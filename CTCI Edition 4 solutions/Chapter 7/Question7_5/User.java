package Question7_5;

import java.util.Set;

public class User {
	private long ID;
	private String details;
	private int accountType;
	private static Set<User> users;
	
	public Book searchLibrary(long id){ return Book.find(id); }
	public void renewMembership() {  }
	
	public static User find(long ID) {
		for (User u:users) {
			if (u.getID() == ID) return u;
		}
		return null;
	}
	
	public static void addUser(long ID, String details, 
								int accountType) {
		users.add(new User(ID,details,accountType));
	}

	public User(long iD, String details, int accountType) {
		ID = iD;
		this.details = details;
		this.accountType = accountType;
	}
	public long getID() { return ID; }
	public void setID(long iD) { ID = iD; }
	public String getDetails() { return details; }
	public void setDetails(String details) { this.details = details; }
	public int getAccountType() { return accountType; }
	public void setAccountType(int accountType) { 
		this.accountType = accountType;
	}
}

