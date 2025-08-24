package controller.employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Employee;
import service.impl.EmployeeServiceImpl;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddEmployee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
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
	public AddEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 335, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(33, 52, 72));
		panel.setBounds(7, 3, 301, 35);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("新增管理員");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 245, 228));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 0, 300, 35);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(84, 119, 146));
		panel_1.setBounds(9, 48, 301, 215);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(24, 84, 35, 25);
		panel_1.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(70, 84, 205, 25);
		panel_1.add(username);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼");
		lblNewLabel_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(24, 126, 35, 25);
		panel_1.add(lblNewLabel_1_1);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(70, 126, 205, 25);
		panel_1.add(password);
		
		JLabel lblNewLabel_2 = new JLabel("請填寫以下資料");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 245, 228));
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_2.setBounds(0, 6, 301, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("姓名");
		lblNewLabel_1_2.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(24, 38, 35, 25);
		panel_1.add(lblNewLabel_1_2);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(70, 38, 205, 25);
		panel_1.add(name);
		
		/**按鈕的家**/
		JButton btnNewButton = new JButton("確認新增");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=name.getText();
				String Username=username.getText();
				String Password=password.getText();
				Employee employee=new Employee(Name,Username,Password);
				if(Name.equals("")||Username.equals("")||Password.equals(""))
				{
					JOptionPane.showMessageDialog(null, "姓名/帳號/密碼不能是空白的","錯誤", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(new EmployeeServiceImpl().addEmployee(employee))
					{
						JOptionPane.showMessageDialog(null, "新增成功","提示", JOptionPane.INFORMATION_MESSAGE);
						Tool.saveFile(employee,"employee.txt");
						Updateemployee ue=new Updateemployee();
						ue.setVisible(true);
						dispose();	
					}
					
					else
					{
						JOptionPane.showMessageDialog(null, "帳號已存在請嘗試其他字串","錯誤", JOptionPane.ERROR_MESSAGE);
						username.setText("");
					}
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 245, 228));
		btnNewButton.setBackground(new Color(15, 84, 145));
		btnNewButton.setBounds(193, 172, 85, 25);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("回上一頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Updateemployee ue=new Updateemployee();
				ue.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 245, 228));
		btnNewButton_1.setBackground(new Color(15, 84, 145));
		btnNewButton_1.setBounds(24, 172, 85, 25);
		panel_1.add(btnNewButton_1);

	}

}
