package com.shiro.YangLaoYuan.service.ipml;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shiro.YangLaoYuan.Enum.EnumCode;
import com.shiro.YangLaoYuan.entity.RolePermission;
import com.shiro.YangLaoYuan.mapper.RolePermissionMapper;
import com.shiro.YangLaoYuan.pojo.dto.ParamsDto;
import com.shiro.YangLaoYuan.pojo.dto.RolePermisDto;
import com.shiro.YangLaoYuan.pojo.dto.RolePermisVo;
import com.shiro.YangLaoYuan.service.RolePermissionService;
import com.shiro.YangLaoYuan.utils.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jwy
 * @since 2017-12-16
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {



    /**
     * 根据角色查询角色权限
     *
     * @param dto
     * @return
     */
    public List<RolePermission> findRolesPermisByRole(ParamsDto dto) {
        return baseMapper.findRolesPermisByRole(dto);
    }
    /**
     * 添加角色权限
     *
     * @param vo
     * @return
     */
    @Transactional
    public Object addRolesPermis(RolePermisVo vo) {
        RolePermission rp = null;
        String roleId = vo.getRoleId();
        String[] permisIds = vo.getPermiIds()==null?new String[0]:vo.getPermiIds();

        Map<String,Object> map = new HashMap<>();
        map.put("rid",roleId);
        super.baseMapper.deleteByMap(map);

        for (int i = 0,j=permisIds.length; i < j; i++) {
            rp = new RolePermission();
            rp.setRid(roleId);
            rp.setPid(permisIds[i]);
            super.baseMapper.insert(rp);
        }
        return ResultUtil.result(EnumCode.OK.getValue(), "保存成功");
    }

    /**
     * 根据角色id查询记录数
     * @param roleId
     * @return
     */
    public Integer findCountByRole(String roleId,String url) {
        return super.baseMapper.findCountByRole(roleId, url);
    }

    /**
     * 根据父id\角色id查询角色菜单
     *
     * @author: jwy
     * @date: 2018/1/20
     */
    public List<RolePermisDto> findRolesPermisByFatherId(String fatherId, String rid) {
        return super.baseMapper.findRolesPermisByFatherId(fatherId, rid);
    }
}
