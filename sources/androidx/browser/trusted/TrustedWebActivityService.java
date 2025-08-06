package androidx.browser.trusted;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import androidx.browser.trusted.a;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Locale;
import l.b;
import l.d;
import l.e;
import p0.m;

public abstract class TrustedWebActivityService extends Service {

    /* renamed from: b  reason: collision with root package name */
    public NotificationManager f4877b;

    /* renamed from: c  reason: collision with root package name */
    public int f4878c = -1;

    /* renamed from: d  reason: collision with root package name */
    public final ITrustedWebActivityService.Stub f4879d = new a();

    public class a extends ITrustedWebActivityService.Stub {
        public a() {
        }

        public Bundle areNotificationsEnabled(Bundle bundle) {
            d();
            return new a.e(TrustedWebActivityService.this.d(a.c.a(bundle).f4884a)).a();
        }

        public void cancelNotification(Bundle bundle) {
            d();
            a.b a11 = a.b.a(bundle);
            TrustedWebActivityService.this.e(a11.f4882a, a11.f4883b);
        }

        public final void d() {
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            if (trustedWebActivityService.f4878c == -1) {
                trustedWebActivityService.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                TrustedWebActivityService.this.c().load();
                TrustedWebActivityService.this.getPackageManager();
            }
            if (TrustedWebActivityService.this.f4878c != Binder.getCallingUid()) {
                throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
            }
        }

        public Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) {
            d();
            return TrustedWebActivityService.this.f(str, bundle, e.a(iBinder));
        }

        public Bundle getActiveNotifications() {
            d();
            return new a.C0007a(TrustedWebActivityService.this.g()).a();
        }

        public Bundle getSmallIconBitmap() {
            d();
            return TrustedWebActivityService.this.h();
        }

        public int getSmallIconId() {
            d();
            return TrustedWebActivityService.this.i();
        }

        public Bundle notifyNotificationWithChannel(Bundle bundle) {
            d();
            a.d a11 = a.d.a(bundle);
            return new a.e(TrustedWebActivityService.this.j(a11.f4885a, a11.f4886b, a11.f4887c, a11.f4888d)).a();
        }
    }

    public static String a(String str) {
        return str.toLowerCase(Locale.ROOT).replace(' ', '_') + "_channel_id";
    }

    public final void b() {
        if (this.f4877b == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
    }

    public abstract d c();

    public boolean d(String str) {
        b();
        if (!m.d(this).a()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        return b.b(this.f4877b, a(str));
    }

    public void e(String str, int i11) {
        b();
        this.f4877b.cancel(str, i11);
    }

    public Bundle f(String str, Bundle bundle, e eVar) {
        return null;
    }

    public Parcelable[] g() {
        b();
        if (Build.VERSION.SDK_INT >= 23) {
            return l.a.a(this.f4877b);
        }
        throw new IllegalStateException("onGetActiveNotifications cannot be called pre-M.");
    }

    public Bundle h() {
        int i11 = i();
        Bundle bundle = new Bundle();
        if (i11 == -1) {
            return bundle;
        }
        bundle.putParcelable("android.support.customtabs.trusted.SMALL_ICON_BITMAP", BitmapFactory.decodeResource(getResources(), i11));
        return bundle;
    }

    public int i() {
        try {
            Bundle bundle = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128).metaData;
            if (bundle == null) {
                return -1;
            }
            return bundle.getInt("android.support.customtabs.trusted.SMALL_ICON", -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public boolean j(String str, int i11, Notification notification, String str2) {
        b();
        if (!m.d(this).a()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            String a11 = a(str2);
            notification = b.a(this, this.f4877b, notification, a11, str2);
            if (!b.b(this.f4877b, a11)) {
                return false;
            }
        }
        this.f4877b.notify(str, i11, notification);
        return true;
    }

    public final IBinder onBind(Intent intent) {
        return this.f4879d;
    }

    public void onCreate() {
        super.onCreate();
        this.f4877b = (NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION);
    }

    public final boolean onUnbind(Intent intent) {
        this.f4878c = -1;
        return super.onUnbind(intent);
    }
}
