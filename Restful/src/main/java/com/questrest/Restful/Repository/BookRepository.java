package com.questrest.Restful.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.questrest.Restful.Entity.Book;



@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	List<Book> findByTitleContainingOrNameContaining(String recherche, String recherche2);

	
	
}
