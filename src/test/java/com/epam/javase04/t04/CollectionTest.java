package com.epam.javase04.t04;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class CollectionTest {
    @Test
    public void createFile(){
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Home Alone", new Actor("Macaulay", "Culkin"), new Actor("Joe", "Pesci")));
        movies.add(new Movie("Home Alone 2", new Actor("Macaulay", "Culkin"), new Actor("Daniel", "Stern")));
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:\\EPAM\\javase04\\src\\resources\\movies.txt"))) {
            oos.writeObject(movies);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void workWithCollection(){
        IMDb db = new IMDb();
        db.addFilm(new Movie("Back to the Future", new Actor("Michael J", "Fox"), new Actor("Christopher", "Lloyd")));
        db.addFilm(new Movie("Back to the Future 2", new Actor("Michael J", "Fox"), new Actor("Christopher", "Lloyd")));

        for (Movie m : db.movieDB) {
            System.out.println(m.getTitle());
        }

        db.saveDB();


    }
}
