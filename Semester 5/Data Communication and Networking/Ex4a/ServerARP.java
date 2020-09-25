import java.io.*;
import java.net.*;
import java.util.*;

class ServerARP {
  public static void main(String args[]) {
    try {
      ServerSocket obj = new ServerSocket(189);
      Socket obj1 = obj.accept();
      
      while(true) {
        DataInputStream din = new DataInputStream(obj1.getInputStream());
        DataOutputStream dout = new DataOutputStream(obj1.getOutputStream());

        String str = din.readLine();
        String ip[] = {"192.168.18.69", "192.168.18.70", "192.168.18.71", "192.168.18.72"};
        String mac[] = {"6A:08:AA:C2", "8A:BC:E3:FA", "6A:09:AA:C3", "8A:CD:E4:GA"};

        for(int i = 0 ; i < ip.length; i++) {
          if(str.equals(ip[i])) {
            dout.writeBytes(mac[i] + '\n');
            break;
          }
        }                     
        obj.close();
      }       
    } catch(Exception e) {
      System.out.println(e);
    }
  }
}
