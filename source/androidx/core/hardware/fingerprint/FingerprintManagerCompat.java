package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
public class FingerprintManagerCompat {

    /* renamed from: a  reason: collision with root package name */
    public final Context f8380a;

    public static abstract class AuthenticationCallback {
        public void a(int i11, CharSequence charSequence) {
        }

        public void b() {
        }

        public void c(int i11, CharSequence charSequence) {
        }

        public void d(c cVar) {
        }
    }

    public class a extends FingerprintManager.AuthenticationCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AuthenticationCallback f8381a;

        public a(AuthenticationCallback authenticationCallback) {
            this.f8381a = authenticationCallback;
        }

        public void onAuthenticationError(int i11, CharSequence charSequence) {
            this.f8381a.a(i11, charSequence);
        }

        public void onAuthenticationFailed() {
            this.f8381a.b();
        }

        public void onAuthenticationHelp(int i11, CharSequence charSequence) {
            this.f8381a.c(i11, charSequence);
        }

        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            this.f8381a.d(new c(FingerprintManagerCompat.f(b.b(authenticationResult))));
        }
    }

    public static class b {
        public static void a(Object obj, Object obj2, CancellationSignal cancellationSignal, int i11, Object obj3, Handler handler) {
            ((FingerprintManager) obj).authenticate((FingerprintManager.CryptoObject) obj2, cancellationSignal, i11, (FingerprintManager.AuthenticationCallback) obj3, handler);
        }

        public static FingerprintManager.CryptoObject b(Object obj) {
            return ((FingerprintManager.AuthenticationResult) obj).getCryptoObject();
        }

        public static FingerprintManager c(Context context) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 == 23) {
                return (FingerprintManager) context.getSystemService(FingerprintManager.class);
            }
            if (i11 <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
                return null;
            }
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }

        public static boolean d(Object obj) {
            return ((FingerprintManager) obj).hasEnrolledFingerprints();
        }

        public static boolean e(Object obj) {
            return ((FingerprintManager) obj).isHardwareDetected();
        }

        public static d f(Object obj) {
            FingerprintManager.CryptoObject cryptoObject = (FingerprintManager.CryptoObject) obj;
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new d(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new d(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new d(cryptoObject.getMac());
            }
            return null;
        }

        public static FingerprintManager.CryptoObject g(d dVar) {
            if (dVar == null) {
                return null;
            }
            if (dVar.a() != null) {
                return new FingerprintManager.CryptoObject(dVar.a());
            }
            if (dVar.c() != null) {
                return new FingerprintManager.CryptoObject(dVar.c());
            }
            if (dVar.b() != null) {
                return new FingerprintManager.CryptoObject(dVar.b());
            }
            return null;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final d f8382a;

        public c(d dVar) {
            this.f8382a = dVar;
        }

        public d a() {
            return this.f8382a;
        }
    }

    public FingerprintManagerCompat(Context context) {
        this.f8380a = context;
    }

    public static FingerprintManagerCompat b(Context context) {
        return new FingerprintManagerCompat(context);
    }

    public static FingerprintManager c(Context context) {
        return b.c(context);
    }

    public static d f(FingerprintManager.CryptoObject cryptoObject) {
        return b.f(cryptoObject);
    }

    public static FingerprintManager.AuthenticationCallback g(AuthenticationCallback authenticationCallback) {
        return new a(authenticationCallback);
    }

    public static FingerprintManager.CryptoObject h(d dVar) {
        return b.g(dVar);
    }

    public void a(d dVar, int i11, androidx.core.os.CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        FingerprintManager c11;
        if (Build.VERSION.SDK_INT >= 23 && (c11 = c(this.f8380a)) != null) {
            b.a(c11, h(dVar), cancellationSignal != null ? (CancellationSignal) cancellationSignal.b() : null, i11, g(authenticationCallback), handler);
        }
    }

    public boolean d() {
        FingerprintManager c11;
        if (Build.VERSION.SDK_INT < 23 || (c11 = c(this.f8380a)) == null || !b.d(c11)) {
            return false;
        }
        return true;
    }

    public boolean e() {
        FingerprintManager c11;
        if (Build.VERSION.SDK_INT < 23 || (c11 = c(this.f8380a)) == null || !b.e(c11)) {
            return false;
        }
        return true;
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final Signature f8383a;

        /* renamed from: b  reason: collision with root package name */
        public final Cipher f8384b;

        /* renamed from: c  reason: collision with root package name */
        public final Mac f8385c;

        public d(Signature signature) {
            this.f8383a = signature;
            this.f8384b = null;
            this.f8385c = null;
        }

        public Cipher a() {
            return this.f8384b;
        }

        public Mac b() {
            return this.f8385c;
        }

        public Signature c() {
            return this.f8383a;
        }

        public d(Cipher cipher) {
            this.f8384b = cipher;
            this.f8383a = null;
            this.f8385c = null;
        }

        public d(Mac mac) {
            this.f8385c = mac;
            this.f8384b = null;
            this.f8383a = null;
        }
    }
}
