package jeecleandddarchitecture.authentication.mapper;

import org.mapstruct.Mapper;

import jeecleandddarchitecture.authentication.entity.UserDto;
import jeecleandddarchitecture.authentication.entity.UserE;
import jeecleandddarchitecture.common.mapper.MapperI;

@Mapper(uses = { AuthorityMapperI.class })
public interface UserMapperI extends MapperI<UserE, UserDto> {
}
