package com.shiro.YangLaoYuan.api;

import com.shiro.YangLaoYuan.Enum.EnumCode;
import com.shiro.YangLaoYuan.entity.Oldmanfy;
import com.shiro.YangLaoYuan.mapper.OldmanFyMapper;
import com.shiro.YangLaoYuan.pojo.dto.ParamsDto;
import com.shiro.YangLaoYuan.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "OldmanFy")
public class OldmanfyAPI {
    @Autowired
    private OldmanFyMapper odmfy;

    @RequestMapping(value = "/findOldmanfysbyname",method = RequestMethod.GET)
    public Object findOldmansbyName(ParamsDto pd) {
        List<Oldmanfy> list = odmfy.findOldmanfysByname(pd);
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }
    @RequestMapping(value = "/addOldmanfy",method = RequestMethod.POST)
    public Object addOldmanfy( Oldmanfy oma, String tablename) {
        Integer list = odmfy.addOldmanfy(oma,tablename);
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }

    @RequestMapping(value = "/editOldmanfy",method = RequestMethod.POST)
    public Object editOldmanfy(Oldmanfy oma,String tablename) {
        Integer list = odmfy.editOldmansfy(oma,tablename);
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }
}
