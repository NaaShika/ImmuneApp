package com.tutorial.aurie.finalyearproject.API;

import android.content.Context;
import android.util.Log;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.tutorial.aurie.finalyearproject.Interfaces.InformationInterface;

import io.realm.Realm;

/**
 * Created by aurie on 21/04/2017.
 */

public class InformationDataProvider {
    private Context context;
    private Realm realm;

    public InformationDataProvider(Context context) {
        this.context = context;
        this.realm = Realm.getDefaultInstance();
    }

    public void getInformation(final InformationInterface informationInterface){

        Log.e("Information Result" , "result.toString()");
        Ion.with(context)
                .load("https://electpot-eebd9.firebaseio.com/Information Table.json")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        if (e == null && result!= null){
                            Log.e("Information Result" , result.toString());
                        }
                        else {
                            Log.e("Info" , result.toString(), e);

                        }
                    }
                });


    }
}
