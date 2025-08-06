package com.ta.utdid2.device;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.primitives.SignedBytes;
import com.ta.a.e.h;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.bouncycastle.crypto.signers.PSSSigner;
import uy.g;
import vy.b;
import vy.d;
import vy.e;
import vy.f;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f40378a;

    /* renamed from: b  reason: collision with root package name */
    private static Pattern f40379b = Pattern.compile("[^0-9a-zA-Z=/+]+");

    /* renamed from: d  reason: collision with root package name */
    private static final Object f40380d = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static int f40381f = 0;

    /* renamed from: i  reason: collision with root package name */
    private static final String f40382i = (".UTSystemConfig" + File.separator + "Global");
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public wy.c f2402a = null;

    /* renamed from: e  reason: collision with root package name */
    private String f40383e = null;
    private Context mContext = null;

    public interface a {
        void i();
    }

    private c(Context context) {
        this.mContext = context;
        py.a.c().e(context);
        this.f2402a = new wy.c(context, f40382i, "Alvin2");
    }

    private static String b(byte[] bArr) throws Exception {
        byte[] bArr2 = {69, 114, 116, -33, 125, ISO7816.INS_GET_DATA, -31, 86, -11, 11, -78, ISOFileInfo.A0, -17, -99, SignedBytes.MAX_POWER_OF_TWO, 23, ISOFileInfo.A1, -126, -82, ISO7816.INS_GET_RESPONSE, 113, 116, -16, -103, Framer.STDOUT_FRAME_PREFIX, ISO7816.INS_APPEND_RECORD, 9, -39, Framer.ENTER_FRAME_PREFIX, ISO7816.INS_READ_BINARY, PSSSigner.TRAILER_IMPLICIT, -78, ISOFileInfo.SECURITY_ATTR_EXP, 53, 30, -122, SignedBytes.MAX_POWER_OF_TWO, -104, 74, -49, 106, 85, ISO7816.INS_PUT_DATA, -93};
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec(g.c(bArr2), instance.getAlgorithm()));
        return b.f(instance.doFinal(bArr), 2);
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }
        if (24 == str.length()) {
            return !f40379b.matcher(str).find();
        }
        return false;
    }

    private void f(final String str) {
        if (c(str)) {
            f40381f = 6;
            h.e("UTUtdid", "utdid type:", 6);
            this.f2402a.d(str, f40381f);
            a((a) new a() {
                public void i() {
                    c.this.h(str);
                    c.this.f2402a.f();
                }
            });
        }
    }

    private void g(final String str) {
        if (c(str)) {
            a((a) new a() {
                public void i() {
                    if (!str.equals(c.this.f2402a.h())) {
                        c.this.f2402a.g(str);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void h(String str) {
        if (c(str)) {
            try {
                Settings.System.putString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk", str);
            } catch (Exception unused) {
            }
        }
    }

    private String s() {
        String t11 = t();
        if (c(t11)) {
            if (TextUtils.isEmpty(t11) || !t11.endsWith("\n")) {
                this.f40383e = t11;
            } else {
                this.f40383e = t11.substring(0, t11.length() - 1);
            }
            return this.f40383e;
        }
        try {
            byte[] c11 = c();
            if (c11 == null) {
                return null;
            }
            String f11 = b.f(c11, 2);
            this.f40383e = f11;
            f40381f = 6;
            f(f11);
            return this.f40383e;
        } catch (Exception e11) {
            h.d("", e11, new Object[0]);
            return null;
        }
    }

    public static void setType(int i11) {
        f40381f = i11;
    }

    private String t() {
        String u11 = u();
        if (c(u11)) {
            f40381f = 2;
            h.e("UTUtdid", "utdid type", 2);
            g(u11);
            return u11;
        }
        String v11 = v();
        if (c(v11)) {
            f40381f = 2;
            h.e("UTUtdid", "utdid type", 2);
            g(v11);
            return v11;
        }
        final String h11 = this.f2402a.h();
        if (c(h11)) {
            int a11 = this.f2402a.a();
            if (a11 == 0) {
                f40381f = 1;
            } else {
                f40381f = a11;
            }
            h.e("UTUtdid", "get utdid from sp. type", Integer.valueOf(f40381f));
            a((a) new a() {
                public void i() {
                    c.this.h(h11);
                    if (!c.c(c.this.f2402a.i())) {
                        c.this.f2402a.f();
                    }
                }
            });
            return h11;
        }
        final String i11 = this.f2402a.i();
        if (c(i11)) {
            f40381f = 3;
            h.e("UTUtdid", "utdid type", 3);
            this.f2402a.e(f40381f);
            a((a) new a() {
                public void i() {
                    c.this.h(i11);
                }
            });
            return i11;
        }
        h.e("UTUtdid", "read utdid is null");
        Log.d("UTUtdid", "read utdid is null");
        return null;
    }

    private String u() {
        try {
            return Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
        } catch (Exception unused) {
            return "";
        }
    }

    private String v() {
        String str;
        try {
            str = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception unused) {
            str = null;
        }
        try {
            if (f.c(str)) {
                return "";
            }
            e eVar = new e();
            String h11 = eVar.h(str);
            if (c(h11)) {
                h.e("UTUtdid", "OldSettings_1", h11);
                h(h11);
                return h11;
            }
            String g11 = eVar.g(str);
            if (c(g11)) {
                h.e("UTUtdid", "OldSettings_2", g11);
                h(g11);
                return g11;
            }
            String g12 = new d().g(str);
            if (!c(g12)) {
                return "";
            }
            h.e("UTUtdid", "OldSettings_3", g12);
            h(g12);
            return g12;
        } catch (Throwable th2) {
            h.f("UTUtdid", th2, new Object[0]);
            return "";
        }
    }

    public synchronized String getValue() {
        String str = this.f40383e;
        if (str != null) {
            return str;
        }
        return s();
    }

    public static c a(Context context) {
        if (context != null && f40378a == null) {
            synchronized (f40380d) {
                if (f40378a == null) {
                    f40378a = new c(context);
                }
            }
        }
        return f40378a;
    }

    private byte[] c() throws Exception {
        String str;
        h.e("UTUtdid", "generateUtdid");
        Log.d("UTUtdid", "generateUtdid");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int nextInt = new Random().nextInt();
        byte[] a11 = d.a((int) (System.currentTimeMillis() / 1000));
        byte[] a12 = d.a(nextInt);
        byteArrayOutputStream.write(a11, 0, 4);
        byteArrayOutputStream.write(a12, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = e.a(this.mContext);
        } catch (Exception unused) {
            str = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(d.a(f.a(str)), 0, 4);
        byteArrayOutputStream.write(d.a(f.a(b(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    public static void a(final a aVar) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    if (!uy.e.a()) {
                        uy.e.d();
                        return;
                    }
                    aVar.i();
                    uy.e.d();
                } catch (Throwable unused) {
                }
            }
        }).start();
    }
}
