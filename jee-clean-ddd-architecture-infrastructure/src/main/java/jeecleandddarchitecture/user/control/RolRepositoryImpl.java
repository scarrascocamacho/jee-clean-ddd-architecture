/**
 *
 */
package jeecleandddarchitecture.user.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jeecleandddarchitecture.user.entity.RolBean;
import jeecleandddarchitecture.user.entity.RolE;
import jeecleandddarchitecture.user.mapper.RolMapper;

/**
 * @author scarrasco
 *
 */
@Repository
public class RolRepositoryImpl implements RolRepositoryI {

	@Autowired
	private RolJpaRepository repository;
	
	@Autowired
	private RolMapper mapper;
	
	@Override
	public List<RolBean> findByUsername(final String username) {
		return mapList(repository.findByUsername(username));
	}

	@Override
	public List<RolBean> findAll() {
		return mapList(repository.findAll());
	}

	private List<RolBean> mapList(final List<RolE> listE) {
		final List<RolBean> listRb = new ArrayList<>();
		for (final RolE entity : listE) {
			listRb.add(mapper.rolToRolBean(entity));
		}
		return listRb;
	}

	@Override
	public RolBean findById(final Long id) {
		return mapEntity(
		        repository.findById(id).orElseThrow(() -> new RuntimeException("Rol not found with id " + id)));
	}

	@Override
	public RolBean save(final RolBean rol) {
		return mapEntity(repository.save(mapper.rolBeanToRol(rol)));
	}

	private RolBean mapEntity(final RolE entity) {
		return mapper.rolToRolBean(entity);
	}

	@Override
	public void deleteById(final Long id) {
		repository.deleteById(id);
	}
	
}
