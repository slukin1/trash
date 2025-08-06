package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f57618a;

    /* renamed from: b  reason: collision with root package name */
    public List<? extends Annotation> f57619b = CollectionsKt__CollectionsKt.k();

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f57620c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final Set<String> f57621d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public final List<f> f57622e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<List<Annotation>> f57623f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final List<Boolean> f57624g = new ArrayList();

    public a(String str) {
        this.f57618a = str;
    }

    public static /* synthetic */ void b(a aVar, String str, f fVar, List list, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            list = CollectionsKt__CollectionsKt.k();
        }
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        aVar.a(str, fVar, list, z11);
    }

    public final void a(String str, f fVar, List<? extends Annotation> list, boolean z11) {
        if (this.f57621d.add(str)) {
            this.f57620c.add(str);
            this.f57622e.add(fVar);
            this.f57623f.add(list);
            this.f57624g.add(Boolean.valueOf(z11));
            return;
        }
        throw new IllegalArgumentException(("Element with name '" + str + "' is already registered in " + this.f57618a).toString());
    }

    public final List<Annotation> c() {
        return this.f57619b;
    }

    public final List<List<Annotation>> d() {
        return this.f57623f;
    }

    public final List<f> e() {
        return this.f57622e;
    }

    public final List<String> f() {
        return this.f57620c;
    }

    public final List<Boolean> g() {
        return this.f57624g;
    }

    public final void h(List<? extends Annotation> list) {
        this.f57619b = list;
    }
}
