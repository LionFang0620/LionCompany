package util;

import java.io.FileOutputStream;
import java.util.List;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import model.Porder;

public class CreateExcel {
	
	HSSFWorkbook excelbook=new HSSFWorkbook();
	static HSSFSheet sheet=null;
	
	public void createExcel(String excelName,String sheetName,String[]titleName)
	{
		try {
			FileOutputStream out=new FileOutputStream(excelName); //創建檔案
			sheet=excelbook.createSheet(sheetName); //建立分頁
			HSSFRow row=sheet.createRow(0);
			for(int i=0;i<titleName.length;i++)
			{
				row.createCell(i).setCellValue(titleName[i]);
			}
			excelbook.write(out);
			out.flush();
			out.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertExcel(String excelName,String sheetName,List<Porder> porderList)
	{
		try 
		{
			excelbook=new HSSFWorkbook(new FileInputStream(excelName));
			HSSFSheet sheet=excelbook.getSheet(sheetName);//獲得指定的工作表
			int count=sheet.getPhysicalNumberOfRows(); //獲得工作表中總體行數
			for (Porder porder : porderList) {
	            HSSFRow row = sheet.createRow(count++); // 每新增一筆，行數加1
	            row.createCell(0).setCellValue(porder.getId());
	            row.createCell(1).setCellValue(porder.getPorderTime());
	            row.createCell(2).setCellValue(porder.getMemberId());
	            row.createCell(2).setCellValue(porder.getTotal());
	            
	        }
			
			FileOutputStream out;// 新增輸出檔案流        
	        out = new FileOutputStream(excelName);
	        excelbook.write(out);// 把對應的Excel工作簿存碟
	        out.flush();
	        System.out.println("資料新增成功！！！");
		} 
		
		 catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
