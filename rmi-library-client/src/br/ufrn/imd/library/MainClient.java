package br.ufrn.imd.library;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class MainClient {
	
	public static void main(String[] args) {
		
		try {
			
			ServerInterface server = (ServerInterface) 
					Naming.lookup("rmi://127.0.0.1:1098/LibraryServer");
			
			
			System.out.println(server.search("A Dance with Dragons"));
			System.out.println(server.search("A Clash of Kings"));
			
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			
			e.printStackTrace();
		}
	}
}
