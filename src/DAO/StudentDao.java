package DAO;
//import java.io.IOException;
import java.sql.SQLException;

import com.scg.studentService.UserInputException;

import vo.StudentVO;
public interface StudentDao {
	public boolean insertStudentToDB(StudentVO studentVO) throws ClassNotFoundException,SQLException,UserInputException;
	public int deleteFromDB(String usn);
	public void display();
	public void searchByName(String st);
	public void studentPagination(int lim,int off);
	public void updateRecord() throws SQLException;
	public boolean updateStudentInformation(String usn,String fname,String lname,int age,String address,String department);
	
	

}
