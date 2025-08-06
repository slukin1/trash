package androidx.datastore.preferences.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList extends a<String> implements w, RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    public static final LazyStringArrayList f9020d;

    /* renamed from: e  reason: collision with root package name */
    public static final w f9021e;

    /* renamed from: c  reason: collision with root package name */
    public final List<Object> f9022c;

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
        f9020d = lazyStringArrayList;
        lazyStringArrayList.makeImmutable();
        f9021e = lazyStringArrayList;
    }

    public LazyStringArrayList() {
        this(10);
    }

    public static String c(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).toStringUtf8();
        }
        return u.j((byte[]) obj);
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    /* renamed from: b */
    public void add(int i11, String str) {
        a();
        this.f9022c.add(i11, str);
        this.modCount++;
    }

    public void clear() {
        a();
        this.f9022c.clear();
        this.modCount++;
    }

    /* renamed from: d */
    public LazyStringArrayList mutableCopyWithCapacity(int i11) {
        if (i11 >= size()) {
            ArrayList arrayList = new ArrayList(i11);
            arrayList.addAll(this.f9022c);
            return new LazyStringArrayList((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: e */
    public String remove(int i11) {
        a();
        Object remove = this.f9022c.remove(i11);
        this.modCount++;
        return c(remove);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f(ByteString byteString) {
        a();
        this.f9022c.add(byteString);
        this.modCount++;
    }

    /* renamed from: g */
    public String set(int i11, String str) {
        a();
        return c(this.f9022c.set(i11, str));
    }

    public Object getRaw(int i11) {
        return this.f9022c.get(i11);
    }

    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.f9022c);
    }

    public w getUnmodifiableView() {
        return isModifiable() ? new b1(this) : this;
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public int size() {
        return this.f9022c.size();
    }

    public LazyStringArrayList(int i11) {
        this((ArrayList<Object>) new ArrayList(i11));
    }

    public boolean addAll(int i11, Collection<? extends String> collection) {
        a();
        if (collection instanceof w) {
            collection = ((w) collection).getUnderlyingElements();
        }
        boolean addAll = this.f9022c.addAll(i11, collection);
        this.modCount++;
        return addAll;
    }

    public String get(int i11) {
        Object obj = this.f9022c.get(i11);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.f9022c.set(i11, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String j11 = u.j(bArr);
        if (u.g(bArr)) {
            this.f9022c.set(i11, j11);
        }
        return j11;
    }

    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public LazyStringArrayList(ArrayList<Object> arrayList) {
        this.f9022c = arrayList;
    }
}
