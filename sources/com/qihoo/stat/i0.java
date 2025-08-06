package com.qihoo.stat;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import java.util.Vector;

public class i0 {
    public static void a(Context context, Vector vector) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("qihoo_game_online_conf", 0);
        if (vector != null) {
            for (int i11 = 0; i11 < vector.size(); i11++) {
                sharedPreferences.edit().putString((String) ((Pair) vector.get(i11)).first, (String) ((Pair) vector.get(i11)).second).commit();
            }
        }
    }
}
