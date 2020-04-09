package com.shiro.YangLaoYuan.mapper;


import com.shiro.YangLaoYuan.entity.Oldman;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface OldmanMapper {
    /**
     * @desc: 查询老人
     *
     *
     * @author: tjs
     * @date: 2020-03-28
     */

    List<Oldman> findOldmans();

    //查护工照顾的老人个数
    @Select("select count(1) from sys_oldman where hg=#{oldman.hg.id};")
    Integer getOldmanCountByHugongId(@Param("oldman") Oldman oldman);

//更新老人
    Integer editOldmans(Oldman oldman);

    @Insert("INSERT INTO `shiro`.`sys_oldman`( `name`, `sex`, `st`, `hj`, `sfz`, `jjlxr`, `phone`, `adress`, `bed`, `hg`, `rz`, `cy`, `desc`) " +
            "VALUES ( #{oldman.name}, #{oldman.sex}, #{oldman.st},  #{oldman.hj},  #{oldman.sfz},  #{oldman.jjlxr}, #{oldman.phone}, " +
            " #{oldman.adress},  #{oldman.bed.id},  #{oldman.hg.id},  #{oldman.rz},  #{oldman.cy},  #{oldman.desc});\n")
    Integer addOldman(@Param("oldman") Oldman oldman);

}
