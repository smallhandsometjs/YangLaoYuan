package com.shiro.YangLaoYuan.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.shiro.YangLaoYuan.entity.AttributeDetail;
import com.shiro.YangLaoYuan.pojo.dto.AttributeDetailDto;
import com.shiro.YangLaoYuan.pojo.dto.ParamsDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author jwy
 * @since 2017-12-26
 */
public interface AttributeDetailMapper extends BaseMapper<AttributeDetail> {

    /**
     * @desc: 查询属性明细
     *
     * @author: jwy
     * @date: 2017/12/26
     */
    List<AttributeDetail> findAttributeDetailByPage(Pagination page,@Param("dto") ParamsDto dto);

    /**
     * @desc: 根据属性id查询属性明细
     * 
     * @author: jwy
     * @date: 2017/12/27
     */
    List<AttributeDetailDto> findAttributeDetailByAttrId(@Param("attrId") String attrId);
}