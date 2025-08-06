package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.infoproviders.i;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class i0 extends v<i> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34349b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34350c = new v.a(StabilityLevel.STABLE);

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f34351d = SetsKt__SetsJVMKt.c("processor");

    /* renamed from: e  reason: collision with root package name */
    public static final Set<String> f34352e = SetsKt__SetsKt.f("bogomips", "cpu mhz");

    /* renamed from: a  reason: collision with root package name */
    public final i f34353a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return i0.f34350c;
        }

        public a() {
        }
    }

    public i0(i iVar) {
        super((r) null);
        List<Pair<String, String>> d11 = iVar.d();
        ArrayList arrayList = new ArrayList();
        for (T next : d11) {
            if (!f34351d.contains(((String) ((Pair) next).getFirst()).toLowerCase(Locale.ROOT))) {
                arrayList.add(next);
            }
        }
        List<List<Pair<String, String>>> e11 = iVar.e();
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.u(e11, 10));
        for (List it2 : e11) {
            ArrayList arrayList3 = new ArrayList();
            for (Object next2 : it2) {
                if (!f34352e.contains(((String) ((Pair) next2).getFirst()).toLowerCase(Locale.ROOT))) {
                    arrayList3.add(next2);
                }
            }
            arrayList2.add(arrayList3);
        }
        this.f34353a = iVar.a(arrayList, arrayList2);
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(c().d());
        sb2.append(c().e());
        return sb2.toString();
    }

    public v.a b() {
        return f34350c;
    }

    public Map<String, String> d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : c().d()) {
            l.a(linkedHashMap.get("proc_cpu_info.common." + w.b((String) pair.getFirst())), pair.getSecond());
        }
        int i11 = 0;
        for (T next : c().e()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            for (Pair pair2 : (List) next) {
                l.a(linkedHashMap.get("proc_cpu_info.processor." + i11 + '.' + w.b((String) pair2.getFirst())), pair2.getSecond());
            }
            i11 = i12;
        }
        return linkedHashMap;
    }

    /* renamed from: f */
    public i c() {
        return this.f34353a;
    }
}
