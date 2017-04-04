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
    //�� ��ư�� ������ ���� ��Ƶ� String�迭
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
	//txt_display�� �����ϰ� �����������Ѵ�.
	txt_display = new JTextField();
	txt_display.setHorizontalAlignment(JTextField.RIGHT);
	
	//pnl_list�� �����ϰ� ũ�⸦ �����Ѵ�.
	pnl_list = new JPanel();
	FlowLayout flowLayout = (FlowLayout) pnl_list.getLayout();
	flowLayout.setHgap(70);
	pnl_list.setBackground(Color.WHITE);
	
	pnl_result.add(txt_display);
	
	pnl_btn = new JPanel(new GridLayout(4, 5));
	btn_arr = new JButton[str_btn.length];
	
	//btn_arr�迭�� ��ư���� �����ϰ� ActionListener�� �߰��Ѵ�.
	for(int i = 0; i < str_btn.length; ++i) {
	    btn_arr[i] = new JButton(str_btn[i]);
	    pnl_btn.add(btn_arr[i]);
	    btn_arr[i].addActionListener(this);
	}
	
	//frame�� pnl_result, pnl_btn, pnl_list�� �߰��Ѵ�.
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
		 * ����Ű�� ������ ��, txt_display�޼ҵ带 �����ϰ�,
		 * ��������� txt_display�� �ʱ�ȭ�Ѵ�.
		 */
		if (c >= '0' && c <= '9') {
		    txt_display.setText(setNumber(str));
		    e.consume();
		    /*
		     * operatorŰ�� ������ �� setOperator�޼ҵ带 �����Ѵ�.
		     */
		} else if (c == '+' || c == '-' || c == '*' || c == '/'){
		    setOperator(str);
		    e.consume();
		    /*
		     * enterŰ�� ������ �� num1, num2, operator�� ����� ������ doMath�޼ҵ带 �����ϰ�,
		     * �� ��������� txt_display�� �ʱ�ȭ�Ѵ�.
		     * �׸��� listData�� =�� �߰��Ѵ�.
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
	 * �Է¹��� ���ڿ� operator�� �����ϴ� JList ����
	 * �Է¹��� String�����͸� int������ ��ȯ �� txt_display�� �����ش�.
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
     * �� ���� ����ϴ� �޼ҵ�
     * num1�� num2�� op�� ����� operator�� �̿��� ������ �Ѵ�.
     * ����� ������� ��ȯ�Ѵ�.
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
     * num1, num2�� ���� �����ϴ� �޼ҵ�
     * num1�� ���� NONE�̸� num���� �����ϰ�,
     * num1�� ���� NONE�� �ƴ����� operator���� NONE�̸� num1�� num�� �߰��ϰ�,
     * operator�� ���� NONE�� �ƴ����� num2���� NONE�̸� num2�� num�� �����ϰ�,
     * num2�� ���� NONE�� �ƴ϶�� num2�� num�� �߰��Ѵ�.
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
     * operator���� �����ϴ� �޼ҵ�
     * operator���� NONE�̸� op���� �����ϰ�,
     * operator���� NONE�� �ƴ����� num2�� ���� NONE�̸� operator���� op������ �ʱ�ȭ�ϰ�,
     * num2�� ���� NONE�� �ƴϸ� num1, num2, operator�� ����� ������ doMath�޼ҵ带 �����ϰ�
     * ������� num1�� �����ϰ� num2�� operator�� NONE���� �ʱ�ȭ�Ѵ�.
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
	 * ���� ��ư�� ������ �� setNumber�޼ҵ带 �����ϰ�
	 * �� ��������� txt_display���� �ʱ�ȭ�Ѵ�.
	 */
	if (s.compareToIgnoreCase("0") >= 0 && s.compareToIgnoreCase("9") <= 0) {
		txt_display.setText(setNumber(s));
	}
	/*
	 * operator ��ư�� ������ �� setOperator�޼ҵ带 �����Ѵ�.
	 */
	else if (s.equals("+") || s.equals("-") || s.equals("x")|| s.equals("/")) { 	
		setOperator(s);
	}
	/*
	 * = ��ư�� ������ �� num1, num2, operator�� ����� ������ doMath�޼ҵ带 �����ϰ�
	 * ������� num1�� �����ϰ�, num2, operator�� NONE���� �ʱ�ȭ�Ѵ�.
	 * listData�� =��  �߰��ϰ�, txt_display�� ���� num1���� �ʱ�ȭ�Ѵ�.
	 */
	else if(s.equals("=")) {
		num1 = doMath(num1, operator, num2);
		operator = NONE;
		num2 = NONE;
		listData.addElement("=");
		txt_display.setText(num1);
	}
	/*
	 * CE ��ư�� ������ �� num2�� ���� NONE�� �ƴϸ� num2�� ���� NONE���� �ʱ�ȭ�ϰ�,
	 * num1�� ���� NONE�� �ƴϸ� num1�� ���� NONE���� �ʱ�ȭ�Ѵ�.
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
	 * C��ư�� ������ �� num1, num2, operator�� NONE���� �ʱ�ȭ ��,
	 * txt_display�� clear�Ѵ�.
	 * listData�� ����� ������ clear�Ѵ�.
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
