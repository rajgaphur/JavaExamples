package com.examples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDiff {

	public static void main(String[] args) {
	
		//System.out.println(" "+ timeDifference("23:35:21","23:36:32","5"));
		System.out.println(" "+ timeDifference("20230112-01:35:25","20230112-01:30:39","5"));
	
	}

	public static Boolean timeDifference(String actualTime, String expectedTime, String timeDifference) {
		//23:20:27, 23:33:38, 5
		//String actualTime = "23:35:21";
		//String expectedTime = "23:36:32";	

		//20230112-01:35:25
		//20230112-01:30:39
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HH:mm:ss");
		long differenceInTime = 0, difference = 0;
		try {
			Date actualDate = format.parse(actualTime);
			Date expectedDate = format.parse(expectedTime);
			differenceInTime = Math.abs(actualDate.getTime() - expectedDate.getTime());
			difference = (differenceInTime / (60 * 1000)) % 60;
			System.out.println("Total Time Difference :"+difference);
			
			if(difference <= Long.parseLong(timeDifference)) {
				return true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
