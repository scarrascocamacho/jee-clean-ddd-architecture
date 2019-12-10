package jeecleandddarchitecture.authentication.mapper;

import org.mapstruct.Mapper;

import jeecleandddarchitecture.authentication.entity.AuthorityDto;
import jeecleandddarchitecture.authentication.entity.AuthorityE;
import jeecleandddarchitecture.common.mapper.MapperI;

@Mapper
public interface AuthorityMapperI extends MapperI<AuthorityE, AuthorityDto> {
}
