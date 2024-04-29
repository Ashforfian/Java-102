package BookSorter;

import java.util.InputMismatchException;

public class Book {
    private String name;
    private int pageNum;
    private String author;
    private String date;
    public Book(String name, int pageNum, String author, String date){
         setAuthor(author);
         setDate(date);
         setName(name);
         setPageNum(pageNum);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if (pageNum>0){
            this.pageNum = pageNum;
        }else{
            throw new InputMismatchException();
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", pageNum=" + pageNum +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' ;
    }
}

