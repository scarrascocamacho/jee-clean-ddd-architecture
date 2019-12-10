/**
 *
 */
package jeecleandddarchitecture.authentication.entity;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author scarrasco
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private Long id;
	private String username;
	private String password;
	private boolean enabled;
	private Set<AuthorityDto> authorities;
}
