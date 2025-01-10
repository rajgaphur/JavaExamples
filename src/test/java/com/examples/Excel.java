package com.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	// any exceptions need to be caught
	public static void main(String[] args) throws Exception {

		try {
			System.out.println("Writing data to Excel file");
			String fileName = writeDataExcel();

			System.out.println("Reading and Printing data from Excel file :" + fileName);
			readDataExcel(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void readDataExcel(String excelFileName) {

		try {
			FileInputStream fis = new FileInputStream(new File(excelFileName));

			XSSFWorkbook readWb = new XSSFWorkbook(fis);

			XSSFSheet readSheet = readWb.getSheetAt(0);

			Iterator<Row> rowIterator = readSheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = (Row) rowIterator.next();

				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = (Cell) cellIterator.next();
					System.out.print(cell.getStringCellValue() + "\t\t");
				}
				System.out.println();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String writeDataExcel() {

		final Date date = new Date();
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		final String outRespFileName = "C:\\D\\DriveD\\Learning\\ExcelEx\\excelData" + dateFormat.format(date)
		+ ".xlsx";
		
		try {
			
			
			final FileOutputStream out = new FileOutputStream(new File(outRespFileName));
			final XSSFWorkbook writeWb = new XSSFWorkbook();
			final XSSFSheet writeSht = writeWb.createSheet("SheetData1");
			
			// This data needs to be written (String[])
			Map<String, String[]> studentData = new TreeMap<String, String[]>();

			studentData.put("1", new String[] { "Roll No", "NAME", "Year" });

			studentData.put("2", new String[] { "128", "Aditya", "2nd year" });

			studentData.put("3", new String[] { "129", "Narayana", "2nd year" });

			studentData.put("4", new String[] { "130", "Mohan", "2nd year" });

			studentData.put("5", new String[] { "131", "Radha", "2nd year" });

			studentData.put("6", new String[] { "132", "Gopal", "2nd year" });

			Set<String> keyid = studentData.keySet();

			int rowid = 0;
			System.out.println("Writing started....");
			for (String key : keyid) {

				final XSSFRow wrRow = writeSht.createRow(rowid++);
				String[] objectArr = studentData.get(key);
				int cellid = 0;

				for (String str : objectArr) {
					final Cell wrCell = (Cell) wrRow.createCell(cellid++);
					wrCell.setCellValue(str);
				}
				System.out.println(".");
			}
			
			
			writeWb.write((OutputStream) out);
			System.out.println("Writing ended.");
			writeWb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		return outRespFileName;
	}
}