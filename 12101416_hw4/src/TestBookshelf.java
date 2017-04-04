import java.util.Scanner;

public class TestBookshelf {
    public static void main(String[] args) {
	Bookshelf testObj = new Bookshelf();
	Scanner input = new Scanner(System.in);
	while(true) {
	    System.out.println("Choose 1 option to search:");
	    System.out.println("1. Search by title.");
	    System.out.println("2. Search by author.");
	    System.out.println("3. Search by both.");
	    System.out.print("User input: ");
	    int menu = input.nextInt();
	    
	    /*
	     * 1을 입력하면 키워드를 입력받은 후에
	     * 키워드가 책이름에 들어가는 책을 찾아서 출력한다.
	     */
	    if(menu == 1) {
		System.out.print("Insert title keyword: ");
		String keyword = input.next();
		Book findBook[] = testObj.searchByTitle(keyword);
		System.out.println("Found " + findBook.length + " book(s).");
		for(int i = 0; i < findBook.length; ++i) {
		    System.out.println(i + 1 + ". " + findBook[i].toString());
		}
	    }
	    /*
	     * 2를 입력하면 키워드를 입력받은 후에
	     * 키워드가 책저자에 들어가는 책을 찾아서 출력한다.
	     */
	    else if(menu == 2) {
		System.out.print("Insert author keyword: ");
		String keyword = input.next();
		Book findBook[] = testObj.searchByAuthor(keyword);
		System.out.println("Found " + findBook.length + " book(s).");
		for(int i = 0; i < findBook.length; ++i) {
		    System.out.println(i + 1 + ". " + findBook[i].toString());
		}
	    }
	    /*
	     * 3을 입력하면 키워드를 입력받은 후에
	     * 키워드가 책이름 또는 저자에 들어가는 책을 찾아서 출력한다.
	     */
	    else if(menu == 3) {
		System.out.print("Insert both keyword: ");
		String keyword = input.next();
		Book findBook[] = testObj.searchByBoth(keyword);
		System.out.println("Found " + findBook.length + " book(s).");
		for(int i = 0; i < findBook.length; ++i) {
		    System.out.println(i + 1 + ". " + findBook[i].toString());
		}
	    }
	    
	    System.out.println("----------------------------------------------------");
	}
    }
}
