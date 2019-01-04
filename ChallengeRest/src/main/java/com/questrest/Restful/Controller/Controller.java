package com.questrest.Restful.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.questrest.Restful.Entity.Blog;
import com.questrest.Restful.Repository.BlogRepository;

@RestController
public class Controller {
	 @Autowired
	    BlogRepository blogRespository;

	    @GetMapping("/blogs")
	    public List<Blog> index(){
	        return blogRespository.findAll();
	    }

	    @GetMapping("/blogs/{id}")
	    public Blog show(@PathVariable int id){
	        return blogRespository.findById((long) id).get();
	    }

	    @PostMapping("/blogs/search")
	    public List<Blog> search(@RequestBody Map<String, String> body){
	        String searchTerm = body.get("text");
	        return blogRespository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
	    }

	    @PostMapping("/blogs")
	    public Blog create(@RequestBody Blog blog){
	        return blogRespository.save(blog);
	    }

	    @PutMapping("/blogs/{id}")
	    public Blog update(@PathVariable int id, @RequestBody Blog blog){
	        
	        Blog blogToUpdate = blogRespository.findById((long) id).get();
	        blogToUpdate.setName(blog.getTitle());
	        blogToUpdate.setFilm(blog.getContent());
	        return blogRespository.save(blogToUpdate);
	    }

	    @DeleteMapping("blogs/{id}")
	    public boolean delete(@PathVariable int id){
	        blogRespository.deleteById((long) id);
	        return true;
	    }
}
