import java.io.*;
import java.net.*;

class UDPChatServer {
	public static DatagramSocket serversocket;
	public static DatagramPacket dp;
	public static BufferedReader dis;
	public static InetAddress ia;
	public static byte buf[] = new byte[1024];
	public static int clientPort = 789, serverPort = 790;

	public static void main(String[] a) throws IOException {
    serversocket = new DatagramSocket(serverPort);
    dp = new DatagramPacket(buf, buf.length);
    dis = new BufferedReader(new InputStreamReader(System.in));
    ia = InetAddress.getLocalHost();
    System.out.println("Server is Running... Type 'exit' to quit.");

    while(true)	{
      serversocket.receive(dp);
      String str = new String(dp.getData(), 0, dp.getLength());

      if(str.equals("exit")) {
        System.out.println("Terminated...");
        break;
      }

      System.out.println("Client : " + str);
      String str1 = new String(dis.readLine());
      buf = str1.getBytes();
      serversocket.send(new DatagramPacket(buf, str1.length(), ia, clientPort));
    }
  }
}
