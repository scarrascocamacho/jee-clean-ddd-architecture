/**
 *
 */
package jeecleandddarchitecture.user.boundary;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jeecleandddarchitecture.user.control.RolRepositoryI;
import jeecleandddarchitecture.user.entity.RolDto;

/**
 * @author scarrasco
 *
 */
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class RolController {

	@Autowired
	private RolRepositoryI rolesRepository;
	
	@GetMapping("/users/roles")
	public List<RolDto> getAllRoles(@PathVariable(required = false) final String username) {
		return rolesRepository.findAll();
	}
	
	@GetMapping("/users/{username}/roles")
	public List<RolDto> getAllRolesByUsername(@PathVariable final String username) {
		return rolesRepository.findByUsername(username);
	}
	
	@GetMapping("/users/{username}/roles/{id}")
	public RolDto getRol(@PathVariable final String username, @PathVariable final long id) {
		return rolesRepository.findById(id);
	}

	@DeleteMapping("/users/{username}/roles/{id}")
	public ResponseEntity<Void> deleteRol(@PathVariable final String username, @PathVariable final long id) {
		
		rolesRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/users/{username}/roles/{id}")
	public ResponseEntity<RolDto> updateRol(@PathVariable final String username, @PathVariable final long id,
	        @RequestBody final RolDto rol) {
		
		rol.setUsername(username);

		final RolDto rolUpdated = rolesRepository.update(rol);
		
		return new ResponseEntity<>(rolUpdated, HttpStatus.OK);
	}
	
	@PostMapping("/users/{username}/roles")
	public ResponseEntity<Void> createCourse(@PathVariable final String username, @RequestBody final RolDto rol) {

		rol.setUsername(username);
		
		final RolDto createdRol = rolesRepository.create(rol);
		
		final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(createdRol.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}