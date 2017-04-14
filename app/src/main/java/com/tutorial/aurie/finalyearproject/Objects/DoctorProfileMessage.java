package com.tutorial.aurie.finalyearproject.Objects;

/**
 * Created by aurie on 13/04/2017.
 */

public class DoctorProfileMessage {

    public int ProfileImage;
    public String DoctorName;
    public String Speciality;

    public int getProfileImage() {
        return ProfileImage;
    }

    public void setProfileImage(int profileImage) {
        ProfileImage = profileImage;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }

    public DoctorProfileMessage(int profileImage, String doctorName, String speciality) {
        ProfileImage = profileImage;
        DoctorName = doctorName;
        Speciality = speciality;
    }
}
