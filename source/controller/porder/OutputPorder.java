package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.member.LoginSuccess;
import model.Porder;
import util.CreateExcel;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.util.List;

public class OutputPorder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutputPorder frame = new OutputPorder();
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
	public OutputPorder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 10, 300, 35);
		contentPane.add(panel);
		
		JLabel welcome = new JLabel("匯出明細");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		welcome.setBounds(0, 0, 300, 35);
		panel.add(welcome);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 55, 300, 196);
		contentPane.add(panel_1);
		
		JLabel welcome_1 = new JLabel("請選擇要匯出的格式");
		welcome_1.setHorizontalAlignment(SwingConstants.CENTER);
		welcome_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		welcome_1.setBounds(0, 7, 300, 35);
		panel_1.add(welcome_1);
		
		/**按鈕的家**/
		JButton btnexcel = new JButton("匯出Excel表單");
		btnexcel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateExcel ce=new CreateExcel();
				File file=new File("Porder.xls");
				List<Porder> porder = (List<Porder>) Tool.readFile("porder.txt");
				String[]titleName=new String[]{"訂單編號","會員姓名","會員帳號","產品編號","產品名稱","訂購數量"};
				if(!file.exists())
				{
					ce.createExcel("Porder.xls", "訂單表", titleName);
					
				}
					ce.insertExcel("Porder.xls", "訂單表", porder);
					JOptionPane.showMessageDialog(null, "資料匯出成功");
			}
		});
		btnexcel.setBounds(10, 41, 280, 40);
		panel_1.add(btnexcel);
		
		JButton btnNewButton_2 = new JButton("匯出PDF並列印");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Porder> porderList = (List<Porder>) Tool.readFile("porder.txt");
				if (porderList == null || porderList.isEmpty()) {
				    JOptionPane.showMessageDialog(null, "沒有可列印的訂單資料！");
				    return;
				}
				
				StringBuilder reportText = new StringBuilder();
		        reportText.append("=== 訂單報表 ===\n");
		        reportText.append("訂單編號：").append(porderList.get(0).getId()).append("\n");
		        reportText.append("訂購人：").append(porderList.get(0).getMemberId()).append("\n");
		        reportText.append("------------------------\n");
		        reportText.append("購買項目\n");
		         for (Porder p : porderList) 
		         {
		             reportText.append("總價：").append(p.getTotal()).append("\n");
		             reportText.append("  \n");
		         }
		            JTextArea reportArea = new JTextArea(20, 40);
		            reportArea.setText(reportText.toString());
		            
		            try {
						reportArea.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}
		});
		btnNewButton_2.setBounds(10, 91, 280, 40);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("回到最初的起點");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginSuccess ls=new LoginSuccess();
				ls.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setBounds(10, 141, 280, 40);
		panel_1.add(btnNewButton_2_1);

	}

}
