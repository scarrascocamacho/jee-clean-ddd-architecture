/**
 *
 */
package jeecleandddarchitecture.authentication.jwt.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents the structure of request to get a JWT Token.
 * 
 * @author scarrasco
 *
 */
@Data
@AllArgsConstructor
public class JwtTokenRequest implements Serializable {

	private static final long serialVersionUID = -5616176897013108345L;

	private String username;
	private String password;

}
