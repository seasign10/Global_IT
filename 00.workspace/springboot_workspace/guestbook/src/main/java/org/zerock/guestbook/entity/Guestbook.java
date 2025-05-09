package org.zerock.guestbook.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder // builder pattern 사용
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Guestbook extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gno;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1500, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    // title을 update할 때 사용하는 메서드
    public void changeTitle(String title){
        this.title = title;
    }

    // content를 update할 때 사용하는 메서드
    public void changeContent(String content){
        this.content = content;
    }
}
