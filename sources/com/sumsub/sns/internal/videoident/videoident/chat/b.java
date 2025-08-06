package com.sumsub.sns.internal.videoident.videoident.chat;

import kotlin.jvm.internal.r;

public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final a f37047e = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f37048a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f37049b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f37050c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f37051d;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final b a() {
            return new b(false, false, false, false);
        }

        public final b b() {
            return a();
        }

        public a() {
        }
    }

    public b(boolean z11, boolean z12, boolean z13, boolean z14) {
        this.f37048a = z11;
        this.f37049b = z12;
        this.f37050c = z13;
        this.f37051d = z14;
    }

    public final boolean a() {
        return this.f37048a;
    }

    public final boolean b() {
        return this.f37049b;
    }

    public final boolean c() {
        return this.f37050c;
    }

    public final boolean d() {
        return this.f37051d;
    }

    public final boolean e() {
        return this.f37049b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f37048a == bVar.f37048a && this.f37049b == bVar.f37049b && this.f37050c == bVar.f37050c && this.f37051d == bVar.f37051d;
    }

    public final boolean f() {
        return this.f37048a;
    }

    public final boolean g() {
        return this.f37051d;
    }

    public final boolean h() {
        return this.f37050c;
    }

    public int hashCode() {
        boolean z11 = this.f37048a;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        boolean z13 = this.f37049b;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.f37050c;
        if (z14) {
            z14 = true;
        }
        int i13 = (i12 + (z14 ? 1 : 0)) * 31;
        boolean z15 = this.f37051d;
        if (!z15) {
            z12 = z15;
        }
        return i13 + (z12 ? 1 : 0);
    }

    public String toString() {
        return "ParticipantState(connected=" + this.f37048a + ", audioTrackSubscribed=" + this.f37049b + ", videoTrackSubscribed=" + this.f37050c + ", dataTrackSubscribed=" + this.f37051d + ')';
    }

    public final b a(boolean z11, boolean z12, boolean z13, boolean z14) {
        return new b(z11, z12, z13, z14);
    }

    public static /* synthetic */ b a(b bVar, boolean z11, boolean z12, boolean z13, boolean z14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = bVar.f37048a;
        }
        if ((i11 & 2) != 0) {
            z12 = bVar.f37049b;
        }
        if ((i11 & 4) != 0) {
            z13 = bVar.f37050c;
        }
        if ((i11 & 8) != 0) {
            z14 = bVar.f37051d;
        }
        return bVar.a(z11, z12, z13, z14);
    }
}
