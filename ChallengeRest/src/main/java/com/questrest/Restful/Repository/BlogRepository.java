package com.questrest.Restful.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.questrest.Restful.Entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{

	List<Blog> findByTitleContainingOrContentContaining(String searchTerm, String searchTerm2);

	
	
}
