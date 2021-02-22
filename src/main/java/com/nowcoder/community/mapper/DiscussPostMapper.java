package com.nowcoder.community.mapper;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface DiscussPostMapper {
    // 查询帖子相关信息
    // userId == 0 表示不按用户id查询 -> 主页帖子
    // offset limit 分页参数
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // 查询帖子总数量
    int selectDiscussPostsRows(@Param("userId") int userId);
}
