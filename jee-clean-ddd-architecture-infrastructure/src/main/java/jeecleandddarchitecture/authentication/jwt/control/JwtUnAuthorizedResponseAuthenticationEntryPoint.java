/**
 *
 */
package jeecleandddarchitecture.authentication.jwt.control;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Used when a valid token is not provided with a REST API call
 * 
 * @author scarrasco
 *
 */
@Component
public class JwtUnAuthorizedResponseAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = -8970718410437077606L;

	@Override
	public void commence(final HttpServletRequest request, final HttpServletResponse response,
	        final AuthenticationException authException) throws IOException {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
		        "You would need to provide the Jwt Token to Access This resource");
	}
}
