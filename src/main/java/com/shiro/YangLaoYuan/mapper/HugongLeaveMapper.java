package com.shiro.YangLaoYuan.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shiro.YangLaoYuan.entity.HugongLeave;
import com.shiro.YangLaoYuan.pojo.dto.ParamsDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HugongLeaveMapper extends BaseMapper<HugongLeave> {
    /*查询当月请假次数*/
    @Select("SELECT \n" +
            "count(1) \n" +
            "FROM \n" +
            "sys_hugongleave \n" +
            "WHERE \n" +
            "hugongid=#{hgl.hugongid}\n" +
            "and\n" +
            "date_format(startdate, '%Y %m') = date_format(DATE_SUB(curdate(), INTERVAL 0 MONTH),'%Y %m')\n" +
            "\n")
    Integer getDyQjContByHugongId(@Param("hgl") HugongLeave HGL);

    List<HugongLeave> findHugongLeaveByname(@Param("dt") ParamsDto dt);

    @Insert("INSERT INTO `shiro`.`sys_hugongleave`( `hugongid`, `startdate`,`enddate`, `info`, `desc`,`days`) VALUES (#{oma.hugongid}, #{oma.startdate}, #{oma.enddate}, #{oma.info},Null,#{oma.days});")
    Integer addHugongLeave(@Param("oma") HugongLeave HGL);

}
