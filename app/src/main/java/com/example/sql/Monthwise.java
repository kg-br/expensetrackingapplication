package com.example.sql;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Monthwise extends AppCompatActivity {
    DataBaseHelper myDb;
    TextView tsep,monthtitle;
    Button bjan,bfeb,bmar,bapr,bmay,bJune,bjul,baug,bsep,boct,bnov,bdec;
    Spinner spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthwise);
        myDb = new DataBaseHelper(this);
        tsep=(TextView)findViewById(R.id.idmonthwisesep);
        monthtitle=(TextView)findViewById(R.id.monthtitle) ;
        spinner=(Spinner)findViewById(R.id.spinner);



        String [] categories={"January","February","March","April","May","June","July","August","September","October","November","December"};

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,categories);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        forjan();
                        break;
                    case 1:
                        forfeb();

                        break;
                    case 2:
                        formar();
                        //txtdescript.setText("Clothes");
                        break;
                    case 3:
                        forapr();
                        //txtdescript.setText("Rent");
                        break;
                    case 4:
                        formay();
                       // txtdescript.setText("Fuel");
                        break;
                    case 5:
                        forjun();
                      //  txtdescript.setText("Lifestyle");
                        break;
                    case 6:
                        forjul();
                      //  txtdescript.setText("Others");
                        break;
                    case 7:
                        foraug();
                        // txtdescript.setText("Fuel");
                        break;
                    case 8:
                        forsep();
                        //  txtdescript.setText("Lifestyle");
                        break;
                    case 9:
                        foroct();
                        //  txtdescript.setText("Others");
                        break;
                    case 10:
                        fornov();
                        // txtdescript.setText("Fuel");
                        break;
                    case 11:
                        fordec();
                        //  txtdescript.setText("Lifestyle");
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






    }

    public void forfeb(){
        Cursor res = myDb.fetchmonthwise();
        StringBuffer stringBuffer = new StringBuffer();
        tsep.setText("No data to retrieve for the month.");
        monthtitle.setText("February");
        if(res!=null && res.getCount()>0)
        {
            while (res.moveToNext())
            {
                int sorting=Integer.parseInt(res.getString(4));

                if(sorting==2) {
                    // stringBuffer.append("Id: " + res.getString(0) + "\n");
                    stringBuffer.append("Date: " + res.getString(1) + "\n");
                    stringBuffer.append("Description: " + res.getString(2) + "\n");
                    stringBuffer.append("Expense Value= " + res.getString(3) + "\n" + "\n");

                    monthtitle.setText("February");
                    tsep.setText(stringBuffer.toString());

                    //stringBuffer.append("Month= "+res.getString(4)+"\n"+"\n"+"\n");

                }

            }

            // Toast.makeText(this,"Data Retrieved Successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Toast.makeText(this,"No Data to Retrieve",Toast.LENGTH_SHORT).show();

        }

    }

    public void formar(){
        Cursor res = myDb.fetchmonthwise();
        StringBuffer stringBuffer = new StringBuffer();
        tsep.setText("No data to retrieve for the month.");
        monthtitle.setText("March");
        if(res!=null && res.getCount()>0)
        {
            while (res.moveToNext())
            {
                int sorting=Integer.parseInt(res.getString(4));
                monthtitle.setText("March");


                if(sorting==3) {
                    // stringBuffer.append("Id: " + res.getString(0) + "\n");
                    stringBuffer.append("Date: " + res.getString(1) + "\n");
                    stringBuffer.append("Description: " + res.getString(2) + "\n");
                    stringBuffer.append("Expense Value= " + res.getString(3) + "\n" + "\n");
                    monthtitle.setText("March");
                    tsep.setText(stringBuffer.toString());

                    //stringBuffer.append("Month= "+res.getString(4)+"\n"+"\n"+"\n");

                }

            }

            // Toast.makeText(this,"Data Retrieved Successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Toast.makeText(this,"No Data to Retrieve",Toast.LENGTH_SHORT).show();

        }

    }

    public void forapr(){
        Cursor res = myDb.fetchmonthwise();
        StringBuffer stringBuffer = new StringBuffer();
        tsep.setText("No data to retrieve for the month.");
        monthtitle.setText("April");
        if(res!=null && res.getCount()>0)
        {
            while (res.moveToNext())
            {
                int sorting=Integer.parseInt(res.getString(4));

                if(sorting==4) {
                    // stringBuffer.append("Id: " + res.getString(0) + "\n");
                    stringBuffer.append("Date: " + res.getString(1) + "\n");
                    stringBuffer.append("Description: " + res.getString(2) + "\n");
                    stringBuffer.append("Expense Value= " + res.getString(3) + "\n" + "\n");
                    monthtitle.setText("April");
                    tsep.setText(stringBuffer.toString());

                    //stringBuffer.append("Month= "+res.getString(4)+"\n"+"\n"+"\n");

                }

            }

            // Toast.makeText(this,"Data Retrieved Successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Toast.makeText(this,"No Data to Retrieve",Toast.LENGTH_SHORT).show();

        }

    }

    public void formay(){
        Cursor res = myDb.fetchmonthwise();
        StringBuffer stringBuffer = new StringBuffer();
        tsep.setText("No data to retrieve for the month.");
        monthtitle.setText("May");
        if(res!=null && res.getCount()>0)
        {
            while (res.moveToNext())
            {
                int sorting=Integer.parseInt(res.getString(4));

                if(sorting==5) {
                    // stringBuffer.append("Id: " + res.getString(0) + "\n");
                    stringBuffer.append("Date: " + res.getString(1) + "\n");
                    stringBuffer.append("Description: " + res.getString(2) + "\n");
                    stringBuffer.append("Expense Value= " + res.getString(3) + "\n" + "\n");
                    monthtitle.setText("May");
                    tsep.setText(stringBuffer.toString());

                    //stringBuffer.append("Month= "+res.getString(4)+"\n"+"\n"+"\n");

                }

            }

            // Toast.makeText(this,"Data Retrieved Successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Toast.makeText(this,"No Data to Retrieve",Toast.LENGTH_SHORT).show();

        }

    }

    public void forjun(){
        Cursor res = myDb.fetchmonthwise();
        StringBuffer stringBuffer = new StringBuffer();
        tsep.setText("No data to retrieve for the month.");
        monthtitle.setText("June");
        if(res!=null && res.getCount()>0)
        {
            while (res.moveToNext())
            {
                int sorting=Integer.parseInt(res.getString(4));

                if(sorting==6) {
                    // stringBuffer.append("Id: " + res.getString(0) + "\n");
                    stringBuffer.append("Date: " + res.getString(1) + "\n");
                    stringBuffer.append("Description: " + res.getString(2) + "\n");
                    stringBuffer.append("Expense Value= " + res.getString(3) + "\n" + "\n");
                    monthtitle.setText("June");
                    tsep.setText(stringBuffer.toString());

                    //stringBuffer.append("Month= "+res.getString(4)+"\n"+"\n"+"\n");

                }

            }

            // Toast.makeText(this,"Data Retrieved Successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Toast.makeText(this,"No Data to Retrieve",Toast.LENGTH_SHORT).show();

        }

    }

    public void forjul(){
        Cursor res = myDb.fetchmonthwise();
        StringBuffer stringBuffer = new StringBuffer();
        tsep.setText("No data to retrieve for the month.");
        monthtitle.setText("July");
        if(res!=null && res.getCount()>0)
        {
            while (res.moveToNext())
            {
                int sorting=Integer.parseInt(res.getString(4));

                if(sorting==7) {
                    // stringBuffer.append("Id: " + res.getString(0) + "\n");
                    stringBuffer.append("Date: " + res.getString(1) + "\n");
                    stringBuffer.append("Description: " + res.getString(2) + "\n");
                    stringBuffer.append("Expense Value= " + res.getString(3) + "\n" + "\n");
                    monthtitle.setText("July");
                    tsep.setText(stringBuffer.toString());

                    //stringBuffer.append("Month= "+res.getString(4)+"\n"+"\n"+"\n");

                }

            }

            // Toast.makeText(this,"Data Retrieved Successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Toast.makeText(this,"No Data to Retrieve",Toast.LENGTH_SHORT).show();

        }

    }

    public void foraug(){
        Cursor res = myDb.fetchmonthwise();
        StringBuffer stringBuffer = new StringBuffer();
        tsep.setText("No data to retrieve for the month.");
        monthtitle.setText("August");
        if(res!=null && res.getCount()>0)
        {
            while (res.moveToNext())
            {
                int sorting=Integer.parseInt(res.getString(4));

                if(sorting==8) {
                    // stringBuffer.append("Id: " + res.getString(0) + "\n");
                    stringBuffer.append("Date: " + res.getString(1) + "\n");
                    stringBuffer.append("Description: " + res.getString(2) + "\n");
                    stringBuffer.append("Expense Value= " + res.getString(3) + "\n" + "\n");
                    monthtitle.setText("August");
                    tsep.setText(stringBuffer.toString());

                    //stringBuffer.append("Month= "+res.getString(4)+"\n"+"\n"+"\n");

                }


            }

            // Toast.makeText(this,"Data Retrieved Successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {

            // Toast.makeText(this,"No Data to Retrieve",Toast.LENGTH_SHORT).show();

        }

    }
    public void forsep(){
        Cursor res = myDb.fetchmonthwise();
        StringBuffer stringBuffer = new StringBuffer();
        tsep.setText("No data to retrieve for the month.");
        monthtitle.setText("September");
        if(res!=null && res.getCount()>0)
        {
            while (res.moveToNext())
            {
                int sorting=Integer.parseInt(res.getString(4));

                if(sorting==9) {
                    // stringBuffer.append("Id: " + res.getString(0) + "\n");
                    stringBuffer.append("Date: " + res.getString(1) + "\n");
                    stringBuffer.append("Description: " + res.getString(2) + "\n");
                    stringBuffer.append("Expense Value= " + res.getString(3) + "\n" + "\n");
                    monthtitle.setText("September");
                    tsep.setText(stringBuffer.toString());

                    //stringBuffer.append("Month= "+res.getString(4)+"\n"+"\n"+"\n");

                }

            }

            // Toast.makeText(this,"Data Retrieved Successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Toast.makeText(this,"No Data to Retrieve",Toast.LENGTH_SHORT).show();

        }

    }

    public void foroct(){
        Cursor res = myDb.fetchmonthwise();
        StringBuffer stringBuffer = new StringBuffer();
        tsep.setText("No data to retrieve for the month.");
        monthtitle.setText("October");
        if(res!=null && res.getCount()>0)
        {
            while (res.moveToNext())
            {
                int sorting=Integer.parseInt(res.getString(4));

                if(sorting==10) {
                    // stringBuffer.append("Id: " + res.getString(0) + "\n");
                    stringBuffer.append("Date: " + res.getString(1) + "\n");
                    stringBuffer.append("Description: " + res.getString(2) + "\n");
                    stringBuffer.append("Expense Value= " + res.getString(3) + "\n" + "\n");
                    monthtitle.setText("October");
                    tsep.setText(stringBuffer.toString());

                    //stringBuffer.append("Month= "+res.getString(4)+"\n"+"\n"+"\n");

                }

            }

            // Toast.makeText(this,"Data Retrieved Successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Toast.makeText(this,"No Data to Retrieve",Toast.LENGTH_SHORT).show();

        }

    }

    public void fornov(){
        Cursor res = myDb.fetchmonthwise();
        StringBuffer stringBuffer = new StringBuffer();
        tsep.setText("No data to retrieve for the month.");
        monthtitle.setText("November");
        if(res!=null && res.getCount()>0)
        {
            while (res.moveToNext())
            {
                int sorting=Integer.parseInt(res.getString(4));

                if(sorting==11) {
                    // stringBuffer.append("Id: " + res.getString(0) + "\n");
                    stringBuffer.append("Date: " + res.getString(1) + "\n");
                    stringBuffer.append("Description: " + res.getString(2) + "\n");
                    stringBuffer.append("Expense Value= " + res.getString(3) + "\n" + "\n");
                    monthtitle.setText("November");
                    tsep.setText(stringBuffer.toString());

                    //stringBuffer.append("Month= "+res.getString(4)+"\n"+"\n"+"\n");

                }

            }

            // Toast.makeText(this,"Data Retrieved Successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Toast.makeText(this,"No Data to Retrieve",Toast.LENGTH_SHORT).show();

        }

    }

    public void fordec(){
        Cursor res = myDb.fetchmonthwise();
        StringBuffer stringBuffer = new StringBuffer();
        tsep.setText("No data to retrieve for the month.");
        monthtitle.setText("December");
        if(res!=null && res.getCount()>0)
        {
            while (res.moveToNext())
            {
                int sorting=Integer.parseInt(res.getString(4));

                if(sorting==12) {
                    // stringBuffer.append("Id: " + res.getString(0) + "\n");
                    stringBuffer.append("Date: " + res.getString(1) + "\n");
                    stringBuffer.append("Description: " + res.getString(2) + "\n");
                    stringBuffer.append("Expense Value= " + res.getString(3) + "\n" + "\n");
                    monthtitle.setText("December");
                    tsep.setText(stringBuffer.toString());

                    //stringBuffer.append("Month= "+res.getString(4)+"\n"+"\n"+"\n");

                }

            }

            // Toast.makeText(this,"Data Retrieved Successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Toast.makeText(this,"No Data to Retrieve",Toast.LENGTH_SHORT).show();

        }

    }

    public void forjan(){
        Cursor res = myDb.fetchmonthwise();
        StringBuffer stringBuffer = new StringBuffer();
        tsep.setText("No data to retrieve for the month.");
        monthtitle.setText("January");
        if(res!=null && res.getCount()>0)
        {
            while (res.moveToNext())
            {
                int sorting=Integer.parseInt(res.getString(4));

                if(sorting==1) {
                    // stringBuffer.append("Id: " + res.getString(0) + "\n");
                    stringBuffer.append("Date: " + res.getString(1) + "\n");
                    stringBuffer.append("Description: " + res.getString(2) + "\n");
                    stringBuffer.append("Expense Value= " + res.getString(3) + "\n" + "\n");
                    monthtitle.setText("January");
                    tsep.setText(stringBuffer.toString());

                    //stringBuffer.append("Month= "+res.getString(4)+"\n"+"\n"+"\n");

                }

            }

            // Toast.makeText(this,"Data Retrieved Successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Toast.makeText(this,"No Data to Retrieve",Toast.LENGTH_SHORT).show();

        }

    }

}
