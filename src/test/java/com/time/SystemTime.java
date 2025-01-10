package com.time;

import java.text.SimpleDateFormat;
import java.util.*;
class SystemTime
{
 
 public static void main(String...args) throws Exception
 {
	 

 }
 
 public void Timer(String waitInMinutes) throws InterruptedException {
	  
	  int timeInterval = Integer.parseInt(waitInMinutes);
	  int minute = 0;
	  Date d = new Date();
	  int i = 0;
	  for(;;) {
		  i = (int) new Date().getSeconds();
		  if(i == 0) {
			  break;
		  }
	  }
	  System.out.println(timeInterval + " Minutes of Interval...");
	  for(;;)
	  {    
	   // hold the next time.  
	   i = (int) new Date().getSeconds();
	   System.out.print(i+".");
	   if(i == 59) {
		   System.out.println();
		   minute++;
		   System.out.println(minute + " Minutes");
	   }
	   Thread.sleep(1000);
	   if(timeInterval == minute) {
		   System.out.println("Time is elapsed");
		   break;
	   }
	  }
 }
}