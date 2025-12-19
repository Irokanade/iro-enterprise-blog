package com.iro.controller;

import com.iro.model.ArticleCreateFormDto;
import com.iro.model.ArticleDto;
import com.iro.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Locale;

@Controller
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "/article/create", method = RequestMethod.GET)
    public String createArticlePage() {
        return "article-create";
    }

    @RequestMapping(value = "/article/create", method = RequestMethod.POST)
    public String createArticleForm(@ModelAttribute ArticleCreateFormDto articleCreateFormDto,
                                Authentication authentication) {
        articleService.addArticle(articleCreateFormDto, authentication.getName());
        logger.info("User {} created article", authentication.getName());
        return "redirect:/home";
    }
}
