package androidx.credentials;

import android.os.Bundle;
import kotlin.jvm.internal.r;

public class m extends i {
    private final Bundle candidateQueryData;
    private final boolean isAutoSelectAllowed;
    private final boolean isSystemProviderRequired;
    private final Bundle requestData;
    private final String type;

    public m(String str, Bundle bundle, Bundle bundle2, boolean z11) {
        this(str, bundle, bundle2, z11, false, 16, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(String str, Bundle bundle, Bundle bundle2, boolean z11, boolean z12, int i11, r rVar) {
        this(str, bundle, bundle2, z11, (i11 & 16) != 0 ? false : z12);
    }

    public final Bundle getCandidateQueryData() {
        return this.candidateQueryData;
    }

    public final Bundle getRequestData() {
        return this.requestData;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean isAutoSelectAllowed() {
        return this.isAutoSelectAllowed;
    }

    public final boolean isSystemProviderRequired() {
        return this.isSystemProviderRequired;
    }

    public m(String str, Bundle bundle, Bundle bundle2, boolean z11, boolean z12) {
        super(str, bundle, bundle2, z11, z12);
        this.type = str;
        this.requestData = bundle;
        this.candidateQueryData = bundle2;
        this.isSystemProviderRequired = z11;
        this.isAutoSelectAllowed = z12;
        if (!bundle.containsKey(i.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED)) {
            bundle.putBoolean(i.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED, z12);
        }
        if (!(str.length() > 0)) {
            throw new IllegalArgumentException("type should not be empty".toString());
        }
    }
}
