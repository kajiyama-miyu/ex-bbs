package com.example.domain;

public class Comment {


	private Integer id;
	private String name;
	private String comment;
	private Integer articleId;
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", name=" + name + ", comment=" + comment + ", articleId=" + articleId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
	
	
}
