package com.shiro.YangLaoYuan.mapper;

import com.shiro.YangLaoYuan.entity.HugongXinz;
import com.shiro.YangLaoYuan.pojo.dto.ParamsDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HugongXinzMapper {


    List<HugongXinz> findHugongXinzByname(@Param("dt") ParamsDto dt);

    @Insert("INSERT INTO `shiro`.`${tablename}`( `hugongid`, `yingfa`,`yifa`, `isshoudao`,`info`,`ffrq`,`qjcont`) VALUES (#{oma.hugongid}, #{oma.yingfa},0,0,NULL, NULL,0);")
    Integer addHugongXinz(@Param("oma") HugongXinz oma,@Param("tablename") String tablename);

    //更新
    int editHugongXinz(@Param("oma") HugongXinz oma,@Param("tablename") String tablename);

    int editHugongXinzbyhgid(@Param("oma") HugongXinz oma,@Param("tablename") String tablename);

}
