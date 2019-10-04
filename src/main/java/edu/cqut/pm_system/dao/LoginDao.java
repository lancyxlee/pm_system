package edu.cqut.pm_system.dao;

import org.apache.ibatis.annotations.Mapper;

import edu.cqut.pm_system.entity.User;

/**
 * @author llx
 * @date 2019/09/28
 */
@Mapper
public interface LoginDao {
    User login(String username);
}
