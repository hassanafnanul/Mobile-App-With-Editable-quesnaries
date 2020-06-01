package com.afnanulcoder.gold_diggers;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MenuActivity extends AppCompatActivity {

    TextView welcomeText;

    //CardView projectCV, profileCV, participantsCV, polistCV;


    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

      //  w

    }

    public void projectCard(View view)
    {
        Intent intent = new Intent(this, Agendas.class);
      //  intent.putExtra("UserName", getIntent().getStringExtra("UserName"));
        startActivity(intent);
    }

    public void profileCard(View view) {
    }

    public void polistCard(View view) {
    }

    public void participantsCard(View view) {
    }

    public void Call_Emergency(View view)
    {
        String dial = "tel:01922545009";
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
    }

}
