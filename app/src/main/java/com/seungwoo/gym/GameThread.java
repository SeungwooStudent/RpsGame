package com.seungwoo.gym;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class GameThread extends Handler {
    TextView countTextView;
    public GameThread(TextView countTextView) {
        this.countTextView = countTextView;
    }



    public void handleMessage(Message message) {
        Log.d("seungwoo" , "Hello");
        Bundle bundle = message.getData();
        countTextView.setText(bundle.getString("msg"));
    }
}
