package com.example.gasstation.service;

import com.example.gasstation.dto.ArticleForm;
import com.example.gasstation.model.Article;
import com.example.gasstation.repository.ArticleRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public boolean add(ArticleForm articleForm) {
        Article article = new Article();

        article.setTitle(articleForm.getTitle());
        article.setBody(articleForm.getBody());

        if (!articleForm.getPhoto().isEmpty() && articleForm.getPhoto() != null) {
            try {
                byte[] bytes = articleForm.getPhoto().getBytes();
                article.setPhoto(bytes);
            } catch (Exception e) {
                return false;
            }
        } else {
            article.setPhoto(null);
        }

        article.setArticleDate(LocalDateTime.now());
        articleRepository.save(article);

        return true;
    }

    public boolean edit(Long id, ArticleForm articleForm) {
        Article article = articleRepository.findById(id).get();

        article.setTitle(articleForm.getTitle());
        article.setBody(articleForm.getBody());

        if (!articleForm.getPhoto().isEmpty() && articleForm.getPhoto() != null) {
            try {
                byte[] bytes = articleForm.getPhoto().getBytes();
                article.setPhoto(bytes);
            } catch (Exception e) {
                return false;
            }
        }

        articleRepository.save(article);

        return true;
    }

    public Article format(Article article) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        article.setFormattedDate(dtf.format(article.getArticleDate()));

        if (article.getPhoto() != null) {
            byte[] encodeBase64 = Base64.encodeBase64(article.getPhoto());
            String base64Encoded = new String(encodeBase64, StandardCharsets.UTF_8);
            article.setBase64image(base64Encoded);
        }

        return article;
    }
}
