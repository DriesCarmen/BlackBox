package com.example.driescarmen.blackbox;

import android.content.Intent;
import android.renderscript.Int2;

/**
 * Created by DriesCarmen on 06/01/2018.
 */

public class User {

    String Name;
    String Group;
    Boolean ReadyToStart;
    String Question;
    Boolean Done;
    int ID;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public Boolean getReadyToStart() {
        return ReadyToStart;
    }

    public void setReadyToStart(Boolean readyToStart) {
        ReadyToStart = readyToStart;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public Boolean getDone() {
        return Done;
    }

    public void setDone(Boolean done) {
        Done = done;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User(String name, String group, Boolean readyToStart, Boolean done, int ID) {
        Name = name;
        Group = group;
        ReadyToStart = readyToStart;
        Done = done;
        this.ID = ID;
    }
}

