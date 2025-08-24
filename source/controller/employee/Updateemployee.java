package controller.employee;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Employee;
import service.impl.EmployeeServiceImpl;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;



public class Updateemployee extends JFrame {
	private DefaultTableModel tableModel;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_1_1_2;
	private JPanel panel_2_1_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	private JTable table;
	private JTextField username;
	private JTextField password;
	private JTextField name;
	private JButton btnUpdate;
	private JLabel lblNewLabel_1_1_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updateemployee frame = new Updateemployee();
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
	public Updateemployee() {
		EmployeeServiceImpl esi=new EmployeeServiceImpl();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(33, 52, 72));
		panel.setBounds(10, 10, 555, 35);
		contentPane.add(panel);
		
		lblNewLabel = new JLabel("調整管理員");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 245, 228));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel.setBounds(237, 0, 80, 35);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(84, 119, 146));
		panel_1.setBounds(10, 55, 555, 357);
		contentPane.add(panel_1);
        
		lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 285, 35, 25);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_1_1 = new JLabel("密碼");
		lblNewLabel_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(297, 285, 35, 25);
		panel_1.add(lblNewLabel_1_1);
		
		lblNewLabel_1_1_1 = new JLabel("帳號");
		lblNewLabel_1_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(298, 250, 35, 25);
		panel_1.add(lblNewLabel_1_1_1);
		
		username = new JTextField();
		username.setBounds(344, 250, 200, 25);
		panel_1.add(username);
		
		password = new JTextField();
		password.setBounds(344, 285, 200, 25);
		panel_1.add(password);
		
		name = new JTextField();
		name.setBounds(53, 285, 200, 25);
		panel_1.add(name);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(33, 52, 72));
		panel_2.setBounds(9, 214, 535, 25);
		panel_1.add(panel_2);
		
		lblNewLabel_1_1_2 = new JLabel("請先選取一筆資料，再調整要修改的欄位");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(137, 0, 260, 25);
		panel_2.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("編號");
		lblNewLabel_1_2.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 249, 35, 25);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel id = new JLabel("");
		id.setForeground(new Color(255, 245, 228));
		id.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		id.setBounds(53, 250, 200, 25);
		panel_1.add(id);
		
		panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(new Color(33, 52, 72));
		panel_2_1_1.setBounds(10, 9, 534, 25);
		panel_1.add(panel_2_1_1);
		
		lblNewLabel_1_1_3 = new JLabel("所有管理員資料如下");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_3.setBounds(192, 0, 149, 25);
		panel_2_1_1.add(lblNewLabel_1_1_3);
		
		/**產生table表格**/
		String[] columnNames = {"編號", "姓名", "帳號", "密碼"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table=new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(11, 44, 534, 120);
		panel_1.add(scrollPane);
		
        List<Employee> list = esi.findAll();
        for(Employee emp : list) {
            Object[] row = {
                emp.getId(),
                emp.getName(),
                emp.getUsername(),
                emp.getPassword(),
            };
            tableModel.addRow(row);
        }
		
		
		
		/**點選資料，將資料放入下面輸入框框中**/
		table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                id.setText(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 1).toString());
                username.setText(table.getValueAt(row, 2).toString());
                password.setText(table.getValueAt(row, 3).toString());
            }
        });
        
		/**按鈕的家**/
		btnUpdate = new JButton("修改資料");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=name.getText();
				String Username=username.getText();
				String Password=password.getText();
				Employee employee=new Employee();
				employee.setId(Integer.parseInt(id.getText()));
				employee.setName(Name);
				employee.setUsername(Username);
				employee.setPassword(Password);
				if(esi.updateData(employee))
				{
					JOptionPane.showMessageDialog(null, "修改成功，點擊確認後將更新資料", "提示", JOptionPane.INFORMATION_MESSAGE);
					tableModel.setRowCount(0); // 清空舊資料
					List<Employee> newList = esi.findAll();
					for(Employee emp : newList) {
					    tableModel.addRow(new Object[]{emp.getId(), emp.getName(), emp.getUsername(), emp.getPassword()});
					}
					id.setText("");
					name.setText("");
					username.setText("");
					password.setText("");
				}
				
			}
		});
		btnUpdate.setForeground(new Color(255, 245, 228));
		btnUpdate.setBackground(new Color(15, 84, 145));
		btnUpdate.setBounds(429, 320, 115, 25);
		panel_1.add(btnUpdate);
		
		btnNewButton_1 = new JButton("回上一頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Backstage bs=new Backstage();
				bs.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 245, 228));
		btnNewButton_1.setBackground(new Color(15, 84, 145));
		btnNewButton_1.setBounds(296, 173, 115, 25);
		panel_1.add(btnNewButton_1);
		
		btnNewButton_3 = new JButton("刪除選中資料");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (id.getText().isEmpty()) {
			            JOptionPane.showMessageDialog(null, "請先選擇一筆資料！", 
			            		"提示", JOptionPane.WARNING_MESSAGE);
			            return;
			        }
				int delete=Integer.parseInt(id.getText());
				Employee employee=new Employee();
				String message = "確認要刪除這個管理員嗎？\n\n"
	                       + "ID： " + delete + "\n"
	                       + "姓名： " + name.getText() + "\n"
	                       + "帳號：" + username.getText();
				employee.setId(delete);
				Object[]options= {"刪除","取消"};
				int confirm=JOptionPane.showOptionDialog(null, message, "刪除確認", 
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options,options[1]);
				if(confirm==0) 
				{
					if(esi.deleteData(employee))
					{
						JOptionPane.showMessageDialog(null, "刪除成功", 
								"提示", JOptionPane.INFORMATION_MESSAGE);
						tableModel.setRowCount(0); // 清空舊資料
						List<Employee> newList = esi.findAll();
						for(Employee emp : newList) {
						    tableModel.addRow(new Object[]{emp.getId(), emp.getName(), emp.getUsername(), emp.getPassword()});
						}
						id.setText("");
						name.setText("");
						username.setText("");
						password.setText("");
					}
				}
				else if (confirm == 1 || confirm == JOptionPane.CLOSED_OPTION) 
				{ 
		            JOptionPane.showMessageDialog(null,"已取消刪除", "提示",JOptionPane.INFORMATION_MESSAGE);
		        }
				
			}
		});
		btnNewButton_3.setForeground(new Color(255, 245, 228));
		btnNewButton_3.setBackground(new Color(15, 84, 145));
		btnNewButton_3.setBounds(429, 173, 115, 25);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_3_1_1 = new JButton("新增管理員");
		btnNewButton_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddEmployee ae=new AddEmployee();
				ae.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3_1_1.setForeground(new Color(255, 245, 228));
		btnNewButton_3_1_1.setBackground(new Color(15, 84, 145));
		btnNewButton_3_1_1.setBounds(10, 174, 115, 25);
		panel_1.add(btnNewButton_3_1_1);
		
		btnNewButton = new JButton("登出");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployeeLogin el=new EmployeeLogin();
				el.setVisible(true);
				dispose();
				}
		});
		btnNewButton.setForeground(new Color(255, 245, 228));
		btnNewButton.setBackground(new Color(15, 84, 145));
		btnNewButton.setBounds(471, 5, 70, 25);
		panel.add(btnNewButton);
		
	}
    }




