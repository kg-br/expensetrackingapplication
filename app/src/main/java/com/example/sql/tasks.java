package com.example.sql;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class tasks extends AppCompatActivity {
    EditText ed;
    String tasks,name;
    Button sve;
    SharedPreferences myPrefs;
    public static final String actnamefiletwo = "actnamebudtwo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        ed=(EditText)findViewById(R.id.editText5);
        sve=(Button)findViewById(R.id.save);






        sve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = myPrefs.edit();
                String data=ed.getText().toString();
                editor.putString("nameKey", data);
                editor.apply();
                editor.commit();
                Toast.makeText(tasks.this,"Saved",Toast.LENGTH_LONG).show();


            }
        });
        myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
        name = myPrefs.getString("nameKey","Default");
        ed.setText(name);


        Intent intent = new Intent(tasks.this, MainActivity.class);
        intent.putExtra("message", name);


        //final EditText eActNametwo = (EditText)findViewById(R.id.eACTNametwo);
       // final EditText eActBudtwo = (EditText)findViewById(R.id.eACTBudtwo);

       // bCreatetwo = (Button)findViewById(R.id.bCreateActivitytwo);
       // bCreatetwo.setOnClickListener(new View.OnClickListener() {

        //SharedPreferences settingstwo = getSharedPreferences(actnamefiletwo,0);
          //      SharedPreferences.Editor editortwo = settingstwo.edit();
          //      editortwo.putString("nametwo", ed.getText().toString());
                //editortwo.putString("budtwo", eActBudtwo.getText().toString());
            //    editortwo.commit();



       // entvActNametwo = (TextView) findViewById(R.id.tvActNametwo);
        //tvActBudtwo = (TextView) findViewById(R.id.tvActBudtwo);
        //SharedPreferences settingstwo = getSharedPreferences(actnamefiletwo, 0);
     //  ed.setText(settingstwo.getString("nametwo", ""));
        //tvActBudtwo.setText(settingstwo.getString("budtwo", ""));
        tsk();
    }
    public void tsk(){
        Intent intent = new Intent(tasks.this, MainActivity.class);
        intent.putExtra("message", name);

    }
}
