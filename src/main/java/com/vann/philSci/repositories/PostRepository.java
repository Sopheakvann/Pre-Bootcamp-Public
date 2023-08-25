package com.vann.philSci.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.vann.philSci.models.Post;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public interface PostRepository extends CrudRepository<Post, Long>{
	
	List<Post> findAll();
	
	
	

}
