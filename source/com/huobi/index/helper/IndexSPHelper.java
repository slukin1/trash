package com.huobi.index.helper;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Keep;
import bh.j;
import com.huobi.account.event.LogOutEvent;
import k20.h;
import org.greenrobot.eventbus.ThreadMode;

public class IndexSPHelper {
    public static void a(String str) {
        e(str).edit().clear().apply();
    }

    public static int b(String str, String str2, int i11) {
        return e(str).getInt(str2, i11);
    }

    public static String c(String str, String str2, String str3) {
        return e(str).getString(str2, str3);
    }

    public static Context d() {
        return j.c().getApplicationContext();
    }

    public static SharedPreferences e(String str) {
        return d().getSharedPreferences(str, 0);
    }

    public static void f(String str, String str2, int i11) {
        SharedPreferences.Editor edit = e(str).edit();
        edit.putInt(str2, i11);
        edit.apply();
    }

    public static void g(String str, String str2, String str3) {
        SharedPreferences.Editor edit = e(str).edit();
        edit.putString(str2, str3);
        edit.apply();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onLogout(LogOutEvent logOutEvent) {
        a("index_rank_sp");
    }
}
