
public class ThreeDimensionalShape extends Shape {
    static final String CLASS_NAME = "2D Shape";
    private double dimension1;
    private double dimension2;
    private double dimension3;
    
    //ThreeDimensionalShape 클래스의 디폴틑 생성자
    public ThreeDimensionalShape() {
	
    }
    
    /*
     * ThreeDimensionalShape 클래스의 생성자
     * name과 dimension1, dimension2, dimension3를 초기화한다.
     * name은 부모 클래스의 생성자에서 초기화한다.
     */
    public ThreeDimensionalShape(String name, double d1, double d2, double d3) {
	super(name);
	this.dimension1 = d1;
	this.dimension2 = d2;
	this.dimension3 = d3;
    }

    //dimension1의 값을 반환하는 메소드
    public double getDimension1() {
        return dimension1;
    }

    //dimension1의 값을 설정하는 메소드
    public void setDimension1(double dimension1) {
        this.dimension1 = dimension1;
    }

    //dimension2의 값을 반환하는 메소드
    public double getDimension2() {
        return dimension2;
    }

    //dimension2의 값을 설정하는 메소드
    public void setDimension2(double dimension2) {
        this.dimension2 = dimension2;
    }

    //dimension3의 값을 반환하는 메소드
    public double getDimension3() {
        return dimension3;
    }

    //dimension3의 값을 설정하는 메소드
    public void setDimension3(double dimension3) {
        this.dimension3 = dimension3;
    }

    //CLASS_NAME의 값을 반환하는 메소드
    public static String getClassName() {
        return CLASS_NAME;
    }

    /*
     * name의 값을 반환하는 메소드
     * 부모 클래스의 getName 메소드를 이용해 반환한다.
     */
    public String getName() {
        return super.getName();
    }
    
    /*
     * 도형의 부피를 계산해서 반환하는 함수
     * 디폴트값으로 0을 반환한다.
     */
    public double getVolume() {
	return 0;
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
