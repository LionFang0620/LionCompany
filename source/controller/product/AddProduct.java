package controller.product;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import model.Category;
import model.Product;
import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddProduct extends JFrame {

	private static final long serialVersionUID = 1L;
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
					AddProduct frame = new AddProduct();
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
	public AddProduct() {
		CategoryServiceImpl csi=new CategoryServiceImpl();
		ProductServiceImpl psi=new ProductServiceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 335,310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(33, 52, 72));
		panel.setBounds(10, 10, 301, 35);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("新增商品");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 245, 228));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 0, 300, 35);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(84, 119, 146));
		panel_1.setBounds(12, 55, 301, 215);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("名稱");
		lblNewLabel_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(24, 84, 35, 25);
		panel_1.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(70, 84, 205, 25);
		panel_1.add(name);
		
		JLabel lblNewLabel_1_1 = new JLabel("價格");
		lblNewLabel_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(24, 126, 35, 25);
		panel_1.add(lblNewLabel_1_1);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(70, 126, 205, 25);
		panel_1.add(price);
		
		JLabel lblNewLabel_2 = new JLabel("請填寫以下資料");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 245, 228));
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_2.setBounds(0, 6, 301, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("分類");
		lblNewLabel_1_2.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(24, 40, 35, 25);
		panel_1.add(lblNewLabel_1_2);
		
		List<Category>category=csi.findAllCategory();
		JComboBox<Category> categoryCombo = new JComboBox<>();
		for(Category c:category)
		{
			categoryCombo.addItem(c);
		}
		categoryCombo.setBounds(70, 40, 205, 25);
		panel_1.add(categoryCombo);
		
		/**按鈕的家**/
		JButton btnNewButton_1 = new JButton("回上一頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateProduct up = new UpdateProduct();
				up.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setForeground(new Color(255, 245, 228));
		btnNewButton_1.setBackground(new Color(15, 84, 145));
		btnNewButton_1.setBounds(24, 172, 85, 25);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("確認新增");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name = name.getText().trim();
			    String priceText = price.getText().trim();

			    if (Name.isEmpty() || priceText.isEmpty()) 
			    {
			        JOptionPane.showMessageDialog(null, "名稱或價格未填寫", "錯誤", JOptionPane.ERROR_MESSAGE);
			        return;
			    }

			    int Price = 0;
			    try 
			    {
			        Price = Integer.parseInt(priceText);
			    } 
			    catch (NumberFormatException ex) 
			    {
			        JOptionPane.showMessageDialog(null, "價格必須為數字", "錯誤", JOptionPane.ERROR_MESSAGE);
			        return;
			    }

			    if (Price <= 0) 
			    {
			        JOptionPane.showMessageDialog(null, "價格必須大於 0", "錯誤", JOptionPane.ERROR_MESSAGE);
			        return;
			    }

			    Category selectedCategory = (Category) categoryCombo.getSelectedItem();
			    int CategoryId = selectedCategory.getId();
			    Product product = new Product(CategoryId, Name, Price);

			    if (psi.addProduct(product)) 
			    {
			        JOptionPane.showMessageDialog(null, "新增成功", "提示", JOptionPane.INFORMATION_MESSAGE);
			        UpdateProduct up = new UpdateProduct();
			        up.setVisible(true);
			        dispose();
			    } 
			    else 
			    {
			        JOptionPane.showMessageDialog(null, "新增失敗", "錯誤", JOptionPane.ERROR_MESSAGE);
			        name.setText("");
			    }
				
					
				}
			
		});
		btnNewButton.setForeground(new Color(255, 245, 228));
		btnNewButton.setBackground(new Color(15, 84, 145));
		btnNewButton.setBounds(193, 172, 85, 25);
		panel_1.add(btnNewButton);

	}
}
