package com.afnanulcoder.gold_diggers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Questions extends AppCompatActivity {

    TextView titleTV;

    LinearLayout testLayout;

    String[][] databaseTable = new String[50][3];

    String[] dataOfTable;

    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        titleTV = findViewById(R.id.headlineID);

        testLayout = findViewById(R.id.testLLid);

        title = getIntent().getStringExtra("title");
        titleTV.setText(title);

       /* dataOfTable = new String[]{
                "Branch Name", "ET", "text","Toilet And Hygiene",
                "Age", "ET", "number","Toilet And Hygiene",
                "Gender", "CB", "Male,Female,Others","Toilet And Hygiene",
        };*/

        databaseTable = new String[][]{
                {"ব্রাঞ্চ নাম", "ET", "text","Toilet And Hygiene"},
                {"বয়স", "ET", "number","Toilet And Hygiene"},
                {"লিঙ্গ", "CB", "ছেলে,মেয়ে,অন্যান্য","Toilet And Hygiene"},
                {"মাসিক আয়", "ET", "number","Toilet And Hygiene"},
                {"টয়লেট সংখ্যা", "ET", "number","Toilet And Hygiene"},
                {"যদি না হয় তবে কেন", "CB", "অর্থনৈতিক,অভ্যাস নেই,মেরামত লাগবে","Toilet And Hygiene"},
                {"হাত ধোয়ার উপকরন", "CB", "সাবান,ছাই,কাদা,কিছুই না","Toilet And Hygiene"},
                {"টয়লেটের আবস্থা", "CB", "ভালো,খারাপ,খুবই বাজে","Toilet And Hygiene"},
                {"টয়লেট সংখ্যা", "ET", "number","Toilet And Hygiene"},

                {"ব্রাঞ্চ নাম", "ET", "text","Livestock"},
                {"বয়স", "ET", "number","Livestock"},
                {"লিঙ্গ", "CB", "ছেলে,মেয়ে,অন্যান্য","Livestock"},
                {"গবাদি পশুর সংখ্যা", "ET", "number","Livestock"},
                {"গবাদি পশু", "ET", "number","Livestock"},
                {"পশু পালনের অভিজ্ঞতা আছে কিনা", "CB", "হ্যা, না","Livestock"},

        };

       // make2Dtable();

        makeQuestion();

    }



    void makeQuestion()
    {
        int i;
        String k;
        String[] options;

        for(i=0; i<databaseTable.length; i++)
        {
            if(databaseTable[i][3].equals(title))
            {
                if(databaseTable[i][1].equals("ET"))
                {
                    makeTextView(databaseTable[i][0]);

                    k = databaseTable[i][2].toLowerCase();

                    switch(k)
                    {
                        case "number":
                            makeEditText(InputType.TYPE_CLASS_NUMBER);
                            break;

                        case "text":
                            makeEditText(InputType.TYPE_CLASS_TEXT);
                            break;
                    }

                }
                else if (databaseTable[i][1].equals("CB"))
                {
                    makeTextView(databaseTable[i][0]);

                    options = databaseTable[i][2].split(",");

                    makeCheckBox(options);
                }
            }
        }

    }


    void make2Dtable()
    {
        int i, j, k=0;

        for (i = 0; i < dataOfTable.length/4; i++) {
            for (j = 0; j < 4; j++) {
                databaseTable[i][j] = dataOfTable[k];
                k++;
            }
        }
    }




    void makeTextView(String text)
    {
        TextView textView1 = new TextView(this);
        textView1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
          textView1.setText(text);
        testLayout.addView(textView1);

        textView1.setInputType(InputType.TYPE_CLASS_NUMBER);
    }



    void makeEditText(int a)
    {
        EditText editText1 = new EditText(this);
        editText1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
      //  editText1.setText("Text Here");
        testLayout.addView(editText1);

        //editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText1.setInputType(a);
       // View v = editText1.getRootView();


    }

    void makeCheckBox(String[] options)
    {

        CheckBox [] checkbox;

        checkbox=new CheckBox[options.length];

        for(int i=0;i<options.length;i++){
            CheckBox c=new CheckBox(this);

            c.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            c.setText(options[i]);

            testLayout.addView(c);

            checkbox[i]=c;
        }

    }



}
