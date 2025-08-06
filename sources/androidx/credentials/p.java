package androidx.credentials;

import android.os.Bundle;
import androidx.credentials.internal.FrameworkClassParsingException;
import kotlin.jvm.internal.r;

public final class p extends f {

    /* renamed from: b  reason: collision with root package name */
    public static final a f8819b = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f8820a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final p a(Bundle bundle) {
            try {
                return new p(bundle.getString("androidx.credentials.BUNDLE_KEY_AUTHENTICATION_RESPONSE_JSON"));
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        public final Bundle b(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("androidx.credentials.BUNDLE_KEY_AUTHENTICATION_RESPONSE_JSON", str);
            return bundle;
        }
    }

    public p(String str) {
        super("androidx.credentials.TYPE_PUBLIC_KEY_CREDENTIAL", f8819b.b(str));
        this.f8820a = str;
        if (!(str.length() > 0)) {
            throw new IllegalArgumentException("authentication response JSON must not be empty".toString());
        }
    }

    public final String a() {
        return this.f8820a;
    }
}
