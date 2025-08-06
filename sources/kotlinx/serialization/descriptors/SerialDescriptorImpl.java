package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.i;
import kotlin.jvm.internal.x;
import kotlin.l;
import kotlin.ranges.h;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.internal.g1;
import kotlinx.serialization.internal.m;

public final class SerialDescriptorImpl implements f, m {

    /* renamed from: a  reason: collision with root package name */
    public final String f57606a;

    /* renamed from: b  reason: collision with root package name */
    public final h f57607b;

    /* renamed from: c  reason: collision with root package name */
    public final int f57608c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Annotation> f57609d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<String> f57610e;

    /* renamed from: f  reason: collision with root package name */
    public final String[] f57611f;

    /* renamed from: g  reason: collision with root package name */
    public final f[] f57612g;

    /* renamed from: h  reason: collision with root package name */
    public final List<Annotation>[] f57613h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean[] f57614i;

    /* renamed from: j  reason: collision with root package name */
    public final Map<String, Integer> f57615j;

    /* renamed from: k  reason: collision with root package name */
    public final f[] f57616k;

    /* renamed from: l  reason: collision with root package name */
    public final i f57617l;

    public SerialDescriptorImpl(String str, h hVar, int i11, List<? extends f> list, a aVar) {
        this.f57606a = str;
        this.f57607b = hVar;
        this.f57608c = i11;
        this.f57609d = aVar.c();
        this.f57610e = CollectionsKt___CollectionsKt.G0(aVar.f());
        String[] strArr = (String[]) aVar.f().toArray(new String[0]);
        this.f57611f = strArr;
        this.f57612g = g1.b(aVar.e());
        this.f57613h = (List[]) aVar.d().toArray(new List[0]);
        this.f57614i = CollectionsKt___CollectionsKt.D0(aVar.g());
        Iterable<kotlin.collections.m> H0 = ArraysKt___ArraysKt.H0(strArr);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(H0, 10));
        for (kotlin.collections.m mVar : H0) {
            arrayList.add(l.a(mVar.d(), Integer.valueOf(mVar.c())));
        }
        this.f57615j = MapsKt__MapsKt.s(arrayList);
        this.f57616k = g1.b(list);
        this.f57617l = LazyKt__LazyJVMKt.a(new SerialDescriptorImpl$_hashCode$2(this));
    }

    public Set<String> a() {
        return this.f57610e;
    }

    public boolean b() {
        return f.a.c(this);
    }

    public int c(String str) {
        Integer num = this.f57615j.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public f d(int i11) {
        return this.f57612g[i11];
    }

    public int e() {
        return this.f57608c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SerialDescriptorImpl) {
            f fVar = (f) obj;
            if (x.b(h(), fVar.h()) && Arrays.equals(this.f57616k, ((SerialDescriptorImpl) obj).f57616k) && e() == fVar.e()) {
                int e11 = e();
                int i11 = 0;
                while (i11 < e11) {
                    if (x.b(d(i11).h(), fVar.d(i11).h()) && x.b(d(i11).getKind(), fVar.d(i11).getKind())) {
                        i11++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public String f(int i11) {
        return this.f57611f[i11];
    }

    public List<Annotation> g(int i11) {
        return this.f57613h[i11];
    }

    public List<Annotation> getAnnotations() {
        return this.f57609d;
    }

    public h getKind() {
        return this.f57607b;
    }

    public String h() {
        return this.f57606a;
    }

    public int hashCode() {
        return k();
    }

    public boolean i(int i11) {
        return this.f57614i[i11];
    }

    public boolean isInline() {
        return f.a.b(this);
    }

    public final int k() {
        return ((Number) this.f57617l.getValue()).intValue();
    }

    public String toString() {
        h o11 = RangesKt___RangesKt.o(0, e());
        return CollectionsKt___CollectionsKt.k0(o11, ", ", h() + '(', ")", 0, (CharSequence) null, new SerialDescriptorImpl$toString$1(this), 24, (Object) null);
    }
}
