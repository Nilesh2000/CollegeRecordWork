import java.net.*;
import java.io.*;

public class DnsServer {

  public static DatagramSocket serversocket;
  public static DatagramPacket dp;
  public static byte buf[] = new byte[1024];

  public static void main(String[] a) throws IOException {
    serversocket = new DatagramSocket(1234);
    System.out.println("Server is up and running...");

    while (true) {
      dp = new DatagramPacket(buf, buf.length);
      serversocket.receive(dp);
      String hname = new String(dp.getData(), 0, dp.getLength());

      if (hname.equals("STOP")) {
        System.out.println("Server terminated...");
        break;
      }

      InetAddress address;
      address = InetAddress.getByName(hname);

      System.out.println("\nCanonical name : " + address.getCanonicalHostName());
      System.out.println("Host Name : " + address.getHostName());
      System.out.println("Host IP : " + address.getHostAddress());

      InetAddress ia = InetAddress.getByName(null);
      System.out.println("Host name : " + ia.getHostName());

      InetAddress addr = InetAddress.getLoopbackAddress();
      System.out.println("Adress loopback is : " + addr.getHostAddress());

      InetAddress myip = null;
      myip = InetAddress.getLocalHost();

      String IPAddress = myip.getHostAddress();
      String hostname = myip.getHostName();
      System.out.printf("IP address of Localhost is %s %n", IPAddress);
      System.out.printf("Hostname of localhost is %s %n", hostname);
    }
  }
}
