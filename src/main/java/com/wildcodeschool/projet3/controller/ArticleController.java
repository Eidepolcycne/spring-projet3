package com.wildcodeschool.projet3.controller;

import com.wildcodeschool.projet3.entity.Article;
import com.wildcodeschool.projet3.entity.User;
import com.wildcodeschool.projet3.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/articles")
    public List<Article> getAll(){return(List<Article>) articleRepository.findAll();}

    @GetMapping("/articles/{id}")
    public Article getArticle(@PathVariable Long id){return articleRepository.findById(id).get();}

    @PostMapping("/articles")
    public Article createArticle(@RequestBody Article article) {return articleRepository.save(article);}

    @PutMapping("/articles/{id}")
    public Article updateUser(@PathVariable Long id, @RequestBody Article article){
       Article articleToUpdate = articleRepository.findById(id).get();
        articleToUpdate.setTitle(articleToUpdate.getTitle());
        articleToUpdate.setImage(articleToUpdate.getImage());
        articleToUpdate.setContent(articleToUpdate.getContent());
        return articleRepository.save(articleToUpdate);
    }

    @DeleteMapping("/articles/{id}")
    public Boolean deleteArticle(@PathVariable Long id){
        articleRepository.deleteById(id);
        return true;
    }

}
