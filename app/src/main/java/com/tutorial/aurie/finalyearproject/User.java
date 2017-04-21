package com.tutorial.aurie.finalyearproject;

import com.tutorial.aurie.finalyearproject.Objects.DoctorProfileMessage;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by aurie on 24/02/2017.
 */

public class User extends RealmObject {

    public String name;
    @PrimaryKey
    public String phoneNumber;
    public String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String  getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String  phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String name, String  phoneNumber, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public void Save(User user) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();
    }

    public List<User> retrieveAll() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(User.class).findAll();
    }
}
