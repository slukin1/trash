package com.mob.tools.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.hbg.lib.network.pro.core.util.Period;
import com.mob.commons.CSCenter;
import com.mob.commons.d;
import com.mob.commons.s;
import com.mob.commons.x;
import com.mob.commons.y;
import com.mob.tools.MobLog;
import com.mob.tools.c;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.FileUtils;
import com.mob.tools.utils.h;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class i implements a {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f27801a;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f27802b;

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f27803c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f27804d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public b f27805e;

    /* renamed from: f  reason: collision with root package name */
    private volatile Set<String> f27806f = new HashSet();

    public static abstract class a<T> {

        /* renamed from: g  reason: collision with root package name */
        public T f27889g;

        public a(T t11) {
            this.f27889g = t11;
        }

        public long a(T t11) {
            return 0;
        }

        public abstract T b() throws Throwable;
    }

    public i(Context context) {
        this.f27804d = context;
        this.f27801a = new ConcurrentHashMap<>();
        this.f27802b = new ConcurrentHashMap<>();
        this.f27805e = b.a(context);
        this.f27803c = new ConcurrentHashMap<>();
        h.a();
    }

    private void h(String str) {
    }

    public HashMap<String, Long> A() {
        return (HashMap) b("meio", new a<HashMap<String, Long>>((HashMap) null) {
            public long a(HashMap<String, Long> hashMap) {
                return 180000;
            }

            /* renamed from: a */
            public HashMap<String, Long> b() throws Throwable {
                return i.this.f27805e.F();
            }
        });
    }

    public String B() {
        return (String) b("ale", new a<String>((String) null) {
            public long a(String str) {
                return 600000;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.i();
            }
        });
    }

    public String C() {
        return (String) b("sse", new a<String>((String) null) {
            public long a(String str) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.k();
            }
        });
    }

    public String D() {
        return d.i() ? f(false) : "forbid";
    }

    public String E() {
        String lowerCase = D().toLowerCase();
        if (TextUtils.isEmpty(lowerCase) || s.a("004e)dk+ef").equals(lowerCase)) {
            return s.a("004eWdk,ef");
        }
        if (lowerCase.startsWith(s.a("002Ohiej")) || lowerCase.startsWith(s.a("002Bhlej")) || lowerCase.startsWith(s.a("0023jfej")) || lowerCase.startsWith(s.a("002<heej"))) {
            return s.a("004cfgg");
        }
        if (lowerCase.startsWith(s.a("004[fgdiefdi")) || "forbid".equals(lowerCase)) {
            return s.a("004Bfgdiefdi");
        }
        return s.a("005=dk;ihf$dj");
    }

    public String F() {
        String lowerCase = D().toLowerCase();
        if (TextUtils.isEmpty(lowerCase) || s.a("004e=dkJef").equals(lowerCase)) {
            return s.a("004eZdk[ef");
        }
        if (lowerCase.startsWith(s.a("004)fgdiefdi"))) {
            return s.a("004=fgdiefdi");
        }
        if (lowerCase.startsWith(s.a("002Zhiej"))) {
            return s.a("002>hiej");
        }
        if (lowerCase.startsWith(s.a("002Yhlej"))) {
            return s.a("002Ihlej");
        }
        if (lowerCase.startsWith(s.a("0024jfej"))) {
            return s.a("002Ojfej");
        }
        if (lowerCase.startsWith(s.a("002!heej"))) {
            return s.a("002Rheej");
        }
        return lowerCase.startsWith(s.a("009TffFgZdg5fiQdkdk(ih")) ? s.a("009VffGg5dg$fiMdkdkRih") : lowerCase;
    }

    public boolean G() {
        String E = E();
        return s.a("004Yfgdiefdi").equals(E) || s.a("004cfgg").equals(E);
    }

    public int H() {
        return ((Integer) b("dtnttp", new a<Integer>(-1) {
            public long a(Integer num) {
                return 180000;
            }

            /* renamed from: a */
            public Integer b() throws Throwable {
                return Integer.valueOf(i.this.f27805e.V());
            }
        })).intValue();
    }

    public String I() {
        return (String) b("tize", new a<String>((String) null) {
            public long a(String str) {
                return Period.MIN60_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.Q();
            }
        });
    }

    public String J() {
        return (String) b("flvr", new a<String>((String) null) {
            public long a(String str) {
                return Period.MIN60_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.R();
            }
        });
    }

    public String K() {
        return (String) b("babd", new a<String>((String) null) {
            public long a(String str) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.S();
            }
        });
    }

    public String L() {
        return (String) b("bfsp", new a<String>((String) null) {
            public long a(String str) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.T();
            }
        });
    }

    public String M() {
        return (String) b("bopm", new a<String>((String) null) {
            public long a(String str) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.U();
            }
        });
    }

    public String N() {
        if (!CSCenter.getInstance().isIpAddressEnable()) {
            return CSCenter.getInstance().getIpAddress();
        }
        if (!d.i()) {
            return "0.0.0.0";
        }
        try {
            Enumeration<NetworkInterface> a11 = e.a(this.f27804d).a();
            while (a11.hasMoreElements()) {
                Enumeration<InetAddress> a12 = e.a(this.f27804d).a(a11.nextElement());
                while (true) {
                    if (a12.hasMoreElements()) {
                        InetAddress nextElement = a12.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress();
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }

    public ArrayList<HashMap<String, String>> O() {
        return i(false);
    }

    public ArrayList<HashMap<String, String>> P() {
        ArrayList<HashMap<String, String>> a11;
        synchronized ("gsl") {
            a11 = this.f27805e.a(i(false), 2);
        }
        return a11;
    }

    public String Q() {
        return (String) b("deky", new a<String>((String) null) {
            public long a(String str) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.a(false);
            }
        });
    }

    public String R() {
        return (String) b("scph", new a<String>((String) null) {
            public long a(String str) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.t();
            }
        });
    }

    public String S() {
        return this.f27805e.b(T());
    }

    public String T() {
        return (String) b("pne", new a<String>((String) null) {
            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.o();
            }
        });
    }

    public String U() {
        return this.f27805e.p();
    }

    public int V() {
        return this.f27805e.q();
    }

    public String W() {
        return this.f27805e.r();
    }

    public boolean X() {
        return ((Boolean) a("imp", new a<Boolean>(Boolean.FALSE) {
            /* renamed from: a */
            public Boolean b() throws Throwable {
                return Boolean.valueOf(i.this.f27805e.X());
            }
        })).booleanValue();
    }

    public String Y() {
        return (String) a("cpne", new a<String>((String) null) {
            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.Y();
            }
        });
    }

    public boolean Z() {
        return x.a();
    }

    public Context aa() {
        return (Context) a("galct", new a<Context>((Context) null) {
            /* renamed from: a */
            public Context b() throws Throwable {
                if (i.this.f27804d != null) {
                    return i.this.f27804d;
                }
                Context x11 = b.x();
                if (x11 != null) {
                    Context unused = i.this.f27804d = x11;
                }
                return x11;
            }
        });
    }

    public String ab() {
        return this.f27805e.d();
    }

    public String ac() {
        return this.f27805e.e();
    }

    public long ad() {
        return this.f27805e.Z();
    }

    public String ae() {
        return (String) b("dvcnm", new a<String>((String) null) {
            public long a(String str) {
                return Period.MIN60_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.aa();
            }
        });
    }

    public String af() {
        return (String) b("cgrp", new a<String>((String) null) {
            public long a(String str) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.ab();
            }
        });
    }

    public String ag() {
        return (String) b("cinfo", new a<String>((String) null) {
            public long a(String str) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.ac();
            }
        });
    }

    public String ah() {
        if (!CSCenter.getInstance().isOaidEnable()) {
            return CSCenter.getInstance().getOaid();
        }
        if (d.a()) {
            return (String) b("odmt", new a<String>((String) null) {
                public long a(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return -1;
                    }
                    return Period.WEEK_MILLS;
                }

                /* renamed from: a */
                public String b() throws Throwable {
                    return i.this.f27805e.ad();
                }
            });
        }
        return null;
    }

    public String ai() {
        String ah2 = c.a(this.f27804d).d().ah();
        if (!TextUtils.isEmpty(ah2)) {
            try {
                return Base64.encodeToString(Data.AES128Encode(Data.MD5(DH.SyncMtd.getManufacturer()), ah2), 2);
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        return ah2;
    }

    public HashMap<String, Object> aj() {
        return (HashMap) b("alldmt", new a<HashMap<String, Object>>((HashMap) null) {
            public long a(HashMap<String, Object> hashMap) {
                return Period.DAY_MILLS;
            }

            /* renamed from: a */
            public HashMap<String, Object> b() throws Throwable {
                return i.this.f27805e.ae();
            }
        });
    }

    public ApplicationInfo ak() {
        final boolean a11 = c.a("1009", this.f27804d.getPackageName());
        return (ApplicationInfo) b("gtaif", new a<ApplicationInfo>((ApplicationInfo) null) {
            public long a(ApplicationInfo applicationInfo) {
                if (a11) {
                    return 0;
                }
                return Period.DAY_MILLS;
            }

            /* renamed from: a */
            public ApplicationInfo b() throws Throwable {
                return e.a(i.this.f27804d).d();
            }
        }, a(a11, "gtaif", T()));
    }

    public ArrayList<HashMap<String, Object>> al() {
        return (ArrayList) b("gtwflok", new a<ArrayList<HashMap<String, Object>>>((ArrayList) null) {
            public long a(ArrayList<HashMap<String, Object>> arrayList) {
                return 180000;
            }

            /* renamed from: a */
            public ArrayList<HashMap<String, Object>> b() throws Throwable {
                Boolean bool;
                if (!d.d() || !i.this.e(s.a("036de1dcdjdkdidcdlDjf6djdfdififididk*e=dledfkfdegidgidhgfeegceedhelfcfdfcgi")) || !i.this.e(s.a("036de$dcdjdkdidcdlCjfNdjdfdififididk8eRdlfdededgieleldhgfeegceedhelfcfdfcgi"))) {
                    return null;
                }
                LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
                i.this.f27805e.a((BlockingQueue<Boolean>) linkedBlockingQueue);
                i.this.f27805e.A();
                try {
                    bool = (Boolean) linkedBlockingQueue.poll(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, TimeUnit.MILLISECONDS);
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                    bool = null;
                }
                if (bool == null || !bool.booleanValue()) {
                    return null;
                }
                return i.this.f27805e.z();
            }
        });
    }

    public long am() {
        return ((Long) b("gtbdt", new a<Long>(0L) {
            public long a(Long l11) {
                return Period.MIN60_MILLS;
            }

            /* renamed from: a */
            public Long b() throws Throwable {
                return Long.valueOf(i.this.f27805e.af());
            }
        })).longValue();
    }

    public double an() {
        return ((Double) b("gtscnin", new a<Double>(Double.valueOf(0.0d)) {
            public long a(Double d11) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public Double b() throws Throwable {
                return Double.valueOf(i.this.f27805e.ag());
            }
        })).doubleValue();
    }

    public int ao() {
        return ((Integer) b("gtscnppi", new a<Integer>(0) {
            public long a(Integer num) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public Integer b() throws Throwable {
                return Integer.valueOf(i.this.f27805e.ah());
            }
        })).intValue();
    }

    public boolean ap() {
        return ((Boolean) b("ishmos", new a<Boolean>(Boolean.FALSE) {
            public long a(Boolean bool) {
                return Period.MIN60_MILLS;
            }

            /* renamed from: a */
            public Boolean b() throws Throwable {
                return Boolean.valueOf(i.this.f27805e.ai());
            }
        })).booleanValue();
    }

    public String aq() {
        return (String) b("gthmosv", new a<String>((String) null) {
            public long a(String str) {
                return Period.MIN60_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.aj();
            }
        });
    }

    public String ar() {
        return (String) b("gthmosdtlv", new a<String>((String) null) {
            public long a(String str) {
                return Period.MIN60_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.ak();
            }
        });
    }

    public int as() {
        return ((Integer) b("hmpmst", new a<Integer>(-1) {
            public long a(Integer num) {
                return 180000;
            }

            /* renamed from: a */
            public Integer b() throws Throwable {
                return Integer.valueOf(i.this.f27805e.al());
            }
        })).intValue();
    }

    public int at() {
        return ((Integer) b("hmepmst", new a<Integer>(-1) {
            public long a(Integer num) {
                return 180000;
            }

            /* renamed from: a */
            public Integer b() throws Throwable {
                return Integer.valueOf(i.this.f27805e.am());
            }
        })).intValue();
    }

    public String au() {
        return (String) b("gtinnerlangmt", new a<String>((String) null) {
            public long a(String str) {
                return Period.DAY_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.ao();
            }
        });
    }

    public int av() {
        return ((Integer) b("gtgramgendt", new a<Integer>(0) {
            public long a(Integer num) {
                return Period.DAY_MILLS;
            }

            /* renamed from: a */
            public Integer b() throws Throwable {
                return Integer.valueOf(i.this.f27805e.ap());
            }
        })).intValue();
    }

    public boolean aw() {
        return ((Boolean) a("debbing", new a<Boolean>(Boolean.FALSE) {
            public long a(Boolean bool) {
                return 60000;
            }

            /* renamed from: a */
            public Boolean b() throws Throwable {
                return Boolean.valueOf(i.this.f27805e.as());
            }
        })).booleanValue();
    }

    public ArrayList<HashMap<String, Object>> ax() {
        return (ArrayList) b("gteacifo", new a<ArrayList<HashMap<String, Object>>>((ArrayList) null) {
            public long a(ArrayList<HashMap<String, Object>> arrayList) {
                return 180000;
            }

            /* renamed from: a */
            public ArrayList<HashMap<String, Object>> b() throws Throwable {
                return i.this.f27805e.ar();
            }
        });
    }

    public boolean c() {
        return ((Boolean) b("pd0", new a<Boolean>(Boolean.FALSE) {
            public long a(Boolean bool) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public Boolean b() {
                return Boolean.valueOf(i.this.f27805e.I());
            }
        })).booleanValue();
    }

    public boolean d() {
        return ((Boolean) a("dee", new a<Boolean>(Boolean.FALSE) {
            /* renamed from: a */
            public Boolean b() {
                return Boolean.valueOf(i.this.f27805e.N());
            }
        })).booleanValue();
    }

    public boolean e() {
        return this.f27805e.M();
    }

    public boolean f() {
        return ((Boolean) a("ua0", new a<Boolean>(Boolean.FALSE) {
            public long a(Boolean bool) {
                return 180000;
            }

            /* renamed from: a */
            public Boolean b() {
                return Boolean.valueOf(i.this.f27805e.L());
            }
        })).booleanValue();
    }

    public boolean g() {
        return ((Boolean) a("dee1", new a<Boolean>(Boolean.FALSE) {
            public long a(Boolean bool) {
                return 180000;
            }

            /* renamed from: a */
            public Boolean b() {
                return Boolean.valueOf(i.this.f27805e.K());
            }
        })).booleanValue();
    }

    public boolean h() {
        return ((Boolean) a("uee", new a<Boolean>(Boolean.FALSE) {
            public long a(Boolean bool) {
                return 180000;
            }

            /* renamed from: a */
            public Boolean b() {
                return Boolean.valueOf(i.this.f27805e.J());
            }
        })).booleanValue();
    }

    public boolean i() {
        return ((Boolean) a("wpy", new a<Boolean>(Boolean.FALSE) {
            public long a(Boolean bool) {
                return 180000;
            }

            /* renamed from: a */
            public Boolean b() {
                return Boolean.valueOf(i.this.f27805e.O());
            }
        })).booleanValue();
    }

    public String j() {
        return (String) b("agi", new a<String>((String) null) {
            public long a(String str) {
                return Period.DAY_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.u();
            }
        });
    }

    public String k() {
        return (String) b("mvn", new a<String>((String) null) {
            public long a(String str) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.G();
            }
        });
    }

    public String l() {
        return (String) b("mol", new a<String>((String) null) {
            public long a(String str) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.b();
            }
        });
    }

    public String m() {
        return (String) b("mar", new a<String>((String) null) {
            public long a(String str) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.c();
            }
        });
    }

    public String n() {
        return (String) b("brd", new a<String>((String) null) {
            public long a(String str) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.W();
            }
        });
    }

    public String o() {
        return (String) b("dte", new a<String>((String) null) {
            public long a(String str) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.w();
            }
        });
    }

    public Object p() {
        return b("gtecloc", new a<Object>((Object) null) {
            public long a(Object obj) {
                return 180000;
            }

            public Object b() throws Throwable {
                return i.this.f27805e.an();
            }
        });
    }

    public ArrayList<HashMap<String, Object>> q() {
        return (ArrayList) b("bsnbcl", new a<ArrayList<HashMap<String, Object>>>((ArrayList) null) {
            public long a(ArrayList<HashMap<String, Object>> arrayList) {
                return 180000;
            }

            /* renamed from: a */
            public ArrayList<HashMap<String, Object>> b() throws Throwable {
                return i.this.f27805e.v();
            }
        });
    }

    public HashMap<String, Object> r() {
        return e(false);
    }

    public int s() {
        return ((Integer) b("ovit", new a<Integer>(-1) {
            public long a(Integer num) {
                return Period.MIN60_MILLS;
            }

            /* renamed from: a */
            public Integer b() throws Throwable {
                return Integer.valueOf(i.this.f27805e.f());
            }
        })).intValue();
    }

    public String t() {
        return (String) b("ovne", new a<String>((String) null) {
            public long a(String str) {
                return Period.MIN60_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.g();
            }
        });
    }

    public String u() {
        return (String) b("ole", new a<String>((String) null) {
            public long a(String str) {
                return Period.MIN60_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.h();
            }
        });
    }

    public String v() {
        return (String) b("ocy", new a<String>((String) null) {
            public long a(String str) {
                return Period.MIN60_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.j();
            }
        });
    }

    public HashMap<String, Object> w() {
        return (HashMap) b("cio0", new a<HashMap<String, Object>>((HashMap) null) {
            public long a(HashMap<String, Object> hashMap) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public HashMap<String, Object> b() throws Throwable {
                return i.this.f27805e.B();
            }
        });
    }

    public ArrayList<ArrayList<String>> x() {
        return (ArrayList) b("tdio", new a<ArrayList<ArrayList<String>>>((ArrayList) null) {
            public long a(ArrayList<ArrayList<String>> arrayList) {
                return Period.DAY_MILLS;
            }

            /* renamed from: a */
            public ArrayList<ArrayList<String>> b() throws Throwable {
                return i.this.f27805e.C();
            }
        });
    }

    public String y() {
        return (String) b("qkl", new a<String>((String) null) {
            public long a(String str) {
                return "0".equals(str) ? Period.DAY_MILLS : Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.D();
            }
        });
    }

    public HashMap<String, HashMap<String, Long>> z() {
        return (HashMap) b("siio", new a<HashMap<String, HashMap<String, Long>>>((HashMap) null) {
            public long a(HashMap<String, HashMap<String, Long>> hashMap) {
                return Period.DAY_MILLS;
            }

            /* renamed from: a */
            public HashMap<String, HashMap<String, Long>> b() throws Throwable {
                return i.this.f27805e.E();
            }
        });
    }

    private ArrayList<HashMap<String, String>> i(boolean z11) {
        ArrayList<HashMap<String, String>> arrayList;
        synchronized ("gal") {
            arrayList = (ArrayList) b("gal", new a<ArrayList<HashMap<String, String>>>((ArrayList) null) {
                public long a(ArrayList<HashMap<String, String>> arrayList) {
                    Calendar instance = Calendar.getInstance();
                    long a11 = i.this.a(instance) - instance.getTimeInMillis();
                    return a11 > 0 ? a11 : Period.DAY_MILLS;
                }

                /* renamed from: a */
                public ArrayList<HashMap<String, String>> b() throws Throwable {
                    return i.this.f27805e.s();
                }
            }, z11);
        }
        return arrayList;
    }

    public boolean b() {
        return ((Boolean) b("cx0", new a<Boolean>(Boolean.FALSE) {
            public long a(Boolean bool) {
                if (bool == null || !bool.booleanValue()) {
                    return 180000;
                }
                return Period.DAY_MILLS;
            }

            /* renamed from: a */
            public Boolean b() {
                return Boolean.valueOf(i.this.f27805e.H());
            }
        })).booleanValue();
    }

    public String c(boolean z11) {
        return (String) b("car", new a<String>((String) null) {
            public long a(String str) {
                return 600000;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.l();
            }
        }, z11);
    }

    public String d(boolean z11) {
        return (String) b("cne", new a<String>((String) null) {
            public long a(String str) {
                return 600000;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.m();
            }
        }, z11);
    }

    public HashMap<String, Object> e(boolean z11) {
        return (HashMap) b("crtwfo", new a<HashMap<String, Object>>((HashMap) null) {
            public long a(HashMap<String, Object> hashMap) {
                return 180000;
            }

            /* renamed from: a */
            public HashMap<String, Object> b() throws Throwable {
                return i.this.f27805e.y();
            }
        }, z11);
    }

    public String f(boolean z11) {
        return (String) b("nte", new a<String>((String) null) {
            public long a(String str) {
                return 180000;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return i.this.f27805e.n();
            }
        }, z11);
    }

    public String g(boolean z11) {
        return this.f27805e.a(z11);
    }

    public String h(boolean z11) {
        return (String) b("gtdm", new a<String>((String) null) {
            public long a(String str) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public String b() throws Throwable {
                return y.a().h();
            }
        }, z11);
    }

    private long g(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = null;
            ApplicationInfo a11 = a(true, str, 0);
            if (a11 != null) {
                str2 = a11.sourceDir;
            }
            if (!TextUtils.isEmpty(str2)) {
                return new File(str2).lastModified();
            }
        }
        return 0;
    }

    public String b(boolean z11) {
        HashMap<String, Object> e11 = e(z11);
        if (e11 != null) {
            return (String) e11.get("bsmt");
        }
        return null;
    }

    public String c(String str) {
        return this.f27805e.b(str);
    }

    public String d(String str) {
        return this.f27805e.c(str);
    }

    public boolean e(String str) {
        try {
            return this.f27805e.d(str);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return false;
        }
    }

    public long f(final String str) {
        return ((Long) b("gtlstact-" + str, new a<Long>(-1L) {
            public long a(Long l11) {
                return Period.WEEK_MILLS;
            }

            /* renamed from: a */
            public Long b() throws Throwable {
                return Long.valueOf(FileUtils.getLATime(str));
            }
        })).longValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Class<java.lang.String>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T c(java.lang.String r7, com.mob.tools.b.i.a<T> r8) throws com.mob.tools.utils.MobPersistence.NoValidDataException {
        /*
            r6 = this;
            java.lang.reflect.Type r0 = r6.a(r8)
            int r1 = r6.a((java.lang.reflect.Type) r0)
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x0028
            java.lang.reflect.GenericArrayType r0 = (java.lang.reflect.GenericArrayType) r0     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.reflect.Type r0 = r0.getGenericComponentType()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            com.mob.tools.utils.h r1 = com.mob.tools.utils.h.a()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            T r8 = r8.f27889g     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            android.os.Parcelable[] r8 = (android.os.Parcelable[]) r8     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            android.os.Parcelable[] r7 = r1.a((java.lang.String) r7, r0, (T[]) r8)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            goto L_0x0138
        L_0x0022:
            r7 = move-exception
            goto L_0x013a
        L_0x0025:
            r7 = move-exception
            goto L_0x0142
        L_0x0028:
            r4 = 2
            if (r1 == r4) goto L_0x012e
            r5 = 4
            if (r1 != r5) goto L_0x0030
            goto L_0x012e
        L_0x0030:
            r5 = 3
            if (r1 != r5) goto L_0x0086
            java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.reflect.Type r8 = r0.getRawType()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.Class r8 = (java.lang.Class) r8     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.reflect.Type[] r0 = r0.getActualTypeArguments()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            r1 = 0
            r1 = r0[r1]     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            int r5 = r0.length     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            if (r5 != r4) goto L_0x0047
            r1 = r0[r2]     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
        L_0x0047:
            boolean r0 = r1 instanceof java.lang.Class     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            if (r0 == 0) goto L_0x0141
            java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.Class<android.os.Parcelable> r0 = android.os.Parcelable.class
            boolean r0 = r0.isAssignableFrom(r1)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            if (r0 == 0) goto L_0x0141
            java.lang.Class<java.util.List> r0 = java.util.List.class
            if (r8 == r0) goto L_0x007c
            java.lang.Class<java.util.LinkedList> r0 = java.util.LinkedList.class
            if (r8 == r0) goto L_0x007c
            java.lang.Class<java.util.ArrayList> r0 = java.util.ArrayList.class
            if (r8 != r0) goto L_0x0062
            goto L_0x007c
        L_0x0062:
            java.lang.Class<java.util.Map> r0 = java.util.Map.class
            if (r8 == r0) goto L_0x0072
            java.lang.Class<java.util.HashMap> r0 = java.util.HashMap.class
            if (r8 == r0) goto L_0x0072
            java.lang.Class<java.util.TreeMap> r0 = java.util.TreeMap.class
            if (r8 == r0) goto L_0x0072
            java.lang.Class<java.util.Hashtable> r0 = java.util.Hashtable.class
            if (r8 != r0) goto L_0x0141
        L_0x0072:
            com.mob.tools.utils.h r8 = com.mob.tools.utils.h.a()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.util.Map r3 = r8.b((java.lang.String) r7, r1)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            goto L_0x0141
        L_0x007c:
            com.mob.tools.utils.h r8 = com.mob.tools.utils.h.a()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.util.List r3 = r8.c(r7, r1)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            goto L_0x0141
        L_0x0086:
            r2 = 9
            if (r1 != r2) goto L_0x0123
            java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            if (r0 == 0) goto L_0x0141
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            if (r0 != r1) goto L_0x00a8
            com.mob.tools.utils.h r0 = com.mob.tools.utils.h.a()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            T r8 = r8.f27889g     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            int r8 = r8.intValue()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            int r7 = r0.b((java.lang.String) r7, (int) r8)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            goto L_0x0141
        L_0x00a8:
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            if (r0 != r1) goto L_0x00c2
            com.mob.tools.utils.h r0 = com.mob.tools.utils.h.a()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            T r8 = r8.f27889g     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            long r1 = r8.longValue()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            long r7 = r0.a((java.lang.String) r7, (long) r1)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.Long r3 = java.lang.Long.valueOf(r7)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            goto L_0x0141
        L_0x00c2:
            java.lang.Class<java.lang.Double> r1 = java.lang.Double.class
            if (r0 != r1) goto L_0x00db
            com.mob.tools.utils.h r0 = com.mob.tools.utils.h.a()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            T r8 = r8.f27889g     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.Double r8 = (java.lang.Double) r8     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            double r1 = r8.doubleValue()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            double r7 = r0.a((java.lang.String) r7, (double) r1)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.Double r3 = java.lang.Double.valueOf(r7)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            goto L_0x0141
        L_0x00db:
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            if (r0 != r1) goto L_0x00f4
            com.mob.tools.utils.h r0 = com.mob.tools.utils.h.a()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            T r8 = r8.f27889g     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            boolean r8 = r8.booleanValue()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            boolean r7 = r0.a((java.lang.String) r7, (boolean) r8)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r7)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            goto L_0x0141
        L_0x00f4:
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            if (r0 != r1) goto L_0x0105
            com.mob.tools.utils.h r0 = com.mob.tools.utils.h.a()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            T r8 = r8.f27889g     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.String r3 = r0.b((java.lang.String) r7, (java.lang.String) r8)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            goto L_0x0141
        L_0x0105:
            java.lang.Class<android.os.Parcelable> r1 = android.os.Parcelable.class
            boolean r1 = r1.isAssignableFrom(r0)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            if (r1 == 0) goto L_0x0118
            com.mob.tools.utils.h r1 = com.mob.tools.utils.h.a()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            T r8 = r8.f27889g     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.Object r3 = r1.a((java.lang.String) r7, r0, r8)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            goto L_0x0141
        L_0x0118:
            com.mob.tools.utils.h r0 = com.mob.tools.utils.h.a()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            T r8 = r8.f27889g     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.Object r3 = r0.b((java.lang.String) r7, (java.lang.Object) r8)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            goto L_0x0141
        L_0x0123:
            com.mob.tools.utils.h r0 = com.mob.tools.utils.h.a()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            T r8 = r8.f27889g     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.Object r7 = r0.b((java.lang.String) r7, (java.lang.Object) r8)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            goto L_0x0138
        L_0x012e:
            com.mob.tools.utils.h r0 = com.mob.tools.utils.h.a()     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            T r8 = r8.f27889g     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
            java.lang.Object r7 = r0.b((java.lang.String) r7, (java.lang.Object) r8)     // Catch:{ NoValidDataException -> 0x0025, all -> 0x0022 }
        L_0x0138:
            r3 = r7
            goto L_0x0141
        L_0x013a:
            com.mob.tools.log.NLog r8 = com.mob.tools.MobLog.getInstance()
            r8.d(r7)
        L_0x0141:
            return r3
        L_0x0142:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.i.c(java.lang.String, com.mob.tools.b.i$a):java.lang.Object");
    }

    public boolean a() {
        return ((Boolean) b("ird", new a<Boolean>(Boolean.FALSE) {
            public long a(Boolean bool) {
                if (bool == null || !bool.booleanValue()) {
                    return 180000;
                }
                return Period.DAY_MILLS;
            }

            /* renamed from: a */
            public Boolean b() {
                return Boolean.valueOf(i.this.f27805e.a());
            }
        })).booleanValue();
    }

    public String a(boolean z11) {
        HashMap<String, Object> e11 = e(z11);
        if (e11 != null) {
            return (String) e11.get("ssmt");
        }
        return null;
    }

    public boolean b(String str) {
        return this.f27805e.e(str);
    }

    public ResolveInfo b(Intent intent, int i11) {
        return e.a(this.f27804d).b(intent, i11);
    }

    public ArrayList<HashMap<String, String>> a(boolean z11, boolean z12) {
        synchronized ("giafce") {
            ArrayList<HashMap<String, String>> i11 = i(z12);
            if (z11) {
                ArrayList<HashMap<String, String>> a11 = this.f27805e.a(i11, 0);
                return a11;
            }
            ArrayList<HashMap<String, String>> a12 = this.f27805e.a(i11, 1);
            return a12;
        }
    }

    public Object b(boolean z11, int i11, String str, int i12) {
        return b(z11, i11, str, i12, false);
    }

    private PackageInfo b(boolean z11, int i11, String str, int i12, boolean z12) {
        if (!str.equals(DH.SyncMtd.getPackageName())) {
            return a(z11, i11, str, i12, z12);
        }
        int i13 = (i12 == 0 || i12 == 1 || i12 == 128 || i12 == 64) ? 193 : i12;
        PackageInfo a11 = a(z11, i11, str, i13, z12);
        return (a11 == null && i13 == 193) ? a(z11, i11, str, i12, z12) : a11;
    }

    public Location a(int i11, int i12, boolean z11) {
        List a11 = a(i11, i12, z11, false);
        if (a11 == null || a11.isEmpty()) {
            return null;
        }
        return (Location) a11.get(a11.size() - 1);
    }

    private <T> T b(String str, a<T> aVar) {
        return b(str, aVar, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T b(java.lang.String r13, com.mob.tools.b.i.a<T> r14, boolean r15) {
        /*
            r12 = this;
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x00be }
            java.lang.String r2 = "F|A, key: "
            if (r1 == 0) goto L_0x0021
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x00be }
            r15.<init>()     // Catch:{ all -> 0x00be }
            r15.append(r2)     // Catch:{ all -> 0x00be }
            r15.append(r13)     // Catch:{ all -> 0x00be }
            java.lang.String r13 = r15.toString()     // Catch:{ all -> 0x00be }
            r12.h((java.lang.String) r13)     // Catch:{ all -> 0x00be }
            java.lang.Object r13 = r14.b()     // Catch:{ all -> 0x00be }
            goto L_0x0137
        L_0x0021:
            r1 = 1
            r3 = 0
            if (r15 != 0) goto L_0x004b
            java.lang.Object r4 = r12.c(r13, r14)     // Catch:{ NoValidDataException -> 0x0049, all -> 0x003f }
            boolean r5 = r12.a((java.lang.Object) r4)     // Catch:{ NoValidDataException -> 0x004d, all -> 0x003d }
            if (r5 == 0) goto L_0x0038
            java.util.Set<java.lang.String> r5 = r12.f27806f     // Catch:{ NoValidDataException -> 0x004d, all -> 0x003d }
            boolean r5 = r5.contains(r13)     // Catch:{ NoValidDataException -> 0x004d, all -> 0x003d }
            if (r5 != 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r1 = r3
        L_0x0039:
            r11 = r3
            r3 = r1
            r1 = r11
            goto L_0x004d
        L_0x003d:
            r1 = move-exception
            goto L_0x0041
        L_0x003f:
            r1 = move-exception
            r4 = r0
        L_0x0041:
            com.mob.tools.log.NLog r5 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x00bb }
            r5.d(r1)     // Catch:{ all -> 0x00bb }
            goto L_0x004c
        L_0x0049:
            r4 = r0
            goto L_0x004d
        L_0x004b:
            r4 = r0
        L_0x004c:
            r1 = r3
        L_0x004d:
            if (r15 != 0) goto L_0x006b
            if (r1 != 0) goto L_0x006b
            if (r3 == 0) goto L_0x0054
            goto L_0x006b
        L_0x0054:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bb }
            r15.<init>()     // Catch:{ all -> 0x00bb }
            java.lang.String r0 = "F|C, key: "
            r15.append(r0)     // Catch:{ all -> 0x00bb }
            r15.append(r13)     // Catch:{ all -> 0x00bb }
            java.lang.String r13 = r15.toString()     // Catch:{ all -> 0x00bb }
            r12.h((java.lang.String) r13)     // Catch:{ all -> 0x00bb }
            r13 = r4
            goto L_0x0137
        L_0x006b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bb }
            r5.<init>()     // Catch:{ all -> 0x00bb }
            r5.append(r2)     // Catch:{ all -> 0x00bb }
            r5.append(r13)     // Catch:{ all -> 0x00bb }
            java.lang.String r2 = "|"
            r5.append(r2)     // Catch:{ all -> 0x00bb }
            if (r15 == 0) goto L_0x0080
            java.lang.String r0 = "FC"
            goto L_0x008d
        L_0x0080:
            if (r1 == 0) goto L_0x0085
            java.lang.String r0 = "NVC"
            goto L_0x008d
        L_0x0085:
            if (r3 == 0) goto L_0x008d
            java.lang.String r15 = "002Neggj"
            java.lang.String r0 = com.mob.commons.s.a((java.lang.String) r15)     // Catch:{ all -> 0x00bb }
        L_0x008d:
            r5.append(r0)     // Catch:{ all -> 0x00bb }
            java.lang.String r15 = r5.toString()     // Catch:{ all -> 0x00bb }
            r12.h((java.lang.String) r15)     // Catch:{ all -> 0x00bb }
            java.lang.Object r0 = r14.b()     // Catch:{ all -> 0x00bb }
            java.util.Set<java.lang.String> r15 = r12.f27806f     // Catch:{ all -> 0x00be }
            r15.add(r13)     // Catch:{ all -> 0x00be }
            long r1 = r14.a(r0)     // Catch:{ all -> 0x00be }
            r3 = 0
            int r15 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r15 < 0) goto L_0x0136
            if (r15 <= 0) goto L_0x00b1
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00be }
            long r3 = r3 + r1
        L_0x00b1:
            r8 = r3
            r5 = r12
            r6 = r13
            r7 = r0
            r10 = r14
            r5.a((java.lang.String) r6, r7, (long) r8, r10)     // Catch:{ all -> 0x00be }
            goto L_0x0136
        L_0x00bb:
            r13 = move-exception
            r0 = r4
            goto L_0x00bf
        L_0x00be:
            r13 = move-exception
        L_0x00bf:
            boolean r15 = r13 instanceof java.lang.reflect.InvocationTargetException
            java.lang.String r1 = ": "
            java.lang.String r2 = "Exception: "
            if (r15 == 0) goto L_0x0102
            java.lang.Class r15 = r13.getClass()
            java.lang.String r15 = r15.getName()
            java.lang.String r3 = r13.getMessage()
            java.lang.Throwable r13 = r13.getCause()
            if (r13 == 0) goto L_0x00e5
            java.lang.Class r15 = r13.getClass()
            java.lang.String r15 = r15.getName()
            java.lang.String r3 = r13.getMessage()
        L_0x00e5:
            com.mob.tools.log.NLog r13 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r15)
            r4.append(r1)
            r4.append(r3)
            java.lang.String r15 = r4.toString()
            r13.w((java.lang.String) r15)
            goto L_0x0136
        L_0x0102:
            boolean r15 = r13 instanceof android.content.pm.PackageManager.NameNotFoundException
            if (r15 == 0) goto L_0x012f
            com.mob.tools.log.NLog r15 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.Class r2 = r13.getClass()
            java.lang.String r2 = r2.getName()
            r3.append(r2)
            r3.append(r1)
            java.lang.String r13 = r13.getMessage()
            r3.append(r13)
            java.lang.String r13 = r3.toString()
            r15.w((java.lang.String) r13)
            goto L_0x0136
        L_0x012f:
            com.mob.tools.log.NLog r15 = com.mob.tools.MobLog.getInstance()
            r15.w((java.lang.Throwable) r13)
        L_0x0136:
            r13 = r0
        L_0x0137:
            if (r13 != 0) goto L_0x013b
            T r13 = r14.f27889g
        L_0x013b:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.i.b(java.lang.String, com.mob.tools.b.i$a, boolean):java.lang.Object");
    }

    public String a(String str) {
        return this.f27805e.a(str);
    }

    public List<ResolveInfo> a(Intent intent, int i11) {
        return e.a(this.f27804d).a(intent, i11);
    }

    public PackageInfo a(boolean z11, int i11, String str, int i12) {
        return b(z11, i11, str, i12, true);
    }

    private PackageInfo a(boolean z11, int i11, String str, int i12, boolean z12) {
        boolean z13;
        int i13 = i11;
        String str2 = str;
        int i14 = i12;
        boolean z14 = z12;
        boolean a11 = c.a("1009", str2);
        final boolean z15 = a11;
        final int i15 = i11;
        final String str3 = str;
        AnonymousClass40 r16 = r0;
        final int i16 = i12;
        String str4 = "gpi-" + i13 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i14 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + z14;
        final boolean z16 = z12;
        AnonymousClass40 r02 = new a<PackageInfo>((PackageInfo) null) {
            public long a(PackageInfo packageInfo) {
                return z15 ? (long) i15 : Period.DAY_MILLS;
            }

            /* renamed from: a */
            public PackageInfo b() throws Throwable {
                return (PackageInfo) e.a(i.this.f27804d).a(str3, i16, z16);
            }
        };
        if (!z11) {
            if (!a(a11, "gpi-" + i13 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i14 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + z14, str2)) {
                z13 = false;
                return (PackageInfo) b(str4, r16, z13);
            }
        }
        z13 = true;
        return (PackageInfo) b(str4, r16, z13);
    }

    public ApplicationInfo a(String str, int i11) {
        return a(false, str, i11);
    }

    public ApplicationInfo a(boolean z11, String str, int i11) {
        boolean z12;
        boolean a11 = c.a("1009", str);
        String str2 = "gtaiffce-" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i11;
        final boolean z13 = a11;
        final String str3 = str;
        final int i12 = i11;
        AnonymousClass49 r12 = new a<ApplicationInfo>((ApplicationInfo) null) {
            public long a(ApplicationInfo applicationInfo) {
                if (z13) {
                    return 0;
                }
                return Period.DAY_MILLS;
            }

            /* renamed from: a */
            public ApplicationInfo b() throws Throwable {
                return e.a(i.this.f27804d).a(str3, i12);
            }
        };
        if (!z11) {
            if (!a(a11, "gtaiffce-" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i11, str)) {
                z12 = false;
                return (ApplicationInfo) b(str2, r12, z12);
            }
        }
        z12 = true;
        return (ApplicationInfo) b(str2, r12, z12);
    }

    public List a(int i11, int i12, boolean z11, boolean z12) {
        final int i13 = i11;
        final int i14 = i12;
        final boolean z13 = z11;
        final boolean z14 = z12;
        return (List) b("gtelcmefce-" + i11 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i12 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + z11, new a<List<Location>>((List) null) {
            public long a(List<Location> list) {
                return 180000;
            }

            /* renamed from: a */
            public List<Location> b() throws Throwable {
                return i.this.f27805e.a(i13, i14, z13, z14);
            }
        }, z12);
    }

    private boolean a(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == -1) {
                return true;
            }
        } else if (obj instanceof Long) {
            if (((Long) obj).longValue() == -1) {
                return true;
            }
        } else if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        } else {
            if (obj instanceof Collection) {
                return ((Collection) obj).isEmpty();
            }
        }
        return false;
    }

    private <T> T a(String str, a<T> aVar) {
        return a(str, aVar, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T a(java.lang.String r12, com.mob.tools.b.i.a<T> r13, boolean r14) {
        /*
            r11 = this;
            java.lang.String r0 = "M|A, key: "
            r1 = 0
            if (r12 != 0) goto L_0x001d
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fa }
            r14.<init>()     // Catch:{ all -> 0x00fa }
            r14.append(r0)     // Catch:{ all -> 0x00fa }
            r14.append(r12)     // Catch:{ all -> 0x00fa }
            java.lang.String r12 = r14.toString()     // Catch:{ all -> 0x00fa }
            r11.h((java.lang.String) r12)     // Catch:{ all -> 0x00fa }
            java.lang.Object r12 = r13.b()     // Catch:{ all -> 0x00fa }
            goto L_0x0134
        L_0x001d:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r2 = r11.f27802b     // Catch:{ all -> 0x00fa }
            java.lang.Object r2 = r2.get(r12)     // Catch:{ all -> 0x00fa }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x00fa }
            if (r2 == 0) goto L_0x0034
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r3 = r11.f27801a     // Catch:{ all -> 0x00fa }
            java.lang.Object r3 = r3.get(r12)     // Catch:{ all -> 0x00fa }
            if (r3 != 0) goto L_0x0035
            if (r14 != 0) goto L_0x0035
            T r12 = r13.f27889g     // Catch:{ all -> 0x00f7 }
            return r12
        L_0x0034:
            r3 = r1
        L_0x0035:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r4 = r11.f27803c     // Catch:{ all -> 0x00f7 }
            java.lang.Object r4 = r4.get(r12)     // Catch:{ all -> 0x00f7 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ all -> 0x00f7 }
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x004f
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00f7 }
            long r9 = r4.longValue()     // Catch:{ all -> 0x00f7 }
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 < 0) goto L_0x004f
            r4 = r6
            goto L_0x0050
        L_0x004f:
            r4 = r5
        L_0x0050:
            if (r4 != 0) goto L_0x0061
            boolean r7 = r11.a((java.lang.Object) r3)     // Catch:{ all -> 0x00f7 }
            if (r7 == 0) goto L_0x0061
            java.util.Set<java.lang.String> r7 = r11.f27806f     // Catch:{ all -> 0x00f7 }
            boolean r7 = r7.contains(r12)     // Catch:{ all -> 0x00f7 }
            if (r7 != 0) goto L_0x0061
            r5 = r6
        L_0x0061:
            if (r14 != 0) goto L_0x0081
            if (r3 == 0) goto L_0x0081
            if (r4 != 0) goto L_0x0081
            if (r5 == 0) goto L_0x006a
            goto L_0x0081
        L_0x006a:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r14.<init>()     // Catch:{ all -> 0x00f7 }
            java.lang.String r0 = "M|C, key: "
            r14.append(r0)     // Catch:{ all -> 0x00f7 }
            r14.append(r12)     // Catch:{ all -> 0x00f7 }
            java.lang.String r12 = r14.toString()     // Catch:{ all -> 0x00f7 }
            r11.h((java.lang.String) r12)     // Catch:{ all -> 0x00f7 }
            r12 = r3
            goto L_0x0134
        L_0x0081:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r7.<init>()     // Catch:{ all -> 0x00f7 }
            r7.append(r0)     // Catch:{ all -> 0x00f7 }
            r7.append(r12)     // Catch:{ all -> 0x00f7 }
            java.lang.String r0 = "|"
            r7.append(r0)     // Catch:{ all -> 0x00f7 }
            if (r14 == 0) goto L_0x0096
            java.lang.String r1 = "FC"
            goto L_0x00a6
        L_0x0096:
            if (r3 == 0) goto L_0x00a4
            if (r4 == 0) goto L_0x009b
            goto L_0x00a4
        L_0x009b:
            if (r5 == 0) goto L_0x00a6
            java.lang.String r14 = "002@eggj"
            java.lang.String r1 = com.mob.commons.s.a((java.lang.String) r14)     // Catch:{ all -> 0x00f7 }
            goto L_0x00a6
        L_0x00a4:
            java.lang.String r1 = "NVC"
        L_0x00a6:
            r7.append(r1)     // Catch:{ all -> 0x00f7 }
            java.lang.String r14 = r7.toString()     // Catch:{ all -> 0x00f7 }
            r11.h((java.lang.String) r14)     // Catch:{ all -> 0x00f7 }
            java.lang.Object r1 = r13.b()     // Catch:{ all -> 0x00f7 }
            java.util.Set<java.lang.String> r14 = r11.f27806f     // Catch:{ all -> 0x00fa }
            r14.add(r12)     // Catch:{ all -> 0x00fa }
            if (r1 == 0) goto L_0x00dc
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r14 = r11.f27801a     // Catch:{ all -> 0x00fa }
            r14.put(r12, r1)     // Catch:{ all -> 0x00fa }
            long r3 = r13.a(r1)     // Catch:{ all -> 0x00fa }
            r7 = 0
            int r14 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r14 <= 0) goto L_0x00dc
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r14 = r11.f27803c     // Catch:{ all -> 0x00fa }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00fa }
            long r7 = r13.a(r1)     // Catch:{ all -> 0x00fa }
            long r3 = r3 + r7
            java.lang.Long r0 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x00fa }
            r14.put(r12, r0)     // Catch:{ all -> 0x00fa }
        L_0x00dc:
            if (r2 != 0) goto L_0x00e8
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r14 = r11.f27802b     // Catch:{ all -> 0x00fa }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00fa }
            r14.put(r12, r0)     // Catch:{ all -> 0x00fa }
            goto L_0x0133
        L_0x00e8:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r14 = r11.f27802b     // Catch:{ all -> 0x00fa }
            int r0 = r2.intValue()     // Catch:{ all -> 0x00fa }
            int r0 = r0 + r6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00fa }
            r14.put(r12, r0)     // Catch:{ all -> 0x00fa }
            goto L_0x0133
        L_0x00f7:
            r12 = move-exception
            r1 = r3
            goto L_0x00fb
        L_0x00fa:
            r12 = move-exception
        L_0x00fb:
            boolean r14 = r12 instanceof android.content.pm.PackageManager.NameNotFoundException
            if (r14 == 0) goto L_0x012c
            com.mob.tools.log.NLog r14 = com.mob.tools.MobLog.getInstance()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Exception: "
            r0.append(r2)
            java.lang.Class r2 = r12.getClass()
            java.lang.String r2 = r2.getName()
            r0.append(r2)
            java.lang.String r2 = ": "
            r0.append(r2)
            java.lang.String r12 = r12.getMessage()
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            r14.w((java.lang.String) r12)
            goto L_0x0133
        L_0x012c:
            com.mob.tools.log.NLog r14 = com.mob.tools.MobLog.getInstance()
            r14.w((java.lang.Throwable) r12)
        L_0x0133:
            r12 = r1
        L_0x0134:
            if (r12 != 0) goto L_0x0138
            T r12 = r13.f27889g
        L_0x0138:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.i.a(java.lang.String, com.mob.tools.b.i$a, boolean):java.lang.Object");
    }

    private <T> void a(String str, T t11, long j11, a<T> aVar) {
        try {
            Type a11 = a(aVar);
            int a12 = a(a11);
            if (a12 == 1) {
                h.a().a(str, (T[]) (Parcelable[]) t11, j11);
                return;
            }
            if (a12 != 2) {
                if (a12 != 4) {
                    if (a12 == 3) {
                        Class<Hashtable> cls = (Class) ((ParameterizedType) a11).getRawType();
                        if (!(cls == List.class || cls == LinkedList.class)) {
                            if (cls != ArrayList.class) {
                                if (cls == Map.class || cls == HashMap.class || cls == TreeMap.class || cls == Hashtable.class) {
                                    h.a().a(str, (Map) t11, j11);
                                    return;
                                }
                                return;
                            }
                        }
                        h.a().a(str, (List) t11, j11);
                        return;
                    } else if (a12 == 9) {
                        Class<String> cls2 = (Class) a11;
                        if (cls2 == null) {
                            return;
                        }
                        if (cls2 == Integer.class) {
                            h.a().a(str, (Integer) t11, j11);
                            return;
                        } else if (cls2 == Long.class) {
                            h.a().a(str, (Long) t11, j11);
                            return;
                        } else if (cls2 == Double.class) {
                            h.a().a(str, (Double) t11, j11);
                            return;
                        } else if (cls2 == Boolean.class) {
                            h.a().a(str, (Boolean) t11, j11);
                            return;
                        } else if (cls2 == String.class) {
                            h.a().a(str, (String) t11, j11);
                            return;
                        } else if (Parcelable.class.isAssignableFrom(cls2)) {
                            h.a().a(str, (Parcelable) t11, j11);
                            return;
                        } else {
                            h.a().a(str, (Object) t11, j11);
                            return;
                        }
                    } else {
                        h.a().a(str, (Object) t11, j11);
                        return;
                    }
                }
            }
            h.a().a(str, (Object) t11, j11);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
    }

    private <T> Type a(a<T> aVar) {
        try {
            return ((ParameterizedType) aVar.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    private int a(Type type) {
        if (type instanceof GenericArrayType) {
            return Parcelable.class.isAssignableFrom((Class) ((GenericArrayType) type).getGenericComponentType()) ? 1 : 2;
        } else if (!(type instanceof ParameterizedType)) {
            return 9;
        } else {
            try {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = (Class) parameterizedType.getRawType();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Type type2 = actualTypeArguments[0];
                if (actualTypeArguments.length == 2) {
                    type2 = actualTypeArguments[1];
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                    Class cls2 = (Class) parameterizedType2.getRawType();
                    Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                    Type type3 = actualTypeArguments2[0];
                    if (actualTypeArguments2.length == 2) {
                        type3 = actualTypeArguments2[1];
                    }
                    if (type3 instanceof Class) {
                        Class cls3 = (Class) type3;
                    }
                    return 4;
                } else if (!(type2 instanceof Class)) {
                    return -1;
                } else {
                    if (Parcelable.class.isAssignableFrom((Class) type2)) {
                        return 3;
                    }
                    return 4;
                }
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
                return -1;
            }
        }
    }

    /* access modifiers changed from: private */
    public long a(Calendar calendar) {
        calendar.add(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private boolean a(boolean z11, String str, String str2) {
        String str3 = "sdir_able_" + (TextUtils.equals(str2, DH.SyncMtd.getPackageName()) ? 1 : 0);
        if (h.a().a(str3, -1) != z11) {
            h.a().a(str3, Integer.valueOf(z11 ? 1 : 0));
            if (!z11) {
                return true;
            }
        }
        if (!z11 || TextUtils.isEmpty(str2)) {
            return false;
        }
        String str4 = "key_almdf-" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2;
        long c11 = h.a().c(str4);
        long g11 = g(str2);
        if (g11 == c11) {
            return false;
        }
        h.a().a(str4, Long.valueOf(g11));
        return true;
    }
}
