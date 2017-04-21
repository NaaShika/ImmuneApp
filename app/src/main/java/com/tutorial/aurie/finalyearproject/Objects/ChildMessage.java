package com.tutorial.aurie.finalyearproject.Objects;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by aurie on 07/04/2017.
 */

public class ChildMessage extends RealmObject{
    @PrimaryKey
    private String ID;
    private String profileImage;
    private String childName;
    private String age;
    private String gender;
    private String parentName;
    private String parentEmail;
    private String parentPhone;
    private boolean notifications;

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ChildMessage() {
    }

    public ChildMessage(String ID, String profileImage, String childName, String age, String gender) {
        this.profileImage = profileImage;
        this.childName = childName;
        this.age = age;
        this.gender = gender;
        this.ID = ID;

    }

    public ChildMessage(String ID, String profileImage, String childName, String age, String gender, String parentName, String parentEmail, String parentPhone, boolean notifications) {
        this.ID = ID;
        this.profileImage = profileImage;
        this.childName = childName;
        this.age = age;
        this.gender = gender;
        this.parentName = parentName;
        this.parentEmail = parentEmail;
        this.parentPhone = parentPhone;
        this.notifications = notifications;
    }

    public void Save(ChildMessage child){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(child);
        realm.commitTransaction();
    }

    public List<ChildMessage> retrieveAll(){
        Realm realm = Realm.getDefaultInstance();
        return realm.where(ChildMessage.class).findAll();
    }
}
