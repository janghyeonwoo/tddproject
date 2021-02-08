package com.pooney.book;

import com.pooney.book.domain.posts.Posts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContoller {

    @GetMapping("test")
    public String getTest(){
        return "test 호출";
    }

}
