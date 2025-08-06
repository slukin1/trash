package j;

import android.os.Build;
import android.os.CancellationSignal;
import android.util.Log;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final c f16001a = new a();

    /* renamed from: b  reason: collision with root package name */
    public CancellationSignal f16002b;

    /* renamed from: c  reason: collision with root package name */
    public androidx.core.os.CancellationSignal f16003c;

    public class a implements c {
        public a() {
        }

        public androidx.core.os.CancellationSignal a() {
            return new androidx.core.os.CancellationSignal();
        }

        public CancellationSignal b() {
            return C0086b.b();
        }
    }

    /* renamed from: j.b$b  reason: collision with other inner class name */
    public static class C0086b {
        public static void a(CancellationSignal cancellationSignal) {
            cancellationSignal.cancel();
        }

        public static CancellationSignal b() {
            return new CancellationSignal();
        }
    }

    public interface c {
        androidx.core.os.CancellationSignal a();

        CancellationSignal b();
    }

    public void a() {
        CancellationSignal cancellationSignal;
        if (Build.VERSION.SDK_INT >= 16 && (cancellationSignal = this.f16002b) != null) {
            try {
                C0086b.a(cancellationSignal);
            } catch (NullPointerException e11) {
                Log.e("CancelSignalProvider", "Got NPE while canceling biometric authentication.", e11);
            }
            this.f16002b = null;
        }
        androidx.core.os.CancellationSignal cancellationSignal2 = this.f16003c;
        if (cancellationSignal2 != null) {
            try {
                cancellationSignal2.a();
            } catch (NullPointerException e12) {
                Log.e("CancelSignalProvider", "Got NPE while canceling fingerprint authentication.", e12);
            }
            this.f16003c = null;
        }
    }

    public CancellationSignal b() {
        if (this.f16002b == null) {
            this.f16002b = this.f16001a.b();
        }
        return this.f16002b;
    }

    public androidx.core.os.CancellationSignal c() {
        if (this.f16003c == null) {
            this.f16003c = this.f16001a.a();
        }
        return this.f16003c;
    }
}
