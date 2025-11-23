package com.iro.service;

import com.iro.domain.entity.ArticleEntity;
import com.iro.domain.entity.UserEntity;
import com.iro.domain.repository.ArticleRepository;
import com.iro.model.ArticleCreateFormDto;
import com.iro.model.ArticleDto;
import com.iro.model.UserDto;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleService {

    private final EntityManager entityManager;
    private final ArticleRepository articleRepository;
    private final UserService userService;

    @Autowired
    public ArticleService(EntityManager entityManager,
                          ArticleRepository articleRepository,
                          UserService userService) {
        this.entityManager = entityManager;
        this.articleRepository = articleRepository;
        this.userService = userService;
    }

    @Transactional
    public void addArticle(ArticleCreateFormDto articleCreateFormDto, String username) {
        UserDto userDto = userService.getUserByUsername(username);

        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setTitle(articleCreateFormDto.getTitle());
        articleEntity.setContent(articleCreateFormDto.getContent());
        articleEntity.setAuthor(entityManager.getReference(
            UserEntity.class, userDto.getId()
        ));
        articleRepository.save(articleEntity);
    }

    public List<ArticleDto> getAllArticles() {
        return articleRepository.findAll()
            .stream()
            .map(articleEntity ->
                new ArticleDto(articleEntity.getTitle(), articleEntity.getContent())
            )
            .toList();
    }
}
