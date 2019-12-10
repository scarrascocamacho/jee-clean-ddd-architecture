/**
 *
 */
package jeecleandddarchitecture.authentication.jwt.boundary.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jeecleandddarchitecture.authentication.boundary.UserServiceI;
import jeecleandddarchitecture.authentication.entity.UserDto;
import jeecleandddarchitecture.authentication.jwt.entity.JwtUserDetails;

/**
 * @author scarrasco
 *
 */
@Service
@Primary
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserServiceI service;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		
		final UserDto userDto = service.findByUsername(username);

		if (userDto == null) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return new JwtUserDetails(userDto.getId(), userDto.getUsername(), userDto.getPassword(),
		        userDto.getAuthorities());
	}
	
}
