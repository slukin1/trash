package com.mob.commons;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.huochat.community.network.domain.DomainTool;
import com.mob.MobSDK;
import com.mob.commons.a.l;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.UIHandler;
import com.mob.tools.utils.d;
import com.mob.tools.utils.e;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class v {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f27343a;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f27344b = new byte[0];

    /* renamed from: com.mob.commons.v$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27349a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.mob.commons.InternationalDomain[] r0 = com.mob.commons.InternationalDomain.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27349a = r0
                com.mob.commons.InternationalDomain r1 = com.mob.commons.InternationalDomain.JP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27349a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mob.commons.InternationalDomain r1 = com.mob.commons.InternationalDomain.US     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.v.AnonymousClass4.<clinit>():void");
        }
    }

    public static Context a() {
        try {
            Object b11 = b();
            if (b11 != null) {
                return (Context) ReflectHelper.invokeInstanceMethod(b11, l.a("014Vfk(gjJge0kkhYejPdejEejelXf"), new Object[0]);
            }
            return null;
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }

    public static Object b() {
        Object a11;
        final AnonymousClass1 r02 = new ReflectHelper.a<Void, Object>() {
            public Object a(Void voidR) {
                return ReflectHelper.invokeStaticMethodNoThrow(ReflectHelper.importClassNoThrow(l.a("026efGedekelejedem=ekk2emgeKdjDejeeej)j+fdgdKiTekWgeZed"), (String) null), l.a("021dHehekek3gfj6geWdj.ejeeej;jAfdgd5iNek1ge<ed"), null, new Object[0]);
            }
        };
        if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() || Build.VERSION.SDK_INT >= 18) && (a11 = r02.a(null)) != null) {
            return a11;
        }
        final Object obj = new Object();
        final Object[] objArr = new Object[1];
        synchronized (obj) {
            UIHandler.sendEmptyMessage(0, new Handler.Callback() {
                public boolean handleMessage(Message message) {
                    Object obj;
                    synchronized (obj) {
                        try {
                            objArr[0] = r02.a(null);
                            obj = obj;
                        } catch (Throwable th2) {
                            obj.notify();
                            throw th2;
                        }
                        obj.notify();
                    }
                    return false;
                }
            });
            try {
                obj.wait();
            } catch (Throwable th2) {
                MobLog.getInstance().w(th2);
            }
        }
        return objArr[0];
    }

    public static Object c(String str) throws Throwable {
        return ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(l.a("017Fih^eJeeQe-emHhef?fkemhkehIfj*ejegMg")), l.a("010[fk7gj6hkeh=fj=ejegGg"), new Object[0]), l.a("004gWfj'gd"), new Object[]{str}, new Class[]{String.class});
    }

    public static Object d(String str) {
        try {
            return MobSDK.getContext().getSystemService(str);
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }

    public static String d() {
        if (TextUtils.isEmpty(f27343a)) {
            synchronized (f27344b) {
                try {
                    if (TextUtils.isEmpty(f27343a)) {
                        f27343a = new d(MobSDK.getContext()).a();
                    }
                } catch (Throwable th2) {
                    NLog instance = MobLog.getInstance();
                    instance.d("[ICE] ee " + th2, new Object[0]);
                }
            }
        }
        return f27343a;
    }

    public static void a(Closeable... closeableArr) {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                }
            }
        }
    }

    public static byte[] c() throws Throwable {
        DataOutputStream dataOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th2;
        try {
            SecureRandom secureRandom = new SecureRandom();
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    dataOutputStream.writeLong(secureRandom.nextLong());
                    dataOutputStream.writeLong(secureRandom.nextLong());
                    dataOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a(dataOutputStream, byteArrayOutputStream);
                    return byteArray;
                } catch (Throwable th3) {
                    th2 = th3;
                    a(dataOutputStream, byteArrayOutputStream);
                    throw th2;
                }
            } catch (Throwable th4) {
                th = th4;
                dataOutputStream = null;
                th2 = th;
                a(dataOutputStream, byteArrayOutputStream);
                throw th2;
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            dataOutputStream = null;
            th2 = th;
            a(dataOutputStream, byteArrayOutputStream);
            throw th2;
        }
    }

    public static void a(final e<ArrayList<HashMap<String, Object>>> eVar) {
        DH.requester(MobSDK.getContext()).getMwlfo().getMbcdi().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                ArrayList arrayList = new ArrayList();
                try {
                    ArrayList<HashMap<String, Object>> mwlfo = dHResponse.getMwlfo();
                    if (mwlfo != null && !mwlfo.isEmpty()) {
                        ArrayList<String> g11 = b.g();
                        if (g11 != null) {
                            if (!g11.isEmpty()) {
                                String mbcdi = dHResponse.getMbcdi();
                                Iterator<HashMap<String, Object>> it2 = mwlfo.iterator();
                                while (it2.hasNext()) {
                                    HashMap next = it2.next();
                                    Object obj = next.get(l.a("005Sgkfmfmffgm"));
                                    if (obj != null && String.valueOf(obj).equals(mbcdi)) {
                                        next.put(l.a("010Keieiei%d6ehekfeelWff"), Boolean.TRUE);
                                        mbcdi = null;
                                    }
                                    HashMap hashMap = new HashMap();
                                    Iterator<String> it3 = g11.iterator();
                                    while (it3.hasNext()) {
                                        String next2 = it3.next();
                                        Object obj2 = next.get(next2);
                                        if (obj2 != null) {
                                            hashMap.put(next2, obj2);
                                        }
                                    }
                                    arrayList.add(hashMap);
                                }
                            }
                        }
                        e.this.a(null);
                        return;
                    }
                } catch (Throwable th2) {
                    MobLog.getInstance().w(th2);
                }
                e eVar = e.this;
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
                eVar.a(arrayList);
            }
        });
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = "";
        if (str.startsWith(l.a("007ijjklmm"))) {
            str = str.replace(l.a("007ijjklmm"), str2);
        }
        if (str.startsWith(DomainTool.DOMAIN_PREFIX)) {
            str = str.replace(DomainTool.DOMAIN_PREFIX, str2);
        }
        if (MobSDK.checkV6()) {
            str2 = l.a("002Deeii");
        } else {
            int i11 = AnonymousClass4.f27349a[MobSDK.getDomain().ordinal()];
            if (i11 == 1) {
                str2 = "jp";
            } else if (i11 == 2) {
                str2 = l.a("002Eehgj");
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return b(l.a("007ijjklmm") + str);
        }
        if (str.startsWith(str2 + InstructionFileId.DOT)) {
            return b(l.a("007ijjklmm") + str);
        }
        return b(l.a("007ijjklmm") + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00aa A[Catch:{ all -> 0x00da }, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r8) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00da }
            if (r0 == 0) goto L_0x0007
            return r8
        L_0x0007:
            boolean r0 = com.mob.MobSDK.checkForceHttps()     // Catch:{ all -> 0x00da }
            if (r0 != 0) goto L_0x001d
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00da }
            r2 = 23
            if (r1 < r2) goto L_0x00e2
            android.security.NetworkSecurityPolicy r1 = android.security.NetworkSecurityPolicy.getInstance()     // Catch:{ all -> 0x00da }
            boolean r1 = r1.isCleartextTrafficPermitted()     // Catch:{ all -> 0x00da }
            if (r1 != 0) goto L_0x00e2
        L_0x001d:
            java.lang.String r8 = r8.trim()     // Catch:{ all -> 0x00da }
            java.lang.String r1 = "007ijjklmm"
            java.lang.String r1 = com.mob.commons.a.l.a((java.lang.String) r1)     // Catch:{ all -> 0x00da }
            boolean r1 = r8.startsWith(r1)     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x00e2
            java.lang.String r1 = r8.trim()     // Catch:{ all -> 0x00da }
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x00e2
            java.lang.String r2 = r1.getScheme()     // Catch:{ all -> 0x00da }
            if (r2 == 0) goto L_0x00e2
            java.lang.String r3 = "004ijjk"
            java.lang.String r3 = com.mob.commons.a.l.a((java.lang.String) r3)     // Catch:{ all -> 0x00da }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x00da }
            if (r2 == 0) goto L_0x00e2
            java.lang.String r2 = r1.getHost()     // Catch:{ all -> 0x00da }
            java.lang.String r3 = r1.getPath()     // Catch:{ all -> 0x00da }
            java.lang.String r4 = r1.getQuery()     // Catch:{ all -> 0x00da }
            java.lang.String r5 = ""
            if (r2 == 0) goto L_0x00ab
            int r1 = r1.getPort()     // Catch:{ all -> 0x00da }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            r6.<init>()     // Catch:{ all -> 0x00da }
            r6.append(r2)     // Catch:{ all -> 0x00da }
            if (r1 <= 0) goto L_0x007e
            r2 = 80
            if (r1 != r2) goto L_0x006c
            goto L_0x007e
        L_0x006c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            r2.<init>()     // Catch:{ all -> 0x00da }
            java.lang.String r7 = ":"
            r2.append(r7)     // Catch:{ all -> 0x00da }
            r2.append(r1)     // Catch:{ all -> 0x00da }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x00da }
            goto L_0x007f
        L_0x007e:
            r1 = r5
        L_0x007f:
            r6.append(r1)     // Catch:{ all -> 0x00da }
            java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x00da }
            if (r0 != 0) goto L_0x00ab
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00da }
            r1 = 24
            if (r0 < r1) goto L_0x00ab
            android.security.NetworkSecurityPolicy r0 = android.security.NetworkSecurityPolicy.getInstance()     // Catch:{ all -> 0x00da }
            java.lang.String r1 = "027Nejgjfe.hge;ekPjg]fjMjEgdekFeFfgfgejPd^hm.gAekegej8jjg-ed"
            java.lang.String r1 = com.mob.commons.a.l.a((java.lang.String) r1)     // Catch:{ all -> 0x00da }
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x00da }
            r7 = 0
            r6[r7] = r2     // Catch:{ all -> 0x00da }
            java.lang.Object r0 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r0, r1, r6)     // Catch:{ all -> 0x00da }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00da }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00da }
            if (r0 == 0) goto L_0x00ab
            return r8
        L_0x00ab:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            r0.<init>()     // Catch:{ all -> 0x00da }
            java.lang.String r1 = "https://"
            r0.append(r1)     // Catch:{ all -> 0x00da }
            r0.append(r2)     // Catch:{ all -> 0x00da }
            if (r3 != 0) goto L_0x00bb
            r3 = r5
        L_0x00bb:
            r0.append(r3)     // Catch:{ all -> 0x00da }
            if (r4 != 0) goto L_0x00c1
            goto L_0x00d2
        L_0x00c1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            r1.<init>()     // Catch:{ all -> 0x00da }
            java.lang.String r2 = "?"
            r1.append(r2)     // Catch:{ all -> 0x00da }
            r1.append(r4)     // Catch:{ all -> 0x00da }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x00da }
        L_0x00d2:
            r0.append(r5)     // Catch:{ all -> 0x00da }
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x00da }
            return r8
        L_0x00da:
            r0 = move-exception
            com.mob.tools.log.NLog r1 = com.mob.tools.MobLog.getInstance()
            r1.d(r0)
        L_0x00e2:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.v.b(java.lang.String):java.lang.String");
    }

    public static void a(File file) throws Throwable {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                b(file);
                return;
            }
            String[] list = file.list();
            if (list == null || list.length == 0) {
                b(file);
                return;
            }
            for (String file2 : list) {
                File file3 = new File(file, file2);
                if (file3.isDirectory()) {
                    a(file3);
                } else {
                    b(file3);
                }
            }
            b(file);
        }
    }

    public static void b(View view) {
        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe("input_method");
        if (systemServiceSafe != null) {
            ((InputMethodManager) systemServiceSafe).toggleSoftInputFromWindow(view.getWindowToken(), 2, 0);
        }
    }

    private static void b(File file) {
        ReflectHelper.invokeInstanceMethod(file, l.a("006>ed.ghgjg"), (Object[]) null, (Class<?>[]) null, null);
    }

    public static void a(View view) {
        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe("input_method");
        if (systemServiceSafe != null) {
            ((InputMethodManager) systemServiceSafe).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static Intent a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (Build.VERSION.SDK_INT < 33) {
            return (Intent) ReflectHelper.invokeInstanceMethod(MobSDK.getContext(), l.a("016GekOg.fkejgj(jgGekhkFgdg!ejee6gIek"), new Object[]{broadcastReceiver, intentFilter}, new Class[]{BroadcastReceiver.class, IntentFilter.class}, null);
        }
        return (Intent) ReflectHelper.invokeInstanceMethod(MobSDK.getContext(), l.a("016=ek=gCfkejgjAjg%ekhk,gdg?ejeeMg)ek"), new Object[]{broadcastReceiver, intentFilter, 4}, new Class[]{BroadcastReceiver.class, IntentFilter.class, Integer.TYPE}, null);
    }

    public static void a(BroadcastReceiver broadcastReceiver) {
        ReflectHelper.invokeInstanceMethod(MobSDK.getContext(), l.a("018FehCf_ek[g!fkejgj9jgNekhkSgdg,ejee^g0ek"), new Object[]{broadcastReceiver}, new Class[]{BroadcastReceiver.class}, null);
    }

    public static boolean a(long j11, long j12) {
        if (j11 <= 0 || j12 <= 0) {
            return false;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(new Date(j11)).equals(simpleDateFormat.format(new Date(j12)));
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return false;
        }
    }

    public static String a(String str, int i11) {
        int i12;
        int i13 = 0;
        int i14 = 3;
        if (str.startsWith("00")) {
            i12 = Integer.parseInt(str.substring(2, 3));
        } else if (str.startsWith("0")) {
            i12 = Integer.parseInt(str.substring(1, 3));
        } else {
            i12 = Integer.parseInt(str.substring(0, 3));
        }
        char[] charArray = str.toCharArray();
        int[] iArr = new int[i12];
        boolean z11 = true;
        while (i14 < charArray.length) {
            if (charArray[i14] < 'a') {
                z11 = !z11;
            } else {
                if (z11) {
                    iArr[i13] = charArray[i14] - i11;
                } else {
                    iArr[i13] = (charArray[i14] - i11) * 10;
                    i14++;
                    iArr[i13] = iArr[i13] + (charArray[i14] - i11);
                }
                int i15 = iArr[i13];
                i13++;
            }
            i14++;
        }
        return c.a(iArr);
    }
}
