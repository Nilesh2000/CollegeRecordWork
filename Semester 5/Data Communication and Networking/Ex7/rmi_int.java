import java.rmi.*;

public interface rmi_int extends Remote {
  double average(double x, double y) throws RemoteException;
}
