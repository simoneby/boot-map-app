package com.example.ELKdemo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
@RequestMapping("/hello")
    public String index2() {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet request = new HttpGet("http://46.101.166.115:8080/add/user?name=ClauseMann&email=cluseman@mail.ers");
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            System.out.println("http://46.101.166.115:8080/add/user?name=ClauseMann&email=cluseman@mail.ers triggered");
            System.out.println(response.getStatusLine().toString());
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return "Triggered";
    }
}
