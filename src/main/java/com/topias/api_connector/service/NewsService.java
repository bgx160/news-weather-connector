package com.topias.api_connector.service;

import com.topias.api_connector.model.NewsData;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Map;

@Service
public class NewsService {

    Dotenv dotenv = Dotenv.load();

    private final RestTemplate restTemplate;

    private final String apiUrl = "https://newsapi.org/v2/everything";

    private final String apiKey = dotenv.get("NEWS_API_KEY");

    public NewsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ArrayList<NewsData> getNewsData(String keyword, int pageSize) {
        String url = apiUrl + "?q=" + keyword + "&apiKey=" + apiKey + "&pageSize=" + pageSize;

        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            ArrayList<Object> articles = (ArrayList<Object>) response.get("articles");
            return mapNewsData(articles);
        } catch (Exception e) {
            System.out.println("Error fetching news data: " + e.getMessage());
            return null;
        }
    }

     public ArrayList<NewsData> mapNewsData(ArrayList<Object> data) {
        ArrayList<NewsData> newsData = new ArrayList<NewsData>();

        if (data.isEmpty()) {
            return newsData;
        }

        for(Object item : data) {
            Map<String, Object> mapItem = (Map<String, Object>) item;
            String title = (String) mapItem.get("title");
            String url = (String) mapItem.get("url");
            String author = (String) mapItem.get("author");

            newsData.add(new NewsData(title, author, url));
        }
        return newsData;

    }

}
