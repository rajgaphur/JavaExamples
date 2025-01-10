package com.examples;

public class StaticEx {

	public int i;
	public String str;
	public boolean b;
	public float f;
	public double d;
	public char c;
	String str1 = "hi";
	String str2 = "hi";
	
	public static void main(String[] args) {

		int[] a =  {1,2};
		main(a);
		char[] c =  {'a','b','c'};
		main(c);
		StaticEx ex1 = new StaticEx();
		StaticEx ex2 = new StaticEx();

		System.out.println("Before assgining ex2 to ex1");
		if(ex1.equals(ex2)) {
			System.out.println("equals");
		}else {
			System.out.println("Not equals");
		}
		
		if(ex1==ex2) {
			System.out.println("equality");
		}else {
			System.out.println("Not equality");
		}		
		
		ex1 = ex2;
		System.out.println("After assgining ex2 to ex1");
		if(ex1.equals(ex2)) {
			System.out.println("equals");
		}else {
			System.out.println("Not equals");
		}
		
		if(ex1==ex2) {
			System.out.println("equality");
		}else {
			System.out.println("Not equality");
		}		
		
		System.out.println("|"+ex1.i+"|"+ex1.str+"|"+ex1.b+"|"
		+ex1.f+"|"+ex1.d+"|"+ex1.c+"|");
		int x = 0;
		System.out.println("Value :"+x);

	}

	 	public static void main(int[] args){
	        System.out.println("Overloaded Integer array Main Method");
	    }
	    public static void main(char[] args){
	        System.out.println("Overloaded Character array Main Method");
	    }
	    public static void main(double[] args){
	        System.out.println("Overloaded Double array Main Method");
	    }
	    public static void main(float args){
	        System.out.println("Overloaded float Main Method");
	    }
	    
	    public String area() {
	    	return "";
	    }
	    
	    public String area(String s) {
	    	return s;
	    }
}
