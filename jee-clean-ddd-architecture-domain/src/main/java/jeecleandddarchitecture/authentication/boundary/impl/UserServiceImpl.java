/**
 *
 */
package jeecleandddarchitecture.authentication.boundary.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jeecleandddarchitecture.authentication.boundary.UserServiceI;
import jeecleandddarchitecture.authentication.control.UserRepositoryI;
import jeecleandddarchitecture.authentication.entity.UserDto;

/**
 * @author scarrasco
 *
 */
@Service
public class UserServiceImpl implements UserServiceI {
	
	@Autowired
	private UserRepositoryI repository;
	
	@Override
	public UserDto findByUsername(final String username) {
		return repository.findByUsername(username);
	}
	
}
