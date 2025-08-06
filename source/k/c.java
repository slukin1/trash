package k;

import android.app.PendingIntent;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsCallback;
import androidx.browser.customtabs.CustomTabsCallback;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final ICustomTabsCallback f16013a;

    /* renamed from: b  reason: collision with root package name */
    public final PendingIntent f16014b;

    /* renamed from: c  reason: collision with root package name */
    public final CustomTabsCallback f16015c;

    public class a extends CustomTabsCallback {
        public a() {
        }
    }

    public c(ICustomTabsCallback iCustomTabsCallback, PendingIntent pendingIntent) {
        a aVar;
        if (iCustomTabsCallback == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.f16013a = iCustomTabsCallback;
        this.f16014b = pendingIntent;
        if (iCustomTabsCallback == null) {
            aVar = null;
        } else {
            aVar = new a();
        }
        this.f16015c = aVar;
    }

    public IBinder a() {
        ICustomTabsCallback iCustomTabsCallback = this.f16013a;
        if (iCustomTabsCallback == null) {
            return null;
        }
        return iCustomTabsCallback.asBinder();
    }

    public final IBinder b() {
        ICustomTabsCallback iCustomTabsCallback = this.f16013a;
        if (iCustomTabsCallback != null) {
            return iCustomTabsCallback.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    public PendingIntent c() {
        return this.f16014b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        PendingIntent c11 = cVar.c();
        PendingIntent pendingIntent = this.f16014b;
        boolean z11 = true;
        boolean z12 = pendingIntent == null;
        if (c11 != null) {
            z11 = false;
        }
        if (z12 != z11) {
            return false;
        }
        if (pendingIntent != null) {
            return pendingIntent.equals(c11);
        }
        return b().equals(cVar.b());
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.f16014b;
        if (pendingIntent != null) {
            return pendingIntent.hashCode();
        }
        return b().hashCode();
    }
}
