package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.g;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.n0;
import androidx.collection.ArraySet;
import androidx.core.os.LocaleListCompat;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class AppCompatDelegate {

    /* renamed from: b  reason: collision with root package name */
    public static g.a f3812b = new g.a(new g.b());

    /* renamed from: c  reason: collision with root package name */
    public static int f3813c = -100;

    /* renamed from: d  reason: collision with root package name */
    public static LocaleListCompat f3814d = null;

    /* renamed from: e  reason: collision with root package name */
    public static LocaleListCompat f3815e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Boolean f3816f = null;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f3817g = false;

    /* renamed from: h  reason: collision with root package name */
    public static final ArraySet<WeakReference<AppCompatDelegate>> f3818h = new ArraySet<>();

    /* renamed from: i  reason: collision with root package name */
    public static final Object f3819i = new Object();

    /* renamed from: j  reason: collision with root package name */
    public static final Object f3820j = new Object();

    public static class a {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    public static class b {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    public static void F(AppCompatDelegate appCompatDelegate) {
        synchronized (f3819i) {
            G(appCompatDelegate);
        }
    }

    public static void G(AppCompatDelegate appCompatDelegate) {
        synchronized (f3819i) {
            Iterator<WeakReference<AppCompatDelegate>> it2 = f3818h.iterator();
            while (it2.hasNext()) {
                AppCompatDelegate appCompatDelegate2 = (AppCompatDelegate) it2.next().get();
                if (appCompatDelegate2 == appCompatDelegate || appCompatDelegate2 == null) {
                    it2.remove();
                }
            }
        }
    }

    public static void I(boolean z11) {
        n0.c(z11);
    }

    public static void M(int i11) {
        if (i11 != -1 && i11 != 0 && i11 != 1 && i11 != 2 && i11 != 3) {
            Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
        } else if (f3813c != i11) {
            f3813c = i11;
            e();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void S(android.content.Context r3) {
        /*
            boolean r0 = v(r3)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = androidx.core.os.a.b()
            if (r0 == 0) goto L_0x001c
            boolean r0 = f3817g
            if (r0 != 0) goto L_0x0054
            androidx.appcompat.app.g$a r0 = f3812b
            androidx.appcompat.app.b r1 = new androidx.appcompat.app.b
            r1.<init>(r3)
            r0.execute(r1)
            goto L_0x0054
        L_0x001c:
            java.lang.Object r0 = f3820j
            monitor-enter(r0)
            androidx.core.os.LocaleListCompat r1 = f3814d     // Catch:{ all -> 0x0055 }
            if (r1 != 0) goto L_0x0040
            androidx.core.os.LocaleListCompat r1 = f3815e     // Catch:{ all -> 0x0055 }
            if (r1 != 0) goto L_0x0031
            java.lang.String r3 = androidx.appcompat.app.g.b(r3)     // Catch:{ all -> 0x0055 }
            androidx.core.os.LocaleListCompat r3 = androidx.core.os.LocaleListCompat.c(r3)     // Catch:{ all -> 0x0055 }
            f3815e = r3     // Catch:{ all -> 0x0055 }
        L_0x0031:
            androidx.core.os.LocaleListCompat r3 = f3815e     // Catch:{ all -> 0x0055 }
            boolean r3 = r3.f()     // Catch:{ all -> 0x0055 }
            if (r3 == 0) goto L_0x003b
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            return
        L_0x003b:
            androidx.core.os.LocaleListCompat r3 = f3815e     // Catch:{ all -> 0x0055 }
            f3814d = r3     // Catch:{ all -> 0x0055 }
            goto L_0x0053
        L_0x0040:
            androidx.core.os.LocaleListCompat r2 = f3815e     // Catch:{ all -> 0x0055 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0055 }
            if (r1 != 0) goto L_0x0053
            androidx.core.os.LocaleListCompat r1 = f3814d     // Catch:{ all -> 0x0055 }
            f3815e = r1     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = r1.h()     // Catch:{ all -> 0x0055 }
            androidx.appcompat.app.g.a(r3, r1)     // Catch:{ all -> 0x0055 }
        L_0x0053:
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
        L_0x0054:
            return
        L_0x0055:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegate.S(android.content.Context):void");
    }

    public static void b(AppCompatDelegate appCompatDelegate) {
        synchronized (f3819i) {
            G(appCompatDelegate);
            f3818h.add(new WeakReference(appCompatDelegate));
        }
    }

    public static void e() {
        synchronized (f3819i) {
            Iterator<WeakReference<AppCompatDelegate>> it2 = f3818h.iterator();
            while (it2.hasNext()) {
                AppCompatDelegate appCompatDelegate = (AppCompatDelegate) it2.next().get();
                if (appCompatDelegate != null) {
                    appCompatDelegate.d();
                }
            }
        }
    }

    public static AppCompatDelegate h(Activity activity, a aVar) {
        return new AppCompatDelegateImpl(activity, aVar);
    }

    public static AppCompatDelegate i(Dialog dialog, a aVar) {
        return new AppCompatDelegateImpl(dialog, aVar);
    }

    public static LocaleListCompat k() {
        if (androidx.core.os.a.b()) {
            Object p11 = p();
            if (p11 != null) {
                return LocaleListCompat.j(b.a(p11));
            }
        } else {
            LocaleListCompat localeListCompat = f3814d;
            if (localeListCompat != null) {
                return localeListCompat;
            }
        }
        return LocaleListCompat.e();
    }

    public static int m() {
        return f3813c;
    }

    public static Object p() {
        Context l11;
        Iterator<WeakReference<AppCompatDelegate>> it2 = f3818h.iterator();
        while (it2.hasNext()) {
            AppCompatDelegate appCompatDelegate = (AppCompatDelegate) it2.next().get();
            if (appCompatDelegate != null && (l11 = appCompatDelegate.l()) != null) {
                return l11.getSystemService("locale");
            }
        }
        return null;
    }

    public static LocaleListCompat r() {
        return f3814d;
    }

    public static boolean v(Context context) {
        if (f3816f == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.a(context).metaData;
                if (bundle != null) {
                    f3816f = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f3816f = Boolean.FALSE;
            }
        }
        return f3816f.booleanValue();
    }

    public static /* synthetic */ void w(Context context) {
        g.c(context);
        f3817g = true;
    }

    public abstract void A(Bundle bundle);

    public abstract void B();

    public abstract void C(Bundle bundle);

    public abstract void D();

    public abstract void E();

    public abstract boolean H(int i11);

    public abstract void J(int i11);

    public abstract void K(View view);

    public abstract void L(View view, ViewGroup.LayoutParams layoutParams);

    public void N(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void O(Toolbar toolbar);

    public void P(int i11) {
    }

    public abstract void Q(CharSequence charSequence);

    public abstract ActionMode R(ActionMode.Callback callback);

    public abstract void c(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean d();

    @Deprecated
    public void f(Context context) {
    }

    public Context g(Context context) {
        f(context);
        return context;
    }

    public abstract <T extends View> T j(int i11);

    public Context l() {
        return null;
    }

    public abstract ActionBarDrawerToggle$Delegate n();

    public int o() {
        return -100;
    }

    public abstract MenuInflater q();

    public abstract ActionBar s();

    public abstract void t();

    public abstract void u();

    public abstract void x(Configuration configuration);

    public abstract void y(Bundle bundle);

    public abstract void z();
}
