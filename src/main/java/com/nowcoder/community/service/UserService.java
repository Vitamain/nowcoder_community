package com.nowcoder.community.service;

import com.nowcoder.community.entity.LoginTicket;
import com.nowcoder.community.entity.User;

import java.util.Map;

public interface UserService {
    // 根据id查询
    User selectById(int id);

    // 注册用户
    Map<String,Object> register(User user);

    // 激活账户
    int activation(int userId, String code);

    Map<String, Object> login(String username, String password, int expiredSeconds);

    void logout(String ticket);

    LoginTicket findLoginTicket(String ticket);

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
