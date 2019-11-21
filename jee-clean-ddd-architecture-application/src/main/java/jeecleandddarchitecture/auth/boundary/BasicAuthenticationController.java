/**
 *
 */
package jeecleandddarchitecture.auth.boundary;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jeecleandddarchitecture.auth.entity.AuthenticationDto;

/**
 *
 * @author scarrasco
 *
 */
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class BasicAuthenticationController {
	
	@GetMapping(path = "/basicauth")
	public AuthenticationDto basicAuthentication() {
		// throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
		return new AuthenticationDto("You are authenticated");
	}
}
