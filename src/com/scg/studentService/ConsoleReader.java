package com.scg.studentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
public String readString() throws IOException
{
	String string=br.readLine();
	return string;
}
public int readInteger() throws NumberFormatException,IOException
{
	int integer=Integer.parseInt(br.readLine());
	return integer;
}
}
