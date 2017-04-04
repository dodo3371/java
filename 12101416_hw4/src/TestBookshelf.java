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
	     * 1�� �Է��ϸ� Ű���带 �Է¹��� �Ŀ�
	     * Ű���尡 å�̸��� ���� å�� ã�Ƽ� ����Ѵ�.
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
	     * 2�� �Է��ϸ� Ű���带 �Է¹��� �Ŀ�
	     * Ű���尡 å���ڿ� ���� å�� ã�Ƽ� ����Ѵ�.
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
	     * 3�� �Է��ϸ� Ű���带 �Է¹��� �Ŀ�
	     * Ű���尡 å�̸� �Ǵ� ���ڿ� ���� å�� ã�Ƽ� ����Ѵ�.
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
