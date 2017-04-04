import java.text.DecimalFormat;

/*
 * Cart 인터페이스를 사용한다.
 * 때문에 인터페이스에 포함되어 있는 두 개의 메소드를 구현해주어야 한다.
 */
public class MarketCart implements Cart {
    private final static int MAX_ITEM = 100;
    private Item items[];
    private int itemNum;
    private String buyerName;

    /*
     * MarketCart 클래스의 생성자
     * items 배열의 크기를 MAX_ITEM로 초기화한다.
     */
    MarketCart(String buyerName) {
	this.items = new Item[MAX_ITEM];
	this.itemNum = 0;
	this.buyerName = buyerName;
    }

    /*
     * Item 인터페이스의 메소드
     * items배열에 Item객체를 MAX_ITEM만큼 저장한다.
     */
    @Override
    public void addItem(Item i) {
	if (itemNum >= MAX_ITEM) {
	    System.out.println("Cart is full!");
	} else {
	    items[itemNum] = i;
	    itemNum++;
	}
    }

    /*
     * Item 인터페이스의 메소드
     * buyerName과 items에 저장된 Item 객체의 정보를 출력한다.
     * 아이템의 가격을 원화로 출력하기 위해 DecimalFormat를 사용한다.
     * 모든 아이템의 가격을 totalPrice에 더해 총 가격을 출력한다. 
     */
    @Override
    public void printReceipt() {
	DecimalFormat df = new DecimalFormat("#,###");
	int totalPrice = 0;
	System.out.println("Receipt:");
	System.out.println("Buyer: " + buyerName);
	for (int i = 0; i < itemNum; ++i) {
	    System.out.printf("%d. %-37s ", i + 1, items[i].getTitle());
	    System.out.printf("%6s W\n", df.format(items[i].getSalePrice()));
	    totalPrice += items[i].getSalePrice();
	}
	System.out.printf("total: %40s W", df.format(totalPrice));
    }
}