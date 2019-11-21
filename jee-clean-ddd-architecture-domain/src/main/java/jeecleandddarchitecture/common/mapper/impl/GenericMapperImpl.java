/**
 *
 */
package jeecleandddarchitecture.common.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jeecleandddarchitecture.common.mapper.MapperI;

/**
 * @author scarrasco
 *
 */
public class GenericMapperImpl<E, D> implements MapperI<E, D> {
	
	@Autowired
	protected MapperI<E, D> mapper;
	
	@Override
	public D toDto(final E e) {
		return mapper.toDto(e);
	}
	
	@Override
	public List<D> toDtoList(final List<E> listE) {
		final List<D> listD = new ArrayList<>();
		for (final E e : listE) {
			listD.add(toDto(e));
		}
		return listD;
	}

	@Override
	public E toEntity(final D d) {
		return mapper.toEntity(d);
	}
	
	@Override
	public List<E> toEntityList(final List<D> listD) {
		final List<E> listE = new ArrayList<>();
		for (final D d : listD) {
			listE.add(toEntity(d));
		}
		return listE;
	}
	
}
