
public class ThreeDimensionalShape extends Shape {
    static final String CLASS_NAME = "2D Shape";
    private double dimension1;
    private double dimension2;
    private double dimension3;
    
    //ThreeDimensionalShape Ŭ������ �����z ������
    public ThreeDimensionalShape() {
	
    }
    
    /*
     * ThreeDimensionalShape Ŭ������ ������
     * name�� dimension1, dimension2, dimension3�� �ʱ�ȭ�Ѵ�.
     * name�� �θ� Ŭ������ �����ڿ��� �ʱ�ȭ�Ѵ�.
     */
    public ThreeDimensionalShape(String name, double d1, double d2, double d3) {
	super(name);
	this.dimension1 = d1;
	this.dimension2 = d2;
	this.dimension3 = d3;
    }

    //dimension1�� ���� ��ȯ�ϴ� �޼ҵ�
    public double getDimension1() {
        return dimension1;
    }

    //dimension1�� ���� �����ϴ� �޼ҵ�
    public void setDimension1(double dimension1) {
        this.dimension1 = dimension1;
    }

    //dimension2�� ���� ��ȯ�ϴ� �޼ҵ�
    public double getDimension2() {
        return dimension2;
    }

    //dimension2�� ���� �����ϴ� �޼ҵ�
    public void setDimension2(double dimension2) {
        this.dimension2 = dimension2;
    }

    //dimension3�� ���� ��ȯ�ϴ� �޼ҵ�
    public double getDimension3() {
        return dimension3;
    }

    //dimension3�� ���� �����ϴ� �޼ҵ�
    public void setDimension3(double dimension3) {
        this.dimension3 = dimension3;
    }

    //CLASS_NAME�� ���� ��ȯ�ϴ� �޼ҵ�
    public static String getClassName() {
        return CLASS_NAME;
    }

    /*
     * name�� ���� ��ȯ�ϴ� �޼ҵ�
     * �θ� Ŭ������ getName �޼ҵ带 �̿��� ��ȯ�Ѵ�.
     */
    public String getName() {
        return super.getName();
    }
    
    /*
     * ������ ���Ǹ� ����ؼ� ��ȯ�ϴ� �Լ�
     * ����Ʈ������ 0�� ��ȯ�Ѵ�.
     */
    public double getVolume() {
	return 0;
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
