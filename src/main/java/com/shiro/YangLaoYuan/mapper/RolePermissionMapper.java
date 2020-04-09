package com.shiro.YangLaoYuan.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shiro.YangLaoYuan.entity.RolePermission;
import com.shiro.YangLaoYuan.pojo.dto.ParamsDto;
import com.shiro.YangLaoYuan.pojo.dto.RolePermisDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author jwy
 * @since 2017-12-16
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    /**
     * 根据角色查询角色权限
     *
     * @param dto
     * @return
     */
    List<RolePermission> findRolesPermisByRole(@Param("dto") ParamsDto dto);

    /**
     * 根据角色id查询记录数
     * @param roleId
     * @return
     */
    Integer findCountByRole(@Param("roleId") String roleId,@Param("url") String url);

    /**
     * 根据父id\角色id查询角色菜单
     *
     * @author: jwy
     * @date: 2018/1/20
     */
    List<RolePermisDto> findRolesPermisByFatherId(@Param("fatherId") String fatherId, @Param("rid") String rid);
}