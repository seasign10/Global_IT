package org.zerock.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.zerock.guestbook.entity.Guestbook;

// querydsl 사용
public interface GuestbookRepository extends JpaRepository<Guestbook,Long>, QuerydslPredicateExecutor<Guestbook> { // Guestbook의 Id 속성 Long
    //1.save(), findById(), deleteById(), findAll()등 기본 제공 메서드 사용가능
}
