


import java.util.Scanner;

/**
 * 	@author David Manolitsas
 *	@studentID S3779380
 *	@course	COSC2531 Programming Fundamentals
 */

public class PlayStoreMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(">>>>>WELCOME TO THE PLAY STORE<<<<<\n");

		Scanner input = new Scanner(System.in);

		PlayStore store = new PlayStore();

		// new publications
		String[] authors1 = { "L. Tolstoy" };
		Book b1 = new Book("b1", "War and Peace", 12.55, "The Russian Messenger", 1225, authors1);

		String[] authors2 = { "F. Scott Fitzgerald" };
		Book b2 = new Book("b2", "The great gatsby", 10.0, "Charles Scribner's Sons", 180, authors2);

		String[] authors3 = { "Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein" };
		Book b3 = new Book("b3", "Introduction to algorithms", 100.0, "MIT Press", 1312, authors3);

		Magazine m1 = new Magazine("m1", "Forbes", 8.99, "Forbes Media", 50, 201904);

		store.addContent(b1);
		store.addContent(b2);
		store.addContent(b3);
		store.addContent(m1);

		Application g1 = new Application("g1", "Pokemon", 5.3, "androidV4");
		Application g2 = new Application("g2", "Pokemon", 5.0, "iOSV10");

		// a free app
		Application app1 = new Application("app1", "Calendar", null, "androidV3");

		store.addContent(g1);
		store.addContent(g2);
		store.addContent(app1);

		// Adding new users
		User u1 = new User("u1", "John Doe", "0412000", 200);
		User u2 = new User("u2", "Mary Poppins", "0433191");
		User u3 = new User("u3", "Dave Smith", "0413456", 1000);
		User u4 = new User("u4", "Jackie Chan", "0417654");

		store.addUser(u1);
		store.addUser(u2);
		store.addUser(u3);
		store.addUser(u4);

		Comment comment1 = new Comment(u1, "This is a fantastic game!");
		g1.addReview(comment1);

		Comment comment2 = new Comment(u2, "I never liked this game!");
		g1.addReview(comment2);

		g1.addReview(new Comment(u3, "The game crashes frequently"));

		b1.addReview(new Comment(u2, "I love Tolstoy!"));

		// Simulating transactions, showing content, comments etc etc.
		// They can be driven by menu input as well.
		u1.buyContent(b1);
		u1.buyContent(b3);
		u1.buyContent(m1);

		u4.buyContent(g1);
		u4.becomePremium();
		u4.buyContent(m1);

		u2.becomePremium();
		u2.buyContent(b1);
		u2.buyContent(g1);

		g1.showComments();
		
		System.out.println(" ");

		// to do: call a method to show all content items of a particular type, e.g.
		// book, magazine, application.
		//Show all publications 
		store.showPublication();
		System.out.println("\n");
		//Show all books
		store.showBook();
		System.out.println("\n");
		//Show all magazines
		store.showMagazine();
		System.out.println("\n");
		//Show all applications
		store.showApplication();
		System.out.println("\n");
		
		// Administrator menu
		//variables used in administrator menu
		int option;
		String line;
		User user;
		String userID;
		Content content;
		String contentID;

		String menu[] = { "(1) Upgrade a member to premium", "(2) Purchase one item for one user",
				"(3) List all available content", "(4) Show all purchased items of a user",
				"(5) Show all comments of a content", "(0) Quit" };

		do {
			// loop the admin menu, asking for next input
			System.out.println("\n>>>>>ADMINISTRATOR MENU<<<<<");
			for (int i = 0; i < menu.length; i++)
				System.out.println(menu[i]);
			line = input.nextLine();

			//intialise option as a number not in the menu, so that it will not interrupt the try/catch
			option = -1;
			try {
				option = Integer.parseInt(line);
				content = null;

				switch (option) {
				case 0:
					// exit store and close Scanner input
					System.out.println("Logged Out of Play Store..");
					input.close();
					break;
				case 1:
					//Upgrade a member to a premium member
					// prompt admin to enter users ID (key) of HashMap
					System.out.println("ENTER USERS ID TO MAKE THEM A PREMIUM MEMBER:");
					store.showUsers();
					userID = input.nextLine();

					user = store.getUser(userID);
					if (user == null) {
						System.out.println("Error: User doesn't exist");
					} else {
						user.becomePremium();
					}
					break;
				case 2:
					//Purchase and item for a user
					// prompt admin to enter users ID (key) of HashMap
					System.out.println("ENTER USERS ID TO PURCHASE AN ITEM FOR THEM:");
					//display all users
					store.showUsers();
					userID = input.nextLine();
					//get userID
					user = store.getUser(userID);

					// prompt admin to enter content ID (key) of HashMap
					while (content == null) {
						System.out.println("ENTER CONTENT ID TO PURCHASE ITEM:");
						store.showContent();
						contentID = input.nextLine();
						//get contentID
						content = store.getContent(contentID);
					}

					if (user == null) {
						System.out.println("Error: User doesn't exist");
					} else {
						user.buyContent(content);
					}
					break;
				case 3:
					// list all the content in the store
					store.showContent();
					break;
				case 4:
					//Show all purchased items for a user
					// prompt admin to enter users ID (key) of HashMap
					System.out.println("ENTER USERS ID TO VIEW THEIR CONTENT:");
					store.showUsers();
					userID = input.nextLine();
					user = store.getUser(userID);

					if (user == null) {
						System.out.println("Error: User doesn't exist");
					} else {
						user.showContentBought();
					}
					break;
				case 5:
					// Show all comments of a content
					// prompt admin to enter users ID (key) of HashMap
					while (content == null) {
						System.out.println("ENTER CONTENT ID TO VIEW REVIEWS:");
						store.showContent();
						contentID = input.nextLine();
						content = store.getContent(contentID);
					}
					content.showComments();
					break;
				default:
					System.out.println("Invalid input");
					break;
				}
			} catch (NumberFormatException e) {
				// print error for NumberFormatException in red
				System.err.println("Error: invalid input");
			}
		} while (option != 0);
	}
}
