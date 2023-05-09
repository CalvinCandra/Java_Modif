import java.util.ArrayList;

public class Member {
	private String id;
	  private String name;
	  
	  public ArrayList<Book> borrowedBooks = new ArrayList<Book>();

	  public void receiveBook(Book book) {
	    this.borrowedBooks.add(book);
	  }

	  public void giveBook(Book book) {
	    this.borrowedBooks.remove(book);
	  }
	  
//	  encapsulation
//	  set id
	  public void setId(String id) {
		  this.id = id;
	  }
//	  get id
	  public String getId() {
		  return id;
	  }
	  
//	  set nama
	  public void setName(String name) {
		  this.name = name;
	  }
//	  get id
	  public String getName() {
		  return name;
	  }
}
