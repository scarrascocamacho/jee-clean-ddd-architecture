/**
 *
 */
package jeecleandddarchitecture.user.mapper;

import org.mapstruct.Mapper;

import jeecleandddarchitecture.user.entity.RolBean;
import jeecleandddarchitecture.user.entity.RolE;

/**
 * @author scarrasco
 *
 */
@Mapper(componentModel = "spring")
public interface RolMapper {
	
	RolBean rolToRolBean(RolE rE);
	
	RolE rolBeanToRol(RolBean rB);
}
