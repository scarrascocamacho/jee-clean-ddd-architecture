/**
 *
 */
package jeecleandddarchitecture.authentication.boundary.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import jeecleandddarchitecture.authentication.boundary.AuthorityServiceI;
import jeecleandddarchitecture.authentication.control.AuthorityRepositoryI;
import jeecleandddarchitecture.authentication.entity.AuthorityDto;

/**
 * @author scarrasco
 *
 */
@Service
@Primary
public class AuthorityServiceImpl implements AuthorityServiceI {
	
	@Autowired
	private AuthorityRepositoryI repository;

	@Override
	public List<AuthorityDto> findByAuthority(final String authority) {
		return repository.findByAuthority(authority);
	}

	@Override
	public AuthorityDto findById(final Long id) {
		return repository.findById(id);
	}

	@Override
	public List<AuthorityDto> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(final Long id) {
		repository.deleteById(id);
	}

	@Override
	public AuthorityDto create(final AuthorityDto dto) {
		return repository.create(dto);
	}

	@Override
	public AuthorityDto update(final AuthorityDto dto) {
		return repository.update(dto);
	}

}
