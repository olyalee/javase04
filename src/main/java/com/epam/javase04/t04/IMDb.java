package com.epam.javase04.t04;

import java.io.*;
import java.util.ArrayList;

public class IMDb implements Serializable {
    ArrayList<Movie> movieDB = new ArrayList<>();
    String fileName = "c:\\EPAM\\javase04\\src\\resources\\movies.txt";

    public  IMDb(){
        getDB(fileName);
    }

    //get from file
    public void getDB(String fileName){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
          movieDB = (ArrayList<Movie>)ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //save to file
    public void saveDB(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(movieDB);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //add new movie
    public void addFilm(Movie movie){
        movieDB.add(movie);
    }

    //remove movie
    public void removeMovie(String movieTitle){
        for (Movie movie: movieDB) {
            if(movie.getTitle().equalsIgnoreCase(movieTitle)){
                movieDB.remove(movie);
            }
        }
    }

    //change title
    public void changeMovieTitle(String wrongTitle, String correctMovieTitle){
        for (Movie movie: movieDB) {
            if(movie.getTitle().equalsIgnoreCase(wrongTitle)){
                movie.setTitle(correctMovieTitle);
            }
        }
    }

}
