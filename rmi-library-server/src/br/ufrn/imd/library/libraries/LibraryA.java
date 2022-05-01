package br.ufrn.imd.library.libraries;

import java.util.ArrayList;
import java.util.Comparator;

import br.ufrn.imd.library.model.Book;
import br.ufrn.imd.library.model.LibObj;

//@SuppressWarnings("serial")
public class LibraryA implements LibraryInterface{
	
	private ArrayList<LibObj> libObjs = new ArrayList<>();
	private final String name = "Library A";
	
	public LibraryA() {
		LibObj b1 = new Book("A Clash of Kings","George R. R. Martin");
		LibObj b2 = new Book("The Hitchhiker's Guide to the Galaxy","Douglas Adams");
		LibObj b3 = new Book("A Clash of Kings","George R. R. Martin");
		
		libObjs.add(b1);
		libObjs.add(b2);	
		libObjs.add(b3);	
		
	}

	@Override
	public String searchForTitle(String title){
		int borrewedBook = 0;
		long qtTitle = libObjs.stream()
					.filter(b -> b.getName().equals(title))
					.count();
		long availableTitle = libObjs.stream()
				.filter(b -> b.getName().equals(title))
				.filter(b -> b.isAvailable())				
				.count();
		if(qtTitle > 0 && availableTitle == 0) {
			 borrewedBook = libObjs.stream()
					.filter(b -> b.getName().equals(title))
					.filter(b -> !b.isAvailable())
					.sorted(Comparator.comparing(LibObj::getQtdDays))
					.findFirst().get().getQtdDays();
		} 
		if(qtTitle == 0) {
			return name+": No copies available of this title.";
		}
		else {
			return availableTitle > 0 ? name+ ": There's "+availableTitle+" copie(s) available." 
					:name+ ": It's going to be available in "+borrewedBook+" days." ;			
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public void borrow(String title, int days) {
		libObjs.stream()
		.filter(b -> b.getName().equals(title))
		.filter(b -> b.isAvailable())
		.findFirst().get().setAvailable(false, days);
	}

	@Override
	public void returnCopie(String title, int days) {
		libObjs.stream()
		.filter(b -> b.getName().equals(title))
		.filter(b -> b.getQtdDays() == days)
		.findFirst().get().setAvailable(true, 0);
	}
	
}
