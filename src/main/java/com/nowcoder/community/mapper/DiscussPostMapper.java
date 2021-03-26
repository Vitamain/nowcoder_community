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

    // 插入一条帖子
    int insertDiscussPosts(DiscussPost discussPost);

    // 根据 id 查询帖子
    DiscussPost selectDiscussPostById(int id);

    // 修改帖子的评论数量
    int updateCommentCount(int id, int commentCount);
}
