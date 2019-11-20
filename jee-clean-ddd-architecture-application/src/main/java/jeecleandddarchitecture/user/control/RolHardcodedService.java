/**
 *
 */
package jeecleandddarchitecture.user.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jeecleandddarchitecture.user.entity.RolBean;

/***
 *
 * @author scarrasco
 *
 */
@Service
public class RolHardcodedService {
	private static List<RolBean> roles = new ArrayList<>();
	private static long idCounter = 0;

	static {
		roles.add(new RolBean(++idCounter, "user", "Administrador"));
		roles.add(new RolBean(++idCounter, "user", "Editor"));
		roles.add(new RolBean(++idCounter, "user", "Consultor"));
	}

	public List<RolBean> findAll() {
		return roles;
	}
}
