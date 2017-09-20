package clientGUI;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
//import javax.swing.JScrollPane;
import javax.swing.JScrollPane;

public class InputOutput extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Input;
	private JTextArea textField_Output;
	private JButton btnRun;
	private JTextField IP_input;
	private JTextField Port_input;
	private JButton conn_button;
	//private JScrollPane scroll;
	
	
	public String s;
	
	public String output;
	/**
	 * Launch the application.
	*/
	

	/**
	 * Create the frame.
	 */
	public InputOutput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IP_input = new JTextField("");
		IP_input.setBounds(43, 45, 141, 29);
		contentPane.add(IP_input);
		

		Port_input = new JTextField("");
		Port_input.setBounds(216, 45, 141, 29);
		contentPane.add(Port_input);
		
	
		conn_button = new JButton("Connect!");
		conn_button.setBounds(369, 45, 115, 29);
		contentPane.add(conn_button);
		
		textField_Input = new JTextField("");
		textField_Input.setBounds(43, 113, 314, 29);
		contentPane.add(textField_Input);
		textField_Input.setColumns(10);
		
		JLabel lblInputData = new JLabel("Input Command");
		lblInputData.setBounds(43, 86, 131, 15);
		contentPane.add(lblInputData);
		
		textField_Output = new JTextArea("");
		textField_Output.setEditable(true);
		textField_Output.setBounds(43, 181, 407, 179);
		contentPane.add(textField_Output);
		textField_Output.setColumns(10);
		
		
		JLabel lblOutputData = new JLabel("Output Result");
		lblOutputData.setBounds(43, 154, 141, 20);
		contentPane.add(lblOutputData);
		
		btnRun = new JButton("Run");
		btnRun.setBounds(369, 113, 115, 29);
		contentPane.add(btnRun);
		
		JLabel lblIp = new JLabel("IP");
		lblIp.setBounds(43, 12, 70, 29);
		contentPane.add(lblIp);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(220, 19, 70, 15);
		contentPane.add(lblPort);
		
		JScrollPane scrollPane = new JScrollPane(textField_Output);
		scrollPane.setBounds(43, 181, 447, 219);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(scrollPane);

		
		
		
		
	}
	
	public void assignListener(ActionListener executeCommand){
		btnRun.addActionListener(executeCommand);
	}
		
	public String getCommand() {
		s=textField_Input.getText();
		return s;
	}

	public void displayResult(String output) {
		textField_Output.setText(output);
	}
	
	public String getIP(){
		return IP_input.getText();		
	}
	
	public int getPort(){
		return Integer.parseInt(Port_input.getText());		
	}

	public void connect(ActionListener Connect){
		conn_button.addActionListener(Connect);	
	}
}	

