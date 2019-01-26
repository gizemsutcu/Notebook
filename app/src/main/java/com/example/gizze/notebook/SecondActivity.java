package com.example.gizze.notebook;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_NOTE="com.example.gizze.notebook";
    private EditText et1;
    private EditText et2;
    private Button b2;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        b2=(Button)findViewById(R.id.button);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String notbasligi = et1.getText().toString();
                String noticerigi = et2.getText().toString();
                VeriTabani vt = new VeriTabani(SecondActivity.this,null,null,1);
                vt.VeriEkle(notbasligi, noticerigi);
                startActivity(new Intent(SecondActivity.this,MainActivity.class));;
            }
        });
    }
}

