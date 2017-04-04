
public class Book extends Item {
    private String bookTitle;
    private String bookAuthor;

    /*
     * Book Ʋ������ ������
     * super�� �̿��ؼ� �θ� Ŭ������ �� ���� ������ �ʱ�ȭ�ϰ�,
     * bookTitle�� bookAuthor�� �ʱ�ȭ�Ѵ�.
     */
    public Book(String code, int price, String name, String author) {
	super(code, price);
	this.bookTitle = name;
	this.bookAuthor = author;
    }

    /*
     * �۰��̸��� ������ �޼ҵ�
     * bookAuthor�� ���� ��ȯ�Ѵ�.
     */
    public String getAuthor() {
	return this.bookAuthor;
    }

    /*
     * å�� �̸��� ������ �޼ҵ�
     * �������̵��� �޼ҵ��̴�.
     * bookTitle�� ���� ��ȯ�Ѵ�.
     */
    @Override
    public String getTitle() {
	return this.bookTitle;
    }

    /*
     * å�� ������ ������ �޼ҵ�
     * �������̵��� �޼ҵ��̴�.
     * �θ�Ŭ������ importPrice�� ���� 1.5�� ���� ���� int������ ����ȯ�� �ؼ� ��ȯ�Ѵ�.
     */
    @Override
    public int getSalePrice() {
	return (int)(super.importPrice * 1.5);
    }
}
