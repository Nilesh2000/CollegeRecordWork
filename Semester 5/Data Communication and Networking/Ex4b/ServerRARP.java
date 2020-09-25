import java.io.*;
import java.net.*;
import java.util.*;

class ServerRARP
{
  public static void main(String args[]) {
    try {
      DatagramSocket server = new DatagramSocket(1309);

      while(true) {
        byte[] sendbyte = new byte[1024];
        byte[] receivebyte = new byte[1024];
        DatagramPacket receiver = new DatagramPacket(receivebyte, receivebyte.length);

        server.receive(receiver);
        String str = new String(receiver.getData());
        String s = str.trim();

        InetAddress addr = receiver.getAddress();
        int port = receiver.getPort();
        String mac[] = {"6A:08:AA:C2", "8A:BC:E3:FA", "6A:09:AA:C3", "8A:CD:E4:GA"};
        String ip[] = {"192.168.18.69", "192.168.18.70", "192.168.18.71", "192.168.18.72"};

        for(int i = 0 ; i < ip.length ; i++)
        {
          if(s.equals(mac[i])) {
            sendbyte = ip[i].getBytes();
            DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, addr, port);
            server.send(sender);
            break;
          }
        }
        break;
      }
    } catch(Exception e) {
      System.out.println(e);
    }
  }
}
