
public class Book extends Item {
    private String bookTitle;
    private String bookAuthor;

    /*
     * Book 틀래스의 생성자
     * super를 이용해서 부모 클래스의 두 개의 변수를 초기화하고,
     * bookTitle과 bookAuthor를 초기화한다.
     */
    public Book(String code, int price, String name, String author) {
	super(code, price);
	this.bookTitle = name;
	this.bookAuthor = author;
    }

    /*
     * 작가이름을 얻어오는 메소드
     * bookAuthor의 값을 반환한다.
     */
    public String getAuthor() {
	return this.bookAuthor;
    }

    /*
     * 책의 이름을 얻어오는 메소드
     * 오버라이딩된 메소드이다.
     * bookTitle의 값을 반환한다.
     */
    @Override
    public String getTitle() {
	return this.bookTitle;
    }

    /*
     * 책의 가격을 얻어오는 메소드
     * 오버라이딩된 메소드이다.
     * 부모클래스의 importPrice의 값에 1.5를 곱한 값을 int형으로 형변환을 해서 반환한다.
     */
    @Override
    public int getSalePrice() {
	return (int)(super.importPrice * 1.5);
    }
}
