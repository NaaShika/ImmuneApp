package com.tutorial.aurie.finalyearproject.Objects;

/**
 * Created by aurie on 20/04/2017.
 */

public class NewsObject {

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


    public NewsObject(String title, String time, String date) {
        Title = title;
        Time = time;
        Date = date;
    }
}
