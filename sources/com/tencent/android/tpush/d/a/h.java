package com.tencent.android.tpush.d.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import org.json.JSONObject;

public class h extends c {

    /* renamed from: a  reason: collision with root package name */
    private String f69313a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f69314b = null;

    /* renamed from: c  reason: collision with root package name */
    private Context f69315c;

    public h(Context context) {
        this.f69315c = context;
        TLogger.dd("OtherPushXgSysImpl", "OtherPushXgSysImpl");
    }

    private void g(Context context) {
        if (this.f69314b == null) {
            this.f69314b = "";
            JSONObject h11 = h(context);
            if (h11 == null) {
                return;
            }
            if (h11.optString(Constants.XG_SYS_KEY_SYS_PKG, "").equals(context.getPackageName())) {
                TLogger.ii("OtherPushXgSysImpl", "Run in sys app, set pushinfo empty");
            } else {
                this.f69314b = h11.optString(Constants.XG_SYS_KEY_PUSHINFO, "");
            }
        }
    }

    private JSONObject h(Context context) {
        try {
            String type = context.getContentResolver().getType(Uri.parse("content://com.tencent.tpns.syspush.auth"));
            TLogger.ii("OtherPushXgSysImpl", "sysPushInfo:" + type);
            if (type != null) {
                return new JSONObject(type);
            }
            return null;
        } catch (Throwable unused) {
            TLogger.ii("OtherPushXgSysImpl", "get sysPushInfo get throwable");
            return null;
        }
    }

    public void a(Context context) {
        this.f69313a = null;
        PushPreferences.putString(context, Constants.XG_SYS_TOKEN_COL_NAME, "");
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.tpns.syspush.auth/register"), (String[]) null, Long.toString(XGApiConfig.getAccessId(context)), (String[]) null, (String) null);
            if (query != null) {
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex(Constants.XG_SYS_TOKEN_COL_NAME));
                this.f69313a = string;
                PushPreferences.putString(context, Constants.XG_SYS_TOKEN_COL_NAME, string);
                query.close();
            }
            TLogger.ii("OtherPushXgSysImpl", "registerPush ret otherToken:" + this.f69313a);
        } catch (Throwable th2) {
            TLogger.ee("OtherPushXgSysImpl", "registerPush throwable:", th2);
        }
    }

    public void b(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.tpns.syspush.auth/unregister"), (String[]) null, Long.toString(XGApiConfig.getAccessId(context)), (String[]) null, (String) null);
            if (query != null) {
                query.close();
            }
        } catch (Throwable th2) {
            TLogger.ee("OtherPushXgSysImpl", "unregisterPush throwable:", th2);
        }
        this.f69313a = null;
        PushPreferences.putString(context, Constants.XG_SYS_TOKEN_COL_NAME, "");
    }

    public String c(Context context) {
        if (j.b(this.f69313a)) {
            this.f69313a = PushPreferences.getString(context, Constants.XG_SYS_TOKEN_COL_NAME, "");
        }
        return this.f69313a;
    }

    public boolean d(Context context) {
        g(context);
        boolean z11 = !j.b(this.f69314b);
        TLogger.dd("OtherPushXgSysImpl", "isConfig: " + z11);
        return z11;
    }

    public int e(Context context) {
        return 8;
    }

    public String f(Context context) {
        return "";
    }

    public String a() {
        g(this.f69315c);
        return this.f69314b;
    }
}
