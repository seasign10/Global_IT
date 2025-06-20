package org.zerock.mreview.repository;

import java.util.List;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mreview.entity.User;



@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    UserRepository userRepository;

    @Transactional
    @Test
    @DisplayName("Eager type은 User를 단일 조회할 때 join문이 날아간다.")
    void userSingleFindTest() {
        System.out.println("== start ==");
        // User user = userRepository.findById(1L)
        //     .orElseThrow(RuntimeException::new);
        // System.out.println(user.getName());
        
        // Eager 인 경우. User 전체를 조회할 때 N + 1 문제가 발생
       userRepository.findAll();
    }

    @Transactional
    @Test
    @DisplayName("Lazy type은 User 검색 후 필드 검색을 할 때 N+1문제가 발생한다.")
    void userFindTest() {
        System.out.println("== start ==");
        List<User> users = userRepository.findAll();
        System.out.println("== find all ==");
        for (User user : users) {
            System.out.println(user.getArticles().size());
        }
    }

    @Transactional
    @Test
    @DisplayName("일반 jpql 쿼리문은 N+1문제가 발생한다.")
    void normalJpqlTest() {
        System.out.println("== start ==");
        List<User> users = userRepository.findAllJPQL();
        System.out.println("== end ==");
        for (User user : users) {
            System.out.println(user.getArticles().size());
        }
    }



    @Transactional
    @Test
    @DisplayName("fetch join을 하면 N+1문제가 발생하지 않는다.")
    void fetchJoinTest() {
        System.out.println("== start ==");
        List<User> users = userRepository.findAllJPQLFetch();
        System.out.println("== find all ==");
        for (User user : users) {
            System.out.println(user.getArticles().size());
        }
    }
  
    @Transactional
    @Test
    @DisplayName("@EntityGraph를 사용하면 N+1문제가 발생하지 않는다.")
    void EntityGraphTest() {
        System.out.println("== start ==");
        List<User> users = userRepository.findAllEntityGraph();
        System.out.println("== find all ==");
        for (User user : users) {
            System.out.println(user.getArticles().size());
        }
    }




    @Transactional
    @Test
    @DisplayName("fetch join을 paging처리에서 사용해도 N+1문제가 발생한다.")
    // fetch join을 paging에서 사용하면, in memory 페이징 처리로 변환됨. 전체데이터를 모두 가져와서 메모리에서 잘라내기 때문에 성능 저하가 발생할 수 있다.
    void pagingFetchJoinTest() {
        System.out.println("== start ==");
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<User> users = userRepository.findAllPage(pageRequest);
        System.out.println("== find all ==");
        for (User user : users) {
            System.out.println(user.getArticles().size());
        }
    }
    
}
