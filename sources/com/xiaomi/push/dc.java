package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.hbg.lib.network.pro.core.util.Period;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.xiaomi.push.ag;
import com.xiaomi.push.service.ax;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class dc {

    /* renamed from: a  reason: collision with root package name */
    private static volatile dc f51571a;

    /* renamed from: a  reason: collision with other field name */
    private Context f2649a;

    /* renamed from: a  reason: collision with other field name */
    private final ConcurrentLinkedQueue<b> f2650a;

    public class a extends b {
        public a() {
            super();
        }

        public void b() {
            dc.a(dc.this);
        }
    }

    public class b extends ag.b {

        /* renamed from: a  reason: collision with root package name */
        public long f51576a = System.currentTimeMillis();

        public b() {
        }

        public boolean a() {
            return true;
        }

        public void b() {
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m2518b() {
            return System.currentTimeMillis() - this.f51576a > 172800000;
        }
    }

    private dc(Context context) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f2650a = concurrentLinkedQueue;
        this.f2649a = context;
        concurrentLinkedQueue.add(new a());
        b(0);
    }

    private void b() {
        try {
            File file = new File(this.f2649a.getFilesDir() + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File delete : file.listFiles()) {
                    delete.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    private void c() {
        while (!this.f2650a.isEmpty()) {
            b peek = this.f2650a.peek();
            if (peek != null) {
                if (peek.b() || this.f2650a.size() > 6) {
                    com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                    this.f2650a.remove(peek);
                } else {
                    return;
                }
            }
        }
    }

    public static dc a(Context context) {
        if (f51571a == null) {
            synchronized (dc.class) {
                if (f51571a == null) {
                    f51571a = new dc(context);
                }
            }
        }
        f51571a.f2649a = context;
        return f51571a;
    }

    private void b(long j11) {
        if (!this.f2650a.isEmpty()) {
            fz.a(new ag.b() {

                /* renamed from: a  reason: collision with root package name */
                public ag.b f51574a;

                public void b() {
                    b bVar = (b) dc.a(dc.this).peek();
                    if (bVar != null && bVar.a()) {
                        if (dc.a(dc.this).remove(bVar)) {
                            this.f51574a = bVar;
                        }
                        ag.b bVar2 = this.f51574a;
                        if (bVar2 != null) {
                            bVar2.b();
                        }
                    }
                }

                public void c() {
                    ag.b bVar = this.f51574a;
                    if (bVar != null) {
                        bVar.c();
                    }
                }
            }, j11);
        }
    }

    public class c extends b {

        /* renamed from: a  reason: collision with root package name */
        public int f51578a;

        /* renamed from: a  reason: collision with other field name */
        public File f2659a;

        /* renamed from: a  reason: collision with other field name */
        public String f2660a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2661a;

        /* renamed from: b  reason: collision with root package name */
        public String f51579b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f2662b;

        public c(String str, String str2, File file, boolean z11) {
            super();
            this.f2660a = str;
            this.f51579b = str2;
            this.f2659a = file;
            this.f2662b = z11;
        }

        private boolean c() {
            int i11;
            int i12 = 0;
            SharedPreferences sharedPreferences = dc.a(dc.this).getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong(CrashHianalyticsData.TIME);
                i11 = jSONObject.getInt("times");
            } catch (JSONException unused) {
                i11 = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= Period.DAY_MILLS) {
                currentTimeMillis = System.currentTimeMillis();
            } else if (i11 > 10) {
                return false;
            } else {
                i12 = i11;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(CrashHianalyticsData.TIME, currentTimeMillis);
                jSONObject2.put("times", i12 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e11) {
                com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + e11.getMessage());
            }
            return true;
        }

        public boolean a() {
            return av.d(dc.a(dc.this)) || (this.f2662b && av.a(dc.a(dc.this)));
        }

        public void b() {
            try {
                if (c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", ax.a());
                    hashMap.put("token", this.f51579b);
                    hashMap.put("net", av.a(dc.a(dc.this)));
                    av.a(this.f2660a, hashMap, this.f2659a, "file");
                }
                this.f2661a = true;
            } catch (IOException unused) {
            }
        }

        /* renamed from: c  reason: collision with other method in class */
        public void m2519c() {
            if (!this.f2661a) {
                int i11 = this.f51578a + 1;
                this.f51578a = i11;
                if (i11 < 3) {
                    dc.a(dc.this).add(this);
                }
            }
            if (this.f2661a || this.f51578a >= 3) {
                this.f2659a.delete();
            }
            dc.this.a((long) ((1 << this.f51578a) * 1000));
        }
    }

    public void a(String str, String str2, Date date, Date date2, int i11, boolean z11) {
        final int i12 = i11;
        final Date date3 = date;
        final Date date4 = date2;
        final String str3 = str;
        final String str4 = str2;
        final boolean z12 = z11;
        this.f2650a.add(new b() {

            /* renamed from: a  reason: collision with other field name */
            public File f2652a;

            public void b() {
                try {
                    File file = new File(dc.a(dc.this).getFilesDir() + "/.logcache");
                    if (w.a(file)) {
                        file.mkdirs();
                        if (file.isDirectory()) {
                            db dbVar = new db();
                            dbVar.a(i12);
                            this.f2652a = dbVar.a(dc.a(dc.this), date3, date4, file);
                        }
                    }
                } catch (NullPointerException unused) {
                }
            }

            public void c() {
                File file = this.f2652a;
                if (file != null && file.exists()) {
                    dc.a(dc.this).add(new c(str3, str4, this.f2652a, z12));
                }
                dc.this.a(0);
            }
        });
        b(0);
    }

    public void a() {
        c();
        a(0);
    }

    /* access modifiers changed from: private */
    public void a(long j11) {
        b peek = this.f2650a.peek();
        if (peek != null && peek.a()) {
            b(j11);
        }
    }
}
