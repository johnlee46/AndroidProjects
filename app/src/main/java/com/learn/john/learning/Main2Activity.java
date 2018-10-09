package com.learn.john.learning;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if(getIntent().hasExtra("LAMBOS")) {
            TextView tv = (TextView) findViewById(R.id.textView3);
            String text = getIntent().getExtras().getString("LAMBOS");
            tv.setText(text);
        }

        Button lambobutton = (Button)findViewById(R.id.lambutton);
        lambobutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String lambosite = "https://www.lamborghini.com/en-en";
                Uri webaddress = Uri.parse(lambosite);

                Intent gotoLambo = new Intent(Intent.ACTION_VIEW, webaddress);
                if(gotoLambo.resolveActivity(getPackageManager())!= null){
                    startActivity(gotoLambo);
                }
            }
        });
    }
}
