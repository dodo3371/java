
/*
 * ���� �޼ҵ� �ΰ��� �ֱ� ������
 * ���� Ŭ������ �ȴ�.
 * �ڽ�Ŭ�������� ������ �� �ֵ��� importPrice�� protected�� �����Ѵ�.
 */
public abstract class Item {
    private String barcode;
    protected int importPrice;

    /*
     * Item Ŭ������ ������
     * barcode�� inportPrice�� �ʱ�ȭ�Ѵ�.
     */
    public Item(String code, int price) {
	this.barcode = code;
	this.importPrice = price;
    }

    /*
     * �������� ������ ������ �޼ҵ�
     * ���� �޼ҵ��̹Ƿ� �ڽ� Ŭ�������� ������ ���ش�.
     */
    public abstract int getSalePrice();

    /*
     * �������� �̸��� ������ �޼ҵ�
     * ���� �޼ҵ��̹Ƿ� �ڽ� Ŭ�������� ������ ���ش�.
     */    
    public abstract String getTitle();
}
