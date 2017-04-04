
/*
 * 
 * �������,�� �ε����ƿ�,������16��������,�޸�
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

    // ����� ���� �� num1, num2, operator, ������� �����ϴ� ����
    private static String res1;
    private static String res2;
    private static String resOp;
    private static String resTotal;

    // ��� �������� �����صδ� ���ڿ�
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

    // �� ��ư�� ������ ���� ��Ƶ� ���ڿ� �迭
    private String[] str_btn_num = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
    private String[] str_btn_op = { "/", "XOR", "+/-", "=", "*", "NOT", "MOD", "Bksp", "-", "OR", ">>", "CE", "+",
	    "AND", "<<", "c" };

    // ���� ��ư���� ��Ƶδ� ��ư�׷�
    private ButtonGroup btnGroup;

    // ConverterŬ������ HistoryŬ����, DateCalcŬ������ ��ü ����
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

	// ������ư���� ��ư�׷쿡 ��Ƶд�.
	btnGroup = new ButtonGroup();
	btnGroup.add(radioButtonBinary);
	btnGroup.add(radioButtonDecimal);
	btnGroup.add(radioButtonHexa);
	btnGroup.add(radioButtonOctal);

	// list_lbl�� ���� �����ϰ� 0000���� �ʱ�ȭ�Ѵ�.
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

	// list_btn_num�� ��ư���� �����ϰ� ActionListener�� �߰��Ѵ�.
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

	// list_btn_op�� ��ư���� �����ϰ� ActionListener�� �߰��Ѵ�.
	list_btn_op = new JButton[str_btn_op.length];
	for (int i = 0; i < 4; ++i) {
	    int y = 220;
	    for (int j = 0; j < 4; ++j) {
		int x = 320;
		list_btn_op[i * 4 + j] = new JButton(str_btn_op[i * 4 + j]);
		list_btn_op[i * 4 + j].setBounds(x + 45 * j, y - 45 * i, 42, 42);
		list_btn_op[i * 4 + j].setFont(new Font("����", Font.BOLD, 10));
		list_btn_op[i * 4 + j].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		list_btn_op[i * 4 + j].addActionListener(this);
		contentPane.add(list_btn_op[i * 4 + j]);
	    }
	}

	// �ʱ� ����� 10�����������, A���� Z��ư�� ����� �� ���� �Ѵ�.
	for (int i = 10; i < str_btn_num.length; ++i) {
	    list_btn_num[i].setEnabled(false);
	}
    }

    /*
     * �� ���� ����ϴ� �޼ҵ� num1�� num2�� op�� ����� operator�� �̿��� ������ �Ѵ�. format�� ����
     * string�� ���� �����ؼ� ����Ѵ�. ����� ������� ��ȯ�Ѵ�.
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
     * num1, num2�� ���� �����ϴ� �޼ҵ� num1�� ���� NONE�̸� num���� �����ϰ�, num1�� ���� NONE�� �ƴ�����
     * operator���� NONE�̸� num1�� num�� �߰��ϰ�, operator�� ���� NONE�� �ƴ����� num2���� NONE�̸�
     * num2�� num�� �����ϰ�, num2�� ���� NONE�� �ƴ϶�� num2�� num�� �߰��Ѵ�.
     */
    private void setNumber(String num) {
	if (num1 == NONE) {
	    // 2���� ����� ��쿡�� ���ھտ� 0b��, 8���� ����� ��쿡�� 0o��, 16���� ����� ��쿡�� 0x�� �߰��Ѵ�.
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
	    // 2���� ����� ��쿡�� ���ھտ� 0b��, 8���� ����� ��쿡�� 0o��, 16���� ����� ��쿡�� 0x�� �߰��Ѵ�.
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
     * operator���� �����ϴ� �޼ҵ� operator���� NONE�̸� op���� �����ϰ�, operator���� NONE�� �ƴ�����
     * num2�� ���� NONE�̸� operator���� op������ �ʱ�ȭ�ϰ�, num2�� ���� NONE�� �ƴϸ� num1, num2,
     * operator�� ����� ������ doMath�޼ҵ带 �����ϰ� ������� num1�� �����ϰ� num2�� operator�� NONE����
     * �ʱ�ȭ�Ѵ�.
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
	    // num1���� ���� 10������ ����Ǿ� �ֱ� ������ �� ������꿡 �°� num1�� ��ȯ��Ų��.
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
     * ������ ���� setOperator�޼ҵ��̴�. ���ڰ� ���� 2���� ����϶��� format ���ڷ� 2�� �Ѱ��ְ�, 16���� ����϶���
     * 16��, 8���� ����϶��� 8��, 10���� ����϶��� 10�� �Ѱ��ش�.
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
     * ������ ���� doMath�޼ҵ��̴�. ���ڰ� ���� 2���� ����϶��� format ���ڷ� 2�� �Ѱ��ְ�, 16���� ����϶���
     * format ���ڷ� 16�� �Ѱ��ְ�, 10���� ����϶��� format ���ڷ� 10�� �Ѱ��ش�.
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
     * ������ ���� textField���� ����ϴ� �޼ҵ��̴�. 2���� ����϶��� ��� ������տ� 0b�� ���� ���� 2������ ����ϰ�,
     * 16���� ����϶��� 0x�� ���� ���� 16������, 8���� ����϶��� 0o�� ���� ���� 8������, 10���� ����϶��� 10������
     * ����Ѵ�. 2���� ����� ��� num2�տ� 0b�� �߰��ϰ�, 16���� ����� ��쿡�� 0x��, 8���� ����� ��쿡�� 0o�� �߰���
     * �Ŀ�, textFieldNorth�� �߰��Ѵ�.
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
     * ��µ� ������ ������ �����ؼ� ����ϴ� �޼ҵ� converFlag�� 0�϶��� 10������, 1�϶��� 2������, 2�϶��� 16������
     * 3�϶��� 8������ ��ȯ�Ѵ�.
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
	 * ���ڹ�ư�� ��������, ó�� �Է��ϴ� ����϶��� �ؽ�Ʈ�ʵ带 �ʱ�ȭ�ϰ� ������꿡 ���� remember�� �߰��� ���ڸ� �ְ�
	 * �ι�° ���ڸ� ó�� �Է��ϴ� ����϶��� ���� remember�� �߰��� ���ڸ� �ִ´�. �� �Ŀ� setNumber �޼ҵ带
	 * ȣ���Ѵ�.
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
	     * ������ ��ư�� ��������, ù��° ���ڰ� �ԷµǾ��� ��쿡�� �����Ѵ�. setFormat�޼ҵ带 ȣ���� ��, ����
	     * ����ϰ� �ִ� ������ ���� num1 �տ� ���ڸ� �߰��� �Ŀ� �����ڿ� �Բ� textFieldNorth�� ����Ѵ�.
	     * �׸��� �����ڸ� remember�� �߰��Ѵ�.
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
	     * NOT��ư�� ��������, ���ڰ� �ԷµǾ������� �����Ѵ�. ���� ����ϰ� �ִ� ������ ���� num1�� int������
	     * ��ȯ�� ��, �װ��� ~�� ���ϰ� �ٽ� ���ڿ��� ��ȯ�ؼ� textField�� ����Ѵ�.
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
	     * +/-��ư�� ��������, ���ڰ� �ԷµǾ������� �����Ѵ�. ���� ����ϰ� �ִ� ������ ���� num1�� int������
	     * ��ȯ�� ��, �װ��� ��ȣ�� �ݴ���ϰ� �ٽ� ���ڿ��� ��ȯ�ؼ� textField�� ����Ѵ�.
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
	 * = ��ư�� ������ �� num1, num2, operator�� ����� ������ doMath�޼ҵ带 �����ϰ� ������� num1��
	 * �����ϰ�, num2, operator�� NONE���� �ʱ�ȭ�Ѵ�.
	 */
	else if (s.equals("=")) {
	    setFormat(num1, operator, num2);
	    /*
	     * num1�� num2 ��θ� �Է¹޾������� �����ϵ��� �Ѵ�. 2���� ����� ��� num2�տ� 0b�� �߰��ϰ�, 16����
	     * ����� ��쿡�� 0x��, 8���� ����� ��쿡�� 0o�� �߰��� �Ŀ�, textFieldNorth�� �߰��Ѵ�.
	     * ���������� ������� textField�� ����ϰ�, ������� 2������ ��Ÿ�� ���� list_lbl�� ����Ѵ�.
	     * remember�� �����ص� �������� History�� �����Ѵ�.
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
	     * c��ư�� ��������, ��� �ؽ�Ʈ�ʵ�� �󺧵��� �ʱ�ȭ�ϰ� ���� ������ �ִ� ���鵵 ��� �ʱ�ȭ�Ѵ�.
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
	     * CE��ư�� ��������, ���� �Է��ϰ� �ִ� ���� �ʱ�ȭ�ϰ� textFieldNorth�� �ʱ�ȭ�Ѵ�.
	     */
	} else if (s.equals("CE")) {
	    if (num2 != NONE) {
		num2 = NONE;
	    } else if (num1 != NONE) {
		num1 = NONE;
	    }
	    textFieldNorth.setText("");
	    /*
	     * Bksp��ư�� ��������, ���� �Է��ϰ� �ִ� ������ ���� �ϳ����� �����.
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
	 * ����Ű�� ��������, ó�� �Է��ϴ� ����϶��� �ؽ�Ʈ�ʵ带 �ʱ�ȭ�ϰ� ������꿡 ���� remember�� �߰��� ���ڸ� �ְ�
	 * �ι�° ���ڸ� ó�� �Է��ϴ� ����϶��� ���� remember�� �߰��� ���ڸ� �ִ´�. �� �Ŀ� setNumber �޼ҵ带
	 * ȣ���Ѵ�.
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
	     * ������ Ű�� ��������, ù��° ���ڰ� �ԷµǾ��� ��쿡�� �����Ѵ�. setFormat�޼ҵ带 ȣ���� ��, ����
	     * ����ϰ� �ִ� ������ ���� num1 �տ� ���ڸ� �߰��� �Ŀ� �����ڿ� �Բ� textFieldNorth�� ����Ѵ�.
	     * �׸��� �����ڸ� remember�� �߰��Ѵ�.
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
	     * ~Ű�� ��������, ���ڰ� �ԷµǾ������� �����Ѵ�. ���� ����ϰ� �ִ� ������ ���� num1�� int������ ��ȯ��
	     * ��, �װ��� ~�� ���ϰ� �ٽ� ���ڿ��� ��ȯ�ؼ� textField�� ����Ѵ�.
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
	     * enterŰ�� ������ �� num1, num2, operator�� ����� ������ doMath�޼ҵ带 �����ϰ�, ��
	     * ��������� textFieldNorth�� �ʱ�ȭ�Ѵ�.
	     */
	} else if (c == KeyEvent.VK_ENTER) {
	    setFormat(num1, operator, num2);
	    /*
	     * num1�� num2 ��θ� �Է¹޾������� �����ϵ��� �Ѵ�. 2���� ����� ��� num2�տ� 0b�� �߰��ϰ�, 16����
	     * ����� ��쿡�� 0x��, 8���� ����� ��쿡�� 0o�� �߰��� �Ŀ�, textFieldNorth�� �߰��Ѵ�.
	     * ���������� ������� textField�� ����ϰ�, ������� 2������ ��Ÿ�� ���� list_lbl�� ����Ѵ�.
	     * remember�� �����ص� �������� History�� �����Ѵ�.
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
	     * back spaceŰ�� ��������, ���� �Է��ϰ� �ִ� ������ ���� �ϳ����� �����.
	     */
	} else if (c == KeyEvent.VK_BACK_SPACE) {
	    if (textField.getText().isEmpty() == false) {
		String erase = textField.getText();
		erase = erase.substring(0, erase.length() - 1);
		textField.setText(erase);
		e.consume();
	    }
	    /*
	     * cŰ�� ��������, ��� �ؽ�Ʈ�ʵ�� �󺧵��� �ʱ�ȭ�ϰ� ���� ������ �ִ� ���鵵 ��� �ʱ�ȭ�Ѵ�.
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

	    // ������ư�� Ŭ���������� �̺�Ʈ ó��
	    // Binary��ư�� ��������, 0,1�� ��ư�� ��밡���ϰ� �Ѵ�.
	    if (sel.getText().equals("Binary")) {
		for (int i = 2; i < str_btn_num.length; ++i) {
		    list_btn_num[i].setEnabled(false);
		}
		if (textFieldNorth.getText().isEmpty() == false) {
		    convertText(1);
		}
		// Decimal��ư�� ��������, 0������ 10�� ��ư������ ��밡���ϰ� �Ѵ�.
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
		// Hexa��ư�� ��������, ��� ��ư�� ��밡���ϰ� �Ѵ�.
	    } else if (sel.getText().equals("Hexa")) {
		for (int i = 2; i < str_btn_num.length; ++i) {
		    list_btn_num[i].setEnabled(true);
		}
		if (textFieldNorth.getText().isEmpty() == false)
		    convertText(2);
		// Octal��ư�� ��������, 0������ 7�� ��ư������ ��밡���ϰ� �Ѵ�.
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

	    // converterüũ�ڽ��� Ŭ���������� �̺�Ʈó��
	    // Converter��ư�� üũ������ Converterâ�� �ߵ��� �ϰ�, History��ư�� üũ������ Historyâ��
	    // �ߵ��� �ϰ�, DateCalc��ư�� üũ������ DateCalcâ�� �ߵ��� �Ѵ�.
	    else if (sel.getText().equals("Converter")) {
		c = new Converter();
		c.setVisible(true);
	    } else if (sel.getText().equals("History")) {
		h.setVisible(true);
	    } else if (sel.getText().equals("DateCalc")) {
		d.setVisible(true);
	    }
	    // converterüũ�ڽ��� ������������ �̺�Ʈó��
	    // Converter��ư�� üũ���������� Converterâ�� ������ �ϰ�, History��ư�� üũ������
	    // Historyâ�� ������ �ϰ�, DateCalc��ư�� üũ���������� DateCalcâ�� ������ �Ѵ�.
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