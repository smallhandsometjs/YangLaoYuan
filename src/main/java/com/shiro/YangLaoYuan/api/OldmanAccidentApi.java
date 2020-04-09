package com.shiro.YangLaoYuan.api;

import com.shiro.YangLaoYuan.Enum.EnumCode;

import com.shiro.YangLaoYuan.entity.OldmanAccident;
import com.shiro.YangLaoYuan.mapper.OldmanAccidentMapper;
import com.shiro.YangLaoYuan.pojo.dto.ParamsDto;
import com.shiro.YangLaoYuan.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "Accident")
public class OldmanAccidentApi {
    @Autowired
    private OldmanAccidentMapper oam;

    @RequestMapping(value = "/findOldmanAccidents",method = RequestMethod.GET)
    public Object findOldmans(String name) {
           List<OldmanAccident> list = oam.findOldmanaddidents(name);
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);    }

    @RequestMapping(value = "/findOldmanAccidentsbyname",method = RequestMethod.GET)
    public Object findOldmansbyName(ParamsDto pd) {
        List<OldmanAccident> list = oam.findOldmanaddidentsByname(pd);
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }

    @RequestMapping(value = "/deleteOldmanAccidentsbyid",method = RequestMethod.POST)
    public Object deleteOldmanAccidentsbyid(ParamsDto pd) {
        Integer list = oam.deleteById(Integer.parseInt(pd.getId()));
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }

    @RequestMapping(value = "/addOldmanAccident",method = RequestMethod.POST)
    public Object addOldmanAccident(OldmanAccident oma) {
        Integer list = oam.addOldmanAccident(oma);
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }
}
