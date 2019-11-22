/**
 *
 */
package jeecleandddarchitecture.authentication.jwt.exeption;

/**
 * Use to throw invalid credentials or token exception
 * 
 * @author scarrasco
 *
 */
public class AuthenticationException extends RuntimeException {

	private static final long serialVersionUID = 8219008984078814822L;
	
	public AuthenticationException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
