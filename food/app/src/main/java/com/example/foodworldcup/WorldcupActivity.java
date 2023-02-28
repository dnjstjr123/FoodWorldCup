package com.example.foodworldcup;

import android.content.Intent;
import android.content.res.TypedArray;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class WorldcupActivity extends AppCompatActivity {
    TextView text1;
    TextView text2;
    ImageView image1;
    ImageView image2;
    Random random = new Random();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.worldcup_layout);
        int [] imgs = {R.drawable.food1, R.drawable.food2,R.drawable.food3,R.drawable.food4,
                R.drawable.food5,R.drawable.food6,R.drawable.food7,R.drawable.food8,R.drawable.food9,
                R.drawable.food10,R.drawable.food11,R.drawable.food12,R.drawable.food13,R.drawable.food14,
                R.drawable.food15,R.drawable.food16,R.drawable.food17,R.drawable.food18,R.drawable.food19,
                R.drawable.food20,R.drawable.food21,R.drawable.food22,R.drawable.food23,R.drawable.food24};
        ArrayList<Integer> list_all = new ArrayList<Integer>();
        ArrayList<Integer> list_16 = new ArrayList<Integer>();
        for(int i = 0;i<24;i++){
            list_all.add(imgs[i]);
        }
        for(int i = 0; i<16;i++){
            int randomNum = random.nextInt(24);
            if(list_16.contains(list_all.get(randomNum))){
                i--;
                continue;
            }
            list_16.add(list_all.get(randomNum));
            System.out.println(list_16.get(i));
            };
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        final int[] select1 = {0}; // 이미지 1의 인덱스
        final int[] select2 = {1}; // 이미지 2의 인덱스
        image1.setImageResource(list_16.get(select1[0]));
        image2.setImageResource(list_16.get(select2[0]));
        ArrayList<Integer> list_8 = new ArrayList<Integer>();
        ArrayList<Integer> list_4 = new ArrayList<Integer>();
        ArrayList<Integer> list_final = new ArrayList<Integer>();
        final int[] round = {16}; // 몇 강인지 나타내는 변수

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (round[0] == 16) {
                    list_8.add(list_16.get(select1[0]));
                    if(select1[0]!=14) {
                        select1[0] += 2;
                        select2[0] += 2;
                        image1.setImageResource(list_16.get(select1[0]));
                        image2.setImageResource(list_16.get(select2[0]));
                    }
                    else{
                        select1[0] = 0;
                        select2[0] = 1;
                        text1.setText("8강");
                        round[0] = round[0] / 2;
                        image1.setImageResource(list_8.get(select1[0]));
                        image2.setImageResource(list_8.get(select2[0]));
                    }
                }
                else if(round[0] == 8){
                    list_4.add(list_8.get(select1[0]));
                    if(select1[0]!=6) {
                        select1[0] += 2;
                        select2[0] += 2;
                        image1.setImageResource(list_8.get(select1[0]));
                        image2.setImageResource(list_8.get(select2[0]));
                    }
                    else{
                        select1[0] = 0;
                        select2[0] = 1;
                        text1.setText("4강");
                        round[0] = round[0] / 2;
                        image1.setImageResource(list_4.get(select1[0]));
                        image2.setImageResource(list_4.get(select2[0]));
                    }
                }
                else if(round[0] ==4){
                    list_final.add(list_4.get(select1[0]));
                    if(select1[0]!=2) {
                        select1[0] += 2;
                        select2[0] += 2;
                        image1.setImageResource(list_4.get(select1[0]));
                        image2.setImageResource(list_4.get(select2[0]));
                    }
                    else{
                        select1[0] = 0;
                        select2[0] = 1;
                        text1.setText("결승");
                        round[0] = round[0] /2;
                        image1.setImageResource(list_final.get(select1[0]));
                        image2.setImageResource(list_final.get(select2[0]));
                    }
                }
                else if(round[0]==2){
                    text1.setText("오늘의 메뉴");
                    text2.setText("다시하기");
                    image1.setImageResource(list_final.get(select1[0]));
                    image2.setImageResource(R.drawable.reset);
                    round[0] = round[0] /2;
                }
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (round[0] == 16) {
                    list_8.add(list_16.get(select2[0]));
                    if(select1[0]!=14) {
                        select1[0] += 2;
                        select2[0] += 2;
                        image1.setImageResource(list_16.get(select1[0]));
                        image2.setImageResource(list_16.get(select2[0]));
                    }
                    else{
                        select1[0] = 0;
                        select2[0] = 1;
                        text1.setText("8강");
                        round[0] = round[0] / 2;
                        image1.setImageResource(list_8.get(select1[0]));
                        image2.setImageResource(list_8.get(select2[0]));
                    }
                }
                else if(round[0] == 8){
                    list_4.add(list_8.get(select2[0]));
                    if(select1[0]!=6) {
                        select1[0] += 2;
                        select2[0] += 2;
                        image1.setImageResource(list_8.get(select1[0]));
                        image2.setImageResource(list_8.get(select2[0]));
                    }
                    else{
                        select1[0] = 0;
                        select2[0] = 1;
                        text1.setText("4강");
                        round[0] = round[0] / 2;
                        image1.setImageResource(list_4.get(select1[0]));
                        image2.setImageResource(list_4.get(select2[0]));
                    }
                }
                else if(round[0] ==4){
                    list_final.add(list_4.get(select2[0]));
                    if(select1[0]!=2) {
                        select1[0] += 2;
                        select2[0] += 2;
                        image1.setImageResource(list_4.get(select1[0]));
                        image2.setImageResource(list_4.get(select2[0]));
                    }
                    else{
                        select1[0] = 0;
                        select2[0] = 1;
                        text1.setText("결승");
                        round[0] = round[0] /2;
                        image1.setImageResource(list_final.get(select1[0]));
                        image2.setImageResource(list_final.get(select2[0]));
                    }
                }
                else if(round[0]==2){
                    text1.setText("오늘의 메뉴");
                    text2.setText("다시하기");
                    image1.setImageResource(list_final.get(select2[0]));
                    image2.setImageResource(R.drawable.reset);
                    round[0] = round[0] /2;
                }
                else{
                    restart();
                }
            }
        });
    }
    public void restart(){
        Intent intent = getBaseContext().getPackageManager().
                getLaunchIntentForPackage(getBaseContext().getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        ActivityCompat.finishAffinity(this);
    }
}