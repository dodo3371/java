
public class Cube extends RectangularPrism {
    static final String CLASS_NAME = "Cube";
    
    /*
     * Cube Ŭ������ ������
     * name�� lengthOfEdge�� �ʱ�ȭ�Ѵ�.
     * �θ�Ŭ������ �����ڸ� ���ؼ� �ʱ�ȭ�Ѵ�.
     */
    public Cube(String name, double lengthOfEdge) {
	super(name, lengthOfEdge, lengthOfEdge, lengthOfEdge);
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
     * ������ü�� �Ѻ��� ���̸� ��ȯ�ϴ� �޼ҵ�
     * �θ��� �θ�Ŭ������ getDimension1�� �̿��� ��ȯ�Ѵ�.
     */
    public double getSide() {
	return super.getDimension1();
    }
    
    /*
     * ������ü�� �Ѻ��� ���̸� �����ϴ� �޼ҵ�
     * �θ��� �θ�Ŭ������ setDimension1, setDimension2�� �̿��� �����Ѵ�.
     */
    public void setSide(double lengthOfEdge) {
	super.setDimension1(lengthOfEdge);
	super.setDimension2(lengthOfEdge);
	super.setDimension2(lengthOfEdge);	
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
