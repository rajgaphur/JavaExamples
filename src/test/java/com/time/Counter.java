package com.time;

import java.text.SimpleDateFormat;
import java.util.*;
class Counter
{
 
 public static void main(String...args) throws Exception
 {
  System.out.println("Hello\b");
  int timeInterval = 2;
  int minute = 0;
  //SimpleDateFormat dateFormat = new SimpleDateFormat();
  //dateFormat.format(new Date());
  //int i = (int) new Date().getSeconds();
  Date d = new Date();
  System.out.println(d.getDate());
  //System.out.println("Seconds : "+ i);
  int i = 0;
  for(;;) {
	  i = (int) new Date().getSeconds();
	  if(i == 0) {
		  break;
	  }
  }
  
  for(;;)
  {
   Thread.sleep(500);     
   // hold the next time.  
   i = (int) new Date().getSeconds();
   System.out.print(" "+ i);
   if(i == 59) {
	   Thread.sleep(500);
	   System.out.println();
	   minute++;
   }
   Thread.sleep(500);
   if(timeInterval == minute) {
	   System.out.println("Time is elapsed");
	   break;
   }
  }
 }
}
