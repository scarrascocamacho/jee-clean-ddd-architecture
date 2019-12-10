/**
 *
 */
package jeecleandddarchitecture.authentication.boundary.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jeecleandddarchitecture.authentication.boundary.AuthorityServiceI;
import jeecleandddarchitecture.authentication.entity.AuthorityDto;

/***
 *
 * @author scarrasco
 *
 */
@Service
public class AuthorityHardcodedServiceImpl implements AuthorityServiceI {
	private static List<AuthorityDto> roles = new ArrayList<>();
	private static long idCounter = 0;

	static {
		roles.add(new AuthorityDto(++idCounter, "Administrador"));
		roles.add(new AuthorityDto(++idCounter, "Editor"));
		roles.add(new AuthorityDto(++idCounter, "Consultor"));
	}

	@Override
	public List<AuthorityDto> findAll() {
		return roles;
	}

	public AuthorityDto deleteById(final long id) {
		final AuthorityDto rol = findById(id);

		if (rol == null) {
			return null;
		}

		if (roles.remove(rol)) {
			return rol;
		}

		return null;
	}

	public AuthorityDto findById(final long id) {
		for (final AuthorityDto rol : roles) {
			if (rol.getId() == id) {
				return rol;
			}
		}
		return null;
	}

	public AuthorityDto save(final AuthorityDto rol) {
		if (rol.getId() == -1 || rol.getId() == 0) {
			rol.setId(++idCounter);
			roles.add(rol);
		} else {
			deleteById(rol.getId());
			roles.add(rol);
		}
		return rol;
	}
	
	@Override
	public List<AuthorityDto> findByAuthority(final String authority) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public AuthorityDto findById(final Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void deleteById(final Long id) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public AuthorityDto create(final AuthorityDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public AuthorityDto update(final AuthorityDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
