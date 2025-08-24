package controller.product;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.employee.Backstage;
import controller.employee.EmployeeLogin;
import model.Category;
import model.Product;
import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JComboBox;

public class UpdateProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private JTable table;
	private JPanel contentPane;
	private JTextField name;
	private JTextField price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProduct frame = new UpdateProduct();
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
	public UpdateProduct() {
		CategoryServiceImpl csi=new CategoryServiceImpl();
		ProductServiceImpl psi=new ProductServiceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 590, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(33, 52, 72));
		panel.setBounds(10, 10, 556, 35);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("調整商品");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 245, 228));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel.setBounds(239, 0, 78, 35);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(84, 119, 146));
		panel_1.setBounds(10, 56, 556, 404);
		contentPane.add(panel_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(new Color(33, 52, 72));
		panel_2_1_1.setBounds(13, 9, 533, 25);
		panel_1.add(panel_2_1_1);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("商品資料如下");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_3.setBounds(218, 0, 96, 25);
		panel_2_1_1.add(lblNewLabel_1_1_3);
		
		List<Category>category=csi.findAllCategory();
		JComboBox<Category> categoryCombo = new JComboBox<>();
		for(Category c:category)
		{
			categoryCombo.addItem(c);
		}
		categoryCombo.setBounds(13, 40, 160, 25);
		panel_1.add(categoryCombo);
		
		/**產生JTable**/
		String[] columnNames = {"編號", "分類ID", "名稱", "價格"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table=new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 70, 534, 120);
		panel_1.add(scrollPane);
		
		/**監聽JComboBox的輸入，根據categoryId從資料庫撈取對應產品顯示在JTabel中**/
		categoryCombo.addActionListener(e -> {
		    Category selectedCategory = (Category) categoryCombo.getSelectedItem();
		    if (selectedCategory != null) {
		    	tableModel.setRowCount(0); //清空Table的資料
		        int categoryId = selectedCategory.getId();
		        List<Product> products = psi.findByCategoryId(categoryId);
		        for(Product p : products) {
		            Object[] row = {
		                p.getId(),
		                p.getCategoryId(),
		                p.getName(),
		                p.getPrice()
		            };
		            tableModel.addRow(row);
		        }
		    }
		});
		
		/**載入時確保JTabel有項目**/
		if (categoryCombo.getItemCount() > 0) {
		    categoryCombo.setSelectedIndex(0); // 
		}
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBackground(new Color(33, 52, 72));
		panel_2_1_1_1.setBounds(13, 244, 533, 25);
		panel_1.add(panel_2_1_1_1);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("調整商品，請先選擇一筆資料");
		lblNewLabel_1_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_3_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_3_1.setBounds(173, 0, 187, 25);
		panel_2_1_1_1.add(lblNewLabel_1_1_3_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("分類");
		lblNewLabel_1_2.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(13, 318, 35, 25);
		panel_1.add(lblNewLabel_1_2);
		
		/**下方調整用分類JCombobox**/
		List<Category>category2=csi.findAllCategory();
		JComboBox<Category> comboBox_1 = new JComboBox<>();
		for(Category c:category2)
		{
			comboBox_1.addItem(c);
		}
		comboBox_1.setBounds(56, 318, 200, 25);
		panel_1.add(comboBox_1);
		
		
		JLabel lblNewLabel_1 = new JLabel("名稱");
		lblNewLabel_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(303, 279, 35, 25);
		panel_1.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(346, 279, 200, 25);
		panel_1.add(name);
		
		JLabel lblNewLabel_1_1 = new JLabel("價格");
		lblNewLabel_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(303, 318, 35, 25);
		panel_1.add(lblNewLabel_1_1);
		
		price = new JTextField();
		price.setBounds(346, 318, 200, 25);
		panel_1.add(price);
		
		JLabel lblNewLabel_1_3 = new JLabel("編號");
		lblNewLabel_1_3.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(13, 279, 35, 25);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel id = new JLabel("");
		id.setForeground(new Color(255, 245, 228));
		id.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		id.setBounds(56, 279, 151, 25);
		panel_1.add(id);
		
		/**將選取資料塞入下方輸入框中**/
		table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                id.setText(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 2).toString());
                price.setText(table.getValueAt(row, 3).toString());
             // 從 JTable 取出此產品的分類ID
                int categoryId = Integer.parseInt(table.getValueAt(row, 1).toString());
                for (int i = 0; i < comboBox_1.getItemCount(); i++) 
                {
                    Category c = comboBox_1.getItemAt(i);
                    if (c.getId() == categoryId) {
                        comboBox_1.setSelectedIndex(i);
                        break;
                    }
                }
                
            }
        });
		
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
		btnNewButton_3.setBounds(476, 5, 70, 25);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("刪除選中商品");
		btnNewButton_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (id.getText().isEmpty()) {
			            JOptionPane.showMessageDialog(null, "請先選擇一筆資料！", 
			            		"提示", JOptionPane.WARNING_MESSAGE);
			            return;
			        }
				int delete=Integer.parseInt(id.getText());
				Product product=new Product();
				String message = "確認要刪除這個產品嗎？\n\n"
	                       + "ID：" + delete + "\n"
	                       + "產品名稱： " + name.getText() + "\n"
	                       + "價格："  + price.getText();
				product.setId(delete);
				Object[]options= {"刪除","取消"};
				int confirm=JOptionPane.showOptionDialog(null, message, "刪除確認", 
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options,options[1]);
				if(confirm==0) 
				{
					if(psi.deleteProduct(product))
					{
						JOptionPane.showMessageDialog(null, "刪除成功", 
								"提示", JOptionPane.INFORMATION_MESSAGE);
						tableModel.setRowCount(0); // 清空舊資料
						Category selectedCategory = (Category) categoryCombo.getSelectedItem();
						categoryCombo.setSelectedItem(selectedCategory);
						// 根據選中的分類重新撈取產品
					    if (selectedCategory != null) {
					        int categoryId = selectedCategory.getId();
					        List<Product> newList = psi.findByCategoryId(categoryId);
					        for (Product p : newList) {
					            tableModel.addRow(new Object[]{
					                p.getId(),
					                p.getCategoryId(),
					                p.getName(),
					                p.getPrice()
					            });
					        }
					    }
						id.setText("");
						name.setText("");
						price.setText("");
						comboBox_1.setSelectedIndex(-1);
						
						
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
		btnNewButton_3_1.setBounds(431, 203, 115, 25);
		panel_1.add(btnNewButton_3_1);
		
		JButton btnUpdate = new JButton("修改商品");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=name.getText();
				int Price=Integer.parseInt(price.getText());
				Category selectedCategory = (Category) comboBox_1.getSelectedItem();
				int CategoryId=selectedCategory.getId();
				Product product=new Product();
				product.setId(Integer.parseInt(id.getText()));
				product.setName(Name);
				product.setPrice(Price);
				product.setCategoryId(CategoryId);
				if(psi.updateProduct(product))
				{
					JOptionPane.showMessageDialog(null, "修改成功，點擊確認後將更新資料", "提示", JOptionPane.INFORMATION_MESSAGE);
					tableModel.setRowCount(0); // 清空舊資料
					for (int i = 0; i < categoryCombo.getItemCount(); i++) {
					    Category c = categoryCombo.getItemAt(i);
					    if (c.getId() == selectedCategory.getId()) {
					        categoryCombo.setSelectedIndex(i);
					        break;
					    }
					}
					id.setText("");
					name.setText("");
					price.setText("");
					comboBox_1.setSelectedIndex(-1);
				}
			}
		});
		btnUpdate.setForeground(new Color(255, 245, 228));
		btnUpdate.setBackground(new Color(15, 84, 145));
		btnUpdate.setBounds(431, 361, 115, 25);
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
		btnNewButton_1.setBounds(301, 203, 115, 25);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_3_1_1 = new JButton("新增商品");
		btnNewButton_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddProduct ap=new AddProduct();
				ap.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3_1_1.setForeground(new Color(255, 245, 228));
		btnNewButton_3_1_1.setBackground(new Color(15, 84, 145));
		btnNewButton_3_1_1.setBounds(13, 204, 115, 25);
		panel_1.add(btnNewButton_3_1_1);
		

	}
}
