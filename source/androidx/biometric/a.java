package androidx.biometric;

import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import androidx.biometric.BiometricPrompt;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public BiometricPrompt.AuthenticationCallback f4839a;

    /* renamed from: b  reason: collision with root package name */
    public FingerprintManagerCompat.AuthenticationCallback f4840b;

    /* renamed from: c  reason: collision with root package name */
    public final d f4841c;

    /* renamed from: androidx.biometric.a$a  reason: collision with other inner class name */
    public class C0004a extends FingerprintManagerCompat.AuthenticationCallback {
        public C0004a() {
        }

        public void a(int i11, CharSequence charSequence) {
            a.this.f4841c.a(i11, charSequence);
        }

        public void b() {
            a.this.f4841c.b();
        }

        public void c(int i11, CharSequence charSequence) {
            a.this.f4841c.c(charSequence);
        }

        public void d(FingerprintManagerCompat.c cVar) {
            a.this.f4841c.d(new BiometricPrompt.a(cVar != null ? d.c(cVar.a()) : null, 2));
        }
    }

    public static class b {

        /* renamed from: androidx.biometric.a$b$a  reason: collision with other inner class name */
        public class C0005a extends BiometricPrompt.AuthenticationCallback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f4843a;

            public C0005a(d dVar) {
                this.f4843a = dVar;
            }

            public void onAuthenticationError(int i11, CharSequence charSequence) {
                this.f4843a.a(i11, charSequence);
            }

            public void onAuthenticationFailed() {
                this.f4843a.b();
            }

            public void onAuthenticationHelp(int i11, CharSequence charSequence) {
            }

            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
                BiometricPrompt.b b11 = authenticationResult != null ? d.b(authenticationResult.getCryptoObject()) : null;
                int i11 = Build.VERSION.SDK_INT;
                int i12 = -1;
                if (i11 >= 30) {
                    if (authenticationResult != null) {
                        i12 = c.a(authenticationResult);
                    }
                } else if (i11 != 29) {
                    i12 = 2;
                }
                this.f4843a.d(new BiometricPrompt.a(b11, i12));
            }
        }

        public static BiometricPrompt.AuthenticationCallback a(d dVar) {
            return new C0005a(dVar);
        }
    }

    public static class c {
        public static int a(BiometricPrompt.AuthenticationResult authenticationResult) {
            return authenticationResult.getAuthenticationType();
        }
    }

    public static class d {
        public void a(int i11, CharSequence charSequence) {
            throw null;
        }

        public void b() {
            throw null;
        }

        public void c(CharSequence charSequence) {
            throw null;
        }

        public void d(BiometricPrompt.a aVar) {
            throw null;
        }
    }

    public a(d dVar) {
        this.f4841c = dVar;
    }

    public BiometricPrompt.AuthenticationCallback a() {
        if (this.f4839a == null) {
            this.f4839a = b.a(this.f4841c);
        }
        return this.f4839a;
    }

    public FingerprintManagerCompat.AuthenticationCallback b() {
        if (this.f4840b == null) {
            this.f4840b = new C0004a();
        }
        return this.f4840b;
    }
}
