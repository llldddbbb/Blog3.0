package com.ldb.service;

import com.ldb.pojo.vo.BlogDateArchiveVO;

import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
public interface BlogService {

    List<BlogDateArchiveVO> listBlogDateArchive();
}