
public class Movie extends Item {
    private String movieTitle;
    private int publishedYear;

    /*
     * Movie 틀래스의 생성자
     * super를 이용해서 부모 클래스의 두 개의 변수를 초기화하고,
     * movieTitle과 publishedYear를 초기화한다.
     */
    public Movie(String code, int price, String title, int year) {
	super(code, price);
	this.movieTitle = title;
	this.publishedYear = year;
    }

    /*
     * 개봉연도를 얻어오는 메소드
     * publishedYear의 값을 반환한다.
     */
    public int getYear() {
	return this.publishedYear;
    }

    /*
     * 영화의 이름을 얻어오는 메소드
     * 오버라이딩된 메소드이다.
     * movieTitle의 값을 반환한다.
     */
    @Override
    public String getTitle() {
	return this.movieTitle;
    }

    /*
     * 영화의 가격을 얻어오는 메소드
     * 오버라이딩된 메소드이다.
     * 부모클래스의 importPrice의 값에 1.2를 곱한 값을 int형으로 형변환을 해서 반환한다.
     */
    @Override
    public int getSalePrice() {
	return (int)(super.importPrice * 1.2);
    }
}
