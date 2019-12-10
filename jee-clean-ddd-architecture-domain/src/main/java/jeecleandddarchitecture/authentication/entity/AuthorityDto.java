/**
 *
 */
package jeecleandddarchitecture.authentication.entity;

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
public class AuthorityDto {
	private Long id;
	private String authority;
}
