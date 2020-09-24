package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int myActiveplayer = 0;
    int[] mygameState = {2,2,2,2,2,2,2,2,2};

    public void imageTapped(View view) {

        ImageView myTapped = (ImageView) view;
       // Log.i("Tag is","Image No is ="+myTapped.getTag().toString());
        int tappedImageTag = Integer.parseInt(myTapped.getTag().toString());
        if (mygameState[tappedImageTag] == 2)
        {
            mygameState[tappedImageTag] = myActiveplayer;
            if (myActiveplayer == 0) {
                myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(180).setDuration(1000);
                myActiveplayer = 1;
            } else {
                myTapped.setImageResource(R.drawable.circle);
                myActiveplayer = 0;
            }

        }else{
            //Log.i("msg","this palce is occupied");
            Toast.makeText(this,"Area occupied try another spot "+myActiveplayer,Toast.LENGTH_SHORT).show();

            mygameState[tappedImageTag] = myActiveplayer;
        }

    }

    public void playagain(View view){
        //Log.i("msg","play Again");
        for (int i = 0 ; i < mygameState.length;i++){
            mygameState[i] = 2;

        }
        myActiveplayer = 0;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.one);
        for (int i =0; i < linearLayout.getChildCount(); i++){
            ((ImageView) linearLayout.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

        LinearLayout linearLayoutOne = (LinearLayout) findViewById(R.id.two);
        for (int i =0; i < linearLayoutOne.getChildCount(); i++){
            ((ImageView) linearLayoutOne.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

        LinearLayout linearLayoutTwo = (LinearLayout) findViewById(R.id.three);
        for (int i =0; i < linearLayoutTwo.getChildCount(); i++){
            ((ImageView) linearLayoutTwo.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

    }





    @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        }
    }

