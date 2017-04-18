package com.ldb.service.impl;

import com.ldb.dao.CommentDAO;
import com.ldb.dao.CommentReplyDAO;
import com.ldb.pojo.po.CommentPO;
import com.ldb.pojo.vo.CommentReplyVO;
import com.ldb.pojo.vo.CommentVO;
import com.ldb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ldb on 2017/4/17.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private CommentReplyDAO commentReplyDAO;

    @Override
    public List<CommentVO> listNewComment() {
        return commentDAO.listNewCommentVO();
    }

    @Override
    public List<CommentPO> listComment(Integer blogId) {
        List<CommentPO> commentPOList = commentDAO.listCommentPO(blogId);
        for(CommentPO commentPO:commentPOList){
            List<CommentReplyVO> commentReplyVOList = commentReplyDAO.listCommentReply(commentPO.getId());
            commentPO.setCommentReplyVOList(commentReplyVOList);
        }
        return commentPOList;
    }

    @Override
    public int addComment(CommentPO commentPO) {
        return commentDAO.addComment(commentPO);
    }
}
