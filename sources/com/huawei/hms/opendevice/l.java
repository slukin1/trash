package com.huawei.hms.opendevice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.huawei.android.hms.openid.R$string;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.encrypt.utils.BaseKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.util.IOUtil;
import e7.s;
import ig.b;
import ig.c;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    private static final String f38323a = "l";

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, String> f38324b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f38325c = new Object();

    private static String a() {
        return "2A57086C86EF54970C1E6EB37BFC72B1";
    }

    private static byte[] a(String str, String str2, String str3, String str4) {
        if (Build.VERSION.SDK_INT >= 26) {
            return BaseKeyUtil.e(str, str2, str3, str4, 32, true);
        }
        return BaseKeyUtil.e(str, str2, str3, str4, 32, false);
    }

    private static byte[] b() {
        return a(d(), e(), c(), g());
    }

    public static void c(Context context) {
        synchronized (f38325c) {
            d(context.getApplicationContext());
            if (i()) {
                HMSLog.i(f38323a, "The local secret is already in separate file mode.");
                return;
            }
            File file = new File(e.c(context.getApplicationContext()) + "/shared_prefs/LocalAvengers.xml");
            if (file.exists()) {
                IOUtil.a(file);
                HMSLog.i(f38323a, "destroy C, delete file LocalAvengers.xml.");
            }
            byte[] c11 = EncryptUtil.c(32);
            byte[] c12 = EncryptUtil.c(32);
            byte[] c13 = EncryptUtil.c(32);
            byte[] c14 = EncryptUtil.c(32);
            String a11 = d.a(c11);
            String a12 = d.a(c12);
            String a13 = d.a(c13);
            String a14 = d.a(c14);
            a(a11, a12, a13, a14, c.c(d.a(EncryptUtil.c(32)), a(a11, a12, a13, a14)), context);
            HMSLog.i(f38323a, "generate D.");
        }
    }

    private static void d(Context context) {
        if (i()) {
            HMSLog.i(f38323a, "secretKeyCache not empty.");
            return;
        }
        f38324b.clear();
        String c11 = e.c(context);
        if (!TextUtils.isEmpty(c11)) {
            String a11 = m.a(c11 + "/files/math/m");
            String a12 = m.a(c11 + "/files/panda/p");
            String a13 = m.a(c11 + "/files/panda/d");
            String a14 = m.a(c11 + "/files/math/t");
            String a15 = m.a(c11 + "/files/s");
            if (n.a(a11, a12, a13, a14, a15)) {
                f38324b.put("m", a11);
                f38324b.put(TtmlNode.TAG_P, a12);
                f38324b.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, a13);
                f38324b.put("t", a14);
                f38324b.put(s.f70071a, a15);
            }
        }
    }

    private static synchronized String e(Context context) {
        synchronized (l.class) {
            String b11 = c.b(f(), b());
            if (n.a(b11)) {
                HMSLog.i(f38323a, "keyS has been upgraded, no require operate again.");
                return b11;
            }
            String a11 = c.a(f(), h());
            if (n.a(a11)) {
                HMSLog.i(f38323a, "keyS is encrypt by RootKeyUtil, upgrade encrypt mode.");
                a(c.c(a11, b()), context);
                return a11;
            }
            String b12 = c.b(f(), BaseKeyUtil.e(d(), e(), c(), g(), 32, false));
            if (n.a(b12)) {
                HMSLog.i(f38323a, "keyS is encrypt by ExportRootKey with sha1, upgrade encrypt mode to sha256.");
                a(c.c(b12, b()), context);
                return b12;
            }
            HMSLog.e(f38323a, "all mode unable to decrypt root key.");
            return "";
        }
    }

    private static String f() {
        return a(s.f70071a);
    }

    private static String g() {
        return a("t");
    }

    private static b h() {
        return b.d(d(), e(), c(), g());
    }

    private static boolean i() {
        return !TextUtils.isEmpty(f());
    }

    public static String b(Context context) {
        if (!i()) {
            HMSLog.i(f38323a, "work key is empty, execute init.");
            c(context);
        }
        String b11 = c.b(f(), b());
        if (n.a(b11)) {
            return b11;
        }
        return e(context);
    }

    public static byte[] a(Context context) {
        byte[] a11 = d.a(context.getString(R$string.push_cat_head));
        byte[] a12 = d.a(context.getString(R$string.push_cat_body));
        return a(a(a(a11, a12), d.a(a())));
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        if (length != bArr2.length) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr3[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
        }
        return bArr3;
    }

    private static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr[i11] = (byte) (bArr[i11] >> 2);
        }
        return bArr;
    }

    private static void a(String str, String str2, String str3, String str4, String str5, Context context) {
        String c11 = e.c(context.getApplicationContext());
        if (!TextUtils.isEmpty(c11)) {
            try {
                a("m", str, c11 + "/files/math/m");
                a(TtmlNode.TAG_P, str2, c11 + "/files/panda/p");
                a(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, str3, c11 + "/files/panda/d");
                a("t", str4, c11 + "/files/math/t");
                a(s.f70071a, str5, c11 + "/files/s");
            } catch (IOException unused) {
                HMSLog.e(f38323a, "save key IOException.");
            }
        }
    }

    private static String d() {
        return a("m");
    }

    private static String e() {
        return a(TtmlNode.TAG_P);
    }

    private static String c() {
        return a(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
    }

    private static void a(String str, Context context) {
        String c11 = e.c(context.getApplicationContext());
        if (!TextUtils.isEmpty(c11)) {
            try {
                a(s.f70071a, str, c11 + "/files/s");
            } catch (IOException unused) {
                HMSLog.e(f38323a, "save keyS IOException.");
            }
        }
    }

    private static void a(String str, String str2, String str3) throws IOException {
        OutputStreamWriter outputStreamWriter;
        HMSLog.i(f38323a, "save local secret key.");
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(str3);
            m.a(file);
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(outputStreamWriter);
                try {
                    bufferedWriter2.write(str2);
                    bufferedWriter2.flush();
                    f38324b.put(str, str2);
                    IOUtils.closeQuietly((Writer) outputStreamWriter);
                    IOUtils.closeQuietly((Writer) bufferedWriter2);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    IOUtils.closeQuietly((Writer) outputStreamWriter);
                    IOUtils.closeQuietly((Writer) bufferedWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                IOUtils.closeQuietly((Writer) outputStreamWriter);
                IOUtils.closeQuietly((Writer) bufferedWriter);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            outputStreamWriter = null;
            IOUtils.closeQuietly((Writer) outputStreamWriter);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            throw th;
        }
    }

    private static String a(String str) {
        String str2 = f38324b.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
