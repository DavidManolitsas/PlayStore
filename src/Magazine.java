

//Magazine is a subclass of Publication
public class Magazine extends Publication {

	//volume is a unique variable for Magazine
	private int volume;

	
	public Magazine(String ID, String name, Double price, String publisher, int pages, int volume) {
		super(ID, name, price, publisher, pages);
		this.volume = volume;
	}

	
	public int getVolume() {
		return volume;
	}
}