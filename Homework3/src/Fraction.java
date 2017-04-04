
public class Fraction {
    private int nNumtr;
    private int nDenumtr;
    
    public Fraction(int nNewNumtr, int nNewDenumtr) {
	nNumtr = nNewNumtr;
	nDenumtr = nNewDenumtr;
    }
    /*
     * 분수를 출력하는 메소드
     */
    void printFraction() {
	System.out.println(nNumtr + "/" + nDenumtr);
    }
    
    /*
     * 두 분수를 더하는 메소드
     * 객체를 파라미터로 넘겨 받아 값을 구한 후,
     * 기약분수로 만들어주고 결과를 가진 객체를 반환한다.
     */
    Fraction add(Fraction frSrc) {
	int nResNumtr = this.nNumtr * frSrc.nDenumtr + this.nDenumtr * frSrc.nNumtr;
	int nResDenumtr = this.nDenumtr * frSrc.nDenumtr;
	Fraction frRes = new Fraction(nResNumtr, nResDenumtr);
	frRes.reduceFraction();
	return frRes;
    }
    
    /*
     * 두 분수의 차를 구하는 메소드
     * 객체를 파라미터로 넘겨 받아 값을 구한 후,
     * 기약분수로 만들어주고 결과를 가진 객체를 반환한다.
     */
    Fraction subtract(Fraction frSrc) {
	int nResNumtr = this.nNumtr * frSrc.nDenumtr - this.nDenumtr * frSrc.nNumtr;
	int nResDenumtr = this.nDenumtr * frSrc.nDenumtr;
	Fraction frRes = new Fraction(nResNumtr, nResDenumtr);
	frRes.reduceFraction();
	return frRes;
    }
    
    /*
     * 두 분수를 곱하는 메소드
     * 객체를 파라미터로 넘겨 받아 값을 구한 후,
     * 기약분수로 만들어주고 결과를 가진 객체를 반환한다.
     */
    Fraction multiply(Fraction frSrc) {
	int nResNumtr = this.nNumtr * frSrc.nNumtr;
	int nResDenumtr = this.nDenumtr * frSrc.nDenumtr;
	Fraction frRes = new Fraction(nResNumtr, nResDenumtr);
	frRes.reduceFraction();
	return frRes;
    }
    
    /*
     * 두 분수를 나누는 메소드
     * 객체를 파라미터로 넘겨 받아 값을 구한 후,
     * 기약분수로 만들어주고 결과를 가진 객체를 반환한다.
     */
    Fraction divide(Fraction frSrc) {
	int nResNumtr = this.nNumtr * frSrc.nDenumtr;
	int nResDenumtr = this.nDenumtr * frSrc.nNumtr;
	Fraction frRes = new Fraction(nResNumtr, nResDenumtr);
	frRes.reduceFraction();
	return frRes;
    }
    
    /*
     * gcd를 구하는 메소드
     */
    int getGcd(int nX, int nY) {
	if(nY == 0) {
	    return nX;
	}
	return getGcd(nY, nX % nY);
    }

    /*
     * 기약분수를 구하는 메소드
     */
    void reduceFraction() {
	int nGcd = getGcd(nNumtr, nDenumtr);
	nNumtr /= nGcd;
	nDenumtr /= nGcd;
    }

}
