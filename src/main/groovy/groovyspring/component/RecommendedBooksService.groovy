package groovyspring.component
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component

import groovy.json.JsonSlurper
import groovy.transform.Memoized
import groovyspring.model.GBook
import groovyspring.model.GResponseWrapper

@Component
class RecommendedBooksService {


	private String serviceHostUrl = "http://localhost:8080"
	private String booksPath = "/api/allbook"
	private String genrePath = "/api/getbookbyGenre/all"
	private String specificGenrePath="/api/getbookbyGenre"
	private String specificFeedbackPath="/api/getbookbyFeedback"
	
	private static final Logger logger = LoggerFactory.getLogger(RecommendedBooksService.class)

	@Memoized
	String getBooks(String Genre) {

		String urlVal = serviceHostUrl + specificGenrePath + "/"+ Genre.substring(1,Genre.length()-1)
		System.out.println(urlVal)

		URL url = new URL(urlVal)
		logger.debug( "getBooks called rest service.")
		String response = ""
		InputStream inputStream = null
		try {
			URLConnection connection = url.openConnection();
			inputStream = connection.getInputStream();
		} catch(Exception e) {
			response = "Error";
		}
		if (response.equalsIgnoreCase(""))
			response= inputStream.text
		return response

	}
	
	
	@Memoized
	String getBasedOnFeedbackBooks(String feedback){
		String urlVal = serviceHostUrl + specificFeedbackPath + "/" + feedback
		System.out.println(urlVal)
		URL url = new URL(urlVal)
		URLConnection connection = url.openConnection();
		InputStream inputStream = connection.getInputStream();
		logger.debug( "getBooks called rest service.")
		return inputStream.text
	}


	@Memoized
	String getGenre(){
		//List<String> genreList = new ArrayList<>()
		//genreList = new URL(serviceHostUrl + genrePath).text
		URL url = new URL(serviceHostUrl + genrePath)
		System.out.println(url.toString())
		URLConnection connection = url.openConnection();
		InputStream inputStream = connection.getInputStream();
		logger.debug( "getGenre called rest service.")
		System.out.println("Result of the response ")
		return inputStream.text
	}
}
