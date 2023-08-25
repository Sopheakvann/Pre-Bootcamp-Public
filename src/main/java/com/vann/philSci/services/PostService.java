package com.vann.philSci.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.vann.philSci.models.Post;
import com.vann.philSci.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	public List<Post> getAllPost(){
		return postRepo.findAll();
	}
	
	public Post addPost(Post p, BindingResult result) {
		if(result.hasErrors()) {
			result.rejectValue("post", "Post Field cannot be blank!");
		}
		return postRepo.save(p);
	}
	
	public Post getPostById(Long id) {
		Optional<Post> optionalPost = postRepo.findById(id);
		if(optionalPost.isPresent()) {
			return optionalPost.get();
		}else {
			return null;
		}
	}
	
	public Post updatePost(Post p) {
		return postRepo.save(p);
	}
	
	public void deletePost(Long id) {
		postRepo.deleteById(id);
	}
	

	
	

}
