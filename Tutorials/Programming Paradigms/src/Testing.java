import Other.Author;
import Other.Book;

public class Testing {

	public static void main(String[] args) {

		/*
		*	Only the book and author part needs testing, The other classes and interface are self explanatory
		* 	But more details are provided where needed.
		 */
		Author author1 = new Author("Stephen King", "None", 'm');
		Author author2 = new Author("Peter Straub", "None", 'm');

		Book book1 = new Book("The Talisman", author1, 4.99, 1000);
		book1.addAuthor(author2);

		System.out.println(book1);

	}

}
