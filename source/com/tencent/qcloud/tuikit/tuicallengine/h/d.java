package com.tencent.qcloud.tuikit.tuicallengine.h;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.f.n;

public class d extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f48462a;

    /* renamed from: b  reason: collision with root package name */
    public static String f48463b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f48464c;

    public d(Context context) {
        super(context, n.a() + "_" + "callhistory.db", (SQLiteDatabase.CursorFactory) null, 1);
        HandlerThread handlerThread = new HandlerThread("recent_calls");
        handlerThread.start();
        this.f48464c = new Handler(handlerThread.getLooper());
        f48463b = n.a();
    }

    public static Cursor a(d dVar, TUICallDefine.RecentCallsFilter recentCallsFilter) {
        String str;
        TUICallDefine.CallRecords.Result result;
        TUICallDefine.RecentCallsFilter recentCallsFilter2 = recentCallsFilter;
        dVar.getClass();
        String[] strArr = new String[0];
        if (recentCallsFilter2 == null || recentCallsFilter2.result != (result = TUICallDefine.CallRecords.Result.Missed)) {
            str = "";
        } else {
            strArr = new String[]{Integer.toString(result.ordinal())};
            str = "status = ?";
        }
        return dVar.getReadableDatabase().query("callrecord", new String[]{AnalyticsEvents.PARAMETER_CALL_ID, "inviter", "group_id", "remote_user_list", "role", MessengerShareContentUtility.MEDIA_TYPE, "call_scene", "status", "begin_time", "total_time"}, str, strArr, (String) null, (String) null, "begin_time DESC");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE callrecord (call_id TEXT  PRIMARY KEY,inviter TEXT,remote_user_list TEXT,role TEXT,media_type TEXT,group_id TEXT,call_scene TEXT,status INTEGER,begin_time INTEGER,total_time INTEGER);");
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS callrecord");
        sQLiteDatabase.execSQL("CREATE TABLE callrecord (call_id TEXT  PRIMARY KEY,inviter TEXT,remote_user_list TEXT,role TEXT,media_type TEXT,group_id TEXT,call_scene TEXT,status INTEGER,begin_time INTEGER,total_time INTEGER);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS callrecord");
        sQLiteDatabase.execSQL("CREATE TABLE callrecord (call_id TEXT  PRIMARY KEY,inviter TEXT,remote_user_list TEXT,role TEXT,media_type TEXT,group_id TEXT,call_scene TEXT,status INTEGER,begin_time INTEGER,total_time INTEGER);");
    }

    public static d a(Context context) {
        if (!TextUtils.isEmpty(V2TIMManager.getInstance().getLoginUser()) && !V2TIMManager.getInstance().getLoginUser().equals(f48463b) && f48462a != null) {
            Handler handler = f48462a.f48464c;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            f48462a = null;
        }
        if (f48462a == null) {
            synchronized (d.class) {
                if (f48462a == null) {
                    f48462a = new d(context);
                }
            }
        }
        return f48462a;
    }

    public final void a(Runnable runnable) {
        Handler handler = this.f48464c;
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }
}
