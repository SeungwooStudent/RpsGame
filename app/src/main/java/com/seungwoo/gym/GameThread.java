package com.seungwoo.gym;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class GameThread extends Handler {
    TextView countTextView;
    Context context;
    EditText editText;


    public GameThread(TextView countTextView, Context context) {

        this.countTextView = countTextView;
        this.context = context;

    }


    public void handleMessage(Message message) {
        Log.d("seungwoo", "Hello");
        Bundle bundle = message.getData();
        countTextView.setText(bundle.getString("msg"));
        boolean finishgame = bundle.getBoolean("isfinish", false);
        String wincount = bundle.getString("wincount", "empty");
        editText = new EditText(context);

//        boolean finishgame = gameManager.finishGame();


        if (finishgame) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);


            alertDialogBuilder.setTitle("게임이 종료되었습니다");


            alertDialogBuilder
                    .setMessage("다시 시작하시겠습니까?")
                    .setMessage("NO를 누르시면 랭킹이 등록됩니다")
                    .setCancelable(false)
                    .setPositiveButton("YES",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        DialogInterface dialog, int id) {
                                    // 프로그램을 종료한다
//                                  GameActivity.this.finish();
                                    dialog.cancel();
                                }
                            })
                    .setNegativeButton("NO",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        DialogInterface dialog, int id) {
                                    alertDialogBuilder.setTitle("랭킹에 등록할 닉네임을 입력하세요");
                                    alertDialogBuilder.setMessage("");
                                    alertDialogBuilder.setView(editText);
                                    alertDialogBuilder.setPositiveButton("확인",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    String strText = editText.getText().toString();
                                                    SharedPreferencesManager sf = SharedPreferencesManager.getInstance();
                                                    sf.saveData(strText, wincount);
                                                    Intent intent = new Intent(context, GameMain.class);
                                                    context.startActivity(intent);
                                                    ((Activity)context).finish();
                                                }
                                            });
                                    alertDialogBuilder.setNegativeButton("취소",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    dialog.cancel();

                                                }
                                            });
                                    alertDialogBuilder.show();

                                    // 다이얼로그를 취소한다
//                                    dialog.cancel();
                                }
                            });


            // 다이얼로그 생성
            AlertDialog alertDialog = alertDialogBuilder.create();

            // 다이얼로그 보여주기
            alertDialog.show();
        }
    }
}
