package com.example.sql;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Environment;
import android.os.FileObserver;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class createpdf extends AppCompatActivity {
    Button cpdf;
    TextView tvv;
    DataBaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createpdf);
        cpdf = (Button) findViewById(R.id.button3);
        tvv = (TextView) findViewById(R.id.textView2);

        ActivityCompat.requestPermissions(createpdf.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},PackageManager.PERMISSION_GRANTED);


        myDb = new DataBaseHelper(this);
        Cursor res = myDb.getAllDataforpdf();
        StringBuffer stringBuffer = new StringBuffer();
        if (res != null && res.getCount() > 0) {
            while (res.moveToNext()) {
                //stringBuffer.append("Id: " + res.getString(0) + "\n");
                stringBuffer.append("Date: " + res.getString(1) + "\n");
                stringBuffer.append("Description: " + res.getString(2) + "\n");
                stringBuffer.append("Expense Value= " + res.getString(3) + "\n" + "\n");
                //stringBuffer.append("Month= "+res.getString(4)+"\n"+"\n"+"\n");
            }

            tvv.setText(stringBuffer.toString());

        }

        cpdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PdfDocument mypdfdocument=new PdfDocument();
                PdfDocument.PageInfo mypageinfo=new PdfDocument.PageInfo.Builder(300,2000,25).create();
                PdfDocument.Page mypage=mypdfdocument.startPage(mypageinfo);

                Paint mypaint=new Paint();
                String mystring=tvv.getText().toString();
                int x=10,y=25;

                for(String line:mystring.split("\n")){
                    mypage.getCanvas().drawText(line,x,y,mypaint);
                    y+=mypaint.descent()-mypaint.ascent();
                }


                mypdfdocument.finishPage(mypage);


                String myfilepath= Environment.getExternalStorageDirectory().getPath()+"/mypdffile.pdf";

                File myfile=new File(myfilepath);


                try {
                    mypdfdocument.writeTo(new FileOutputStream(myfile));

                    Toast.makeText(createpdf.this, "PDF created in Internal Storage", Toast.LENGTH_LONG).show();


                } catch (Exception e) {
                    e.printStackTrace();
                    tvv.setText("error");


                }
                mypdfdocument.close();



            }

        });
    }

}
