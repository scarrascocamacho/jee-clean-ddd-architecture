/**
 *
 */
package jeecleandddarchitecture.user.mapper;

import org.mapstruct.Mapper;

import jeecleandddarchitecture.common.mapper.MapperI;
import jeecleandddarchitecture.user.entity.RolDto;
import jeecleandddarchitecture.user.entity.RolE;

/**
 * @author scarrasco
 *
 */
@Mapper(componentModel = "spring")
public interface RolMapperI extends MapperI<RolE, RolDto> {
}
