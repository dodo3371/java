
public class Cube extends RectangularPrism {
    static final String CLASS_NAME = "Cube";
    
    /*
     * Cube 클래스의 생성자
     * name과 lengthOfEdge를 초기화한다.
     * 부모클래스의 생성자를 통해서 초기화한다.
     */
    public Cube(String name, double lengthOfEdge) {
	super(name, lengthOfEdge, lengthOfEdge, lengthOfEdge);
    }

    //CLASS_NAME의 값을 반환한다.
    public static String getClassName() {
        return CLASS_NAME;
    }
    
    //부모의 CLASS_NAME의 값을 반환하는 메소드
    public String getParentClassName() {
        return super.getClassName();
    }

    /*
     * 정육면체의 한변의 길이를 반환하는 메소드
     * 부모의 부모클래스의 getDimension1을 이용해 반환한다.
     */
    public double getSide() {
	return super.getDimension1();
    }
    
    /*
     * 정육면체의 한변의 길이를 설정하는 메소드
     * 부모의 부모클래스의 setDimension1, setDimension2를 이용해 설정한다.
     */
    public void setSide(double lengthOfEdge) {
	super.setDimension1(lengthOfEdge);
	super.setDimension2(lengthOfEdge);
	super.setDimension2(lengthOfEdge);	
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
