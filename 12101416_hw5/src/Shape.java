
public class Shape {
    static final String CLASS_NAME = "Shape";
    private String name;

    //Shape Ŭ������ ����Ʈ ������
    public Shape() {
	
    }
    
    /*
     * Shape Ŭ������ ������
     * �̸��� �Ű������� �޾Ƽ� �ɹ����� name�� �ʱ�ȭ �Ѵ�.
     */
    public Shape(String name) {
	this.name = name;
    }

    //CLASS_NAME�� ��ȯ�ϴ� �޼ҵ�
    public static String getClassName() {
        return CLASS_NAME;
    }

    //name�� ��ȯ�ϴ� �޼ҵ�
    public String getName() {
        return name;
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
