


import java.util.HashMap;

public class User {

	//instance variables
	private String ID;
	private String name;
	private String phoneNumber;
	private double funds;
	private boolean premiumUser;
	//Hash Map of content bought by the user
	private HashMap<String, Content> boughtContent = new HashMap<String, Content>(); 


	//constructor
	public User(String ID, String name, String phoneNumber, double funds) {
		this.ID = ID;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.funds = funds;
		premiumUser = false;
	}

	//Each new user starts with $500.00
	public User(String ID, String name, String phoneNumber) {
		this(ID, name, phoneNumber, 500);
	}

	//getters
	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public double getFunds() {
		return funds;
	}


	public String toString() {
		return ID + " " + name;
	}


	public void becomePremium() {
		//check to see if user is already a premium member or not
		//if they are not, deduct cost of premium membership ($100) from user funds
		if (premiumUser == false) {
			if (funds >= 100) {
				funds = funds - 100;
				System.out.println(name + " has become a premium member");
				premiumUser = true;
			} else {
				System.out.println("Error: " + name + " has insufficient funds");
			}
			//if user is already a premium member, display error
		} else
			System.out.println("Error: " + name + " is already a Premium User");
	}


	public void buyContent(Content content) {
		try {
			//check to see if the user already owns a piece of content
			if(boughtContent.containsValue(content)) {
				//throw an exception is the user already owns the content trying to be purchased
				throw new Exception("Error: " + name + " already owns " + content.getName());
			} else {
				//check to see if the user is a premium user to see whether or not they get the 20% discount
				if (premiumUser == false) {
					//regular user bought content
					if (funds >= content.getPrice()) {
						funds -= content.getPrice();
						content.setDownloads();
						boughtContent.put(content.getID(), content);
						System.out.println(name + " purchased " + content.getName() +  " for $" + String.format("%.2f", content.getPrice()));
						//if user has insufficient funds, throw an exception
					} else throw new Exception("Error: " + name + " has invalid Funds");
				}
				else {
					//premium user bought content
					if (funds >= content.getPrice() * 0.8) {
						funds -= (content.getPrice() * 0.8);
						content.setDownloads();
						boughtContent.put(content.getID(), content);
						System.out.println(name + " purchased " + content.getName() +  " for $" + String.format("%.2f",(content.getPrice() * 0.8)));
						//if user has insufficient funds, throw an exception
					} else throw new Exception("Error: " + name + " has invalid Funds");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public void showContentBought() {
		//loop and print all content within the user hash map
		System.out.println("All content bought by " + name + ":");
		for(Content z : boughtContent.values()) {
			System.out.println(z.toString());
		}
	}
}

