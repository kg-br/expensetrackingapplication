package com.example.sql;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DataBaseHelper myDb;


    EditText txtdate, txtdescript, txtMarks,edmonth;
    Button btnClick ,btn2,btndp;
    DatePicker datePicker;
    Spinner spinner;
    TextView textView,tv;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Intent myIntent = new Intent(MainActivity.this , MainActivity.class);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(MainActivity.this, 0, myIntent, 0);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.MINUTE, 50);
        calendar.set(Calendar.SECOND, 00);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 24*60*60*1000 , pendingIntent);



































//for tasks

        //Bundle bundle = getIntent().getExtras();
        //String message = bundle.getString("message");
        // FloatingActionButton fab = findViewById(R.id.fab);

        myDb = new DataBaseHelper(this);

        txtdate = (EditText) findViewById(R.id.iddate);
        txtdescript = (EditText) findViewById(R.id.iddescrip);
        txtMarks = (EditText) findViewById(R.id.idexpenses);
        btnClick = (Button) findViewById(R.id.idBtn);
        btn2=(Button)findViewById(R.id.button2);
        edmonth=(EditText)findViewById(R.id.idMonth);
        spinner=(Spinner)findViewById(R.id.spinner);
        textView=(TextView)findViewById(R.id.tv) ;
       // tv=(TextView)findViewById(R.id.marque);
        // tv.setText(message);
       // tv.setSelected(true);



       String [] categories={"Food","Travel","Clothes","Rent","Fuel","Lifestyle","Others"};

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,categories);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        txtdescript.setText("Food");
                        break;
                    case 1:
                        txtdescript.setText("Travel");
                        break;
                    case 2:
                        txtdescript.setText("Clothes");
                        break;
                    case 3:
                        txtdescript.setText("Rent");
                        break;
                    case 4:
                        txtdescript.setText("Fuel");
                        break;
                    case 5:
                        txtdescript.setText("Lifestyle");
                        break;
                    case 6:
                        txtdescript.setText("Others");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Calendar myCalendar = Calendar.getInstance();




        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                // edmonth.setText(monthOfYear);
                int abc=monthOfYear+1;
                txtdate.setText(dayOfMonth+"-"+abc+"-"+year);

                String xyz=Integer.toString(abc);
                edmonth.setText(xyz);
                //Toast.makeText(MainActivity.this, "moth is"+abc, Toast.LENGTH_SHORT).show();


            }

        };

        txtdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });





        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickMe();


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,alltransactions.class));

            }
        });




        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this,aboutus.class));
            //return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.adexp) {

        } else if (id == R.id.alltr) {
            startActivity(new Intent(MainActivity.this,alltransactions.class));

        }  else if (id == R.id.nav_tools) {
            startActivity(new Intent(MainActivity.this,Monthwise.class));

        } else if (id == R.id.nav_share) {
            startActivity(new Intent(MainActivity.this,testingoftabs.class));

        } else if (id == R.id.nav_send) {
            startActivity(new Intent(MainActivity.this,createpdf.class));
        }

        else if (id == R.id.nav_tasks) {
            startActivity(new Intent(MainActivity.this,tasks.class));
        }
        //else if (id == R.id.log) {
           // startActivity(new Intent(MainActivity.this,loginactivity2.class));
           // Toast.makeText(MainActivity.this,"User logged out Successfully",Toast.LENGTH_LONG).show();
       // }



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void ClickMe() {
        String name = txtdate.getText().toString();
        String surname = txtdescript.getText().toString();
        String marks = txtMarks.getText().toString();
        String month=edmonth.getText().toString();
        if (marks.isEmpty()){
            Toast.makeText(this,"Expenses field cannot be blank",Toast.LENGTH_LONG).show();
        }


        else {

            Boolean result = myDb.insertData(name, surname, marks, month);
            if (result == true) {
                Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                txtMarks.setText("");
                txtdescript.setText("");
                txtdate.setText("");


            } else {
                Toast.makeText(this, "Data Insertion Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        boolean isUserInteracting = true;
    }








}
