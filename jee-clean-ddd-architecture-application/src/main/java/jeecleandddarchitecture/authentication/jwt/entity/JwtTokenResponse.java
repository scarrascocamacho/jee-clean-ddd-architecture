/**
 *
 */
package jeecleandddarchitecture.authentication.jwt.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represnets to structure of response containing the JWT Token.
 * 
 * @author scarrasco
 *
 */
@Data
@AllArgsConstructor
public class JwtTokenResponse implements Serializable {
	
	private static final long serialVersionUID = 8317676219297719109L;
	
	private final String token;

}
