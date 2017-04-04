
public class FractionTest {

    public static void main(String[] args) {
	Fraction frFrac1 = new Fraction(1, 2);
	Fraction frFrac2 = new Fraction(2, 5);
	
	System.out.print("First fraction is: ");
	frFrac1.printFraction();
	System.out.print("Second fraction is: ");
	frFrac2.printFraction();
	System.out.print("Result of addition is: ");
	frFrac1.add(frFrac2).printFraction();
	System.out.print("Result of subtraction is: ");
	frFrac1.subtract(frFrac2).printFraction();
	System.out.print("Result of multiplication is: ");
	frFrac1.multiply(frFrac2).printFraction();
	System.out.print("Result of division is: ");
	frFrac1.divide(frFrac2).printFraction();	
    }
}
