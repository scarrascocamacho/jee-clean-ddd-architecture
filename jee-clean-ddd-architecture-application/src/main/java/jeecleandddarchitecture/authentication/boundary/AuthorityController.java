/**
 *
 */
package jeecleandddarchitecture.authentication.boundary;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jeecleandddarchitecture.authentication.entity.AuthorityDto;

/**
 * @author scarrasco
 *
 */
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class AuthorityController {

	@Autowired
	private AuthorityServiceI service;

	@GetMapping("/users/roles")
	public ResponseEntity<List<AuthorityDto>> getAllRoles() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"))) {

			return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
	}

	@GetMapping("/users/{username}/roles")
	public List<AuthorityDto> getAllRolesByUsername(@PathVariable final String username) {
		return null;
	}

	@GetMapping("/users/roles/{id}")
	public AuthorityDto getRol(@PathVariable final long id) {
		return service.findById(id);
	}

	@DeleteMapping("/users/roles/{id}")
	public ResponseEntity<Void> deleteRol(@PathVariable final long id) {

		service.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("/users/roles/{id}")
	public ResponseEntity<AuthorityDto> updateRol(@PathVariable final long id, @RequestBody final AuthorityDto rol) {

		final AuthorityDto rolUpdated = service.update(rol);

		return new ResponseEntity<>(rolUpdated, HttpStatus.OK);
	}

	@PostMapping("/users/roles")
	public ResponseEntity<Void> createRol(@RequestBody final AuthorityDto rol) {

		final AuthorityDto createdRol = service.create(rol);

		final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(createdRol.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
}
