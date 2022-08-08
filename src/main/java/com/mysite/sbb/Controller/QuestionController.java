package com.mysite.sbb.Controller;

import com.mysite.sbb.Dao.Question;
import com.mysite.sbb.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private final QuestionRepository questionRepository;

    @RequestMapping("/list")
    public List<Question> showQuestion(){
        return questionRepository.findAll();
    }
}
