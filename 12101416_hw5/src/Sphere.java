
public class Sphere extends ThreeDimensionalShape {
    static final String CLASS_NAME = "Sphere";

    /*
     * Sphere 클래스의 생성자
     * name, radius의 값을 초기화한다.
     * 부모클래스의 생성자를 통해서 초기화한다.
     * 원의 경우, dimension의 값이 하나밖에 없기 때문에,
     * dimension2, dimension3의 값은 0으로 넘겨준다.
     */
    public Sphere(String name, double radius) {
	super(name, radius, 0, 0);
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
     * 부모클래스의 getDimension1 메소드를 이용해 반환한다.
     */
    public double getRadius() {
	return super.getDimension1();
    }
    
    /*
     * radius의 값을 설정하는 메소드
     * 부모클래스의 setDimension1 메소드를 이용해 설정한다.
     */
    public void setRadius(double radius) {
	super.setDimension1(radius);
    }
    
    /*
     * 구의 지름을 계산해서 반환하는 메소드
     * 부모클래스의 getDimension1 메소드를 이용해 지름을 구한다.
     */
    public double getDiameter() {
	return super.getDimension1() * 2;
    }
    
    /*
     * 구의 지름을 설정하는 메소드
     * 부모클래스의 setDimension1 메소드를 이용해 설정한다.
     */
    public void setDiameter(double diameter) {
	super.setDimension1(diameter / 2);
    }
    
    /*
     * 구의 부피를 구하는 메소드
     * 부모클래스의 메소드를 오버라이드했다.
     * 구의 부피를 구해 반환한다.
     */
    @Override
    public double getVolume() {
	return 4 / 3 * getRadius() * getRadius() * getRadius() * Math.PI;
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
