package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.an;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class fb {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f51769a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f2839a;

    /* renamed from: a  reason: collision with other field name */
    public int f2840a = 0;

    /* renamed from: a  reason: collision with other field name */
    public long f2841a = -1;

    /* renamed from: a  reason: collision with other field name */
    public fc f2842a;

    /* renamed from: a  reason: collision with other field name */
    public fk f2843a = null;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f2844a;

    /* renamed from: a  reason: collision with other field name */
    public String f2845a = "";

    /* renamed from: a  reason: collision with other field name */
    private final Collection<fe> f2846a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f2847a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    public final Map<fg, a> f2848a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public final int f51770b = f51769a.getAndIncrement();

    /* renamed from: b  reason: collision with other field name */
    public volatile long f2849b = 0;

    /* renamed from: b  reason: collision with other field name */
    public String f2850b = "";

    /* renamed from: b  reason: collision with other field name */
    public final Map<fg, a> f2851b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private int f51771c = 2;

    /* renamed from: c  reason: collision with other field name */
    public volatile long f2852c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f51772d = 0;

    /* renamed from: e  reason: collision with root package name */
    private long f51773e = 0;

    static {
        f2839a = false;
        try {
            f2839a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        fh.a();
    }

    public fb(XMPushService xMPushService, fc fcVar) {
        this.f2842a = fcVar;
        this.f2844a = xMPushService;
        b();
    }

    private String a(int i11) {
        return i11 == 1 ? "connected" : i11 == 0 ? "connecting" : i11 == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    public fc m2671a() {
        return this.f2842a;
    }

    public abstract void a(fp fpVar);

    public abstract void a(am.b bVar);

    public abstract void a(String str, String str2);

    public abstract void a(es[] esVarArr);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2674a() {
        return false;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m2675b() {
        return this.f2842a.b();
    }

    public abstract void b(int i11, Exception exc);

    public abstract void b(es esVar);

    public abstract void b(boolean z11);

    /* renamed from: c  reason: collision with other method in class */
    public boolean m2678c() {
        return this.f51771c == 1;
    }

    public void d() {
        synchronized (this.f2847a) {
            this.f2847a.clear();
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private fg f51774a;

        /* renamed from: a  reason: collision with other field name */
        private fl f2853a;

        public a(fg fgVar, fl flVar) {
            this.f51774a = fgVar;
            this.f2853a = flVar;
        }

        public void a(fp fpVar) {
            fl flVar = this.f2853a;
            if (flVar == null || flVar.a(fpVar)) {
                this.f51774a.a(fpVar);
            }
        }

        public void a(es esVar) {
            this.f51774a.a(esVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2672a() {
        return this.f2842a.c();
    }

    public void b(fe feVar) {
        this.f2846a.remove(feVar);
    }

    public synchronized void c() {
        this.f51773e = SystemClock.elapsedRealtime();
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m2670a() {
        return this.f2852c;
    }

    public void b(fg fgVar, fl flVar) {
        Objects.requireNonNull(fgVar, "Packet listener is null.");
        this.f2851b.put(fgVar, new a(fgVar, flVar));
    }

    public void a(fe feVar) {
        if (feVar != null && !this.f2846a.contains(feVar)) {
            this.f2846a.add(feVar);
        }
    }

    public void a(fg fgVar, fl flVar) {
        Objects.requireNonNull(fgVar, "Packet listener is null.");
        this.f2848a.put(fgVar, new a(fgVar, flVar));
    }

    public void b(fg fgVar) {
        this.f2851b.remove(fgVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m2676b() {
        String str;
        if (this.f2842a.a() && this.f2843a == null) {
            Class<?> cls = null;
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            if (cls == null) {
                this.f2843a = new fa(this);
                return;
            }
            try {
                this.f2843a = (fk) cls.getConstructor(new Class[]{fb.class, Writer.class, Reader.class}).newInstance(new Object[]{this});
            } catch (Exception e12) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e12);
            }
        }
    }

    public void a(fg fgVar) {
        this.f2848a.remove(fgVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<fg, a> m2673a() {
        return this.f2848a;
    }

    public int a() {
        return this.f2840a;
    }

    public void a(int i11, int i12, Exception exc) {
        int i13 = this.f51771c;
        if (i11 != i13) {
            b.a(String.format("update the connection status. %1$s -> %2$s : %3$s ", new Object[]{a(i13), a(i11), an.a(i12)}));
        }
        if (av.a((Context) this.f2844a)) {
            a(i11);
        }
        if (i11 == 1) {
            this.f2844a.a(10);
            if (this.f51771c != 0) {
                b.a("try set connected while not connecting.");
            }
            this.f51771c = i11;
            for (fe b11 : this.f2846a) {
                b11.b(this);
            }
        } else if (i11 == 0) {
            if (this.f51771c != 2) {
                b.a("try set connecting while not disconnected.");
            }
            this.f51771c = i11;
            for (fe a11 : this.f2846a) {
                a11.a(this);
            }
        } else if (i11 == 2) {
            this.f2844a.a(10);
            int i14 = this.f51771c;
            if (i14 == 0) {
                for (fe a12 : this.f2846a) {
                    a12.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i14 == 1) {
                for (fe a13 : this.f2846a) {
                    a13.a(this, i12, exc);
                }
            }
            this.f51771c = i11;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2677b() {
        return this.f51771c == 0;
    }

    public int b() {
        return this.f51771c;
    }

    public synchronized void a(String str) {
        if (this.f51771c == 0) {
            b.a("setChallenge hash = " + bb.a(str).substring(0, 8));
            this.f2845a = str;
            a(1, 0, (Exception) null);
        } else {
            b.a("ignore setChallenge because connection was disconnected");
        }
    }

    public synchronized boolean a(long j11) {
        return this.f51773e >= j11;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m2669a(int i11) {
        synchronized (this.f2847a) {
            if (i11 == 1) {
                this.f2847a.clear();
            } else {
                this.f2847a.add(new Pair(Integer.valueOf(i11), Long.valueOf(System.currentTimeMillis())));
                if (this.f2847a.size() > 6) {
                    this.f2847a.remove(0);
                }
            }
        }
    }
}
