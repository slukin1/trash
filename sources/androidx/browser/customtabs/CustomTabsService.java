package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import androidx.collection.SimpleArrayMap;
import java.util.List;
import java.util.NoSuchElementException;
import k.b;
import k.c;

public abstract class CustomTabsService extends Service {

    /* renamed from: b  reason: collision with root package name */
    public final SimpleArrayMap<IBinder, IBinder.DeathRecipient> f4870b = new SimpleArrayMap<>();

    /* renamed from: c  reason: collision with root package name */
    public ICustomTabsService.Stub f4871c = new a();

    public class a extends ICustomTabsService.Stub {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(c cVar) {
            CustomTabsService.this.a(cVar);
        }

        public Bundle extraCommand(String str, Bundle bundle) {
            return CustomTabsService.this.b(str, bundle);
        }

        public final PendingIntent g(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
            bundle.remove("android.support.customtabs.extra.SESSION_ID");
            return pendingIntent;
        }

        public final boolean i(ICustomTabsCallback iCustomTabsCallback, PendingIntent pendingIntent) {
            c cVar = new c(iCustomTabsCallback, pendingIntent);
            try {
                b bVar = new b(this, cVar);
                synchronized (CustomTabsService.this.f4870b) {
                    iCustomTabsCallback.asBinder().linkToDeath(bVar, 0);
                    CustomTabsService.this.f4870b.put(iCustomTabsCallback.asBinder(), bVar);
                }
                return CustomTabsService.this.d(cVar);
            } catch (RemoteException unused) {
                return false;
            }
        }

        public boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list) {
            return CustomTabsService.this.c(new c(iCustomTabsCallback, g(bundle)), uri, bundle, list);
        }

        public boolean newSession(ICustomTabsCallback iCustomTabsCallback) {
            return i(iCustomTabsCallback, (PendingIntent) null);
        }

        public boolean newSessionWithExtras(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return i(iCustomTabsCallback, g(bundle));
        }

        public int postMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            return CustomTabsService.this.e(new c(iCustomTabsCallback, g(bundle)), str, bundle);
        }

        public boolean receiveFile(ICustomTabsCallback iCustomTabsCallback, Uri uri, int i11, Bundle bundle) {
            return CustomTabsService.this.f(new c(iCustomTabsCallback, g(bundle)), uri, i11, bundle);
        }

        public boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
            return CustomTabsService.this.g(new c(iCustomTabsCallback, (PendingIntent) null), uri);
        }

        public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle) {
            return CustomTabsService.this.g(new c(iCustomTabsCallback, g(bundle)), uri);
        }

        public boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return CustomTabsService.this.h(new c(iCustomTabsCallback, g(bundle)), bundle);
        }

        public boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback, int i11, Uri uri, Bundle bundle) {
            return CustomTabsService.this.i(new c(iCustomTabsCallback, g(bundle)), i11, uri, bundle);
        }

        public boolean warmup(long j11) {
            return CustomTabsService.this.j(j11);
        }
    }

    public boolean a(c cVar) {
        try {
            synchronized (this.f4870b) {
                IBinder a11 = cVar.a();
                if (a11 == null) {
                    return false;
                }
                a11.unlinkToDeath(this.f4870b.get(a11), 0);
                this.f4870b.remove(a11);
                return true;
            }
        } catch (NoSuchElementException unused) {
            return false;
        }
    }

    public abstract Bundle b(String str, Bundle bundle);

    public abstract boolean c(c cVar, Uri uri, Bundle bundle, List<Bundle> list);

    public abstract boolean d(c cVar);

    public abstract int e(c cVar, String str, Bundle bundle);

    public abstract boolean f(c cVar, Uri uri, int i11, Bundle bundle);

    public abstract boolean g(c cVar, Uri uri);

    public abstract boolean h(c cVar, Bundle bundle);

    public abstract boolean i(c cVar, int i11, Uri uri, Bundle bundle);

    public abstract boolean j(long j11);

    public IBinder onBind(Intent intent) {
        return this.f4871c;
    }
}
