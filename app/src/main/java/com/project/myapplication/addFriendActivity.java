package com.project.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class addFriendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        Dbhelper dbhelper = new Dbhelper(addFriendActivity.this);


    }
}