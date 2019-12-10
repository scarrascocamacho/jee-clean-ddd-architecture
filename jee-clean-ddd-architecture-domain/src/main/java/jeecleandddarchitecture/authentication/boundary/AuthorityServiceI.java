/**
 *
 */
package jeecleandddarchitecture.authentication.boundary;

import java.util.List;

import jeecleandddarchitecture.authentication.entity.AuthorityDto;

/**
 * @author scarrasco
 *
 */
public interface AuthorityServiceI {
	List<AuthorityDto> findByAuthority(String authority);

	AuthorityDto findById(Long id);

	List<AuthorityDto> findAll();

	void deleteById(Long id);

	AuthorityDto create(AuthorityDto dto);

	AuthorityDto update(AuthorityDto dto);
}
