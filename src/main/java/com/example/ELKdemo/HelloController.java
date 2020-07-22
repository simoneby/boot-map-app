package com.example.ELKdemo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

@RestController
public class HelloController {
    
@RequestMapping("/hello")
    public String index2() {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet request = new HttpGet("http://46.101.166.115:8080/add/user?name=ClauseMann&email=cluseman@mail.ers");
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            System.out.println("http://46.101.166.115:8080/add/user?name=ClauseMann&email=cluseman@mail.ers triggered");
            System.out.println(response.getStatusLine().toString());
            return "Claus was triggered and hopefully added to database";
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return "Failed to add to database";
    }
}
