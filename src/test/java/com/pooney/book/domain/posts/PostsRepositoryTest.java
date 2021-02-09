package com.pooney.book.domain.posts;

import com.pooney.book.domain.posts.Posts;
import com.pooney.book.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest// 별다른 설정 없으면 H2 데이터베이스를 자동으로 실행
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    //Junit에서 단위 테스트가 끝날 때 마다 수행됨
    @After
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void getBoard(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        //save : id 값이 있으면 update , 없으면 insert 쿼리 실행
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("pooney@gmail.com")
                .build());
        //when
        //findAll: 모든 데이터를 조회
        List<Posts> postsList = postsRepository.findAll();
        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등륵(){
        //given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
    }
}
