package com.seungwoo.gym.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.seungwoo.gym.model.GameManager;
import com.seungwoo.gym.model.GameThread;
import com.seungwoo.gym.R;

import java.util.Random;


public class GameActivity extends AppCompatActivity {
    Handler gameHandler;
    GameManager gameManager;
    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Button scissorsbtn = (Button) findViewById(R.id.scissors_btn);
        Button rockbtn = (Button) findViewById(R.id.rock_btn);
        Button papersbtn = (Button) findViewById(R.id.paper_btn);
        Button startbtn = (Button) findViewById(R.id.start_button);
        TextView countTextView = (TextView) findViewById(R.id.count_down);
        TextView winCountTextView = (TextView) findViewById(R.id.win_text);
        ImageView computerimageView = (ImageView) findViewById(R.id.computer_turn);
        ImageView myimageView = (ImageView) findViewById(R.id.my_turn);

        gameHandler = new GameThread(countTextView, this );
        gameManager = new GameManager();


        scissorsbtn.setVisibility(View.INVISIBLE);
        rockbtn.setVisibility(View.INVISIBLE);
        papersbtn.setVisibility(View.INVISIBLE);

        scissorsbtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                myimageView.setImageResource(R.drawable.b);
                gameManager.setUserChoice(1);
            }
        });

        rockbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myimageView.setImageResource(R.drawable.a);
                gameManager.setUserChoice(2);
            }

        });
        papersbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myimageView.setImageResource(R.drawable.c);
                gameManager.setUserChoice(3);
            }
        });
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scissorsbtn.setVisibility(View.VISIBLE);
                rockbtn.setVisibility(View.VISIBLE);
                papersbtn.setVisibility(View.VISIBLE);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {


                        String gameText[] = {"게임을 시작합니다", "가위", "바위", "보"};


                        for (int j = 0; j < 4; j++) {

                            try {
                                Message message = gameHandler.obtainMessage();
                                Bundle bundle = new Bundle();
                                bundle.putString("msg", gameText[j]);
                                message.setData(bundle);
                                gameHandler.sendMessage(message);
                                Thread.sleep(1200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }


                        scissorsbtn.setVisibility(View.INVISIBLE);
                        rockbtn.setVisibility(View.INVISIBLE);
                        papersbtn.setVisibility(View.INVISIBLE);


                        Random random = new Random();
                        int number = random.nextInt(3) + 1;
                        if (number == 1) {
                            computerimageView.setImageResource(R.drawable.b);
                        } else if (number == 2) {
                            computerimageView.setImageResource(R.drawable.a);
                        } else if (number == 3) {
                            computerimageView.setImageResource(R.drawable.c);
                        }
                        gameManager.setComputerChoice(number);


                        Message message = gameHandler.obtainMessage();
                        Bundle bundle = new Bundle();
                        bundle.putString("msg", gameManager.compare());
                        bundle.putBoolean("isfinish", !gameManager.finishGame());
                        bundle.putInt("wincount", gameManager.getWinCount());

                        message.setData(bundle);
                        gameHandler.sendMessage(message);


                    }

                });
                thread.start();
                winCountTextView.setText("Win : " + gameManager.getWinCount() + "연승");


            }
        });


    }
}
