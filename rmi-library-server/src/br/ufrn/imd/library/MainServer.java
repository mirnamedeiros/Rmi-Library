package br.ufrn.imd.library;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MainServer {

	public static void main(String[] args)  {
		
		try {
			
			System.setProperty("java.rmi.server.hostname","127.0.0.1");
			
			ServerInterface server = new ServerImp();

			LocateRegistry.createRegistry(1098);
			
			Naming.rebind("rmi://127.0.0.1:1098/LibraryServer", server);
			
			System.out.println("RMI Server Started.");
			
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
}
