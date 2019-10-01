package com.example.hancongnhu_day06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CreatNewNote extends AppCompatActivity {
    TextView tvdmy;
    TextView tvhms;
    Spinner tvspinner;
    TextView tvtags;
    TextView tvweeks;
    Button btTune;
    ArrayList<String> type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_new_note);
        tvdmy=findViewById(R.id.tvdmy);
        tvhms=findViewById(R.id.tvhms);
        tvspinner=findViewById(R.id.tvspinner);
        tvtags=findViewById(R.id.tvtags);
        tvweeks=findViewById(R.id.tvweeks);
        btTune=findViewById(R.id.btTune);
        Calendar calendar=Calendar.getInstance();
        // [HCN] calender ngay thang nam
        SimpleDateFormat dinhdangngay=new SimpleDateFormat("dd/mm/yyyy");
        tvdmy.append(dinhdangngay.format(calendar.getTime()));
        SimpleDateFormat dinhdanggio=new SimpleDateFormat("hh:mm:ss");
        tvhms.append(dinhdanggio.format(calendar.getTime()));
        // [HCN] bat su kien cho tvdmy
        tvdmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 chonngay();
            }
        });
        // [HCN] bat su kien cho tvhms
        tvhms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 chongio();
            }
        });

        // [HCN] khoi tao cho spinner
        type=new ArrayList<>();
        type.add("Work");
        type.add("Friend");
        type.add("Family");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getBaseContext(),android.R.layout.simple_list_item_1,type);
        tvspinner.setAdapter(arrayAdapter);
        // [HCN] khoi tao cho multi choose alert dialog tags
        tvtags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] group = {"Family", "Android", "VTC", "Game","Friend"};
                boolean[] isChecks = {true, false, true, false,true};

                AlertDialog alertDialog = new AlertDialog.Builder(CreatNewNote.this)
                        .setTitle("Choose Tags")
                        .setMultiChoiceItems(group, isChecks, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();

                alertDialog.show();
            }
        });

        // [HCN] khoi tao cho multi choose alert dialog weeks
        tvweeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] group1 = {"Monday", "Tuesday", "Wednesday", "Thursday","Friday","Saturday","Sunday"};
                boolean[] isChecks = {true, false, true, false,true,false,true};

                AlertDialog alertDialog = new AlertDialog.Builder(CreatNewNote.this)
                        .setTitle("Choose Tags")
                        .setMultiChoiceItems(group1, isChecks, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();

                alertDialog.show();
            }
        });
        // [HCN] popup menu button
        btTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowMenu();
            }
        });
    }
    public void ShowMenu(){

        PopupMenu popupMenu=new PopupMenu(this,btTune);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.menudefault)
                {

                    String[] tunes = {"Nexus Tune", "Winphone Tune", "Pep Tune","Nokia Tune","Etc"};
                    AlertDialog alertDialog = new AlertDialog.Builder(CreatNewNote.this)
                            .setTitle("Set RingTune")
//                        .setMessage("SetMessenger")
                            .setSingleChoiceItems(tunes, 1, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getBaseContext(), "OK", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .create();

                    alertDialog.show();
                }
                return false;
            }
        });
        popupMenu.show();

    }
    //[HCN]  khoi tao date picker dialog
    private void chonngay(){
        Calendar calendar=Calendar.getInstance();
        int ngay=calendar.get(Calendar.DATE);
        int thang=calendar.get(Calendar.MONTH);
        int nam=calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            }
        },nam,thang,ngay);
       datePickerDialog.show();

    }
    private void chongio(){
        Calendar calendar=Calendar.getInstance();
        int gio=calendar.get(Calendar.HOUR);
        int phut=calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {

            }
        },gio,phut,true);
      timePickerDialog.show();
    }

// [HCN] khoi tao menu option
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudemo,menu);
        return super.onCreateOptionsMenu(menu);
    }
// [HCN] bat su kien menu option
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menusave)
        {
            Toast.makeText(getBaseContext(),"Save",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.menucancel)
        {
            Intent intent=new Intent(getBaseContext(),MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
