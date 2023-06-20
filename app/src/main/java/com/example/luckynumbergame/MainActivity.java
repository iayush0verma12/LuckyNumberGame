package com.example.luckynumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ed;
    Button btn;
    TextView tex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed=findViewById(R.id.edittext);
        btn=findViewById(R.id.button);
        tex=findViewById(R.id.textview);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name= ed.getText().toString();
                Intent i = new Intent(getApplicationContext(),LuckyNumberActivity.class);
                i.putExtra("name",user_name);//passing data
                startActivity(i);

            }
        });

    }
}