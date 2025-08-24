package controller.employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.product.AddCategory;
import controller.product.UpdateProduct;
import model.Employee;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Backstage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Backstage frame = new Backstage();
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
	public Backstage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 335, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(33, 52, 72));
		panel.setBounds(10, 10, 300, 35);
		contentPane.add(panel);
		
		JLabel welcome = new JLabel("");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setForeground(new Color(255, 245, 228));
		welcome.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		welcome.setBounds(0, 0, 215, 35);
		Employee employee=(Employee)Tool.readFile("employee.txt");
		welcome.setText(employee.getName()+"管理員登入中");
		panel.add(welcome);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(84, 119, 146));
		panel_1.setBounds(10, 55, 300, 365);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("請選擇要使用的服務");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(0, 4, 300, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(33, 52, 72));
		panel_2.setBounds(10, 38, 280, 25);
		panel_1.add(panel_2);
		
		/**按鈕的家**/
		JButton btnNewButton_3 = new JButton("登出");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployeeLogin el=new EmployeeLogin();
				el.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setForeground(new Color(255, 245, 228));
		btnNewButton_3.setBackground(new Color(15, 84, 145));
		btnNewButton_3.setBounds(225, 6, 70, 25);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("貨物調整");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(104, 0, 72, 25);
		panel_2.add(lblNewLabel_1_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(33, 52, 72));
		panel_2_1.setBounds(10, 179, 280, 25);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("其他");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(95, 0, 90, 20);
		panel_2_1.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton_1 = new JButton("確認/調整分類");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddCategory ac=new AddCategory();
				ac.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 245, 228));
		btnNewButton_1.setBackground(new Color(15, 84, 145));
		btnNewButton_1.setBounds(10, 68, 280, 40);
		panel_1.add(btnNewButton_1);
		
		JButton btnexcel = new JButton("顧客訂單確認");
		btnexcel.setForeground(new Color(255, 245, 228));
		btnexcel.setBackground(new Color(15, 84, 145));
		btnexcel.setBounds(10, 263, 280, 40);
		panel_1.add(btnexcel);
		
		JButton btnNewButton_2_1 = new JButton("報表與圖表生成");
		btnNewButton_2_1.setForeground(new Color(255, 245, 228));
		btnNewButton_2_1.setBackground(new Color(15, 84, 145));
		btnNewButton_2_1.setBounds(10, 313, 280, 40);
		panel_1.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("調整管理員");
		btnNewButton_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Updateemployee ue=new Updateemployee();
				ue.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1_1.setForeground(new Color(255, 245, 228));
		btnNewButton_2_1_1.setBackground(new Color(15, 84, 145));
		btnNewButton_2_1_1.setBounds(10, 213, 280, 40);
		panel_1.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2 = new JButton("確認/調整商品");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateProduct up = new UpdateProduct();
				up.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(10, 118, 280, 40);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setForeground(new Color(255, 245, 228));
		btnNewButton_2.setBackground(new Color(15, 84, 145));

	}

}
