package com.tutorial.aurie.finalyearproject;

/**
 * Created by aurie on 07/04/2017.
 */

public class ChildMessage {
    private int profileImage;
    private String childName;
    private String age;
    private String DOB;
    private String Gender;
    private String PhoneNumber;

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

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public ChildMessage(int profileImage, String childName, String age, String DOB, String gender, String phoneNumber) {
        this.profileImage = profileImage;
        this.childName = childName;
        this.age = age;
        this.DOB = DOB;
        Gender = gender;
        PhoneNumber = phoneNumber;
    }
}
