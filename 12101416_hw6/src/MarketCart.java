import java.text.DecimalFormat;

/*
 * Cart �������̽��� ����Ѵ�.
 * ������ �������̽��� ���ԵǾ� �ִ� �� ���� �޼ҵ带 �������־�� �Ѵ�.
 */
public class MarketCart implements Cart {
    private final static int MAX_ITEM = 100;
    private Item items[];
    private int itemNum;
    private String buyerName;

    /*
     * MarketCart Ŭ������ ������
     * items �迭�� ũ�⸦ MAX_ITEM�� �ʱ�ȭ�Ѵ�.
     */
    MarketCart(String buyerName) {
	this.items = new Item[MAX_ITEM];
	this.itemNum = 0;
	this.buyerName = buyerName;
    }

    /*
     * Item �������̽��� �޼ҵ�
     * items�迭�� Item��ü�� MAX_ITEM��ŭ �����Ѵ�.
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
     * Item �������̽��� �޼ҵ�
     * buyerName�� items�� ����� Item ��ü�� ������ ����Ѵ�.
     * �������� ������ ��ȭ�� ����ϱ� ���� DecimalFormat�� ����Ѵ�.
     * ��� �������� ������ totalPrice�� ���� �� ������ ����Ѵ�. 
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