
public class Rectangle extends TwoDimensionalShape {
    static final String CLASS_NAME = "Rectangle";

    /*
     * Rectangle Ŭ������ ������
     * name, width, height�� ���� �ʱ�ȭ�Ѵ�.
     * �θ� Ŭ������ �����ڸ� ���� �ʱ�ȭ�Ѵ�.
     */
    public Rectangle(String name, double width, double height) {
	super(name, width, height);
    }
    
    //CLASS_NAME�� ���� ��ȯ�ϴ� �޼ҵ�
    public static String getClassName() {
        return CLASS_NAME;
    }

    //�θ��� CLASS_NAME�� ���� ��ȯ�ϴ� �޼ҵ�
    public String getParentClassName() {
        return super.getClassName();
    }

    /*
     * width�� ���� ��ȯ�ϴ� �޼ҵ�
     * �θ�Ŭ������ getDimension1 �޼ҵ带 �̿��ؼ� ��ȯ�Ѵ�.
     */
    
    public double getWidth() {
	return super.getDimension1();
    }
    
    /*
     * height�� ���� ��ȯ�ϴ� �޼ҵ�
     * �θ�Ŭ������ getDimension2 �޼ҵ带 �̿��ؼ� ��ȯ�Ѵ�.
     */
    public double getHeight() {
	return super.getDimension2();
    }
    
    /*
     * width�� height�� ���� �����ϴ� �޼ҵ�
     * �θ�Ŭ������ setDimension1, setDimension2 �޼ҵ带 �̿��ؼ� �����Ѵ�.
     */
    public void setSize(double w, double h) {
	super.setDimension1(w);
	super.setDimension2(h);
    }
    
    /*
     * ���簢���� ���̸� ���ϴ� �޼ҵ�
     * �θ�Ŭ������ �޼ҵ带 �������̵��ߴ�.
     * ���簢���� ���̸� ���� ��ȯ�Ѵ�.
     */
    @Override
    public double getArea() {
	return getWidth() * getHeight();
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
