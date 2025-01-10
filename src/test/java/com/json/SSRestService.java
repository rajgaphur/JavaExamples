package com.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.restassured.path.xml.XmlPath;

public class SSRestService {
	public String id;
	public String operation_id;
	public String lookup_id;
	public String test_type;
	public String test_name;
	public String response_wait_ms;
	public String description;
	public String soap_response;
	public String is_delete;
	public String response_added;
	public String response_modified;
	public String is_edit;

	public static void main(String[] args) {
		final String inRespFileName = "C:\\D\\DriveD\\Learning\\ExcelEx\\exportedSmok.xlsx";
		try {
			getSSDataFromResp(inRespFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getAbsolutePath() {
		final File f = new File("templates");
		final String absolutepath = f.getAbsolutePath();
		return absolutepath;
	}

	public static SSRest getSSDataFromResp(String respFileName) {
		XmlPath xmlSS = null;
		SSRest data = null;
		final Date date = new Date();
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		final String outRespFileName = "C:\\D\\DriveD\\Learning\\ExcelEx\\import"
				+ dateFormat.format(date) + ".xlsx";
		final XSSFWorkbook writeWb = new XSSFWorkbook();
		final XSSFSheet writeSht = writeWb.createSheet("SS Rest Response");
		try {
			final FileInputStream fis = new FileInputStream(new File(respFileName));
			final XSSFWorkbook wb = new XSSFWorkbook((InputStream) fis);
			final XSSFSheet sheet = wb.getSheetAt(0);
			final Iterator<Row> rowIterator = (Iterator<Row>) sheet.iterator();
			int rowid = 0;
			while (rowIterator.hasNext()) {
				final Row row = rowIterator.next();
				final Iterator<Cell> cellIterator = (Iterator<Cell>) row.cellIterator();
				final XSSFRow wrRow = writeSht.createRow(rowid++);
				int cellid = 0;
				while (cellIterator.hasNext()) {
					final Cell cell = cellIterator.next();
					final FormulaEvaluator formulaEvaluator = (FormulaEvaluator) wb.getCreationHelper()
							.createFormulaEvaluator();
					final Cell wrCell = (Cell) wrRow.createCell(cellid++);
					switch (formulaEvaluator.evaluate(cell).getCellType()) {
					case NUMERIC: {
						if (cell.getNumericCellValue() == 288.0) {// 309 or 288
							wrCell.setCellValue(369.0);
							System.out.print("369\t\t\t");
							continue;
						}
						if (cell.getNumericCellValue() == 286.0) {// 329 or 286
							wrCell.setCellValue(389.0);
							System.out.print("389\t\t\t");
							continue;
						}
						wrCell.setCellValue(cell.getNumericCellValue());
						System.out.print(String.valueOf(cell.getNumericCellValue()) + "\t\t\t");
						continue;
					}
					case STRING: {
						final String strInput = cell.getStringCellValue();
						String path = "";
						if (strInput.contains("<soap:Envelope")) {
							xmlSS = new XmlPath(strInput);
							if (strInput.contains("ReverseGeocodeResponse")) {
								path = String.valueOf(getAbsolutePath()) + "\\ss_rest_rgc.txt";
								System.out.println(path);
								data = new SSRest(path);
								getRGCData(data, xmlSS);
								System.out.print(String.valueOf(data.getContents()) + "\t\t\t");
							} else if (strInput.contains("CovCheck")) {
								path = String.valueOf(getAbsolutePath()) + "\\ss_rest_covcheck.txt";
								// C:\Users\ilkal\eclipse-workspace-HandsOn\Examples\templates\ss_rest_covcheck
								System.out.println(path);
								data = new SSRest(path);
								getCovCheckData(data, xmlSS);
								System.out.print(String.valueOf(data.getContents()) + "\t\t\t");
							}
							wrCell.setCellValue(data.getContents());
							continue;
						}
						wrCell.setCellValue(strInput);
						continue;
					}
					default: {
						continue;
					}
					}
				}
				final FileOutputStream out = new FileOutputStream(new File(outRespFileName));
				writeWb.write((OutputStream) out);
				System.out.println("Ended");
			}
			writeWb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		return data;
	}

	public static SSRest getRGCData(SSRest data, XmlPath xmlSS) {
		data.addressLine1 = xmlSS.getString("**.find {it.name() == 'Row'}.AddressLine1");
		data.addressLine2 = xmlSS.getString("**.find {it.name() == 'Row'}.AddressLine2");
		data.city = xmlSS.getString("**.find {it.name() == 'Row'}.City");
		data.postalcodebase = xmlSS.getString("**.find {it.name() == 'PostalCode.Base'}");
		data.stateprovince = xmlSS.getString("**.find {it.name() == 'Row'}.StateProvince");
		return data;
	}

	public static SSRest getCovCheckData(SSRest data, XmlPath xmlSS) {
		data.signalgsm = xmlSS.getString("**.find {it.name() == 'Row'}.SignalGSM");
		data.signalumts = xmlSS.getString("**.find {it.name() == 'Row'}.SignalUMTS");
		data.signallte = xmlSS.getString("**.find {it.name() == 'Row'}.SignalLTE");
		data.pcsspectrumenabled = xmlSS.getString("**.find {it.name() == 'Row'}.pcsSpectrumEnabled");
		data.awsspectrumenabled = xmlSS.getString("**.find {it.name() == 'Row'}.awsSpectrumEnabled");
		data.psapid = xmlSS.getString("**.find {it.name() == 'Row'}.PSAPID");
		data.market = xmlSS.getString("**.find {it.name() == 'Row'}.Market");
		data.timezone = xmlSS.getString("**.find {it.name() == 'Row'}.Timezone");
		data.dst_observed = xmlSS.getString("**.find {it.name() == 'Row'}.DST_Observed");
		data.mta = xmlSS.getString("**.find {it.name() == 'Row'}.MTA");
		data.psapenabled = xmlSS.getString("**.find {it.name() == 'Row'}.PSAPEnabled");
		data.msc_pool_region = xmlSS.getString("**.find {it.name() == 'Row'}.MSC_Pool_Region");
		data.mme_pool_id = xmlSS.getString("**.find {it.name() == 'Row'}.MME_Pool_ID");
		data.rnc_id_s1gw_id_lac_tac_list1 = xmlSS
				.getString("**.find {it.name() == 'Row'}.RNC_ID_S1GW_ID_LAC_TAC_List1");
		data.rnc_id_s1gw_id_lac_tac_list2 = xmlSS
				.getString("**.find {it.name() == 'Row'}.RNC_ID_S1GW_ID_LAC_TAC_List2");
		data.rnc_id_s1gw_id_lac_tac_list3 = xmlSS
				.getString("**.find {it.name() == 'Row'}.RNC_ID_S1GW_ID_LAC_TAC_List3");
		data.rnc_id_s1gw_id_lac_tac_list4 = xmlSS
				.getString("**.find {it.name() == 'Row'}.RNC_ID_S1GW_ID_LAC_TAC_List4");
		data.rnc_id_s1gw_id_lac_tac_list5 = xmlSS
				.getString("**.find {it.name() == 'Row'}.RNC_ID_S1GW_ID_LAC_TAC_List5");
		data.rnc_id_s1gw_id_lac_tac_list6 = xmlSS
				.getString("**.find {it.name() == 'Row'}.RNC_ID_S1GW_ID_LAC_TAC_List6");
		data.rnc_id_s1gw_id_lac_tac_list7 = xmlSS
				.getString("**.find {it.name() == 'Row'}.RNC_ID_S1GW_ID_LAC_TAC_List7");
		data.rnc_id_s1gw_id_lac_tac_list8 = xmlSS
				.getString("**.find {it.name() == 'Row'}.RNC_ID_S1GW_ID_LAC_TAC_List8");
		data.nbiot_s1gwid_tac_list1 = xmlSS.getString("**.find {it.name() == 'Row'}.NBIOT_S1GWID_TAC_List1");
		data.nbiot_s1gwid_tac_list2 = xmlSS.getString("**.find {it.name() == 'Row'}.NBIOT_S1GWID_TAC_List2");
		data.nbiot_s1gwid_tac_list3 = xmlSS.getString("**.find {it.name() == 'Row'}.NBIOT_S1GWID_TAC_List3");
		data.nbiot_s1gwid_tac_list4 = xmlSS.getString("**.find {it.name() == 'Row'}.NBIOT_S1GWID_TAC_List4");
		data.nbiot_s1gwid_tac_list5 = xmlSS.getString("**.find {it.name() == 'Row'}.NBIOT_S1GWID_TAC_List5");
		data.nbiot_s1gwid_tac_list6 = xmlSS.getString("**.find {it.name() == 'Row'}.NBIOT_S1GWID_TAC_List6");
		data.nbiot_s1gwid_tac_list7 = xmlSS.getString("**.find {it.name() == 'Row'}.NBIOT_S1GWID_TAC_List7");
		data.nbiot_s1gwid_tac_list8 = xmlSS.getString("**.find {it.name() == 'Row'}.NBIOT_S1GWID_TAC_List8");
		data.fips = xmlSS.getString("**.find {it.name() == 'Row'}.FIPS");
		data.mme_pool_name = xmlSS.getString("**.find {it.name() == 'Row'}.MME_Pool_name");
		data.county = xmlSS.getString("**.find {it.name() == 'Row'}.County");
		data.state = xmlSS.getString("**.find {it.name() == 'Row'}.State");
		return data;
	}
}