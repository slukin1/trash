package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public abstract class a<E> extends AbstractList<E> implements u.i<E> {

    /* renamed from: b  reason: collision with root package name */
    public boolean f9055b = true;

    public void a() {
        if (!this.f9055b) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean add(E e11) {
        a();
        return super.add(e11);
    }

    public boolean addAll(Collection<? extends E> collection) {
        a();
        return super.addAll(collection);
    }

    public void clear() {
        a();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i11 = 0; i11 < size; i11++) {
            if (!get(i11).equals(list.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i11 = 1;
        for (int i12 = 0; i12 < size; i12++) {
            i11 = (i11 * 31) + get(i12).hashCode();
        }
        return i11;
    }

    public boolean isModifiable() {
        return this.f9055b;
    }

    public final void makeImmutable() {
        this.f9055b = false;
    }

    public boolean remove(Object obj) {
        a();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        a();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        a();
        return super.retainAll(collection);
    }

    public boolean addAll(int i11, Collection<? extends E> collection) {
        a();
        return super.addAll(i11, collection);
    }
}
