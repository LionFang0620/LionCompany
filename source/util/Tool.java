package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Member;

public class Tool {

	public static void main(String[] args) {
		//Tool.saveFile(new Member("aaa","bbb","ccc","1235","4568"),"c:/HW04/member.txt");
		Member m=(Member)Tool.readFile("c:/ABC/member.txt");
		System.out.println(m.getName()+"\t"+m.getUsername()+"\t"+m.getPassword());
	}
	public static void saveFile(Object object,String fileName)
	{
		try 
		{
			FileOutputStream fos =new FileOutputStream(fileName);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(object);
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	
	public static Object readFile(String fileName)
	{
		Object object=null;
		try 
		{
			FileInputStream fis=new FileInputStream(fileName);
			ObjectInputStream ois=new ObjectInputStream(fis);
			object=ois.readObject();
		}
		catch (ClassNotFoundException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

}
