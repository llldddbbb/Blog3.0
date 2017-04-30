package com.ldb.service.impl;

import com.ldb.dao.BlogDAO;
import com.ldb.dao.BlogTagDAO;
import com.ldb.pojo.po.BlogTagPO;
import com.ldb.pojo.vo.BlogVO;
import com.ldb.service.BlogTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
@Service("blogTagService")
public class BlogTagServiceImpl implements BlogTagService {

    @Autowired
    private BlogTagDAO blogTagDAO;

    @Autowired
    private BlogDAO blogDAO;

    @Override
    public List<BlogTagPO> listBlogTag() {
        return blogTagDAO.listBlogTagPO();
    }

    @Override
    public int updateBlogTag(BlogTagPO blogTagPO) {
        return blogTagDAO.updateBlogTag(blogTagPO);
    }

    @Override
    public int deleteBlogTag(Integer id) {
        HashMap<String,Integer> param=new HashMap<>();
        param.put("blogTagId",id);
        List<BlogVO> blogVOList = blogDAO.listBlog(param);
        if(blogVOList.size()>0){
            return 0;
        }
        return blogTagDAO.deleteBlogTag(id);
    }

    @Override
    public int addBlogTag(BlogTagPO blogTagPO) {
        return blogTagDAO.addBlogTag(blogTagPO);
    }
}
