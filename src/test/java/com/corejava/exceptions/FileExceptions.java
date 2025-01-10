package com.corejava.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileExceptions {

	public static void main(String[] args) {
		
		File f = new File("test.txt");
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(f));
			
		} /*catch (IOException e) {   //Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
										//Unreachable catch block for FileNotFoundException. It is already handled by the catch block for IOException
										//at com.corejava.exceptions.FileExceptions.main(FileExceptions.java:26)
			e.printStackTrace();
		}*/
		catch (ClassCastException e) {
			e.printStackTrace();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

}
