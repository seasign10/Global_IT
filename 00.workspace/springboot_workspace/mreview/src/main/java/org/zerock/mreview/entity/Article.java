package org.zerock.mreview.entity;


import lombok.Getter;
import jakarta.persistence.*;

@Entity
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Lob
    private String content;

    @ManyToOne
    private User user;
    
}
