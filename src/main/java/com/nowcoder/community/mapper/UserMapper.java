package com.nowcoder.community.mapper;

import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    // 根据id查询
    User selectById(int id);
    // 根据用户名查询
    User selectByName(String username);
    // 根据邮箱查询
    User selectByEmail(String email);
    // 新增用户
    int insertUser(User user);
    // 修改用户状态
    int updateStatus(int id, int status);
    // 修改用户头像
    int updateHeader(int id, String headerUrl);
    // 修改用户密码
    int updatePassword(int id, String password);
}
