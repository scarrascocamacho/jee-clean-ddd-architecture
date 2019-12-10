/**
 *
 */
package jeecleandddarchitecture.authentication.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Simple bean which will be used to send a response for the basic authentication request.
 * 
 * @author scarrasco
 *
 */
@Data
@AllArgsConstructor
public class AuthenticationDto {
	private String message;
}
