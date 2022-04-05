package com.seungwoo.gym.model;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferencesManager {
    String rankingName[];
    int rankingWin[];
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
        rankingWin = new int[3];
    }

    public void saveData(String name, int win) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("rankingname1", name);
        editor.putInt("rankingwin1",win);
        editor.putString("rankingname2", name);
        editor.putInt("rankingwin2",win);
        editor.putString("rankingname3", name);
        editor.putInt("rankingwin3",win);
        editor.commit();
    }

    public void readData() {
        rankingName[0] = sharedPref.getString("rankingname1", "empty");
        rankingWin[0] = sharedPref.getInt("rankingwin1", 0);
        rankingName[1] = sharedPref.getString("rankingname2", "empty");
        rankingWin[1] = sharedPref.getInt("rankingwin2", 0);
        rankingName[2] = sharedPref.getString("rankingname3", "empty");
        rankingWin[2] = sharedPref.getInt("rankingwin3", 0);
    }

    public String[] getRankingName() {
        return rankingName;
    }
    public int[] getRankingWin() { return rankingWin; }


}

