
public class Book {
    private String title;
    private String[] authors;
    private int page;
    private int pubYear;
    
    /*
     * Book의 생성자
     * 멤버변수들을 초기화해준다.
     */
    public Book(String title, String[] authors, int page, int year) {
	this.title = title;
	this.authors = authors;
	this.page = page;
	pubYear = year;
    }
    
    //title값을 반환한다.
    public String getTitle() {
        return title;
    }

    //title값을 설정한다.
    public void setTitle(String title) {
        this.title = title;
    }

    //author값들을 반환한다.
    public String[] getAuthors() {
        return authors;
    }

    //author값들을 설정한다.
    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    //page값을 반환한다.
    public int getPage() {
        return page;
    }

    //page값을 설정한다.
    public void setPage(int page) {
        this.page = page;
    }

    //pubYear값을 반환한다.
    public int getPubYear() {
        return pubYear;
    }

    //pubYear값을 설정한다.
    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    /*
     * Book에 저장된 정보들을 반환한다.
     * strRes에 Book의 모든 정보를 저장한다.
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
