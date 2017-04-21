package com.tutorial.aurie.finalyearproject.Objects;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by aurie on 09/03/2017.
 */

public class Message extends RealmObject{
    private int profileImage;
    private String senderName;
    private String deliveredTime;
    private String message;

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getDeliveredTime() {
        return deliveredTime;
    }

    public void setDeliveredTime(String deliveredTime) {
        this.deliveredTime = deliveredTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message() {
    }

    public Message(int profileImage, String senderName, String deliveredTime, String message) {
        this.profileImage = profileImage;
        this.senderName = senderName;
        this.deliveredTime = deliveredTime;
        this.message = message;
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
