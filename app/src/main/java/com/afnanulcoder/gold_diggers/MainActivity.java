package com.afnanulcoder.gold_diggers;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout logIn;
    RelativeLayout buttonLayout;

    Button logInButton;
    EditText userNameET, passwordET;

    String uName, password;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            logIn.setVisibility(View.VISIBLE);
            buttonLayout.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logIn = findViewById(R.id.logIn);
        buttonLayout = findViewById(R.id.buttonLayout);

        logInButton = findViewById(R.id.logInButtonID);
        userNameET = findViewById(R.id.UNameID);
        passwordET = findViewById(R.id.PassID);


        handler.postDelayed(runnable, 2000);
    }

    public void LogInButton(View view)
    {
        uName = userNameET.getText().toString();
        password = passwordET.getText().toString();

        if(uName.equals("") || password.equals(""))
        {
            Toast.makeText(this, "Please Enter Data", Toast.LENGTH_LONG).show();
        }
        else
        {
            if(uName.equals("afnan") && password.equals("1234"))
            {
                Intent intent = new Intent(this, MenuActivity.class);
                intent.putExtra("UserName", uName);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "Please Enter Correct Data", Toast.LENGTH_LONG).show();
            }
        }

    }
}
