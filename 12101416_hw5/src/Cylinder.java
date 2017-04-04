
public class Cylinder extends ThreeDimensionalShape {
    static final String CLASS_NAME = "Cylinder";
    Circle circularFace;
    
    public Cylinder(String name, double radiusOfCircularFace, double length) {
	super(name, radiusOfCircularFace, length, 0);
	circularFace = new Circle(name, radiusOfCircularFace);
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
     * circularFace ��ü��  getRadius �޼ҵ带 �̿��� ��ȯ�Ѵ�.
     */
    public double getRadius() {
	return circularFace.getRadius();
    }

    /*
     * height�� ���� ��ȯ�ϴ� �޼ҵ�
     * �θ�Ŭ������ getDimension2 �޼ҵ带 �̿��ؼ� ��ȯ�Ѵ�.
     */
    public double getHeight() {
	return super.getDimension2();
    }

    /*
     * radiusOfCircularFace�� ���� �����ϴ� �޼ҵ�
     * circularFace ��ü��  setRadius �޼ҵ带 �̿��� �����Ѵ�.
     */
    public void setRadius(double radiusOfCircularFace) {
	circularFace.setRadius(radiusOfCircularFace);
    }

    /*
     * height�� ���� �����ϴ� �޼ҵ�
     * �θ�Ŭ������ getDimension2 �޼ҵ带 �̿��ؼ� �����Ѵ�.
     */
    public void setHeight(double height) {
	super.setDimension2(height);
    }

    /*
     * �ظ��� ������ ����ؼ� ��ȯ�ϴ� �޼ҵ�
     * circularFace ��ü�� getDiameter �޼ҵ带 �̿��� ������ ���Ѵ�.
     */
    public double getDiameter() {
	return circularFace.getDiameter();
    }
    
    /*
     * �ظ��� ������ �����ϴ� �޼ҵ�
     * circularFace ��ü�� getDiameter �޼ҵ带 �̿��� ������ �����Ѵ�.
     */
    public void setDiameter(double diameterOfCirularFace) {
	circularFace.setDiameter(diameterOfCirularFace / 2);
    }
    
    /*
     * ������� ���Ǹ� ���ϴ� �޼ҵ�
     * �θ�Ŭ������ �޼ҵ带 �������̵��ߴ�.
     * ������� ���Ǹ� ���� ��ȯ�Ѵ�.
     */
    @Override
    public double getVolume() {
	return circularFace.getArea() * getHeight();
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
