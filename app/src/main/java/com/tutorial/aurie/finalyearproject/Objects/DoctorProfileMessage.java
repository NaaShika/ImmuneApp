package com.tutorial.aurie.finalyearproject.Objects;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by aurie on 13/04/2017.
 */

public class DoctorProfileMessage extends RealmObject{
    @PrimaryKey
    private String ID;
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

    public DoctorProfileMessage() {
    }

    public DoctorProfileMessage(int profileImage, String doctorName, String speciality) {
        ProfileImage = profileImage;
        DoctorName = doctorName;
        Speciality = speciality;
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
