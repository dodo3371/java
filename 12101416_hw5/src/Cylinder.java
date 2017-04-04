
public class Cylinder extends ThreeDimensionalShape {
    static final String CLASS_NAME = "Cylinder";
    Circle circularFace;
    
    public Cylinder(String name, double radiusOfCircularFace, double length) {
	super(name, radiusOfCircularFace, length, 0);
	circularFace = new Circle(name, radiusOfCircularFace);
    }
    
    //CLASS_NAME의 값을 반환하는 메소드
    public static String getClassName() {
        return CLASS_NAME;
    }

    //부모의 CLASS_NAME의 값을 반환하는 메소드
    public String getParentClassName() {
        return super.getClassName();
    }

    /*
     * radius의 값을 반환하는 메소드
     * circularFace 객체의  getRadius 메소드를 이용해 반환한다.
     */
    public double getRadius() {
	return circularFace.getRadius();
    }

    /*
     * height의 값을 반환하는 메소드
     * 부모클래스의 getDimension2 메소드를 이용해서 반환한다.
     */
    public double getHeight() {
	return super.getDimension2();
    }

    /*
     * radiusOfCircularFace의 값을 설정하는 메소드
     * circularFace 객체의  setRadius 메소드를 이용해 설정한다.
     */
    public void setRadius(double radiusOfCircularFace) {
	circularFace.setRadius(radiusOfCircularFace);
    }

    /*
     * height의 값을 설정하는 메소드
     * 부모클래스의 getDimension2 메소드를 이용해서 설정한다.
     */
    public void setHeight(double height) {
	super.setDimension2(height);
    }

    /*
     * 밑면의 지름을 계산해서 반환하는 메소드
     * circularFace 객체의 getDiameter 메소드를 이용해 지름을 구한다.
     */
    public double getDiameter() {
	return circularFace.getDiameter();
    }
    
    /*
     * 밑면의 지름을 설정하는 메소드
     * circularFace 객체의 getDiameter 메소드를 이용해 지름을 설정한다.
     */
    public void setDiameter(double diameterOfCirularFace) {
	circularFace.setDiameter(diameterOfCirularFace / 2);
    }
    
    /*
     * 원기둥의 부피를 구하는 메소드
     * 부모클래스의 메소드를 오버라이드했다.
     * 원기둥의 부피를 구해 반환한다.
     */
    @Override
    public double getVolume() {
	return circularFace.getArea() * getHeight();
    }
    
    /*
     * 도형의 이름을 반환하는 메소드
     * 부모클래스의 메소드를 오버라이드했다.
     */
    @Override
    public String toString() {
	return getClassName();
    }
}
