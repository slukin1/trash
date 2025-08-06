package com.google.android.play.core.integrity;

import android.net.Network;

final class e extends IntegrityTokenRequest {

    /* renamed from: a  reason: collision with root package name */
    private final String f66830a;

    /* renamed from: b  reason: collision with root package name */
    private final Long f66831b;

    public /* synthetic */ e(String str, Long l11, Network network, d dVar) {
        this.f66830a = str;
        this.f66831b = l11;
    }

    public final Network a() {
        return null;
    }

    public final Long cloudProjectNumber() {
        return this.f66831b;
    }

    public final boolean equals(Object obj) {
        Long l11;
        if (obj == this) {
            return true;
        }
        if (obj instanceof IntegrityTokenRequest) {
            IntegrityTokenRequest integrityTokenRequest = (IntegrityTokenRequest) obj;
            if (this.f66830a.equals(integrityTokenRequest.nonce()) && ((l11 = this.f66831b) != null ? l11.equals(integrityTokenRequest.cloudProjectNumber()) : integrityTokenRequest.cloudProjectNumber() == null)) {
                integrityTokenRequest.a();
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int hashCode = this.f66830a.hashCode() ^ 1000003;
        Long l11 = this.f66831b;
        if (l11 == null) {
            i11 = 0;
        } else {
            i11 = l11.hashCode();
        }
        return ((hashCode * 1000003) ^ i11) * 1000003;
    }

    public final String nonce() {
        return this.f66830a;
    }

    public final String toString() {
        String str = this.f66830a;
        Long l11 = this.f66831b;
        return "IntegrityTokenRequest{nonce=" + str + ", cloudProjectNumber=" + l11 + ", network=null}";
    }
}
