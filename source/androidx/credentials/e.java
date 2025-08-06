package androidx.credentials;

import android.os.Bundle;
import kotlin.jvm.internal.r;

public final class e extends b {

    /* renamed from: e  reason: collision with root package name */
    public static final a f8777e = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public final String f8778d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final Bundle a(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("androidx.credentials.BUNDLE_KEY_REGISTRATION_RESPONSE_JSON", str);
            return bundle;
        }
    }

    public e(String str) {
        super("androidx.credentials.TYPE_PUBLIC_KEY_CREDENTIAL", f8777e.a(str));
        this.f8778d = str;
        if (!(str.length() > 0)) {
            throw new IllegalArgumentException("registrationResponseJson must not be empty".toString());
        }
    }

    public final String a() {
        return this.f8778d;
    }
}
