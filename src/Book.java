

//Book is a subclass of Publication with an additional variable of authors
public class Book extends Publication {

	//String array of authors as a book may have multiple authors
	private String[] authors;

	
	public Book(String ID, String name, Double price, String publisher, int pages, String[] authors) {
		super(ID, name, price, publisher, pages);
		this.authors = authors;
	}

	
	public String[] getAuthors() {
		return authors;
	}
	
}