package com.mysite.sbb.Repository;

import com.mysite.sbb.Dao.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
