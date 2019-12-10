/**
 *
 */
package jeecleandddarchitecture.authentication.control;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jeecleandddarchitecture.authentication.entity.AuthorityE;

/**
 * @author scarrasco
 *
 */
@Repository
public abstract interface AuthorityJpaRepositoryI extends JpaRepository<AuthorityE, Long> {
	List<AuthorityE> findByAuthority(String authority);
}
