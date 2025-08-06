package com.sumsub.sns.internal.fingerprint.signalproviders;

import com.sumsub.sns.internal.fingerprint.infoproviders.d;
import com.sumsub.sns.internal.fingerprint.infoproviders.g0;
import com.sumsub.sns.internal.fingerprint.infoproviders.i;
import com.sumsub.sns.internal.fingerprint.infoproviders.v;
import com.sumsub.sns.internal.fingerprint.infoproviders.y;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.l;

public abstract class a<T> extends d<T> {

    /* renamed from: c  reason: collision with root package name */
    public final StabilityLevel f34657c;

    /* renamed from: d  reason: collision with root package name */
    public final String f34658d;

    public a(StabilityLevel stabilityLevel, String str, String str2, T t11) {
        super(str, t11);
        this.f34657c = stabilityLevel;
        this.f34658d = str2;
    }

    public final Map<String, Object> a(d<?> dVar) {
        Object obj;
        Object b11 = dVar.b();
        if (b11 == null) {
            b11 = MapsKt__MapsKt.h();
        }
        if (b11 instanceof String) {
            return MapsKt__MapsJVMKt.e(l.a(f.f34662a, b11));
        }
        if (b11 instanceof Integer) {
            return MapsKt__MapsJVMKt.e(l.a(f.f34662a, b11));
        }
        if (b11 instanceof Long) {
            return MapsKt__MapsJVMKt.e(l.a(f.f34662a, b11));
        }
        if (b11 instanceof Boolean) {
            return MapsKt__MapsJVMKt.e(l.a(f.f34662a, b11));
        }
        if (b11 instanceof Map) {
            return MapsKt__MapsJVMKt.e(l.a(f.f34662a, b11));
        }
        if (b11 instanceof List) {
            Iterable iterable = (Iterable) b11;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(iterable, 10));
            for (Object next : iterable) {
                if (next instanceof y) {
                    y yVar = (y) next;
                    obj = MapsKt__MapsKt.l(l.a("codecName", yVar.d()), l.a("codecCapabilities", yVar.c()));
                } else if (next instanceof v) {
                    v vVar = (v) next;
                    obj = MapsKt__MapsKt.l(l.a("vendor", vVar.d()), l.a("name", vVar.c()));
                } else if (next instanceof g0) {
                    g0 g0Var = (g0) next;
                    obj = MapsKt__MapsKt.l(l.a("sensorName", g0Var.a()), l.a("vendorName", g0Var.b()));
                } else if (next instanceof d) {
                    d dVar2 = (d) next;
                    obj = MapsKt__MapsKt.l(l.a("cameraName", dVar2.d()), l.a("cameraType", dVar2.f()), l.a("cameraOrientation", dVar2.e()));
                } else if (next instanceof Pair) {
                    Pair pair = (Pair) next;
                    obj = CollectionsKt__CollectionsKt.n(String.valueOf(pair.getFirst()), String.valueOf(pair.getSecond()));
                } else {
                    obj = String.valueOf(next);
                }
                arrayList.add(obj);
            }
            return MapsKt__MapsJVMKt.e(l.a(f.f34662a, arrayList));
        } else if (!(b11 instanceof i)) {
            return MapsKt__MapsJVMKt.e(l.a(f.f34662a, b11.toString()));
        } else {
            i iVar = (i) b11;
            List<Pair<String, String>> d11 = iVar.d();
            int size = iVar.e().size();
            List w11 = CollectionsKt__IterablesKt.w(iVar.e());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object next2 : w11) {
                Pair pair2 = (Pair) next2;
                Object obj2 = linkedHashMap.get(pair2);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(pair2, obj2);
                }
                ((List) obj2).add(next2);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (((List) entry.getValue()).size() == size) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            ArrayList<Pair> arrayList2 = new ArrayList<>(linkedHashMap2.size());
            for (Map.Entry key : linkedHashMap2.entrySet()) {
                arrayList2.add((Pair) key.getKey());
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.u(arrayList2, 10));
            for (Pair first : arrayList2) {
                arrayList3.add((String) first.getFirst());
            }
            Set N0 = CollectionsKt___CollectionsKt.N0(arrayList3);
            List<List<Pair<String, String>>> e11 = iVar.e();
            ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.u(e11, 10));
            for (List it2 : e11) {
                ArrayList arrayList5 = new ArrayList();
                for (Object next3 : it2) {
                    if (!N0.contains(((Pair) next3).getFirst())) {
                        arrayList5.add(next3);
                    }
                }
                arrayList4.add(arrayList5);
            }
            return MapsKt__MapsJVMKt.e(l.a(f.f34662a, MapsKt__MapsKt.l(l.a("commonProps", d11), l.a("repeatedProps", arrayList2), l.a("uniquePerCpuProps", arrayList4))));
        }
    }

    public Map<String, Object> c() {
        return a(this);
    }

    public final String d() {
        return this.f34658d;
    }

    public final StabilityLevel e() {
        return this.f34657c;
    }

    public abstract String toString();
}
