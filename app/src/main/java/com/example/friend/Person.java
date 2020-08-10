package com.example.friend;

import android.media.Image;
import android.widget.ImageView;

public class Person {

    private String person_name;
    //private ImageView person_image;

    public String getPerson_name() {
        return person_name;
    }

    /*public ImageView getPerson_image() {
        return person_image;
    }*/

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }
    /*public void setPerson_image(ImageView person_image) {
        this.person_image = person_image;
    }*/

    public Person(String person_name) {
        this.person_name = person_name;
        //this.person_image = person_image;
    }
}
