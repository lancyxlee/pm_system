package edu.cqut.pm_system.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

import edu.cqut.pm_system.entity.User;

/**
 * @author llx
 * @date 2019/10/04
 */
@Mapper
public interface UserDao {
    User getUserFromId(String uid);
    void updatePassword(@Param("uid")String uid, @Param("password")String newPwd);
    Map<String, Object> getUserInfo(String uid);
}
