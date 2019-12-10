/**
 *
 */
package jeecleandddarchitecture.authentication.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jeecleandddarchitecture.authentication.boundary.impl.AuthorityHardcodedServiceImpl;
import jeecleandddarchitecture.authentication.entity.AuthorityDto;

/***
 *
 * @author scarrasco
 *
 */
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class AuthorityHardcodedController {
	@Autowired
	private AuthorityHardcodedServiceImpl rolesManagementService;
	
	@GetMapping("/users/{username}/rolesHardcoded")
	public List<AuthorityDto> getAllRoles(@PathVariable final String username) {
		return rolesManagementService.findAll();
	}
}
