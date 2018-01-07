package com.example.driescarmen.blackbox;

import android.content.Intent;
import android.renderscript.Int2;

/**
 * Created by DriesCarmen on 06/01/2018.
 */

public class User {

    String name;
    String group;
    Boolean readyToStart;
    String question;
    Boolean done;


    public User(String name, String group, Boolean readyToStart, Boolean done) {
        this.name = name;
        this.group = group;
        this.readyToStart = readyToStart;
        this.done = done;
    }

    public String getName() {
        return name;
    }


    public String getGroup() {
        return group;
    }


    public Boolean getReadyToStart() {
        return readyToStart;
    }

    public void setReadyToStart(Boolean readyToStart) {
        this.readyToStart = readyToStart;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}

