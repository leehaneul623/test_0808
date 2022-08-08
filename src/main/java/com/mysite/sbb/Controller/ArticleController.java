package com.mysite.sbb.Controller;

import com.mysite.sbb.Dao.Article;
import com.mysite.sbb.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping("/list")
    @ResponseBody
    public List<Article> showList(){
        return articleRepository.findAll();
    }
}
