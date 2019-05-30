package com.giantdwarf.webservice.domain.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.giantdwarf.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@NoArgsConstructor: lombok의 생성자 자동생성( access=AccessLevel.PROTECTED는 기본생성자의 접근권한을 protected로 제)
//@Getter: lombok에서 사용하는 어노테이션으로 해당필드의 getXxx() 자동생성 @Setter의경우는 setXxx()자동생
//@Entity: 엔티티 클래스임을 지정하며 테이블과 매핑, 언더스코어 네이밍(_)으로 이름을 매칭함 SalesManager.java-> sales_manager_tbl

@NoArgsConstructor(access = AccessLevel.PROTECTED)		
@Getter												
@Entity												
public class Posts extends BaseTimeEntity{

	//@Id: 해당 테이블의 PK필드를 나타
	//@GeneratedValue: //원하는 키 생성 전략을 선택.(IDENTITY, SEQUENCE, TABLE, AUTO), 기본값은 AUTO로 mysql의 auto_increment와 같이 자동증가하는 정수값, 스프링부트2.0에선 옵션을 추가해야만 자동으로 증가
   
	@Id					
    @GeneratedValue		
    private Long id;	

	//@Column: 기본값 외에 추가로변경이 필요할떄 사용, 문자열의경우 varchar(255)가 기본인데 사이즈를 늘리고 싶거나 타입을 text로 변경하고 싶은 경우에 사
    @Column(length = 500, nullable = false)			
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

  //해당 클래스의 빌더패턴 클래스를 생성(생성자 상단에 선언하면 생성자에 포함된 필드만 빌더에 포함)
    @Builder			
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
