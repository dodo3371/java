import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Calculator extends JFrame implements ActionListener {

    public final String NONE = "none"; 
    private String num1;
    private String num2;
    private String operator;
    private DefaultListModel<String> listData;
    
    JPanel pnl_result;
    JPanel pnl_btn;
    JPanel pnl_list;
        
    JTextField txt_display;
    JList lst_result;
    
    JButton[] btn_arr;
    //각 버튼에 저장할 값을 모아둔 String배열
    String[] str_btn = {"7", "8", "9", "+", "C",
			"4", "5", "6", "-", "CE",
			"1", "2", "3", "x", "M",
			"0", ".", "=", "/", "MC"};
    
    /**
     * Create the frame.
     */
    public Calculator() {
	super("Calculator");
	
	num1 = NONE;
	num2 = NONE;
	operator = NONE;
	listData = new DefaultListModel();
	
	getContentPane().setLayout(new BorderLayout());
	pnl_result = new JPanel(new BorderLayout());
	pnl_result.setBackground(Color.WHITE);
	//txt_display를 생성하고 오른쪽정렬한다.
	txt_display = new JTextField();
	txt_display.setHorizontalAlignment(JTextField.RIGHT);
	
	//pnl_list을 생성하고 크기를 조정한다.
	pnl_list = new JPanel();
	FlowLayout flowLayout = (FlowLayout) pnl_list.getLayout();
	flowLayout.setHgap(70);
	pnl_list.setBackground(Color.WHITE);
	
	pnl_result.add(txt_display);
	
	pnl_btn = new JPanel(new GridLayout(4, 5));
	btn_arr = new JButton[str_btn.length];
	
	//btn_arr배열의 버튼들을 생성하고 ActionListener를 추가한다.
	for(int i = 0; i < str_btn.length; ++i) {
	    btn_arr[i] = new JButton(str_btn[i]);
	    pnl_btn.add(btn_arr[i]);
	    btn_arr[i].addActionListener(this);
	}
	
	//frame에 pnl_result, pnl_btn, pnl_list를 추가한다.
	getContentPane().add("North", pnl_result);
	getContentPane().add("Center", pnl_btn);
	getContentPane().add("East", pnl_list);
	setSize(600, 400);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	txt_display.addKeyListener(new KeyListener() {
	    
	    @Override
	    public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		String str = new Character(c).toString();
		/*
		 * 숫자키를 눌렀을 떄, txt_display메소드를 실행하고,
		 * 결과값으로 txt_display를 초기화한다.
		 */
		if (c >= '0' && c <= '9') {
		    txt_display.setText(setNumber(str));
		    e.consume();
		    /*
		     * operator키를 눌렀을 때 setOperator메소드를 실행한다.
		     */
		} else if (c == '+' || c == '-' || c == '*' || c == '/'){
		    setOperator(str);
		    e.consume();
		    /*
		     * enter키를 눌렀을 때 num1, num2, operator에 저장된 값으로 doMath메소드를 실행하고,
		     * 그 결과값으로 txt_display를 초기화한다.
		     * 그리고 listData에 =을 추가한다.
		     */
		    
		}else if (c == KeyEvent.VK_ENTER){
			num1 = doMath(num1, operator, num2);
			operator = NONE;
			num2 = NONE;
			listData.addElement("=");
			txt_display.setText(num1);
		}else {
		    e.consume();
		}
	    }
	    
	    @Override
	    public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	    }
	    
	    @Override
	    public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	    }
	});
	
	/*
	 * 입력받은 숫자와 operator를 저장하는 JList 생성
	 * 입력받은 String데이터를 int형으로 변환 후 txt_display에 보여준다.
	 */
	lst_result = new JList(listData);
	lst_result.addListSelectionListener(new ListSelectionListener() {
	    
	    @Override
	    public void valueChanged(ListSelectionEvent arg0) {
		// get the object on which the event occurred 
		JList lst = (JList)arg0.getSource();
		try {
			// try to convert to integer
			String str = listData.getElementAt(lst.getSelectedIndex());
			Integer.parseInt(str); 
			txt_display.setText(str);
		}catch (NumberFormatException  e){
			// do nothing
		}
	    }
	});
	pnl_list.add(lst_result);
    }

    /*
     * 두 수를 계산하는 메소드
     * num1과 num2를 op에 저장된 operator를 이용해 연산을 한다.
     * 계산한 결과값을 반환한다.
     */
    private String doMath(String num1, String op, String num2) {
	int number1 = Integer.parseInt(num1);
	int number2 = Integer.parseInt(num2);
	
	switch(op) {
	case "+":
	    number1 += number2;
	    break;
	case "-":
	    number1 -= number2;
	    break;
	case "*":
	    number1 *= number2;
	    break;
	case "/":
	    number1 /= number2;
	    break;
	}
	return("" + number1);
    }
    
    /*
     * num1, num2의 값을 설정하는 메소드
     * num1의 값이 NONE이면 num값을 저장하고,
     * num1의 값이 NONE이 아니지만 operator값이 NONE이면 num1에 num을 추가하고,
     * operator의 값도 NONE이 아니지만 num2값이 NONE이면 num2에 num을 저장하고,
     * num2의 값도 NONE이 아니라면 num2에 num을 추가한다.
     */
    private String setNumber(String num) {
	if(num1 == NONE) {
	    num1 = num;
	    return num1;
	}
	else if(operator == NONE) {
	    num1 += num;
	    return num1;
	}
	else if(num2 == NONE) {
	    num2 = num;
	    listData.addElement(operator);
	    return num2;
	}
	else {
	    num2 += num;
	    return num2;
	}
    }
    
    /*
     * operator값을 설정하는 메소드
     * operator값이 NONE이면 op값을 저장하고,
     * operator값이 NONE이 아니지만 num2의 값이 NONE이면 operator값을 op값으로 초기화하고,
     * num2의 값도 NONE이 아니면 num1, num2, operator에 저장된 값으로 doMath메소드를 실행하고
     * 결과값을 num1에 저장하고 num2와 operator는 NONE으로 초기화한다.
     */
    private void setOperator(String op) {
	if(operator == NONE) {
	    listData.addElement(num1);
	    operator = op;
	}
	else if(num2 == NONE) {
	    operator = op;	    
	}
	else if(num2 != NONE) {
	    num1 = doMath(num1, operator, num2);
	    num2 = NONE;
	    operator = op;
	}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	String s = e.getActionCommand();
	/*
	 * 숫자 버튼을 눌렀을 때 setNumber메소드를 실행하고
	 * 그 결과값으로 txt_display값을 초기화한다.
	 */
	if (s.compareToIgnoreCase("0") >= 0 && s.compareToIgnoreCase("9") <= 0) {
		txt_display.setText(setNumber(s));
	}
	/*
	 * operator 버튼을 눌렀을 때 setOperator메소드를 실행한다.
	 */
	else if (s.equals("+") || s.equals("-") || s.equals("x")|| s.equals("/")) { 	
		setOperator(s);
	}
	/*
	 * = 버튼을 눌렀을 때 num1, num2, operator에 저장된 값으로 doMath메소드를 실행하고
	 * 결과값을 num1에 저장하고, num2, operator는 NONE으로 초기화한다.
	 * listData에 =을  추가하고, txt_display의 값을 num1으로 초기화한다.
	 */
	else if(s.equals("=")) {
		num1 = doMath(num1, operator, num2);
		operator = NONE;
		num2 = NONE;
		listData.addElement("=");
		txt_display.setText(num1);
	}
	/*
	 * CE 버튼을 눌렀을 때 num2의 값이 NONE이 아니면 num2의 값을 NONE으로 초기화하고,
	 * num1의 값이 NONE이 아니면 num1의 값을 NONE으로 초기화한다.
	 */
	else if(s.equals("CE")) {
	    if(num2 != NONE) {
		num2 = NONE;
	    }
	    else if(num1 != NONE) {
		num1 = NONE;
	    }
	}
	/*
	 * C버튼을 눌렀을 때 num1, num2, operator를 NONE으로 초기화 후,
	 * txt_display를 clear한다.
	 * listData에 저장된 정보도 clear한다.
	 */
	else if(s.equals("C")) {
		num1 = NONE;
		num2 = NONE;
		operator = NONE;
		listData.clear();
		txt_display.setText("");
	}
    }
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	Calculator test = new Calculator();
    }
}
