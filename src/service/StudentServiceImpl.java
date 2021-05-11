package service;
import java.io.IOException;
import java.sql.SQLException;

import com.scg.studentService.ConsoleReader;
import com.scg.studentService.StudentValidator;
import com.scg.studentService.UserInputException;

import DAO.StudentDao;
import DAO.StudentDaoImpl;
import vo.StudentVO;
public class StudentServiceImpl implements StudentService {
	
		StudentValidator validation=new StudentValidator();
		ConsoleReader consoleReader=new ConsoleReader();
		
	private	StudentDao studentDao;
	  public	 StudentServiceImpl()
		{
			studentDao=new StudentDaoImpl();
		}
	  public boolean insertStudentToDB(StudentVO studentVO) throws IOException,UserInputException,SQLException,ClassNotFoundException
	  
	  { boolean flag=false;
		  validation.validateObject(studentVO);
		  validation.validateUsn(studentVO.getUsn());
		  validation.validateString(studentVO.getFname());
		  validation.validateString(studentVO.getLname());
		  validation.validateInteger(studentVO.getAge());
		  validation.validateString(studentVO.getAddress());
		  validation.validateString(studentVO.getDepartment());
		  studentDao.insertStudentToDB(studentVO);
		  
		  flag=true;
		  return flag;
		  
		  
	  }
	  public void deleteFromDB(String usn) throws UserInputException,SQLException
	  {
		  validation.validateUsn(usn);
		  int  numberOfRecordsDeleted=studentDao.deleteFromDB(usn);
		  
		  if(numberOfRecordsDeleted==0)
			  System.out.println("Usn does not exist");
		  else
			  System.out.println(String.format("%d recods deleted", numberOfRecordsDeleted));
	      
	  }
	  public void searchByName(String st) throws UserInputException
	  {
		  validation.validateString(st);
		  studentDao.searchByName(st);
	  }
	  public void studentPagination(int limit,int offset) throws IOException,UserInputException
	  {
		  boolean flag;
		 flag=validation.validateInteger(limit);
		 if(flag)
		  validation.validateInteger(offset);
		 else
			 System.out.println("please enter valid integer");
		  studentDao.studentPagination(limit,offset);
	  }
	  
	  
	
	  

}
