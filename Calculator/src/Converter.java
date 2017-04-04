import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class Converter extends JFrame {

    private JPanel contentPane;
    private JLabel lblConverter;
    private JComboBox comboBox;
    private JTextField textField_From;
    private JLabel lblFrom;
    private JLabel lblTo;
    private JComboBox comboBox_from;
    private JLabel lblLabelTo;
    private JComboBox comboBox_to;

    // 각 범주에 포함되는 단위들을 저장하고 있는 문자열 배열
    private String list[] = { "Length", "Weight", "Time" };
    private String list_length[] = { "Feet", "Inch", "Kilometer", "Meter", "Mile", "Yard" };
    private String list_weight[] = { "Carat", "Gram", "Ounce", "Pound" };
    private String list_time[] = { "Second", "Minute", "Hour", "Day", "Week" };

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Converter frame = new Converter();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public Converter() {
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 450, 257);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	lblConverter = new JLabel("Converter");
	lblConverter.setBounds(12, 10, 57, 15);
	contentPane.add(lblConverter);

	comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(list));
	comboBox.setBounds(12, 44, 97, 21);
	contentPane.add(comboBox);
	comboBox.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		Object obj = comboBox.getSelectedItem();
		// 계산하려는 단위의 범주를 선택했을때, 그 범주에 속하는 단위들을 comboBox_from과
		// comboBox_to에 생성하고, 라벨과 텍스트필드의 값을 0으로 초기화한다.
		if (obj.toString() == "Length") {
		    comboBox_from.setModel(new DefaultComboBoxModel(list_length));
		    comboBox_to.setModel(new DefaultComboBoxModel(list_length));
		} else if (obj.toString() == "Weight") {
		    comboBox_from.setModel(new DefaultComboBoxModel(list_weight));
		    comboBox_to.setModel(new DefaultComboBoxModel(list_weight));
		} else if (obj.toString() == "Time") {
		    comboBox_from.setModel(new DefaultComboBoxModel(list_time));
		    comboBox_to.setModel(new DefaultComboBoxModel(list_time));
		}
		textField_From.setText("0");
		lblLabelTo.setText("0");
	    }
	});

	//콤보박스의 단위를 선택했을때 ProcessEvent메소드를 실행한다.
	comboBox_from = new JComboBox();
	comboBox_from.setBounds(338, 115, 84, 21);
	contentPane.add(comboBox_from);
	comboBox_from.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		ProcessEvent();
	    }
	});
	comboBox_to = new JComboBox();
	comboBox_to.setBounds(338, 177, 84, 21);
	contentPane.add(comboBox_to);
	comboBox_to.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		ProcessEvent();
	    }
	});

	textField_From = new JTextField();
	textField_From.setText("0");
	textField_From.setBounds(12, 115, 314, 21);
	contentPane.add(textField_From);
	textField_From.setColumns(10);

	lblFrom = new JLabel("From:");
	lblFrom.setBounds(22, 90, 57, 15);
	contentPane.add(lblFrom);

	lblTo = new JLabel("To:");
	lblTo.setBounds(22, 152, 57, 15);
	contentPane.add(lblTo);

	lblLabelTo = new JLabel("0");
	lblLabelTo.setBounds(12, 177, 314, 21);
	lblLabelTo.setBorder(new EtchedBorder());
	contentPane.add(lblLabelTo);

	textField_From.addKeyListener(new KeyListener() {

	    @Override
	    public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		//엔터키를 눌렀을때 ProcessEvent메소드를 실행한다.
		if (c == KeyEvent.VK_ENTER) {
		    ProcessEvent();
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
    }

    // 길이단위를 변환하는 메소드이다. 현재 입력된 값을 str_from 단위에 대해 Kilometer로 변환한 후, str_to단위로
    // 변환한다.
    // 변환한 결과값을 소수점 6번째자리까지 lblLabelTo에 출력한다.
    void ConvertLength(String str_from, String str_to) {
	double preNum = Double.parseDouble(textField_From.getText());
	if (str_from == "Feet") {
	    preNum /= 3280.8399;
	} else if (str_from == "Inch") {
	    preNum /= 39370.0787;
	} else if (str_from == "Meter") {
	    preNum /= 1000;
	} else if (str_from == "Mile") {
	    preNum /= 0.621371;
	} else if (str_from == "Yard") {
	    preNum /= 1093.6133;
	}

	if (str_to == "Feet") {
	    preNum *= 3280.8399;
	} else if (str_to == "Inch") {
	    preNum *= 39370.0787;
	} else if (str_to == "Meter") {
	    preNum *= 1000;
	} else if (str_to == "Mile") {
	    preNum *= 0.621371;
	} else if (str_to == "Yard") {
	    preNum *= 1093.6133;
	}

	String res = String.format("%.6f", preNum);
	lblLabelTo.setText(res);
    }

    // 무게단위를 변환하는 메소드이다. 현재 입력된 값을 str_from 단위에 대해 Gram으로 변환한 후, str_to단위로 변환한다.
    // 변환한 결과값을 소수점 6번째자리까지 lblLabelTo에 출력한다.
    void ConvertWeight(String str_from, String str_to) {
	double preNum = Double.parseDouble(textField_From.getText());
	if (str_from == "Carat") {
	    preNum *= 0.2;
	} else if (str_from == "Ounce") {
	    preNum /= 0.035274;
	} else if (str_from == "Pound") {
	    preNum /= 0.002205;
	}

	if (str_to == "Carat") {
	    preNum /= 0.2;
	} else if (str_to == "Ounce") {
	    preNum *= 0.035274;
	} else if (str_to == "Pound") {
	    preNum *= 0.002205;
	}

	String res = String.format("%.6f", preNum);
	lblLabelTo.setText(res);
    }

    // 시간단위를 변환하는 메소드이다. 현재 입력된 값을 str_from 단위에 대해 Second로 변환한 후, str_to단위로
    // 변환한다.
    // 변환한 결과값을 소수점 6번째자리까지 lblLabelTo에 출력한다.
    void ConvertTime(String str_from, String str_to) {
	double preNum = Double.parseDouble(textField_From.getText());
	if (str_from == "Minute") {
	    preNum *= 60;
	} else if (str_from == "Hour") {
	    preNum *= 3600;
	} else if (str_from == "Day") {
	    preNum *= 86400;
	} else if (str_from == "Week") {
	    preNum *= 604800;
	}

	if (str_to == "Minute") {
	    preNum /= 60;
	} else if (str_to == "Hour") {
	    preNum /= 3600;
	} else if (str_to == "Day") {
	    preNum /= 86400;
	} else if (str_to == "Week") {
	    preNum /= 604800;
	}

	String res = String.format("%.6f", preNum);
	lblLabelTo.setText(res);
    }

    // 단위변환 전체를 수행하는 메소드이다.
    // Length범주를 선택하면 ConvertLength메소드를 실행하고, Weight범주를 선택하면 ConvertWeight메소드를
    // 실행하고, Time범주를 선택하면 ConvertTime메소드를 실행한다.
    void ProcessEvent() {
	Object obj_list = comboBox.getSelectedItem();
	Object obj_from = comboBox_from.getSelectedItem();
	Object obj_to = comboBox_to.getSelectedItem();

	if (obj_list.toString() == "Length") {
	    ConvertLength(obj_from.toString(), obj_to.toString());
	} else if (obj_list.toString() == "Weight") {
	    ConvertWeight(obj_from.toString(), obj_to.toString());
	} else if (obj_list.toString() == "Time") {
	    ConvertTime(obj_from.toString(), obj_to.toString());
	}
    }
}
