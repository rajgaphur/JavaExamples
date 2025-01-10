package com.examples;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetRowCellNum {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\ilkal\\Desktop\\Test.xlsx";

		final XSSFWorkbook writeWb = new XSSFWorkbook();
		final XSSFSheet writeSht = writeWb.createSheet("2023-04-21");

		Map<Integer, List<String>> studentData = new TreeMap<Integer, List<String>>();

		//studentData.put("1", new Object[] { "Roll No", "NAME", "Year" });

		//studentData.put("2", new Object[] { "128", "Aditya", "2nd year" });
		ResultSet rs = null;
		List<String> list = null;
		
		for(int k =1;k<=2;k++) {
			list = new ArrayList<String>();
		for(int j = 1;j<=3;j++) {
			
			list.add("Raj"+j);
		}
		studentData.put(k, list);
		}
		
		/*for(int i = 0; i<= 10; i++) {
		while (rs.next()) {
			list.add(rs.getString("REQUESTED_ACTION"));
			list.add(rs.getString("REQUESTED_ACTION"));
			list.add(rs.getString("SMALL_CELL_ID"));
			list.add(rs.getString("PROC_DEF_KEY_"));
			list.add(rs.getString("STATUS"));
			list.add(rs.getString("STATE_"));
			list.add(rs.getString("START_TIME_"));
			list.add(rs.getString("END_TIME_"));
			list.add(rs.getString("WORKFLOW_ID"));
			list.add(rs.getString("LAST_MODIFIED_DATE"));
			studentData.put(i++, list);
		    }
		}*/
		XSSFRow row;
		int rowid = 25;
		Set<Integer> keyid = studentData.keySet();
		for (int key : keyid) {

			row = writeSht.createRow(rowid++);
			List<String> objectArr = studentData.get(key);
			int cellid = 0;

			for (Object obj : objectArr) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String) obj);
			}
		}

		// .xlsx is the format for Excel Sheets...
		// writing the workbook into the file...
		FileOutputStream out = new FileOutputStream(new File(path));

		System.out.println("Success");
		writeWb.write(out);
		out.close();
	}

}
