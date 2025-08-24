package controller.product;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.employee.Backstage;
import controller.employee.EmployeeLogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import model.Category;
import service.impl.CategoryServiceImpl;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class AddCategory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField createName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCategory frame = new AddCategory();
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
	public AddCategory() {
		CategoryServiceImpl csi=new CategoryServiceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 410, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(33, 52, 72));
		panel.setBounds(8, 10, 380, 35);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("調整分類");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 245, 228));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel.setBounds(151, 0, 78, 35);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(84, 119, 146));
		panel_1.setBounds(8, 56, 380, 417);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("名稱");
		lblNewLabel_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(16, 279, 35, 25);
		panel_1.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(61, 279, 160, 25);
		panel_1.add(name);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(33, 52, 72));
		panel_2.setBounds(13, 209, 350, 25);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("修改分類，請先選取要修改的資料");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(63, 0, 223, 25);
		panel_2.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("編號");
		lblNewLabel_1_2.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(16, 244, 35, 25);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel id = new JLabel("");
		id.setForeground(new Color(255, 245, 228));
		id.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		id.setBounds(59, 244, 160, 25);
		panel_1.add(id);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(new Color(33, 52, 72));
		panel_2_1_1.setBounds(13, 9, 350, 25);
		panel_1.add(panel_2_1_1);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("所有分類資料如下");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_3.setBounds(100, 0, 149, 25);
		panel_2_1_1.add(lblNewLabel_1_1_3);
		
		String[] columnNames = {"編號", "名稱"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table=new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(13, 42, 350, 120);
		panel_1.add(scrollPane);
		
        List<Category> list = csi.findAllCategory();
        for(Category c : list) {
            Object[] row = {
                c.getId(),
                c.getName(),
            };
            tableModel.addRow(row);
        }
		
		/**點選資料，將資料放入下面輸入框中**/
		table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                id.setText(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 1).toString());
            }
        });
	
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(33, 52, 72));
		panel_2_1.setBounds(13, 324, 350, 25);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("新增分類，請填入要新增的名稱");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_2_1.setBounds(70, 0, 209, 25);
		panel_2_1.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("名稱");
		lblNewLabel_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(16, 363, 35, 25);
		panel_1.add(lblNewLabel_1_1);
		
		createName = new JTextField();
		createName.setBounds(61, 363, 160, 25);
		panel_1.add(createName);
		
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
		btnNewButton_3.setBounds(301, 5, 70, 25);
		panel.add(btnNewButton_3);
		
		JButton btnUpdate = new JButton("修改資料");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			        if (id.getText().isEmpty()) 
			        {
			            JOptionPane.showMessageDialog(null, "請先選擇要修改的項目！", "錯誤", JOptionPane.ERROR_MESSAGE);
			            return;
			        }

			        Category c = new Category();
			        c.setId(Integer.parseInt(id.getText()));
			        c.setName(name.getText());

			        if (csi.updateCategory(c)) 
			        {
			            JOptionPane.showMessageDialog(null, "修改成功，點擊確認後將更新資料", "提示", JOptionPane.INFORMATION_MESSAGE);
			            tableModel.setRowCount(0);
			            List<Category> newList = csi.findAllCategory();
			            for (Category emp : newList) 
			            {
			                tableModel.addRow(new Object[]{emp.getId(), emp.getName()});
			            }
			            id.setText("");
			            name.setText("");

			        } 
			        else 
			        {
			            JOptionPane.showMessageDialog(null, "修改失敗：名稱不得重複", "錯誤", JOptionPane.ERROR_MESSAGE);
			        }

			    } 
				catch (Exception ex) 
				{
			        JOptionPane.showMessageDialog(null, "修改過程中發生錯誤：" + ex.getMessage(), "錯誤", JOptionPane.ERROR_MESSAGE);
			    }
			}
		});
		btnUpdate.setForeground(new Color(255, 245, 228));
		btnUpdate.setBackground(new Color(15, 84, 145));
		btnUpdate.setBounds(248, 279, 115, 25);
		panel_1.add(btnUpdate);
		
		JButton btnNewButton_1 = new JButton("回上一頁");
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
		btnNewButton_1.setBounds(16, 171, 115, 25);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_3_1 = new JButton("刪除選中資料");
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (id.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "請先選擇一筆資料！", 
		            		"提示", JOptionPane.WARNING_MESSAGE);
		            return;
		        }
				int delete=Integer.parseInt(id.getText());
				Category c=new Category();
				String message ="確認要刪除這個分類嗎？"+"\n"
								+"\nID："+id.getText()
								+"\n名稱："+name.getText();
				c.setId(delete);
				Object[]options= {"刪除","取消"};
				int confirm=JOptionPane.showOptionDialog(null, message, "刪除確認", 
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options,options[1]);
				if(confirm==0)
				{
					if(csi.deleteCategory(c))
					{
						JOptionPane.showMessageDialog(null, "刪除成功", 
								"提示", JOptionPane.INFORMATION_MESSAGE);
						tableModel.setRowCount(0); // 清空舊資料
						List<Category> newList = csi.findAllCategory();
						for(Category emp : newList) {
						    tableModel.addRow(new Object[]{emp.getId(), emp.getName()});
						}
						id.setText("");
						name.setText("");
					}
				}
				else if (confirm == 1 || confirm == JOptionPane.CLOSED_OPTION) 
				{ 
		            JOptionPane.showMessageDialog(null,"已取消刪除", "提示",JOptionPane.INFORMATION_MESSAGE);
		        }
			}
		});
		btnNewButton_3_1.setForeground(new Color(255, 245, 228));
		btnNewButton_3_1.setBackground(new Color(15, 84, 145));
		btnNewButton_3_1.setBounds(248, 172, 115, 25);
		panel_1.add(btnNewButton_3_1);
		
		JButton btnUpdate_1 = new JButton("確認新增");
		btnUpdate_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=createName.getText();
				Category c=new Category(Name);
				if(Name.equals(""))
				{
					JOptionPane.showMessageDialog(null, "名稱不能是空白的","錯誤", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(new CategoryServiceImpl().addCategory(c))
					{
						JOptionPane.showMessageDialog(null,"新增成功，確認後將更新資料", "提示",JOptionPane.INFORMATION_MESSAGE);
						tableModel.setRowCount(0);
						List<Category> newList = csi.findAllCategory();
						for(Category emp : newList) 
						{
						    tableModel.addRow(new Object[]{emp.getId(), emp.getName()});
						}
						createName.setText("");
					}
					
					else
					{
						JOptionPane.showMessageDialog(null, "新增失敗：名稱不得重複", "錯誤", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnUpdate_1.setForeground(new Color(255, 245, 228));
		btnUpdate_1.setBackground(new Color(15, 84, 145));
		btnUpdate_1.setBounds(248, 363, 115, 25);
		panel_1.add(btnUpdate_1);
	}
}
