package groovyspring

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import groovy.json.JsonBuilder
import groovy.json.JsonOutput

import groovyspring.GroovySpringApplication
import groovyspring.component.RecommendedBooksService
import groovyspring.model.GBook
import com.bookapi.BookapiApplication


@SpringBootApplication
public class GroovySpringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BookapiApplication.class, args)
		printData(context)
	}

	private static printData(ConfigurableApplicationContext context) {
		RecommendedBooksService recommendedBookService = new RecommendedBooksService()
		String genreVal = recommendedBookService.getGenre()
		String [] genArrayStr=genreVal.split(",");
		int lengthOfArray = genArrayStr.size();

		String gbookData = recommendedBookService.getBasedOnFeedbackBooks("Liked")
		System.out.println(gbookData)

		String gbookData1 = recommendedBookService.getBasedOnFeedbackBooks("DisLiked")
		System.out.println(gbookData1)

		for (int i=1; i < lengthOfArray; i++) {
			if (genArrayStr[i].contains("MysteryThrillerSuspense")) {
				genArrayStr[i] = genArrayStr[i].substring(0,genArrayStr[i].length()-1)
			}
			String textData = recommendedBookService.getBooks(genArrayStr[i])
			System.out.println(textData)
		}
		context.close()
	}
}
