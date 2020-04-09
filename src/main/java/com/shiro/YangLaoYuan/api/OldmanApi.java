package com.shiro.YangLaoYuan.api;

import com.shiro.YangLaoYuan.Enum.EnumCode;
import com.shiro.YangLaoYuan.api.base.BaseApi;
import com.shiro.YangLaoYuan.entity.Bed;
import com.shiro.YangLaoYuan.entity.Hugong;
import com.shiro.YangLaoYuan.entity.Oldman;
import com.shiro.YangLaoYuan.entity.Oldmanfy;
import com.shiro.YangLaoYuan.mapper.BedMapper;
import com.shiro.YangLaoYuan.mapper.HugongMapper;
import com.shiro.YangLaoYuan.mapper.OldmanFyMapper;
import com.shiro.YangLaoYuan.mapper.OldmanMapper;
import com.shiro.YangLaoYuan.utils.ResultUtil;
import com.shiro.YangLaoYuan.utils.Utilsage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
@RestController
@RequestMapping(value = "OldmanManger")
public class OldmanApi extends BaseApi {

    @Autowired
    private OldmanMapper oldmanMp;

    @Autowired
    private OldmanFyMapper oldmanfyMp;

    @Autowired
    private HugongMapper hgmp;

    @Autowired
    private BedMapper bedmp;

    /**
     * @desc: 查询老人
     *
     * @param
     * @author:
     * @date:
     */
    @RequestMapping(value = "/findOldmans",method = RequestMethod.GET)
    public Object findOldmans() {
       List<Oldman> list = oldmanMp.findOldmans();
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }



    @RequestMapping(value = "/editOldmans",method = RequestMethod.POST)
    public Object editOldmans(Oldman oldman) {
        int list = oldmanMp.editOldmans(oldman);
        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }


    @RequestMapping(value = "/addOldman",method = RequestMethod.POST)
    @Transactional
    public Object addOldman(Oldman oldman,String feiyong) {
        int list = oldmanMp.addOldman(oldman);
//加费用
        int oldmanid=oldman.getId();
        Oldmanfy oldmanfy = new Oldmanfy();
        oldmanfy.setOldmanid(oldmanid);
        oldmanfy.setYingshou(Integer.parseInt(feiyong));
        String tablename = "sys_oldmanfy"+ Utilsage.getdqzq(new Date());
        oldmanfyMp.addOldmanfy(oldmanfy,tablename);

//设置床位非空
        Bed bed = new Bed();
        int bedid = oldman.getBed().getId();
        bed.setId(bedid);
        bed.setIsnull("0");
        bedmp.editBed(bed);
 //更新护工照顾老人个数
        Hugong hg = new Hugong();
        int hgid=oldman.getHg().getId();
        hg.setId(hgid);
        int oldmancount = oldmanMp.getOldmanCountByHugongId(oldman);
        hg.setOldmancount(oldmancount);
        hgmp.editHugong(hg);

        return ResultUtil.result(EnumCode.OK.getValue(), "请求成功", list);
    }

}
