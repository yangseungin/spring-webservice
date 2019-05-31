package com.giantdwarf.webservice.dto.posts;

import com.giantdwarf.webservice.domain.post.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



// Controller에서 @RequestBody로 외부에서 데이터를 받는 경우엔 기본생성자 + set메소드를 통해서만 값이 할당되어 setter 사용 
// 절대로 테이블과 매핑되는 Entity 클래스를 Request/ Response 클래스로 사용해서는 안됨.
// 실제로 컨트롤러에서 결과값으로 여러테이블을 조인하는 경우가 빈번하기 때문에 Entity클래스와 Controller에서 쓸 DTO는 분리해서 사용하도

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

	private String title;
	private String content;
	private String author;
	
	@Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

	public Posts toEntity() {
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}

}
