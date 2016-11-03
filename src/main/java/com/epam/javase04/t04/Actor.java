package com.epam.javase04.t04;

import java.io.Serializable;
import java.util.ArrayList;

public class Actor implements Serializable{
    String name = "";
    String lastname = "";
    ArrayList<String> filmography = new ArrayList();

    public Actor(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public void addFilm(String film){
        if(!filmography.contains(film)){
            filmography.add(film);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public ArrayList<String> getFilmography() {
        return filmography;
    }

    public void setFilmography(ArrayList<String> filmography) {
        this.filmography = filmography;
    }



}
