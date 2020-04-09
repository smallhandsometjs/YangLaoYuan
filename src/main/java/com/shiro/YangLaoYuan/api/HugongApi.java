package com.shiro.YangLaoYuan.api;

import com.shiro.YangLaoYuan.Enum.EnumCode;
import com.shiro.YangLaoYuan.entity.Hugong;
import com.shiro.YangLaoYuan.entity.HugongXinz;
import com.shiro.YangLaoYuan.mapper.HugongMapper;
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
@RequestMapping("hugong")
public class HugongApi {
    @Autowired
    private HugongMapper hgp;

    @Autowired
    private HugongXinzMapper hgxz;

    @RequestMapping(value = "/findhginfobyname",method = RequestMethod.GET)
    public Object findHugongbyName(ParamsDto pd) {
        List<Hugong> list = hgp.findhugongByname(pd);
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }

    @RequestMapping(value = "/addhg",method = RequestMethod.POST)
    public Object addHugong(Hugong hg,String xinzi) {

        try{
            Integer list = hgp.addHugong(hg);
            String tablename = "sys_hugongxz"+Utilsage.getdqzq(new Date());
            int hugongid=hg.getId();
            HugongXinz hugongxz = new HugongXinz();
            hugongxz.setHugongid(hugongid);
            hugongxz.setYingfa(Integer.parseInt(xinzi));
            hgxz.addHugongXinz(hugongxz,tablename);
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

    @RequestMapping(value = "/edithg",method = RequestMethod.POST)
    public Object editHugong( Hugong hg) {
        Integer list = hgp.editHugong(hg);
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }

    @RequestMapping(value = "/deletehg",method = RequestMethod.POST)
    public Object deleteHugong(ParamsDto pd) {
        Integer list = hgp.deleteById(Integer.parseInt(pd.getId()));
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }
}
