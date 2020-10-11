import java.rmi.*;

public class rmi_client {
  public static void main(String arg[]) {
    try {
      rmi_int rr = (rmi_int) Naming.lookup("rmi://127.1.1.0/rmi_server");
      double s = rr.average(5, 9);
      System.out.println("Average of the two numbers is : " + s);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
