package com.example.gasstation.controller;

import com.example.gasstation.dto.ArticleForm;
import com.example.gasstation.model.Article;
import com.example.gasstation.repository.ArticleRepository;
import com.example.gasstation.service.ArticleService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    public NewsController(ArticleRepository articleRepository, ArticleService articleService) {
        this.articleRepository = articleRepository;
        this.articleService = articleService;
    }

    @GetMapping
    public String getNews(Model model) {
        List<Article> news = articleRepository.findAll(Sort.by(Sort.Direction.DESC, "articleDate"));
        news.forEach(articleService::format);

        model.addAttribute("news", news);
        return "news/index";
    }

    @GetMapping("/{id}")
    public String getNewById(@PathVariable Long id, Model model) {
        Article article = articleRepository.findById(id).orElse(new Article());
        article = articleService.format(article);

        model.addAttribute("article", article);
        return "news/article";
    }

    @GetMapping("/add")
    public String addArticleForm(Model model) {
        model.addAttribute("articleForm", new ArticleForm());
        return "news/add";
    }

    @PostMapping("/add")
    public String addArticle(@ModelAttribute("articleForm") ArticleForm articleForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "news/add";
        }

        if (articleService.add(articleForm)) {
            return "redirect:/news";
        }

        return "news/add";
    }

    @GetMapping("/edit/{id}")
    public String editArticleForm(@PathVariable Long id, Model model) {
        Article article = articleRepository.findById(id).get();
        model.addAttribute("articleForm", new ArticleForm());
        model.addAttribute("article", article);
        return "news/edit";
    }

    @PostMapping("/edit/{id}")
    public String editArticleForm(@PathVariable Long id, @ModelAttribute("articleForm") ArticleForm articleForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "news/edit";
        }

        if (articleService.edit(id, articleForm)) {
            return "redirect:/news";
        }

        return "news/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
        return "redirect:/news";
    }
}
