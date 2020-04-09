package com.shiro.YangLaoYuan.mapper;



import com.shiro.YangLaoYuan.entity.Oldmanfy;
import com.shiro.YangLaoYuan.pojo.dto.ParamsDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface OldmanFyMapper {

    List<Oldmanfy> findOldmanfysByname(@Param("dt") ParamsDto dt);

    @Insert("INSERT INTO `shiro`.`${tablename}`( `oldmanid`, `yingshou`,`yishou`, `isshoudao`,`info`,`jfrq`) VALUES (#{oma.oldmanid}, #{oma.yingshou},0,0,'备注', NULL);")
    Integer addOldmanfy(@Param("oma") Oldmanfy oma,@Param("tablename") String tablename);

    //更新老人费用
    int editOldmansfy(@Param("oma") Oldmanfy oma,@Param("tablename") String tablename);
}
