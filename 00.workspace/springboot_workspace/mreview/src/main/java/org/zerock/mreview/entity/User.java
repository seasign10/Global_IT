package org.zerock.mreview.entity;

import java.util.Set;

import org.hibernate.annotations.BatchSize;

import jakarta.persistence.*;

import lombok.Getter;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String name;

    //BatchSize는 100~1000이 적당
    //user가 10000명이고 BatchSize가 100이면, 10000/100 = 100번의 쿼리가 날아간다. (이 때문에 ManyToOne을 사용하는 것을 권장)
    @BatchSize(size=100) // BatchSize는 N+1문제를 해결하기 위한 방법으로, 한번에 가져올 row의 개수를 지정한다.
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    // @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    // @OneToMany(mappedBy = "user")
    private Set<Article> articles;
    
}
