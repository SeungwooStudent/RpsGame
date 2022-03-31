package com.seungwoo.gym;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferencesManager {
    String rankingName[];
    String rankingWin[];
    private SharedPreferences sharedPref;

    private static SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager();

    public static SharedPreferencesManager getInstance() { //get같은거
        return sharedPreferencesManager;
    }

    SharedPreferencesManager() {

    }
    public void init(Context context) {
        if (sharedPref == null) {
            sharedPref = context.getSharedPreferences("ranking", Context.MODE_PRIVATE);
        }
        rankingName = new String[3];
        rankingWin = new String[3];
    }

    public void saveData(String name, String win) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("rankingname1", name);
        editor.putString("rankingwin1", win);
        editor.putString("rankingname2", name);
        editor.putString("rankingwin2", win);
        editor.putString("rankingname3", name);
        editor.putString("rankingwin3", win);
        editor.commit();
    }

    public void readData() {
        rankingName[0] = sharedPref.getString("rankingname1", "empty");
        rankingWin[0] = sharedPref.getString("rankingwin1", "empty");
        rankingName[1] = sharedPref.getString("rankingname2", "empty");
        rankingWin[1] = sharedPref.getString("rankingwin2", "empty");
        rankingName[2] = sharedPref.getString("rankingname3", "empty");
        rankingWin[2] = sharedPref.getString("rankingwin3", "empty");
    }

    public String[] getRankingName() {
        return rankingName;
    }
    public String[] getRankingWin() {
        return rankingWin;
    }


}

