package androidx.credentials;

import android.os.Bundle;
import androidx.credentials.internal.FrameworkClassParsingException;
import kotlin.jvm.internal.r;

public final class o extends f {

    /* renamed from: c  reason: collision with root package name */
    public static final a f8816c = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f8817a;

    /* renamed from: b  reason: collision with root package name */
    public final String f8818b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final o a(Bundle bundle) {
            try {
                return new o(bundle.getString("androidx.credentials.BUNDLE_KEY_ID"), bundle.getString("androidx.credentials.BUNDLE_KEY_PASSWORD"));
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        public final Bundle b(String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString("androidx.credentials.BUNDLE_KEY_ID", str);
            bundle.putString("androidx.credentials.BUNDLE_KEY_PASSWORD", str2);
            return bundle;
        }
    }

    public o(String str, String str2) {
        super("android.credentials.TYPE_PASSWORD_CREDENTIAL", f8816c.b(str, str2));
        this.f8817a = str;
        this.f8818b = str2;
        if (!(str2.length() > 0)) {
            throw new IllegalArgumentException("password should not be empty".toString());
        }
    }
}
