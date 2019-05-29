package com.giantdwarf.webservice.web;



import java.awt.image.BufferedImage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.giantdwarf.webservice.domain.post.PostsRepository;
import com.giantdwarf.webservice.dto.posts.PostsSaveRequestDto;

@RestController
public class WebRestController {

	private PostsRepository postsRepository;
	
    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
    	postsRepository.save(dto.toEntity());
    	
    }
}
