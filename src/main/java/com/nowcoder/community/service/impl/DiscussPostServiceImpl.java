package com.nowcoder.community.service.impl;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.mapper.DiscussPostMapper;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.utils.SensitiveFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * @program: community
 * @description: 帖子业务层实体类
 * @author: Mr.Vitamain
 * @create: 2021-02-21 16:14
 **/
@Service
public class DiscussPostServiceImpl implements DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;
    
    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Override
    public List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    @Override
    public int selectDiscussPostsRows(int userId) {
        return discussPostMapper.selectDiscussPostsRows(userId);
    }

    @Override
    public int addDiscussPost(DiscussPost post) {
        if(post == null) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        // 当帖子标题和内容存在HTML标签时，浏览器不应该将其解析为标签，而是文本
        // 转义HTML标记 通过HtmlUtils
        post.setTitle(HtmlUtils.htmlEscape(post.getTitle()));
        post.setContent(HtmlUtils.htmlEscape(post.getContent()));

        // 过滤敏感词
        post.setTitle(sensitiveFilter.filter(post.getTitle()));
        post.setContent(sensitiveFilter.filter(post.getContent()));
        
        // 调用mapper方法
        return discussPostMapper.insertDiscussPosts(post);
    }

    @Override
    public DiscussPost selectDiscussPostById(int id) {
        return discussPostMapper.selectDiscussPostById(id);
    }

    public int updateCommentCount(int id, int commentCount) {
        return discussPostMapper.updateCommentCount(id, commentCount);
    }

    // 帖子中一般需要显示作者的名字和头像信息，帖子和用户的关联字段是user_id
    // 有两种解决办法 1.使用关联查询  2.使用user_id单独查询用户信息
}
