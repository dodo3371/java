
public class RectangularPrism extends ThreeDimensionalShape {
    static final String CLASS_NAME = "Rectangular Prism";

    /*
     * RectangularPrism Ŭ������ ������
     * name, length, width, height�� ���� �ʱ�ȭ�Ѵ�.
     * �θ� Ŭ������ �����ڸ� ���� �ʱ�ȭ�Ѵ�.
     */
    public RectangularPrism(String name, double length, double width, double height) {
	super(name, length, width, height);
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
     * length�� ���� ��ȯ�ϴ� �޼ҵ�
     * �θ�Ŭ������ getDimension1 �޼ҵ带 �̿��ؼ� ��ȯ�Ѵ�.
     */    
    public double getLength() {
	return super.getDimension1();
    }

    /*
     * width�� ���� ��ȯ�ϴ� �޼ҵ�
     * �θ�Ŭ������ getDimension2 �޼ҵ带 �̿��ؼ� ��ȯ�Ѵ�.
     */    
    public double getWidth() {
	return super.getDimension2();
    }
    
    /*
     * height�� ���� ��ȯ�ϴ� �޼ҵ�
     * �θ�Ŭ������ getDimension3 �޼ҵ带 �̿��ؼ� ��ȯ�Ѵ�.
     */
    public double getHeight() {
	return super.getDimension3();
    }
    
    /*
     * length�� width, height�� ���� �����ϴ� �޼ҵ�
     * �θ�Ŭ������ setDimension1, setDimension2, setDimension2 �޼ҵ带 �̿��ؼ� �����Ѵ�.
     */
    public void setSize(double l, double w, double h) {
	super.setDimension1(l);
	super.setDimension2(w);
	super.setDimension3(h);
    }
    
    /*
     * ������ü�� ���Ǹ� ���ϴ� �޼ҵ�
     * �θ�Ŭ������ �޼ҵ带 �������̵��ߴ�.
     * ������ü�� ���Ǹ� ���� ��ȯ�Ѵ�.
     */
    @Override
    public double getVolume() {
	return getLength() * getWidth() * getHeight();
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
