package com.bookapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapi.exception.BookNotFoundException;
import com.bookapi.model.Book;
import com.bookapi.repository.BookRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/allbook")
	public List<Book> getAllBooks() {
	    return bookRepository.findAll();
	}
	
	@PostMapping("/book")
	public Book createBook(@Valid @RequestBody Book book) {
	    return bookRepository.save(book);
	}
	
	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable(value = "id") Long bookId) {
	    return bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book", "id", bookId));
	}
	
	@PutMapping("/book/{id}")
	public Book updateBook(@PathVariable(value = "id") int bookId,
	                                        @Valid @RequestBody Book bookDetails) {

	    bookRepository.findById((long) bookId).orElseThrow(() -> new BookNotFoundException("Book", "id", bookId));
	    
	    bookDetails.setAsin(bookId);
	    Book updateBook = bookRepository.save(bookDetails);
	    return updateBook;
	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) {
	    Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book", "id", bookId));

	    bookRepository.delete(book);
	    return ResponseEntity.ok().build();
	}
	
	@GetMapping("/getbookbyGenre/{genre}")
	public  List<Book>  getbookbyGenre(@PathVariable(value = "genre") String genre) {
		System.out.println(" the value of Genre passed " + genre);
	    return bookRepository.findByGenre(genre);
	}

	@GetMapping("/getbookbyGenre/all")
	public  List<String>  getAllGenre() {
	    return bookRepository.findAllGenres();
	}
	
	@GetMapping("/getbookbyAuthor/{author}")
	public  List<Book>  getbookbyAuthor(@PathVariable(value = "author") String author) {
		System.out.println(" the value of Author passed " + author);
	    return bookRepository.findByAuthor(author);
	}

	
	@GetMapping("/getbookbyFeedback/{feedback}")
	public  List<Book>  getbookbyFeedback(@PathVariable(value = "feedback") String feedback) {
		System.out.println(" the value of Author passed " + feedback);
	    return bookRepository.findByfeedback(feedback);
	}

	
	@GetMapping("/getbookbyAuthor/all")
	public  List<String>  getAllAuther() {
	    return bookRepository.findAllAuthor();
	}
	
}
