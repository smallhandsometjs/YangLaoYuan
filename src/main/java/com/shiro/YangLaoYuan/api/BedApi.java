package com.shiro.YangLaoYuan.api;

import com.shiro.YangLaoYuan.Enum.EnumCode;
import com.shiro.YangLaoYuan.entity.Bed;
import com.shiro.YangLaoYuan.entity.Hugong;
import com.shiro.YangLaoYuan.entity.HugongXinz;
import com.shiro.YangLaoYuan.mapper.BedMapper;
import com.shiro.YangLaoYuan.pojo.dto.ParamsDto;
import com.shiro.YangLaoYuan.utils.ResultUtil;
import com.shiro.YangLaoYuan.utils.Utilsage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("BedApi")
public class BedApi {

    @Autowired
    BedMapper bedmp;
    @RequestMapping(value = "/findBedInfoBybednmb",method = RequestMethod.GET)
    public Object findBedInfoBybednmb(ParamsDto pd) {
        List<Bed> list = bedmp.findBedInfoBybednmb(pd);
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }

    @RequestMapping(value = "/addBed",method = RequestMethod.POST)
    public Object addBed(int count) {

        try{
            int newbed=bedmp.selectMaxBed()+1;
            for(int i = 0;i<count;i++){
                bedmp.addBed(newbed++);
            }
            return ResultUtil.result(EnumCode.OK.getValue(), "请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
        }//此时return语句能够执行
        return ResultUtil.result(EnumCode.BAD_REQUEST.getValue(), "请求出错");

    }

    @RequestMapping(value = "/editBed",method = RequestMethod.POST)
    public Object editBed(Bed bed) {
        Integer list = bedmp.editBed(bed);
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }

    @RequestMapping(value = "/deleteBed",method = RequestMethod.POST)
    public Object deleteBed(ParamsDto pd) {
        Integer list = bedmp.deleteById(Integer.parseInt(pd.getId()));
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }
}
