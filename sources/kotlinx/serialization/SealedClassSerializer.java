package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.l;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.c;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

public final class SealedClassSerializer<T> extends AbstractPolymorphicSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    public final c<T> f57596a;

    /* renamed from: b  reason: collision with root package name */
    public List<? extends Annotation> f57597b;

    /* renamed from: c  reason: collision with root package name */
    public final i f57598c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<c<? extends T>, b<? extends T>> f57599d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, b<? extends T>> f57600e;

    public static final class a implements l<Map.Entry<? extends c<? extends T>, ? extends b<? extends T>>, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Iterable f57601a;

        public a(Iterable iterable) {
            this.f57601a = iterable;
        }

        public String a(Map.Entry<? extends c<? extends T>, ? extends b<? extends T>> entry) {
            return ((b) entry.getValue()).getDescriptor().h();
        }

        public Iterator<Map.Entry<? extends c<? extends T>, ? extends b<? extends T>>> b() {
            return this.f57601a.iterator();
        }
    }

    public SealedClassSerializer(String str, c<T> cVar, c<? extends T>[] cVarArr, b<? extends T>[] bVarArr) {
        this.f57596a = cVar;
        this.f57597b = CollectionsKt__CollectionsKt.k();
        this.f57598c = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.PUBLICATION, new SealedClassSerializer$descriptor$2(str, this));
        if (cVarArr.length == bVarArr.length) {
            Map<c<? extends T>, b<? extends T>> s11 = MapsKt__MapsKt.s(ArraysKt___ArraysKt.I0(cVarArr, bVarArr));
            this.f57599d = s11;
            a aVar = new a(s11.entrySet());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator b11 = aVar.b();
            while (b11.hasNext()) {
                Object next = b11.next();
                Object a11 = aVar.a(next);
                Object obj = linkedHashMap.get(a11);
                if (obj == null) {
                    linkedHashMap.containsKey(a11);
                }
                Map.Entry entry = (Map.Entry) next;
                Map.Entry entry2 = (Map.Entry) obj;
                String str2 = (String) a11;
                if (entry2 == null) {
                    linkedHashMap.put(a11, entry);
                } else {
                    throw new IllegalStateException(("Multiple sealed subclasses of '" + e() + "' have the same serial name '" + str2 + "': '" + entry2.getKey() + "', '" + entry.getKey() + '\'').toString());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.d(linkedHashMap.size()));
            for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                linkedHashMap2.put(entry3.getKey(), (b) ((Map.Entry) entry3.getValue()).getValue());
            }
            this.f57600e = linkedHashMap2;
            return;
        }
        throw new IllegalArgumentException("All subclasses of sealed class " + e().f() + " should be marked @Serializable");
    }

    public a<T> c(kotlinx.serialization.encoding.a aVar, String str) {
        b bVar = this.f57600e.get(str);
        return bVar != null ? bVar : super.c(aVar, str);
    }

    public g<T> d(d dVar, T t11) {
        g<T> gVar = this.f57599d.get(Reflection.b(t11.getClass()));
        if (gVar == null) {
            gVar = super.d(dVar, t11);
        }
        if (gVar != null) {
            return gVar;
        }
        return null;
    }

    public c<T> e() {
        return this.f57596a;
    }

    public f getDescriptor() {
        return (f) this.f57598c.getValue();
    }

    public SealedClassSerializer(String str, c<T> cVar, c<? extends T>[] cVarArr, b<? extends T>[] bVarArr, Annotation[] annotationArr) {
        this(str, cVar, cVarArr, bVarArr);
        this.f57597b = ArraysKt___ArraysJvmKt.d(annotationArr);
    }
}
