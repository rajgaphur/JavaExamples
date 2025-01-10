package com.examples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestDate {

	public static void main(String[] args) {


		TimeZone.setDefault(TimeZone.getTimeZone("GMT-8"));
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		Date dateGMT = cal.getTime();

		System.out.println("dateGMT "+dateGMT);
		String fileDateTime = new SimpleDateFormat("yyyyMMdd-HH:mm:ss").format(dateGMT);
		//String filetime = Utils.formatFileTime(fileDateTime);
		System.out.println("fileDateTime "+ fileDateTime);
		try {
			Date currentdate = new SimpleDateFormat("yyyyMMdd").parse(fileDateTime);
			System.out.println("currentdate "+currentdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String locationProfilePrefix = "parser.properties_" + fileDateTime;
		System.out.println("actual: parser.properties_20230111-23:20:27");
		
		System.out.println("expual: "+locationProfilePrefix);
		
		
		

	}

}
