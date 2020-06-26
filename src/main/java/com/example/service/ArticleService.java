package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Article;
import com.example.repository.AriticleRepository;

@Service
@Transactional
public class ArticleService {
	
	@Autowired
	private AriticleRepository ariticleRepository;
	
	public List<Article> findAll(){
		return ariticleRepository.findAll();
	}
	
	public void insert(Article article) {
		ariticleRepository.insert(article);
	}

	public void deleteById(int id) {
		ariticleRepository.deleteById(id);
	}
}
