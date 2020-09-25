import java.io.*;
import java.net.*;

class UDPDateClient {
  public static void main(String[] args) throws Exception {
    System.out.println("Server Time:-");
    DatagramSocket cs = new DatagramSocket();
    InetAddress ip = InetAddress.getByName("localhost");
    byte[] rd = new byte[100];
    byte[] sd = new byte[100];
    DatagramPacket sp = new DatagramPacket(sd, sd.length, ip, 1234);
    DatagramPacket rp = new DatagramPacket(rd, rd.length);
    cs.send(sp);
    cs.receive(rp);
    String time = new String(rp.getData());
    System.out.println(time);
    cs.close();
  }
}
