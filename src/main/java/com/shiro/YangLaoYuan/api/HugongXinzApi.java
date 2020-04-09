package com.shiro.YangLaoYuan.api;

import com.shiro.YangLaoYuan.Enum.EnumCode;
import com.shiro.YangLaoYuan.entity.HugongXinz;
import com.shiro.YangLaoYuan.mapper.HugongXinzMapper;
import com.shiro.YangLaoYuan.pojo.dto.ParamsDto;
import com.shiro.YangLaoYuan.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hugongxinzi")
public class HugongXinzApi {
    @Autowired
    private HugongXinzMapper hgxz;
    private HugongXinz hgxinz;

    @RequestMapping(value = "/findhugongxzsbyname",method = RequestMethod.GET)
    public Object findOldmansbyName(ParamsDto pd) {
        List<HugongXinz> list = hgxz.findHugongXinzByname(pd);
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }


    @RequestMapping(value = "/edithugongxinzi",method = RequestMethod.POST)
    public Object editOldmanfy(HugongXinz hgxinz,String tablename) {
        Integer list = hgxz.editHugongXinz(hgxinz,tablename);
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }
}
