package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class b1 extends AbstractList<String> implements w, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public final w f9058b;

    public class a implements ListIterator<String> {

        /* renamed from: b  reason: collision with root package name */
        public ListIterator<String> f9059b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f9060c;

        public a(int i11) {
            this.f9060c = i11;
            this.f9059b = b1.this.f9058b.listIterator(i11);
        }

        /* renamed from: a */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: b */
        public String next() {
            return this.f9059b.next();
        }

        /* renamed from: c */
        public String previous() {
            return this.f9059b.previous();
        }

        /* renamed from: d */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.f9059b.hasNext();
        }

        public boolean hasPrevious() {
            return this.f9059b.hasPrevious();
        }

        public int nextIndex() {
            return this.f9059b.nextIndex();
        }

        public int previousIndex() {
            return this.f9059b.previousIndex();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class b implements Iterator<String> {

        /* renamed from: b  reason: collision with root package name */
        public Iterator<String> f9062b;

        public b() {
            this.f9062b = b1.this.f9058b.iterator();
        }

        /* renamed from: a */
        public String next() {
            return this.f9062b.next();
        }

        public boolean hasNext() {
            return this.f9062b.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public b1(w wVar) {
        this.f9058b = wVar;
    }

    public void f(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public Object getRaw(int i11) {
        return this.f9058b.getRaw(i11);
    }

    public List<?> getUnderlyingElements() {
        return this.f9058b.getUnderlyingElements();
    }

    public w getUnmodifiableView() {
        return this;
    }

    public Iterator<String> iterator() {
        return new b();
    }

    public ListIterator<String> listIterator(int i11) {
        return new a(i11);
    }

    public int size() {
        return this.f9058b.size();
    }

    public String get(int i11) {
        return (String) this.f9058b.get(i11);
    }
}
