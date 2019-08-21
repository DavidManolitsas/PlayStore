


import java.util.ArrayList;

abstract class Content {

	private String ID;
	private String name;
	private int downloads;
	private Double price;
	//ArrayList of comments for an item of content 
	private ArrayList<Comment> reviews = new ArrayList<Comment>();


	public Content(String ID, String name, int downloads, Double price) {
		this.ID = ID;
		this.name = name;
		this.downloads = downloads;
		this.price = price;
	}


	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public void setDownloads() {
		downloads++;
	}

	public String toString() {
		return ID + " " + name + " " + downloads + " $" + String.format("%.2f", price);
	}


	//adda a comment from the comment class to the reviews Array List
	public void addReview(Comment comment) {
		comment.getComment();
		reviews.add(comment);
	}


	public void showComments() {
		//loop through showComments ArrayList and print each comment
		System.out.println("All comments for: " + ID + " " + name);
		for (int i = 0; i < reviews.size(); i++) {
			System.out.println(reviews.get(i).toString());
		}
	}
}
