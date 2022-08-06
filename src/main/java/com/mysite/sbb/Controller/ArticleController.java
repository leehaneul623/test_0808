package com.mysite.sbb.Controller;

import com.mysite.sbb.Dao.Article;
import com.mysite.sbb.Repository.ArticleRepository;
import com.mysite.sbb.Repository.UserRepository;
import com.mysite.sbb.Ut.Ut;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;

    // C ======================================



    // R ======================================
    @RequestMapping("/list")
    @ResponseBody
    public List<Article> showList(){
        return articleRepository.findAll();
    }

    @RequestMapping("/detail")
    @ResponseBody
    public Article showDetail(Long id){
        Article article = articleRepository.findById(id).get();
        return article;
    }

    // U ======================================
    @RequestMapping("/doModify")
    @ResponseBody
   public String doModify(Long id, String title, String body){
        if(id == null){
            return "게시물이 없습니다.";
        }
        if(Ut.empty(title)){
            return "제목을 입력해주세요.";
        }
        if(Ut.empty(body)){
            return "내용을 입력해주세요.";
        }
        if(!articleRepository.existsById(id)){
            return "게시물이 없습니다.";
        }

        Article article = articleRepository.findById(id).get();
        article.setUpdateDate(LocalDateTime.now());
        article.setTitle(title);
        article.setBody(body);

        articleRepository.save(article);

        return "%번 게시물 수정이 완료되었습니다.".formatted(article.getId());
    }
    // D ======================================
    @RequestMapping("/doDelete")
    @ResponseBody
    public String doDelete(Long id){
        if(!articleRepository.existsById(id)){
            return "%번 게시물이 없습니다.".formatted(id);
        }

        Article article = articleRepository.findById(id).get();
        articleRepository.delete(article);

        return "%d번 게시물을 삭제 했습니다.".formatted(id);
    }
}
