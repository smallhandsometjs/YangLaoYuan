package com.shiro.YangLaoYuan.service.ipml;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shiro.YangLaoYuan.Enum.EnumCode;
import com.shiro.YangLaoYuan.entity.AttributeDetail;
import com.shiro.YangLaoYuan.mapper.AttributeDetailMapper;
import com.shiro.YangLaoYuan.pojo.dto.AttributeDetailDto;
import com.shiro.YangLaoYuan.pojo.dto.ParamsDto;
import com.shiro.YangLaoYuan.pojo.vo.AttributeDetailVo;
import com.shiro.YangLaoYuan.service.AttributeDetailService;
import com.shiro.YangLaoYuan.utils.ResultUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jwy
 * @since 2017-12-26
 */
@Service
public class AttributeDetailServiceImpl extends ServiceImpl<AttributeDetailMapper, AttributeDetail> implements AttributeDetailService {

    /**
     * @desc: 查询属性明细
     *
     * @author: jwy
     * @date: 2017/12/26
     */
    public List<AttributeDetail> findAttributeDetailByPage(Page<AttributeDetail> page, ParamsDto dto) {
        return super.baseMapper.findAttributeDetailByPage(page,dto);
    }

    /**
     * @desc: 新增属性明细
     *
     * @author: jwy
     * @date: 2017/12/27
     */
    public Object addAttributeDetail(AttributeDetailVo vo) {
        AttributeDetail attributeDetail = new AttributeDetail();
        attributeDetail.setAttrId(vo.getId());
        attributeDetail.setName(vo.getName());
        Integer rows = super.baseMapper.insert(attributeDetail);
      if (rows > 0) {
          return ResultUtil.result(EnumCode.OK.getValue(), "新增成功");
      }
        return ResultUtil.result(EnumCode.INTERNAL_SERVER_ERROR.getValue(), "新增失败");
    }

    /**
     * @desc: 根据属性id查询属性明细
     *
     * @author: jwy
     * @date: 2017/12/27
     */
    public List<AttributeDetailDto> findAttributeDetailByAttrId(String attrId) {
        return super.baseMapper.findAttributeDetailByAttrId(attrId);
    }

    /**
     * @desc: 删除属性明细
     *
     * @author: jwy
     * @date: 2017/12/27
     */
    public Object delAttributeDetails(String[] ids) {

        for (String id : ids) {
            super.baseMapper.deleteById(id);
        }

        return ResultUtil.result(EnumCode.OK.getValue(), "删除成功");
    }
}
