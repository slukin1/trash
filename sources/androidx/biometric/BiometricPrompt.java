package androidx.biometric;

import android.annotation.SuppressLint;
import android.os.Build;
import android.security.identity.IdentityCredential;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.security.Signature;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public class BiometricPrompt {

    /* renamed from: a  reason: collision with root package name */
    public FragmentManager f4777a;

    public static abstract class AuthenticationCallback {
        public void a(int i11, CharSequence charSequence) {
        }

        public void b() {
        }

        public void c(a aVar) {
        }
    }

    public static class PromptInfo {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f4778a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f4779b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f4780c;

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f4781d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f4782e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f4783f;

        /* renamed from: g  reason: collision with root package name */
        public final int f4784g;

        public static class Builder {

            /* renamed from: a  reason: collision with root package name */
            public CharSequence f4785a = null;

            /* renamed from: b  reason: collision with root package name */
            public CharSequence f4786b = null;

            /* renamed from: c  reason: collision with root package name */
            public CharSequence f4787c = null;

            /* renamed from: d  reason: collision with root package name */
            public CharSequence f4788d = null;

            /* renamed from: e  reason: collision with root package name */
            public boolean f4789e = true;

            /* renamed from: f  reason: collision with root package name */
            public boolean f4790f = false;

            /* renamed from: g  reason: collision with root package name */
            public int f4791g = 0;

            public PromptInfo a() {
                boolean z11;
                if (TextUtils.isEmpty(this.f4785a)) {
                    throw new IllegalArgumentException("Title must be set and non-empty.");
                } else if (b.e(this.f4791g)) {
                    int i11 = this.f4791g;
                    if (i11 != 0) {
                        z11 = b.c(i11);
                    } else {
                        z11 = this.f4790f;
                    }
                    if (TextUtils.isEmpty(this.f4788d) && !z11) {
                        throw new IllegalArgumentException("Negative text must be set and non-empty.");
                    } else if (TextUtils.isEmpty(this.f4788d) || !z11) {
                        return new PromptInfo(this.f4785a, this.f4786b, this.f4787c, this.f4788d, this.f4789e, this.f4790f, this.f4791g);
                    } else {
                        throw new IllegalArgumentException("Negative text must not be set if device credential authentication is allowed.");
                    }
                } else {
                    throw new IllegalArgumentException("Authenticator combination is unsupported on API " + Build.VERSION.SDK_INT + l.f34627b + b.a(this.f4791g));
                }
            }

            public Builder b(CharSequence charSequence) {
                this.f4788d = charSequence;
                return this;
            }

            public Builder c(CharSequence charSequence) {
                this.f4785a = charSequence;
                return this;
            }
        }

        public PromptInfo(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z11, boolean z12, int i11) {
            this.f4778a = charSequence;
            this.f4779b = charSequence2;
            this.f4780c = charSequence3;
            this.f4781d = charSequence4;
            this.f4782e = z11;
            this.f4783f = z12;
            this.f4784g = i11;
        }

        public int a() {
            return this.f4784g;
        }

        public CharSequence b() {
            return this.f4780c;
        }

        public CharSequence c() {
            CharSequence charSequence = this.f4781d;
            return charSequence != null ? charSequence : "";
        }

        public CharSequence d() {
            return this.f4779b;
        }

        public CharSequence e() {
            return this.f4778a;
        }

        public boolean f() {
            return this.f4782e;
        }

        @Deprecated
        public boolean g() {
            return this.f4783f;
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final b f4792a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4793b;

        public a(b bVar, int i11) {
            this.f4792a = bVar;
            this.f4793b = i11;
        }

        public int a() {
            return this.f4793b;
        }

        public b b() {
            return this.f4792a;
        }
    }

    @SuppressLint({"LambdaLast"})
    public BiometricPrompt(FragmentActivity fragmentActivity, Executor executor, AuthenticationCallback authenticationCallback) {
        if (fragmentActivity == null) {
            throw new IllegalArgumentException("FragmentActivity must not be null.");
        } else if (executor == null) {
            throw new IllegalArgumentException("Executor must not be null.");
        } else if (authenticationCallback != null) {
            g(fragmentActivity.getSupportFragmentManager(), f(fragmentActivity), executor, authenticationCallback);
        } else {
            throw new IllegalArgumentException("AuthenticationCallback must not be null.");
        }
    }

    public static BiometricFragment d(FragmentManager fragmentManager) {
        return (BiometricFragment) fragmentManager.m0("androidx.biometric.BiometricFragment");
    }

    public static BiometricFragment e(FragmentManager fragmentManager) {
        BiometricFragment d11 = d(fragmentManager);
        if (d11 != null) {
            return d11;
        }
        BiometricFragment Eh = BiometricFragment.Eh();
        fragmentManager.q().e(Eh, "androidx.biometric.BiometricFragment").k();
        fragmentManager.i0();
        return Eh;
    }

    public static BiometricViewModel f(FragmentActivity fragmentActivity) {
        if (fragmentActivity != null) {
            return (BiometricViewModel) new ViewModelProvider(fragmentActivity).a(BiometricViewModel.class);
        }
        return null;
    }

    public void a(PromptInfo promptInfo) {
        if (promptInfo != null) {
            b(promptInfo, (b) null);
            return;
        }
        throw new IllegalArgumentException("PromptInfo cannot be null.");
    }

    public final void b(PromptInfo promptInfo, b bVar) {
        FragmentManager fragmentManager = this.f4777a;
        if (fragmentManager == null) {
            Log.e("BiometricPromptCompat", "Unable to start authentication. Client fragment manager was null.");
        } else if (fragmentManager.W0()) {
            Log.e("BiometricPromptCompat", "Unable to start authentication. Called after onSaveInstanceState().");
        } else {
            e(this.f4777a).ph(promptInfo, bVar);
        }
    }

    public void c() {
        FragmentManager fragmentManager = this.f4777a;
        if (fragmentManager == null) {
            Log.e("BiometricPromptCompat", "Unable to start authentication. Client fragment manager was null.");
            return;
        }
        BiometricFragment d11 = d(fragmentManager);
        if (d11 == null) {
            Log.e("BiometricPromptCompat", "Unable to cancel authentication. BiometricFragment not found.");
        } else {
            d11.sh(3);
        }
    }

    public final void g(FragmentManager fragmentManager, BiometricViewModel biometricViewModel, Executor executor, AuthenticationCallback authenticationCallback) {
        this.f4777a = fragmentManager;
        if (biometricViewModel != null) {
            if (executor != null) {
                biometricViewModel.R0(executor);
            }
            biometricViewModel.Q0(authenticationCallback);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Signature f4794a;

        /* renamed from: b  reason: collision with root package name */
        public final Cipher f4795b;

        /* renamed from: c  reason: collision with root package name */
        public final Mac f4796c;

        /* renamed from: d  reason: collision with root package name */
        public final IdentityCredential f4797d;

        public b(Signature signature) {
            this.f4794a = signature;
            this.f4795b = null;
            this.f4796c = null;
            this.f4797d = null;
        }

        public Cipher a() {
            return this.f4795b;
        }

        public IdentityCredential b() {
            return this.f4797d;
        }

        public Mac c() {
            return this.f4796c;
        }

        public Signature d() {
            return this.f4794a;
        }

        public b(Cipher cipher) {
            this.f4794a = null;
            this.f4795b = cipher;
            this.f4796c = null;
            this.f4797d = null;
        }

        public b(Mac mac) {
            this.f4794a = null;
            this.f4795b = null;
            this.f4796c = mac;
            this.f4797d = null;
        }

        public b(IdentityCredential identityCredential) {
            this.f4794a = null;
            this.f4795b = null;
            this.f4796c = null;
            this.f4797d = identityCredential;
        }
    }
}
