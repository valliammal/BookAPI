package groovyspring.model;

import java.math.BigDecimal;

public class Book {
	public Book() {
		super();
	}

	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuther() {
		return Auther;
	}
	public void setAuther(String auther) {
		Auther = auther;
	}
	
	public int getASIN() {
		return ASIN;
	}
	public void setASIN(int aSIN) {
		ASIN = aSIN;
	}
	public BigDecimal getGenre() {
		return Genre;
	}
	public void setGenre(BigDecimal genre) {
		Genre = genre;
	}

	private String Title;
	private String Auther;
	private int ASIN;
	private BigDecimal Genre;


}
