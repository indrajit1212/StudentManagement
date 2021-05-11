package com.scg.main;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.scg.studentService.ConsoleReader;
import com.scg.studentService.UserInputException;

import DAO.StudentDaoImpl;
import service.StudentService;
import service.StudentServiceImpl;
import vo.StudentVO;

public class StudentController{
 static ConsoleReader consoleReader=new ConsoleReader();
 static StudentService studentService=new StudentServiceImpl();

	public static void main(String[] args)throws IOException, SQLException, ClassNotFoundException, UserInputException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("**********************"+"                               "+"**************************");
		System.out.println("                      "+"WELCOME TO STUDENT REGISTRATION");
		StudentDaoImpl s=new StudentDaoImpl();
		while(true)
		{
			System.out.println("enter 1 for insert the value");
			System.out.println("enter 2 for delete");
			System.out.println("enter 3 for display");
			System.out.println("enter 4 for search by name");
			System.out.println("enter 5 to see in pagination");
			System.out.println("enter 6 for updating the column");
			System.out.println("enter 7 to exit");
			int c=Integer.parseInt(br.readLine());
			if(c==1)
			{
				System.out.println("enter the Id:");
			      String usn=consoleReader.readString();
			      System.out.println("entet the firstname");
			      String fname=consoleReader.readString();
			      System.out.println("enter the last name");
			      String lname=consoleReader.readString();
			      System.out.println("enter the age");
			      int age=consoleReader.readInteger();
			      System.out.println("enter the address");
			
			      String address=consoleReader.readString();
			      System.out.println("enter the depart");
			      String department=consoleReader.readString();
		
			      StudentVO st=new StudentVO(usn,fname,lname,age,address,department);
		      boolean answer=studentService.insertStudentToDB(st);
		      if(answer)
		      {
		         System.out.println("student registered successfully");
		      }
			}
			else if(c==2)
			{
				System.out.println("enter the usn ");
				String usn=consoleReader.readString();
				studentService.deleteFromDB(usn);
				
			}
			else if(c==3)
			{
				s.display();
			}
			else if(c==4)
			{
				
				System.out.println("enter the name");
				String fname1=consoleReader.readString();
				studentService.searchByName(fname1);
			}
			else if(c==5)
			{

				System.out.println("enter the number from where u need to see page");
				int off=consoleReader.readInteger();
				System.out.println("enter the number to where u want to see page");
				int lim=consoleReader.readInteger();
				studentService.studentPagination(lim,off);
			}
			else if(c==6)
			{
			 
			 s.updateRecord();
			 
			}
			else if(c==7)
			{
				System.out.println("thank you for using ");
				break;
			}
			else
			{
				System.out.println("oops invalid option! please try again");
			}
				
			}
		
		
	}

}
/* vo 
 * dao
 * service
 */
