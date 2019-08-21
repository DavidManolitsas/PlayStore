

//Import Java Utility Hash Map
import java.util.HashMap;

public class PlayStore {

	//Hash Maps for content and user
	//Chose Hash Maps over ArrayLists as both content and users have a unique identifier (UserID and ContentID)
	private HashMap <String, Content> contentMap;
	private HashMap<String, User> userMap;


	public PlayStore() {
		contentMap = new HashMap <String, Content>();
		userMap = new HashMap <String, User>();
	}


	public void addContent(Content content) {
		// add the content into the content hash map
		contentMap.put(content.getID(), content);
		System.out.println(content.getName() + " has been added to store");
	}


	public void addUser(User user) {
		//add the user into the user hash map
		userMap.put(user.getID(), user);
		System.out.println(user.getName() + " has joined the Play Store");
	}	


	public void showContent() {
		//loop and print all content within the content hash map
		System.out.println("ALL CONTENT IN THE STORE:");
		for(Content x : contentMap.values()) {
			System.out.println(x.toString());
		}
	}


	public void showPublication() {
		//loop and print all content within the content hash map
		System.out.println("ALL PUBLICATIONS IN THE STORE:");
		for(Content x : contentMap.values()) {
			if(x.getClass().equals(Book.class) || x.getClass().equals(Magazine.class))
				System.out.println(x.toString());
		}
	}


	public void showBook() {
		//loop and print all content within the content hash map
		System.out.println("ALL BOOKS IN THE STORE:");
		for(Content x : contentMap.values()) {
			if(x.getClass().equals(Book.class))
				System.out.println(x.toString());
		}
	}


	public void showMagazine() {
		//loop and print all content within the content hash map
		System.out.println("ALL MAGAZINES IN THE STORE:");
		for(Content x : contentMap.values()) {
			if(x.getClass().equals(Magazine.class))
				System.out.println(x.toString());
		}
	}


	public void showApplication() {
		//loop and print all content within the content hash map
		System.out.println("ALL APPLICATIONS IN THE STORE:");
		for(Content x : contentMap.values()) {
			if(x.getClass().equals(Application.class))
				System.out.println(x.toString());
		}
	}


	public void showUsers() {
		//loop and print all content within the user hash map
		System.out.println("ALL USERS IN THE STORE:");
		for(User y : userMap.values()) {
			System.out.println(y.toString());
		}
	}


	//getters
	public User getUser(String user) {
		return userMap.get(user);
	}

	public Content getContent (String content) {
		return contentMap.get(content);
	}
}
