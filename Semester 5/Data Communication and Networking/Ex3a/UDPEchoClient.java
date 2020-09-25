import java.io.*;
import java.net.*;
class UDPEchoClient {
  public static class UDPEchoReader extends Thread {
    
    public UDPEchoReader(DatagramSocket socket) {
      datagramSocket = socket;
      active = true;
    }

    public void run() {
      byte[] buffer = new byte[1024];
      DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
      String receivedString;
      while(active) {
        try {
          datagramSocket.receive(incoming);
          receivedString = new String(incoming.getData(), 0, incoming.getLength());
          System.out.println("Received from Server : "+ receivedString);
        } catch(IOException e) {
          System.out.println(e);
          active = false;
        }
      }
    }

    public boolean active;
    public DatagramSocket datagramSocket;
  }

  public static void main(String[] args) {
    InetAddress address = null;
    int port = 8000;
    DatagramSocket datagramSocket = null;
    BufferedReader keyboardReader = null;
    try {
      address = InetAddress.getByName("127.0.0.1");
      datagramSocket = new DatagramSocket();
      keyboardReader = new BufferedReader(new InputStreamReader(System.in));
    } catch (IOException e) {
      System.out.println(e);
      System.exit(1);
    }

    UDPEchoReader reader = new UDPEchoReader(datagramSocket);
    reader.setDaemon(true);
    reader.start();
    System.out.println("Ready to send your messages...");

    try {
      String input;
      while (true) {
        input = keyboardReader.readLine();
        DatagramPacket datagramPacket = new DatagramPacket(input.getBytes(), input.length(), address, port);
        datagramSocket.send(datagramPacket);
      }
    } catch(IOException e) {
      System.out.println(e);
    }
  }
}

