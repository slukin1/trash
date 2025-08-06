package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.FontsContractCompat;
import androidx.core.provider.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final FontsContractCompat.FontRequestCallback f8426a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f8427b;

    /* renamed from: androidx.core.provider.a$a  reason: collision with other inner class name */
    public class C0024a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FontsContractCompat.FontRequestCallback f8428b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Typeface f8429c;

        public C0024a(FontsContractCompat.FontRequestCallback fontRequestCallback, Typeface typeface) {
            this.f8428b = fontRequestCallback;
            this.f8429c = typeface;
        }

        public void run() {
            this.f8428b.b(this.f8429c);
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FontsContractCompat.FontRequestCallback f8431b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f8432c;

        public b(FontsContractCompat.FontRequestCallback fontRequestCallback, int i11) {
            this.f8431b = fontRequestCallback;
            this.f8432c = i11;
        }

        public void run() {
            this.f8431b.a(this.f8432c);
        }
    }

    public a(FontsContractCompat.FontRequestCallback fontRequestCallback, Handler handler) {
        this.f8426a = fontRequestCallback;
        this.f8427b = handler;
    }

    public final void a(int i11) {
        this.f8427b.post(new b(this.f8426a, i11));
    }

    public void b(c.e eVar) {
        if (eVar.a()) {
            c(eVar.f8449a);
        } else {
            a(eVar.f8450b);
        }
    }

    public final void c(Typeface typeface) {
        this.f8427b.post(new C0024a(this.f8426a, typeface));
    }
}
