package com.haixiang.pipeline.mapper;

import com.haixiang.pipeline.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {
    //然后做一些数据库的对应操作，这次是查询操作
    List<User> getUserList();
}
