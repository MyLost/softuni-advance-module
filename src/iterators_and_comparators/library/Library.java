package iterators_and_comparators.library;

import iterators_and_comparators.book.Book;

import java.util.Iterator;

public class Library<Book> implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }


    private class LibraryIterator implements Iterator<Book> {

        private int counter=0;
        @Override
        public boolean hasNext() {
            return books.length > counter;
        }

        @Override
        public Book next() {
            return books[counter++];
        }
    }
}
