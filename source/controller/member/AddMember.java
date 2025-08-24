package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;
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

public class AddMember extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JTextField name;
	private JTextField address;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMember frame = new AddMember();
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
	public AddMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(33, 52, 72));
		panel.setBounds(9, 10, 301, 35);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("註冊會員");
		lblNewLabel.setForeground(new Color(255, 245, 228));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 0, 300, 35);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(84, 119, 146));
		panel_1.setBounds(9, 55, 301, 299);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(30, 92, 35, 25);
		panel_1.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(75, 92, 205, 25);
		panel_1.add(username);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼");
		lblNewLabel_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(30, 132, 35, 25);
		panel_1.add(lblNewLabel_1_1);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(75, 132, 205, 25);
		panel_1.add(password);
		
		JLabel lblNewLabel_2 = new JLabel("請填寫以下資料");
		lblNewLabel_2.setForeground(new Color(255, 245, 228));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_2.setBounds(0, 10, 301, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("姓名");
		lblNewLabel_1_2.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(30, 44, 35, 25);
		panel_1.add(lblNewLabel_1_2);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(75, 44, 205, 25);
		panel_1.add(name);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("地址");
		lblNewLabel_1_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(30, 175, 35, 25);
		panel_1.add(lblNewLabel_1_1_1);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(75, 175, 205, 25);
		panel_1.add(address);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("電話");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(30, 220, 35, 25);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(75, 220, 205, 25);
		panel_1.add(phone);
		
		/**按鈕的家**/
		JButton btnNewButton = new JButton("確認註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=name.getText();
				String Username=username.getText();
				String Password=password.getText();
				String Address=address.getText();
				String Phone=phone.getText();
				Member m=new Member(Name,Username,Password,Address,Phone);
				if(Name.equals("")||Username.equals("")||Password.equals(""))
				{
					JOptionPane.showMessageDialog(null, "姓名/帳號/密碼不能是空白的","錯誤", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(new MemberServiceImpl().addMember(m))
					{
						
						JOptionPane.showMessageDialog(null, "註冊成功，即將進入系統","提示", JOptionPane.INFORMATION_MESSAGE);
						Tool.saveFile(m,"member.txt");
						LoginSuccess ls=new LoginSuccess ();
		                ls.setVisible(true);
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
		btnNewButton.setBounds(195, 263, 85, 25);
		btnNewButton.setForeground(new Color(255, 245, 228));
		btnNewButton.setBackground(new Color(15, 84, 145));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回登入");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login=new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 245, 228));
		btnNewButton_1.setBackground(new Color(15, 84, 145));
		btnNewButton_1.setBounds(29, 264, 85, 25);
		panel_1.add(btnNewButton_1);

	}
}
