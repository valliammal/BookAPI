package com.bookapi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookapi.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    /**
     * Find a page of all books that not appear in any active orders
     * @param pageable
     * @return page of available books
     */
    @Query("SELECT b FROM Book b")
    Page<Book> findAvailable(Pageable pageable);

    /**
     * Find all genres, appeared in the library
     * @return list of all appeared genres
     */
    @Query("SELECT Genre from Book b")
    List<String> findAllGenres();

    /**
     * Find all Authors, appeared in the library
     * @return list of all appeared Authors
     */

    @Query("SELECT Author from Book b")
    List<String> findAllAuthor();

    /**
     * Find page of books by given genre
     * @param genre
     * @param request pageable
     * @return page of books of requested genre
     */
    @Query("select b from Book b where b.Genre = :genre")
    List<Book> findByGenre(@Param("genre") String genre) ;


    /**
     * Find page of books by given feedback
     * @param genre
     * @return page of books of requested feedback
     */
    @Query("select b from Book b where b.feedback = :feedback")
    List<Book> findByfeedback(@Param("feedback") String feedback) ;

    
    /**
     * Find page of books by given Author
     * @param Author
     * @param request pageable
     * @return page of books of requested Author
     */
    @Query("select b from Book b where b.Author = :author")
    List<Book> findByAuthor(@Param("author") String author) ;

    /**
     * Find book by its id, search only in active orders
     * @param id book id
     * @return found Book or null if not found
     */
    @Query("SELECT b FROM Book b WHERE b.id = :id")
    Book findBook(Long id);

}
