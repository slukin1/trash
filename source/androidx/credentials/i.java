package androidx.credentials;

import android.os.Bundle;
import androidx.credentials.internal.FrameworkClassParsingException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class i {
    public static final String BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED = "androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED";
    public static final a Companion = new a((r) null);
    private final Bundle candidateQueryData;
    private final boolean isAutoSelectAllowed;
    private final boolean isSystemProviderRequired;
    private final Bundle requestData;
    private final String type;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final i a(String str, Bundle bundle, Bundle bundle2, boolean z11) {
            try {
                if (x.b(str, "android.credentials.TYPE_PASSWORD_CREDENTIAL")) {
                    return GetPasswordOption.f8752b.a(bundle);
                }
                if (x.b(str, "androidx.credentials.TYPE_PUBLIC_KEY_CREDENTIAL")) {
                    String string = bundle.getString("androidx.credentials.BUNDLE_KEY_SUBTYPE");
                    if (string != null && string.hashCode() == -613058807 && string.equals("androidx.credentials.BUNDLE_VALUE_SUBTYPE_GET_PUBLIC_KEY_CREDENTIAL_OPTION")) {
                        return n.f8812d.a(bundle);
                    }
                    throw new FrameworkClassParsingException();
                }
                throw new FrameworkClassParsingException();
            } catch (FrameworkClassParsingException unused) {
                return new m(str, bundle, bundle2, z11, bundle.getBoolean(i.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED, false));
            }
        }
    }

    public i(String str, Bundle bundle, Bundle bundle2, boolean z11, boolean z12) {
        this.type = str;
        this.requestData = bundle;
        this.candidateQueryData = bundle2;
        this.isSystemProviderRequired = z11;
        this.isAutoSelectAllowed = z12;
        Bundle requestData2 = getRequestData();
        if (requestData2 != null) {
            requestData2.putBoolean(BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED, isAutoSelectAllowed());
        }
    }

    public static final i createFrom(String str, Bundle bundle, Bundle bundle2, boolean z11) {
        return Companion.a(str, bundle, bundle2, z11);
    }

    public Bundle getCandidateQueryData() {
        return this.candidateQueryData;
    }

    public Bundle getRequestData() {
        return this.requestData;
    }

    public String getType() {
        return this.type;
    }

    public boolean isAutoSelectAllowed() {
        return this.isAutoSelectAllowed;
    }

    public boolean isSystemProviderRequired() {
        return this.isSystemProviderRequired;
    }
}
