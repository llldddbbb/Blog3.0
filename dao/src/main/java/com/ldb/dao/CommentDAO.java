package com.ldb.dao;

import com.ldb.pojo.po.CommentPO;
import com.ldb.pojo.vo.CommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
public interface CommentDAO {

    int getCommentCount(@Param("blogId") Integer blogId);

    List<CommentVO> listNewCommentVO();

    List<CommentPO> listCommentPO(@Param("blogId")Integer blogId);

    int addComment(CommentPO commentPO);
}
