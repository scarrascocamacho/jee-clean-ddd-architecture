/**
 *
 */
package jeecleandddarchitecture.authentication.control.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jeecleandddarchitecture.authentication.control.AuthorityJpaRepositoryI;
import jeecleandddarchitecture.authentication.control.AuthorityRepositoryI;
import jeecleandddarchitecture.authentication.entity.AuthorityDto;
import jeecleandddarchitecture.authentication.entity.AuthorityE;
import jeecleandddarchitecture.common.mapper.impl.MapperImpl;
import jeecleandddarchitecture.config.RepositoryMapper;

/**
 * @author scarrasco
 *
 */
@RepositoryMapper
public class AuthorityRepositoryImpl extends MapperImpl<AuthorityE, AuthorityDto> implements AuthorityRepositoryI {

	@Autowired
	private AuthorityJpaRepositoryI repository;

	@Override
	public AuthorityDto create(final AuthorityDto dto) {
		return save(dto);
	}

	@Override
	public void delete(final AuthorityDto dto) {
		repository.delete(toEntity(dto));
	}

	@Override
	public AuthorityDto find(final AuthorityDto dto) {
		return findById(dto.getId());
	}

	@Override
	public AuthorityDto update(final AuthorityDto dto) {
		return save(dto);
	}

	@Override
	public AuthorityDto findById(final Long id) {
		return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Rol not found with id " + id)));
	}

	@Override
	public List<AuthorityDto> findAll() {
		return toDtoList(repository.findAll());
	}

	@Override
	public void deleteById(final Long id) {
		repository.deleteById(id);
	}

	private AuthorityDto save(final AuthorityDto dto) {
		return toDto(repository.save(toEntity(dto)));
	}

	@Override
	public List<AuthorityDto> findByAuthority(final String authority) {
		return toDtoList(repository.findByAuthority(authority));
	}

}
