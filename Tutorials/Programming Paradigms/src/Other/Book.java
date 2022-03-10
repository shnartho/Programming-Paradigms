package Other;

import java.util.ArrayList;
import java.util.Arrays;

public class Book {

	private final String name;
	private ArrayList<Author> authors = new ArrayList<>();
	private double price;
	private int quantity;

	Book(String name, Author author, double price) {
		this.name = name;
		authors.add(author);
		this.price = price > 0 ? price : 0;
		quantity = 1;
	}

	public Book(String name, Author author, double price, int quantity) {
		this.name = name;
		authors.add(author);
		this.price = price > 0 ? price : 0;
		this.quantity = Math.max(quantity, 0);
	}

	Book(String name, ArrayList<Author> authors, double price, int quantity) {
		this.name = name;
		this.authors = authors;
		this.price = price > 0 ? price : 0;
		this.quantity = Math.max(quantity, 0);
	}

	public String getName() {
		return name;
	}

	public ArrayList<Author> getAuthor() {
		return authors;
	}

	public void addAuthor(Author author) {
		authors.add(author);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price > 0 ? price : 0;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = Math.max(quantity, 0);
	}

	public String toString() {
		return "Name: " + name + "\n" +
				"Author/s: " + getAuthor() + "\n" +
				"Price: " + price + "\n" +
				"Quantity: " + quantity + "\n";
	}

}
