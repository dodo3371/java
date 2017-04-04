
public class Bookshelf {
    static final int bookCapacity = 50;
    private int bookHave;
    private Book[] books;
    
    /*
     * Bookshelf의 생성자.
     * books에 저장할 책들의 정보를 저장한다.
     */
    public Bookshelf() {
	books = new Book[3];
	String author[] = new String[1];
	author[0] = "J.K.Rowling";
	books[0] = new Book("Harry Potter And The Sorcerer's Stone", author, 428, 1998);
	
	author = new String[2];
	author[0] = "J.K.Rowling";
	author[1] = "Mary GrandPre";
	books[1] = new Book("Harry Potter And The Goblet Of Fire", author, 752, 2002);
	
	author = new String[1];
	author[0] = "J.K.Rowling";
	books[2] = new Book("The Casual Vacancy", author, 513, 2012);
	bookHave = 3;
    }
    
    /*
     * 책이름을 찾는 메소드.
     * 입력받은 키워드가 들어간 책을 찾아서 반환한다.
     * 저장된 책중에서 키워드가 들어가는 책의 인덱스를 저장한 후에
     * findBook에 저장하고 반환한다.
     */
    public Book[] searchByTitle(String keyword) {
	int[] bookIdx = new int[bookCapacity];
	int cnt = 0;
	for(int i = 0; i < books.length; ++i) {
	    boolean found = books[i].getTitle().contains(keyword);
	    if(found) {
		bookIdx[cnt] = i;
		cnt++;
	    }
	}
	Book[] findBook = new Book[cnt];
	for(int i = 0; i < cnt; ++i) {
	    findBook[i] = books[bookIdx[i]];
	}
	return findBook;
    }

    /*
     * 책저자을 찾는 메소드.
     * 입력받은 키워드가 들어간 저자를 찾아서 반환한다.
     * 저장된 책중에서 키워드가 들어가는 책의 인덱스를 저장한 후에
     * findBook에 저장하고 반환한다.
     */
    public Book[] searchByAuthor(String keyword) {
	int[] bookIdx = new int[bookCapacity];
	int cnt = 0;
	for(int i = 0; i < books.length; ++i) {
	    for(int j = 0; j < books[i].getAuthors().length; ++j) {
		boolean found = books[i].getAuthors()[j].contains(keyword);
		if(found) {
		    bookIdx[cnt] = i;
		    cnt++;
		    break;
		}
	    }
	}
	Book[] findBook = new Book[cnt];
	for(int i = 0; i < cnt; ++i) {
	    findBook[i] = books[bookIdx[i]];
	}
	return findBook;
    }
    
    /*
     * 키워드가 책이름 또는 저자에 들어가는 책을 찾는 메소드.
     * 입력받은 키워드가 책이름 또는 저자에 들어가는 책을 찾아서 반환한다.
     * 저장된 책중에서 키워드가 들어가는 책의 인덱스를 저장한 후에
     * findBook에 저장하고 반환한다.
     */
    public Book[] searchByBoth(String keyword) {
	int[] bookIdx = new int[bookCapacity];
	int cnt = 0;
	for(int i = 0; i < books.length; ++i) {
	boolean found = books[i].getTitle().contains(keyword);
	if(found) {
	    bookIdx[cnt] = i;
	    cnt++;
	    continue;
	}
	    for(int j = 0; j < books[i].getAuthors().length; ++j) {
		found = books[i].getAuthors()[j].contains(keyword);
		if(found) {
		    bookIdx[cnt] = i;
		    cnt++;
		    break;
		}
	    }
	}
	Book[] findBook = new Book[cnt];
	for(int i = 0; i < cnt; ++i) {
	    findBook[i] = books[bookIdx[i]];
	}
	return findBook;
    }
}
