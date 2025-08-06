package com.huawei.hms.push;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

public class p extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private Context f38430a;

    /* renamed from: b  reason: collision with root package name */
    private o f38431b;

    public p(Context context, o oVar) {
        this.f38430a = context;
        this.f38431b = oVar;
    }

    private static Intent a(Context context, o oVar) {
        if (oVar == null) {
            return null;
        }
        Intent b11 = e.b(context, oVar.c());
        if (oVar.m() != null) {
            try {
                Intent parseUri = Intent.parseUri(oVar.m(), 0);
                parseUri.setSelector((Intent) null);
                if (parseUri.getClipData() == null) {
                    parseUri.setClipData(ClipData.newPlainText("avoid intent add read permission flags", "avoid"));
                }
                HMSLog.d("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + parseUri.getAction());
                if (e.a(context, oVar.c(), parseUri).booleanValue()) {
                    return parseUri;
                }
                return b11;
            } catch (Exception e11) {
                HMSLog.w("PushSelfShowLog", "intentUri error," + e11.toString());
                return b11;
            }
        } else {
            if (oVar.a() != null) {
                Intent intent = new Intent(oVar.a());
                if (e.a(context, oVar.c(), intent).booleanValue()) {
                    b11 = intent;
                }
            }
            b11.setPackage(oVar.c());
            return b11;
        }
    }

    private boolean b(Context context) {
        if ("cosa".equals(this.f38431b.h())) {
            return a(context);
        }
        return true;
    }

    public void run() {
        HMSLog.i("PushSelfShowLog", "enter run()");
        try {
            if (b(this.f38430a) && !b(this.f38430a, this.f38431b)) {
                n.a(this.f38430a, this.f38431b);
            }
        } catch (Exception e11) {
            HMSLog.e("PushSelfShowLog", e11.toString());
        }
    }

    private boolean b(Context context, o oVar) {
        if (!"cosa".equals(oVar.h()) || a(context, oVar) != null) {
            return false;
        }
        HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
        return true;
    }

    private boolean a(Context context) {
        return e.c(context, this.f38431b.c());
    }
}
