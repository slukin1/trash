package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.biometric.BiometricPrompt;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.z;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

public class BiometricFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public Handler f4755b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public BiometricViewModel f4756c;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f4757b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CharSequence f4758c;

        public a(int i11, CharSequence charSequence) {
            this.f4757b = i11;
            this.f4758c = charSequence;
        }

        public void run() {
            BiometricFragment.this.f4756c.o0().a(this.f4757b, this.f4758c);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            BiometricFragment.this.f4756c.o0().b();
        }
    }

    public class c implements z<BiometricPrompt.a> {
        public c() {
        }

        /* renamed from: a */
        public void onChanged(BiometricPrompt.a aVar) {
            if (aVar != null) {
                BiometricFragment.this.Ih(aVar);
                BiometricFragment.this.f4756c.N0((BiometricPrompt.a) null);
            }
        }
    }

    public class d implements z<j.a> {
        public d() {
        }

        /* renamed from: a */
        public void onChanged(j.a aVar) {
            if (aVar != null) {
                BiometricFragment.this.Fh(aVar.b(), aVar.c());
                BiometricFragment.this.f4756c.K0((j.a) null);
            }
        }
    }

    public class e implements z<CharSequence> {
        public e() {
        }

        /* renamed from: a */
        public void onChanged(CharSequence charSequence) {
            if (charSequence != null) {
                BiometricFragment.this.Hh(charSequence);
                BiometricFragment.this.f4756c.K0((j.a) null);
            }
        }
    }

    public class f implements z<Boolean> {
        public f() {
        }

        /* renamed from: a */
        public void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                BiometricFragment.this.Gh();
                BiometricFragment.this.f4756c.L0(false);
            }
        }
    }

    public class g implements z<Boolean> {
        public g() {
        }

        /* renamed from: a */
        public void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                if (BiometricFragment.this.Bh()) {
                    BiometricFragment.this.Kh();
                } else {
                    BiometricFragment.this.Jh();
                }
                BiometricFragment.this.f4756c.b1(false);
            }
        }
    }

    public class h implements z<Boolean> {
        public h() {
        }

        /* renamed from: a */
        public void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                BiometricFragment.this.sh(1);
                BiometricFragment.this.dismiss();
                BiometricFragment.this.f4756c.V0(false);
            }
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            BiometricFragment.this.f4756c.W0(false);
        }
    }

    public class j implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f4768b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CharSequence f4769c;

        public j(int i11, CharSequence charSequence) {
            this.f4768b = i11;
            this.f4769c = charSequence;
        }

        public void run() {
            BiometricFragment.this.Lh(this.f4768b, this.f4769c);
        }
    }

    public class k implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BiometricPrompt.a f4771b;

        public k(BiometricPrompt.a aVar) {
            this.f4771b = aVar;
        }

        public void run() {
            BiometricFragment.this.f4756c.o0().c(this.f4771b);
        }
    }

    public static class l {
        public static Intent a(KeyguardManager keyguardManager, CharSequence charSequence, CharSequence charSequence2) {
            return keyguardManager.createConfirmDeviceCredentialIntent(charSequence, charSequence2);
        }
    }

    public static class m {
        public static void a(android.hardware.biometrics.BiometricPrompt biometricPrompt, BiometricPrompt.CryptoObject cryptoObject, CancellationSignal cancellationSignal, Executor executor, BiometricPrompt.AuthenticationCallback authenticationCallback) {
            biometricPrompt.authenticate(cryptoObject, cancellationSignal, executor, authenticationCallback);
        }

        public static void b(android.hardware.biometrics.BiometricPrompt biometricPrompt, CancellationSignal cancellationSignal, Executor executor, BiometricPrompt.AuthenticationCallback authenticationCallback) {
            biometricPrompt.authenticate(cancellationSignal, executor, authenticationCallback);
        }

        public static android.hardware.biometrics.BiometricPrompt c(BiometricPrompt.Builder builder) {
            return builder.build();
        }

        public static BiometricPrompt.Builder d(Context context) {
            return new BiometricPrompt.Builder(context);
        }

        public static void e(BiometricPrompt.Builder builder, CharSequence charSequence) {
            builder.setDescription(charSequence);
        }

        public static void f(BiometricPrompt.Builder builder, CharSequence charSequence, Executor executor, DialogInterface.OnClickListener onClickListener) {
            builder.setNegativeButton(charSequence, executor, onClickListener);
        }

        public static void g(BiometricPrompt.Builder builder, CharSequence charSequence) {
            builder.setSubtitle(charSequence);
        }

        public static void h(BiometricPrompt.Builder builder, CharSequence charSequence) {
            builder.setTitle(charSequence);
        }
    }

    public static class n {
        public static void a(BiometricPrompt.Builder builder, boolean z11) {
            builder.setConfirmationRequired(z11);
        }

        public static void b(BiometricPrompt.Builder builder, boolean z11) {
            builder.setDeviceCredentialAllowed(z11);
        }
    }

    public static class o {
        public static void a(BiometricPrompt.Builder builder, int i11) {
            builder.setAllowedAuthenticators(i11);
        }
    }

    public static class p implements Executor {

        /* renamed from: b  reason: collision with root package name */
        public final Handler f4773b = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            this.f4773b.post(runnable);
        }
    }

    public static class q implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<BiometricFragment> f4774b;

        public q(BiometricFragment biometricFragment) {
            this.f4774b = new WeakReference<>(biometricFragment);
        }

        public void run() {
            if (this.f4774b.get() != null) {
                ((BiometricFragment) this.f4774b.get()).Th();
            }
        }
    }

    public static class r implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<BiometricViewModel> f4775b;

        public r(BiometricViewModel biometricViewModel) {
            this.f4775b = new WeakReference<>(biometricViewModel);
        }

        public void run() {
            if (this.f4775b.get() != null) {
                ((BiometricViewModel) this.f4775b.get()).U0(false);
            }
        }
    }

    public static class s implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<BiometricViewModel> f4776b;

        public s(BiometricViewModel biometricViewModel) {
            this.f4776b = new WeakReference<>(biometricViewModel);
        }

        public void run() {
            if (this.f4776b.get() != null) {
                ((BiometricViewModel) this.f4776b.get()).a1(false);
            }
        }
    }

    public static BiometricFragment Eh() {
        return new BiometricFragment();
    }

    public static int th(FingerprintManagerCompat fingerprintManagerCompat) {
        if (!fingerprintManagerCompat.e()) {
            return 12;
        }
        return !fingerprintManagerCompat.d() ? 11 : 0;
    }

    public final boolean Ah() {
        return Build.VERSION.SDK_INT == 28 && !j.f.a(getContext());
    }

    public boolean Bh() {
        return Build.VERSION.SDK_INT <= 28 && b.c(this.f4756c.h0());
    }

    public final boolean Ch() {
        return Build.VERSION.SDK_INT < 28 || zh() || Ah();
    }

    public final void Dh() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Log.e("BiometricFragment", "Failed to check device credential. Client FragmentActivity not found.");
            return;
        }
        KeyguardManager a11 = j.e.a(activity);
        if (a11 == null) {
            Lh(12, getString(R$string.generic_error_no_keyguard));
            return;
        }
        CharSequence z02 = this.f4756c.z0();
        CharSequence y02 = this.f4756c.y0();
        CharSequence r02 = this.f4756c.r0();
        if (y02 == null) {
            y02 = r02;
        }
        Intent a12 = l.a(a11, z02, y02);
        if (a12 == null) {
            Lh(14, getString(R$string.generic_error_no_device_credential));
            return;
        }
        this.f4756c.S0(true);
        if (Ch()) {
            vh();
        }
        a12.setFlags(134742016);
        startActivityForResult(a12, 1);
    }

    public void Fh(int i11, CharSequence charSequence) {
        if (!j.d.b(i11)) {
            i11 = 8;
        }
        Context context = getContext();
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 21 && i12 < 29 && j.d.c(i11) && context != null && j.e.b(context) && b.c(this.f4756c.h0())) {
            Dh();
        } else if (Ch()) {
            if (charSequence == null) {
                charSequence = j.d.a(getContext(), i11);
            }
            if (i11 == 5) {
                int m02 = this.f4756c.m0();
                if (m02 == 0 || m02 == 3) {
                    Mh(i11, charSequence);
                }
                dismiss();
                return;
            }
            if (this.f4756c.G0()) {
                Lh(i11, charSequence);
            } else {
                Sh(charSequence);
                this.f4755b.postDelayed(new j(i11, charSequence), (long) wh());
            }
            this.f4756c.W0(true);
        } else {
            if (charSequence == null) {
                charSequence = getString(R$string.default_error_msg) + " " + i11;
            }
            Lh(i11, charSequence);
        }
    }

    public void Gh() {
        if (Ch()) {
            Sh(getString(R$string.fingerprint_not_recognized));
        }
        Nh();
    }

    public void Hh(CharSequence charSequence) {
        if (Ch()) {
            Sh(charSequence);
        }
    }

    public void Ih(BiometricPrompt.a aVar) {
        Oh(aVar);
    }

    public void Jh() {
        CharSequence x02 = this.f4756c.x0();
        if (x02 == null) {
            x02 = getString(R$string.default_error_msg);
        }
        Lh(13, x02);
        sh(2);
    }

    public void Kh() {
        if (Build.VERSION.SDK_INT < 21) {
            Log.e("BiometricFragment", "Failed to check device credential. Not supported prior to API 21.");
        } else {
            Dh();
        }
    }

    public void Lh(int i11, CharSequence charSequence) {
        Mh(i11, charSequence);
        dismiss();
    }

    public final void Mh(int i11, CharSequence charSequence) {
        if (this.f4756c.D0()) {
            Log.v("BiometricFragment", "Error not sent to client. User is confirming their device credential.");
        } else if (!this.f4756c.B0()) {
            Log.w("BiometricFragment", "Error not sent to client. Client is not awaiting a result.");
        } else {
            this.f4756c.O0(false);
            this.f4756c.p0().execute(new a(i11, charSequence));
        }
    }

    public final void Nh() {
        if (!this.f4756c.B0()) {
            Log.w("BiometricFragment", "Failure not sent to client. Client is not awaiting a result.");
        } else {
            this.f4756c.p0().execute(new b());
        }
    }

    public final void Oh(BiometricPrompt.a aVar) {
        Ph(aVar);
        dismiss();
    }

    public final void Ph(BiometricPrompt.a aVar) {
        if (!this.f4756c.B0()) {
            Log.w("BiometricFragment", "Success not sent to client. Client is not awaiting a result.");
            return;
        }
        this.f4756c.O0(false);
        this.f4756c.p0().execute(new k(aVar));
    }

    public final void Qh() {
        BiometricPrompt.Builder d11 = m.d(requireContext().getApplicationContext());
        CharSequence z02 = this.f4756c.z0();
        CharSequence y02 = this.f4756c.y0();
        CharSequence r02 = this.f4756c.r0();
        if (z02 != null) {
            m.h(d11, z02);
        }
        if (y02 != null) {
            m.g(d11, y02);
        }
        if (r02 != null) {
            m.e(d11, r02);
        }
        CharSequence x02 = this.f4756c.x0();
        if (!TextUtils.isEmpty(x02)) {
            m.f(d11, x02, this.f4756c.p0(), this.f4756c.w0());
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            n.a(d11, this.f4756c.C0());
        }
        int h02 = this.f4756c.h0();
        if (i11 >= 30) {
            o.a(d11, h02);
        } else if (i11 >= 29) {
            n.b(d11, b.c(h02));
        }
        qh(m.c(d11), getContext());
    }

    public final void Rh() {
        Context applicationContext = requireContext().getApplicationContext();
        FingerprintManagerCompat b11 = FingerprintManagerCompat.b(applicationContext);
        int th2 = th(b11);
        if (th2 != 0) {
            Lh(th2, j.d.a(applicationContext, th2));
        } else if (isAdded()) {
            this.f4756c.W0(true);
            if (!j.c.f(applicationContext, Build.MODEL)) {
                this.f4755b.postDelayed(new i(), 500);
                FingerprintDialogFragment.sh().show(getParentFragmentManager(), "androidx.biometric.FingerprintDialogFragment");
            }
            this.f4756c.P0(0);
            rh(b11, applicationContext);
        }
    }

    public final void Sh(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = getString(R$string.default_error_msg);
        }
        this.f4756c.Z0(2);
        this.f4756c.X0(charSequence);
    }

    public void Th() {
        if (this.f4756c.J0()) {
            return;
        }
        if (getContext() == null) {
            Log.w("BiometricFragment", "Not showing biometric prompt. Context is null.");
            return;
        }
        this.f4756c.e1(true);
        this.f4756c.O0(true);
        if (Ch()) {
            Rh();
        } else {
            Qh();
        }
    }

    public void dismiss() {
        this.f4756c.e1(false);
        vh();
        if (!this.f4756c.D0() && isAdded()) {
            getParentFragmentManager().q().s(this).k();
        }
        Context context = getContext();
        if (context != null && j.c.e(context, Build.MODEL)) {
            this.f4756c.U0(true);
            this.f4755b.postDelayed(new r(this.f4756c), 600);
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 1) {
            this.f4756c.S0(false);
            xh(i12);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uh();
    }

    public void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT == 29 && b.c(this.f4756c.h0())) {
            this.f4756c.a1(true);
            this.f4755b.postDelayed(new s(this.f4756c), 250);
        }
    }

    public void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT < 29 && !this.f4756c.D0() && !yh()) {
            sh(0);
        }
    }

    public void ph(BiometricPrompt.PromptInfo promptInfo, BiometricPrompt.b bVar) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Log.e("BiometricFragment", "Not launching prompt. Client activity was null.");
            return;
        }
        this.f4756c.d1(promptInfo);
        int b11 = b.b(promptInfo, bVar);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 23 || i11 >= 30 || b11 != 15 || bVar != null) {
            this.f4756c.T0(bVar);
        } else {
            this.f4756c.T0(d.a());
        }
        if (Bh()) {
            this.f4756c.c1(getString(R$string.confirm_device_credential_password));
        } else {
            this.f4756c.c1((CharSequence) null);
        }
        if (i11 >= 21 && Bh() && c.g(activity).a(255) != 0) {
            this.f4756c.O0(true);
            Dh();
        } else if (this.f4756c.E0()) {
            this.f4755b.postDelayed(new q(this), 600);
        } else {
            Th();
        }
    }

    public void qh(android.hardware.biometrics.BiometricPrompt biometricPrompt, Context context) {
        BiometricPrompt.CryptoObject d11 = d.d(this.f4756c.q0());
        CancellationSignal b11 = this.f4756c.n0().b();
        p pVar = new p();
        BiometricPrompt.AuthenticationCallback a11 = this.f4756c.i0().a();
        if (d11 == null) {
            try {
                m.b(biometricPrompt, b11, pVar, a11);
            } catch (NullPointerException e11) {
                Log.e("BiometricFragment", "Got NPE while authenticating with biometric prompt.", e11);
                Lh(1, context != null ? context.getString(R$string.default_error_msg) : "");
            }
        } else {
            m.a(biometricPrompt, d11, b11, pVar, a11);
        }
    }

    public void rh(FingerprintManagerCompat fingerprintManagerCompat, Context context) {
        try {
            fingerprintManagerCompat.a(d.e(this.f4756c.q0()), 0, this.f4756c.n0().c(), this.f4756c.i0().b(), (Handler) null);
        } catch (NullPointerException e11) {
            Log.e("BiometricFragment", "Got NPE while authenticating with fingerprint.", e11);
            Lh(1, j.d.a(context, 1));
        }
    }

    public void sh(int i11) {
        if (i11 == 3 || !this.f4756c.H0()) {
            if (Ch()) {
                this.f4756c.P0(i11);
                if (i11 == 1) {
                    Mh(10, j.d.a(getContext(), 10));
                }
            }
            this.f4756c.n0().a();
        }
    }

    public final void uh() {
        if (getActivity() != null) {
            BiometricViewModel biometricViewModel = (BiometricViewModel) new ViewModelProvider(getActivity()).a(BiometricViewModel.class);
            this.f4756c = biometricViewModel;
            biometricViewModel.l0().observe(this, new c());
            this.f4756c.j0().observe(this, new d());
            this.f4756c.k0().observe(this, new e());
            this.f4756c.A0().observe(this, new f());
            this.f4756c.I0().observe(this, new g());
            this.f4756c.F0().observe(this, new h());
        }
    }

    public final void vh() {
        this.f4756c.e1(false);
        if (isAdded()) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            FingerprintDialogFragment fingerprintDialogFragment = (FingerprintDialogFragment) parentFragmentManager.m0("androidx.biometric.FingerprintDialogFragment");
            if (fingerprintDialogFragment == null) {
                return;
            }
            if (fingerprintDialogFragment.isAdded()) {
                fingerprintDialogFragment.dismissAllowingStateLoss();
            } else {
                parentFragmentManager.q().s(fingerprintDialogFragment).k();
            }
        }
    }

    public final int wh() {
        Context context = getContext();
        return (context == null || !j.c.f(context, Build.MODEL)) ? 2000 : 0;
    }

    public final void xh(int i11) {
        if (i11 == -1) {
            Oh(new BiometricPrompt.a((BiometricPrompt.b) null, 1));
        } else {
            Lh(10, getString(R$string.generic_error_user_canceled));
        }
    }

    public final boolean yh() {
        FragmentActivity activity = getActivity();
        return activity != null && activity.isChangingConfigurations();
    }

    public final boolean zh() {
        FragmentActivity activity = getActivity();
        return (activity == null || this.f4756c.q0() == null || !j.c.g(activity, Build.MANUFACTURER, Build.MODEL)) ? false : true;
    }
}
