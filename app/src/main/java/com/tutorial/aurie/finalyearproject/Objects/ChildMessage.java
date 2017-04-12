package com.tutorial.aurie.finalyearproject.Objects;

/**
 * Created by aurie on 07/04/2017.
 */

public class ChildMessage {
    private int profileImage;
    private String childName;
    private String age;
    private String gender;

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
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

    public ChildMessage(int profileImage, String childName, String age, String gender) {
        this.profileImage = profileImage;
        this.childName = childName;
        this.age = age;
        this.gender = gender;
    }
}
