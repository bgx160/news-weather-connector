package com.topias.api_connector.controller;

import com.topias.api_connector.model.NewsData;
import com.topias.api_connector.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public ArrayList<NewsData> news(@RequestParam String keyword) {
        return newsService.getNewsData(keyword, 15);
    }

}
