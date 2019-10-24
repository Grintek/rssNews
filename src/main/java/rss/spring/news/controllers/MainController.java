package rss.spring.news.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rss.spring.news.repos.RssRepository;
import rss.spring.news.service.InputRss;

@Controller
public class MainController {

    @Autowired
    private RssRepository rssRepository;


    @GetMapping("/")
    public String getFeed(Model model){
        model.addAttribute("rss", rssRepository.findAll());
        return "home";
    }

}
