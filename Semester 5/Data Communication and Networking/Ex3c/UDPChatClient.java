import java.io.*;
import java.net.*;

class UDPChatClient {
  public static DatagramSocket clientsocket;
  public static DatagramPacket dp;
  public static BufferedReader dis;
  public static InetAddress ia;
  public static byte buf[] = new byte[1024];
  public static int clientPort = 789, serverPort = 790;

  public static void main(String[] a) throws IOException {
    clientsocket = new DatagramSocket(clientPort);
    dp = new DatagramPacket(buf, buf.length);
    dis = new BufferedReader(new InputStreamReader(System.in));
    ia = InetAddress.getLocalHost();
    System.out.println("Client is Running... Type 'exit' to quit.");

    while(true) {
      String str = new String(dis.readLine());
      buf = str.getBytes();

      if(str.equals("exit")) {
        System.out.println("Terminated...");
        clientsocket.send(new DatagramPacket(buf, str.length(), ia,serverPort));
        break;
      }

      clientsocket.send(new DatagramPacket(buf, str.length(), ia, serverPort));
      clientsocket.receive(dp);
      String str2 = new String(dp.getData(), 0, dp.getLength());
      System.out.println("Server : " + str2);
    }
  }
}
