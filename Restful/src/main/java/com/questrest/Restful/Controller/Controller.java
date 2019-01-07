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

import com.questrest.Restful.Entity.Book;
import com.questrest.Restful.Repository.BookRepository;



@RestController
public class Controller {
	 @Autowired
	    BookRepository bookRespository;

	    @GetMapping("/books")
	    public List<Book> index(){
	        return bookRespository.findAll();
	    }

	    @GetMapping("/books/{id}")
	    public Book show(@PathVariable int id){
	        return bookRespository.findById((long) id).get();
	    }

	    @PostMapping("/books/search")
	    public List<Book> search(@RequestBody Map<String, String> body){
	        String recherche = body.get("text");
	        return bookRespository.findByTitleContainingOrNameContaining(recherche, recherche);
	    }

	    @PostMapping("/books")
	    public Book create(@RequestBody Book book){
	        return bookRespository.save(book);
	    }

	    @PutMapping("/books/{id}")
	    public Book update(@PathVariable int id, @RequestBody Book book){
	        
	        Book bookToUpdate = bookRespository.findById((long) id).get();
	        bookToUpdate.setTitle(book.getTitle());
	        bookToUpdate.setName(book.getName());
	        bookToUpdate.setAuthor(book.getAuthor());
	        return bookRespository.save(bookToUpdate);
	    }

	    @DeleteMapping("books/{id}")
	    public boolean delete(@PathVariable int id){
	        bookRespository.deleteById((long) id);
	        return true;
	    }
}
