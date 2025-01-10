package com.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDel {

	public static void main(String[] args) {
		
		String url = "http://135.115.145.247:8484/v1/data/smpc/cells/lte/cid_cells/310-260-256010935";
		String type = "DELETE";
		try {
			HttpURLConnection conn = getHttpConnection(url,type);
			//System.out.println("getContent \n"+conn.getContent().toString());
			System.out.println("getCode \n"+conn.getResponseCode());
			System.out.println(" "+conn.getResponseMessage());
			BufferedReader br = null;
    			if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) { 
    				br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
    			}else {
    				br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
    			}
    		
    		String output;
    		String result = "";
    		System.out.println("Output from Server .... \n");
			
    		while((output = br.readLine()) != null) {
    		    result += output;
    			System.out.println(output);
    		}
    		
    		System.out.println(result);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static HttpURLConnection getHttpConnection(String url, String type){
        URL uri = null;
        HttpURLConnection con = null;
        try{
            uri = new URL(url);
            con = (HttpURLConnection) uri.openConnection();
            con.setRequestMethod(type); //type: POST, PUT, DELETE, GET
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setConnectTimeout(60000); //60 secs
            con.setReadTimeout(60000); //60 secs
            con.setRequestProperty("Accept-Encoding", "Your Encoding");
            con.setRequestProperty("Content-Type", "Your Encoding");
            
        }catch(Exception e){
            System.out.println("connection i/o failed" );
        }
        return con;
}
}
