package utils.JsonParser.Example3;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by WataruS on 8/26/2017.
 */
public class Book {
    private String title;
    private String isbn_10;
    private String isbn_13;
    private String[] authors;


    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        Book book = gson.fromJson(new FileReader("src/main/java/utils/JsonParser/Example3/simpleExample.json"), Book.class);
        System.out.println(gson.toJson(book));
        System.out.println(book.getTitle());
        System.out.println(book.getIsbn_10());
        System.out.println(book.getIsbn_13());
        System.out.println(book.getAuthors()[0]);
        System.out.println(book.getAuthors()[1]);
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn_10() {
        return isbn_10;
    }

    public void setIsbn_10(String isbn_10) {
        this.isbn_10 = isbn_10;
    }

    public String getIsbn_13() {
        return isbn_13;
    }

    public void setIsbn_13(String isbn_13) {
        this.isbn_13 = isbn_13;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }
}
