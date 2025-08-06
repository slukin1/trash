package com.mob.commons;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.commons.a;
import com.mob.tools.MobLog;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.SharePrefrenceHelper;
import com.mob.tools.utils.c;
import com.mob.tools.utils.e;
import com.mob.tools.utils.j;
import e7.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ab {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26987a = m.a("009_cf[d(cabfbabgch<bh");

    /* renamed from: b  reason: collision with root package name */
    public static final String f26988b = m.a("0109cf,dRcabfMc.beXhDbhPaBba");

    /* renamed from: c  reason: collision with root package name */
    public static final String f26989c = m.a("009NcfVdJcabf.c:beMebe");

    /* renamed from: d  reason: collision with root package name */
    public static final String f26990d = m.a("0105cf]dPcabfdgTcGbe[ebe");

    /* renamed from: e  reason: collision with root package name */
    public static final String f26991e = m.a("011OcfLdQcabf-hh'bfchbh;g'ba");

    /* renamed from: f  reason: collision with root package name */
    public static final String f26992f = m.a("0313cf9d+cabf'cd<cgCg1bfbe,he8bi bPbabfAbhh*bf(bagRbgbbKdAbf>g8bgbd@d");

    /* renamed from: g  reason: collision with root package name */
    public static final String f26993g = m.a("0251cf:d^cabfddbecdcd@dIbh2d babfVeObiVabg3bgbi0c'bfbdbafg");

    /* renamed from: h  reason: collision with root package name */
    public static final String f26994h = m.a("038BcfEdQcabf:cd]cg@g>bfbeQhe$bi<b2babfddbecdcdBdBbhFd!babfLe<bi%abgBbgbiVcIbf!gAbgbdUd");

    /* renamed from: i  reason: collision with root package name */
    public static final String f26995i = m.a("0142debgcdbgbfNeb4dgCg!bfbgUcCcdbi");

    /* renamed from: j  reason: collision with root package name */
    public static final String f26996j = m.a("018;cfZd2cabfdebgcdbgbfFe0bgdg(g+bfKfbGdg4f");

    /* renamed from: k  reason: collision with root package name */
    public static final String f26997k = m.a("030Tcf+d-cabfAcd$cg;g2bfbeKhe,bi7bPbabfdebgcdbgbf<e4bgdgPgVbf6gNbgbd@d");

    /* renamed from: l  reason: collision with root package name */
    public static final String f26998l = m.a("012,cf'dYcabfdgdebgZgafdNdg");

    /* renamed from: m  reason: collision with root package name */
    public static final String f26999m = m.a("022(cfHdIcabfdgdebg5gafdQdgbfFg;bgbd3d5dgUgb6bdEh");

    /* renamed from: n  reason: collision with root package name */
    private static final String f27000n = m.a("011>bdbiddbfTaBbibdbdbiBcQdg");

    /* renamed from: o  reason: collision with root package name */
    private static final String f27001o = m.a("019Icf3d4cabf$bhh]bf]bag^bgbb[d)bf-gKbgbdMd");

    /* renamed from: p  reason: collision with root package name */
    private static final String f27002p = m.a("012?cfPd^cabf7afbccde9dg");

    /* renamed from: q  reason: collision with root package name */
    private static AtomicBoolean f27003q = new AtomicBoolean(false);

    /* renamed from: r  reason: collision with root package name */
    private static AtomicBoolean f27004r = new AtomicBoolean(false);

    /* renamed from: s  reason: collision with root package name */
    private static ab f27005s;

    /* renamed from: t  reason: collision with root package name */
    private SharePrefrenceHelper f27006t;

    private ab() {
        if (this.f27006t == null) {
            SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
            this.f27006t = sharePrefrenceHelper;
            sharePrefrenceHelper.open(f27000n, 1);
        }
    }

    public static synchronized ab a() {
        ab abVar;
        synchronized (ab.class) {
            if (f27005s == null) {
                f27005s = new ab();
            }
            abVar = f27005s;
        }
        return abVar;
    }

    public static boolean b() {
        if (MobSDK.getContext() == null) {
            return false;
        }
        Context context = MobSDK.getContext();
        String str = f27000n;
        if (SharePrefrenceHelper.isMpfFileExist(context, str, 1)) {
            return true;
        }
        boolean isMobSpFileExist = SharePrefrenceHelper.isMobSpFileExist(MobSDK.getContext(), str, 1);
        if (isMobSpFileExist) {
            return isMobSpFileExist;
        }
        if (c.a() || c.b()) {
            return true;
        }
        return false;
    }

    public static void r() {
        if (f27003q.compareAndSet(false, true)) {
            new j(m.a("004%djgjfied")) {
                public void a() {
                    Object obj = p.f27296i;
                    synchronized (obj) {
                        try {
                            obj.wait(600000);
                            h.a().a(11);
                            ConcurrentHashMap<String, Object> e11 = b.e();
                            if (e11 != null && e11.size() > 0) {
                                h.a().a(12);
                                Object obj2 = e11.get("h");
                                Object obj3 = e11.get("k");
                                Object obj4 = e11.get(m.a("001Wdd"));
                                Object obj5 = e11.get(s.f70071a);
                                Object obj6 = e11.get(m.a("002ac"));
                                Object obj7 = e11.get(m.a("002;cd(c"));
                                e11.clear();
                                c.a(obj2, obj3, obj4, obj5, obj6, obj7);
                            }
                        } catch (Throwable th2) {
                            h.a().a(3, th2);
                        }
                    }
                }
            }.start();
        }
        t();
    }

    private static String s() {
        return Data.MD5(DH.SyncMtd.getModel());
    }

    private static void t() {
        if (f27004r.compareAndSet(false, true)) {
            new j("DS-W") {
                public void a() {
                    Object obj = p.f27297j;
                    synchronized (obj) {
                        try {
                            obj.wait();
                            ConcurrentHashMap<String, Object> f11 = b.f();
                            f11.clear();
                            c.a((ArrayList<HashMap<String, Object>>) (ArrayList) f11.get(m.a("002eg")), (e<Void>) new e<Void>() {
                                public void a(Void voidR) {
                                }
                            });
                        } catch (Throwable th2) {
                            MobLog.getInstance().d(th2);
                        }
                    }
                }
            }.start();
        }
    }

    public Object c(String str, Object obj) {
        return this.f27006t.get(str, obj);
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = Base64.encodeToString(Data.AES128Encode(s(), str), 0);
                a(f26999m, System.currentTimeMillis());
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        a("key_gfrt", str);
    }

    public void e() {
        c((String) null);
        d((String) null);
    }

    public HashMap<Long, Long> f() {
        HashMap fromJson;
        String string = this.f27006t.getString(f27001o);
        HashMap<Long, Long> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(string) && (fromJson = HashonHelper.fromJson(string)) != null && !fromJson.isEmpty()) {
            for (Map.Entry entry : fromJson.entrySet()) {
                if (entry != null) {
                    hashMap.put(Long.valueOf(Long.parseLong((String) entry.getKey())), entry.getValue());
                }
            }
        }
        return hashMap;
    }

    public HashMap<String, Object> g() {
        String b11 = b(f27002p, (String) null);
        if (TextUtils.isEmpty(b11)) {
            return null;
        }
        return HashonHelper.fromJson(b11);
    }

    public int h() {
        return b("key_mstrgy", 0);
    }

    public a.c i() {
        return a.c.a(b("key_duid_param_blacklist", (String) null));
    }

    public a.C0238a j() {
        try {
            String b11 = b("key_duid_entity", (String) null);
            if (!TextUtils.isEmpty(b11)) {
                return a.C0238a.a(Data.AES128Decode(DH.SyncMtd.getModel(), Base64.decode(b11, 0)));
            }
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
        return null;
    }

    public String k() {
        return b("key_chd_ak", (String) null);
    }

    public String l() {
        return b("key_chd_as", (String) null);
    }

    public HashMap<String, HashMap<String, ArrayList<String>>> m() {
        return HashonHelper.fromJson(b("key_chd_busi_dm", (String) null));
    }

    public HashMap<String, String> n() {
        return HashonHelper.fromJson(b("key_ckd_busi_dm", (String) null));
    }

    public ArrayList<String> o() {
        HashMap fromJson = HashonHelper.fromJson(b("key_chd_prx_dm", (String) null));
        if (fromJson == null || fromJson.isEmpty()) {
            return new ArrayList<>();
        }
        return (ArrayList) fromJson.get(m.a("0083cdQbXcfJdeIbgdg3g"));
    }

    public HashMap<String, Long> p() {
        return HashonHelper.fromJson(b("key_dm_ck_tm", (String) null));
    }

    public long q() {
        return b("key_fst_lnch_tm", 0);
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = Base64.encodeToString(Data.AES128Encode(s(), str), 0);
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        a(f26998l, str);
    }

    public void e(String str) {
        a("key_chd_ak", str);
    }

    public void a(String str, long j11) {
        this.f27006t.putLong(str, Long.valueOf(j11));
    }

    public void e(HashMap<String, Long> hashMap) {
        a("key_dm_ck_tm", HashonHelper.fromHashMap(hashMap));
    }

    public void a(String str, int i11) {
        this.f27006t.putInt(str, Integer.valueOf(i11));
    }

    public long b(String str, long j11) {
        return this.f27006t.getLong(str, j11);
    }

    public void a(String str, boolean z11) {
        this.f27006t.putBoolean(str, Boolean.valueOf(z11));
    }

    public int b(String str, int i11) {
        return this.f27006t.getInt(str, i11);
    }

    public void a(String str, String str2) {
        if (str2 == null) {
            this.f27006t.remove(str);
        } else {
            this.f27006t.putString(str, str2);
        }
    }

    public boolean b(String str, boolean z11) {
        return this.f27006t.getBoolean(str, z11);
    }

    public String b(String str, String str2) {
        return this.f27006t.getString(str, str2);
    }

    public String c() {
        String b11 = b(f26998l, (String) null);
        if (TextUtils.isEmpty(b11)) {
            return b11;
        }
        try {
            String s11 = s();
            return Data.AES128PaddingDecode(s11.getBytes("UTF-8"), Base64.decode(b11, 0));
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return b11;
        }
    }

    public String d() {
        String b11 = b("key_gfrt", (String) null);
        if (TextUtils.isEmpty(b11)) {
            return b11;
        }
        try {
            String s11 = s();
            return Data.AES128PaddingDecode(s11.getBytes("UTF-8"), Base64.decode(b11, 0));
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return b11;
        }
    }

    public void f(String str) {
        a("key_chd_as", str);
    }

    public void a(String str, Object obj) {
        this.f27006t.put(str, obj);
    }

    public void b(String str, Object obj) {
        this.f27006t.put(str, obj);
    }

    public Object a(String str) {
        return this.f27006t.get(str);
    }

    public void b(String str) {
        this.f27006t.remove(str);
    }

    public void a(HashMap<Long, Long> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            this.f27006t.remove(f27001o);
            return;
        }
        HashMap hashMap2 = new HashMap();
        for (Map.Entry next : hashMap.entrySet()) {
            if (next != null) {
                hashMap2.put(String.valueOf(next.getKey()), next.getValue());
            }
        }
        this.f27006t.putString(f27001o, HashonHelper.fromHashMap(hashMap2));
    }

    public void b(HashMap<String, Object> hashMap) {
        a(f27002p, HashonHelper.fromHashMap(hashMap));
    }

    public void c(HashMap<String, HashMap<String, ArrayList<String>>> hashMap) {
        a("key_chd_busi_dm", HashonHelper.fromHashMap(hashMap));
    }

    public void d(HashMap<String, String> hashMap) {
        a("key_ckd_busi_dm", HashonHelper.fromHashMap(hashMap));
    }

    public void a(int i11) {
        if (i11 >= 0) {
            a("key_mstrgy", i11);
        }
    }

    public void a(a.c cVar) {
        a("key_duid_param_blacklist", cVar != null ? cVar.a() : null);
    }

    public void a(a.C0238a aVar) {
        String str = null;
        if (aVar != null) {
            try {
                str = aVar.a();
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
                return;
            }
        }
        a("key_duid_entity", Base64.encodeToString(Data.EncodeNoPadding(DH.SyncMtd.getModel(), str), 0));
    }

    public void a(ArrayList<String> arrayList) {
        a("key_chd_prx_dm", (arrayList == null || arrayList.isEmpty()) ? null : HashonHelper.fromObject(arrayList));
    }

    public void a(long j11) {
        a("key_fst_lnch_tm", j11);
    }
}
