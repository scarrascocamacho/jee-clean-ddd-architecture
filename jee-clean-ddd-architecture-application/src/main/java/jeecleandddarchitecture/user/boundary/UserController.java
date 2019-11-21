/**
 *
 */
package jeecleandddarchitecture.user.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jeecleandddarchitecture.user.control.RolHardcodedService;
import jeecleandddarchitecture.user.entity.RolDto;

/***
 *
 * @author scarrasco
 *
 */
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class UserController {
	@Autowired
	private RolHardcodedService rolesManagementService;

	@GetMapping("/users/{username}/rolesHardcoded")
	public List<RolDto> getAllRoles(@PathVariable final String username) {
		return rolesManagementService.findAll();
	}
}
