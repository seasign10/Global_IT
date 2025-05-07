package org.zerock.ex2.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.zerock.ex2.entity.Memo;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {
    @Autowired
    MemoRepository memoRepository; //주입

    @Test
    public void testInsertDummies(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample..."+i).build();

            memoRepository.save(memo);
        });
    }


    @Test
    public void testSelect(){

        //데이터베이스에 존재하는 mno
        Long mno  = 100L;

        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("==================================");

        if(result.isPresent()){
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    @Test
    public void testUpdate() {

        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();

        System.out.println(memoRepository.save(memo));

    }

    @Test
    public void testDelete() {

        Long mno = 100L;

        memoRepository.deleteById(mno);

    }

    @Test
    public void testPageDefault() {

        //1페이지 10개
        Pageable pageable = PageRequest.of(0,10);

        Page<Memo> result = memoRepository.findAll(pageable);

        System.out.println(result);

        System.out.println("---------------------------------------");

        System.out.println("Total Pages: "+result.getTotalPages());

        System.out.println("Total Count: "+result.getTotalElements());

        System.out.println("Page Number: "+result.getNumber());

        System.out.println("Page Size: "+result.getSize());

        System.out.println("has next page?: "+result.hasNext());

        System.out.println("first page?: "+result.isFirst());

    }

    @Test
    public void testSort() {

        Sort sort1 = Sort.by("mno").descending(); // order by mno desc

        Pageable pageable = PageRequest.of(0, 10, sort1);

        Page<Memo> result = memoRepository.findAll(pageable);

        result.get().forEach(memo -> {
            System.out.println(memo);
        });
    }

    @Test
    public void testQueryMethodWithPagable() {

        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());

        Page<Memo> result = memoRepository.findByMnoBetween(10L,50L, pageable);

        result.get().forEach(memo -> System.out.println(memo));

    }

    @Commit
    @Transactional
    @Test
    public void testDeleteQueryMethods() {
        // 데이터 삭제가 mno<10이 아닌, delete를 하나씩 해서 9번 삭제 작동을 함
        memoRepository.deleteMemoByMnoLessThan(10L);

    }

    //JPQL사용 필요한 field만 가져오기
    @Test
    public void testJPQLwithPageable2(){
        Pageable pageable=PageRequest.of(0,10,Sort.by("mno").descending());
        Page<Object[]> result=memoRepository.getListWithQueryObject(10L,pageable);
        result.get().forEach(object->System.out.println(object));
        result.forEach(object->System.out.println(object[0]+","+object[1]+","+object[2]));
    }


    //Native Query 사용.
    @Test
    public void testNativeQuery(){

        List<Object[]> result=memoRepository.getNativeResult();
        //result.forEach(object->System.out.println(object));
        //result.forEach(object->System.out.println(object[0]+","+object[1]));
        result.forEach(object->{
            Long mno=(Long)object[0];
            String memoText=(String)object[1];
            Memo memo=new Memo(mno,memoText);
            System.out.println(memo);

        });

    }

}
