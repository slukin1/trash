package androidx.credentials;

import android.os.Bundle;
import androidx.credentials.internal.FrameworkClassParsingException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class f {
    public static final a Companion = new a((r) null);
    private final Bundle data;
    private final String type;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final f a(String str, Bundle bundle) {
            try {
                if (x.b(str, "android.credentials.TYPE_PASSWORD_CREDENTIAL")) {
                    return o.f8816c.a(bundle);
                }
                if (x.b(str, "androidx.credentials.TYPE_PUBLIC_KEY_CREDENTIAL")) {
                    return p.f8819b.a(bundle);
                }
                throw new FrameworkClassParsingException();
            } catch (FrameworkClassParsingException unused) {
                return new k(str, bundle);
            }
        }
    }

    public f(String str, Bundle bundle) {
        this.type = str;
        this.data = bundle;
    }

    public static final f createFrom(String str, Bundle bundle) {
        return Companion.a(str, bundle);
    }

    public Bundle getData() {
        return this.data;
    }

    public String getType() {
        return this.type;
    }
}
