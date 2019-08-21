

//Publication is a subclass of Content
public class Publication extends Content {

	//unique to the Publication class are the following variables
	private String publisher;
	private int pages;

	
	public Publication(String ID, String name, Double price, String publisher, int pages) {
		super(ID, name, 0, price);
		this.publisher = publisher;
		this.pages = pages;
	}

	
	public String getPublisher() {
		return publisher;
	}

	
	public int getPages() {
		return pages;
	}
}