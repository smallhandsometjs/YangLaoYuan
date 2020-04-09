package com.shiro.YangLaoYuan.api;

import com.shiro.YangLaoYuan.Enum.EnumCode;
import com.shiro.YangLaoYuan.entity.HugongLeave;
import com.shiro.YangLaoYuan.entity.HugongXinz;
import com.shiro.YangLaoYuan.mapper.HugongLeaveMapper;
import com.shiro.YangLaoYuan.mapper.HugongXinzMapper;
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
@RequestMapping("hugongLeave")
public class HugongLeaveApi {
    @Autowired
    private HugongLeaveMapper hgleave;

    @Autowired
    private HugongXinzMapper hgxz;

    @RequestMapping(value = "/findhgleavebyname",method = RequestMethod.GET)
    public Object findHugongbyName(ParamsDto pd) {
        List<HugongLeave> list = hgleave.findHugongLeaveByname(pd);
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }

    @RequestMapping(value = "/addhgleave",method = RequestMethod.POST)
    public Object addHugongleave(HugongLeave hgle) {
        try{
            //新增请假
            Integer list = hgleave.addHugongLeave(hgle);
           //获取当前账期
            String tablename = "sys_hugongxz"+ Utilsage.getdqzq(new Date());
            int hugongid=hgle.getHugongid();
            //获取当前账期的请假次数
            Integer qjcont=hgleave.getDyQjContByHugongId(hgle);

            HugongXinz hugongxz = new HugongXinz();
            hugongxz.setHugongid(hugongid);
            hugongxz.setQjcont(qjcont);
            //修改请假次数
            hgxz.editHugongXinzbyhgid(hugongxz,tablename);
            return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
        }
//此时return语句能够执行
        return ResultUtil.result(EnumCode.BAD_REQUEST.getValue(), "请求出错");

    }

    @RequestMapping(value = "/deletehgleave",method = RequestMethod.POST)
    public Object deleteHugong(ParamsDto pd) {

        try{
            //删除请假
            Integer list = hgleave.deleteById(Integer.parseInt(pd.getId()));
            //获取当前账期
            String tablename = "sys_hugongxz"+ Utilsage.getdqzq(new Date());
            int hugongid=Integer.parseInt(pd.getKeyword());
            //获取当前账期的请假次数
            HugongLeave hgl = new HugongLeave();
            hgl.setHugongid(hugongid);
            Integer qjcont=hgleave.getDyQjContByHugongId(hgl);

            HugongXinz hugongxz = new HugongXinz();
            hugongxz.setHugongid(hugongid);
            hugongxz.setQjcont(qjcont);
            //修改请假次数
            hgxz.editHugongXinzbyhgid(hugongxz,tablename);
            return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
        }
//此时return语句能够执行
        return ResultUtil.result(EnumCode.BAD_REQUEST.getValue(), "请求出错");

    }
}
