package com.java;

class Parent{
    protected int num = 1;
    private final int x;
    protected final int y = 10;
    
    Parent(){
    	System.out.println("Parent class default constructor.");
    	this.x = 0;
    }
    /*
    Parent(){
        System.out.println("Parent class default constructor.");
    }
    
     */
    Parent(String str){
        
		this.x = 0;
		System.out.println("Parent class parameterised constructor."+str);
        
    }

    Parent(String str, int val){
		this.x = 0;
		System.out.println("Parent class parameterised constructor."+str);
        
    }
    public void foo(){
        System.out.println("Parent class foo!");
    }
    
    public void display(){
    	System.out.println("Parent display");
    }
    public static void main(String[] args) {
		Parent p = new Parent();
		int y = p.x;
		
		System.gc();
	}
}

class Child extends Parent{
    private int num = 2;
    
    Child(){
        //super constructor call should always be in the first line
        //super();              // Either call default super() to call default parent constructor OR
        super("Call Parent");    // call parameterised super to call parameterised parent constructor.
        System.out.println("Child class default Constructor");
    }
    
    void printNum(){
        System.out.println(num);
        System.out.println(super.num); //prints the value of num of parent class
    }
    
    @Override
    public void foo(){
        System.out.println("Child class foo!");
        super.foo();    //Calls foo method of Parent class inside the Overriden foo method of Child class.
    }
    
    public void display() {
    	System.out.println("Child display");
    }
}