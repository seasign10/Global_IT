package org.zerock.board.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    private String title;
    private String content;

    // ManyToOne이 걸려있으면 엔티티 클래스내에 참조가 없어도 left join처리가 가능해서 on이 필요 없음
    @ManyToOne (fetch = FetchType.LAZY) // (fetch = FetchType.LAZY) : 지연로딩(board/member를 필요한 것만 따로 출력)
    //@ManyToOne // type이 string이 아닌 member(모든컬럼.복수컬럼)이기 때문에 join이 됨 (join 'email') // 즉시로딩(모든 테이블이 join되어 한 번에 전부출력)
    private Member writer;

    public void changeTitle(String title){
        this.title = title;
    }

    public void changeContent(String content){
        this.content = content;
    }
}
