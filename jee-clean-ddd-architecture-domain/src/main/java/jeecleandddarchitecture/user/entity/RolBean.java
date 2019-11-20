/**
 *
 */
package jeecleandddarchitecture.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 *
 * @author scarrasco
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolBean {
	private Long id;
	private String username;
	private String description;
}
