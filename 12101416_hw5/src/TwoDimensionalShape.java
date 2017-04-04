
public class TwoDimensionalShape extends Shape {
    static final String CLASS_NAME = "2D Shape";
    private double dimension1;
    private double dimension2;
    
    //TwoDimensionalShape Ŭ������ �����z ������
    public TwoDimensionalShape() {
	
    }
    
    /*
     * TwoDimensionalShape Ŭ������ ������
     * name�� dimension1, dimension2�� �ʱ�ȭ�Ѵ�.
     * name�� �θ� Ŭ������ �����ڿ��� �ʱ�ȭ�Ѵ�.
     */
    public TwoDimensionalShape(String name, double d1, double d2) {
	super(name);
	this.dimension1 = d1;
	this.dimension2 = d2;
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
     * ������ ���̸� ����ؼ� ��ȯ�ϴ� �Լ�
     * ����Ʈ������ 0�� ��ȯ�Ѵ�.
     */
    public double getArea() {
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
