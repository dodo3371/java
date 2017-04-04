
public class Movie extends Item {
    private String movieTitle;
    private int publishedYear;

    /*
     * Movie Ʋ������ ������
     * super�� �̿��ؼ� �θ� Ŭ������ �� ���� ������ �ʱ�ȭ�ϰ�,
     * movieTitle�� publishedYear�� �ʱ�ȭ�Ѵ�.
     */
    public Movie(String code, int price, String title, int year) {
	super(code, price);
	this.movieTitle = title;
	this.publishedYear = year;
    }

    /*
     * ���������� ������ �޼ҵ�
     * publishedYear�� ���� ��ȯ�Ѵ�.
     */
    public int getYear() {
	return this.publishedYear;
    }

    /*
     * ��ȭ�� �̸��� ������ �޼ҵ�
     * �������̵��� �޼ҵ��̴�.
     * movieTitle�� ���� ��ȯ�Ѵ�.
     */
    @Override
    public String getTitle() {
	return this.movieTitle;
    }

    /*
     * ��ȭ�� ������ ������ �޼ҵ�
     * �������̵��� �޼ҵ��̴�.
     * �θ�Ŭ������ importPrice�� ���� 1.2�� ���� ���� int������ ����ȯ�� �ؼ� ��ȯ�Ѵ�.
     */
    @Override
    public int getSalePrice() {
	return (int)(super.importPrice * 1.2);
    }
}
