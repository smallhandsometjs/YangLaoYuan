package com.shiro.YangLaoYuan.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shiro.YangLaoYuan.entity.Hugong;
import com.shiro.YangLaoYuan.pojo.dto.ParamsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HugongMapper extends BaseMapper<Hugong> {

    List<Hugong> findhugongByname(@Param("dt") ParamsDto dt);

    @Select("select * from sys_hugong order by oldmancount")
    List<Hugong> findhugongs();

     Integer addHugong(@Param("hg") Hugong hg);

    //更新
    int editHugong(@Param("hg") Hugong hg);

}
