package com.sumsub.sns.internal.videoident.presentation;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f36689a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f36690b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f36691c;

    public e(boolean z11, CharSequence charSequence, boolean z12) {
        this.f36689a = z11;
        this.f36690b = charSequence;
        this.f36691c = z12;
    }

    public final boolean a() {
        return this.f36689a;
    }

    public final CharSequence b() {
        return this.f36690b;
    }

    public final boolean c() {
        return this.f36691c;
    }

    public final CharSequence d() {
        return this.f36690b;
    }

    public final boolean e() {
        return this.f36691c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f36689a == eVar.f36689a && x.b(this.f36690b, eVar.f36690b) && this.f36691c == eVar.f36691c;
    }

    public final boolean f() {
        return this.f36689a;
    }

    public int hashCode() {
        boolean z11 = this.f36689a;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        CharSequence charSequence = this.f36690b;
        int hashCode = (i11 + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
        boolean z13 = this.f36691c;
        if (!z13) {
            z12 = z13;
        }
        return hashCode + (z12 ? 1 : 0);
    }

    public String toString() {
        return "RemoteVideoState(showVideoView=" + this.f36689a + ", caption=" + this.f36690b + ", showLoader=" + this.f36691c + ')';
    }

    public final e a(boolean z11, CharSequence charSequence, boolean z12) {
        return new e(z11, charSequence, z12);
    }

    public static /* synthetic */ e a(e eVar, boolean z11, CharSequence charSequence, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = eVar.f36689a;
        }
        if ((i11 & 2) != 0) {
            charSequence = eVar.f36690b;
        }
        if ((i11 & 4) != 0) {
            z12 = eVar.f36691c;
        }
        return eVar.a(z11, charSequence, z12);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(boolean z11, CharSequence charSequence, boolean z12, int i11, r rVar) {
        this(z11, charSequence, (i11 & 4) != 0 ? false : z12);
    }
}
