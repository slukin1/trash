package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.LazyThreadSafetyMode;
import kotlin.i;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.descriptors.i;

public class PluginGeneratedSerialDescriptor implements f, m {

    /* renamed from: a  reason: collision with root package name */
    public final String f57669a;

    /* renamed from: b  reason: collision with root package name */
    public final d0<?> f57670b;

    /* renamed from: c  reason: collision with root package name */
    public final int f57671c;

    /* renamed from: d  reason: collision with root package name */
    public int f57672d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f57673e;

    /* renamed from: f  reason: collision with root package name */
    public final List<Annotation>[] f57674f;

    /* renamed from: g  reason: collision with root package name */
    public List<Annotation> f57675g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean[] f57676h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, Integer> f57677i;

    /* renamed from: j  reason: collision with root package name */
    public final i f57678j;

    /* renamed from: k  reason: collision with root package name */
    public final i f57679k;

    /* renamed from: l  reason: collision with root package name */
    public final i f57680l;

    public PluginGeneratedSerialDescriptor(String str, d0<?> d0Var, int i11) {
        this.f57669a = str;
        this.f57670b = d0Var;
        this.f57671c = i11;
        this.f57672d = -1;
        String[] strArr = new String[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            strArr[i12] = "[UNINITIALIZED]";
        }
        this.f57673e = strArr;
        int i13 = this.f57671c;
        this.f57674f = new List[i13];
        this.f57676h = new boolean[i13];
        this.f57677i = MapsKt__MapsKt.h();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.f57678j = LazyKt__LazyJVMKt.b(lazyThreadSafetyMode, new PluginGeneratedSerialDescriptor$childSerializers$2(this));
        this.f57679k = LazyKt__LazyJVMKt.b(lazyThreadSafetyMode, new PluginGeneratedSerialDescriptor$typeParameterDescriptors$2(this));
        this.f57680l = LazyKt__LazyJVMKt.b(lazyThreadSafetyMode, new PluginGeneratedSerialDescriptor$_hashCode$2(this));
    }

    public static /* synthetic */ void l(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, String str, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            pluginGeneratedSerialDescriptor.k(str, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
    }

    public Set<String> a() {
        return this.f57677i.keySet();
    }

    public boolean b() {
        return f.a.c(this);
    }

    public int c(String str) {
        Integer num = this.f57677i.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public f d(int i11) {
        return n()[i11].getDescriptor();
    }

    public final int e() {
        return this.f57671c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PluginGeneratedSerialDescriptor) {
            f fVar = (f) obj;
            if (x.b(h(), fVar.h()) && Arrays.equals(o(), ((PluginGeneratedSerialDescriptor) obj).o()) && e() == fVar.e()) {
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
        return this.f57673e[i11];
    }

    public List<Annotation> g(int i11) {
        List<Annotation> list = this.f57674f[i11];
        return list == null ? CollectionsKt__CollectionsKt.k() : list;
    }

    public List<Annotation> getAnnotations() {
        List<Annotation> list = this.f57675g;
        return list == null ? CollectionsKt__CollectionsKt.k() : list;
    }

    public h getKind() {
        return i.a.f57647a;
    }

    public String h() {
        return this.f57669a;
    }

    public int hashCode() {
        return p();
    }

    public boolean i(int i11) {
        return this.f57676h[i11];
    }

    public boolean isInline() {
        return f.a.b(this);
    }

    public final void k(String str, boolean z11) {
        String[] strArr = this.f57673e;
        int i11 = this.f57672d + 1;
        this.f57672d = i11;
        strArr[i11] = str;
        this.f57676h[i11] = z11;
        this.f57674f[i11] = null;
        if (i11 == this.f57671c - 1) {
            this.f57677i = m();
        }
    }

    public final Map<String, Integer> m() {
        HashMap hashMap = new HashMap();
        int length = this.f57673e.length;
        for (int i11 = 0; i11 < length; i11++) {
            hashMap.put(this.f57673e[i11], Integer.valueOf(i11));
        }
        return hashMap;
    }

    public final b<?>[] n() {
        return (b[]) this.f57678j.getValue();
    }

    public final f[] o() {
        return (f[]) this.f57679k.getValue();
    }

    public final int p() {
        return ((Number) this.f57680l.getValue()).intValue();
    }

    public String toString() {
        kotlin.ranges.h o11 = RangesKt___RangesKt.o(0, this.f57671c);
        return CollectionsKt___CollectionsKt.k0(o11, ", ", h() + '(', ")", 0, (CharSequence) null, new PluginGeneratedSerialDescriptor$toString$1(this), 24, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PluginGeneratedSerialDescriptor(String str, d0 d0Var, int i11, int i12, r rVar) {
        this(str, (i12 & 2) != 0 ? null : d0Var, i11);
    }
}
