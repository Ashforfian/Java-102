package BookSorter;

import java.util.Comparator;

public class OrderPageComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return b1.getPageNum() - b2.getPageNum();
    }
}
