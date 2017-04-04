
public class Fraction {
    private int nNumtr;
    private int nDenumtr;
    
    public Fraction(int nNewNumtr, int nNewDenumtr) {
	nNumtr = nNewNumtr;
	nDenumtr = nNewDenumtr;
    }
    /*
     * �м��� ����ϴ� �޼ҵ�
     */
    void printFraction() {
	System.out.println(nNumtr + "/" + nDenumtr);
    }
    
    /*
     * �� �м��� ���ϴ� �޼ҵ�
     * ��ü�� �Ķ���ͷ� �Ѱ� �޾� ���� ���� ��,
     * ���м��� ������ְ� ����� ���� ��ü�� ��ȯ�Ѵ�.
     */
    Fraction add(Fraction frSrc) {
	int nResNumtr = this.nNumtr * frSrc.nDenumtr + this.nDenumtr * frSrc.nNumtr;
	int nResDenumtr = this.nDenumtr * frSrc.nDenumtr;
	Fraction frRes = new Fraction(nResNumtr, nResDenumtr);
	frRes.reduceFraction();
	return frRes;
    }
    
    /*
     * �� �м��� ���� ���ϴ� �޼ҵ�
     * ��ü�� �Ķ���ͷ� �Ѱ� �޾� ���� ���� ��,
     * ���м��� ������ְ� ����� ���� ��ü�� ��ȯ�Ѵ�.
     */
    Fraction subtract(Fraction frSrc) {
	int nResNumtr = this.nNumtr * frSrc.nDenumtr - this.nDenumtr * frSrc.nNumtr;
	int nResDenumtr = this.nDenumtr * frSrc.nDenumtr;
	Fraction frRes = new Fraction(nResNumtr, nResDenumtr);
	frRes.reduceFraction();
	return frRes;
    }
    
    /*
     * �� �м��� ���ϴ� �޼ҵ�
     * ��ü�� �Ķ���ͷ� �Ѱ� �޾� ���� ���� ��,
     * ���м��� ������ְ� ����� ���� ��ü�� ��ȯ�Ѵ�.
     */
    Fraction multiply(Fraction frSrc) {
	int nResNumtr = this.nNumtr * frSrc.nNumtr;
	int nResDenumtr = this.nDenumtr * frSrc.nDenumtr;
	Fraction frRes = new Fraction(nResNumtr, nResDenumtr);
	frRes.reduceFraction();
	return frRes;
    }
    
    /*
     * �� �м��� ������ �޼ҵ�
     * ��ü�� �Ķ���ͷ� �Ѱ� �޾� ���� ���� ��,
     * ���м��� ������ְ� ����� ���� ��ü�� ��ȯ�Ѵ�.
     */
    Fraction divide(Fraction frSrc) {
	int nResNumtr = this.nNumtr * frSrc.nDenumtr;
	int nResDenumtr = this.nDenumtr * frSrc.nNumtr;
	Fraction frRes = new Fraction(nResNumtr, nResDenumtr);
	frRes.reduceFraction();
	return frRes;
    }
    
    /*
     * gcd�� ���ϴ� �޼ҵ�
     */
    int getGcd(int nX, int nY) {
	if(nY == 0) {
	    return nX;
	}
	return getGcd(nY, nX % nY);
    }

    /*
     * ���м��� ���ϴ� �޼ҵ�
     */
    void reduceFraction() {
	int nGcd = getGcd(nNumtr, nDenumtr);
	nNumtr /= nGcd;
	nDenumtr /= nGcd;
    }

}
