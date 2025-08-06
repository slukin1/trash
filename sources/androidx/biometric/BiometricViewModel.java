package androidx.biometric;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.biometric.BiometricPrompt;
import androidx.biometric.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

public class BiometricViewModel extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public Executor f4798a;

    /* renamed from: b  reason: collision with root package name */
    public BiometricPrompt.AuthenticationCallback f4799b;

    /* renamed from: c  reason: collision with root package name */
    public BiometricPrompt.PromptInfo f4800c;

    /* renamed from: d  reason: collision with root package name */
    public BiometricPrompt.b f4801d;

    /* renamed from: e  reason: collision with root package name */
    public a f4802e;

    /* renamed from: f  reason: collision with root package name */
    public j.b f4803f;

    /* renamed from: g  reason: collision with root package name */
    public DialogInterface.OnClickListener f4804g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f4805h;

    /* renamed from: i  reason: collision with root package name */
    public int f4806i = 0;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4807j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4808k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f4809l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f4810m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f4811n;

    /* renamed from: o  reason: collision with root package name */
    public MutableLiveData<BiometricPrompt.a> f4812o;

    /* renamed from: p  reason: collision with root package name */
    public MutableLiveData<j.a> f4813p;

    /* renamed from: q  reason: collision with root package name */
    public MutableLiveData<CharSequence> f4814q;

    /* renamed from: r  reason: collision with root package name */
    public MutableLiveData<Boolean> f4815r;

    /* renamed from: s  reason: collision with root package name */
    public MutableLiveData<Boolean> f4816s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f4817t = true;

    /* renamed from: u  reason: collision with root package name */
    public MutableLiveData<Boolean> f4818u;

    /* renamed from: v  reason: collision with root package name */
    public int f4819v = 0;

    /* renamed from: w  reason: collision with root package name */
    public MutableLiveData<Integer> f4820w;

    /* renamed from: x  reason: collision with root package name */
    public MutableLiveData<CharSequence> f4821x;

    public class a extends BiometricPrompt.AuthenticationCallback {
        public a() {
        }
    }

    public static final class b extends a.d {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<BiometricViewModel> f4823a;

        public b(BiometricViewModel biometricViewModel) {
            this.f4823a = new WeakReference<>(biometricViewModel);
        }

        public void a(int i11, CharSequence charSequence) {
            if (this.f4823a.get() != null && !((BiometricViewModel) this.f4823a.get()).D0() && ((BiometricViewModel) this.f4823a.get()).B0()) {
                ((BiometricViewModel) this.f4823a.get()).K0(new j.a(i11, charSequence));
            }
        }

        public void b() {
            if (this.f4823a.get() != null && ((BiometricViewModel) this.f4823a.get()).B0()) {
                ((BiometricViewModel) this.f4823a.get()).L0(true);
            }
        }

        public void c(CharSequence charSequence) {
            if (this.f4823a.get() != null) {
                ((BiometricViewModel) this.f4823a.get()).M0(charSequence);
            }
        }

        public void d(BiometricPrompt.a aVar) {
            if (this.f4823a.get() != null && ((BiometricViewModel) this.f4823a.get()).B0()) {
                if (aVar.a() == -1) {
                    aVar = new BiometricPrompt.a(aVar.b(), ((BiometricViewModel) this.f4823a.get()).v0());
                }
                ((BiometricViewModel) this.f4823a.get()).N0(aVar);
            }
        }
    }

    public static class c implements Executor {

        /* renamed from: b  reason: collision with root package name */
        public final Handler f4824b = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            this.f4824b.post(runnable);
        }
    }

    public static class d implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<BiometricViewModel> f4825b;

        public d(BiometricViewModel biometricViewModel) {
            this.f4825b = new WeakReference<>(biometricViewModel);
        }

        public void onClick(DialogInterface dialogInterface, int i11) {
            if (this.f4825b.get() != null) {
                ((BiometricViewModel) this.f4825b.get()).b1(true);
            }
        }
    }

    public static <T> void f1(MutableLiveData<T> mutableLiveData, T t11) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            mutableLiveData.setValue(t11);
        } else {
            mutableLiveData.postValue(t11);
        }
    }

    public LiveData<Boolean> A0() {
        if (this.f4815r == null) {
            this.f4815r = new MutableLiveData<>();
        }
        return this.f4815r;
    }

    public boolean B0() {
        return this.f4808k;
    }

    public boolean C0() {
        BiometricPrompt.PromptInfo promptInfo = this.f4800c;
        return promptInfo == null || promptInfo.f();
    }

    public boolean D0() {
        return this.f4809l;
    }

    public boolean E0() {
        return this.f4810m;
    }

    public LiveData<Boolean> F0() {
        if (this.f4818u == null) {
            this.f4818u = new MutableLiveData<>();
        }
        return this.f4818u;
    }

    public boolean G0() {
        return this.f4817t;
    }

    public boolean H0() {
        return this.f4811n;
    }

    public LiveData<Boolean> I0() {
        if (this.f4816s == null) {
            this.f4816s = new MutableLiveData<>();
        }
        return this.f4816s;
    }

    public boolean J0() {
        return this.f4807j;
    }

    public void K0(j.a aVar) {
        if (this.f4813p == null) {
            this.f4813p = new MutableLiveData<>();
        }
        f1(this.f4813p, aVar);
    }

    public void L0(boolean z11) {
        if (this.f4815r == null) {
            this.f4815r = new MutableLiveData<>();
        }
        f1(this.f4815r, Boolean.valueOf(z11));
    }

    public void M0(CharSequence charSequence) {
        if (this.f4814q == null) {
            this.f4814q = new MutableLiveData<>();
        }
        f1(this.f4814q, charSequence);
    }

    public void N0(BiometricPrompt.a aVar) {
        if (this.f4812o == null) {
            this.f4812o = new MutableLiveData<>();
        }
        f1(this.f4812o, aVar);
    }

    public void O0(boolean z11) {
        this.f4808k = z11;
    }

    public void P0(int i11) {
        this.f4806i = i11;
    }

    public void Q0(BiometricPrompt.AuthenticationCallback authenticationCallback) {
        this.f4799b = authenticationCallback;
    }

    public void R0(Executor executor) {
        this.f4798a = executor;
    }

    public void S0(boolean z11) {
        this.f4809l = z11;
    }

    public void T0(BiometricPrompt.b bVar) {
        this.f4801d = bVar;
    }

    public void U0(boolean z11) {
        this.f4810m = z11;
    }

    public void V0(boolean z11) {
        if (this.f4818u == null) {
            this.f4818u = new MutableLiveData<>();
        }
        f1(this.f4818u, Boolean.valueOf(z11));
    }

    public void W0(boolean z11) {
        this.f4817t = z11;
    }

    public void X0(CharSequence charSequence) {
        if (this.f4821x == null) {
            this.f4821x = new MutableLiveData<>();
        }
        f1(this.f4821x, charSequence);
    }

    public void Y0(int i11) {
        this.f4819v = i11;
    }

    public void Z0(int i11) {
        if (this.f4820w == null) {
            this.f4820w = new MutableLiveData<>();
        }
        f1(this.f4820w, Integer.valueOf(i11));
    }

    public void a1(boolean z11) {
        this.f4811n = z11;
    }

    public void b1(boolean z11) {
        if (this.f4816s == null) {
            this.f4816s = new MutableLiveData<>();
        }
        f1(this.f4816s, Boolean.valueOf(z11));
    }

    public void c1(CharSequence charSequence) {
        this.f4805h = charSequence;
    }

    public void d1(BiometricPrompt.PromptInfo promptInfo) {
        this.f4800c = promptInfo;
    }

    public void e1(boolean z11) {
        this.f4807j = z11;
    }

    public int h0() {
        BiometricPrompt.PromptInfo promptInfo = this.f4800c;
        if (promptInfo != null) {
            return b.b(promptInfo, this.f4801d);
        }
        return 0;
    }

    public a i0() {
        if (this.f4802e == null) {
            this.f4802e = new a(new b(this));
        }
        return this.f4802e;
    }

    public MutableLiveData<j.a> j0() {
        if (this.f4813p == null) {
            this.f4813p = new MutableLiveData<>();
        }
        return this.f4813p;
    }

    public LiveData<CharSequence> k0() {
        if (this.f4814q == null) {
            this.f4814q = new MutableLiveData<>();
        }
        return this.f4814q;
    }

    public LiveData<BiometricPrompt.a> l0() {
        if (this.f4812o == null) {
            this.f4812o = new MutableLiveData<>();
        }
        return this.f4812o;
    }

    public int m0() {
        return this.f4806i;
    }

    public j.b n0() {
        if (this.f4803f == null) {
            this.f4803f = new j.b();
        }
        return this.f4803f;
    }

    public BiometricPrompt.AuthenticationCallback o0() {
        if (this.f4799b == null) {
            this.f4799b = new a();
        }
        return this.f4799b;
    }

    public Executor p0() {
        Executor executor = this.f4798a;
        return executor != null ? executor : new c();
    }

    public BiometricPrompt.b q0() {
        return this.f4801d;
    }

    public CharSequence r0() {
        BiometricPrompt.PromptInfo promptInfo = this.f4800c;
        if (promptInfo != null) {
            return promptInfo.b();
        }
        return null;
    }

    public LiveData<CharSequence> s0() {
        if (this.f4821x == null) {
            this.f4821x = new MutableLiveData<>();
        }
        return this.f4821x;
    }

    public int t0() {
        return this.f4819v;
    }

    public LiveData<Integer> u0() {
        if (this.f4820w == null) {
            this.f4820w = new MutableLiveData<>();
        }
        return this.f4820w;
    }

    public int v0() {
        int h02 = h0();
        return (!b.d(h02) || b.c(h02)) ? -1 : 2;
    }

    public DialogInterface.OnClickListener w0() {
        if (this.f4804g == null) {
            this.f4804g = new d(this);
        }
        return this.f4804g;
    }

    public CharSequence x0() {
        CharSequence charSequence = this.f4805h;
        if (charSequence != null) {
            return charSequence;
        }
        BiometricPrompt.PromptInfo promptInfo = this.f4800c;
        if (promptInfo != null) {
            return promptInfo.c();
        }
        return null;
    }

    public CharSequence y0() {
        BiometricPrompt.PromptInfo promptInfo = this.f4800c;
        if (promptInfo != null) {
            return promptInfo.d();
        }
        return null;
    }

    public CharSequence z0() {
        BiometricPrompt.PromptInfo promptInfo = this.f4800c;
        if (promptInfo != null) {
            return promptInfo.e();
        }
        return null;
    }
}
