
public class TestMarketCart {
    public static void main(String[] args) {
	MarketCart cart1 = new MarketCart("Tamer");

	// �������� 4�� �����ϰ� �߰��� ������ ������ ������ ����Ѵ�.
	Item item1 = new Book("1231231231", 14000, "Harry Potter and the Deathly Hallows", "J.K.Rowling");	
	cart1.addItem(item1);
	
	Item item2 = new Movie("4545454545", 10000, "Lord of the Ring", 2001);
	cart1.addItem(item2);
	
	Item item3 = new Book("8493758392", 12000, "Jang Ok-jeong lives in love", "������");
	cart1.addItem(item3);
	
	Item item4 = new Movie("0909876483", 14000, "Taegukgi", 2003);
	cart1.addItem(item4);
	
	cart1.printReceipt();
    }
}
