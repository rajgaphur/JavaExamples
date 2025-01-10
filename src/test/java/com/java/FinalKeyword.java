package com.java;

//final class FinalKeyword { 
public class FinalKeyword {

	public final static int x = 1;
	final static public int y = 1;
	static public final int z = 1;
	
	//final FinalKeyword(){}  //"Illegal modifier for the constructor in type FinalKeyword; only public, protected & private are permitted
	
	public static void main(String[] args) {

		//public final static int x = 1;  //  "Illegal modifier for parameter x; only final is permitted"
		//static public int y = 1;        //  "Illegal modifier for parameter y; only final is permitted"
		//public final int z = 1;		  // "Illegal modifier for parameter z; only final is permitted"
		
		//public int a = 0;				//	"Illegal modifier for parameter a; only final is permitted"
		//static int b = 0;				//	"Illegal modifier for parameter b; only final is permitted"
		
		final int c = 0;
		
		FinalKeyword fk = new FinalKeyword();
		//fk.x = 10;  //The final field FinalKeyword.x cannot be assigned
		fk.example1();
	}
	
	public void example1() {
		int x = 1;
		final String str = "abl";
		//str = "hi";  // "The final local variable str cannot be assigned. It must be blank and not using a compound assignment"
		System.out.println(x + " "+ str);
	}
	
	public final void example2() {
		int a = 0;
		final String str = "xyz";
		a = 10;
		//str = "hi";  // "The final local variable str cannot be assigned. It must be blank and not using a compound assignment"
		System.out.println(a + " "+ str);
	}

}
