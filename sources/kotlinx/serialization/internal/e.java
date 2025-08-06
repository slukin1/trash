package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;

public final class e<E> extends s<E, List<? extends E>, ArrayList<E>> {

    /* renamed from: b  reason: collision with root package name */
    public final f f57709b;

    public e(b<E> bVar) {
        super(bVar);
        this.f57709b = new d(bVar.getDescriptor());
    }

    public f getDescriptor() {
        return this.f57709b;
    }

    /* renamed from: q */
    public ArrayList<E> a() {
        return new ArrayList<>();
    }

    /* renamed from: r */
    public int b(ArrayList<E> arrayList) {
        return arrayList.size();
    }

    /* renamed from: s */
    public void c(ArrayList<E> arrayList, int i11) {
        arrayList.ensureCapacity(i11);
    }

    /* renamed from: t */
    public void n(ArrayList<E> arrayList, int i11, E e11) {
        arrayList.add(i11, e11);
    }

    /* renamed from: u */
    public ArrayList<E> k(List<? extends E> list) {
        ArrayList<E> arrayList = list instanceof ArrayList ? (ArrayList) list : null;
        return arrayList == null ? new ArrayList<>(list) : arrayList;
    }

    /* renamed from: v */
    public List<E> l(ArrayList<E> arrayList) {
        return arrayList;
    }
}
