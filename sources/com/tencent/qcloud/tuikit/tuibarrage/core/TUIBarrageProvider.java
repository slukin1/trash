package com.tencent.qcloud.tuikit.tuibarrage.core;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.tencent.qcloud.tuicore.TUICore;

public final class TUIBarrageProvider extends ContentProvider {
    private static final String TAG = "TUIBarrageProvider";

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
        Log.d(TAG, "TUIBarrageProvider onCreate");
        TUICore.registerExtension(TUIBarrageExtension.OBJECT_TUI_BARRAGE, new TUIBarrageExtension());
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
