/**
 *
 */
package jeecleandddarchitecture.user.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jeecleandddarchitecture.common.control.GenericMapperImpl;
import jeecleandddarchitecture.user.entity.RolDto;
import jeecleandddarchitecture.user.entity.RolE;

/**
 * @author scarrasco
 *
 */
@Repository
public class RolRepositoryImpl extends GenericMapperImpl<RolE, RolDto> implements RolRepositoryI {

	@Autowired
	private RolJpaRepositoryI repository;

	@Override
	public List<RolDto> findByUsername(final String username) {
		return toDtoList(repository.findByUsername(username));
	}

	@Override
	public List<RolDto> findAll() {
		return toDtoList(repository.findAll());
	}

	@Override
	public RolDto findById(final Long id) {
		return toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Rol not found with id " + id)));
	}

	@Override
	public void deleteById(final Long id) {
		repository.deleteById(id);
	}

	@Override
	public RolDto create(final RolDto rol) {
		return save(rol);
	}

	@Override
	public void delete(final RolDto rol) {
		repository.delete(toEntity(rol));
	}

	@Override
	public RolDto find(final RolDto rol) {
		return findById(rol.getId());
	}

	@Override
	public RolDto update(final RolDto rol) {
		return save(rol);
	}

	private RolDto save(final RolDto rol) {
		return toDto(repository.save(toEntity(rol)));
	}
<<<<<<< HEAD
	
=======

>>>>>>> branch 'develop' of https://github.com/scarrascocamacho/jee-clean-ddd-architecture
}
