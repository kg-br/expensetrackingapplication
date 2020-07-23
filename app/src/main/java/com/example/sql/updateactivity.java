package com.example.sql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateactivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    Button b;
    DataBaseHelper myDb;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateactivity);
       ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        ed4=(EditText)findViewById(R.id.editText4);
        b=(Button)findViewById(R.id.button);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();

            }
        });


    }



   private void ClickMeforupdate() {
        String id = ed1.getText().toString();
        String date = ed2.getText().toString();
        String description = ed3.getText().toString();
        int marks=Integer.parseInt(ed4.getText().toString());
        boolean result = myDb.updateData(id,date,description,marks);
       Toast.makeText(updateactivity.this,"abc"+result,Toast.LENGTH_LONG).show();
       /*if(result==true){
           Toast.makeText(this,"Data Updated Successfully",Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(this,"No Rows Affected",Toast.LENGTH_SHORT).show();
       }*/

   }

   public void updateData(){
        boolean isUpdate=myDb.updateData(ed1.getText().toString(),ed2.getText().toString(),ed3.getText().toString(),Integer.parseInt(ed4.getText().toString()));
        if(isUpdate == true){
            Toast.makeText(this,"updated successfully",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Not updated successfully",Toast.LENGTH_LONG).show();
        }
   }

}

