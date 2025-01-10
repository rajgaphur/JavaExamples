package com.time;

import java.io.IOException;

public class ClearScreen {


public static void main(String[] args) throws InterruptedException, IOException  
{  
	System.out.println("Waiting");
	Counter c = new Counter();
	
	c.wait(5000);
}  
}  