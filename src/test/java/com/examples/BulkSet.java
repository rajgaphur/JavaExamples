package com.examples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BulkSet {

	public static void main(String[] args) {

		BulkSet DbData = new BulkSet();
		DbData.readXMLEntriesFromCSV();

	}

	public void getDbData(String SerialNumber, String CSVPath, String Env , String ID) {

		Connection conn = null;
		try {
			conn = getConnection();

			if (conn != null) {
				System.out.println("Connected to DB");
			}

			if (Env.equals("QA")) {

				String sql = "select st.REQUESTED_ACTION, act.PROC_DEF_KEY_, act.BUSINESS_KEY_, st.STATUS, act.STATE_, act.START_TIME_, act.END_TIME_, sa.workflow_id, st.LAST_MODIFIED_DATE from scope_transaction st, scope_activity sa, ACT_HI_PROCINST act where st.SCOPE_TRANSACTION_ID = sa.SCOPE_TRANSACTION_ID and st.SMALL_CELL_ID in ("
						+ SerialNumber
						+ ") and sa.workflow_id = act.PROC_INST_ID_ and ACTIVITY_TYPE = 'Workflow' and st.LAST_MODIFIED_DATE > SYSDATE - 3 order by st.LAST_MODIFIED_DATE desc";
				System.out.println(sql);
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				String outputFile = CSVPath;
				System.out.println(outputFile);
				saveToTemplate(rs, outputFile,Env,ID);
			}
			else if (Env.equals("TMO"))  {
				
				
				System.out.println("Connect to TMO to run Set 4 and Set 5");

				String sql = "select st.REQUESTED_ACTION, act.PROC_DEF_KEY_, act.BUSINESS_KEY_, st.STATUS, act.STATE_, act.START_TIME_, act.END_TIME_, sa.workflow_id, st.LAST_MODIFIED_DATE from scope_transaction st, scope_activity sa, ACT_HI_PROCINST act where st.SCOPE_TRANSACTION_ID = sa.SCOPE_TRANSACTION_ID and st.SMALL_CELL_ID in ("
						+ SerialNumber
						+ ") and sa.workflow_id = act.PROC_INST_ID_ and ACTIVITY_TYPE = 'Workflow' and st.LAST_MODIFIED_DATE > SYSDATE - 23/24 order by st.LAST_MODIFIED_DATE desc";
				System.out.println(sql);
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				System.out.println(rs);
				String outputFile = CSVPath;
				System.out.println(outputFile);
				saveToTemplate(rs, outputFile,Env,ID);	
			}

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void readXMLEntriesFromCSV() {
		BufferedReader Reader = null;
		String line = "";

		try {

			String filePath = "InputXml.csv";
			System.out.println("getAbsolutePath :" + filePath);
			Reader = new BufferedReader(new FileReader(filePath));
			
			ArrayList<String> SerialNumbers = new ArrayList<String>();
			SerialNumbers.add("'AUTOBULK1110','AUTOBULK1111','AUTOBULK1112','AUTOBULK1113','AUTOBULK1114','AUTOBULK1115','AUTOBULK1116','AUTOBULK1117','AUTOBULK1118','AUTOBULK1119'");
			SerialNumbers.add("'AUTOBULK2220','AUTOBULK2221','AUTOBULK2222'");
			SerialNumbers.add("'AUTOBULK3330'");
			SerialNumbers.add("'AUTOBULK4442'");
			SerialNumbers.add("'AUTOBULK5550'");

			ArrayList<String> Path = new ArrayList<String>();
			String TemplatePath = "C:\\Users\\ilkal\\Desktop\\BulkMail\\Template1.xlsx";
			
			int i = 0;
			while ((line = Reader.readLine()) != null) {
				String[] entry = null;
				System.out.println(line);
				entry = line.split(",");
				getDbData(SerialNumbers.get(i++), TemplatePath, entry[1], entry[2]); 
			
			}
			
			/*
			 * Path.add("C:\\Automation Work\\BulkSetAutomation\\OracleOutput\\Set1.csv");
			 * Path.add("C:\\Automation Work\\BulkSetAutomation\\OracleOutput\\Set2.csv");
			 * Path.add("C:\\Automation Work\\BulkSetAutomation\\OracleOutput\\Set3.csv");
			 * int i = 0; for (String SerialNumber : SerialNumbers) {
			 * 
			 * getDbData(SerialNumber, Path.get(i)); i = i + 1; }
			 */
			
			/*
			 * for (String SerialNumber : SerialNumbers) {
			 * 
			 * getDbData(SerialNumber, TemplatePath);
			 * 
			 * }
			 */
			
				 
			
			//getDbData(SerialNumbers.get(0), TemplatePath);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (Reader != null) {
				try {
					Reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/*
	 * public static void resultToCsv(ResultSet rs, String outputFile) throws
	 * SQLException, FileNotFoundException {
	 * 
	 * PrintWriter csvWriter = new PrintWriter(new File(outputFile));
	 * ResultSetMetaData meta = rs.getMetaData(); int numberOfColumns =
	 * meta.getColumnCount(); String dataHeaders = "\"" + meta.getColumnName(1) +
	 * "\""; for (int i = 2; i < numberOfColumns + 1; i++) { dataHeaders += ",\"" +
	 * meta.getColumnName(i).replaceAll("\"", "\\\"") + "\""; }
	 * csvWriter.println(dataHeaders); while (rs.next()) { String row = "\"" +
	 * rs.getString(1).trim().replaceAll("\"", "\\\"") + "\""; for (int i = 2; i <
	 * numberOfColumns + 1; i++) { row += ",\"" +
	 * rs.getString(i).trim().replaceAll("\"", "\\\"") + "\""; }
	 * csvWriter.println(row); } csvWriter.close(); csvWriter.flush(); }
	 */

	public static void saveToTemplate(ResultSet rs, String path, String Env, String ID) throws SQLException, IOException{
        
        FileInputStream file = new FileInputStream(path);
        final XSSFWorkbook writeWb = new XSSFWorkbook(file);
        //XSSFWorkbook templateBook = fileInputStream.get
        //Load the sample Excel file
        // Date date = new Date();
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		//File fileObj = new File(dir + Path + LOOKUP_ID + "_" + dateFormat.format(date) + ".txt");
        XSSFSheet writeSht = writeWb.getSheetAt(0);
 
        
        //final XSSFSheet writeSht = writeWb.createSheet("2023-04-21");
        //final XSSFSheet writeSht = writeWb.getSheet("2023-04-21");

        Map<Integer, List<String>> studentData = new TreeMap<Integer, List<String>>();
        
        List<String> list = null;
        
		/*
		 * for(int k =1;k<=2;k++) { for(int j = 1;j<=3;j++) { list.add("Raj"+j); }
		 * studentData.put(k, list); }
		 */
        int i = 0;
        //for(int i = 0; i<= 10; i++) {
        while (rs.next()) {
        	   list = new ArrayList<String>();
               list.add(rs.getString("REQUESTED_ACTION"));
               list.add(rs.getString("PROC_DEF_KEY_"));
               list.add(rs.getString("BUSINESS_KEY_"));
               list.add(rs.getString("STATUS"));
               list.add(rs.getString("STATE_"));
               list.add(rs.getString("START_TIME_"));
               list.add(rs.getString("END_TIME_"));
               list.add(rs.getString("WORKFLOW_ID"));
               list.add(rs.getString("LAST_MODIFIED_DATE"));
               studentData.put(i++, list);
               
            }
        System.out.println(studentData);
       // }
        XSSFRow row;
        int rowid = Integer.parseInt(ID) ;//set1-78,set2-118,set3-137,set4-152,set5-172
        System.out.println(rowid);
        Set<Integer> keyid = studentData.keySet();
        for (int key : keyid) {

               row = writeSht.createRow(rowid++);
        		//row = writeSht.getRow(rowid++);
               List<String> objectArr = studentData.get(key);
               int cellid = 0;

               for (Object obj : objectArr) {
                     Cell cell = row.createCell(cellid++);
                     //Cell cell = row.getCell(cellid++);
                     cell.setCellValue((String) obj);
               }
        }

        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        String Report = "C:\\Users\\ilkal\\Desktop\\BulkMail\\Report.xlsx";
        //FileOutputStream out = new FileOutputStream(new File(Report));
        BufferedWriter output = null;
        try {
        	File file1 = new File(Report);
        	output = new BufferedWriter(new FileWriter(file1));
     //   	output.write();
        	} catch ( IOException e ) {
        	e.printStackTrace();
        	} finally {
        	if ( output != null ) {
        	output.close();
        	}
        	}

        System.out.println("Success");
   //writeWb.write(output);
  output.close();
  }


	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

		FileReader reader = new FileReader("connection.properties");
		Properties p = new Properties();
		p.load(reader);

		Class.forName(p.getProperty("driver"));
		String dbURL1 = p.getProperty("url");
		return DriverManager.getConnection(dbURL1);

	}
}
