import java.net.*;
import java.io.*;

public class DnsClient {
  public static DatagramSocket clientsocket;
  public static DatagramPacket dp;
  public static BufferedReader din;
  public static InetAddress ia;
  public static byte buf[] = new byte[1024];

  public static void main(String[] a) throws IOException {
    clientsocket = new DatagramSocket();
    din = new BufferedReader(new InputStreamReader(System.in));
    ia = InetAddress.getLocalHost();

    System.out.println("Client is Running... Type 'STOP' to Quit\n");

    while (true) {
      System.out.println("Enter Host Name : ");
      String str = new String(din.readLine());
      buf = str.getBytes();
      dp = new DatagramPacket(buf, buf.length, ia, 1234);

      if (str.equals("STOP")) {
        System.out.println("Terminated...");
        clientsocket.send(dp);
        break;
      }
      clientsocket.send(dp);
    }
  }
}
