package com.seungwoo.gym.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;


public class SharedPreferencesManager {
    ArrayList<Ranker> rankers;
    String rankingName[];
    int rankingWin[];
    private SharedPreferences sharedPref;

    private static SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager();

    public static SharedPreferencesManager getInstance() { //get같은거
        return sharedPreferencesManager;
    }

    SharedPreferencesManager() {
        rankers = new ArrayList<>();
    }
    public void init(Context context) {
        if (sharedPref == null) {
            sharedPref = context.getSharedPreferences("ranking", Context.MODE_PRIVATE);
        }
        rankingName = new String[3];
        rankingWin = new int[3];
    }

    public void saveData(String name, int win) {
        // win -> 6
        /*
        count : 6[0]
        count : 5 [1]
        count : 3 [2]
        count : 2 [3]
         */
        Log.d("seungwoo", "saveData wincount : " + win);
        for (int i = 0; i < 3; i++) {
            Ranker r = rankers.get(i);
            if (r.getWinCount() < win) {
                rankers.add(i, new Ranker(name, win));
                break;
            }
        }
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("rankingname1", rankers.get(0).getName());
        editor.putInt("rankingwin1",rankers.get(0).getWinCount());
        editor.putString("rankingname2", rankers.get(1).getName());
        editor.putInt("rankingwin2",rankers.get(1).getWinCount());
        editor.putString("rankingname3", rankers.get(2).getName());
        editor.putInt("rankingwin3",rankers.get(2).getWinCount());
        editor.commit();
    }

    public void readData() {

        rankingName[0] = sharedPref.getString("rankingname1", "empty");
        rankingWin[0] = sharedPref.getInt("rankingwin1", 0);
        rankingName[1] = sharedPref.getString("rankingname2", "empty");
        rankingWin[1] = sharedPref.getInt("rankingwin2", 0);
        rankingName[2] = sharedPref.getString("rankingname3", "empty");
        rankingWin[2] = sharedPref.getInt("rankingwin3", 0);

        for (int i = 0; i < 3; i++) {
            Ranker ranker = new Ranker(rankingName[i], rankingWin[i]);
            rankers.add(ranker);
        }

    }

    public String[] getRankingName() {
        return rankingName;
    }
    public int[] getRankingWin() { return rankingWin; }


}

