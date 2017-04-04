
public class RectangularPrism extends ThreeDimensionalShape {
    static final String CLASS_NAME = "Rectangular Prism";

    /*
     * RectangularPrism 클래스의 생성자
     * name, length, width, height의 값을 초기화한다.
     * 부모 클래스의 생성자를 통해 초기화한다.
     */
    public RectangularPrism(String name, double length, double width, double height) {
	super(name, length, width, height);
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
     * length의 값을 반환하는 메소드
     * 부모클래스의 getDimension1 메소드를 이용해서 반환한다.
     */    
    public double getLength() {
	return super.getDimension1();
    }

    /*
     * width의 값을 반환하는 메소드
     * 부모클래스의 getDimension2 메소드를 이용해서 반환한다.
     */    
    public double getWidth() {
	return super.getDimension2();
    }
    
    /*
     * height의 값을 반환하는 메소드
     * 부모클래스의 getDimension3 메소드를 이용해서 반환한다.
     */
    public double getHeight() {
	return super.getDimension3();
    }
    
    /*
     * length와 width, height의 값을 설정하는 메소드
     * 부모클래스의 setDimension1, setDimension2, setDimension2 메소드를 이용해서 설정한다.
     */
    public void setSize(double l, double w, double h) {
	super.setDimension1(l);
	super.setDimension2(w);
	super.setDimension3(h);
    }
    
    /*
     * 직육면체의 부피를 구하는 메소드
     * 부모클래스의 메소드를 오버라이드했다.
     * 직육면체의 부피를 구해 반환한다.
     */
    @Override
    public double getVolume() {
	return getLength() * getWidth() * getHeight();
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
