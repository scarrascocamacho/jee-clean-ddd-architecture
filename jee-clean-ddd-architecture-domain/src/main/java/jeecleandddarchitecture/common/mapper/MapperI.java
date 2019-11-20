package jeecleandddarchitecture.common.mapper;

import java.util.List;

public interface MapperI<E, D> {
	D toDto(E e);
	
	List<D> toDtoList(List<E> listE);
	
	E toEntity(D d);
	
	List<E> toEntityList(List<D> listD);
}
