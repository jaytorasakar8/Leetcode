package Question7_5;

public class OnlineReaderSystem {
	private Book b;
	private User u;
	public OnlineReaderSystem(Book b, User u) {
		this.b = b;
		this.u = u;
	}
	
	public void listenRequest() { }
	public Book searchBook(long ID) { return Book.find(ID); }
	public User searchUser(long ID){ return User.find(ID); }
	public void display() { }
	public Book getBook() { return b; }
	public void setBook(Book b) { this.b = b; }
	public User getUser() { return u; }
	public void setUser(User u) { this.u = u; }
}
