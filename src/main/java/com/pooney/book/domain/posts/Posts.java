package com.pooney.book.domain.posts;


import com.pooney.book.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.StringTokenizer;

@Getter
@NoArgsConstructor
//@AllArgsConstructor
@Entity//테이블과 맅크될 클래시임을 나태난다 ex) TestDb -> test_db
public class Posts extends BaseTimeEntity{


    //spring boot 2.0 이상부터 IDENTITY 옵션을 추가해야만 auto_increment 된다.
    @Id // Pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column은 굳이 선언하지 않아도 모두 컬럼이된다.  기본값이 외 추가없이 필요한 경우 사용
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false) //varcher -> test로 변경하고자 할때 사용
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title,String content){
        this.title = title;
        this.content = content;
    }


}
