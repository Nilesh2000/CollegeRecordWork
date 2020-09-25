import java.io.*;
import java.net.*;
import java.util.*;

class DateServer {
  public static void main(String args[]) throws Exception {
    ServerSocket s = new ServerSocket(5217);
    while(true) {
      System.out.println("Waiting For Connection...");
      Socket soc = s.accept();
      DataOutputStream out = new DataOutputStream(soc.getOutputStream());
      out.writeBytes("Date With Time : " + (new Date()).toString() + "\n");

      out.close();
      soc.close();
    }
  }
}
