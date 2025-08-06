package com.mob.commons;

import android.os.Process;
import android.text.TextUtils;
import com.jumio.sdk.reject.JumioRejectReason;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.b;
import com.mob.tools.b.c;
import com.mob.tools.c.a;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.i;
import com.mob.tools.utils.j;
import e7.s;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class x {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f27351a = true;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static AtomicInteger f27352b = new AtomicInteger(-1);

    /* renamed from: c  reason: collision with root package name */
    private static AtomicBoolean f27353c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private static AtomicBoolean f27354d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    private static w f27355e = new w();

    /* renamed from: f  reason: collision with root package name */
    private static volatile String f27356f;

    /* access modifiers changed from: private */
    public static void b(boolean z11, boolean z12) {
        if (!z12) {
            f27355e.a();
        }
        if (z11) {
            if (TextUtils.isEmpty(C0891r.f27321a)) {
                String k11 = ab.a().k();
                if (TextUtils.isEmpty(k11)) {
                    k11 = i();
                }
                if (!TextUtils.isEmpty(k11)) {
                    C0891r.f27323c = k11;
                    ab.a().e(k11);
                }
            } else {
                C0891r.f27323c = C0891r.f27321a;
                ab.a().e(C0891r.f27321a);
            }
            if (TextUtils.isEmpty(C0891r.f27322b)) {
                String l11 = ab.a().l();
                if (!TextUtils.isEmpty(l11)) {
                    C0891r.f27324d = l11;
                }
            } else {
                C0891r.f27324d = C0891r.f27322b;
                ab.a().f(C0891r.f27322b);
            }
            CountDownLatch g11 = g();
            MobLog.getInstance().d(DH.SyncMtd.isInMainProcess() ? FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT : "sub", new Object[0]);
            if (!z12) {
                a(g11);
                return;
            }
            aa.a();
            b.h();
        } else if (!z12) {
            f27355e.b();
        }
    }

    public static int d() {
        int c11 = c();
        if (c11 != -1) {
            return c11;
        }
        return e();
    }

    public static int e() {
        int i11 = -1;
        if (ab.b()) {
            i11 = ab.a().b(ab.f26991e, -1);
        }
        NLog instance = MobLog.getInstance();
        instance.d("get py grtd status cac: " + i11, new Object[0]);
        return i11;
    }

    public static String f() {
        return "ecpgnjvr<1fxsowaktq0{EKhPmziWUVCNdy2uDJFH|LYZQGTXRO:43l87;/6MI>\"@A?\\9[)_]5=.(S'~盺朼-";
    }

    public static CountDownLatch g() {
        if (!f27354d.getAndSet(true)) {
            return c.a(MobSDK.getContext()).a();
        }
        return new CountDownLatch(0);
    }

    public static boolean h() {
        String a11 = u.a();
        return !TextUtils.isEmpty(a11) && !TextUtils.isEmpty(a11.trim()) && !TextUtils.equals(a11, i());
    }

    public static String i() {
        if (f27356f == null) {
            String str = null;
            try {
                String absolutePath = MobSDK.getContext().getFilesDir().getAbsolutePath();
                if (!TextUtils.isEmpty(absolutePath)) {
                    String substring = absolutePath.substring(0, absolutePath.lastIndexOf(l.a("001n")));
                    if (!TextUtils.isEmpty(substring)) {
                        str = substring.substring(substring.lastIndexOf(l.a("001n")) + 1);
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    String CRC32 = Data.CRC32(str.getBytes("utf-8"));
                    if (!TextUtils.isEmpty(CRC32)) {
                        String byteToHex = Data.byteToHex(CRC32.getBytes());
                        if (!TextUtils.isEmpty(byteToHex)) {
                            f27356f = s.f70071a + byteToHex;
                        }
                    }
                }
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        return f27356f;
    }

    private static void k() {
        try {
            ServerSocketChannel open = ServerSocketChannel.open();
            open.configureBlocking(false);
            open.socket().bind(new InetSocketAddress(37926));
            q.f27299a = false;
            open.close();
        } catch (Throwable unused) {
        }
    }

    private static void l() {
        l.a().a((k) new k() {
            public void a(boolean z11, boolean z12, long j11) {
                if (z11) {
                    MobLog.getInstance().d("fg.", new Object[0]);
                    boolean unused = x.f27351a = true;
                    return;
                }
                MobLog.getInstance().d("bg.", new Object[0]);
                boolean unused2 = x.f27351a = false;
            }
        });
    }

    public static int c() {
        NLog instance = MobLog.getInstance();
        instance.d("get py grtd status mem: " + f27352b.get(), new Object[0]);
        return f27352b.get();
    }

    public static void a(final boolean z11) {
        z.f27384c.execute(new i() {
            public void a() {
                a.f27896b.set(Boolean.TRUE);
                b.a();
                if (!TextUtils.isEmpty("M-")) {
                    Thread currentThread = Thread.currentThread();
                    currentThread.setName("M-" + l.a("0042inknjmjh"));
                }
                int b11 = ab.b() ? ab.a().b(ab.f26991e, -1) : -1;
                if (x.f27352b.get() == -1) {
                    x.f27352b.set(b11);
                }
                if (x.f27352b.get() == 1) {
                    x.b(true, z11);
                } else {
                    x.b(false, z11);
                }
                NLog instance = MobLog.getInstance();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(z11 ? l.a("002Sfl;h") : "");
                sb2.append("init cfg over. py ");
                sb2.append(x.f27352b.get());
                instance.d(sb2.toString(), new Object[0]);
                a.f27896b.set(Boolean.FALSE);
            }
        });
    }

    public static void a(final CountDownLatch countDownLatch) {
        if (f27353c.compareAndSet(false, true)) {
            if (ab.a().q() == 0) {
                ab.a().a(System.currentTimeMillis());
            }
            C0891r.a(MobSDK.getContext());
            k();
            l();
            aa.a();
            q.a().b();
            new j("PY-C") {
                public void a() {
                    a.f27896b.set(Boolean.TRUE);
                    NLog instance = MobLog.getInstance();
                    instance.d("g lk st: " + Process.myPid(), new Object[0]);
                    boolean a11 = p.a(p.a(p.f27294g), new o() {
                        public boolean a(FileLocker fileLocker) {
                            NLog instance = MobLog.getInstance();
                            instance.d("g lk pd: " + Process.myPid() + ", proc st", new Object[0]);
                            long currentTimeMillis = System.currentTimeMillis();
                            ab.r();
                            b.a(countDownLatch);
                            NLog instance2 = MobLog.getInstance();
                            instance2.d("g lk pd: " + Process.myPid() + ", proc ed, dur: " + (System.currentTimeMillis() - currentTimeMillis) + ", release: y", new Object[0]);
                            return false;
                        }
                    });
                    NLog instance2 = MobLog.getInstance();
                    instance2.d("g lk res: " + a11 + Process.myPid(), new Object[0]);
                    a.f27896b.set(Boolean.FALSE);
                }
            }.start();
        }
    }

    public static boolean a() {
        return f27351a;
    }

    public static boolean b() {
        return f27352b.get() == 1;
    }

    public static void b(final boolean z11) {
        f27352b.set(z11 ? 1 : 0);
        NLog instance = MobLog.getInstance();
        instance.d("submit py: " + z11, new Object[0]);
        new j(l.a("004,inknjmjg")) {
            public void a() {
                int e11 = x.e();
                ab.a().a(ab.f26991e, z11 ? 1 : 0);
                if (z11 && e11 != 1) {
                    CountDownLatch g11 = x.g();
                    MobLog.getInstance().d(DH.SyncMtd.isInMainProcess() ? FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT : "sub", new Object[0]);
                    x.a(g11);
                    DH.requester(MobSDK.getContext()).getDetailNetworkTypeForStatic().request(new DH.DHResponder() {
                        public void onResponse(DH.DHResponse dHResponse) {
                            try {
                                x.b(z11, dHResponse.getDetailNetworkTypeForStatic());
                            } catch (Throwable th2) {
                                MobLog.getInstance().d(th2);
                            }
                        }
                    });
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public static void b(boolean z11, String str) throws Throwable {
        HashMap<String, Object> a11 = u.a(str);
        a11.put(l.a("009Jfkhkhfglfl.hhSinKl"), String.valueOf(z11));
        HashMap hashMap = new HashMap();
        hashMap.put(l.a("003$gjMh(ge"), u.a());
        hashMap.put(l.a("013Ugmhk(h?fljmggfe1hgkBfkLk?ge"), aa.f());
        String httpGet = new NetworkHelper().httpGet(i.a().a("gclg") + l.a("036nl_flfkff;fe6geEnlCfmYi3fk8e8geYnf5fiOkj^fmflfkifKfk5fkfm3gn3hkOkfkOfihk"), a11, hashMap);
        MobLog.getInstance().d("RS sp: " + httpGet, new Object[0]);
        HashMap fromJson = HashonHelper.fromJson(httpGet);
        if (fromJson == null) {
            throw new Throwable("RS is illegal: " + httpGet);
        } else if (!JumioRejectReason.NOT_READABLE.equals(String.valueOf(fromJson.get(l.a("004eMfmfe4h"))))) {
            throw new Throwable("RS code is not 200: " + httpGet);
        }
    }
}
