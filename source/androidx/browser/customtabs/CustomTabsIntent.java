package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import p0.g;

public final class CustomTabsIntent {

    /* renamed from: a  reason: collision with root package name */
    public final Intent f4859a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f4860b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final Intent f4861a = new Intent("android.intent.action.VIEW");

        /* renamed from: b  reason: collision with root package name */
        public final CustomTabColorSchemeParams.Builder f4862b = new CustomTabColorSchemeParams.Builder();

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<Bundle> f4863c;

        /* renamed from: d  reason: collision with root package name */
        public Bundle f4864d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<Bundle> f4865e;

        /* renamed from: f  reason: collision with root package name */
        public SparseArray<Bundle> f4866f;

        /* renamed from: g  reason: collision with root package name */
        public Bundle f4867g;

        /* renamed from: h  reason: collision with root package name */
        public int f4868h = 0;

        /* renamed from: i  reason: collision with root package name */
        public boolean f4869i = true;

        public CustomTabsIntent a() {
            if (!this.f4861a.hasExtra("android.support.customtabs.extra.SESSION")) {
                c((IBinder) null, (PendingIntent) null);
            }
            ArrayList<Bundle> arrayList = this.f4863c;
            if (arrayList != null) {
                this.f4861a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f4865e;
            if (arrayList2 != null) {
                this.f4861a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f4861a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f4869i);
            this.f4861a.putExtras(this.f4862b.a().a());
            Bundle bundle = this.f4867g;
            if (bundle != null) {
                this.f4861a.putExtras(bundle);
            }
            if (this.f4866f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f4866f);
                this.f4861a.putExtras(bundle2);
            }
            this.f4861a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f4868h);
            return new CustomTabsIntent(this.f4861a, this.f4864d);
        }

        @Deprecated
        public Builder b() {
            this.f4861a.putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", true);
            return this;
        }

        public final void c(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            g.b(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f4861a.putExtras(bundle);
        }

        public Builder d(boolean z11) {
            this.f4861a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z11 ? 1 : 0);
            return this;
        }
    }

    public CustomTabsIntent(Intent intent, Bundle bundle) {
        this.f4859a = intent;
        this.f4860b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f4859a.setData(uri);
        ContextCompat.startActivity(context, this.f4859a, this.f4860b);
    }
}
