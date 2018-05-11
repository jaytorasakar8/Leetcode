package Question7_5;

import java.util.Set;

public class Book {
	private long ID;
	private String details;	
	private static Set<Book> books;
	
	public Book(long iD, String details) {
		ID = iD;
		this.details = details;
	}
	
	public static void addBook(long iD, String details){
		books.add(new Book(iD,details));
	}
	
	public void update() { } 
	
	public static void delete(Book b){
		books.remove(b);
	}
	
	public static Book find(long id){
		for (Book b : books) {
			if(b.getID() == id)	return b;
		}
		return null;
	}
	
	public long getID() { return ID; }
	public void setID(long iD) { ID = iD; }
	public String getDetails() { return details; }
	public void setDetails(String details) { this.details = details; }
}