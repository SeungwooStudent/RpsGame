package com.seungwoo.gym;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class GameThread extends Handler {
    TextView countTextView;
    Context context;

    public GameThread(TextView countTextView , Context context) {

        this.countTextView = countTextView;
        this.context = context;
    }



    public void handleMessage(Message message) {
        Log.d("seungwoo" , "Hello");
        Bundle bundle = message.getData();
        countTextView.setText(bundle.getString("msg"));
        boolean finishgame = bundle.getBoolean("isfinish", false);

//        boolean finishgame = gameManager.finishGame();


        if (finishgame) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);


            alertDialogBuilder.setTitle("게임이 종료되었습니다");


            alertDialogBuilder
                    .setMessage("다시 시작하시겠습니까? NO를 누르시면 랭킹이 등록됩니다")
                    .setCancelable(false)
                    .setPositiveButton("YES",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        DialogInterface dialog, int id) {
                                    // 프로그램을 종료한다
//                                                GameActivity.this.finish();
                                    dialog.cancel();
                                }
                            })
                    .setNegativeButton("NO",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        DialogInterface dialog, int id) {


                                    // 다이얼로그를 취소한다
                                    dialog.cancel();
                                }
                            });



            // 다이얼로그 생성
            AlertDialog alertDialog = alertDialogBuilder.create();

            // 다이얼로그 보여주기
            alertDialog.show();
        }
    }
}
