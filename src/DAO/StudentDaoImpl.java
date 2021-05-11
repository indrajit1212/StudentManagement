package DAO;


import java.sql.*;

import com.scg.studentService.ConsoleReader;

import service.StudentService;
import service.StudentServiceImpl;
import vo.StudentVO;
public  class StudentDaoImpl implements StudentDao{
	static StudentService studentService=new StudentServiceImpl();
	static ConsoleReader consoleReader=new ConsoleReader();
	public   boolean insertStudentToDB(StudentVO studentVO) throws SQLException
	{
		Connection con=StudentConnection.createConnection();
		
		boolean f=false;
		try
		{
			
		
		String query="insert into students(usn,fname,lname,age,address,department) values(?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1,studentVO.getUsn());
		pstmt.setString(2, studentVO.getFname());
		pstmt.setString(3,studentVO.getLname());
		pstmt.setInt(4, studentVO.getAge());
		pstmt.setString(5, studentVO.getAddress());
		pstmt.setString(6,studentVO.getDepartment());

		
		pstmt.executeUpdate();
		f=true;
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(f)
			{
				con.commit();
			}
			else
			{
				con.rollback();
			}
			con.close();
		}
		return f;
}
	public  int deleteFromDB(String usn)
	{ 
		int numberOfRecordsDeleted=0;
		try
		{

			
			Connection con=StudentConnection.createConnection();
			String query="delete from students where usn=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, usn);
			numberOfRecordsDeleted=pstmt.executeUpdate();
			
			
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return numberOfRecordsDeleted;
		
	}
	public  void display()
	{
		try
		{
			Connection con=StudentConnection.createConnection();
			String query="select * from students";
			PreparedStatement pstmt=con.prepareStatement(query);
			ResultSet set=pstmt.executeQuery();
			while(set.next())
			{
				String usn=set.getString(1);
				String fname=set.getString(2);
				String lname=set.getString(3);
				int age=set.getInt(4);
				String address=set.getString(5);
				String department=set.getString(6);
				System.out.println("usn: "+usn);
				System.out.println("fname: "+fname);
				System.out.println("lname: "+lname);
				System.out.println("age: "+age);
				System.out.println("address: "+address);
				System.out.println("department: "+department);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
				
				
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	
	}
	public  void searchByName(String st)
	{boolean flag=false;
		try
		{
			
			Connection con=StudentConnection.createConnection();
			String query="select * from students where fname=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, st);
			ResultSet set=pstmt.executeQuery();
			
		
			while(set.next())
			{
				flag=true;
				String usn=set.getString(1);
				String fname=set.getString(2);
				String lname=set.getString(3);
				int age=set.getInt(4);
				String address=set.getString(5);
				String department=set.getString(6);
				System.out.println("usn: "+usn);
				System.out.println("fname: "+fname);
				System.out.println("lname: "+lname);
				System.out.println("age: "+age);
				System.out.println("address: "+address);
				System.out.println("department: "+department);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
				
			
			}
			if(flag==false)
			{
				System.out.println("Student does not exist");
			}
		
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public  void studentPagination(int lim,int off)

	{
		try
		{
			Connection con=StudentConnection.createConnection();
		    String query="select * from students Limit ? offset ?";
		    PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, lim);
			pstmt.setInt(2,off);
			ResultSet set=pstmt.executeQuery();
			while(set.next())
			{
				String usn=set.getString(1);
				String fname=set.getString(2);
				String lname=set.getString(3);
				int age=set.getInt(4);
				String address=set.getString(5);
				String department=set.getString(6);
				System.out.println("usn: "+usn);
				System.out.println("fname: "+fname);
				System.out.println("lname: "+lname);
				System.out.println("age: "+age);
				System.out.println("address: "+address);
				System.out.println("department: "+department);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
				
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}

	public  void updateRecord() throws SQLException
	{ 

		String fname,lname,address,department;
		int age;
		try
		{
			System.out.println("enter the usn");
			 String usn=consoleReader.readString();
		Connection con=StudentConnection.createConnection();
		String sql="select * from students where usn=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,usn);
		ResultSet set=pstmt.executeQuery();
		if(set.next())
		{
			usn=set.getNString("usn");
			fname=set.getString("fname");
		    lname=set.getString("lname");
			age=set.getInt("age");
		    address=set.getString("address");
		    department=set.getString("department");
			
		
	System.out.println("do u want to update first name:[y/n]");
	String inp1=consoleReader.readString();

	if(inp1.equals("y"))
	{
		System.out.println("enter the first name");
		 fname=consoleReader.readString();
	}
	System.out.println("do u want to update last name:[y/n]");
	String inp2=consoleReader.readString();
	if(inp2.equals("y"))
	{
		System.out.println("enter the last name");
		lname=consoleReader.readString();
	}
	System.out.println("do u want to update age:[y/n]");
	String inp3=consoleReader.readString();
	if(inp3.equals("y"))
	{
		age=consoleReader.readInteger();
	}
	System.out.println("do u want to update address:[y/n]");
	String inp4=consoleReader.readString();
	if(inp4.equals("y"))
	{
		System.out.println("enter the address");
		address=consoleReader.readString();
	}
	System.out.println("do u want to update department:[y/n]");
	String inp5=consoleReader.readString();
	if(inp5.equals("y"))
	{
		System.out.println("enter the department");
		department=consoleReader.readString();
	}
	boolean ans=updateStudentInformation(usn, fname, lname, age, address, department);
	if(ans)
	{
		System.out.println("student details updated successfully");
	}
		}
		else
		{
			System.out.println("usn does not exist");
		}
   }
		catch(Exception e)
	 {
			e.printStackTrace();
	 }
		
}
	public  boolean updateStudentInformation(String usn,String fname,String lname,int age,String address,String department)
	{
		boolean flag=false;
		try
		{
			Connection con=StudentConnection.createConnection();
		    String query="update students set fname=?,lname=?,age=?,address=?,department=? where usn=?";
		    PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1,fname);
			pstmt.setString(2,lname);
			pstmt.setInt(3, age);
			pstmt.setString(4,address);
			pstmt.setString(5,department);
			pstmt.setString(6,usn);
			pstmt.executeUpdate();
			flag=true;
		    
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
			
		
	
}
}
