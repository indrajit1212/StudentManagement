package com.scg.studentService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAO.StudentDaoImpl;
import vo.StudentVO;

public class StudentValidator {
	StudentDaoImpl studentDao=new StudentDaoImpl();
	public void validateUsn(String usn) throws UserInputException
	{
		String format="1[a-zA-Z]{2}1[7-9]{1}[a-z]{2}[0-9]{3}";
		Pattern pattern=Pattern.compile(new String (format));
		Matcher matcher=pattern.matcher(usn);
		if(!matcher.matches())
	    throw new UserInputException("invalid usn");
	}
	public boolean validateInteger(int number) throws UserInputException
	{
		boolean flag=false;
		if(number<0)
			throw new UserInputException("invalid number");
		else
			flag=true;
		return flag;
	}
	public void validateString(String string) throws UserInputException
	{
		String format="^[a-zA-Z\\s]*$";
		Pattern pattern=Pattern.compile(new String (format));
		Matcher matcher=pattern.matcher(string);
		if(!matcher.matches())
	    throw new UserInputException("invalid string");
	}
	public void validateObject(StudentVO studentVO) throws UserInputException
	{
		if(studentVO.getAge()<5||studentVO.getAge()>40)
		{
			throw new UserInputException("invalid age");
			
		}
		String format="1[a-zA-Z]{2}1[7-9]{1}[a-z]{2}[0-9]{3}";
		Pattern pattern=Pattern.compile(new String (format));
		Matcher matcher=pattern.matcher(studentVO.getUsn());
		if(!matcher.matches())
	    throw new UserInputException("invalid usn");
		
		String format1="^[a-zA-Z\\s]*$";
		Pattern pattern1=Pattern.compile(new String (format1));
		Matcher matcher1=pattern1.matcher(studentVO.getFname());
		if(!matcher1.matches())
	    throw new UserInputException("invalid firstname");
		
		String format2="^[a-zA-Z\\s]*$";
		Pattern pattern2=Pattern.compile(new String (format2));
		Matcher matcher2=pattern2.matcher(studentVO.getLname());
		if(!matcher2.matches())
	    throw new UserInputException("invalid last name");
		
		String format3="^[a-zA-Z\\s]*$";
		Pattern pattern3=Pattern.compile(new String (format3));
		Matcher matcher3=pattern3.matcher(studentVO.getAddress());
		if(!matcher3.matches())
	    throw new UserInputException("invalid last name");
		
		String format4="^[a-zA-Z\\s]*$";
		Pattern pattern4=Pattern.compile(new String (format4));
		Matcher matcher4=pattern4.matcher(studentVO.getDepartment());
		if(!matcher4.matches())
	    throw new UserInputException("invalid last name");
		
		
		
	}

	

}
