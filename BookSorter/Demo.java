package BookSorter;

import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        Book b1 = new Book("a",120,"c","29.03.2003");
        Book b2 = new Book("b",240,"Jules Verne","23.03.1903");
        Book b3 = new Book("c",210,"d","01.01.2004");
        Book b4 = new Book("d",180,"g","19.07.1976");
        Book b5 = new Book("e",105,"h","10.07.1970");
        OrderPageComparator order = new OrderPageComparator();
        TreeSet<Book> books = new TreeSet<>(order);
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        for (Book element: books){
            System.out.println(element);
        }
        OrderNameComparator order2 = new OrderNameComparator();
        TreeSet<Book> books2 = new TreeSet<>(order2);
        books2.add(b1);
        books2.add(b2);
        books2.add(b3);
        books2.add(b4);
        books2.add(b5);
        System.out.println("------------------------------------------------");
        for (Book element: books2){
            System.out.println(element);
        }
    }
}
