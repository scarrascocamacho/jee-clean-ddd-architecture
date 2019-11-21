/**
 *
 */
package jeecleandddarchitecture.user.control;

import java.util.List;

import jeecleandddarchitecture.common.control.GenericRepositoryI;
import jeecleandddarchitecture.user.entity.RolDto;

/**
 * @author scarrasco
 *
 */
public interface RolRepositoryI extends GenericRepositoryI<RolDto> {
	List<RolDto> findByUsername(String username);

	RolDto findById(Long id);
	
	@Override
	List<RolDto> findAll();
	
	void deleteById(Long id);
}
