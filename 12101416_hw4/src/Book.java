
public class Book {
    private String title;
    private String[] authors;
    private int page;
    private int pubYear;
    
    /*
     * Book�� ������
     * ����������� �ʱ�ȭ���ش�.
     */
    public Book(String title, String[] authors, int page, int year) {
	this.title = title;
	this.authors = authors;
	this.page = page;
	pubYear = year;
    }
    
    //title���� ��ȯ�Ѵ�.
    public String getTitle() {
        return title;
    }

    //title���� �����Ѵ�.
    public void setTitle(String title) {
        this.title = title;
    }

    //author������ ��ȯ�Ѵ�.
    public String[] getAuthors() {
        return authors;
    }

    //author������ �����Ѵ�.
    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    //page���� ��ȯ�Ѵ�.
    public int getPage() {
        return page;
    }

    //page���� �����Ѵ�.
    public void setPage(int page) {
        this.page = page;
    }

    //pubYear���� ��ȯ�Ѵ�.
    public int getPubYear() {
        return pubYear;
    }

    //pubYear���� �����Ѵ�.
    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    /*
     * Book�� ����� �������� ��ȯ�Ѵ�.
     * strRes�� Book�� ��� ������ �����Ѵ�.
     */
    public String toString() {
	String strRes = new String();
	strRes += (title + " - ");
	for(int i = 0; i < authors.length; ++i) {
	    strRes += authors[i];
	    if(i < authors.length - 1) {
		strRes += ", ";
	    }
	}
	strRes += (" - " + page + " pages - " + pubYear);
	return strRes;
    }

}
