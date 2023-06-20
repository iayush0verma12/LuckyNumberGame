package com.example.luckynumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    Button btn2;
    TextView tx2;
    TextView txt2;

//    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        btn2= findViewById(R.id.buttonfinal);
        txt2 = findViewById(R.id.textv);
        tx2 = findViewById(R.id.textview2);
        Intent i= getIntent();
        String userName=i.getStringExtra("name");
        Toast.makeText(this,"User name :"+userName,Toast.LENGTH_SHORT).show();
        int randomNum= RandomNumber();
        tx2.setText(""+randomNum);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName,randomNum);
            }
        });
    }

    public int RandomNumber()
    {
        Random random =  new Random();
        int upperLimit=1000;
        int randomNumberGenerated=random.nextInt(upperLimit);
        return randomNumberGenerated;
    }
    public void shareData(String userName,int randomNum)
    {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String number = String.valueOf(randomNum);
        i.putExtra(Intent.EXTRA_SUBJECT,userName + " got lucky today! ");
        i.putExtra(Intent.EXTRA_TEXT," His Lucky number is : "+number);
        startActivity(Intent.createChooser(i,"Choose a Platform"));
    }
}