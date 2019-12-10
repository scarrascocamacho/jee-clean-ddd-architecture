/**
 *
 */
package jeecleandddarchitecture.authentication.control;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jeecleandddarchitecture.authentication.entity.UserE;

/**
 * @author scarrasco
 *
 */
@Repository
public abstract interface UserJpaRepositoryI extends JpaRepository<UserE, Long> {
	UserE findByUsername(String username);
}
