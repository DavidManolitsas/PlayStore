


public class Comment {

	private User UserID;
	private String comment;

	//Comment constructor including the Users ID and their comment
	public Comment(User UserID, String comment) {
		this.comment = comment;
		this.setUserID(UserID);
	}

	public String getComment() {
		return comment;
	}

	public User getUserID() {
		return UserID;
	}

	public void setUserID(User UserID) {
		this.UserID = UserID;
	}

	public String toString() {
		return UserID + " " + '"' + comment + '"' ;
	}
}