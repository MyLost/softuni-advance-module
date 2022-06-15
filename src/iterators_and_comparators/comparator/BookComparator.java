package iterators_and_comparators.comparator;

import iterators_and_comparators.book.Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book one, Book two) {
        return one.compareTo(two);
    }
}
