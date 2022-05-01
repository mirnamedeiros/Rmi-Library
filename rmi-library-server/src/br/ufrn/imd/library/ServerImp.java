package br.ufrn.imd.library;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import br.ufrn.imd.library.libraries.LibraryA;
import br.ufrn.imd.library.libraries.LibraryB;
import br.ufrn.imd.library.libraries.LibraryC;
import br.ufrn.imd.library.libraries.LibraryInterface;

@SuppressWarnings("serial")
public class ServerImp extends UnicastRemoteObject implements ServerInterface{
	
	private ArrayList<LibraryInterface> libraries = new ArrayList<>();
	
	protected ServerImp() throws RemoteException {
		super();
		LibraryA lA = new LibraryA();
		LibraryB lB = new LibraryB();
		LibraryC lC = new LibraryC();
		libraries.add(lA);
		libraries.add(lB);
		libraries.add(lC);
	}


	@Override
	public String search(String title) throws RemoteException {
		
		String s = "";
		for(LibraryInterface l : libraries) {
			s += l.searchForTitle(title);
			s +="\n";
		}		
		return s;
	}

}
