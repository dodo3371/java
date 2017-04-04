
/*
 * 가상 메소드 두개가 있기 때문에
 * 가상 클래스가 된다.
 * 자식클래스에서 접근할 수 있도록 importPrice는 protected로 선언한다.
 */
public abstract class Item {
    private String barcode;
    protected int importPrice;

    /*
     * Item 클래스의 생성자
     * barcode와 inportPrice를 초기화한다.
     */
    public Item(String code, int price) {
	this.barcode = code;
	this.importPrice = price;
    }

    /*
     * 아이템의 가격을 얻어오는 메소드
     * 가상 메소드이므로 자식 클래스에서 구현을 해준다.
     */
    public abstract int getSalePrice();

    /*
     * 아이템의 이름을 얻어오는 메소드
     * 가상 메소드이므로 자식 클래스에서 구현을 해준다.
     */    
    public abstract String getTitle();
}
