package com.project.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonSend;
    EditText userName, password;

    final String realsUserName = "Tom";
    final String realsPassword = "mot";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonSend = findViewById(R.id.button);
        userName = findViewById(R.id.userName);
        password  = findViewById(R.id.password);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (userName.getText().toString().equals("")|| password.getText().toString().equals("")){

                    Toast.makeText(MainActivity.this, "Los datos Estan incompletos", Toast.LENGTH_SHORT).show();
                }else if (userName.getText().toString().equals(realsUserName)|| password.getText().toString().equals(realsPassword)){

                    Intent intent = new Intent(MainActivity.this, addFriendActivity.class);
                    intent.putExtra("namePerson", userName.getText().toString());
                    intent.putExtra("passwordPerson", password.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }


}
