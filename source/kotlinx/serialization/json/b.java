package kotlinx.serialization.json;

import com.xiaomi.mipush.sdk.Constants;
import d10.l;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.f;

@f(with = c.class)
public final class b extends g implements List<g>, e10.a {
    public static final a Companion = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final List<g> f57831b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<b> serializer() {
            return c.f57832a;
        }
    }

    public b(List<? extends g> list) {
        super((r) null);
        this.f57831b = list;
    }

    public boolean a(g gVar) {
        return this.f57831b.contains(gVar);
    }

    public /* bridge */ /* synthetic */ void add(int i11, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i11, Collection<? extends g> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends g> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: c */
    public g get(int i11) {
        return this.f57831b.get(i11);
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        return a((g) obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return this.f57831b.containsAll(collection);
    }

    public int d() {
        return this.f57831b.size();
    }

    public boolean equals(Object obj) {
        return x.b(this.f57831b, obj);
    }

    public int h(g gVar) {
        return this.f57831b.indexOf(gVar);
    }

    public int hashCode() {
        return this.f57831b.hashCode();
    }

    public int i(g gVar) {
        return this.f57831b.lastIndexOf(gVar);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof g)) {
            return -1;
        }
        return h((g) obj);
    }

    public boolean isEmpty() {
        return this.f57831b.isEmpty();
    }

    public Iterator<g> iterator() {
        return this.f57831b.iterator();
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof g)) {
            return -1;
        }
        return i((g) obj);
    }

    public ListIterator<g> listIterator() {
        return this.f57831b.listIterator();
    }

    public ListIterator<g> listIterator(int i11) {
        return this.f57831b.listIterator(i11);
    }

    public /* bridge */ /* synthetic */ Object remove(int i11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(UnaryOperator<g> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return d();
    }

    public void sort(Comparator<? super g> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<g> subList(int i11, int i12) {
        return this.f57831b.subList(i11, i12);
    }

    public Object[] toArray() {
        return q.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return q.b(this, tArr);
    }

    public String toString() {
        return CollectionsKt___CollectionsKt.k0(this.f57831b, Constants.ACCEPT_TIME_SEPARATOR_SP, "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
    }
}
