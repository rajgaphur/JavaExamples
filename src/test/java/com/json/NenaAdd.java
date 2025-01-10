package com.json;

import io.restassured.path.xml.XmlPath;

public class NenaAdd {

	public static void main(String[] args) {

		String nenaAddress = "<root><NAM>FEMTOCELL</NAM><HNO>8100</HNO><HNS></HNS><PRD></PRD><STN>Anderson Mill</STN><STS>RD</STS><POD></POD><MCN>Austin</MCN><COI>Williamson</COI><STA>TX</STA><ESN></ESN><LOC></LOC></root>";
		//JSONObject nenaJsonObject	=	new JSONObject(nenaAddress);
		XmlPath nenaXml = new XmlPath(nenaAddress);
		String NAMValue = nenaXml.getString("**.find {it.name() == 'NAM'}");
		System.out.println("NAM : "+NAMValue);
		
		String HNOvalue = nenaXml.getString("**.find {it.name() == 'HNO'}");
		System.out.println("HNO : "+HNOvalue);
	}

}
