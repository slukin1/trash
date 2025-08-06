package i0;

import androidx.collection.SparseArrayCompat;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\u001a\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0004"}, d2 = {"T", "Landroidx/collection/SparseArrayCompat;", "", "a", "collection-ktx"}, k = 2, mv = {1, 4, 0})
public final class d {

    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00018\u00008\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"i0/d$a", "", "", "hasNext", "kotlin.jvm.PlatformType", "next", "()Ljava/lang/Object;", "collection-ktx"}, k = 1, mv = {1, 4, 0})
    public static final class a implements Iterator<T>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public int f15957b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SparseArrayCompat f15958c;

        public a(SparseArrayCompat<T> sparseArrayCompat) {
            this.f15958c = sparseArrayCompat;
        }

        public boolean hasNext() {
            return this.f15957b < this.f15958c.p();
        }

        public T next() {
            SparseArrayCompat sparseArrayCompat = this.f15958c;
            int i11 = this.f15957b;
            this.f15957b = i11 + 1;
            return sparseArrayCompat.q(i11);
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final <T> Iterator<T> a(SparseArrayCompat<T> sparseArrayCompat) {
        return new a(sparseArrayCompat);
    }
}
