package org.zerock.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Builder // builder pattern 사용
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tbl_member")
public class Member extends BaseEntity  {
    @Id
    private String email;

    private String password;
    private String name;
}