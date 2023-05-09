import java.util.HashSet;
import java.util.Scanner;

public class main {
	static Scanner scan = new Scanner(System.in);
	static Library library = new turunan();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 initLibraryData();

		    String isContinue = "y";

		    while (isContinue.equals("y")) {
		      showMenu();
		      int selectedMenu = chooseMenu();

		      if (selectedMenu == 1) {
		        showBooks();
		      } else if (selectedMenu == 2) {
		        showMembers();
		      } else if (selectedMenu == 3) {
		        addMember();
		      } else if (selectedMenu == 4) {
		        borrowBook();
		      } else if (selectedMenu == 5) {
		        returnBook();
		      } else if (selectedMenu == 6) {
			    addBook();
		      } else {
		        System.out.println("wrong input");
		      }

		      System.out.print("continue ? ");
		      isContinue = scan.next();
		    }

	}
	
	public static void showMenu() {
	    System.out.println("================================");
	    System.out.println("1. show books list");
	    System.out.println("2. show members list");
	    System.out.println("3. add member");
	    System.out.println("4. borrow book");
	    System.out.println("5. return book");
	    System.out.println("6. dd book");
	    System.out.println("================================");
	  }

	  public static void initLibraryData() {
	    Book book1 = new Book();
	    book1.id = "1";
	    book1.title = "pemrograman java";

	    Book book2 = new Book();
	    book2.id = "2";
	    book2.title = "pemrograman oop";

	    Book book3 = new Book();
	    book3.id = "3";
	    book3.title = "pemrograman android";

	    Member member1 = new Member();
	    member1.setId("1");
	    member1.setName("aka");

	    Member member2 = new Member();
	    member2.setId("2");
	    member2.setName("budi");

	    Member member3 = new Member();
	    member3.setId("3");
	    member3.setName("tono");

	    library.books.add(book1);
	    library.books.add(book2);
	    library.books.add(book3);

	    library.members.add(member1);
	    library.members.add(member2);
	    library.members.add(member3);
	  }

	  public static int chooseMenu() {
	    System.out.print("choose menu : ");
	    int pilihan = scan.nextInt();
	    return pilihan;
	  }

	  public static void showBooks() {
	    for (Book book : library.books) {
	      System.out.println(book.id + " " + book.title);
	    }
	  }

	  public static void showMembers() {
	    for (Member member : library.members) {
	      System.out.println(member.getId() + " " + member.getName());
	    }
	  }

	//  edit member id agar tidak sama
	  public static void addMember() {
		Member member = new Member();
		
		 HashSet<String> cek = new HashSet<String>();
			for(Member user : library.members) {
				cek.add(user.getId());
			}
			
			System.out.println("ID :");
			String id_member = scan.next();
			
			while(cek.contains(id_member)) {
				System.out.println("ID Telah Ada");
				System.out.println("ID :");
				id_member = scan.next();
			}
			
			member.setId(id_member);
			System.out.println("Nama :");
			member.setName(scan.next());

	    library.addMember(member);
	  }

	  public static void borrowBook() {
	    System.out.print("id member : ");
	    String memberId = scan.next();

	    System.out.print("id book : ");
	    String bookId = scan.next();

	    library.giveBook(memberId, bookId);
	  }

	  public static void returnBook() {
	    System.out.print("id member : ");
	    String memberId = scan.next();

	    System.out.print("id book : ");
	    String bookId = scan.next();

	    library.receiveBook(memberId, bookId);
	  }
	  
	//  buat method addbook dan membuat id book tidak sama
	  public static void addBook() {
		  Book book = new Book();
		  
		  try {
			do {
			  if(library.isBookIdExist(book.id) == true) {
				System.out.println("ID Sudah Ada");
			  }
				  
			  System.out.println("ID :");
			  book.id = scan.next() ;
				  
			}while(library.isBookIdExist(book.id) == true);
			  
			System.out.println("Nama :");
			book.title = scan.next();
			library.books.add(book); 
		  }catch (Exception e) {
			  System.out.println("Terjadi kesalahan: " + e.getMessage());
		  }
	  }
}
