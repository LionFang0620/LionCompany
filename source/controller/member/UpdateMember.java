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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateMember extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField password;
	private JTextField address;
	private JTextField phone;
	private JTextField deleteusername;
	private JTextField deletepassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateMember frame = new UpdateMember();
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
	public UpdateMember() {
		MemberServiceImpl msi=new MemberServiceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(33, 52, 72));
		panel.setBounds(9, 10, 555, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("查詢/修改/刪除資料");
		lblNewLabel.setForeground(new Color(255, 245, 228));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel.setBounds(205, 0, 144, 35);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(84, 119, 146));
		panel_1.setBounds(9, 55, 555, 396);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel MemberName = new JLabel("");
		MemberName.setForeground(new Color(255, 245, 228));
		MemberName.setHorizontalAlignment(SwingConstants.CENTER);
		MemberName.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		MemberName.setBounds(10, 11, 213, 25);
		panel_1.add(MemberName);
		Member m=(Member)Tool.readFile("member.txt");
		String show=m.getName()+"，以下是您的資料";
		MemberName.setText(show);
		
		JTextArea MemberData = new JTextArea();
		MemberData.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		MemberData.setBounds(10, 45, 213, 302);
		panel_1.add(MemberData);
		
		String show2="\n"
					+" 姓名："+m.getName()
					+"\n 密碼："+m.getPassword()
					+"\n 地址："+m.getAddress()
					+"\n 電話："+m.getPhone();
		MemberData.setText(show2);
		
		JLabel lblNewLabel_1_2 = new JLabel("姓名");
		lblNewLabel_1_2.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(247, 43, 35, 25);
		panel_1.add(lblNewLabel_1_2);
		
	
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(295, 43, 243, 25);
		panel_1.add(name);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("密碼");
		lblNewLabel_1_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(247, 82, 35, 25);
		panel_1.add(lblNewLabel_1_1_1);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(294, 82, 244, 25);
		panel_1.add(password);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("地址");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(247, 120, 35, 25);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(294, 120, 244, 25);
		panel_1.add(address);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("電話");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(247, 157, 35, 25);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(294, 157, 244, 25);
		panel_1.add(phone);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("帳號");
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(247, 279, 35, 25);
		panel_1.add(lblNewLabel_1_1_1_1_1_1);
		
		deleteusername = new JTextField();
		deleteusername.setColumns(10);
		deleteusername.setBounds(294, 279, 244, 25);
		panel_1.add(deleteusername);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("密碼");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(247, 318, 35, 25);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1);
		
		deletepassword = new JTextField();
		deletepassword.setColumns(10);
		deletepassword.setBounds(294, 318, 244, 25);
		panel_1.add(deletepassword);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(33, 52, 72));
		panel_2.setBounds(247, 11, 291, 25);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("請輸入要修改的資料");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_2_1.setBounds(39, 0, 213, 25);
		panel_2.add(lblNewLabel_1_1_2_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(33, 52, 72));
		panel_2_1.setBounds(247, 244, 291, 25);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("若要刪除資料，請輸入帳號密碼");
		lblNewLabel_1_1_2.setBounds(28, 0, 213, 25);
		panel_2_1.add(lblNewLabel_1_1_2);
		lblNewLabel_1_1_2.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(new Color(33, 52, 72));
		panel_2_1_1.setBounds(10, 11, 213, 25);
		panel_1.add(panel_2_1_1);
		
		/**按鈕的家**/
		//回上一頁鈕，點擊回到成功登入頁面
		JButton btnNewButton_1_1 = new JButton("回上一頁");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.saveFile(m, "member.txt");
				LoginSuccess ls=new LoginSuccess();
				ls.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1_1.setForeground(new Color(255, 245, 228));
		btnNewButton_1_1.setBackground(new Color(15, 84, 145));
		btnNewButton_1_1.setBounds(138, 357, 85, 25);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton = new JButton("確認修改");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String loginUsername = m.getUsername(); 
				String Name=name.getText();
				String Password=password.getText();
				String Address=address.getText();
				String Phone=phone.getText();
				Member member=new Member();
				member.setUsername(loginUsername);
				member.setName(Name);
				member.setPassword(Password);
				member.setAddress(Address);
				member.setPhone(Phone);
				if(msi.updateMemberData(member))
				{
					JOptionPane.showMessageDialog(null, "修改成功，左側資料已更新", "提示", JOptionPane.INFORMATION_MESSAGE);
					name.setText("");
					password.setText("");
					address.setText("");
					phone.setText("");
					Tool.saveFile(member,"member.txt");
					String show=member.getName()+"，以下是您的資料";
					MemberName.setText(show);
					String show2="\n"
							+" 姓名："+member.getName()
							+"\n 密碼："+member.getPassword()
							+"\n 地址："+member.getAddress()
							+"\n 電話："+member.getPhone();
					MemberData.setText(show2);
				}
				else
				{
					
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 245, 228));
		btnNewButton.setBackground(new Color(15, 84, 145));
		btnNewButton.setBounds(453, 192, 85, 25);
		panel_1.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("確認刪除");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=deleteusername.getText();
				String Password=deletepassword.getText();
				Member member=new Member();
				member.setUsername(Username);
				member.setPassword(Password);
				Object[]options= {"刪除","取消"};
				int confirm=JOptionPane.showOptionDialog(null, "確認要刪除這個會員嗎？", "刪除確認", 
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options,options[1]);
				if(confirm==0) 
				{
					if(msi.deleteMemberData(member))
					{
						JOptionPane.showMessageDialog(null, "刪除成功，確認後將自動關閉視窗", "提示", JOptionPane.INFORMATION_MESSAGE);
						dispose();
		                System.exit(0);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "請再確認資料是否正確", "警告", JOptionPane.ERROR_MESSAGE);
					}
	
				}
				
				else if (confirm == 1 || confirm == JOptionPane.CLOSED_OPTION) 
				{ 
		            JOptionPane.showMessageDialog(null,"已取消刪除", "提示",JOptionPane.INFORMATION_MESSAGE);
		        }
			}
		});
		btnNewButton_1.setForeground(new Color(255, 245, 228));
		btnNewButton_1.setBackground(new Color(15, 84, 145));
		btnNewButton_1.setBounds(453, 357, 85, 25);
		panel_1.add(btnNewButton_1);
		
		
				
		JButton btnNewButton_3 = new JButton("登出");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lo=new Login();
				lo.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setForeground(new Color(255, 245, 228));
		btnNewButton_3.setBackground(new Color(15, 84, 145));
		btnNewButton_3.setBounds(471, 5, 70, 25);
		panel.add(btnNewButton_3);
	
	}
}
