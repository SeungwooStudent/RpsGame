package com.seungwoo.gym;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {
    String rankingName[];
    String rankingWin[];
    SharedPreferences sharedPref;

    SharedPreferencesManager(Context context) {
        sharedPref = context.getSharedPreferences("ranking",Context.MODE_PRIVATE);
        rankingName = new String[3];
        rankingWin = new String[3];
    }

//    SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString("ranking1", "오이");
//        editor.putString("ranking2", "감자");
//        editor.putString("ranking3", "호박");
//        editor.putString("rankingwin1", "10");
//        editor.putString("rankingwin2", "8");
//        editor.putString("rankingwin3", "7");
//        editor.commit();
//
//    String ranking1 = sharedPref.getString("ranking1", "empty");
//        firstNameTextView.setText(""+ranking1);
//
//    String ranking2 = sharedPref.getString("ranking2", "empty");
//        secondNameTextView.setText(""+ranking2);
//
//    String ranking3 = sharedPref.getString("ranking3", "empty");
//        thirdNameTextView.setText(""+ranking3);
//
//    String rankingwin1 = sharedPref.getString("rankingwin1", "empty");
//        firstWinTextView.setText(""+rankingwin1);
//
//    String rankingwin2 = sharedPref.getString("rankingwin2", "empty");
//        secondWinTextView.setText(""+rankingwin2);
//
//    String rankingwin3 = sharedPref.getString("rankingwin3", "empty");
//        thirdWinTextView.setText(""+rankingwin3);

}

