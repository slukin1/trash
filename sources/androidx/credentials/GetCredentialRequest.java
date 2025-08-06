package androidx.credentials;

import java.util.ArrayList;
import java.util.List;

public final class GetCredentialRequest {

    /* renamed from: a  reason: collision with root package name */
    public final List<i> f8748a;

    /* renamed from: b  reason: collision with root package name */
    public final String f8749b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public List<i> f8750a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public String f8751b;

        public final Builder a(i iVar) {
            this.f8750a.add(iVar);
            return this;
        }

        public final GetCredentialRequest b() {
            return new GetCredentialRequest(CollectionsKt___CollectionsKt.I0(this.f8750a), this.f8751b);
        }
    }

    public GetCredentialRequest(List<? extends i> list, String str) {
        this.f8748a = list;
        this.f8749b = str;
        if (!(!list.isEmpty())) {
            throw new IllegalArgumentException("credentialOptions should not be empty".toString());
        }
    }

    public final List<i> a() {
        return this.f8748a;
    }
}
