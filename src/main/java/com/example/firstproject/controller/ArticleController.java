package com.example.firstproject.controller;

import com.example.firstproject.dto.AriticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결!
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(Model model){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(AriticleForm ariticleForm){
        System.out.println(ariticleForm.toString());

        //1. DTO를 변환! Entity
        Article article = ariticleForm.toEntity();
        System.out.println(article.toString());

        //2. Repository에게 Entity를 DB안에 저장하게 함!
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());

        return "";
    }
}
