/**
 *
 */
package jeecleandddarchitecture.common.control;

/**
 * @author scarrasco
 *
 */
public interface GenericRepositoryI<T> {
	T create(T t);

	void delete(T t);

	T find(T t);

	T update(T t);

	Iterable<T> findAll();
}
