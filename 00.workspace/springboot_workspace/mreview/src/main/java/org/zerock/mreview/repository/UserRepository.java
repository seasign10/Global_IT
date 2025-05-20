package org.zerock.mreview.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.mreview.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select distinct u from User u left join u.articles")
    List<User> findAllJPQL();

    @Query("select distinct u from User u left join fetch u.articles")
    List<User> findAllJPQLFetch();

    @EntityGraph(attributePaths = {"articles"}, type = EntityGraphType.FETCH)
    @Query("select distinct u from User u left join u.articles")
    List<User> findAllEntityGraph();

    // @EntityGraph(attributePaths = {"articles"}, type = EntityGraphType.FETCH)
    // @Query("select distinct u from User u left join u.articles")
    // Page<User> findAllPage(Pageable pageable);

    // @BatichSize사용시 fetch join 적용하지 않고 처리
    @Query("select distinct u from User u left join u.articles")
    Page<User> findAllPage(Pageable pageable);

}
