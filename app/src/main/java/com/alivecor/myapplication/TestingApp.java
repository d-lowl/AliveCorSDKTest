package com.alivecor.myapplication;

import android.app.Application;

import com.alivecor.alivecorkitlite.AliveCorKitLite;

public class TestingApp extends Application {

    private static final String KARDIA_API_KEY = "EEf4/7iClNvFkO9GrLauVjXc5LM=";

    @Override
    public void onCreate() {
        super.onCreate();

        AliveCorKitLite.initialize(this, KARDIA_API_KEY, BuildConfig.DEBUG);
    }
}
