package com.tencent.tpns.baseapi.crosssp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.tpns.baseapi.base.SettingsContentProvider;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ProviderMessage {

    /* renamed from: a  reason: collision with root package name */
    private static SettingsContentProvider f49884a;

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap<String, List<Long>> f49885b = new ConcurrentHashMap<>();

    public static class a<T> extends TTask {

        /* renamed from: a  reason: collision with root package name */
        public static long f49886a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static long f49887b = 0;

        /* renamed from: c  reason: collision with root package name */
        public static long f49888c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static long f49889d = 0;

        /* renamed from: r  reason: collision with root package name */
        private static volatile boolean f49890r = false;

        /* renamed from: s  reason: collision with root package name */
        private static int f49891s;

        /* renamed from: t  reason: collision with root package name */
        private static String f49892t;

        /* renamed from: u  reason: collision with root package name */
        private static ContentProvider f49893u;

        /* renamed from: e  reason: collision with root package name */
        private Context f49894e;

        /* renamed from: g  reason: collision with root package name */
        private Uri f49895g;

        /* renamed from: h  reason: collision with root package name */
        private String[] f49896h;

        /* renamed from: i  reason: collision with root package name */
        private String f49897i;

        /* renamed from: j  reason: collision with root package name */
        private String[] f49898j;

        /* renamed from: k  reason: collision with root package name */
        private String f49899k;

        /* renamed from: l  reason: collision with root package name */
        private ContentValues f49900l;

        /* renamed from: m  reason: collision with root package name */
        private String f49901m;

        /* renamed from: n  reason: collision with root package name */
        private int f49902n = 3;

        /* renamed from: o  reason: collision with root package name */
        private boolean f49903o;

        /* renamed from: p  reason: collision with root package name */
        private int f49904p;

        /* renamed from: q  reason: collision with root package name */
        private T f49905q;

        public a(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            this.f49894e = context;
            this.f49895g = uri;
            this.f49896h = strArr;
            this.f49897i = str;
            this.f49898j = strArr2;
            this.f49899k = str2;
        }

        private static int b(Context context, Uri uri) {
            if (uri != null) {
                String host = uri.getHost();
                a(context);
                if (!TextUtils.isEmpty(host)) {
                    if (host.equals(context.getPackageName() + InstructionFileId.DOT + SettingsContentProvider.PREFFERENCE_AUTHORITY)) {
                        return 1;
                    }
                    if (host.equals(f49892t)) {
                        return 2;
                    }
                }
            }
            return 0;
        }

        public void TRun() {
            Object obj;
            ContentProvider contentProvider;
            ContentProvider contentProvider2;
            ContentProvider contentProvider3;
            try {
                int i11 = this.f49902n;
                if (i11 == 1) {
                    boolean z11 = this.f49903o;
                    if (z11 && this.f49904p == 1) {
                        obj = ProviderMessage.b(this.f49894e).query(this.f49895g, this.f49896h, this.f49897i, this.f49898j, this.f49899k);
                    } else if (!z11 || this.f49904p != 2 || (contentProvider = f49893u) == null) {
                        obj = this.f49894e.getContentResolver().query(this.f49895g, this.f49896h, this.f49897i, this.f49898j, this.f49899k);
                    } else {
                        obj = contentProvider.query(this.f49895g, this.f49896h, this.f49897i, this.f49898j, this.f49899k);
                    }
                } else if (i11 == 2) {
                    boolean z12 = this.f49903o;
                    if (z12 && this.f49904p == 1) {
                        obj = ProviderMessage.b(this.f49894e).insert(this.f49895g, this.f49900l);
                    } else if (!z12 || this.f49904p != 2 || (contentProvider2 = f49893u) == null) {
                        obj = this.f49894e.getContentResolver().insert(this.f49895g, this.f49900l);
                    } else {
                        obj = contentProvider2.insert(this.f49895g, this.f49900l);
                    }
                } else if (i11 == 3) {
                    boolean z13 = this.f49903o;
                    if (z13 && this.f49904p == 1) {
                        obj = ProviderMessage.b(this.f49894e).getType(this.f49895g);
                    } else if (!z13 || this.f49904p != 2 || (contentProvider3 = f49893u) == null) {
                        obj = this.f49894e.getContentResolver().getType(this.f49895g);
                    } else {
                        obj = contentProvider3.getType(this.f49895g);
                    }
                } else if (i11 == 4) {
                    obj = Integer.valueOf(this.f49894e.getContentResolver().update(this.f49895g, this.f49900l, this.f49901m, this.f49898j));
                } else if (i11 != 5) {
                    obj = null;
                } else {
                    obj = Integer.valueOf(this.f49894e.getContentResolver().delete(this.f49895g, this.f49901m, this.f49898j));
                }
                a(obj);
            } catch (Throwable th2) {
                Logger.e("ProviderMessage", TUIConstants.TUICalling.METHOD_NAME_CALL, th2);
            }
        }

        public void a(boolean z11) {
            this.f49903o = z11;
        }

        public void a(int i11) {
            this.f49904p = i11;
        }

        public T a() {
            return this.f49905q;
        }

        public void a(T t11) {
            this.f49905q = t11;
        }

        private static void a(Context context) {
            int intValue;
            try {
                if (!f49890r) {
                    Logger.i("ProviderMessage", "try initXGPushProviderInstance");
                    Class<?> cls = Class.forName("com.tencent.android.tpush.XGPushProvider");
                    Object invoke = cls.getDeclaredMethod("getProviderPid", new Class[0]).invoke(cls, new Object[0]);
                    if (invoke != null && (intValue = ((Integer) invoke).intValue()) == Process.myPid()) {
                        f49893u = (ContentProvider) cls.newInstance();
                        f49891s = intValue;
                        Object invoke2 = cls.getDeclaredMethod("getProviderAuthority", new Class[]{Context.class}).invoke(cls, new Object[]{context});
                        if (invoke2 != null) {
                            f49892t = (String) invoke2;
                        }
                        Logger.i("ProviderMessage", "initXGPushProviderInstance success pushProviderPid: " + f49891s + ", pushProviderAuthority: " + f49892t);
                    }
                    f49890r = true;
                }
            } catch (Throwable th2) {
                Logger.w("ProviderMessage", "initXGPushProviderInstance error: " + th2.toString());
            }
        }

        public a(Context context, Uri uri, ContentValues contentValues) {
            this.f49894e = context;
            this.f49895g = uri;
            this.f49900l = contentValues;
        }

        public a(Context context, Uri uri) {
            this.f49894e = context;
            this.f49895g = uri;
        }

        public a(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
            this.f49894e = context;
            this.f49895g = uri;
            this.f49900l = contentValues;
            this.f49901m = str;
            this.f49898j = strArr;
        }

        public static Cursor a(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            ContentProvider contentProvider;
            int b11 = b(context, uri);
            int myPid = Process.myPid();
            long id2 = Thread.currentThread().getId();
            long id3 = context.getMainLooper().getThread().getId();
            boolean z11 = true;
            if (b11 == 1) {
                if (myPid == SettingsContentProvider.getProviderPid()) {
                    if (id2 != id3) {
                        return ProviderMessage.b(context).query(uri, strArr, str, strArr2, str2);
                    }
                    a aVar = new a(context, uri, strArr, str, strArr2, str2);
                    aVar.a(b11);
                    aVar.a(z11);
                    Thread thread = new Thread(aVar);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("tpnsQ-");
                    long j11 = f49886a;
                    f49886a = 1 + j11;
                    sb2.append(j11);
                    thread.setName(sb2.toString());
                    thread.start();
                    thread.join(1000);
                    return (Cursor) aVar.a();
                }
            } else if (b11 == 2 && myPid == f49891s) {
                if (!(id2 == id3 || (contentProvider = f49893u) == null)) {
                    return contentProvider.query(uri, strArr, str, strArr2, str2);
                }
                a aVar2 = new a(context, uri, strArr, str, strArr2, str2);
                aVar2.a(b11);
                aVar2.a(z11);
                Thread thread2 = new Thread(aVar2);
                StringBuilder sb22 = new StringBuilder();
                sb22.append("tpnsQ-");
                long j112 = f49886a;
                f49886a = 1 + j112;
                sb22.append(j112);
                thread2.setName(sb22.toString());
                thread2.start();
                thread2.join(1000);
                return (Cursor) aVar2.a();
            }
            z11 = false;
            a aVar22 = new a(context, uri, strArr, str, strArr2, str2);
            aVar22.a(b11);
            aVar22.a(z11);
            Thread thread22 = new Thread(aVar22);
            StringBuilder sb222 = new StringBuilder();
            sb222.append("tpnsQ-");
            long j1122 = f49886a;
            f49886a = 1 + j1122;
            sb222.append(j1122);
            thread22.setName(sb222.toString());
            thread22.start();
            try {
                thread22.join(1000);
            } catch (Throwable th2) {
                Logger.e("ProviderMessage", "myQuery", th2);
            }
            return (Cursor) aVar22.a();
        }

        public a(Context context, Uri uri, String str, String[] strArr) {
            this.f49894e = context;
            this.f49895g = uri;
            this.f49901m = str;
            this.f49898j = strArr;
        }

        public static Uri a(Context context, Uri uri, ContentValues contentValues) {
            ContentProvider contentProvider;
            int b11 = b(context, uri);
            int myPid = Process.myPid();
            long id2 = Thread.currentThread().getId();
            long id3 = context.getMainLooper().getThread().getId();
            boolean z11 = true;
            if (b11 == 1) {
                if (myPid == SettingsContentProvider.getProviderPid()) {
                    if (id2 != id3) {
                        return ProviderMessage.b(context).insert(uri, contentValues);
                    }
                    a aVar = new a(context, uri, contentValues);
                    aVar.a(b11);
                    aVar.a(z11);
                    Thread thread = new Thread(aVar);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("tpnsT-");
                    long j11 = f49887b;
                    f49887b = 1 + j11;
                    sb2.append(j11);
                    thread.setName(sb2.toString());
                    thread.start();
                    thread.join(1000);
                    return (Uri) aVar.a();
                }
            } else if (b11 == 2 && myPid == f49891s) {
                if (!(id2 == id3 || (contentProvider = f49893u) == null)) {
                    return contentProvider.insert(uri, contentValues);
                }
                a aVar2 = new a(context, uri, contentValues);
                aVar2.a(b11);
                aVar2.a(z11);
                Thread thread2 = new Thread(aVar2);
                StringBuilder sb22 = new StringBuilder();
                sb22.append("tpnsT-");
                long j112 = f49887b;
                f49887b = 1 + j112;
                sb22.append(j112);
                thread2.setName(sb22.toString());
                thread2.start();
                thread2.join(1000);
                return (Uri) aVar2.a();
            }
            z11 = false;
            a aVar22 = new a(context, uri, contentValues);
            aVar22.a(b11);
            aVar22.a(z11);
            Thread thread22 = new Thread(aVar22);
            StringBuilder sb222 = new StringBuilder();
            sb222.append("tpnsT-");
            long j1122 = f49887b;
            f49887b = 1 + j1122;
            sb222.append(j1122);
            thread22.setName(sb222.toString());
            thread22.start();
            try {
                thread22.join(1000);
            } catch (Throwable th2) {
                Logger.e("ProviderMessage", "myInsert", th2);
            }
            return (Uri) aVar22.a();
        }

        public static String a(Context context, Uri uri) {
            ContentProvider contentProvider;
            int b11 = b(context, uri);
            int myPid = Process.myPid();
            long id2 = Thread.currentThread().getId();
            long id3 = context.getMainLooper().getThread().getId();
            boolean z11 = true;
            if (b11 == 1) {
                if (myPid == SettingsContentProvider.getProviderPid()) {
                    if (id2 != id3) {
                        return ProviderMessage.b(context).getType(uri);
                    }
                    a aVar = new a(context, uri);
                    aVar.a(b11);
                    aVar.a(z11);
                    Thread thread = new Thread(aVar);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("tpnsT");
                    sb2.append(myPid);
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    long j11 = f49888c;
                    f49888c = 1 + j11;
                    sb2.append(j11);
                    thread.setName(sb2.toString());
                    thread.start();
                    thread.join(1000);
                    return (String) aVar.a();
                }
            } else if (b11 == 2 && myPid == f49891s) {
                if (!(id2 == id3 || (contentProvider = f49893u) == null)) {
                    return contentProvider.getType(uri);
                }
                a aVar2 = new a(context, uri);
                aVar2.a(b11);
                aVar2.a(z11);
                Thread thread2 = new Thread(aVar2);
                StringBuilder sb22 = new StringBuilder();
                sb22.append("tpnsT");
                sb22.append(myPid);
                sb22.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                long j112 = f49888c;
                f49888c = 1 + j112;
                sb22.append(j112);
                thread2.setName(sb22.toString());
                thread2.start();
                thread2.join(1000);
                return (String) aVar2.a();
            }
            z11 = false;
            a aVar22 = new a(context, uri);
            aVar22.a(b11);
            aVar22.a(z11);
            Thread thread22 = new Thread(aVar22);
            StringBuilder sb222 = new StringBuilder();
            sb222.append("tpnsT");
            sb222.append(myPid);
            sb222.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            long j1122 = f49888c;
            f49888c = 1 + j1122;
            sb222.append(j1122);
            thread22.setName(sb222.toString());
            thread22.start();
            try {
                thread22.join(1000);
            } catch (Throwable th2) {
                Logger.e("ProviderMessage", "myGetType", th2);
            }
            return (String) aVar22.a();
        }

        public static int a(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
            a aVar = new a(context, uri, contentValues, str, strArr);
            Thread thread = new Thread(aVar);
            thread.setName("tpnsU");
            thread.start();
            try {
                thread.join(1000);
            } catch (Throwable th2) {
                Logger.e("ProviderMessage", "myUpdate", th2);
            }
            return ((Integer) aVar.a()).intValue();
        }

        public static int a(Context context, Uri uri, String str, String[] strArr) {
            a aVar = new a(context, uri, str, strArr);
            Thread thread = new Thread(aVar);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("tpnsD-");
            long j11 = f49889d;
            f49889d = 1 + j11;
            sb2.append(j11);
            thread.setName(sb2.toString());
            thread.start();
            try {
                thread.join(1000);
            } catch (Throwable th2) {
                Logger.e("ProviderMessage", "myDelete", th2);
            }
            return ((Integer) aVar.a()).intValue();
        }
    }

    /* access modifiers changed from: private */
    public static SettingsContentProvider b(Context context) {
        if (f49884a == null) {
            f49884a = new SettingsContentProvider(context);
        }
        return f49884a;
    }

    public static int delete(Context context, String str, String str2, String str3, String[] strArr) {
        return delete(context, Uri.parse("content://" + str + "/" + str2), str3, strArr);
    }

    public static String getType(Context context, Uri uri) {
        try {
            return a.a(context, uri);
        } catch (Throwable th2) {
            Logger.e("ProviderMessage", "getType", th2);
            return null;
        }
    }

    public static Uri insert(Context context, Uri uri, ContentValues contentValues) {
        try {
            return a.a(context, uri, contentValues);
        } catch (Throwable th2) {
            Logger.e("ProviderMessage", "insert", th2);
            return null;
        }
    }

    public static void log(String str) {
        Logger.d("ProviderMessage", "" + str);
    }

    public static Cursor query(Context context, String str, String str2, String[] strArr, String str3, String[] strArr2, String str4) {
        return query(context, Uri.parse("content://" + str + "/" + str2), strArr, str3, strArr2, str4);
    }

    public static int update(Context context, String str, String str2, ContentValues contentValues, String str3, String[] strArr) {
        return update(context, Uri.parse("content://" + str + "/" + str2), contentValues, str3, strArr);
    }

    public static String getType(Context context, String str, String str2) {
        return getType(context, Uri.parse("content://" + str + "/" + str2));
    }

    public static Uri insert(Context context, String str, String str2, ContentValues contentValues) {
        return insert(context, Uri.parse("content://" + str + "/" + str2), contentValues);
    }

    public static int delete(Context context, Uri uri, String str, String[] strArr) {
        try {
            return a.a(context, uri, str, strArr);
        } catch (Throwable th2) {
            Logger.e("ProviderMessage", "delete", th2);
            return 0;
        }
    }

    public static Cursor query(Context context, Uri uri, String[] strArr, String str) {
        return query(context, uri, strArr, str, (String[]) null, (String) null);
    }

    public static int update(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            return a.a(context, uri, contentValues, str, strArr);
        } catch (Throwable th2) {
            Logger.e("ProviderMessage", "update", th2);
            return 0;
        }
    }

    public static Cursor query(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return a.a(context, uri, strArr, str, strArr2, str2);
        } catch (Throwable th2) {
            Logger.e("ProviderMessage", "query", th2);
            return null;
        }
    }
}
