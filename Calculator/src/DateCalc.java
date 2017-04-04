import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//날짜 계산기
public class DateCalc extends JFrame {

    private JPanel contentPane;
    private JLabel lblFrom;
    private JTextField textField;
    private JLabel lblTo;
    private JTextField textField_1;
    private JLabel lblDifference;
    private JTextField textField_2;
    private JButton btnNewButton;
    private JTextField txtInsertFormatDaymonthyear;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    DateCalc frame = new DateCalc();
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
    public DateCalc() {
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 411, 249);
	setTitle("Date Calculation");
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	lblFrom = new JLabel("From:");
	lblFrom.setBounds(14, 74, 62, 18);
	contentPane.add(lblFrom);

	textField = new JTextField();
	textField.setBounds(64, 71, 191, 24);
	contentPane.add(textField);
	textField.setColumns(10);

	lblTo = new JLabel("To:");
	lblTo.setBounds(14, 111, 62, 18);
	contentPane.add(lblTo);

	textField_1 = new JTextField();
	textField_1.setBounds(64, 108, 191, 24);
	contentPane.add(textField_1);
	textField_1.setColumns(10);

	lblDifference = new JLabel("Difference: ");
	lblDifference.setBounds(14, 171, 87, 18);
	contentPane.add(lblDifference);

	textField_2 = new JTextField();
	textField_2.setBounds(94, 168, 285, 24);
	contentPane.add(textField_2);
	textField_2.setColumns(10);
	textField_2.setEditable(false);

	btnNewButton = new JButton("Calculation");
	btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		/*
		 * From옆의 텍스트필드와 to옆의 텍스트필드를 가져와 날짜의 차이를 계산한다
		 */
		try {
		    textField_2.setText(diffDate(textField.getText(), textField_1.getText()));
		} catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	});
	btnNewButton.setBounds(274, 65, 105, 74);
	contentPane.add(btnNewButton);
	txtInsertFormatDaymonthyear = new JTextField();
	txtInsertFormatDaymonthyear.setColumns(10);
	txtInsertFormatDaymonthyear.setForeground(Color.BLACK);
	// 입력형식을 지정해준다
	txtInsertFormatDaymonthyear.setText("Insert Format: day/month/year");
	txtInsertFormatDaymonthyear.setBounds(11, 14, 365, 34);
	contentPane.add(txtInsertFormatDaymonthyear);
	txtInsertFormatDaymonthyear.setEditable(false);
	txtInsertFormatDaymonthyear.setBorder(null);

    }

    /*
     * 날짜의 차이를 계산하는 함수 정해진 포맷대로 날짜를 받아와 long day에 저장한다 day를 365,30,7,로 나눠 각각
     * year,month,week에 저장하고 출력한다
     */
    public static String diffDate(String begin, String end) throws Exception {
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	Date beginDate = formatter.parse(begin);
	Date endDate = formatter.parse(end);
	long diff = endDate.getTime() - beginDate.getTime();
	long day = diff / (24 * 60 * 60 * 1000);
	long year = day / 365;
	day %= 365;
	long month = day / 30;
	day %= 30;
	long week = day / 7;
	day %= 7;
	return year + "year(s), " + month + "month(s), " + week + "week(s), " + day + "day(s) ";
    }

}
