package com.example.sreeraj.game1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView tv1, tv2, tv3,timer,status_text;
    ImageView iv;
    String[] array = {"Stone", "Paper", "Scissor"};
    TextView tv4;
    String st1 = "0", st2 = "0";
    String choice = "None", choice2 = "None", s;
    int sucess,count=0;
    Toast toast; CountDownTimer countDownTimer;
    int you = 0, computer = 0,trails=10;
    Intent intent;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(MainActivity.this, Main2Activity.class);
        //timer();

        tv2 = (TextView) (TextView) findViewById(R.id.textView8);
        tv1 = findViewById(R.id.textView1);
        timer = findViewById(R.id.textView2);
        //ImageView iv = (ImageView)findViewById(R.id.imageView) ;

        iv = (ImageView) findViewById(R.id.imageView2);
        //Drawable d = getResources().getDrawable(R.drawable.hand);
        iv.setImageResource(R.mipmap.background);
        //iv.setImageResource(R.drawable.hand);
        tv1.setText(st1);
        tv2.setText(st2);

        status_text = (TextView)findViewById(R.id.textView3);
        ImageButton bt1 = (ImageButton) findViewById(R.id.button1);


        bt1.setOnClickListener(this);
        ImageButton bt2 = (ImageButton) findViewById(R.id.button2);
        bt2.setOnClickListener(this);
        ImageButton bt3 = (ImageButton) findViewById(R.id.button3);
        bt3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        final int random = new Random().nextInt(3);
        String ran = String.valueOf(random);
        trails--;
        timer.setText("Trails left : " +String.valueOf(trails));
        choice2 = array[random];
        if (trails ==0){

            if (you==computer) s = "Match Draw";
            else if(you>computer) s= "You Won";
            else s="You Lose";
            intent.putExtra("string", s);
            startActivity(intent);

            finish();
        }
        switch (view.getId()) {

            case R.id.button1:
                choice = "Stone";
                if (choice2 == "Paper") {
                    iv.setImageResource(R.mipmap.hand2_toted);

                    sucess = 0;
                } else if (choice2 == "Scissor") {
                    iv.setImageResource(R.mipmap.hand3_rotated);

                    sucess = 1;
                } else {
                    sucess = -1;
                    iv.setImageResource(R.mipmap.hand_rotated);

                }
                break;

            case R.id.button2:
                choice = "Paper";
                if (choice2 == "Scissor") {
                    iv.setImageResource(R.mipmap.hand3_rotated);

                    sucess = 0;
                } else if (choice2 == "Stone") {
                    iv.setImageResource(R.mipmap.hand_rotated);

                    sucess = 1;
                } else {
                    sucess = -1;
                    iv.setImageResource(R.mipmap.hand2_toted);

                }
                break;

            case R.id.button3:
                choice = "Scissor";
                if (choice2 == "Stone") {
                    iv.setImageResource(R.mipmap.hand_rotated);

                    sucess = 0;
                } else if (choice2 == "Paper") {
                    iv.setImageResource(R.mipmap.hand2_toted);

                    sucess = 1;
                } else {
                    sucess = -1;
                    iv.setImageResource(R.mipmap.hand3_rotated);

                }
                break;
            default:
                break;
        }


        if (sucess == 1) {
            you++;
            st1 = String.valueOf(you);


             status_text.setText("You won");
            tv1.setText(st1);


        } else if (sucess == 0) {

            computer++;
            st2 = String.valueOf(computer);
            status_text.setText("You Lose");

            tv2.setText(st2);


        } else {

            status_text.setText("Match Draw");


        }



        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                iv.setImageResource(R.mipmap.background);
                //toast.cancel();
            }
        }, 1000);



    }

   /* private void timer(){

        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                timer.setText("Time left : "+ l/1000);
            }

            @Override
            public void onFinish() {
                timer.setText("Time up");
                intent.putExtra("string" ,"You loss" );


                startActivity(intent);
                finish();





            }
        };*/


   public  void onBackPressed(){
        finish();
        //countDownTimer.cancel();
    }


}


