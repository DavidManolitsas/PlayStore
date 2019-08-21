

//Application is a subclass of Content
public class Application extends Content {
	
	//unique to the application class is the String OStype
	private String OStype;

	
	public Application(String ID, String name, int downloads, Double price, String OStype) {
		super(ID, name, downloads, price);
		this.OStype = OStype;
	}
	
	
	public Application (String ID, String name, Double price, String OStype) {
		this(ID, name, 0, 0.0, OStype);
	}
	
	
	public String getOStype() {
		return OStype;
	}
}