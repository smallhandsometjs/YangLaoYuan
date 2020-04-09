package com.shiro.YangLaoYuan.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shiro.YangLaoYuan.entity.Bed;
import com.shiro.YangLaoYuan.pojo.dto.ParamsDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BedMapper extends BaseMapper<Bed> {
    @Select("select MAX(bed) from sys_bed ")
    Integer selectMaxBed();

    @Select("select * from sys_bed where isnull = 1;")
    List<Bed> findnullBeds();

    List<Bed> findBedInfoBybednmb(@Param("dt") ParamsDto dt);

    @Insert("INSERT INTO `shiro`.`sys_bed`(`bed`, `isnull`, `info`) VALUES ( #{bed}, '1', '信息请自行更新');")
    Integer addBed(@Param("bed") int bed);

    //更新
    int editBed(@Param("bd") Bed bd);
}
