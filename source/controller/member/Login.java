package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Welcome;
//import controller.member.AddMember;
//import controller.member.LoginSuccess;
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
import javax.swing.JPasswordField;

public class Login extends JFrame {

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
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 264, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(33, 52, 72));
		panel.setBounds(5, 10, 240, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("歡迎使用大全聯會員系統");
		lblNewLabel.setForeground(new Color(255, 245, 228));
		lblNewLabel.setBackground(new Color(255, 245, 228));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel.setBounds(0, 0, 175, 35);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("返回");
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
		btnNewButton_2.setBounds(176, 6, 59, 25);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(84, 119, 146));
		panel_1.setBounds(5, 51, 240, 138);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(11, 13, 35, 25);
		panel_1.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(54, 13, 177, 25);
		panel_1.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼");
		lblNewLabel_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(11, 49, 35, 25);
		panel_1.add(lblNewLabel_1_1);
		
		password = new JPasswordField();
		password.setBounds(54, 48, 177, 25);
		panel_1.add(password);
		
		/***按鈕的家***/
		JButton btnNewButton = new JButton("註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMember addmember = new AddMember();
				addmember.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 245, 228));
		btnNewButton.setBackground(new Color(15, 84, 145));
		btnNewButton.setBounds(11, 99, 85, 25);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("登入");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				String Password=new String(password.getPassword());
				Member m=new MemberServiceImpl().login(Username, Password);
				if(m!=null)
				{
					Tool.saveFile(m,"member.txt");
					JOptionPane.showMessageDialog(null, "登入成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					LoginSuccess ls=new LoginSuccess();
					ls.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "帳號不存在請先註冊", "警告", JOptionPane.WARNING_MESSAGE);
					dispose();
					AddMember am=new AddMember();
					am.setVisible(true);
				}
				
			}
		});
		btnNewButton_1.setForeground(new Color(255, 245, 228));
		btnNewButton_1.setBackground(new Color(15, 84, 145));
		btnNewButton_1.setBounds(146, 99, 85, 25);
		panel_1.add(btnNewButton_1);
		

	}
}
