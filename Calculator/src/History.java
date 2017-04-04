import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class History extends JFrame {

    private JPanel contentPane;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JTextArea textArea;

    public JTextArea getTextArea() {
	return textArea;
    }

    public void setTextArea(JTextArea textArea) {
	this.textArea = textArea;
    }

    // 파일저장에 필요한 BufferedWriter와 JFileChooser 생성
    private BufferedWriter out;
    private JFileChooser filechooser = new JFileChooser();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    History frame = new History();
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
    public History() {
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	// 히스토리를 초기화하는 버튼생성
	btnNewButton = new JButton("Clear History");
	btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		textArea.setText("");
	    }
	});
	btnNewButton.setBounds(59, 219, 117, 27);
	contentPane.add(btnNewButton);

	/*
	 * 히스토리의 내용을 파일로저장하는 버튼 생성 JFilechooser로 저장경로를 보여주고 저장경로를 File에 저장한뒤
	 * FileWriter를 통해 파일을 저장한다
	 */
	btnNewButton_1 = new JButton("Save to file");
	btnNewButton_1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		try {
		    filechooser.showSaveDialog(btnNewButton_1);
		    File file = filechooser.getSelectedFile();
		    FileWriter fw = new FileWriter(file);
		    out = new BufferedWriter(fw);
		    out.write(textArea.getText());
		    out.flush();
		    out.close();

		} catch (IOException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}

	    }
	});
	btnNewButton_1.setBounds(257, 219, 127, 27);
	contentPane.add(btnNewButton_1);

	// 히스토리의 내용을 저장할 JtextArea
	textArea = new JTextArea();
	textArea.setBounds(14, 12, 404, 187);
	contentPane.add(textArea);
	textArea.setEditable(true);

	JScrollPane scrollPane = new JScrollPane(textArea);
	scrollPane.setBounds(5, 5, 422, 199);
	contentPane.add(scrollPane);

    }
}