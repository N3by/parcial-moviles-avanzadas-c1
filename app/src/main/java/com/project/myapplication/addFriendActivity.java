package com.project.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addFriendActivity extends AppCompatActivity {

    EditText friendName, friendAge, friendCity;
    Button storeFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        Toast.makeText(this, "Se cambio de pantalla exitosamente", Toast.LENGTH_SHORT).show();

        //conecto lo visual con la logica

        //EditText
        friendName = findViewById(R.id.friendName);
        friendAge = findViewById(R.id.friendAge);
        friendCity = findViewById(R.id.friendCity);

        //botones
        storeFriend = findViewById(R.id.storeFriend);
        //
        //onclicklistener
        storeFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dbhelper dbhelper = new Dbhelper(addFriendActivity.this);
                dbhelper.addFriend(
                        friendName.getText().toString().trim(),
                        friendAge.getText().toString().trim(),
                        friendCity.getText().toString().trim()
                );
            }
        });
        //1

    }


}