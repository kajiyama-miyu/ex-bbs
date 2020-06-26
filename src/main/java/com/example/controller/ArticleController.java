package com.example.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.domain.Comment;
import com.example.form.ArticleForm;
import com.example.form.CommentForm;
import com.example.service.ArticleService;
import com.example.service.CommentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CommentService commentService;
	
	
	@ModelAttribute
	private ArticleForm setUpArticleForm() {
		return new ArticleForm();
	}
	
	@ModelAttribute
	private CommentForm setUpCommentForm() {
		return new CommentForm();
	}
	
	@RequestMapping("")
	public String index(Model model) {

		List<Article> articleList = articleService.findAll();
		for(Article article : articleList) {
			List<Comment> commentList = commentService.findByArticleId(article.getId());
			article.setCommentList(commentList);
		}
		model.addAttribute("articleList", articleList);
		return "article";
	}
		
	
	@RequestMapping("/insert-article")
	public String insertArticle(ArticleForm articleForm) {
		Article article = new Article();
		article.setName(articleForm.getName());
		article.setContent(articleForm.getContent());
		articleService.insert(article);
		
		
				
		return "redirect:/article";
	}
	
	@RequestMapping("/insert-comment")
	public String insertComment(CommentForm commentForm) {
		Comment comment = new Comment();
		comment.setName(commentForm.getName());
		comment.setContent(commentForm.getContent());
		comment.setArticleId(Integer.parseInt(commentForm.getArticleId()));
		commentService.insert(comment);
		
		
		return "redirect:/article";
		
	}
	
	@RequestMapping("/delete")
	public String deleteArticle(int id) {
		
		commentService.deleteByArticleId(id);
		articleService.deleteById(id);
		return "redirect:/article";
	}
}
