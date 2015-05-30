package com.millky.dev.database.multi.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millky.dev.database.multi.domain.article.Article;
import com.millky.dev.database.multi.domain.user.User;
import com.millky.dev.database.multi.infra.article.ArticleRepo;
import com.millky.dev.database.multi.infra.user.UserRepo;

@Service
public class MultiDatabaseService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ArticleRepo articleRepo;

	public User addUser(String name) {
		User user = new User();
		user.setName(name);

		return userRepo.save(user);
	}

	public List<User> listAllUser() {
		return userRepo.findAll();
	}

	public Article addArticle(String note) {
		Article article = new Article();
		article.setNote(note);

		return articleRepo.save(article);
	}

	public List<Article> listAllArticle() {
		return articleRepo.findAll();
	}
}
