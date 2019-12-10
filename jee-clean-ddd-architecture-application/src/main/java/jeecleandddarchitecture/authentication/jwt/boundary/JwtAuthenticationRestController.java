/**
 *
 */
package jeecleandddarchitecture.authentication.jwt.boundary;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jeecleandddarchitecture.authentication.jwt.control.JwtTokenUtil;
import jeecleandddarchitecture.authentication.jwt.entity.JwtTokenRequest;
import jeecleandddarchitecture.authentication.jwt.entity.JwtTokenResponse;
import jeecleandddarchitecture.authentication.jwt.exeption.AuthenticationException;

/**
 * Exposes all the URLs related to JWT Authentication.
 * 
 * @author scarrasco
 *
 */
@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
public class JwtAuthenticationRestController {
	
	@Value("${jwt.http.request.header}")
	private String tokenHeader;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody final JwtTokenRequest authenticationRequest)
	        throws AuthenticationException {
		
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		
		final UserDetails userDetails = userDetailsService
		        .loadUserByUsername(authenticationRequest.getUsername());
		
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtTokenResponse(token));
	}
	
	@RequestMapping(value = "${jwt.refresh.token.uri}", method = RequestMethod.GET)
	public ResponseEntity<?> refreshAndGetAuthenticationToken(final HttpServletRequest request) {
		final String authToken = request.getHeader(tokenHeader);
		final String token = authToken.substring(7);
		final String username = jwtTokenUtil.getUsernameFromToken(token);
		userDetailsService.loadUserByUsername(username);
		
		if (jwtTokenUtil.canTokenBeRefreshed(token)) {
			final String refreshedToken = jwtTokenUtil.refreshToken(token);
			return ResponseEntity.ok(new JwtTokenResponse(refreshedToken));
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@ExceptionHandler({ AuthenticationException.class })
	public ResponseEntity<String> handleAuthenticationException(final AuthenticationException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	}
	
	private void authenticate(final String username, final String password) {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (final DisabledException e) {
			throw new AuthenticationException("USER_DISABLED", e);
		} catch (final BadCredentialsException e) {
			throw new AuthenticationException("INVALID_CREDENTIALS", e);
		}
	}
}
