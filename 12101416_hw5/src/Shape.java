
public class Shape {
    static final String CLASS_NAME = "Shape";
    private String name;

    //Shape 클래스의 디폴트 생성자
    public Shape() {
	
    }
    
    /*
     * Shape 클래스의 생성자
     * 이름을 매개변수로 받아서 맴버변수 name을 초기화 한다.
     */
    public Shape(String name) {
	this.name = name;
    }

    //CLASS_NAME을 반환하는 메소드
    public static String getClassName() {
        return CLASS_NAME;
    }

    //name을 반환하는 메소드
    public String getName() {
        return name;
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
