package com.example.sql;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class alltransactions extends AppCompatActivity {
    DataBaseHelper myDb;
    TextView txtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alltransactions);
        myDb = new DataBaseHelper(this);
        txtResult=(TextView)findViewById(R.id.idResult);

        Cursor res = myDb.getAllData();





        StringBuffer stringBuffer = new StringBuffer();
        if(res!=null && res.getCount()>0)
        {
            while (res.moveToNext())
            {
                int a=Integer.parseInt(res.getString(4));

            stringBuffer.append("Id: "+res.getString(0)+"\n");
                stringBuffer.append("Date: "+res.getString(1)+"\n");
                stringBuffer.append("Description: "+res.getString(2)+"\n");
                stringBuffer.append("Expense Value= "+res.getString(3)+"\n"+"\n");
                //stringBuffer.append("Month= "+res.getString(4)+"\n"+"\n");
            }

            txtResult.setText(stringBuffer.toString());

            Toast.makeText(this,"Data Retrieved Successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"No Data to Retrieve",Toast.LENGTH_SHORT).show();

        }
    }


}
