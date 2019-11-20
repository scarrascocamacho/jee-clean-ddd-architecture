/**
 *
 */
package jeecleandddarchitecture.user.control;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jeecleandddarchitecture.user.entity.RolE;

/**
 * @author scarrasco
 *
 */
@Repository
abstract interface RolJpaRepository extends JpaRepository<RolE, Long> {
	List<RolE> findByUsername(String username);
}
