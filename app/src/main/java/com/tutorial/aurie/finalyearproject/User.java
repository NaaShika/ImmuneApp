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
    public String id;
    @PrimaryKey
    public Long phoneNumber;
    public String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void Save(DoctorProfileMessage DrProfile){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(DrProfile);
        realm.commitTransaction();
    }

    public List<DoctorProfileMessage> retrieveAll(){
        Realm realm = Realm.getDefaultInstance();
        return realm.where(DoctorProfileMessage.class).findAll();
    }
}
