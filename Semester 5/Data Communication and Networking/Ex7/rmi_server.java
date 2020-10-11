import java.rmi.*;
import java.net.*;

public class rmi_server {
  public static void main(String arg[]) {
    try {
      rmi_imp ri = new rmi_imp();
      Naming.rebind("rmi_server", ri);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
