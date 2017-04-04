
/*
 * 
 * 음수출발,라벨 인덱스아웃,이진수16진수연산,메모리
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class Calculator extends JFrame implements ActionListener, KeyListener, ItemListener {

    public final String NONE = "none";
    private String num1;
    private String num2;
    private String operator;

    // 계산이 끝난 후 num1, num2, operator, 결과값을 저장하는 변수
    private static String res1;
    private static String res2;
    private static String resOp;
    private static String resTotal;

    // 계산 과정들을 저장해두는 문자열
    private String remember = "";

    private JPanel contentPane;
    private JTextField textFieldNorth;
    private JTextField textField;
    private JPanel panel1;
    private JPanel panel2;
    private JRadioButton radioButtonBinary;
    private JRadioButton radioButtonDecimal;
    private JRadioButton radioButtonHexa;
    private JRadioButton radioButtonOctal;
    private JCheckBox checkboxHistory;
    private JCheckBox checkboxConverter;
    private JCheckBox checkboxDateCalc;

    private JLabel[] list_lbl;
    private JButton[] list_btn_num;
    private JButton[] list_btn_op;

    // 각 버튼에 저장할 값을 모아둔 문자열 배열
    private String[] str_btn_num = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
    private String[] str_btn_op = { "/", "XOR", "+/-", "=", "*", "NOT", "MOD", "Bksp", "-", "OR", ">>", "CE", "+",
	    "AND", "<<", "c" };

    // 라디오 버튼들을 모아두는 버튼그룹
    private ButtonGroup btnGroup;

    // Converter클래스와 History클래스, DateCalc클래스의 객체 생성
    private Converter c = new Converter();
    private History h = new History();
    private DateCalc d = new DateCalc();;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Calculator frame = new Calculator();
		    frame.setVisible(true);
		    frame.setResizable(false);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public Calculator() {
	setTitle("Calculator");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 520, 310);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	num1 = NONE;
	num2 = NONE;
	operator = NONE;

	textFieldNorth = new JTextField();
	textFieldNorth.setBounds(15, 10, 485, 21);
	contentPane.add(textFieldNorth);
	textFieldNorth.setColumns(10);
	textFieldNorth.addKeyListener(this);

	textField = new JTextField();
	textField.setBounds(15, 30, 485, 24);
	contentPane.add(textField);
	textField.setColumns(10);
	textField.addKeyListener(this);

	panel1 = new JPanel();
	panel1.setBorder(new LineBorder(Color.LIGHT_GRAY));
	panel1.setBackground(Color.WHITE);
	panel1.setBounds(15, 85, 97, 89);
	contentPane.add(panel1);
	panel1.setLayout(new GridLayout(4, 1));

	radioButtonBinary = new JRadioButton("Binary");
	radioButtonBinary.addItemListener(this);
	panel1.add(radioButtonBinary);

	radioButtonDecimal = new JRadioButton("Decimal");
	radioButtonDecimal.setSelected(true);
	radioButtonDecimal.addItemListener(this);
	panel1.add(radioButtonDecimal);

	radioButtonHexa = new JRadioButton("Hexa");
	radioButtonHexa.addItemListener(this);
	panel1.add(radioButtonHexa);

	radioButtonOctal = new JRadioButton("Octal");
	radioButtonOctal.addItemListener(this);
	panel1.add(radioButtonOctal);

	// 라디오버튼들을 버튼그룹에 모아둔다.
	btnGroup = new ButtonGroup();
	btnGroup.add(radioButtonBinary);
	btnGroup.add(radioButtonDecimal);
	btnGroup.add(radioButtonHexa);
	btnGroup.add(radioButtonOctal);

	// list_lbl의 라벨을 생성하고 0000으로 초기화한다.
	list_lbl = new JLabel[10];
	for (int i = 0; i < 8; ++i) {
	    list_lbl[i] = new JLabel("0000");
	    list_lbl[i].setBounds(15 + 65 * i, 55, 38, 18);
	    contentPane.add(list_lbl[i]);
	}

	panel2 = new JPanel();
	panel2.setBorder(new LineBorder(Color.LIGHT_GRAY));
	panel2.setBounds(15, 175, 97, 90);
	contentPane.add(panel2);
	panel2.setLayout(new GridLayout(3, 1));

	checkboxHistory = new JCheckBox("History");
	checkboxHistory.addItemListener(this);
	panel2.add(checkboxHistory);

	checkboxConverter = new JCheckBox("Converter");
	checkboxConverter.addItemListener(this);
	panel2.add(checkboxConverter);

	checkboxDateCalc = new JCheckBox("DateCalc");
	checkboxDateCalc.addItemListener(this);
	panel2.add(checkboxDateCalc);

	// list_btn_num의 버튼들을 생성하고 ActionListener를 추가한다.
	list_btn_num = new JButton[str_btn_num.length];
	for (int i = 0; i < 4; ++i) {
	    int y = 220;
	    for (int j = 0; j < 4; ++j) {
		int x = 120;
		list_btn_num[i * 4 + j] = new JButton(str_btn_num[i * 4 + j]);
		list_btn_num[i * 4 + j].setBounds(x + 45 * j, y - 45 * i, 42, 42);
		list_btn_num[i * 4 + j].addActionListener(this);
		contentPane.add(list_btn_num[i * 4 + j]);
	    }
	}

	// list_btn_op의 버튼들을 생성하고 ActionListener를 추가한다.
	list_btn_op = new JButton[str_btn_op.length];
	for (int i = 0; i < 4; ++i) {
	    int y = 220;
	    for (int j = 0; j < 4; ++j) {
		int x = 320;
		list_btn_op[i * 4 + j] = new JButton(str_btn_op[i * 4 + j]);
		list_btn_op[i * 4 + j].setBounds(x + 45 * j, y - 45 * i, 42, 42);
		list_btn_op[i * 4 + j].setFont(new Font("굴림", Font.BOLD, 10));
		list_btn_op[i * 4 + j].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		list_btn_op[i * 4 + j].addActionListener(this);
		contentPane.add(list_btn_op[i * 4 + j]);
	    }
	}

	// 초기 계산기는 10진수계산으로, A부터 Z버튼은 사용할 수 없게 한다.
	for (int i = 10; i < str_btn_num.length; ++i) {
	    list_btn_num[i].setEnabled(false);
	}
    }

    /*
     * 두 수를 계산하는 메소드 num1과 num2를 op에 저장된 operator를 이용해 연산을 한다. format에 따라서
     * string의 값을 변경해서 계산한다. 계산한 결과값을 반환한다.
     */
    private static String doMath(String num1, String op, String num2, int format) {
	int number1 = 0;
	int number2 = 0;

	if (format == 10) {
	    number1 = Integer.parseInt(num1);
	    number2 = Integer.parseInt(num2);
	} else if (format == 2) {
	    number1 = Integer.parseInt(num1, 2);
	    number2 = Integer.parseInt(num2, 2);
	} else if (format == 16) {
	    number1 = Integer.parseInt(num1, 16);
	    number2 = Integer.parseInt(num2, 16);
	} else if (format == 8) {
	    number1 = Integer.parseInt(num1, 8);
	    number2 = Integer.parseInt(num2, 8);
	}

	res1 = Integer.toString(number1);
	res2 = Integer.toString(number2);
	resOp = op;

	switch (op) {
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
	case "AND":
	case "&":
	    number1 &= number2;
	    break;
	case "OR":
	case "|":
	    number1 |= number2;
	    break;
	case "XOR":
	case "^":
	    number1 ^= number2;
	    break;
	case "<<":
	case "<":
	    number1 <<= number2;
	    break;
	case ">>":
	case ">":
	    number1 >>= number2;
	    break;
	case "MOD":
	case "%":
	    number1 %= number2;
	    break;
	}
	resTotal = Integer.toString(number1);
	return ("" + number1);
    }

    /*
     * num1, num2의 값을 설정하는 메소드 num1의 값이 NONE이면 num값을 저장하고, num1의 값이 NONE이 아니지만
     * operator값이 NONE이면 num1에 num을 추가하고, operator의 값도 NONE이 아니지만 num2값이 NONE이면
     * num2에 num을 저장하고, num2의 값도 NONE이 아니라면 num2에 num을 추가한다.
     */
    private void setNumber(String num) {
	if (num1 == NONE) {
	    // 2진수 계산일 경우에는 숫자앞에 0b를, 8진수 계산일 경우에는 0o를, 16진수 계산일 경우에는 0x를 추가한다.
	    if (radioButtonBinary.isSelected()) {
		textField.setText("0b");
	    } else if (radioButtonHexa.isSelected()) {
		textField.setText("0x");
	    } else if (radioButtonOctal.isSelected()) {
		textField.setText("0o");
	    }
	    num1 = num;
	} else if (operator == NONE) {
	    num1 += num;
	} else if (num2 == NONE) {
	    // 2진수 계산일 경우에는 숫자앞에 0b를, 8진수 계산일 경우에는 0o를, 16진수 계산일 경우에는 0x를 추가한다.
	    if (radioButtonBinary.isSelected()) {
		textField.setText("0b");
	    } else if (radioButtonHexa.isSelected()) {
		textField.setText("0x");
	    } else if (radioButtonOctal.isSelected()) {
		textField.setText("0o");
	    }
	    num2 = num;
	} else {
	    num2 += num;
	}
    }

    /*
     * operator값을 설정하는 메소드 operator값이 NONE이면 op값을 저장하고, operator값이 NONE이 아니지만
     * num2의 값이 NONE이면 operator값을 op값으로 초기화하고, num2의 값도 NONE이 아니면 num1, num2,
     * operator에 저장된 값으로 doMath메소드를 실행하고 결과값을 num1에 저장하고 num2와 operator는 NONE으로
     * 초기화한다.
     */
    private void setOperator(String op, int format) {
	if (operator == NONE) {
	    operator = op;
	} else if (num1 == NONE) {
	    operator = op;
	} else if (num2 == NONE) {
	    operator = op;
	} else if (num2 != NONE) {
	    num1 = doMath(num1, operator, num2, format);
	    // num1에는 현재 10진수로 저장되어 있기 때문에 각 진법계산에 맞게 num1을 변환시킨다.
	    if (format == 2) {
		num1 = Integer.toBinaryString(Integer.parseInt(num1));
	    } else if (format == 16) {
		num1 = Integer.toHexString(Integer.parseInt(num1)).toUpperCase();
	    } else if (format == 8) {
		num1 = Integer.toOctalString(Integer.parseInt(num1));
	    }
	    num2 = NONE;
	    operator = op;
	}
	textField.setText("");
    }

    /*
     * 진법에 따른 setOperator메소드이다. 인자값 전달 2진수 계산일때는 format 인자로 2를 넘겨주고, 16진수 계산일때는
     * 16을, 8진수 계산일때는 8을, 10진수 계산일때는 10을 넘겨준다.
     */
    private void setFormat(String str) {
	if (radioButtonBinary.isSelected()) {
	    setOperator(str, 2);
	} else if (radioButtonHexa.isSelected()) {
	    setOperator(str, 16);
	} else if (radioButtonOctal.isSelected()) {
	    setOperator(str, 8);
	} else if (radioButtonDecimal.isSelected()) {
	    setOperator(str, 10);
	}
    }

    /*
     * 진법에 따른 doMath메소드이다. 인자값 전달 2진수 계산일때는 format 인자로 2를 넘겨주고, 16진수 계산일때는
     * format 인자로 16을 넘겨주고, 10진수 계산일때는 format 인자로 10을 넘겨준다.
     */
    private void setFormat(String number1, String op, String number2) {
	if (radioButtonBinary.isSelected()) {
	    num1 = doMath(number1, op, number2, 2);
	} else if (radioButtonHexa.isSelected()) {
	    num1 = doMath(number1, op, number2, 16);
	} else if (radioButtonOctal.isSelected()) {
	    num1 = doMath(number1, op, number2, 8);
	} else if (radioButtonDecimal.isSelected()) {
	    num1 = doMath(number1, op, number2, 10);
	}
    }

    /*
     * 진법에 따른 textField값을 출력하는 메소드이다. 2진수 계산일때는 계산 결과값앞에 0b를 붙인 다음 2진수로 출력하고,
     * 16진수 계산일때는 0x를 붙인 다음 16진수로, 8진수 계산일때는 0o를 붙인 다음 8진수로, 10진수 계산일때는 10진수로
     * 출력한다. 2진수 계산일 경우 num2앞에 0b를 추가하고, 16진수 계산일 경우에는 0x를, 8진수 계산일 경우에는 0o를 추가한
     * 후에, textFieldNorth에 추가한다.
     */
    private void setText(String number1, String number2, String op) {
	if (radioButtonBinary.isSelected()) {
	    textFieldNorth.setText(textFieldNorth.getText() + "0b" + number2 + " " + op);
	} else if (radioButtonHexa.isSelected()) {
	    textFieldNorth.setText(textFieldNorth.getText() + "0x" + number2 + " " + op);
	} else if (radioButtonOctal.isSelected()) {
	    textFieldNorth.setText(textFieldNorth.getText() + "0o" + number2 + " " + op);
	} else {
	    textFieldNorth.setText(textFieldNorth.getText() + " " + number2 + " " + op);
	}

	if (radioButtonBinary.isSelected()) {
	    textField.setText("0b" + Integer.toBinaryString(Integer.parseInt(number1)));
	} else if (radioButtonHexa.isSelected()) {
	    textField.setText("0x" + Integer.toHexString(Integer.parseInt(number1)).toUpperCase());
	} else if (radioButtonOctal.isSelected()) {
	    textField.setText("0o" + Integer.toOctalString(Integer.parseInt(number1)));
	} else {
	    textField.setText(number1);
	}
    }

    /*
     * 출력된 숫자의 진법을 변경해서 출력하는 메소드 converFlag가 0일때는 10진수로, 1일때는 2진수로, 2일때는 16진수로
     * 3일때는 8진수로 변환한다.
     */
    private void convertText(int converFlag) {
	if (converFlag == 0) {
	    textFieldNorth.setText(res1 + " " + resOp + " " + res2);
	    textField.setText(resTotal);
	} else if (converFlag == 1) {
	    textFieldNorth.setText("0b" + Integer.toBinaryString(Integer.parseInt(res1)) + " " + resOp + " " + "0b"
		    + Integer.toBinaryString(Integer.parseInt(res2)));
	    textField.setText("0b" + Integer.toBinaryString((Integer.parseInt(resTotal))));
	} else if (converFlag == 2) {
	    textFieldNorth.setText("0x" + Integer.toHexString(Integer.parseInt(res1)).toUpperCase() + " " + resOp + " "
		    + "0x" + Integer.toHexString(Integer.parseInt(res2)).toUpperCase());
	    textField.setText("0x" + Integer.toHexString(Integer.parseInt(resTotal)).toUpperCase());
	} else if (converFlag == 3) {
	    textFieldNorth.setText("0o" + Integer.toOctalString(Integer.parseInt(res1)) + " " + resOp + " " + "0o"
		    + Integer.toOctalString(Integer.parseInt(res2)).toUpperCase());
	    textField.setText("0o" + Integer.toOctalString(Integer.parseInt(resTotal)));
	}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String s = e.getActionCommand();
	/*
	 * 숫자버튼을 눌렀을떄, 처음 입력하는 경우일때는 텍스트필드를 초기화하고 진법계산에 따라서 remember에 추가할 문자를 넣고
	 * 두번째 숫자를 처음 입력하는 경우일때도 역시 remember에 추가할 문자를 넣는다. 그 후에 setNumber 메소드를
	 * 호출한다.
	 */
	if (s.matches("^[0-9A-F]$")) {
	    if (num1 == NONE) {
		textField.setText("");
		textFieldNorth.setText("");
		res1 = "";
		res2 = "";
		resOp = "";
		resTotal = "";

		if (radioButtonBinary.isSelected()) {
		    remember += "0b";
		} else if (radioButtonHexa.isSelected()) {
		    remember += "0x";
		} else if (radioButtonOctal.isSelected()) {
		    remember += "0o";
		}
	    } else if (operator != NONE && num2 == NONE) {
		if (radioButtonBinary.isSelected()) {
		    remember += "0b";
		} else if (radioButtonHexa.isSelected()) {
		    remember += "0x";
		} else if (radioButtonOctal.isSelected()) {
		    remember += "0o";
		}
	    }
	    setNumber(s);
	    textField.setText(textField.getText() + s);

	    for (int i = 0; i < 8; i++) {
		list_lbl[i].setText("0000");
	    }
	    remember += s;
	    /*
	     * 연산자 버튼을 눌렀을때, 첫번째 숫자가 입력되었을 경우에만 수행한다. setFormat메소드를 호출한 후, 현재
	     * 계산하고 있는 진법에 따라서 num1 앞에 문자를 추가한 후에 연산자와 함께 textFieldNorth에 출력한다.
	     * 그리고 연산자를 remember에 추가한다.
	     */
	} else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("AND") || s.equals("OR")
		|| s.equals("XOR") || s.equals(">>") || s.equals("<<") || s.equals("MOD")) {
	    if (num1 != NONE) {
		setFormat(s);
		if (radioButtonBinary.isSelected()) {
		    textFieldNorth.setText("0b" + num1 + " " + s);
		} else if (radioButtonHexa.isSelected()) {
		    textFieldNorth.setText("0x" + num1 + " " + s);
		} else if (radioButtonOctal.isSelected()) {
		    textFieldNorth.setText("0o" + num1 + " " + s);
		} else {
		    textFieldNorth.setText(num1 + " " + s);
		}
	    }
	    remember += " " + s + " ";
	    /*
	     * NOT버튼을 눌렀을때, 숫자가 입력되었을때만 수행한다. 현재 계산하고 있는 진법에 따라서 num1을 int형으로
	     * 변환한 후, 그값에 ~을 취하고 다시 문자열로 변환해서 textField에 출력한다.
	     */
	} else if (s.equals("NOT")) {
	    if (num1 != NONE) {
		if (radioButtonBinary.isSelected()) {
		    String tmp = Integer.toString(Integer.parseInt(num1, 2));
		    tmp = Integer.toString(~Integer.parseInt(tmp));
		    tmp = Integer.toBinaryString(Integer.parseInt(tmp));
		    textField.setText("0b" + tmp);
		} else if (radioButtonHexa.isSelected()) {
		    String tmp = Integer.toString(Integer.parseInt(num1, 16));
		    tmp = Integer.toString(~Integer.parseInt(tmp));
		    tmp = Integer.toHexString(Integer.parseInt(tmp)).toUpperCase();
		    textField.setText("0x" + tmp);
		} else if (radioButtonOctal.isSelected()) {
		    String tmp = Integer.toString(Integer.parseInt(num1, 8));
		    tmp = Integer.toString(~Integer.parseInt(tmp));
		    tmp = Integer.toOctalString(Integer.parseInt(tmp));
		    textField.setText("0o" + tmp);
		} else {
		    String tmp = Integer.toString(Integer.parseInt(num1, 10));
		    tmp = Integer.toString(~Integer.parseInt(tmp));
		    tmp = Integer.toString(Integer.parseInt(tmp));
		    textField.setText(tmp);
		}
		num1 = NONE;
		num2 = NONE;
		operator = NONE;
	    }
	    /*
	     * +/-버튼을 눌렀을때, 숫자가 입력되었을때만 수행한다. 현재 계산하고 있는 진법에 따라서 num1을 int형으로
	     * 변환한 후, 그값에 부호를 반대로하고 다시 문자열로 변환해서 textField에 출력한다.
	     */
	} else if (s.equals("+/-")) {
	    if (num1 != NONE) {
		if (radioButtonBinary.isSelected()) {
		    String tmp = Integer.toString(Integer.parseInt(num1, 2));
		    tmp = Integer.toString(-Integer.parseInt(tmp));
		    num1 = Integer.toBinaryString(Integer.parseInt(tmp));
		    textField.setText("0b" + num1);
		} else if (radioButtonHexa.isSelected()) {
		    String tmp = Integer.toString(Integer.parseInt(num1, 16));
		    tmp = Integer.toString(-Integer.parseInt(tmp));
		    num1 = Integer.toHexString(Integer.parseInt(tmp)).toUpperCase();
		    textField.setText("0x" + num1);
		} else if (radioButtonOctal.isSelected()) {
		    String tmp = Integer.toString(Integer.parseInt(num1, 8));
		    tmp = Integer.toString(-Integer.parseInt(tmp));
		    num1 = Integer.toOctalString(Integer.parseInt(tmp));
		    textField.setText("0o" + num1);
		} else {
		    String tmp = Integer.toString(Integer.parseInt(num1, 10));
		    tmp = Integer.toString(-Integer.parseInt(tmp));
		    num1 = Integer.toString(Integer.parseInt(tmp));
		    textField.setText(num1);
		}
		num2 = NONE;
		operator = NONE;
	    }
	}

	/*
	 * = 버튼을 눌렀을 때 num1, num2, operator에 저장된 값으로 doMath메소드를 실행하고 결과값을 num1에
	 * 저장하고, num2, operator는 NONE으로 초기화한다.
	 */
	else if (s.equals("=")) {
	    setFormat(num1, operator, num2);
	    /*
	     * num1과 num2 모두를 입력받았을때만 동작하도록 한다. 2진수 계산일 경우 num2앞에 0b를 추가하고, 16진수
	     * 계산일 경우에는 0x를, 8진수 계산일 경우에는 0o를 추가한 후에, textFieldNorth에 추가한다.
	     * 마찬가지로 결과값도 textField에 출력하고, 결과값을 2진수로 나타낸 값을 list_lbl에 출력한다.
	     * remember에 저장해둔 계산과정을 History에 저장한다.
	     */
	    if (num1 != NONE && num2 != NONE) {
		setText(num1, num2, s);
		operator = NONE;
		num1 = NONE;
		num2 = NONE;

		String tmp = Integer.toBinaryString(Integer.parseInt(resTotal));
		if (tmp.length() % 4 == 1) {
		    tmp = "000" + tmp;
		} else if (tmp.length() % 4 == 2) {
		    tmp = "00" + tmp;
		} else if (tmp.length() % 4 == 3) {
		    tmp = "0" + tmp;
		}
		for (int i = 0; i < tmp.length() / 4; i++) {
		    list_lbl[7 - i].setText(tmp.substring(tmp.length() - 4 - 4 * i, tmp.length() - 4 * i));
		}
		remember += " " + " = " + textField.getText() + "\n\n";
		h.getTextArea().append(remember);
		remember = "";
	    }
	    /*
	     * c버튼을 눌렀을때, 모든 텍스트필드와 라벨들을 초기화하고 현재 가지고 있는 값들도 모두 초기화한다.
	     */
	} else if (s.equals("c")) {
	    textField.setText("");
	    textFieldNorth.setText("");
	    operator = NONE;
	    num1 = NONE;
	    num2 = NONE;
	    res1 = "";
	    res2 = "";
	    resOp = "";
	    resTotal = "";

	    remember = "";
	    for (int i = 0; i < 8; i++) {
		list_lbl[i].setText("0000");
	    }
	    /*
	     * CE버튼을 눌렀을때, 현재 입력하고 있던 값을 초기화하고 textFieldNorth를 초기화한다.
	     */
	} else if (s.equals("CE")) {
	    if (num2 != NONE) {
		num2 = NONE;
	    } else if (num1 != NONE) {
		num1 = NONE;
	    }
	    textFieldNorth.setText("");
	    /*
	     * Bksp버튼을 눌렀을때, 현재 입력하고 있던 값에서 숫자 하나만을 지운다.
	     */
	} else if (s.equals("Bksp")) {
	    if (textField.getText().isEmpty() == false) {
		String erase = textField.getText();
		erase = erase.substring(0, erase.length() - 1);
		textField.setText(erase);
	    }
	}
    }

    @Override
    public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	char c = e.getKeyChar();
	String str = new Character(c).toString();
	/*
	 * 숫자키를 눌렀을떄, 처음 입력하는 경우일때는 텍스트필드를 초기화하고 진법계산에 따라서 remember에 추가할 문자를 넣고
	 * 두번째 숫자를 처음 입력하는 경우일때도 역시 remember에 추가할 문자를 넣는다. 그 후에 setNumber 메소드를
	 * 호출한다.
	 */
	if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F')) {
	    if (num1 == NONE) {
		textField.setText("");
		textFieldNorth.setText("");
	    }
	    res1 = "";
	    res2 = "";
	    resTotal = "";
	    setNumber(str);
	    textField.setText(textField.getText() + c);
	    for (int i = 0; i < 8; i++) {
		list_lbl[i].setText("0000");
	    }
	    remember += str + " ";
	    e.consume();
	    /*
	     * 연산자 키를 눌렀을때, 첫번째 숫자가 입력되었을 경우에만 수행한다. setFormat메소드를 호출한 후, 현재
	     * 계산하고 있는 진법에 따라서 num1 앞에 문자를 추가한 후에 연산자와 함께 textFieldNorth에 출력한다.
	     * 그리고 연산자를 remember에 추가한다.
	     */
	} else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '&' || c == '|' || c == '^' || c == '<'
		|| c == '>' || c == '%') {
	    setFormat(str);
	    if (radioButtonBinary.isSelected()) {
		textFieldNorth.setText("0b" + num1 + " " + c);
	    } else if (radioButtonHexa.isSelected()) {
		textFieldNorth.setText("0x" + num1 + " " + c);
	    } else if (radioButtonOctal.isSelected()) {
		textFieldNorth.setText("0o" + num1 + " " + c);
	    } else {
		textFieldNorth.setText(num1 + " " + c);
	    }
	    remember += " " + c + " ";
	    e.consume();
	    /*
	     * ~키를 눌렀을때, 숫자가 입력되었을때만 수행한다. 현재 계산하고 있는 진법에 따라서 num1을 int형으로 변환한
	     * 후, 그값에 ~을 취하고 다시 문자열로 변환해서 textField에 출력한다.
	     */
	} else if (c == '~') {
	    if (num1 != NONE) {
		if (radioButtonBinary.isSelected()) {
		    String tmp = Integer.toString(Integer.parseInt(num1, 2));
		    tmp = Integer.toString(~Integer.parseInt(tmp));
		    tmp = Integer.toBinaryString(Integer.parseInt(tmp));
		    textField.setText("0b" + tmp);
		} else if (radioButtonHexa.isSelected()) {
		    String tmp = Integer.toString(Integer.parseInt(num1, 16));
		    tmp = Integer.toString(~Integer.parseInt(tmp));
		    tmp = Integer.toHexString(Integer.parseInt(tmp)).toUpperCase();
		    textField.setText("0x" + tmp);
		} else if (radioButtonOctal.isSelected()) {
		    String tmp = Integer.toString(Integer.parseInt(num1, 8));
		    tmp = Integer.toString(~Integer.parseInt(tmp));
		    tmp = Integer.toOctalString(Integer.parseInt(tmp));
		    textField.setText("0o" + tmp);
		} else {
		    String tmp = Integer.toString(Integer.parseInt(num1, 10));
		    tmp = Integer.toString(~Integer.parseInt(tmp));
		    tmp = Integer.toString(Integer.parseInt(tmp));
		    textField.setText(tmp);
		}
		num1 = NONE;
		num2 = NONE;
		operator = NONE;
	    }
	    e.consume();
	    /*
	     * enter키를 눌렀을 때 num1, num2, operator에 저장된 값으로 doMath메소드를 실행하고, 그
	     * 결과값으로 textFieldNorth를 초기화한다.
	     */
	} else if (c == KeyEvent.VK_ENTER) {
	    setFormat(num1, operator, num2);
	    /*
	     * num1과 num2 모두를 입력받았을때만 동작하도록 한다. 2진수 계산일 경우 num2앞에 0b를 추가하고, 16진수
	     * 계산일 경우에는 0x를, 8진수 계산일 경우에는 0o를 추가한 후에, textFieldNorth에 추가한다.
	     * 마찬가지로 결과값도 textField에 출력하고, 결과값을 2진수로 나타낸 값을 list_lbl에 출력한다.
	     * remember에 저장해둔 계산과정을 History에 저장한다.
	     */
	    setText(num1, num2, "=");
	    operator = NONE;
	    num1 = NONE;
	    num2 = NONE;

	    String tmp = Integer.toBinaryString(Integer.parseInt(resTotal));
	    if (tmp.length() % 4 == 1) {
		tmp = "000" + tmp;
	    } else if (tmp.length() % 4 == 2) {
		tmp = "00" + tmp;
	    } else if (tmp.length() % 4 == 3) {
		tmp = "0" + tmp;
	    }
	    for (int i = 0; i < tmp.length() / 4; i++) {
		list_lbl[7 - i].setText(tmp.substring(tmp.length() - 4 - 4 * i, tmp.length() - 4 * i));
	    }
	    remember += " = " + textField.getText() + "\n\n";
	    h.getTextArea().append(remember);
	    remember = "";
	    e.consume();
	    /*
	     * back space키를 눌렀을때, 현재 입력하고 있던 값에서 숫자 하나만을 지운다.
	     */
	} else if (c == KeyEvent.VK_BACK_SPACE) {
	    if (textField.getText().isEmpty() == false) {
		String erase = textField.getText();
		erase = erase.substring(0, erase.length() - 1);
		textField.setText(erase);
		e.consume();
	    }
	    /*
	     * c키를 눌렀을때, 모든 텍스트필드와 라벨들을 초기화하고 현재 가지고 있는 값들도 모두 초기화한다.
	     */
	} else if (c == 'c') {
	    textField.setText("");
	    textFieldNorth.setText("");
	    operator = NONE;
	    num1 = NONE;
	    num2 = NONE;
	    res1 = "";
	    res2 = "";
	    resOp = "";
	    resTotal = "";
	    remember = "";
	    for (int i = 0; i < 8; i++) {
		list_lbl[i].setText("0000");
	    }
	} else {
	    e.consume();
	}
    }

    @Override
    public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	char c = e.getKeyChar();
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
	// TODO Auto-generated method stub
	AbstractButton sel = (AbstractButton) e.getItemSelectable();
	if (e.getStateChange() == ItemEvent.SELECTED) {

	    // 라디오버튼을 클릭했을때의 이벤트 처리
	    // Binary버튼을 눌렀을때, 0,1번 버튼만 사용가능하게 한다.
	    if (sel.getText().equals("Binary")) {
		for (int i = 2; i < str_btn_num.length; ++i) {
		    list_btn_num[i].setEnabled(false);
		}
		if (textFieldNorth.getText().isEmpty() == false) {
		    convertText(1);
		}
		// Decimal버튼을 눌렀을때, 0번부터 10번 버튼까지만 사용가능하게 한다.
	    } else if (sel.getText().equals("Decimal")) {
		for (int i = 2; i < str_btn_num.length; ++i) {
		    if (i < 10)
			list_btn_num[i].setEnabled(true);
		    else
			list_btn_num[i].setEnabled(false);
		}
		if (textFieldNorth.getText().isEmpty() == false) {
		    convertText(0);
		}
		// Hexa버튼을 눌렀을때, 모든 버튼을 사용가능하게 한다.
	    } else if (sel.getText().equals("Hexa")) {
		for (int i = 2; i < str_btn_num.length; ++i) {
		    list_btn_num[i].setEnabled(true);
		}
		if (textFieldNorth.getText().isEmpty() == false)
		    convertText(2);
		// Octal버튼을 눌렀을때, 0번부터 7번 버튼까지만 사용가능하게 한다.
	    } else if (sel.getText().equals("Octal")) {
		for (int i = 2; i < str_btn_num.length; ++i) {
		    if (i < 8)
			list_btn_num[i].setEnabled(true);
		    else
			list_btn_num[i].setEnabled(false);
		}
		if (textFieldNorth.getText().isEmpty() == false)
		    convertText(3);
	    }

	    // converter체크박스를 클릭했을때의 이벤트처리
	    // Converter버튼을 체크했을떄 Converter창이 뜨도록 하고, History버튼를 체크했을때 History창이
	    // 뜨도록 하고, DateCalc버튼를 체크했을때 DateCalc창이 뜨도록 한다.
	    else if (sel.getText().equals("Converter")) {
		c = new Converter();
		c.setVisible(true);
	    } else if (sel.getText().equals("History")) {
		h.setVisible(true);
	    } else if (sel.getText().equals("DateCalc")) {
		d.setVisible(true);
	    }
	    // converter체크박스를 해제했을때의 이벤트처리
	    // Converter버튼을 체크해제했을떄 Converter창이 닫히게 하고, History버튼를 체크했을때
	    // History창이 닫히게 하고, DateCalc버튼을 체크해제했을떄 DateCalc창이 닫히게 한다.
	} else if (e.getStateChange() == ItemEvent.DESELECTED) {
	    if (sel.getText().equals("Converter")) {
		c.dispose();
	    } else if (sel.getText().equals("History")) {
		h.dispose();
	    } else if (sel.getText().equals("DateCalc")) {
		d.dispose();
	    }
	}
    }
}