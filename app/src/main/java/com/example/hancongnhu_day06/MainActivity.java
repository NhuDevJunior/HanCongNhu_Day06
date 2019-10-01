package com.example.hancongnhu_day06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvname;
    TextView tvpass;
    Button btlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvname=findViewById(R.id.tvname);
        tvpass=findViewById(R.id.tvpass);
        btlogin=findViewById(R.id.btlogin);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=tvname.getText().toString();
                String password=tvpass.getText().toString();
                if(username.equals(""))
                {
                    Toast.makeText(MainActivity.this,"username bị bỏ trống",Toast.LENGTH_LONG).show();
                }
                else
                {
                    int dk1=password.length();
                    int dk2=checkdigit(password);
                    int dk3=checklower(password);
                    int dk4=checksign(password);
                    int dk5=checkupper(password);
                    int dk6=checkrong(password);
                    if(password.length()>=6&&checkdigit(password)==1&&checksign(password)==1&&
                            checklower(password)==1&&checkupper(password)==1&&checkrong(password)==1)
                    {

                        Intent intent=new Intent(MainActivity.this,CreatNewNote.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"password khong hop le",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    public int checkdigit(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='0'&&s.charAt(i)<='9')
                return 1;
        }
        return 0;
    }
    public  int checklower(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            if((s.charAt(i)>='a'&&s.charAt(i)<='z'))
                    return 1;
        }
        return 0;

    }
    public  int checkupper(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            if((s.charAt(i)>='A'&&s.charAt(i)<='Z'))
                return 1;
        }
        return 0;

    }
    public  int checksign(String s)
    {

        for(int i=0;i<s.length();i++)
        {
            if((s.charAt(i)>='!'&&s.charAt(i)<='/')||(s.charAt(i)>=':'&&s.charAt(i)<='@')||(s.charAt(i)>=']'&&s.charAt(i)<='_')||(s.charAt(i)>='{'&&s.charAt(i)<='~'))

                return 1;
        }
        return 0;
    }
    public  int checkrong(String s)
    {
        if(s.indexOf("\n")==-1)
        {
            return 1;
        }
    return 0;
    }

}
