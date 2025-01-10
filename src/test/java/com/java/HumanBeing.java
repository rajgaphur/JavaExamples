package com.java;

class HumanBeing {
	
	static final int x = 10;
	final int y = 20;
	HumanBeing(){
		System.out.println("In HumanBeing class constructor");
	}
    public int walk (int distance, int time) {
    	System.out.println("In HumanBeing class Walk method");
    	final int x = 1;
            int speed = distance / time;
            return speed;
    }
    public static void main(String[] args) {
		HumanBeing hb = new HumanBeing();
		int x = hb.walk(10,5);
		System.out.println("x = "+x);
		
		Athlete a = new Athlete();
		int y = a.walk(10,5);
		System.out.println("y = "+y);
		
		final int i=10;
		
		HumanBeing hb1 = new Athlete();
		System.out.println(hb1.walk(15, 3));
		
		//java.lang.ClassCastException: 
		//com.java.HumanBeing cannot be cast to com.java.Athlete
		Athlete a1 = (Athlete) new HumanBeing();
		a1.walk(20, 2);
		
		System.gc();
	}
}
class Athlete extends HumanBeing {
	
	Athlete(){
		System.out.println("In Athlete class constructor");
	}
	
    public int walk(int distance, int time) {
    	System.out.println("In Athlete class Walk method");
            int speed = distance / time;
            speed = speed * 2;
            return speed;
    }
}
