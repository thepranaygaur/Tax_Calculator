package com.example.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
 EditText in;
 EditText al;
 EditText age;
 public static String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

    }
    public void openActivity2(){
        in=findViewById(R.id.textbox1);
        al=findViewById(R.id.textbox2);
        age=findViewById(R.id.textbox3);
        long inc=Long.parseLong(in.getText().toString());
        long all=Long.parseLong(al.getText().toString());
        long a=Long.parseLong(age.getText().toString());
        Intent i=new Intent(this,Activity2.class);
        double tax=caltax(inc,all,a);
        String s2=String.valueOf(tax);
        i.putExtra(s1,s2);
        startActivity(i);
    }
    public double caltax(long income,long allowance,long age){
        double tax =0.0;
        int rate;
        long effective;
        effective=income-allowance;
        if(age<60){
            if(effective<=250000) {
                rate = 0;
                tax = 0;
            }
            else if (effective>250000&&effective<=500000) {
                rate = 5;
                effective-=250000;
                tax=(rate*effective)/100;
            }
            else if (effective>500000&&effective<=1000000) {
                rate = 20;
                effective-=500000;
                tax=(rate*effective)/100;
                tax+=12500;
            }
            else if (effective>1000000){
                rate = 30;
                effective-=1000000;
                tax=(rate*effective)/100;
                tax+=112500;
            }
        }
        else if(age>=60&&age<80){
            if(effective<=250000) {
                rate = 0;
                tax = 0;
            }
            else if (effective>250000&&effective<=500000) {
                rate = 5;
                effective-=250000;
                tax=(rate*effective)/100;
            }
            else if (effective>500000&&effective<=1000000) {
                rate = 20;
                effective-=500000;
                tax=(rate*effective)/100;
                tax+=10000;
            }
            else if (effective>1000000){
                rate = 30;
                effective-=1000000;
                tax=(rate*effective)/100;
                tax+=110000;
            }
        }
        else{
            if (effective<=500000) {
                rate = 0;
                tax=0;
            }
            else if (effective>500000&&effective<=1000000) {
                rate = 20;
                effective-=500000;
                tax=(rate*effective)/100;
            }
            else if (effective>1000000){
                rate = 30;
                effective-=1000000;
                tax=(rate*effective)/100;
                tax+=100000;
            }
        }
        return tax;
    }

}
