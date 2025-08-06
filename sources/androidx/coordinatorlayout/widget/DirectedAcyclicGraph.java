package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.e;
import androidx.core.util.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class DirectedAcyclicGraph<T> {

    /* renamed from: a  reason: collision with root package name */
    public final e<ArrayList<T>> f8133a = new f(10);

    /* renamed from: b  reason: collision with root package name */
    public final SimpleArrayMap<T, ArrayList<T>> f8134b = new SimpleArrayMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<T> f8135c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public final HashSet<T> f8136d = new HashSet<>();

    public void a(T t11, T t12) {
        if (!this.f8134b.containsKey(t11) || !this.f8134b.containsKey(t12)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.f8134b.get(t11);
        if (arrayList == null) {
            arrayList = f();
            this.f8134b.put(t11, arrayList);
        }
        arrayList.add(t12);
    }

    public void b(T t11) {
        if (!this.f8134b.containsKey(t11)) {
            this.f8134b.put(t11, null);
        }
    }

    public void c() {
        int size = this.f8134b.size();
        for (int i11 = 0; i11 < size; i11++) {
            ArrayList p11 = this.f8134b.p(i11);
            if (p11 != null) {
                k(p11);
            }
        }
        this.f8134b.clear();
    }

    public boolean d(T t11) {
        return this.f8134b.containsKey(t11);
    }

    public final void e(T t11, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t11)) {
            if (!hashSet.contains(t11)) {
                hashSet.add(t11);
                ArrayList arrayList2 = this.f8134b.get(t11);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        e(arrayList2.get(i11), arrayList, hashSet);
                    }
                }
                hashSet.remove(t11);
                arrayList.add(t11);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    public final ArrayList<T> f() {
        ArrayList<T> acquire = this.f8133a.acquire();
        return acquire == null ? new ArrayList<>() : acquire;
    }

    public List g(T t11) {
        return this.f8134b.get(t11);
    }

    public List<T> h(T t11) {
        int size = this.f8134b.size();
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < size; i11++) {
            ArrayList p11 = this.f8134b.p(i11);
            if (p11 != null && p11.contains(t11)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f8134b.l(i11));
            }
        }
        return arrayList;
    }

    public ArrayList<T> i() {
        this.f8135c.clear();
        this.f8136d.clear();
        int size = this.f8134b.size();
        for (int i11 = 0; i11 < size; i11++) {
            e(this.f8134b.l(i11), this.f8135c, this.f8136d);
        }
        return this.f8135c;
    }

    public boolean j(T t11) {
        int size = this.f8134b.size();
        for (int i11 = 0; i11 < size; i11++) {
            ArrayList p11 = this.f8134b.p(i11);
            if (p11 != null && p11.contains(t11)) {
                return true;
            }
        }
        return false;
    }

    public final void k(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f8133a.release(arrayList);
    }
}
