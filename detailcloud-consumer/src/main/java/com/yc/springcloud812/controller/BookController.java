package com.yc.springcloud812.controller;


import com.yc.springcloud812.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.List;


@RestController
@RequestMapping("/consumer")
public class BookController {
    private final static String URL="http://localhost:8888/book/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders headers;

    @GetMapping("{id}")
    public Book getBook(@PathVariable("id" ) Integer id ){
        //return restTemplate.getForObject(URL+id,Book.class);
        //restTemplate.
        return restTemplate.exchange(URL+id, HttpMethod.GET,new HttpEntity<Object>(headers),Book.class).getBody();
    }

    @GetMapping("findAll")
    public List<Book> getAllBook(){
        //return restTemplate.getForObject(URL+"findAll",List.class);

        return restTemplate.exchange(URL+"findAll",HttpMethod.GET,new HttpEntity<Object>(headers),List.class).getBody();
    }
}

