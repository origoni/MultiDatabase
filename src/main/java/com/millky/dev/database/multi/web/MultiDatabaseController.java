package com.millky.dev.database.multi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.millky.dev.database.multi.domain.MultiDatabaseService;
import com.millky.dev.database.multi.domain.article.Article;
import com.millky.dev.database.multi.domain.user.User;

@RestController
public class MultiDatabaseController {

	@Autowired
	MultiDatabaseService multiDatabaseService;

	@RequestMapping(value = { "/addUser" })
	public User addUser(User user) {
		return multiDatabaseService.addUser(user.getName());
	}

	@RequestMapping(value = { "/listUser" })
	public List<User> listUser() {
		return multiDatabaseService.listAllUser();
	}

	
	@RequestMapping(value = { "/addNote" })
	public Article addArticle(Article article) {
		return multiDatabaseService.addArticle(article.getNote());
	}

	@RequestMapping(value = { "/listNote" })
	public List<Article> listArticle() {
		return multiDatabaseService.listAllArticle();
	}
}
