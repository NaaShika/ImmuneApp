package com.tutorial.aurie.finalyearproject.Objects;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by aurie on 20/04/2017.
 */

public class ScheduleDoseObject {
   @PrimaryKey
   public String ID;
    public String VaccineName;
    public String Date;
    public String Dose;


    public ScheduleDoseObject() {
    }

    public ScheduleDoseObject(String ID, String vaccineName, String date, String dose) {
        this.ID = ID;
        VaccineName = vaccineName;
        Date = date;
        Dose = dose;
    }

}
