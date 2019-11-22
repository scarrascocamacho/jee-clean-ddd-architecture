/**
 *
 */
package jeecleandddarchitecture.authentication.jwt.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jeecleandddarchitecture.authentication.jwt.entity.JwtUserDetails;

/**
 * Provides an in memory implementation of UserDetailsService storing the user credentials.
 * 
 * @author scarrasco
 *
 */
@Service
public class JwtInMemoryUserDetailsServiceImpl implements UserDetailsService {
	
	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
	
	static {
		inMemoryUserList.add(new JwtUserDetails(1L, "user",
		        "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
	}
	
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
		        .filter(user -> user.getUsername().equals(username)).findFirst();
		
		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}
		
		return findFirst.get();
	}
	
}
