package androidx.browser.trusted;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;

public final class a {

    /* renamed from: androidx.browser.trusted.a$a  reason: collision with other inner class name */
    public static class C0007a {

        /* renamed from: a  reason: collision with root package name */
        public final Parcelable[] f4881a;

        public C0007a(Parcelable[] parcelableArr) {
            this.f4881a = parcelableArr;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", this.f4881a);
            return bundle;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f4882a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4883b;

        public b(String str, int i11) {
            this.f4882a = str;
            this.f4883b = i11;
        }

        public static b a(Bundle bundle) {
            a.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            a.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            return new b(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"));
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f4884a;

        public c(String str) {
            this.f4884a = str;
        }

        public static c a(Bundle bundle) {
            a.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new c(bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f4885a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4886b;

        /* renamed from: c  reason: collision with root package name */
        public final Notification f4887c;

        /* renamed from: d  reason: collision with root package name */
        public final String f4888d;

        public d(String str, int i11, Notification notification, String str2) {
            this.f4885a = str;
            this.f4886b = i11;
            this.f4887c = notification;
            this.f4888d = str2;
        }

        public static d a(Bundle bundle) {
            a.a(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            a.a(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            a.a(bundle, "android.support.customtabs.trusted.NOTIFICATION");
            a.a(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new d(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"), (Notification) bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION"), bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f4889a;

        public e(boolean z11) {
            this.f4889a = z11;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", this.f4889a);
            return bundle;
        }
    }

    public static void a(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            throw new IllegalArgumentException("Bundle must contain " + str);
        }
    }
}
