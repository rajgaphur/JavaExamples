package com.http;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class LogicVolume {
	
	private static void runCmds(String[] cmds) throws IOException, InterruptedException
	   {
	      for(String cmd : cmds)
	      {
	         System.out.print(cmd);
	         System.out.print(' ');
	      }
	      Process process = Runtime.getRuntime().exec(cmds);
	      InputStreamReader ir = new InputStreamReader(process.getInputStream());
	      LineNumberReader input = new LineNumberReader(ir);
	      String line;
	      while((line = input.readLine()) != null)
	      {
	         System.out.println(line);
	      }
	   }
	   
	   protected static String sudoCmd = "echo \"Abcd123456\" | sudo -S ";

	  /**
	    * @param args
	    * @throws IOException 
	    * @throws InterruptedException 
	    */
	   public static void main(String[] args) throws IOException, InterruptedException
	   {
	      testExecuteCommand();
	   }

	   private static void testExecuteCommand() throws IOException, InterruptedException
	   {
	      String cmds[] = {"/bin/bash", "-c", sudoCmd + "ls -l/home"};
	      LogicVolume.runCmds(cmds);
	   }
}
