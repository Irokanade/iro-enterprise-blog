package com.iro.controller;

import com.iro.model.ArticleDto;
import com.iro.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final ArticleService articleService;


    @Autowired
    public HomeController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);

        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String userHomePage(Locale locale, Model model, Authentication authentication) {
        logger.info("Welcome home! The client locale is {}.", locale);

        List<ArticleDto> articles = articleService.getAllArticles();

        model.addAttribute("currentUser", authentication.getName());
        model.addAttribute("articles", articles);
        return "home";
    }
}
