package br.ufrn.imd.library;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote{

	public String search(String title) throws RemoteException;
	
}
