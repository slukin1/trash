package com.mob.commons;

import android.text.TextUtils;
import com.hbg.lib.network.pro.core.util.Period;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.HashonHelper;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.xiaomi.mipush.sdk.Constants;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, String> f27238a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static final ArrayList<String> f27239b = new ArrayList<>(Arrays.asList(new String[]{C0891r.b("017ci8chgj i^egckdbdgehcbdgehck4b;cjce"), C0891r.b("017ciEchgj@i<geckdbdgehcbdgehck;b6cjce"), C0891r.b("017ciZchgj5i(gdckdbdgehcbdgehckWbNcjce"), C0891r.b("017ci5chgjTi?ieckdbdgehcbdgehck:bNcjce"), C0891r.b("017ciEchgj i!gkckdbdgehcbdgehckCb]cjce"), C0891r.b("018ci?chgjKiSegckcecjeeehcfci3fSckIb cjce"), C0891r.b("018ci=chgjVi$geckcecjeeehcfci;fOck0bGcjce"), C0891r.b("018ci?chgj!i9gdckcecjeeehcfci3f!ck9b)cjce"), C0891r.b("018ciSchgj9iSieckcecjeeehcfci fJck.b%cjce"), C0891r.b("018ciEchgj;iTgkckcecjeeehcfci.fAckOb?cjce")}));

    /* renamed from: c  reason: collision with root package name */
    private static final CountDownLatch f27240c = new CountDownLatch(1);

    /* renamed from: d  reason: collision with root package name */
    private static final String f27241d = C0891r.b("006^dcfggbgbfgdf");

    /* renamed from: e  reason: collision with root package name */
    private static i f27242e;

    /* renamed from: f  reason: collision with root package name */
    private volatile HashMap<String, HashMap<String, ArrayList<String>>> f27243f = ab.a().m();

    /* renamed from: g  reason: collision with root package name */
    private volatile HashMap<String, String> f27244g = ab.a().n();

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<String> f27245h;

    /* renamed from: i  reason: collision with root package name */
    private volatile HashMap<String, Long> f27246i;

    /* renamed from: j  reason: collision with root package name */
    private ReentrantReadWriteLock f27247j;

    /* renamed from: k  reason: collision with root package name */
    private ReentrantReadWriteLock f27248k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public volatile CountDownLatch f27249l = f27240c;

    static {
        f27238a.put("gcfg", C0891r.b("016ci;chgjHb(ckcbcfXhOch3f0ehckPbBcjce"));
        f27238a.put("gclg", C0891r.b("016ciYchgjcbckcbcf=h;ch)fHehck)bGcjce"));
        f27238a.put("el", C0891r.b("018ci2chgj8eOdh_bRckcbcfAhWchEf,ehckRb!cjce"));
        f27238a.put("dg", C0891r.b("020+cb*eQccehgjcb8chcSckcbcf8h5ch?f-ehckPb;cjce"));
        f27238a.put("dtc", "api-df.dutils.com");
        f27238a.put("tcig", "m.mpl.dutils.com");
        f27238a.put("gdg", "api-gd.dutils.com");
    }

    private i() {
        ArrayList<String> o11 = ab.a().o();
        this.f27245h = o11;
        if (o11 == null || o11.isEmpty()) {
            this.f27245h = f27239b;
        }
        this.f27246i = ab.a().p();
        this.f27247j = new ReentrantReadWriteLock();
        this.f27248k = new ReentrantReadWriteLock();
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str) || str.equals("127.0.0.1") || str.startsWith("10.") || str.startsWith("192.168")) {
            return false;
        }
        if (str.startsWith("172.")) {
            String[] split = str.split("\\.");
            if (split.length > 1) {
                try {
                    int parseInt = Integer.parseInt(split[1]);
                    if (parseInt < 16 || parseInt > 31) {
                        return true;
                    }
                    return false;
                } catch (Throwable th2) {
                    NLog instance = MobLog.getInstance();
                    instance.d(th2, "DM " + th2.getMessage(), new Object[0]);
                }
            }
        }
        return true;
    }

    public void b() {
        if (this.f27249l == f27240c || this.f27249l.getCount() == 0) {
            MobLog.getInstance().d("DM obt start", new Object[0]);
            this.f27249l = new CountDownLatch(1);
            z.f27384c.execute(new Runnable() {
                public void run() {
                    i iVar = i.this;
                    iVar.a(iVar.f27249l, 0);
                }
            });
            return;
        }
        MobLog.getInstance().d("DM obt abort", new Object[0]);
    }

    public static i a() {
        if (f27242e == null) {
            synchronized (i.class) {
                if (f27242e == null) {
                    f27242e = new i();
                }
            }
        }
        return f27242e;
    }

    private boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null) {
                    for (InetAddress hostAddress : allByName) {
                        if (!c(hostAddress.getHostAddress())) {
                            MobLog.getInstance().d("DM ck ht: " + str + ", fai", new Object[0]);
                            return false;
                        }
                    }
                }
                MobLog.getInstance().d("DM ck ht: " + str + ", suc", new Object[0]);
                return true;
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2, "DM " + th2.getMessage(), new Object[0]);
            }
        }
        MobLog.getInstance().d("DM ck ht: " + str + ", fai_emp|exp", new Object[0]);
        return false;
    }

    public String a(String str) {
        return v.a(a().a(f27241d, str, f27238a.get(str), false));
    }

    public String a(String str, String str2, String str3, boolean z11) {
        HashMap hashMap;
        ArrayList arrayList;
        NLog instance = MobLog.getInstance();
        instance.d("DM get: " + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + z11, new Object[0]);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            MobLog.getInstance().d("DM Params 'sName' or 'aName' is null", new Object[0]);
            return str3;
        }
        boolean z12 = this.f27249l.getCount() == 0;
        try {
            if (this.f27247j.readLock().tryLock(3000, TimeUnit.MILLISECONDS) && this.f27243f != null && this.f27243f.containsKey(str) && (hashMap = this.f27243f.get(str)) != null && hashMap.containsKey(str2) && (arrayList = (ArrayList) hashMap.get(str2)) != null && !arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String str4 = (String) it2.next();
                    if (!z11 || !a(str, str2)) {
                        HashMap<String, String> hashMap2 = this.f27244g;
                        if (hashMap2.containsKey(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2)) {
                            HashMap<String, String> hashMap3 = this.f27244g;
                            String str5 = hashMap3.get(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2);
                            NLog instance2 = MobLog.getInstance();
                            instance2.d("DM rtn [cac|chk_abt]: " + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + l.f34627b + str5, new Object[0]);
                            try {
                                this.f27247j.readLock().unlock();
                            } catch (Throwable th2) {
                                NLog instance3 = MobLog.getInstance();
                                instance3.d(th2, "DM " + th2.getMessage(), new Object[0]);
                            }
                            return str5;
                        } else if (!TextUtils.isEmpty(str4)) {
                            NLog instance4 = MobLog.getInstance();
                            instance4.d("DM rtn [cac]: " + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + l.f34627b + str4, new Object[0]);
                            try {
                                this.f27247j.readLock().unlock();
                            } catch (Throwable th3) {
                                NLog instance5 = MobLog.getInstance();
                                instance5.d(th3, "DM " + th3.getMessage(), new Object[0]);
                            }
                            return str4;
                        }
                    } else if (a(str, str2, str4)) {
                        NLog instance6 = MobLog.getInstance();
                        instance6.d("DM rtn [cac|chk]: " + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + l.f34627b + str4, new Object[0]);
                        HashMap<String, String> hashMap4 = this.f27244g;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        sb2.append(str2);
                        hashMap4.put(sb2.toString(), str4);
                        ab.a().d(this.f27244g);
                        try {
                            this.f27247j.readLock().unlock();
                        } catch (Throwable th4) {
                            NLog instance7 = MobLog.getInstance();
                            instance7.d(th4, "DM " + th4.getMessage(), new Object[0]);
                        }
                        return str4;
                    }
                }
            }
            try {
                this.f27247j.readLock().unlock();
            } catch (Throwable th5) {
                NLog instance8 = MobLog.getInstance();
                instance8.d(th5, "DM " + th5.getMessage(), new Object[0]);
            }
        } catch (Throwable th6) {
            NLog instance9 = MobLog.getInstance();
            instance9.d(th6, "DM " + th6.getMessage(), new Object[0]);
        }
        try {
            HashMap<String, String> hashMap5 = this.f27244g;
            hashMap5.remove(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2);
            ab.a().d(this.f27244g);
            if (!z11 || !a(str, str2)) {
                HashMap<String, String> hashMap6 = this.f27244g;
                if (hashMap6.containsKey(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2)) {
                    HashMap<String, String> hashMap7 = this.f27244g;
                    String str6 = hashMap7.get(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2);
                    NLog instance10 = MobLog.getInstance();
                    instance10.d("DM rtn [def|chk_abt]: " + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + l.f34627b + str6, new Object[0]);
                    return str6;
                }
                NLog instance11 = MobLog.getInstance();
                instance11.d("DM rtn [def]" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + l.f34627b + str3, new Object[0]);
                return str3;
            } else if (a(str, str2, str3)) {
                NLog instance12 = MobLog.getInstance();
                instance12.d("DM rtn [def|chk_true]: " + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + l.f34627b + str3, new Object[0]);
                HashMap<String, String> hashMap8 = this.f27244g;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb3.append(str2);
                hashMap8.put(sb3.toString(), str3);
                ab.a().d(this.f27244g);
                return str3;
            } else if (z12) {
                NLog instance13 = MobLog.getInstance();
                instance13.d("DM rtn [def|chk_false]" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + l.f34627b + str3, new Object[0]);
                return str3;
            } else if (this.f27249l.await(5000, TimeUnit.MILLISECONDS)) {
                MobLog.getInstance().d("DM awt next", new Object[0]);
                return a(str, str2, str3, z11);
            } else {
                NLog instance14 = MobLog.getInstance();
                instance14.d("DM rtn [def|awt_to]" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + l.f34627b + str3, new Object[0]);
                return str3;
            }
        } catch (Throwable th7) {
            NLog instance15 = MobLog.getInstance();
            instance15.d(th7, "DM " + th7.getMessage(), new Object[0]);
            NLog instance16 = MobLog.getInstance();
            instance16.d("DM rtn [def|exp]" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + l.f34627b + str3, new Object[0]);
            return str3;
        }
    }

    /* access modifiers changed from: private */
    public void a(CountDownLatch countDownLatch, int i11) {
        int i12;
        CountDownLatch countDownLatch2 = countDownLatch;
        int i13 = i11;
        try {
            ArrayList<String> arrayList = this.f27245h;
            if (arrayList == null || i13 >= arrayList.size()) {
                MobLog.getInstance().w("DM No pdm");
            } else {
                String a11 = v.a(this.f27245h.get(i13) + "/dm");
                HashMap hashMap = new HashMap();
                hashMap.put(C0891r.b("006ciiOdgDeAdb"), u.a());
                NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                networkTimeOut.connectionTimeout = 3000;
                networkTimeOut.readTimout = 5000;
                String httpGetNew = new NetworkHelper().httpGetNew(a11, hashMap, (HashMap<String, String>) null, networkTimeOut);
                NLog instance = MobLog.getInstance();
                instance.d("DM resp: " + httpGetNew, new Object[0]);
                HashMap fromJson = HashonHelper.fromJson(httpGetNew);
                if (fromJson == null || fromJson.isEmpty()) {
                    a(countDownLatch2, i13 + 1);
                } else {
                    Object obj = fromJson.get(C0891r.b("004bGcjcbJe"));
                    if (obj == null) {
                        a(countDownLatch2, i13 + 1);
                    } else if (((Integer) obj).intValue() == 200) {
                        HashMap hashMap2 = (HashMap) fromJson.get(C0891r.b("004Qcb chc"));
                        if (hashMap2 != null && !hashMap2.isEmpty()) {
                            try {
                                HashMap hashMap3 = (HashMap) hashMap2.get(C0891r.b("004=cb?chc"));
                                if (hashMap3 != null && !hashMap3.isEmpty()) {
                                    HashMap hashMap4 = new HashMap();
                                    for (Map.Entry entry : hashMap3.entrySet()) {
                                        String str = (String) entry.getKey();
                                        HashMap hashMap5 = (HashMap) entry.getValue();
                                        HashMap hashMap6 = new HashMap();
                                        if (hashMap5 != null && !hashMap5.isEmpty()) {
                                            for (Map.Entry entry2 : hashMap5.entrySet()) {
                                                String str2 = (String) entry2.getKey();
                                                ArrayList arrayList2 = (ArrayList) entry2.getValue();
                                                ArrayList arrayList3 = new ArrayList();
                                                if (arrayList2 != null && !arrayList2.isEmpty()) {
                                                    Iterator it2 = arrayList2.iterator();
                                                    while (it2.hasNext()) {
                                                        String str3 = (String) it2.next();
                                                        if (b(str3)) {
                                                            arrayList3.add(str3);
                                                        }
                                                    }
                                                }
                                                if (!arrayList3.isEmpty()) {
                                                    hashMap6.put(str2, arrayList3);
                                                }
                                            }
                                        }
                                        if (!hashMap6.isEmpty()) {
                                            hashMap4.put(str, hashMap6);
                                        }
                                    }
                                    if (!hashMap4.isEmpty()) {
                                        try {
                                            NLog instance2 = MobLog.getInstance();
                                            instance2.d("DM busi w 2 cac: " + hashMap4, new Object[0]);
                                            if (this.f27247j.writeLock().tryLock(3000, TimeUnit.MILLISECONDS)) {
                                                this.f27243f.clear();
                                                this.f27243f.putAll(hashMap4);
                                                ab.a().c(this.f27243f);
                                            }
                                            this.f27247j.writeLock().unlock();
                                        } catch (Throwable th2) {
                                            NLog instance3 = MobLog.getInstance();
                                            instance3.d(th2, "DM " + th2.getMessage(), new Object[0]);
                                        }
                                    } else {
                                        MobLog.getInstance().d("DM busi no avai dm", new Object[0]);
                                    }
                                }
                            } catch (Throwable th3) {
                                try {
                                    NLog instance4 = MobLog.getInstance();
                                    instance4.d(th3, "DM " + th3.getMessage(), new Object[0]);
                                } catch (Throwable th4) {
                                    countDownLatch.countDown();
                                    throw th4;
                                }
                            }
                            countDownLatch.countDown();
                            ArrayList arrayList4 = (ArrayList) hashMap2.get(TtmlNode.TAG_P);
                            if (arrayList4 != null && !arrayList4.isEmpty()) {
                                ArrayList arrayList5 = new ArrayList();
                                Iterator it3 = arrayList4.iterator();
                                while (it3.hasNext()) {
                                    String str4 = (String) it3.next();
                                    if (b(str4)) {
                                        arrayList5.add(str4);
                                    }
                                }
                                if (!arrayList5.isEmpty()) {
                                    NLog instance5 = MobLog.getInstance();
                                    instance5.d("DM prx w 2 cac: " + arrayList5, new Object[0]);
                                    this.f27245h.clear();
                                    this.f27245h.addAll(arrayList5);
                                    ab.a().a(this.f27245h);
                                } else {
                                    MobLog.getInstance().d("DM prx no avai dm", new Object[0]);
                                }
                            }
                        }
                    } else {
                        a(countDownLatch2, i13 + 1);
                    }
                }
            }
        } catch (Throwable th5) {
            try {
                NLog instance6 = MobLog.getInstance();
                instance6.d(th5, "DM " + th5.getMessage(), new Object[0]);
                a(countDownLatch2, i13 + 1);
                if (i12 <= 0) {
                    return;
                }
            } finally {
                if (countDownLatch.getCount() > 0) {
                    countDownLatch.countDown();
                }
            }
        }
        if (countDownLatch.getCount() <= 0) {
        }
    }

    private boolean a(String str, String str2) {
        Long l11;
        boolean z11 = true;
        try {
            if (this.f27248k.readLock().tryLock(3000, TimeUnit.MILLISECONDS)) {
                String str3 = str + "_" + str2;
                if (this.f27246i != null && this.f27246i.containsKey(str3) && (l11 = this.f27246i.get(str3)) != null && System.currentTimeMillis() - l11.longValue() < Period.MIN30_MILLS) {
                    z11 = false;
                }
            }
            try {
                this.f27248k.readLock().unlock();
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2, "DM " + th2.getMessage(), new Object[0]);
            }
        } catch (Throwable th3) {
            MobLog.getInstance().d(th3, "DM " + th3.getMessage(), new Object[0]);
        }
        MobLog.getInstance().d("DM ck dur: " + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + ", pass: " + z11, new Object[0]);
        return z11;
    }

    private boolean a(String str, String str2, String str3) {
        boolean b11 = b(str3);
        if (b11) {
            try {
                if (this.f27248k.writeLock().tryLock(3000, TimeUnit.MILLISECONDS)) {
                    this.f27246i.put(str + "_" + str2, Long.valueOf(System.currentTimeMillis()));
                    ab.a().e(this.f27246i);
                }
                try {
                    this.f27248k.writeLock().unlock();
                } catch (Throwable th2) {
                    NLog instance = MobLog.getInstance();
                    instance.d(th2, "DM " + th2.getMessage(), new Object[0]);
                }
            } catch (Throwable th3) {
                NLog instance2 = MobLog.getInstance();
                instance2.d(th3, "DM " + th3.getMessage(), new Object[0]);
            }
        }
        return b11;
    }
}
