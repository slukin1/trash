package com.huobi.woodpecker.core;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.huobi.woodpecker.WoodPeckerSDK;
import fv.g;
import wu.c;

public class WoodPeckerOwnerInitializer extends ContentProvider {

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            c.e().d();
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        Log.d("WPInitializer", "HBWP::: WoodPeckerOwnerInitializer - ContentProvider - init!!!");
        WoodPeckerSDK.f().l(getContext());
        ActionType.init(getContext());
        g.c().a();
        vu.g.d().h(new a());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
