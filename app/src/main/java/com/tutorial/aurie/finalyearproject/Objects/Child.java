package com.tutorial.aurie.finalyearproject.Objects;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by aurie on 07/04/2017.
 */

public class Child {
    @PrimaryKey
    public String ID;
    public String profileImage;
    public String childName;
    public String age;
    public String gender;
    public String parentEmail;
    public String parentPhone;
    public boolean notifications;


    public Child() {
    }

    public Child(String ID, String profileImage, String childName, String age, String gender, String parentEmail, String parentPhone, boolean notifications) {
        this.ID = ID;
        this.profileImage = profileImage;
        this.childName = childName;
        this.age = age;
        this.gender = gender;
        this.parentEmail = parentEmail;
        this.parentPhone = parentPhone;
        this.notifications = notifications;
    }
}
