package controller.porder;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.member.Login;
import controller.member.LoginSuccess;
import model.Porder;
import model.Product;
import model.Category;
import model.Member;
import service.impl.CategoryServiceImpl;
import service.impl.PorderDetailServiceImpl;
import service.impl.PorderServiceImpl;
import service.impl.ProductServiceImpl;

import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import java.util.List;
import javax.swing.Timer;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JComboBox;


public class AddPorder extends JFrame {
	private DefaultTableModel tableModel;
	private JTable orderTable;
	private JTable table;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField quantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorder frame = new AddPorder();
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
	public AddPorder() {
		
		ProductServiceImpl psi=new ProductServiceImpl();
		PorderServiceImpl pordersi=new  PorderServiceImpl();
		PorderDetailServiceImpl pdsi=new PorderDetailServiceImpl();
		CategoryServiceImpl csi=new CategoryServiceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(33, 52, 72));
		panel.setBounds(10, 10, 556, 35);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("購物系統");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 245, 228));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel.setBounds(239, 0, 78, 35);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(84, 119, 146));
		panel_1.setBounds(10, 53, 556, 500);
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
		
		String[] columnNames = {"編號", "分類ID", "名稱", "價格"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table=new JTable(tableModel);
        JScrollPane scrollPane_products = new JScrollPane(table);
		scrollPane_products.setBounds(13, 70, 534, 120);
		panel_1.add(scrollPane_products);
		
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
		
		table.getSelectionModel().addListSelectionListener(e -> {
			int selectedRow = table.getSelectedRow();
			
		});
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBackground(new Color(33, 52, 72));
		panel_2_1_1_1.setBounds(13, 239, 533, 25);
		panel_1.add(panel_2_1_1_1);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("訂單細項");
		lblNewLabel_1_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1_3_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1_3_1.setBounds(224, 0, 85, 25);
		panel_2_1_1_1.add(lblNewLabel_1_1_3_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("數量");
		lblNewLabel_1_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(13, 198, 35, 25);
		panel_1.add(lblNewLabel_1_1);
		
		quantity = new JTextField();
		quantity.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		quantity.setHorizontalAlignment(SwingConstants.CENTER);
		quantity.setText("輸入數字");
		quantity.setBounds(59, 198, 70, 25);
		panel_1.add(quantity);
		Member member=(Member)Tool.readFile("member.txt");
		String welcome=member.getName()+"登入中";
		
		
		LocalDateTime now=LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatted = now.format(formatter);
		JLabel timeSet = new JLabel();		//時間
		timeSet.setHorizontalAlignment(SwingConstants.CENTER);
		timeSet.setBounds(4, 0, 157, 34);
		panel.add(timeSet);
		timeSet.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		timeSet.setForeground(new Color(255, 245, 228));
		timeSet.setText(""+formatted);
		Timer timer = new Timer(1000, new ActionListener() {
	           public void actionPerformed(ActionEvent e) {
	               LocalDateTime now = LocalDateTime.now();
	               String formatted = now.format(formatter);
	               timeSet.setText(formatted);
	           }
	       });
	       timer.start();
		
	    JLabel name = new JLabel("");
	    name.setBounds(319, 0, 157, 35);
	    panel.add(name);
	    name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(new Color(255, 245, 228));
		name.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		name.setText(welcome);
		
		String[] columns = {"商品ID", "商品名稱", "單價", "數量", "小計"};
		DefaultTableModel orderModel = new DefaultTableModel(columns, 0);
		orderTable=new JTable(orderModel);
		JScrollPane porder = new JScrollPane(orderTable);
		porder.setBounds(13, 270, 534, 183);
		panel_1.add(porder);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(33, 52, 72));
		panel_2.setBounds(16, 461, 180, 26);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("總價");
		lblNewLabel_1.setBounds(5, 0, 35, 25);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 245, 228));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		
		JLabel total = new JLabel("");
		total.setBounds(45, 0, 98, 25);
		panel_2.add(total);
		total.setBackground(new Color(255, 255, 255));
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setForeground(new Color(158, 248, 219));
		total.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_2 = new JLabel("元");
		lblNewLabel_1_2.setBounds(148, 0, 25, 25);
		panel_2.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(new Color(255, 245, 228));
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		
		
		/**按鈕的家**/
		JButton btnConfirm = new JButton("加入訂單");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  int selectedRow = table.getSelectedRow();
			        if (selectedRow == -1) {
			            JOptionPane.showMessageDialog(null, "請先選擇商品！");
			            return;
			        }

			        String qtyText = quantity.getText().trim();
			        if (qtyText.isEmpty() || !qtyText.matches("\\d+")) {
			            JOptionPane.showMessageDialog(null, "請輸入正確的數量！");
			            return;
			        }

			        int qty = Integer.parseInt(qtyText);
			        int productId = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
			        String productName = table.getValueAt(selectedRow, 2).toString();
			        int price = Integer.parseInt(table.getValueAt(selectedRow, 3).toString());
			        int subtotal = price * qty;
			        // 取得訂單 TableModel
			        DefaultTableModel orderModel = (DefaultTableModel) orderTable.getModel();

			        // 1. 檢查訂單中是否已有該商品
			        boolean found = false;
			        for (int i = 0; i < orderModel.getRowCount(); i++) 
			        {
			            int existingId = Integer.parseInt(orderModel.getValueAt(i, 0).toString());
			            if (existingId == productId) 
			            {
			                // 更新數量與總額
			                int oldQty = Integer.parseInt(orderModel.getValueAt(i, 3).toString());
			                int newQty = oldQty + qty;
			                orderModel.setValueAt(newQty, i, 3);             
			                orderModel.setValueAt(price * newQty, i, 4);
			                found = true;
			                break;
			            }
			        }
			        if (!found) 
			        {
			            orderModel.addRow(new Object[]{productId, productName, price, qty, subtotal});
			            
			        }
			        int sum = 0;
			        for (int i = 0; i < orderModel.getRowCount(); i++) {
			            sum += Integer.parseInt(orderModel.getValueAt(i, 4).toString());
			        }
			        total.setText(String.valueOf(sum));
			}
		});
		btnConfirm.setForeground(new Color(255, 245, 228));
		btnConfirm.setBackground(new Color(15, 84, 145));
		btnConfirm.setBounds(143, 198, 115, 25);
		panel_1.add(btnConfirm);
		
		
		JButton btnNewButton_1 = new JButton("回上一頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginSuccess ls=new LoginSuccess();
				ls.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(431, 198, 115, 25);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setForeground(new Color(255, 245, 228));
		btnNewButton_1.setBackground(new Color(15, 84, 145));
		
		JButton btnDelete = new JButton("刪除選中項目");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = orderTable.getSelectedRow(); 
		        if (selectedRow != -1) 
		        { 
		            DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
		            model.removeRow(selectedRow); 

		            // 刪除後重新計算總價
		            int sum = 0;
		            for (int i = 0; i < model.getRowCount(); i++) 
		            {
		                sum += Integer.parseInt(model.getValueAt(i, 4).toString());
		            }
		            total.setText(String.valueOf(sum));
		        } 
		        else 
		        {
		            JOptionPane.showMessageDialog(null, "請選擇要刪除的項目！");
		        }
			}
		});
		btnDelete.setForeground(new Color(255, 245, 228));
		btnDelete.setBackground(new Color(15, 84, 145));
		btnDelete.setBounds(429, 462, 115, 25);
		panel_1.add(btnDelete);
		
		JButton btnPorder = new JButton("確認下單");
		btnPorder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String porderId = pordersi.generatePorderId();
				int memberId=member.getId();
				String time=timeSet.getText();
				int totalAmount=Integer.parseInt(total.getText());
				Porder porder = new Porder();
				porder.setPorderId(porderId);
			    porder.setMemberId(memberId);
			    porder.setPorderTime(time);
			    porder.setTotal(totalAmount);
			    if(pordersi.addPorder(porder))
			    {
			    	JOptionPane.showMessageDialog(null, "下單成功", "提示", JOptionPane.INFORMATION_MESSAGE);
			    	orderModel.setRowCount(0);
			    	total.setText("");
			    }
			    
			}
		});
		btnPorder.setForeground(new Color(255, 245, 228));
		btnPorder.setBackground(new Color(15, 84, 145));
		btnPorder.setBounds(211, 462, 115, 25);
		panel_1.add(btnPorder);
		
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
		btnNewButton_3.setBounds(476, 5, 70, 25);
		panel.add(btnNewButton_3);
	}
}
