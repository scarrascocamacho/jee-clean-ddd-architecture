/**
 *
 */
package jeecleandddarchitecture.authentication.boundary;

import jeecleandddarchitecture.authentication.entity.UserDto;

/**
 * @author scarrasco
 *
 */
public interface UserServiceI {
	UserDto findByUsername(String username);
}
