package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class a<E> extends AbstractCollection<E> implements List<E> {
    public static final C0662a Companion = new C0662a((r) null);

    /* renamed from: kotlin.collections.a$a  reason: collision with other inner class name */
    public static final class C0662a {
        public C0662a() {
        }

        public /* synthetic */ C0662a(r rVar) {
            this();
        }

        public final void a(int i11, int i12, int i13) {
            if (i11 < 0 || i12 > i13) {
                throw new IndexOutOfBoundsException("startIndex: " + i11 + ", endIndex: " + i12 + ", size: " + i13);
            } else if (i11 > i12) {
                throw new IllegalArgumentException("startIndex: " + i11 + " > endIndex: " + i12);
            }
        }

        public final void b(int i11, int i12) {
            if (i11 < 0 || i11 >= i12) {
                throw new IndexOutOfBoundsException("index: " + i11 + ", size: " + i12);
            }
        }

        public final void c(int i11, int i12) {
            if (i11 < 0 || i11 > i12) {
                throw new IndexOutOfBoundsException("index: " + i11 + ", size: " + i12);
            }
        }

        public final void d(int i11, int i12, int i13) {
            if (i11 < 0 || i12 > i13) {
                throw new IndexOutOfBoundsException("fromIndex: " + i11 + ", toIndex: " + i12 + ", size: " + i13);
            } else if (i11 > i12) {
                throw new IllegalArgumentException("fromIndex: " + i11 + " > toIndex: " + i12);
            }
        }

        public final boolean e(Collection<?> collection, Collection<?> collection2) {
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it2 = collection2.iterator();
            for (Object b11 : collection) {
                if (!x.b(b11, it2.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int f(Collection<?> collection) {
            Iterator<?> it2 = collection.iterator();
            int i11 = 1;
            while (it2.hasNext()) {
                Object next = it2.next();
                i11 = (i11 * 31) + (next != null ? next.hashCode() : 0);
            }
            return i11;
        }
    }

    public class b implements Iterator<E>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public int f56634b;

        public b() {
        }

        public final int a() {
            return this.f56634b;
        }

        public final void b(int i11) {
            this.f56634b = i11;
        }

        public boolean hasNext() {
            return this.f56634b < a.this.size();
        }

        public E next() {
            if (hasNext()) {
                a<E> aVar = a.this;
                int i11 = this.f56634b;
                this.f56634b = i11 + 1;
                return aVar.get(i11);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public class c extends a<E>.b implements ListIterator<E> {
        public c(int i11) {
            super();
            a.Companion.c(i11, a.this.size());
            b(i11);
        }

        public void add(E e11) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean hasPrevious() {
            return a() > 0;
        }

        public int nextIndex() {
            return a();
        }

        public E previous() {
            if (hasPrevious()) {
                a<E> aVar = a.this;
                b(a() - 1);
                return aVar.get(a());
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return a() - 1;
        }

        public void set(E e11) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class d<E> extends a<E> implements RandomAccess {

        /* renamed from: b  reason: collision with root package name */
        public final a<E> f56637b;

        /* renamed from: c  reason: collision with root package name */
        public final int f56638c;

        /* renamed from: d  reason: collision with root package name */
        public int f56639d;

        public d(a<? extends E> aVar, int i11, int i12) {
            this.f56637b = aVar;
            this.f56638c = i11;
            a.Companion.d(i11, i12, aVar.size());
            this.f56639d = i12 - i11;
        }

        public E get(int i11) {
            a.Companion.b(i11, this.f56639d);
            return this.f56637b.get(this.f56638c + i11);
        }

        public int getSize() {
            return this.f56639d;
        }
    }

    public void add(int i11, E e11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i11, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        return Companion.e(this, (Collection) obj);
    }

    public abstract E get(int i11);

    public abstract int getSize();

    public int hashCode() {
        return Companion.f(this);
    }

    public int indexOf(E e11) {
        int i11 = 0;
        for (Object b11 : this) {
            if (x.b(b11, e11)) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public Iterator<E> iterator() {
        return new b();
    }

    public int lastIndexOf(E e11) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (x.b(listIterator.previous(), e11)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public ListIterator<E> listIterator() {
        return new c(0);
    }

    public E remove(int i11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public E set(int i11, E e11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<E> subList(int i11, int i12) {
        return new d(this, i11, i12);
    }

    public ListIterator<E> listIterator(int i11) {
        return new c(i11);
    }
}
