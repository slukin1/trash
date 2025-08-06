package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.android.tpush.common.Constants;
import com.xiaomi.push.bx;

public class bu extends bx.e {

    /* renamed from: a  reason: collision with root package name */
    private String f51461a = "MessageInsertJob";

    public bu(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.f51461a = str2;
    }

    public static bu a(Context context, String str, gk gkVar) {
        byte[] a11 = hq.a(gkVar);
        if (a11 == null || a11.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", gkVar.d());
        contentValues.put("messageItem", a11);
        contentValues.put("appId", bo.a(context).b());
        contentValues.put(Constants.FLAG_PACKAGE_NAME, bo.a(context).a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", 0);
        return new bu(str, contentValues, "a job build to insert message to db");
    }
}
