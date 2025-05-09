package org.zerock.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.zerock.board.entity.Board;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select b, w from Board b left join b.writer w where b.bno =:bno")
        // native query로 작성
        // select b.*, m.* from board b left join tbl_member m on b.writer_email=m.email where b.bno=10
    Object getBoardWithWriter(@Param("bno") Long bno);

    @Query("SELECT b, r FROM Board b LEFT JOIN Reply r ON r.board = b WHERE b.bno = :bno")
        // native query로 작성
        // select b.*, r.* from board b left join reply r on r.board_bno=b.bno where b.bno=10
    List<Object[]> getBoardWithReply(@Param("bno") Long bno);

    @Query(value ="SELECT b, w, count(r) " +
            " FROM Board b " +
            " LEFT JOIN b.writer w " +
            " LEFT JOIN Reply r ON r.board = b " +
            " GROUP BY b",
            countQuery ="SELECT count(b) FROM Board b")
        //native query로 작성
        // select b.*, r.*, count(*)
        // from board b
        // left join tbl_member m on b.writer_email=m.email
        // left join reply r on b.bno=r.board_bno
        // group by b.bno;
        //
        // select count(*) from board
    Page<Object[]> getBoardWithReplyCount(Pageable pageable);


    @Query("SELECT b, w, count(r) " +
            " FROM Board b LEFT JOIN b.writer w " +
            " LEFT OUTER JOIN Reply r ON r.board = b" +
            " WHERE b.bno = :bno")
        // native query로 작성
        // select b.*, r.*, count(*)
        // from board b
        // left join tbl_member m on b.writer_email=m.email
        // left join reply r on b.bno=r.board_bno
        // where b.bno=10
    Object getBoardByBno(@Param("bno") Long bno);

}
