package controller.employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Welcome;
import model.Employee;
import service.impl.EmployeeServiceImpl;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeLogin frame = new EmployeeLogin();
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
	public EmployeeLogin() {
		EmployeeServiceImpl esi=new EmployeeServiceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 264, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(33, 52, 72));
		panel.setBounds(5, 3, 240, 35);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("歡迎使用後台管理系統");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 245, 228));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel.setBackground(new Color(255, 245, 228));
		lblNewLabel.setBounds(43, 0, 153, 35);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(84, 119, 146));
		panel_1.setBounds(5, 44, 240, 134);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(11, 13, 35, 25);
		panel_1.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(55, 13, 177, 25);
		panel_1.add(username);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼");
		lblNewLabel_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(11, 49, 35, 25);
		panel_1.add(lblNewLabel_1_1);
		
		password = new JPasswordField();
		password.setBounds(55, 48, 177, 25);
		panel_1.add(password);
		
		JButton btnNewButton_1 = new JButton("登入");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				Employee employee=esi.Employeelogin(Username, Password);
				if(employee!=null)
				{
					Tool.saveFile(employee, "employee.txt");
					JOptionPane.showMessageDialog(null, "登入成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					Backstage bt=new Backstage();
					bt.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "管理員帳號不存在請先新增", "警告", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnNewButton_1.setForeground(new Color(255, 245, 228));
		btnNewButton_1.setBackground(new Color(15, 84, 145));
		btnNewButton_1.setBounds(132, 93, 98, 25);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("回上一頁");
		btnNewButton_2.setBounds(11, 93, 98, 25);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Welcome wel=new Welcome();
				wel.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setForeground(new Color(255, 245, 228));
		btnNewButton_2.setBackground(new Color(15, 84, 145));

	}
}
