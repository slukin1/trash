package com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class h extends f {

    /* renamed from: b  reason: collision with root package name */
    public final String f35641b;

    /* renamed from: c  reason: collision with root package name */
    public final String f35642c;

    public h(String str, String str2) {
        super(false, "Authentication is not started", (String) null, 4, (r) null);
        this.f35641b = str;
        this.f35642c = str2;
    }

    public final h a(String str, String str2) {
        return new h(str, str2);
    }

    public final String b() {
        return this.f35641b;
    }

    public final String c() {
        return this.f35642c;
    }

    public final String d() {
        return this.f35642c;
    }

    public final String e() {
        return this.f35641b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return x.b(this.f35641b, hVar.f35641b) && x.b(this.f35642c, hVar.f35642c);
    }

    public int hashCode() {
        int hashCode = this.f35641b.hashCode() * 31;
        String str = this.f35642c;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SNSEidStartReadingException(cardPin=" + this.f35641b + ", cardCan=" + this.f35642c + ')';
    }

    public static /* synthetic */ h a(h hVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = hVar.f35641b;
        }
        if ((i11 & 2) != 0) {
            str2 = hVar.f35642c;
        }
        return hVar.a(str, str2);
    }
}
