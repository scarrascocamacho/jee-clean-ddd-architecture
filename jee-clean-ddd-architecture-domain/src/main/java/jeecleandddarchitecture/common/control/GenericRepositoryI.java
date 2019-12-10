/**
 *
 */
package jeecleandddarchitecture.common.control;

/**
 * @author scarrasco
 *
 */
public interface GenericRepositoryI<T> {
	T create(T dto);
	
	void delete(T dto);
	
	T find(T dto);
	
	T update(T dto);
	
	Iterable<T> findAll();
}
