/**
 *
 */
package jeecleandddarchitecture.authentication.control;

import java.util.List;

import jeecleandddarchitecture.authentication.entity.AuthorityDto;
import jeecleandddarchitecture.common.control.GenericRepositoryI;

/**
 * @author scarrasco
 *
 */
public interface AuthorityRepositoryI extends GenericRepositoryI<AuthorityDto> {
	List<AuthorityDto> findByAuthority(String authority);
	
	AuthorityDto findById(Long id);
	
	@Override
	List<AuthorityDto> findAll();
	
	void deleteById(Long id);
	
}
