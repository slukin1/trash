package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huobi.vulcan.model.VulcanInfo;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;

public class a extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static int f52385a = 1;

    /* renamed from: a  reason: collision with other field name */
    public static final Object f3262a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f3263a = {Constants.PACKAGE_NAME, "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", VulcanInfo.IMSI, "TEXT"};

    public a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, f52385a);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb2 = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        int i11 = 0;
        while (true) {
            String[] strArr = f3263a;
            if (i11 < strArr.length - 1) {
                if (i11 != 0) {
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb2.append(strArr[i11]);
                sb2.append(" ");
                sb2.append(strArr[i11 + 1]);
                i11 += 2;
            } else {
                sb2.append(");");
                sQLiteDatabase.execSQL(sb2.toString());
                return;
            }
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f3262a) {
            try {
                a(sQLiteDatabase);
            } catch (SQLException e11) {
                b.a((Throwable) e11);
            }
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }
}
