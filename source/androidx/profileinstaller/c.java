package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final AssetManager f10477a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f10478b;

    /* renamed from: c  reason: collision with root package name */
    public final h.c f10479c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f10480d;

    /* renamed from: e  reason: collision with root package name */
    public final File f10481e;

    /* renamed from: f  reason: collision with root package name */
    public final String f10482f;

    /* renamed from: g  reason: collision with root package name */
    public final String f10483g;

    /* renamed from: h  reason: collision with root package name */
    public final String f10484h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10485i = false;

    /* renamed from: j  reason: collision with root package name */
    public d[] f10486j;

    /* renamed from: k  reason: collision with root package name */
    public byte[] f10487k;

    public c(AssetManager assetManager, Executor executor, h.c cVar, String str, String str2, String str3, File file) {
        this.f10477a = assetManager;
        this.f10478b = executor;
        this.f10479c = cVar;
        this.f10482f = str;
        this.f10483g = str2;
        this.f10484h = str3;
        this.f10481e = file;
        this.f10480d = d();
    }

    public static byte[] d() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 24 || i11 > 33) {
            return null;
        }
        switch (i11) {
            case 24:
            case 25:
                return o.f10524e;
            case 26:
                return o.f10523d;
            case 27:
                return o.f10522c;
            case 28:
            case 29:
            case 30:
                return o.f10521b;
            case 31:
            case 32:
            case 33:
                return o.f10520a;
            default:
                return null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(int i11, Object obj) {
        this.f10479c.a(i11, obj);
    }

    public static boolean k() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 24 || i11 > 33) {
            return false;
        }
        if (!(i11 == 24 || i11 == 25)) {
            switch (i11) {
                case 31:
                case 32:
                case 33:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public final c b(d[] dVarArr, byte[] bArr) {
        InputStream h11;
        try {
            h11 = h(this.f10477a, this.f10484h);
            if (h11 != null) {
                this.f10486j = m.q(h11, m.o(h11, m.f10509b), bArr, dVarArr);
                h11.close();
                return this;
            }
            if (h11 != null) {
                h11.close();
            }
            return null;
        } catch (FileNotFoundException e11) {
            this.f10479c.a(9, e11);
        } catch (IOException e12) {
            this.f10479c.a(7, e12);
        } catch (IllegalStateException e13) {
            this.f10486j = null;
            this.f10479c.a(8, e13);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public final void c() {
        if (!this.f10485i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    public boolean e() {
        if (this.f10480d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        } else if (!this.f10481e.canWrite()) {
            l(4, (Object) null);
            return false;
        } else {
            this.f10485i = true;
            return true;
        }
    }

    public final InputStream f(AssetManager assetManager) {
        try {
            return h(assetManager, this.f10483g);
        } catch (FileNotFoundException e11) {
            this.f10479c.a(6, e11);
            return null;
        } catch (IOException e12) {
            this.f10479c.a(7, e12);
            return null;
        }
    }

    public final InputStream h(AssetManager assetManager, String str) throws IOException {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e11) {
            String message = e11.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            this.f10479c.b(5, (Object) null);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r0 = b(r0, r2.f10480d);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.profileinstaller.c i() {
        /*
            r2 = this;
            r2.c()
            byte[] r0 = r2.f10480d
            if (r0 != 0) goto L_0x0008
            return r2
        L_0x0008:
            android.content.res.AssetManager r0 = r2.f10477a
            java.io.InputStream r0 = r2.f(r0)
            if (r0 == 0) goto L_0x0016
            androidx.profileinstaller.d[] r0 = r2.j(r0)
            r2.f10486j = r0
        L_0x0016:
            androidx.profileinstaller.d[] r0 = r2.f10486j
            if (r0 == 0) goto L_0x0029
            boolean r1 = k()
            if (r1 == 0) goto L_0x0029
            byte[] r1 = r2.f10480d
            androidx.profileinstaller.c r0 = r2.b(r0, r1)
            if (r0 == 0) goto L_0x0029
            return r0
        L_0x0029:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.c.i():androidx.profileinstaller.c");
    }

    public final d[] j(InputStream inputStream) {
        try {
            d[] w11 = m.w(inputStream, m.o(inputStream, m.f10508a), this.f10482f);
            try {
                inputStream.close();
                return w11;
            } catch (IOException e11) {
                this.f10479c.a(7, e11);
                return w11;
            }
        } catch (IOException e12) {
            this.f10479c.a(7, e12);
            inputStream.close();
            return null;
        } catch (IllegalStateException e13) {
            this.f10479c.a(8, e13);
            try {
                inputStream.close();
            } catch (IOException e14) {
                this.f10479c.a(7, e14);
            }
            return null;
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e15) {
                this.f10479c.a(7, e15);
            }
            throw th2;
        }
    }

    public final void l(int i11, Object obj) {
        this.f10478b.execute(new b(this, i11, obj));
    }

    public c m() {
        ByteArrayOutputStream byteArrayOutputStream;
        d[] dVarArr = this.f10486j;
        byte[] bArr = this.f10480d;
        if (!(dVarArr == null || bArr == null)) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                m.E(byteArrayOutputStream, bArr);
                if (!m.B(byteArrayOutputStream, bArr, dVarArr)) {
                    this.f10479c.a(5, (Object) null);
                    this.f10486j = null;
                    byteArrayOutputStream.close();
                    return this;
                }
                this.f10487k = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                this.f10486j = null;
            } catch (IOException e11) {
                this.f10479c.a(7, e11);
            } catch (IllegalStateException e12) {
                this.f10479c.a(8, e12);
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        return this;
        throw th;
    }

    public boolean n() {
        FileOutputStream fileOutputStream;
        byte[] bArr = this.f10487k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                fileOutputStream = new FileOutputStream(this.f10481e);
                e.l(byteArrayInputStream, fileOutputStream);
                l(1, (Object) null);
                fileOutputStream.close();
                byteArrayInputStream.close();
                this.f10487k = null;
                this.f10486j = null;
                return true;
            } catch (Throwable th2) {
                byteArrayInputStream.close();
                throw th2;
            }
        } catch (FileNotFoundException e11) {
            l(6, e11);
            this.f10487k = null;
            this.f10486j = null;
            return false;
        } catch (IOException e12) {
            try {
                l(7, e12);
                this.f10487k = null;
                this.f10486j = null;
                return false;
            } catch (Throwable th3) {
                this.f10487k = null;
                this.f10486j = null;
                throw th3;
            }
        } catch (Throwable th4) {
            th2.addSuppressed(th4);
        }
        throw th;
    }
}
