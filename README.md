# BOOK API - Spring Boot, MySQL, JPA Rest API Tutorial

Build Restful CRUD API for a simple Book-Manage application using Spring MVC, Mysql and Hibernate.

## Requirements

1. Java - 1.8.x

2. Maven - 3.3.9

3. MySQL - 5.7.12    

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/scbushan05/book-api-spring-boot.git
```

**2. Create Mysql database**

```bash
create database booksdb
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/db.properties`

+ change `mysql.user` and `mysql.password` as per your mysql installation

**4. Build and run the app using maven**



The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.
	Get All the books by :-
    GET /api/allbook
    
    POST /api/book
	
    Get Specific book by ID
    GET /api/book/{bookId}
    
    PUT /api/book/{bookId}
    
    DELETE /api/book/{bookId}

	Get specific book by Genre
	GET /getbookbyGenre/{genre}
	
	Get All Genre values by 
	GET /getbookbyGenre/all
	
	Get specific Author book by 
	/getbookbyAuthor/{author}
	
	Get All Authors 
	/getbookbyAuthor/all
	
	Get specific Feedback book by 
	/getbookbyFeedback/{feedback}
	
	
You can test them using postman or any other rest client.

After this , this is tested by Groovy integrations done with this.
Groovy integration needs to be run by the GroovySpringIntegration file