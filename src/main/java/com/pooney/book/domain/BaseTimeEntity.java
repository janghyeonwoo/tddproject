package com.pooney.book.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass//JPA Entity 클래스들가 해당 클래스를 상속 받는 경우 해당 해당 칼럼들도 컬럼으로써 인식하도록 설정
@EntityListeners(AuditingEntityListener.class) //해당클래스에 Auditing 기능을 포함 시키는 기능
public class BaseTimeEntity {
    //JPA Auditing 어노테이들을 모두 활성화 할 수있으도록 메인 Application.class에 활성화 어노테이션 추가 해야함.
    @CreatedDate// Entity가 생성되어 저장될때 시간이 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity의  값을 변경할때 시간이 자동 저장
    private LocalDateTime modifiedDate;
}
