package groovyspring.service.impl;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import groovyspring.service.RecommendedBooks;

@Component("RecommendedBooks")
public class RecommendedBooksImp implements RecommendedBooks {

	@Override
	public String GetFirst20Books(String genre, String bookName, String Authername) {
		// Based on this data, the corresponding details need to be moved from the Books.txt
		return null;
	}

}
