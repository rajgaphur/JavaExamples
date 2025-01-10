package com.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Test1 {

  public static void main(String[] args) throws Exception {
    String[] cmd = {"sudo","-S", "ls"};
    System.out.println(runSudoCommand(cmd));
  }

  private static int runSudoCommand(String[] command) throws Exception {

    Runtime runtime =Runtime.getRuntime();
    Process process = runtime.exec(command);
    OutputStream os = process.getOutputStream();
    os.write("astagfirullh\n".getBytes());
    os.flush();
    os.close();
    process.waitFor();
    String output = readFile(process.getInputStream());
    if (output != null && !output.isEmpty()) {
      System.out.println(output);
    }
    String error = readFile(process.getErrorStream());
    if (error != null && !error.isEmpty()) {
      System.out.println(error);
    }
    return process.exitValue();
  }

  private static String readFile(InputStream inputStream) throws Exception {
    if (inputStream == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    BufferedReader bufferedReader = null;
    try {
      bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      String line = bufferedReader.readLine();
      while (line != null) {
        sb.append(line);
        line = bufferedReader.readLine();
      }
      return sb.toString();
    } finally {
      if (bufferedReader != null) {
        bufferedReader.close();
      }
    }
  }

}
