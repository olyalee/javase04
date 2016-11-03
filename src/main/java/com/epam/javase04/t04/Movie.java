package com.epam.javase04.t04;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable{
    String title = "";
    ArrayList<Actor> mainActors = new ArrayList<>();

    public Movie(String title) {
        this.title = title;
    }

    public Movie(String title, Actor leadActor1, Actor leadActor2){
        this.title = title;
        mainActors.add(leadActor1);
        mainActors.add(leadActor2);
    }

    public void addActor(Actor... actors){
        if(actors.length!=0){
            for(Actor actor:actors){
                if(!mainActors.contains(actor)){
                    mainActors.add(actor);
                }
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Actor> getMainActors() {
        return mainActors;
    }

    public void setMainActors(ArrayList<Actor> mainActors) {
        this.mainActors = mainActors;
    }

}
