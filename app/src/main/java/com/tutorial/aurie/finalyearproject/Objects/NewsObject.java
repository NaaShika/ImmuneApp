package com.tutorial.aurie.finalyearproject.Objects;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by aurie on 20/04/2017.
 */

public class NewsObject extends RealmObject{

    public String Title;
    public  String Time;
    public  String Date;


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public NewsObject() {
    }

    public NewsObject(String title, String time, String date) {
        Title = title;
        Time = time;
        Date = date;
    }

    public void Save(NewsObject newsObject){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(newsObject);
        realm.commitTransaction();
    }

    public List<NewsObject> retrieveAll(){
        Realm realm = Realm.getDefaultInstance();
        return realm.where(NewsObject.class).findAll();
    }
}
