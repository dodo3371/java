
public class Square extends Rectangle {
    static final String CLASS_NAME = "Square";
    
    /*
     * Square Ŭ������ ������
     * name�� side�� �ʱ�ȭ�Ѵ�.
     * �θ�Ŭ������ �����ڸ� ���ؼ� �ʱ�ȭ�Ѵ�.
     */
    Square(String name, double side) {
	super(name, side, side);
    }

    //CLASS_NAME�� ���� ��ȯ�Ѵ�.
    public static String getClassName() {
        return CLASS_NAME;
    }
    
    //�θ��� CLASS_NAME�� ���� ��ȯ�ϴ� �޼ҵ�
    public String getParentClassName() {
        return super.getClassName();
    }

    /*
     * ���簢���� �Ѻ��� ���̸� ��ȯ�ϴ� �޼ҵ�
     * �θ��� �θ�Ŭ������ getDimension1�� �̿��� ��ȯ�Ѵ�.
     */
    public double getSide() {
	return super.getDimension1();
    }
    
    /*
     * ���簢���� �Ѻ��� ���̸� �����ϴ� �޼ҵ�
     * �θ��� �θ�Ŭ������ setDimension1, setDimension2�� �̿��� �����Ѵ�.
     */
    public void setSide(double side) {
	super.setDimension1(side);
	super.setDimension2(side);
    }
    
    /*
     * ������ �̸��� ��ȯ�ϴ� �޼ҵ�
     * �θ�Ŭ������ �޼ҵ带 �������̵��ߴ�.
     */
    @Override
    public String toString() {
	return getClassName();
    }
}
