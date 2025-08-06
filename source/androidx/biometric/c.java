package androidx.biometric;

import android.content.Context;
import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.util.Log;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import j.e;
import j.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final d f4844a;

    /* renamed from: b  reason: collision with root package name */
    public final BiometricManager f4845b;

    /* renamed from: c  reason: collision with root package name */
    public final FingerprintManagerCompat f4846c;

    public static class a {
        public static int a(BiometricManager biometricManager) {
            return biometricManager.canAuthenticate();
        }

        public static BiometricManager b(Context context) {
            return (BiometricManager) context.getSystemService(BiometricManager.class);
        }

        public static Method c() {
            try {
                return BiometricManager.class.getMethod("canAuthenticate", new Class[]{BiometricPrompt.CryptoObject.class});
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
    }

    public static class b {
        public static int a(BiometricManager biometricManager, int i11) {
            return biometricManager.canAuthenticate(i11);
        }
    }

    /* renamed from: androidx.biometric.c$c  reason: collision with other inner class name */
    public static class C0006c implements d {

        /* renamed from: a  reason: collision with root package name */
        public final Context f4847a;

        public C0006c(Context context) {
            this.f4847a = context.getApplicationContext();
        }

        public boolean a() {
            return e.a(this.f4847a) != null;
        }

        public boolean b() {
            return e.b(this.f4847a);
        }

        public boolean c() {
            return j.c.a(this.f4847a, Build.MODEL);
        }

        public FingerprintManagerCompat d() {
            return FingerprintManagerCompat.b(this.f4847a);
        }

        public BiometricManager e() {
            return a.b(this.f4847a);
        }

        public boolean f() {
            return f.a(this.f4847a);
        }
    }

    public interface d {
        boolean a();

        boolean b();

        boolean c();

        FingerprintManagerCompat d();

        BiometricManager e();

        boolean f();
    }

    public c(d dVar) {
        this.f4844a = dVar;
        int i11 = Build.VERSION.SDK_INT;
        FingerprintManagerCompat fingerprintManagerCompat = null;
        this.f4845b = i11 >= 29 ? dVar.e() : null;
        this.f4846c = i11 <= 29 ? dVar.d() : fingerprintManagerCompat;
    }

    public static c g(Context context) {
        return new c(new C0006c(context));
    }

    public int a(int i11) {
        if (Build.VERSION.SDK_INT < 30) {
            return b(i11);
        }
        BiometricManager biometricManager = this.f4845b;
        if (biometricManager != null) {
            return b.a(biometricManager, i11);
        }
        Log.e("BiometricManager", "Failure in canAuthenticate(). BiometricManager was null.");
        return 1;
    }

    public final int b(int i11) {
        if (!b.e(i11)) {
            return -2;
        }
        if (i11 == 0 || !this.f4844a.a()) {
            return 12;
        }
        if (b.c(i11)) {
            return this.f4844a.b() ? 0 : 11;
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 == 29) {
            if (b.f(i11)) {
                return f();
            }
            return e();
        } else if (i12 != 28) {
            return c();
        } else {
            if (this.f4844a.f()) {
                return d();
            }
            return 12;
        }
    }

    public final int c() {
        FingerprintManagerCompat fingerprintManagerCompat = this.f4846c;
        if (fingerprintManagerCompat == null) {
            Log.e("BiometricManager", "Failure in canAuthenticate(). FingerprintManager was null.");
            return 1;
        } else if (!fingerprintManagerCompat.e()) {
            return 12;
        } else {
            return !this.f4846c.d() ? 11 : 0;
        }
    }

    public final int d() {
        if (!this.f4844a.b()) {
            return c();
        }
        return c() == 0 ? 0 : -1;
    }

    public final int e() {
        BiometricPrompt.CryptoObject d11;
        Method c11 = a.c();
        if (!(c11 == null || (d11 = d.d(d.a())) == null)) {
            try {
                Object invoke = c11.invoke(this.f4845b, new Object[]{d11});
                if (invoke instanceof Integer) {
                    return ((Integer) invoke).intValue();
                }
                Log.w("BiometricManager", "Invalid return type for canAuthenticate(CryptoObject).");
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e11) {
                Log.w("BiometricManager", "Failed to invoke canAuthenticate(CryptoObject).", e11);
            }
        }
        int f11 = f();
        return (this.f4844a.c() || f11 != 0) ? f11 : d();
    }

    public final int f() {
        BiometricManager biometricManager = this.f4845b;
        if (biometricManager != null) {
            return a.a(biometricManager);
        }
        Log.e("BiometricManager", "Failure in canAuthenticate(). BiometricManager was null.");
        return 1;
    }
}
