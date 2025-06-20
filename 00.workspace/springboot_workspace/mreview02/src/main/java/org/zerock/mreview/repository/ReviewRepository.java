package org.zerock.mreview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.zerock.mreview.entity.Member;
import org.zerock.mreview.entity.Movie;
import org.zerock.mreview.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
  // @EntityGraph: JPA에서 제공하는 기능으로, 연관된 엔티티를 함께 조회할 수 있도록 해줌
  // 리뷰 목록
  @EntityGraph(attributePaths = {"member"}, type = EntityGraph.EntityGraphType.FETCH)
  List<Review> findByMovie(Movie movie);

  // 리뷰 삭제
  @Modifying
  @Query("DELETE FROM Review mr WHERE mr.movie = :movie")
  void deleteByMember(Member member);
}
