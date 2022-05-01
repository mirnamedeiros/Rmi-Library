package br.ufrn.imd.library;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class Client extends UnicastRemoteObject implements ClientInterface {

	protected Client() throws RemoteException {
		super();
	}
	
}
