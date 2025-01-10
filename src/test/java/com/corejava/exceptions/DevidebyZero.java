package com.corejava.exceptions;

import java.io.Serializable;

public class DevidebyZero {

	public static void main(String[] args) {

		DevidebyZero db = new DevidebyZero();
		int a = 10;
		int b =0;
	//public class Throwable implements Serializable {
		//public class Exception extends Throwable {
			//Run Time Exceptions
				//Arithmatic, ClassCast, NPE, ArrayIndexOB,ArrayStore, IlleagalThreadState
			//Compile Time Exceptions
				//ClassNotFound, Interrupted, IO, SQL, FileNotFound, Installation
		
		//int y = db.DevideBy0(a,b);
		//Exception Details
		//Exception in thread "main" java.lang.ArithmeticException: / by zero
		//			at com.corejava.exceptions.DevidebyZero.DevideBy0(DevidebyZero.java:44)
		//			at com.corejava.exceptions.DevidebyZero.main(DevidebyZero.java:19)
					
		
		try {
			int x = db.DevideBy0(a,b);
		} catch (ArrayIndexOutOfBoundsException e) {
			//e.printStackTrace();
			System.out.println();
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			b=1;
			System.out.println("In ArrayIndexOutOfBoundsException block");
			System.out.println("b value changed to "+b+" and ans "+db.DevideBy0(a,b));
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println();
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			b=2;
			System.out.println("In ArithmeticException block");
			System.out.println("b value changed to "+b+" and ans "+db.DevideBy0(a,b));
		}finally {
			System.out.println("Exception handled");
		}

		
	}
	public int DevideBy0(int a, int b) {

		return a/b;
	}

}
