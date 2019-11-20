/**
 *
 */
package jeecleandddarchitecture.user.control;

import java.util.List;

import jeecleandddarchitecture.user.entity.RolBean;

/**
 * @author scarrasco
 *
 */
public interface RolRepositoryI {
	List<RolBean> findByUsername(String username);

	List<RolBean> findAll();

	RolBean findById(Long id);

	RolBean save(RolBean rol);
	
	void deleteById(Long id);
}
