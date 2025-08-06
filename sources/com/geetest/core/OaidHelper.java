package com.geetest.core;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.huochat.community.util.FileTool;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;

public class OaidHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final e f65301a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f65302b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f65303c = false;

    /* renamed from: d  reason: collision with root package name */
    public static PackageManager f65304d;

    public static class a extends j {
        public a() {
            super("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService", "com.asus.msa.action.ACCESS_DID", "com.asus.msa.SupplementaryDID.IDidAidlInterface");
        }

        public final int a() {
            return 2;
        }
    }

    public static class b extends j {
        public b() {
            super("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService", (String) null, "com.coolpad.deviceidsupport.IDeviceIdManager");
        }

        public final int a() {
            return 2;
        }
    }

    public static class c extends j {
        public c() {
            super("com.huawei.hwid", (String) null, "com.uodis.opendevice.OPENIDS_SERVICE", "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }
    }

    public static class d implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        public final IBinder f65305a;

        /* renamed from: b  reason: collision with root package name */
        public final String f65306b;

        public d(IBinder iBinder, String str) {
            this.f65305a = iBinder;
            this.f65306b = str;
        }

        public final String a(String str, String str2, String str3, int i11) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(this.f65306b);
                if (!TextUtils.isEmpty(str)) {
                    obtain.writeString(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    obtain.writeString(str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    obtain.writeString(str3);
                }
                this.f65305a.transact(i11, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } catch (Throwable th2) {
                th2.printStackTrace();
                try {
                    obtain.recycle();
                    obtain2.recycle();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                return "";
            }
        }

        public final IBinder asBinder() {
            return this.f65305a;
        }
    }

    public interface e {
        boolean a(Context context);

        String b(Context context);

        boolean c(Context context);
    }

    public static class f extends j {
        public f() {
            super("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService", (String) null, "com.zui.deviceidservice.IDeviceidInterface");
        }
    }

    public static class g extends h {
        public g() {
            super("com.meizu.flyme.openidsdk", "");
        }

        public final boolean a(Context context) {
            if (!super.a(context)) {
                try {
                    Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), (String[]) null, (String) null, new String[]{"support"}, (String) null);
                    if (query == null) {
                        return false;
                    }
                    query.moveToFirst();
                    int columnIndex = query.getColumnIndex("value");
                    if (columnIndex >= 0) {
                        String string = query.getString(columnIndex);
                        if (TextUtils.isEmpty(string)) {
                            return false;
                        }
                        h.f65308f = "0".equals(string);
                    } else {
                        h.f65308f = false;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    h.f65308f = false;
                    return false;
                }
            } else {
                h.f65308f = true;
            }
            this.f65312d = true;
            return h.f65308f;
        }

        public final String b(Context context) {
            this.f65311c = new String[]{"oaid"};
            return super.b(context);
        }
    }

    public static class h implements e {

        /* renamed from: e  reason: collision with root package name */
        public static String f65307e = null;

        /* renamed from: f  reason: collision with root package name */
        public static boolean f65308f = false;

        /* renamed from: a  reason: collision with root package name */
        public final String f65309a;

        /* renamed from: b  reason: collision with root package name */
        public final String f65310b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f65311c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f65312d = false;

        public h(String str, String str2) {
            this.f65309a = str;
            this.f65310b = str2;
        }

        public boolean a(Context context) {
            if (this.f65312d) {
                return f65308f;
            }
            if (context == null) {
                return false;
            }
            try {
                PackageManager access$000 = OaidHelper.getPackageManager(context);
                f65308f = (access$000 == null || access$000.resolveContentProvider(this.f65309a, 0) == null) ? false : true;
            } catch (Throwable th2) {
                th2.printStackTrace();
                f65308f = false;
            }
            this.f65312d = true;
            return f65308f;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x004c, code lost:
            if (r8 != null) goto L_0x0058;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String b(android.content.Context r8) {
            /*
                r7 = this;
                java.lang.String r0 = f65307e
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L_0x0063
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "content://"
                r0.append(r1)
                java.lang.String r1 = r7.f65309a
                r0.append(r1)
                java.lang.String r1 = "/"
                r0.append(r1)
                java.lang.String r1 = r7.f65310b
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                android.net.Uri r2 = android.net.Uri.parse(r0)
                r0 = 0
                android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ all -> 0x004f }
                r3 = 0
                r4 = 0
                java.lang.String[] r5 = r7.f65311c     // Catch:{ all -> 0x004f }
                r6 = 0
                android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x004f }
                if (r8 == 0) goto L_0x004c
                r8.moveToFirst()     // Catch:{ all -> 0x004a }
                java.lang.String r1 = "value"
                int r1 = r8.getColumnIndex(r1)     // Catch:{ all -> 0x004a }
                java.lang.String r1 = r8.getString(r1)     // Catch:{ all -> 0x004a }
                f65307e = r1     // Catch:{ all -> 0x004a }
                goto L_0x004c
            L_0x004a:
                r1 = move-exception
                goto L_0x0051
            L_0x004c:
                if (r8 == 0) goto L_0x0063
                goto L_0x0058
            L_0x004f:
                r1 = move-exception
                r8 = r0
            L_0x0051:
                r1.printStackTrace()     // Catch:{ all -> 0x005c }
                f65307e = r0     // Catch:{ all -> 0x005c }
                if (r8 == 0) goto L_0x0063
            L_0x0058:
                r8.close()
                goto L_0x0063
            L_0x005c:
                r0 = move-exception
                if (r8 == 0) goto L_0x0062
                r8.close()
            L_0x0062:
                throw r0
            L_0x0063:
                java.lang.String r8 = f65307e
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geetest.core.OaidHelper.h.b(android.content.Context):java.lang.String");
        }

        public final boolean c(Context context) {
            return true;
        }
    }

    public static class i implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public d f65313a;

        /* renamed from: b  reason: collision with root package name */
        public final String f65314b;

        /* renamed from: c  reason: collision with root package name */
        public final CountDownLatch f65315c;

        /* renamed from: d  reason: collision with root package name */
        public IBinder f65316d;

        public i(String str, CountDownLatch countDownLatch) {
            this.f65314b = str;
            this.f65315c = countDownLatch;
        }

        /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(android.content.Context r4, android.content.Intent r5) {
            /*
                r3 = this;
                com.geetest.core.OaidHelper$d r0 = r3.f65313a
                r1 = 1
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                boolean r4 = r4.bindService(r5, r3, r1)     // Catch:{ all -> 0x0030 }
                java.util.concurrent.CountDownLatch r5 = r3.f65315c     // Catch:{ all -> 0x0030 }
                r0 = 1
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0030 }
                r5.await(r0, r2)     // Catch:{ all -> 0x0030 }
                android.os.IBinder r5 = r3.f65316d     // Catch:{ all -> 0x0030 }
                java.lang.String r0 = r3.f65314b     // Catch:{ all -> 0x0030 }
                if (r5 != 0) goto L_0x001b
                r5 = 0
                goto L_0x002d
            L_0x001b:
                android.os.IInterface r1 = r5.queryLocalInterface(r0)     // Catch:{ all -> 0x0030 }
                boolean r2 = r1 instanceof com.geetest.core.OaidHelper.d     // Catch:{ all -> 0x0030 }
                if (r2 == 0) goto L_0x0027
                r5 = r1
                com.geetest.core.OaidHelper$d r5 = (com.geetest.core.OaidHelper.d) r5     // Catch:{ all -> 0x0030 }
                goto L_0x002d
            L_0x0027:
                com.geetest.core.OaidHelper$d r1 = new com.geetest.core.OaidHelper$d     // Catch:{ all -> 0x0030 }
                r1.<init>(r5, r0)     // Catch:{ all -> 0x0030 }
                r5 = r1
            L_0x002d:
                r3.f65313a = r5     // Catch:{ all -> 0x0030 }
                return r4
            L_0x0030:
                r4 = move-exception
                r4.printStackTrace()
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geetest.core.OaidHelper.i.a(android.content.Context, android.content.Intent):boolean");
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f65316d = iBinder;
                this.f65315c.countDown();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            this.f65313a = null;
            this.f65316d = null;
        }
    }

    public static class j implements e {

        /* renamed from: f  reason: collision with root package name */
        public static String f65317f = null;

        /* renamed from: g  reason: collision with root package name */
        public static boolean f65318g = false;

        /* renamed from: h  reason: collision with root package name */
        public static boolean f65319h = false;

        /* renamed from: i  reason: collision with root package name */
        public static final CountDownLatch f65320i = new CountDownLatch(1);

        /* renamed from: a  reason: collision with root package name */
        public final String f65321a;

        /* renamed from: b  reason: collision with root package name */
        public final String f65322b;

        /* renamed from: c  reason: collision with root package name */
        public final String f65323c;

        /* renamed from: d  reason: collision with root package name */
        public final String f65324d;

        /* renamed from: e  reason: collision with root package name */
        public i f65325e;

        public j(String str, String str2, String str3, String str4) {
            this.f65321a = str;
            this.f65322b = str2;
            this.f65323c = str3;
            this.f65324d = str4;
        }

        public int a() {
            return 1;
        }

        public boolean a(Context context) {
            if (f65319h) {
                return f65318g;
            }
            boolean z11 = false;
            if (context == null || TextUtils.isEmpty(this.f65321a)) {
                f65318g = false;
            } else {
                try {
                    PackageInfo packageInfo = OaidHelper.getPackageManager(context).getPackageInfo(this.f65321a, 0);
                    if (Build.VERSION.SDK_INT < 28) {
                        if (packageInfo != null && packageInfo.versionCode > 0) {
                            z11 = true;
                        }
                        f65318g = z11;
                    } else if (packageInfo == null || packageInfo.getLongVersionCode() < 1) {
                        return false;
                    } else {
                        return true;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return false;
                }
            }
            f65319h = true;
            return f65318g;
        }

        public String b() {
            return null;
        }

        public String b(Context context) {
            i iVar;
            d dVar;
            i iVar2;
            if (!TextUtils.isEmpty(f65317f) || (iVar = this.f65325e) == null || (dVar = iVar.f65313a) == null) {
                return f65317f;
            }
            try {
                String a11 = dVar.a(d(context), e(context), b(), a());
                f65317f = a11;
                if (!TextUtils.isEmpty(a11) && (iVar2 = this.f65325e) != null) {
                    context.unbindService(iVar2);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return f65317f;
        }

        public boolean c(Context context) {
            if (context == null || TextUtils.isEmpty(this.f65321a)) {
                return false;
            }
            if (this.f65325e == null) {
                this.f65325e = new i(this.f65324d, f65320i);
            }
            Intent intent = new Intent();
            if (TextUtils.isEmpty(this.f65322b)) {
                intent.setPackage(this.f65321a);
            } else {
                intent.setComponent(new ComponentName(this.f65321a, this.f65322b));
            }
            if (!TextUtils.isEmpty(this.f65323c)) {
                intent.setAction(this.f65323c);
            }
            return this.f65325e.a(context, intent);
        }

        public String d(Context context) {
            return null;
        }

        public String e(Context context) {
            return null;
        }
    }

    public static class k extends j {

        /* renamed from: j  reason: collision with root package name */
        public String f65326j;

        /* renamed from: k  reason: collision with root package name */
        public String f65327k;

        public k() {
            super("com.heytap.openid", "com.heytap.openid.IdentifyService", "action.com.heytap.openid.OPEN_ID_SERVICE", "com.heytap.openid.IOpenID");
        }

        public final String b() {
            return "OUID";
        }

        public final String d(Context context) {
            if (TextUtils.isEmpty(this.f65327k)) {
                this.f65327k = context.getPackageName();
            }
            return this.f65327k;
        }

        @SuppressLint({"PackageManagerGetSignatures"})
        public final String e(Context context) {
            if (TextUtils.isEmpty(this.f65326j)) {
                try {
                    if (TextUtils.isEmpty(this.f65327k)) {
                        this.f65327k = context.getPackageName();
                    }
                    this.f65327k = this.f65327k;
                    Signature[] signatureArr = OaidHelper.getPackageManager(context).getPackageInfo(this.f65327k, 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        byte[] digest = MessageDigest.getInstance(FileTool.HASH_TYPE_SHA1).digest(signatureArr[0].toByteArray());
                        StringBuilder sb2 = new StringBuilder();
                        for (byte b11 : digest) {
                            sb2.append(Integer.toHexString((b11 & 255) | 256).substring(1, 3));
                        }
                        this.f65326j = sb2.toString();
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            return this.f65326j;
        }
    }

    public static class l extends j {
        public l() {
            super("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService", (String) null, "com.samsung.android.deviceidservice.IDeviceIdService");
        }
    }

    public static class m extends h {
        public m() {
            super("com.vivo.vms.IdProvider", "IdentifierId/OAID");
        }
    }

    public static class n implements e {

        /* renamed from: b  reason: collision with root package name */
        public static String f65328b;

        /* renamed from: a  reason: collision with root package name */
        public Class f65329a = null;

        @SuppressLint({"PrivateApi"})
        public final boolean a(Context context) {
            try {
                this.f65329a = Class.forName("com.android.id.impl.IdProviderImpl");
                return true;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return false;
            }
        }

        public final String b(Context context) {
            if (TextUtils.isEmpty(f65328b)) {
                try {
                    Object newInstance = this.f65329a.newInstance();
                    f65328b = String.valueOf(this.f65329a.getMethod("getOAID", new Class[]{Context.class}).invoke(newInstance, new Object[]{context}));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    f65328b = null;
                }
            }
            return f65328b;
        }

        public final boolean c(Context context) {
            return true;
        }
    }

    static {
        e eVar;
        String upperCase = Build.MANUFACTURER.toUpperCase();
        upperCase.hashCode();
        char c11 = 65535;
        switch (upperCase.hashCode()) {
            case -2053026509:
                if (upperCase.equals("LENOVO")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1712043046:
                if (upperCase.equals("SAMSUNG")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1706170181:
                if (upperCase.equals("XIAOMI")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1134767290:
                if (upperCase.equals("BLACKSHARK")) {
                    c11 = 3;
                    break;
                }
                break;
            case -602397472:
                if (upperCase.equals("ONEPLUS")) {
                    c11 = 4;
                    break;
                }
                break;
            case 89198:
                if (upperCase.equals("ZUI")) {
                    c11 = 5;
                    break;
                }
                break;
            case 2018896:
                if (upperCase.equals("ASUS")) {
                    c11 = 6;
                    break;
                }
                break;
            case 2255112:
                if (upperCase.equals("IQOO")) {
                    c11 = 7;
                    break;
                }
                break;
            case 2432928:
                if (upperCase.equals("OPPO")) {
                    c11 = 8;
                    break;
                }
                break;
            case 2634924:
                if (upperCase.equals("VIVO")) {
                    c11 = 9;
                    break;
                }
                break;
            case 68924490:
                if (upperCase.equals(SystemUtils.PRODUCT_HONOR)) {
                    c11 = 10;
                    break;
                }
                break;
            case 73239724:
                if (upperCase.equals("MEIZU")) {
                    c11 = 11;
                    break;
                }
                break;
            case 77852109:
                if (upperCase.equals("REDMI")) {
                    c11 = 12;
                    break;
                }
                break;
            case 1670208650:
                if (upperCase.equals("COOLPAD")) {
                    c11 = 13;
                    break;
                }
                break;
            case 1972178256:
                if (upperCase.equals("HUA_WEI")) {
                    c11 = 14;
                    break;
                }
                break;
            case 2141820391:
                if (upperCase.equals("HUAWEI")) {
                    c11 = 15;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 5:
                eVar = new f();
                break;
            case 1:
                eVar = new l();
                break;
            case 2:
            case 3:
            case 12:
                eVar = new n();
                break;
            case 4:
            case 8:
                eVar = new k();
                break;
            case 6:
                eVar = new a();
                break;
            case 7:
            case 9:
                eVar = new m();
                break;
            case 10:
            case 14:
            case 15:
                eVar = new c();
                break;
            case 11:
                eVar = new g();
                break;
            case 13:
                eVar = new b();
                break;
            default:
                eVar = null;
                break;
        }
        f65301a = eVar;
    }

    private OaidHelper() {
    }

    public static String getOaid(Context context) {
        isSupport(context);
        if (f65303c) {
            return getOaid();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static PackageManager getPackageManager(Context context) {
        if (f65304d == null) {
            f65304d = context.getPackageManager();
        }
        return f65304d;
    }

    private static void isSupport(Context context) {
        e eVar = f65301a;
        if (eVar != null && context != null) {
            f65302b = context.getApplicationContext();
            if (isSupportService()) {
                f65303c = eVar.c(f65302b);
            }
        }
    }

    private static boolean isSupportService() {
        e eVar;
        try {
            Context context = f65302b;
            if (context == null || (eVar = f65301a) == null || !eVar.a(context)) {
                return false;
            }
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    private static String getOaid() {
        e eVar;
        try {
            Context context = f65302b;
            if (context == null || (eVar = f65301a) == null || !f65303c) {
                return null;
            }
            return eVar.b(context);
        } catch (Throwable unused) {
            return null;
        }
    }
}
