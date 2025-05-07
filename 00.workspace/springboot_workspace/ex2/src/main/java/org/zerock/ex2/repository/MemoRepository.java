package org.zerock.ex2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.ex2.entity.Memo;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long>{
    //1. save(), findById(), deleteById(), findAll()함수는 코드작성 없이 사용

    //2. query method
    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);
    Page<Memo> findByMnoBetween(Long from, Long to, Pageable pageable);
    void deleteMemoByMnoLessThan(Long num);

    // 3. JPQL
    // JPQL대신 queryDSL 사용 권장
    @Query("select m from Memo m order by m.mno desc")
    List<Memo> getListDesc();
    // jpql사용시 페이징처리할 때 countQuery를 직접작성필요.
    @Query(value="select m from Memo m where m.mno>:mno",
            countQuery = "select count(m) from Memo m where m.mno>:mno")
    Page<Memo> getListWithQuery(Long mno, Pageable pageable);
    // select절에 필요한 field만 작성하는 경우 object형으로 리턴됨
    @Query(value = "select m.mno, m.memoText, CURRENT_DATE from Memo m where m.mno > :mno",
            countQuery = "select count(m) from Memo m where m.mno > :mno" )
    Page<Object[]> getListWithQueryObject(Long mno, Pageable pageable);

    // 4. Native Query
    // nativeQuery = true 옵션사용. 각 컬럼의 값은 object형으로 리턴됨. 변환해서 모델에 넣는 작업 필요.
    // 복잡한 join이나 subquery는 MyBatis사용
    @Query(value="select * from tbl_memo where mno>0", nativeQuery = true)
    List<Object[]> getNativeResult();
}
