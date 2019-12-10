/**
 *
 */
package jeecleandddarchitecture.authentication.control.impl;

import org.springframework.beans.factory.annotation.Autowired;

import jeecleandddarchitecture.authentication.control.UserJpaRepositoryI;
import jeecleandddarchitecture.authentication.control.UserRepositoryI;
import jeecleandddarchitecture.authentication.entity.UserDto;
import jeecleandddarchitecture.authentication.entity.UserE;
import jeecleandddarchitecture.common.mapper.impl.MapperImpl;
import jeecleandddarchitecture.config.RepositoryMapper;

/**
 * @author scarrasco
 *
 */
@RepositoryMapper
public class UserRepositoryImpl extends MapperImpl<UserE, UserDto> implements UserRepositoryI {
	
	@Autowired
	private UserJpaRepositoryI repository;
	
	@Override
	public UserDto create(final UserDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void delete(final UserDto dto) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public UserDto find(final UserDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public UserDto update(final UserDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Iterable<UserDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto findByUsername(final String username) {
		return toDto(repository.findByUsername(username));
	}

}
