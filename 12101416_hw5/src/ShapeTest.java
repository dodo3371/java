
public class ShapeTest {
    public static void main(String[] args) {
	//각 도형의 객체를 생성한다.
	Circle cir1 = new Circle("Cir One", 3.0);
	Rectangle rec1 = new Rectangle("Rec One", 3.0, 4.0);
	Square sq1 = new Square("Square One", 6.0);
	Cube cb1 = new Cube("Cube One", 5.0);
	RectangularPrism recPrism1 = new RectangularPrism("recPrism One", 2.0, 3.0, 5.0);
	Cylinder cyl1 = new Cylinder("Cylinder One", 5.0, 4.0);
	Cone cn1 = new Cone("Cone One", 2.0, 5.0);
	Sphere sph1 = new Sphere("Sphere One", 3.0);	
	
	System.out.println("Eight shapes have been created:");

	// 생성한 각 도형의 정보를 출력한다.
	System.out.printf("1. %s is a , [%s] and is a [%s]\n",
		cir1.getName(), cir1.toString(), cir1.getParentClassName());
	System.out.printf( "%s's area is %.2f, radius is %.2f\n", 
		cir1.getName(), cir1.getArea(), cir1.getRadius());
	
	System.out.printf("2. %s is a , [%s] and is a [%s]\n",
		rec1.getName(), rec1.toString(), rec1.getParentClassName());
	System.out.printf( "%s's area is %.2f, width is %.2f, height is %.2f\n", 
		rec1.getName(), rec1.getArea(), rec1.getWidth(), rec1.getHeight());

	System.out.printf("3. %s is a , [%s] and is a [%s]\n",
		sq1.getName(), sq1.toString(), sq1.getParentClassName());
	System.out.printf( "%s's area is %.2f, side is %.2f\n", 
		sq1.getName(), sq1.getArea(), sq1.getSide());

	System.out.printf("4. %s is a , [%s] and is a [%s]\n",
		cb1.getName(), cb1.toString(), cb1.getParentClassName());
	System.out.printf( "%s's volume is %.2f, side is %.2f\n", 
		cb1.getName(), cb1.getVolume(), cb1.getSide());

	System.out.printf("5. %s is a , [%s] and is a [%s]\n",
		recPrism1.getName(), recPrism1.toString(), recPrism1.getParentClassName());
	System.out.printf( "%s's volume is %.2f, length is %.2f, width is %.2f, height is %.2f\n", 
		recPrism1.getName(), recPrism1.getVolume(), recPrism1.getLength(), recPrism1.getWidth(), recPrism1.getHeight());

	System.out.printf("6. %s is a , [%s] and is a [%s]\n",
		cyl1.getName(), cyl1.toString(), cyl1.getParentClassName());
	System.out.printf( "%s's volume is %.2f, heigth is %.2f, radius is %.2f\n", 
		cyl1.getName(), cyl1.getVolume(), cyl1.getHeight(), cyl1.getRadius());

	System.out.printf("7. %s is a , [%s] and is a [%s]\n",
		cn1.getName(), cn1.toString(), cn1.getParentClassName());
	System.out.printf( "%s's volume is %.2f, heigth is %.2f, radius is %.2f\n", 
		cn1.getName(), cn1.getVolume(), cn1.getHeight(), cn1.getRadius());

	System.out.printf("8. %s is a , [%s] and is a [%s]\n",
		sph1.getName(), sph1.toString(), sph1.getParentClassName());
	System.out.printf( "%s's volume is %.2f, radius is %.2f\n", 
		sph1.getName(), sph1.getVolume(), sph1.getRadius());

    }
}
