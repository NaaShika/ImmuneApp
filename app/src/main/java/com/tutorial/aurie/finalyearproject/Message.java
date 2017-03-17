package com.tutorial.aurie.finalyearproject;

/**
 * Created by aurie on 09/03/2017.
 */

public class Message {
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

    public Message(int profileImage, String senderName, String deliveredTime, String message) {
        this.profileImage = profileImage;
        this.senderName = senderName;
        this.deliveredTime = deliveredTime;
        this.message = message;
    }
}
