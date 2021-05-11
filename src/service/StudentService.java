package service;

import java.io.IOException;
import java.sql.SQLException;

import com.scg.studentService.UserInputException;

import vo.StudentVO;

public interface StudentService {
	
	public boolean insertStudentToDB(StudentVO studentVO) throws IOException,UserInputException,ClassNotFoundException,SQLException;
	
    public void deleteFromDB(String usn) throws IOException,UserInputException,ClassNotFoundException,SQLException;
    
  
    public void searchByName(String st) throws IOException,UserInputException,ClassNotFoundException,SQLException;
    
    public void studentPagination(int limit,int offset) throws IOException,UserInputException,ClassNotFoundException,SQLException;
    
   
    
}
