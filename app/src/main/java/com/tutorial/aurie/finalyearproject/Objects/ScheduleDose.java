package com.tutorial.aurie.finalyearproject.Objects;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by aurie on 20/04/2017.
 */

public class ScheduleDose extends RealmObject {
   @PrimaryKey
   public String ID;
    public String VaccineName;
    public String Date;
    public String Dose;


    public ScheduleDose() {
    }

    public ScheduleDose(String ID, String vaccineName, String date, String dose) {
        this.ID = ID;
        VaccineName = vaccineName;
        Date = date;
        Dose = dose;
    }

    public void Save(ScheduleDose dose){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(dose);
        realm.commitTransaction();
    }

    public List<ScheduleDose> retrieveAll(){
        Realm realm = Realm.getDefaultInstance();
        return realm.where(ScheduleDose.class).findAll();
    }
}
