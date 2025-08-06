package com.zendesk.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import mz.a;

public class CountedSet<E> implements Set<E> {

    /* renamed from: b  reason: collision with root package name */
    public Map<E, Integer> f52768b = new LinkedHashMap();

    public boolean add(E e11) {
        if (e11 == null) {
            return false;
        }
        if (this.f52768b.containsKey(e11)) {
            this.f52768b.put(e11, Integer.valueOf(this.f52768b.get(e11).intValue() + 1));
        } else {
            this.f52768b.put(e11, 1);
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        if (!a.i(collection)) {
            return false;
        }
        for (Object add : collection) {
            if (!add(add)) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        this.f52768b.clear();
    }

    public boolean contains(Object obj) {
        return this.f52768b.containsKey(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        if (!a.i(collection)) {
            return false;
        }
        for (Object containsKey : collection) {
            if (!this.f52768b.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f52768b.isEmpty();
    }

    public Iterator<E> iterator() {
        return this.f52768b.keySet().iterator();
    }

    public boolean remove(Object obj) {
        if (!this.f52768b.containsKey(obj)) {
            return false;
        }
        int intValue = this.f52768b.get(obj).intValue();
        if (intValue > 1) {
            this.f52768b.put(obj, Integer.valueOf(intValue - 1));
        } else {
            this.f52768b.remove(obj);
        }
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        if (!a.i(collection)) {
            return false;
        }
        for (Object containsKey : collection) {
            if (!this.f52768b.containsKey(containsKey)) {
                return false;
            }
        }
        for (Object remove : collection) {
            this.f52768b.remove(remove);
        }
        return true;
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f52768b.size();
    }

    public Object[] toArray() {
        return this.f52768b.keySet().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f52768b.keySet().toArray(tArr);
    }
}
