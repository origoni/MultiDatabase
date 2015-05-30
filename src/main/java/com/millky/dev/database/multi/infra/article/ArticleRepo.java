package com.millky.dev.database.multi.infra.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.millky.dev.database.multi.domain.article.Article;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Integer> {

}
