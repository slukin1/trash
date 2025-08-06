package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.af;
import com.xiaomi.push.bx;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.az;
import java.lang.ref.WeakReference;

public class bo {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bo f51448a;

    /* renamed from: a  reason: collision with other field name */
    private Context f2562a;

    /* renamed from: a  reason: collision with other field name */
    private af.a f2563a = new af.a() {
        public String a() {
            return "10052";
        }

        public void run() {
            b.c("exec== mUploadJob");
            if (bo.a(bo.this) != null) {
                bo.a(bo.this).a(bo.a(bo.this));
                bo.this.b("upload_time");
            }
        }
    };

    /* renamed from: a  reason: collision with other field name */
    private by f2564a;

    /* renamed from: a  reason: collision with other field name */
    private bz f2565a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2566a = "push_stat_sp";

    /* renamed from: b  reason: collision with root package name */
    private af.a f51449b = new af.a() {
        public String a() {
            return "10054";
        }

        public void run() {
            b.c("exec== DbSizeControlJob");
            bx.a(bo.a(bo.this)).a((Runnable) new bq(bo.a(bo.this), new WeakReference(bo.a(bo.this))));
            bo.this.b("check_time");
        }
    };

    /* renamed from: b  reason: collision with other field name */
    private final String f2567b = "upload_time";

    /* renamed from: c  reason: collision with root package name */
    private af.a f51450c = new af.a() {
        public String a() {
            return "10053";
        }

        public void run() {
            if (bo.a(bo.this) != null) {
                bo.a(bo.this).b(bo.a(bo.this));
                bo.this.b("delete_time");
            }
        }
    };

    /* renamed from: c  reason: collision with other field name */
    private final String f2568c = "delete_time";

    /* renamed from: d  reason: collision with root package name */
    private final String f51451d = "check_time";

    /* renamed from: e  reason: collision with root package name */
    private String f51452e;

    /* renamed from: f  reason: collision with root package name */
    private String f51453f;

    private bo(Context context) {
        this.f2562a = context;
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f2562a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        p.a(edit);
    }

    private String c() {
        return this.f2562a.getDatabasePath(bp.f2570a).getAbsolutePath();
    }

    public static bo a(Context context) {
        if (f51448a == null) {
            synchronized (bo.class) {
                if (f51448a == null) {
                    f51448a = new bo(context);
                }
            }
        }
        return f51448a;
    }

    public String b() {
        return this.f51453f;
    }

    private boolean a() {
        return ah.a(this.f2562a).a(gl.StatDataSwitch.a(), true);
    }

    public void a(bx.a aVar) {
        bx.a(this.f2562a).a(aVar);
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f2564a == null) {
            return;
        }
        if (bool.booleanValue()) {
            this.f2564a.a(this.f2562a, str2, str);
        } else {
            this.f2564a.b(this.f2562a, str2, str);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2446a() {
        return this.f51452e;
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(ca.a(this.f2562a, str));
        }
    }

    public void a(gk gkVar) {
        if (a() && az.a(gkVar.e())) {
            a((bx.a) bu.a(this.f2562a, c(), gkVar));
        }
    }
}
