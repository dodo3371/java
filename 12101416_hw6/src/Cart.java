
/*
 * Cart 인터페이스
 * 아이템을 추가하는 메소드와 영수증을 출력하는 메소드가 있다.
 */
public interface Cart {
    void addItem(Item i);

    void printReceipt();
}
