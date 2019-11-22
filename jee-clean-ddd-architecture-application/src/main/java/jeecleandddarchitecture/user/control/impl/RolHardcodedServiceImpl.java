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

	public RolDto deleteById(final long id) {
		final RolDto rol = findById(id);

		if (rol == null) {
			return null;
		}

		if (roles.remove(rol)) {
			return rol;
		}

		return null;
	}

	public RolDto findById(final long id) {
		for (final RolDto rol : roles) {
			if (rol.getId() == id) {
				return rol;
			}
		}
		return null;
	}

	public RolDto save(final RolDto rol) {
		if (rol.getId() == -1 || rol.getId() == 0) {
			rol.setId(++idCounter);
			roles.add(rol);
		} else {
			deleteById(rol.getId());
			roles.add(rol);
		}
		return rol;
	}
}
