
public class Rectangle extends TwoDimensionalShape {
    static final String CLASS_NAME = "Rectangle";

    /*
     * Rectangle 클래스의 생성자
     * name, width, height의 값을 초기화한다.
     * 부모 클래스의 생성자를 통해 초기화한다.
     */
    public Rectangle(String name, double width, double height) {
	super(name, width, height);
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
     * width의 값을 반환하는 메소드
     * 부모클래스의 getDimension1 메소드를 이용해서 반환한다.
     */
    
    public double getWidth() {
	return super.getDimension1();
    }
    
    /*
     * height의 값을 반환하는 메소드
     * 부모클래스의 getDimension2 메소드를 이용해서 반환한다.
     */
    public double getHeight() {
	return super.getDimension2();
    }
    
    /*
     * width와 height의 값을 설정하는 메소드
     * 부모클래스의 setDimension1, setDimension2 메소드를 이용해서 설정한다.
     */
    public void setSize(double w, double h) {
	super.setDimension1(w);
	super.setDimension2(h);
    }
    
    /*
     * 직사각형의 넓이를 구하는 메소드
     * 부모클래스의 메소드를 오버라이드했다.
     * 직사각형의 넓이를 구해 반환한다.
     */
    @Override
    public double getArea() {
	return getWidth() * getHeight();
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
