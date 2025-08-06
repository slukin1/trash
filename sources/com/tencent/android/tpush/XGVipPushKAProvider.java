package com.tencent.android.tpush;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.service.b;

public class XGVipPushKAProvider extends ContentProvider {
    private void a(Uri uri, Context context) {
        if (context != null) {
            try {
                if (!XGPushConfig.isUsedTpnsChannel(context)) {
                    TLogger.ii("XGVipPushKAProvider", "prepare startService abolish, not use Tpns channel service");
                    return;
                }
                TLogger.d("XGVipPushKAProvider", "prepare startService");
                Intent intent = new Intent();
                intent.setData(uri);
                intent.setClass(context, XGVipPushService.class);
                context.startService(intent);
            } catch (Throwable th2) {
                TLogger.w("XGVipPushKAProvider", "start service failed.", th2);
            }
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        a(uri, getContext());
        return 0;
    }

    public String getType(Uri uri) {
        a(uri, getContext());
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        a(uri, getContext());
        return null;
    }

    public boolean onCreate() {
        Context context = getContext();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onCreate start service context: ");
        sb2.append(context != null);
        TLogger.d("XGVipPushKAProvider", sb2.toString());
        if (context != null) {
            b.a(context);
        }
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        a(uri, getContext());
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        a(uri, getContext());
        return 0;
    }
}
