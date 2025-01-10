package com.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSudo {
	private String[] command = null;
	private String commandOutput = null;
	private Process process = null;
	public String SIMULATOR_WINDOWS_FILE_PATH = "C:\\DriveD/";
	
	public static void main(String[] args) {
		
		String cmdNetStat = "dir";//"dir";//"tasklist";
		String[] commandlist = { "cmd", "/c", cmdNetStat };
		
		TestSudo commandLineProcess = new TestSudo();
		
		try {

			System.out.println("Command: "+Arrays.toString(commandlist));
			List<String> responseLines = commandLineProcess.execCommandReturnAsList(commandlist);
			DisplayList(responseLines);
			
			
		} catch (Exception e) {
			System.out.println(
					"TestSystem.startSimulator:  Unable to start local simulator due to exception:  " + e.getMessage());
		}
	}

	public List<String> execCommandReturnAsList(String[] command) throws IOException {
		this.command = command;
		ProcessBuilder pb = new ProcessBuilder(this.command);
		
		pb.directory(new File(SIMULATOR_WINDOWS_FILE_PATH));
		pb.redirectErrorStream(true);
		List<String> responseLines = new ArrayList<String>();
		
		System.out.println("Linux command: " + Arrays.toString(command));
		
		try {
			
			this.process = pb.start();
			
			// To capture output from the process
			InputStream shellIn = this.process.getInputStream();
			
			//Getting the InputStream as list of strings 
			responseLines = readInputStreamAsList(shellIn);
			System.out.println(responseLines);

		}

		catch (IOException e) {
			System.out.println("Error occured while executing Linux command. Error Description: " + e.getMessage());
		}
		
		return responseLines;  
	}
	private List<String> readInputStreamAsList(InputStream input) throws IOException {
		StringBuilder resultCommandOutput = new StringBuilder();
		List<String> result = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		String line;
		
		while ((line = reader.readLine()) != null) {
			result.add(line);
			resultCommandOutput.append(line);
		}
		
		this.commandOutput = resultCommandOutput.toString();
		return result;
	}
	
	public static void DisplayList(List<String> responseLines) {
		
		System.out.println("---------------------------------------------------------------------------");
		for (String string : responseLines) {
			System.out.println(string);
		}
		System.out.println("---------------------------------------------------------------------------");
	}
}
