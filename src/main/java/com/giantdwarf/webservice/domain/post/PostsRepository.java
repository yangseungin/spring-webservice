package com.giantdwarf.webservice.domain.post;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostsRepository extends JpaRepository<Posts, Long> {
	//보통 Mybatis에서 Dao라고 불리는 DB Layer 접근자//
	//JPA에서는 Repository라고 부르며 인터페이스로 생성함.
	//단순히 인터페이스 생성 후 JPaRepository<Entity클래스, PK타입>을 상속하면 기본적인 CRUD 메소드가 자동생성 됨.
	//@Repository를 추가할 필요도 없음.
	@Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}
