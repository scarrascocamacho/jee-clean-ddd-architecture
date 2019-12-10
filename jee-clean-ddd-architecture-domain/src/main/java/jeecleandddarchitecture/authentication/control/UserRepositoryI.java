/**
 *
 */
package jeecleandddarchitecture.authentication.control;

import jeecleandddarchitecture.authentication.entity.UserDto;
import jeecleandddarchitecture.common.control.GenericRepositoryI;

/**
 * @author scarrasco
 *
 */
public interface UserRepositoryI extends GenericRepositoryI<UserDto> {
	UserDto findByUsername(String username);
}
