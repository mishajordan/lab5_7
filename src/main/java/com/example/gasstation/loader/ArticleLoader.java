package com.example.gasstation.loader;

import com.example.gasstation.model.Article;
import com.example.gasstation.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class ArticleLoader implements ApplicationRunner {

    private final ArticleRepository articleRepository;

    private void loadArticles() {
        Article article1 = new Article();
        article1.setTitle("Мы открылись!");
        article1.setBody("Приглашаем вас на торжественное открытие бензоколонки");
        article1.setArticleDate(LocalDateTime.of(2022, 12, 1, 12, 34, 10));

        Article article2 = new Article();
        article2.setTitle("Новые акции");
        article2.setBody("При покупке 30 литров бензина канистра масла в подарок!");
        article2.setArticleDate(LocalDateTime.of(2022, 12, 4, 15, 34, 10));

        Article article3 = new Article();
        article3.setTitle("Акция завершена");
        article3.setBody("Спасибо за участие");
        article3.setArticleDate(LocalDateTime.of(2022, 12, 7, 9, 23, 10));

        articleRepository.save(article1);
        articleRepository.save(article2);
        articleRepository.save(article3);
    }

    public void run(ApplicationArguments args) {
        loadArticles();
    }
}
