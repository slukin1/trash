package com.sumsub.sns.internal.nfc;

import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.jmrtd.PassportService;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f35140a;

    /* renamed from: b  reason: collision with root package name */
    public final List<Short> f35141b;

    public b() {
        this(false, (List) null, 3, (r) null);
    }

    public final boolean a() {
        return this.f35140a;
    }

    public final List<Short> b() {
        return this.f35141b;
    }

    public final List<Short> c() {
        return this.f35141b;
    }

    public final boolean d() {
        return this.f35140a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f35140a == bVar.f35140a && x.b(this.f35141b, bVar.f35141b);
    }

    public int hashCode() {
        boolean z11 = this.f35140a;
        if (z11) {
            z11 = true;
        }
        return ((z11 ? 1 : 0) * true) + this.f35141b.hashCode();
    }

    public String toString() {
        return "NfcConfig(usePace=" + this.f35140a + ", files=" + this.f35141b + ')';
    }

    public b(boolean z11, List<Short> list) {
        this.f35140a = z11;
        this.f35141b = list;
    }

    public final b a(boolean z11, List<Short> list) {
        return new b(z11, list);
    }

    public static /* synthetic */ b a(b bVar, boolean z11, List<Short> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = bVar.f35140a;
        }
        if ((i11 & 2) != 0) {
            list = bVar.f35141b;
        }
        return bVar.a(z11, list);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(boolean z11, List list, int i11, r rVar) {
        this((i11 & 1) != 0 ? true : z11, (i11 & 2) != 0 ? CollectionsKt__CollectionsKt.n(Short.valueOf(PassportService.EF_COM), (short) 285, Short.valueOf(PassportService.EF_DG1), Short.valueOf(PassportService.EF_DG2)) : list);
    }
}
