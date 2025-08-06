package com.mob.commons;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.a;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.MobRSA;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.i;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f27299a = false;

    /* renamed from: b  reason: collision with root package name */
    private static q f27300b;

    /* renamed from: c  reason: collision with root package name */
    private File f27301c;

    /* renamed from: d  reason: collision with root package name */
    private BigInteger f27302d = new BigInteger("f53c224aefb38daa0825c1b8ea691b16d2e16db10880548afddd780c6670a091a11dafa954ea4a9483797fda1045d2693a08daa48cf9cedce1e8733b857304cb", 16);

    /* renamed from: e  reason: collision with root package name */
    private BigInteger f27303e = new BigInteger("27749621e6ca022469645faed16e8261acf6af822467382d55c24bb9bc02356ab16e76ddc799dc8ba6b4f110411996eeb63505c9dcf969d3fc085d712f0f1a9713b67aa1128d7cc41bda363afb0ec7ade60e542a4e22869395331cc0096de412034551e98bb2629ae1b7168b8bc82006d064ab335d8567283e70beb6a49e9423", 16);

    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private int f27306a;

        /* renamed from: b  reason: collision with root package name */
        private int f27307b;

        /* renamed from: c  reason: collision with root package name */
        private String f27308c;

        /* renamed from: d  reason: collision with root package name */
        private String f27309d;

        private a() {
        }

        private void b(int i11, int i12, String str, String str2) {
            MobLog.getInstance().d("[LGSM] SLR: onL", new Object[0]);
            final int i13 = i11;
            final String str3 = str;
            final int i14 = i12;
            final String str4 = str2;
            if (q.a().a((Runnable) new i() {
                public void a() throws Throwable {
                    MobLog.getInstance().d("[LGSM] SLR: Ins", new Object[0]);
                    HashMap hashMap = new HashMap();
                    hashMap.put(l.a("010,hkfegjim0h5flhkfkfm<g"), Integer.valueOf(i13));
                    hashMap.put(l.a("006)hkfegjhe3f;gl"), str3);
                    hashMap.put(l.a("004kSgeHlh"), Integer.valueOf(i14));
                    hashMap.put(l.a("005hCflfl;fk"), Long.valueOf(System.currentTimeMillis()));
                    String encode = URLEncoder.encode(str4);
                    if (TextUtils.isEmpty(encode)) {
                        encode = str4;
                    }
                    hashMap.put(l.a("003Mfhhkgl"), Base64.encodeToString(encode.getBytes("utf-8"), 2));
                    hashMap.put(l.a("005kQfkfh0hYhk"), 1);
                    NLog instance = MobLog.getInstance();
                    instance.d("[LGSM] W l " + hashMap, new Object[0]);
                    q.b(i14).a(HashonHelper.fromHashMap(hashMap));
                }
            }) && x.b()) {
                MobLog.getInstance().d("[LGSM] SLR: U", new Object[0]);
                z.f27384c.execute(new c());
            }
        }

        public a a(int i11, int i12, String str, String str2) {
            this.f27306a = i11;
            this.f27307b = i12;
            this.f27308c = str;
            this.f27309d = str2;
            return this;
        }

        public void run() {
            try {
                b(this.f27306a, this.f27307b, this.f27308c, this.f27309d);
            } catch (Throwable th2) {
                MobLog.getInstance().w(th2);
            }
        }
    }

    public static class c implements Runnable {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Runnable f27318a;

        public void run() {
            try {
                if (!b.c()) {
                    MobLog.getInstance().d("[LGSM] ULR Ck nt: FBDN", new Object[0]);
                } else {
                    DH.requester(MobSDK.getContext()).getDetailNetworkTypeForStatic().request(new DH.DHResponder() {
                        public void onResponse(DH.DHResponse dHResponse) {
                            if (!l.a("004gIfm8gh").equals(dHResponse.getDetailNetworkTypeForStatic())) {
                                int intValue = ((Integer) b.a(l.a("004ehCflfl"), 0)).intValue();
                                NLog instance = MobLog.getInstance();
                                instance.d("[LGSM] ULR Ck cerr: " + intValue, new Object[0]);
                                if (intValue == 1) {
                                    boolean unused = q.a().a(c.this.f27318a);
                                    return;
                                }
                                q.b(1).a(((Long) b.a("cerr_max", 104857600L)).longValue());
                            }
                        }
                    });
                }
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }

        private c() {
            this.f27318a = new i() {
                public void a() {
                    MobLog.getInstance().d("[LGSM] UCLR", new Object[0]);
                    q.b(1).a((a.C0242a) new b());
                }
            };
        }
    }

    private q() {
    }

    public void b() {
        MobLog.getInstance().d("[LGSM] Sd last", new Object[0]);
        z.f27384c.execute(new c());
    }

    public static synchronized q a() {
        q qVar;
        synchronized (q.class) {
            if (f27300b == null) {
                f27300b = new q();
            }
            qVar = f27300b;
        }
        return qVar;
    }

    /* access modifiers changed from: private */
    public static com.mob.tools.a b(int i11) {
        String a11 = l.a("005(fnfh_eiOgl");
        return new com.mob.tools.a(a11, l.a("005(fnfh_eiOgl") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i11, 50);
    }

    public static class b implements a.C0242a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<HashMap<String, Object>> f27315a;

        /* renamed from: b  reason: collision with root package name */
        public int f27316b;

        /* renamed from: c  reason: collision with root package name */
        public String f27317c;

        private b() {
            this.f27315a = new ArrayList<>();
            this.f27316b = -1;
        }

        private String b(String str) throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            ByteArrayInputStream byteArrayInputStream;
            Throwable th2;
            GZIPOutputStream gZIPOutputStream;
            Throwable th3;
            try {
                byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = byteArrayInputStream.read(bArr, 0, 1024);
                                if (read != -1) {
                                    gZIPOutputStream.write(bArr, 0, read);
                                } else {
                                    gZIPOutputStream.flush();
                                    try {
                                        v.a(gZIPOutputStream);
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        byteArrayOutputStream.flush();
                                        String encodeToString = Base64.encodeToString(byteArray, 2);
                                        v.a(byteArrayOutputStream, byteArrayInputStream);
                                        return encodeToString;
                                    } catch (Throwable th4) {
                                        th2 = th4;
                                        v.a(byteArrayOutputStream, byteArrayInputStream);
                                        throw th2;
                                    }
                                }
                            }
                        } catch (Throwable th5) {
                            th3 = th5;
                            v.a(gZIPOutputStream);
                            throw th3;
                        }
                    } catch (Throwable th6) {
                        Throwable th7 = th6;
                        gZIPOutputStream = null;
                        th3 = th7;
                        v.a(gZIPOutputStream);
                        throw th3;
                    }
                } catch (Throwable th8) {
                    th2 = th8;
                    byteArrayOutputStream = null;
                    v.a(byteArrayOutputStream, byteArrayInputStream);
                    throw th2;
                }
            } catch (Throwable th9) {
                byteArrayInputStream = null;
                th2 = th9;
                byteArrayOutputStream = null;
                v.a(byteArrayOutputStream, byteArrayInputStream);
                throw th2;
            }
        }

        public void a(String str) {
            NLog instance = MobLog.getInstance();
            instance.d("[LGSM] ULL onRd " + str, new Object[0]);
            HashMap fromJson = HashonHelper.fromJson(str);
            try {
                this.f27316b = Integer.parseInt(String.valueOf(fromJson.get(l.a("010%hkfegjimSh9flhkfkfmVg"))));
            } catch (Throwable unused) {
            }
            this.f27317c = (String) fromJson.get(l.a("006)hkfegjheFfCgl"));
            this.f27315a.add(fromJson);
        }

        public boolean a(DH.DHResponse dHResponse) {
            MobLog.getInstance().d("[LGSM] ULL onUd", new Object[0]);
            HashMap<String, Object> a11 = a(dHResponse, this.f27316b, this.f27317c);
            a11.put(l.a("006h7flflfhhkgl"), this.f27315a);
            try {
                String fromHashMap = HashonHelper.fromHashMap(a11);
                this.f27315a.clear();
                String b11 = b(fromHashMap);
                if (!l.a("004g%fm!gh").equals(dHResponse.getDetailNetworkTypeForStatic())) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("m", b11);
                    NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                    networkTimeOut.readTimout = 10000;
                    networkTimeOut.connectionTimeout = 10000;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(l.a("013EgmhkRh@fljmggfe2hgkDfk kUge"), aa.c());
                    hashMap2.put(l.a("004.fhfmfkfe"), dHResponse.getODH());
                    String str = i.a().a("el") + "/errlog";
                    MobLog.getInstance().d("[LGSM] ULL onUd: Req", new Object[0]);
                    String httpPostNew = new NetworkHelper().httpPostNew(str, hashMap, hashMap2, networkTimeOut);
                    MobLog.getInstance().d("[LGSM] ULL onUd: " + String.format("Resp(%s): %s", new Object[]{str, httpPostNew}), new Object[0]);
                    Object obj = HashonHelper.fromJson(httpPostNew).get(l.a("006Khk2kfk3fihk"));
                    if ((obj != null ? ((Integer) obj).intValue() : 0) == 200) {
                        return true;
                    }
                    return false;
                }
                throw new IllegalStateException("network is disconnected!");
            } catch (Throwable th2) {
                MobLog.getInstance().d("[LGSM] ULL onUd: E", new Object[0]);
                MobLog.getInstance().d(th2);
            }
        }

        private HashMap<String, Object> a(DH.DHResponse dHResponse, int i11, String str) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(l.a("0035gj8hOge"), u.a());
            hashMap.put(l.a("0041fefifkfe"), e.a((MobProduct) null));
            hashMap.put(l.a("004lifk"), Integer.valueOf(DH.SyncMtd.getPlatformCode()));
            hashMap.put(l.a("0037hkfegj"), str);
            hashMap.put(l.a("006!hkfegjff]hCfl"), Integer.valueOf(i11));
            hashMap.put(l.a("007fllgf>fh7h"), dHResponse.getAppName());
            hashMap.put(l.a("006flll)gjgl"), DH.SyncMtd.getPackageName());
            hashMap.put(l.a("006fll$ff!h?fl"), String.valueOf(DH.SyncMtd.getAppVersion()));
            hashMap.put(l.a("005+fhfmfe-hi"), DH.SyncMtd.getModel());
            if (b.b()) {
                hashMap.put(l.a("0087feBhIfffkTeh5fkfe"), dHResponse.getDeviceKey());
            }
            hashMap.put(l.a("006%hkgehkff4hUfl"), String.valueOf(DH.SyncMtd.getOSVersionInt()));
            hashMap.put(l.a("011ghk]hifmflgj2kYge[lh"), dHResponse.getDetailNetworkTypeForStatic());
            return hashMap;
        }
    }

    public void a(int i11, String str, int i12, String str2) {
        MobLog.getInstance().d("[LGSM] Sd curr", new Object[0]);
        if (i11 == 1) {
            new a().a(i12, i11, str, str2).run();
        }
    }

    /* access modifiers changed from: private */
    public boolean a(final Runnable runnable) {
        if (this.f27301c == null) {
            File file = new File(MobSDK.getContext().getFilesDir(), l.a("005_fn-iLfm1e.gj"));
            this.f27301c = file;
            if (!file.exists()) {
                try {
                    this.f27301c.createNewFile();
                } catch (Throwable unused) {
                }
            }
        }
        return p.a(this.f27301c, new o() {
            public boolean a(FileLocker fileLocker) {
                runnable.run();
                return false;
            }
        });
    }

    public int a(int i11, String str) {
        if (MobSDK.getContextSafely() != null && f27299a) {
            Intent intent = new Intent();
            intent.setPackage(l.a("015eg3fnhk:jfDfl:hShkfegjfn3i fmgl"));
            intent.putExtra(l.a("007lfeEgj(fYglGh"), MobSDK.getContext().getPackageName());
            intent.putExtra(l.a("008l$flfkfmflfk-k<ge"), i11);
            intent.putExtra("ver", MobSDK.SDK_VERSION_CODE);
            intent.putExtra(l.a("003Ifhhkgl"), a(str));
            ReflectHelper.invokeInstanceMethod(MobSDK.getContextSafely(), l.a("013@hkThg fehlflfmPfMfeDefNhk;k"), new Object[]{intent}, new Class[]{Intent.class}, 0);
        }
        return 0;
    }

    private String a(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] c11 = v.c();
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                byte[] encode = new MobRSA(1024).encode(c11, this.f27302d, this.f27303e);
                dataOutputStream.writeInt(encode.length);
                dataOutputStream.write(encode);
                byte[] AES128Encode = Data.AES128Encode(c11, str.getBytes("utf-8"));
                dataOutputStream.writeInt(AES128Encode.length);
                dataOutputStream.write(AES128Encode);
                dataOutputStream.flush();
                v.a(dataOutputStream, byteArrayOutputStream);
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = null;
                v.a(dataOutputStream, byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            MobLog.getInstance().d(th3);
            return null;
        }
    }
}
