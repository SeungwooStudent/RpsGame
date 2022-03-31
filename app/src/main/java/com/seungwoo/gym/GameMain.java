package com.seungwoo.gym;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class GameMain extends AppCompatActivity {
    SharedPreferencesManager sharedPreferencesManager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_main);
        Button startbutton = findViewById(R.id.game_start_button);
        sharedPreferencesManager = SharedPreferencesManager.getInstance();
        sharedPreferencesManager.init(this);

        sharedPreferencesManager.readData();
        String rankingname[] = sharedPreferencesManager.getRankingName();
        String rankingwin[] = sharedPreferencesManager.getRankingWin();

//        TextView[] rankingNameTextView = new TextView[3];
//        int rankingTextNumber[] = {R.id.tv_First_name,R.id.tv_second_name,R.id.tv_third_name};
//
//        for (int i = 0; i < rankingTextView.length; i++) {
//            rankingTextView[i] = (TextView) findViewById(rankingTextNumber[i]);
//        }


        TextView firstNameTextView = (TextView) findViewById(R.id.tv_First_name);
        TextView secondNameTextView = (TextView) findViewById(R.id.tv_second_name);
        TextView thirdNameTextView = (TextView) findViewById(R.id.tv_third_name);
        TextView firstWinTextView = (TextView) findViewById(R.id.tv_First_win);
        TextView secondWinTextView = (TextView) findViewById(R.id.tv_second_win);
        TextView thirdWinTextView = (TextView) findViewById(R.id.tv_third_win);
        firstNameTextView.setText(rankingname[0]);
        secondNameTextView.setText(rankingname[1]);
        thirdNameTextView.setText(rankingname[2]);
        firstWinTextView.setText(rankingwin[0]);
        secondWinTextView.setText(rankingwin[1]);
        thirdWinTextView.setText(rankingwin[2]);

        startbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameMain.this, GameActivity.class);

                startActivity(intent);
                finish();
            }


        });






    }

}

