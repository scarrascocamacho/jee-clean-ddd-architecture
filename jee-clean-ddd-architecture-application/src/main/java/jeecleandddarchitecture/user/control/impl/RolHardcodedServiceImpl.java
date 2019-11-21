/**
 *
 */
package jeecleandddarchitecture.user.control.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jeecleandddarchitecture.user.entity.RolDto;

/***
 *
 * @author scarrasco
 *
 */
@Service
public class RolHardcodedServiceImpl {
	private static List<RolDto> roles = new ArrayList<>();
	private static long idCounter = 0;

	static {
		roles.add(new RolDto(++idCounter, "user", "Administrador"));
		roles.add(new RolDto(++idCounter, "user", "Editor"));
		roles.add(new RolDto(++idCounter, "user", "Consultor"));
	}

	public List<RolDto> findAll() {
		return roles;
	}
}
