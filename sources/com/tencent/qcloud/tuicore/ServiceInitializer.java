package com.tencent.qcloud.tuicore;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class ServiceInitializer extends ContentProvider {
    private static Context appContext;

    public static Context getAppContext() {
        return appContext;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int getLightThemeResId() {
        return R.style.TUIBaseLightTheme;
    }

    public int getLivelyThemeResId() {
        return R.style.TUIBaseLivelyTheme;
    }

    public int getSeriousThemeResId() {
        return R.style.TUIBaseSeriousTheme;
    }

    public String getType(Uri uri) {
        return null;
    }

    public void init(Context context) {
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        if (appContext == null) {
            appContext = getContext().getApplicationContext();
        }
        TUIRouter.init(appContext);
        TUIConfig.init(appContext);
        TUIThemeManager.addLightTheme(getLightThemeResId());
        TUIThemeManager.addLivelyTheme(getLivelyThemeResId());
        TUIThemeManager.addSeriousTheme(getSeriousThemeResId());
        TUIThemeManager.setTheme(appContext);
        init(appContext);
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
