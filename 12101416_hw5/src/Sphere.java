
public class Sphere extends ThreeDimensionalShape {
    static final String CLASS_NAME = "Sphere";

    /*
     * Sphere Ŭ������ ������
     * name, radius�� ���� �ʱ�ȭ�Ѵ�.
     * �θ�Ŭ������ �����ڸ� ���ؼ� �ʱ�ȭ�Ѵ�.
     * ���� ���, dimension�� ���� �ϳ��ۿ� ���� ������,
     * dimension2, dimension3�� ���� 0���� �Ѱ��ش�.
     */
    public Sphere(String name, double radius) {
	super(name, radius, 0, 0);
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
     * radius�� ���� ��ȯ�ϴ� �޼ҵ�
     * �θ�Ŭ������ getDimension1 �޼ҵ带 �̿��� ��ȯ�Ѵ�.
     */
    public double getRadius() {
	return super.getDimension1();
    }
    
    /*
     * radius�� ���� �����ϴ� �޼ҵ�
     * �θ�Ŭ������ setDimension1 �޼ҵ带 �̿��� �����Ѵ�.
     */
    public void setRadius(double radius) {
	super.setDimension1(radius);
    }
    
    /*
     * ���� ������ ����ؼ� ��ȯ�ϴ� �޼ҵ�
     * �θ�Ŭ������ getDimension1 �޼ҵ带 �̿��� ������ ���Ѵ�.
     */
    public double getDiameter() {
	return super.getDimension1() * 2;
    }
    
    /*
     * ���� ������ �����ϴ� �޼ҵ�
     * �θ�Ŭ������ setDimension1 �޼ҵ带 �̿��� �����Ѵ�.
     */
    public void setDiameter(double diameter) {
	super.setDimension1(diameter / 2);
    }
    
    /*
     * ���� ���Ǹ� ���ϴ� �޼ҵ�
     * �θ�Ŭ������ �޼ҵ带 �������̵��ߴ�.
     * ���� ���Ǹ� ���� ��ȯ�Ѵ�.
     */
    @Override
    public double getVolume() {
	return 4 / 3 * getRadius() * getRadius() * getRadius() * Math.PI;
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
