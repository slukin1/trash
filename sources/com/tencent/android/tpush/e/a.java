package com.tencent.android.tpush.e;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Build;
import com.hbg.lib.network.pro.core.util.Period;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.g;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static long f69324a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static long f69325b = 172800000;

    /* renamed from: c  reason: collision with root package name */
    private static com.tencent.android.tpush.e.a.a f69326c;

    public static boolean a(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("msgId", -1);
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgid", Long.valueOf(longExtra));
        boolean z11 = true;
        contentValues.put("message", Rijndael.encrypt(intent.toUri(1)));
        contentValues.put(CrashHianalyticsData.TIME, Long.valueOf(g.b(intent)));
        contentValues.put("busiid", Long.valueOf(intent.getLongExtra(MessageKey.MSG_BUSI_MSG_ID, 0)));
        contentValues.put("showedtime", 0);
        contentValues.put("status", 0);
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            if (writableDatabase.insert("messagetoshow", (String) null, contentValues) <= 0) {
                TLogger.e("MessageInfoManager", "addCacheMessage Error! ");
                z11 = false;
            }
            writableDatabase.close();
            return z11;
        } catch (Throwable th2) {
            TLogger.e("MessageInfoManager", "addNewCacheMessage Error! " + th2);
            return false;
        }
    }

    public static boolean b(Context context, long j11) {
        e(context);
        return a(context, j11, 2);
    }

    public static boolean c(Context context, long j11) {
        return a(context, j11, 3);
    }

    private static com.tencent.android.tpush.e.a.a d(Context context) {
        if (f69326c == null) {
            synchronized (a.class) {
                if (f69326c == null) {
                    f69326c = new com.tencent.android.tpush.e.a.a(context.getApplicationContext());
                }
            }
        }
        return f69326c;
    }

    private static boolean e(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = f69324a;
        boolean z11 = true;
        if (j11 == 0 || currentTimeMillis - j11 > Period.DAY_MILLS) {
            f69324a = currentTimeMillis;
            long j12 = currentTimeMillis - f69325b;
            try {
                SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
                if (writableDatabase.delete("messagetoshow", "status >= ? AND showedtime < ? ", new String[]{"1", j12 + ""}) <= 0) {
                    TLogger.d("MessageInfoManager", "delOldShowedCacheMessage Error! toDelTime: " + j12);
                    z11 = false;
                }
                writableDatabase.close();
            } catch (Throwable th2) {
                TLogger.e("MessageInfoManager", "delOldShowedCacheMessage Error! " + th2);
                return false;
            }
        }
        return z11;
    }

    public static boolean f(Context context, long j11) {
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            boolean z11 = true;
            if (writableDatabase.delete("messagetoshow", "busiid=?", new String[]{j11 + ""}) <= 0) {
                TLogger.d("MessageInfoManager", "delCacheMessageByBusiId Error! msgid to delete which busiId = : " + j11);
                z11 = false;
            }
            writableDatabase.close();
            return z11;
        } catch (Throwable th2) {
            TLogger.e("MessageInfoManager", "delCacheMessageByBusiId Error! " + th2);
            return false;
        }
    }

    public static boolean g(Context context, long j11) {
        boolean z11 = false;
        try {
            SQLiteDatabase readableDatabase = d(context).getReadableDatabase();
            SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
            sQLiteQueryBuilder.setTables("messagetoshow");
            String[] strArr = {j11 + ""};
            Cursor query = sQLiteQueryBuilder.query(readableDatabase, new String[]{"message"}, "msgid=?", strArr, (String) null, (String) null, (String) null);
            if (query != null) {
                z11 = query.moveToFirst();
                query.close();
            }
            readableDatabase.close();
        } catch (Throwable th2) {
            TLogger.e("MessageInfoManager", "isMessageCached Error! " + th2);
        }
        return z11;
    }

    public static ArrayList<Intent> c(Context context) {
        ArrayList<Intent> arrayList = new ArrayList<>();
        try {
            SQLiteDatabase readableDatabase = d(context).getReadableDatabase();
            SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
            sQLiteQueryBuilder.setTables("messagetoshow");
            Cursor query = sQLiteQueryBuilder.query(readableDatabase, new String[]{"message"}, "status=0", (String[]) null, (String) null, (String) null, (String) null);
            if (query != null) {
                while (query.moveToNext()) {
                    Intent parseUri = Intent.parseUri(Rijndael.decrypt(query.getString(0)), 1);
                    parseUri.addCategory("android.intent.category.BROWSABLE");
                    parseUri.setComponent((ComponentName) null);
                    if (Build.VERSION.SDK_INT >= 15) {
                        try {
                            parseUri.getClass().getMethod("setSelector", new Class[]{Intent.class}).invoke(parseUri, new Object[]{null});
                        } catch (Throwable th2) {
                            TLogger.w("MessageInfoManager", "invoke intent.setComponent error.", th2);
                        }
                    }
                    arrayList.add(parseUri);
                }
                query.close();
            }
            readableDatabase.close();
        } catch (URISyntaxException e11) {
            TLogger.e("MessageInfoManager", "getCacheMessages Error: " + e11);
        } catch (Throwable th3) {
            TLogger.e("MessageInfoManager", "getNewCacheMessages Error! " + th3);
        }
        return arrayList;
    }

    public static boolean b(Context context) {
        boolean z11;
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            if (writableDatabase.delete("messagetoshow", "msgid < 0", (String[]) null) <= 0) {
                TLogger.d("MessageInfoManager", "deleteAllLocalCacheMsgIntent Error! ");
                z11 = false;
            } else {
                z11 = true;
            }
            writableDatabase.close();
            return z11;
        } catch (Throwable th2) {
            TLogger.e("MessageInfoManager", "deleteAllLocalCacheMsgIntent Error! " + th2);
            return false;
        }
    }

    public static boolean d(Context context, long j11) {
        return a(context, j11, 4);
    }

    public static boolean e(Context context, long j11) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            if (writableDatabase.delete("messagetoshow", "msgid=?", new String[]{j11 + ""}) <= 0) {
                TLogger.d("MessageInfoManager", "delCacheMessage Error! msgid to delete: " + j11);
                try {
                    writableDatabase.close();
                } catch (Throwable unused) {
                    TLogger.w("MessageInfoManager", "unexpected for delCacheMessage, db close error");
                }
                return false;
            }
            try {
                writableDatabase.close();
            } catch (Throwable unused2) {
                TLogger.w("MessageInfoManager", "unexpected for delCacheMessage, db close error");
            }
            return true;
        } catch (Throwable unused3) {
            TLogger.w("MessageInfoManager", "unexpected for delCacheMessage, db close error");
        }
        return false;
    }

    public static boolean a(Context context, long j11) {
        e(context);
        return a(context, j11, 1);
    }

    private static boolean a(Context context, long j11, int i11) {
        ContentValues contentValues = new ContentValues();
        boolean z11 = true;
        if (i11 == 1 || i11 == 2) {
            contentValues.put("showedtime", Long.valueOf(System.currentTimeMillis()));
        }
        contentValues.put("status", Integer.valueOf(i11));
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            if (((long) writableDatabase.update("messagetoshow", contentValues, "msgid=?", new String[]{j11 + ""})) <= 0) {
                TLogger.d("MessageInfoManager", "updateCacheMessage Error! msgId:" + j11 + ", status:" + i11);
                z11 = false;
            }
            writableDatabase.close();
            return z11;
        } catch (Throwable th2) {
            TLogger.e("MessageInfoManager", "updateCacheMessage Error! " + th2);
            return false;
        }
    }

    public static boolean a(Context context) {
        boolean z11;
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            if (writableDatabase.delete("messagetoshow", (String) null, (String[]) null) <= 0) {
                TLogger.w("MessageInfoManager", "delAllCacheMessage but no mssgage in db");
                z11 = false;
            } else {
                z11 = true;
            }
            writableDatabase.close();
            return z11;
        } catch (Throwable th2) {
            TLogger.e("MessageInfoManager", "delAllCacheMessage Error! " + th2);
            return false;
        }
    }
}
