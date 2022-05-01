package br.ufrn.imd.library.model;

public abstract class LibObj {

	private final String name;
	private final String author;
	private String type;
	private boolean available = true;
	private int qtdDays = 0;
	
	public LibObj(String name, String author) {
		this.name = name;
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available, int qtdDays) {
		this.available = available;
		this.qtdDays = qtdDays;
	}

	public int getQtdDays() {
		return qtdDays;
	}

	
}
