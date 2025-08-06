package com.sumsub.sns.internal.fingerprint.infoproviders;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class i {

    /* renamed from: c  reason: collision with root package name */
    public static final a f34610c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final i f34611d = new i(CollectionsKt__CollectionsKt.k(), CollectionsKt__CollectionsKt.k());

    /* renamed from: a  reason: collision with root package name */
    public final List<Pair<String, String>> f34612a;

    /* renamed from: b  reason: collision with root package name */
    public final List<List<Pair<String, String>>> f34613b;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final i a() {
            return i.f34611d;
        }

        public a() {
        }
    }

    public i(List<Pair<String, String>> list, List<? extends List<Pair<String, String>>> list2) {
        this.f34612a = list;
        this.f34613b = list2;
    }

    public final i a(List<Pair<String, String>> list, List<? extends List<Pair<String, String>>> list2) {
        return new i(list, list2);
    }

    public final List<Pair<String, String>> b() {
        return this.f34612a;
    }

    public final List<List<Pair<String, String>>> c() {
        return this.f34613b;
    }

    public final List<Pair<String, String>> d() {
        return this.f34612a;
    }

    public final List<List<Pair<String, String>>> e() {
        return this.f34613b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return x.b(this.f34612a, iVar.f34612a) && x.b(this.f34613b, iVar.f34613b);
    }

    public int hashCode() {
        return (this.f34612a.hashCode() * 31) + this.f34613b.hashCode();
    }

    public String toString() {
        return "CpuInfo(commonInfo=" + this.f34612a + ", perProcessorInfo=" + this.f34613b + ')';
    }

    public static /* synthetic */ i a(i iVar, List<Pair<String, String>> list, List<List<Pair<String, String>>> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = iVar.f34612a;
        }
        if ((i11 & 2) != 0) {
            list2 = iVar.f34613b;
        }
        return iVar.a(list, list2);
    }
}
