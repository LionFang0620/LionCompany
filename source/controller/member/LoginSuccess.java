package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import controller.member.Login;
import controller.porder.AddPorder;
import model.Member;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginSuccess extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccess frame = new LoginSuccess();
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
	public LoginSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(33, 52, 72));
		panel.setBounds(9, 10, 300, 35);
		contentPane.add(panel);
		
		JLabel welcome = new JLabel("");
		welcome.setForeground(new Color(255, 245, 228));
		welcome.setBounds(0, 0, 215, 35);
		panel.add(welcome);
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		Member m=(Member)Tool.readFile("member.txt");
		String show=m.getName()+",歡迎登入";
		welcome.setText(show);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(84, 119, 146));
		panel_1.setBounds(9, 55, 300, 305);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("請選擇要使用的服務");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(0, 4, 300, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(33, 52, 72));
		panel_2.setBounds(9, 38, 280, 25);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("商品訂購");
		lblNewLabel_1_1_1.setBounds(104, 0, 72, 25);
		panel_2.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(33, 52, 72));
		panel_2_1.setBounds(10, 222, 280, 25);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("會員資料管理");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_1_1.setBounds(95, 0, 90, 20);
		panel_2_1.add(lblNewLabel_1_1_1_1);
		
		/**按鈕的家**/
		JButton btnNewButton_3 = new JButton("登出");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login=new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setForeground(new Color(255, 245, 228));
		btnNewButton_3.setBackground(new Color(15, 84, 145));
		btnNewButton_3.setBounds(225, 6, 70, 25);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("大全聯線上超市");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorder ap=new AddPorder();
				ap.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 245, 228));
		btnNewButton_1.setBackground(new Color(15, 84, 145));
		btnNewButton_1.setBounds(9, 68, 280, 40);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("查詢/修改/刪除資料");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateMember um=new UpdateMember();
				um.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 245, 228));
		btnNewButton.setBackground(new Color(15, 84, 145));
		btnNewButton.setBounds(11, 255, 280, 40);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("查詢訂單");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//CheckPorder cp=new CheckPorder();
				//cp.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setForeground(new Color(255, 245, 228));
		btnNewButton_2.setBackground(new Color(15, 84, 145));
		btnNewButton_2.setBounds(9, 116, 280, 40);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_2_2 = new JButton("刪除訂單");
		btnNewButton_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//DeletePorder dp=new DeletePorder();
				//dp.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_2_2.setForeground(new Color(255, 245, 228));
		btnNewButton_2_2.setBackground(new Color(15, 84, 145));
		btnNewButton_2_2.setBounds(9, 163, 280, 40);
		panel_1.add(btnNewButton_2_2);

	}
}
