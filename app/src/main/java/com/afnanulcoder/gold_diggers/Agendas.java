package com.afnanulcoder.gold_diggers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Agendas extends AppCompatActivity {


        ListView listView;
        String[] agendas;
        TextView welcomeText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_agendas);

            agendas = new String[]{"Toilet And Hygiene", "Livestock"};

            listView = findViewById(R.id.listViewID);

       // welcomeText.setText(String.format("Welcome %s", getIntent().getStringExtra("UserName")));

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Agendas.this, R.layout.agenda_view_sample, R.id.listView1TV,agendas);
        listView.setAdapter(adapter1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(Agendas.this, Questions.class);
                intent.putExtra("title", agendas[position]);
                startActivity(intent);

            }
        });

    }
}
