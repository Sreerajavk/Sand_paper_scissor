package com.example.sreeraj.game1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        i = getIntent();
        ImageView im = (ImageView)findViewById(R.id.imageView) ;
        ImageView im2 = (ImageView)findViewById(R.id.imageview3);
        String s = i.getStringExtra("string");
        im.setImageResource(R.mipmap.retry);


        TextView tv = (TextView) findViewById(R.id.textView);
        if (s.equals("You Won")){
            im2.setImageResource(R.mipmap.happy);
        }
        else{
            im2.setImageResource(R.mipmap.sad);

        }

        tv.setText(s);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Main2Activity.this , MainActivity.class);
                finish();
                startActivity(in);

                return;


            }
        });
    }

    public void onBackPressed(){
        finish();

    }
}
