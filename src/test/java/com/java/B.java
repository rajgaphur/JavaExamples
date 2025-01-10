package com.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class B extends A{
	
	B(){
		System.out.println("Constructor B called");
	}

	public static void main(String[] args) {
		
		B b = new B();
		
		b.display();
		B.display(10);
	
		A a = new A();
		a.display();
		A.display(20);

		A a1 = new B();
		a1.display();
		
		B b1 = (B) new A(); //Gives ClassCastException
		b1.display();

	}
	
	/* Cannot override the final method from A
	public void display() {
		System.out.println("B's display normal method");
	}
	*/

	 public static void display(int x) {
		System.out.println("B's display param x from static method");
	}
	 
	 public void exceptionChk() {
		
		 try {
			File f = new File("/inputXml.csv");
			FileInputStream fis = new FileInputStream(f);
			while(fis.read() != 0 ) {
				System.out.println(fis.toString());
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}
		 catch(RuntimeException e) {
			 
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
