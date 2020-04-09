package com.shiro.YangLaoYuan.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shiro.YangLaoYuan.entity.OldmanAccident;
import com.shiro.YangLaoYuan.pojo.dto.ParamsDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OldmanAccidentMapper extends BaseMapper<OldmanAccident> {
    @Select("select a.*,a.startdate as startdate,b.name,b.sex " +
            " from sys_oldmanaccident a " +
            "left join sys_oldman b on a.oldmanid=b.id ")
    List<OldmanAccident> findOldmanaddidents(String name);


    List<OldmanAccident> findOldmanaddidentsByname(@Param("dt") ParamsDto dt);

    @Insert("INSERT INTO `shiro`.`sys_oldmanaccident`( `oldmanid`, `startdate`, `info`, `desc`) VALUES (#{oma.oldmanid}, #{oma.startdate},  #{oma.info}, NULL);")
    Integer addOldmanAccident(@Param("oma") OldmanAccident OMAT);

}
