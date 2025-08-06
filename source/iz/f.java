package iz;

import android.util.Log;

public class f implements b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f52899a = false;

    public void a(boolean z11) {
        this.f52899a = z11;
    }

    public void d(String str, String str2) {
        if (this.f52899a) {
            Log.d(str, str2);
        }
    }

    public void e(String str, String str2) {
        if (this.f52899a) {
            Log.e(str, str2);
        }
    }

    public void w(String str, String str2) {
        if (this.f52899a) {
            Log.w(str, str2);
        }
    }

    public void e(String str, String str2, Throwable th2) {
        if (this.f52899a) {
            Log.e(str, str2, th2);
        }
    }
}
