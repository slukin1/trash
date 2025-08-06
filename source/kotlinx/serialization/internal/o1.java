package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.r;
import kotlin.reflect.c;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;

public final class o1<ElementKlass, Element extends ElementKlass> extends r<Element, Element[], ArrayList<Element>> {

    /* renamed from: b  reason: collision with root package name */
    public final c<ElementKlass> f57751b;

    /* renamed from: c  reason: collision with root package name */
    public final f f57752c;

    public o1(c<ElementKlass> cVar, b<Element> bVar) {
        super(bVar, (r) null);
        this.f57751b = cVar;
        this.f57752c = new c(bVar.getDescriptor());
    }

    public f getDescriptor() {
        return this.f57752c;
    }

    /* renamed from: o */
    public ArrayList<Element> a() {
        return new ArrayList<>();
    }

    /* renamed from: p */
    public int b(ArrayList<Element> arrayList) {
        return arrayList.size();
    }

    /* renamed from: q */
    public void c(ArrayList<Element> arrayList, int i11) {
        arrayList.ensureCapacity(i11);
    }

    /* renamed from: r */
    public Iterator<Element> d(Element[] elementArr) {
        return h.a(elementArr);
    }

    /* renamed from: s */
    public int e(Element[] elementArr) {
        return elementArr.length;
    }

    /* renamed from: t */
    public void n(ArrayList<Element> arrayList, int i11, Element element) {
        arrayList.add(i11, element);
    }

    /* renamed from: u */
    public ArrayList<Element> k(Element[] elementArr) {
        return new ArrayList<>(ArraysKt___ArraysJvmKt.d(elementArr));
    }

    /* renamed from: v */
    public Element[] l(ArrayList<Element> arrayList) {
        return f1.n(arrayList, this.f57751b);
    }
}
