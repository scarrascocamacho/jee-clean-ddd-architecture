/**
 *
 */
package jeecleandddarchitecture.authentication.jwt.boundary.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jeecleandddarchitecture.authentication.entity.AuthorityDto;
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
	static Set<AuthorityDto> authoritySet = new HashSet<>();
	
	static {
		authoritySet.add(new AuthorityDto(Long.valueOf(2), "ROLE_USER_2"));
		inMemoryUserList.add(new JwtUserDetails(1L, "user",
		        "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", authoritySet));
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
