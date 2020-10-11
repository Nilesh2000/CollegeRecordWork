import java.rmi.*;
import java.rmi.server.*;

public class rmi_imp extends UnicastRemoteObject implements rmi_int {
  public rmi_imp() throws RemoteException {
  }

  public double average(double x, double y) throws RemoteException {
    return (x + y) / 2;
  }
}
