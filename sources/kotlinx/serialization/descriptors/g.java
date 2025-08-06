package kotlinx.serialization.descriptors;

import java.util.Iterator;

public final class g {

    public static final class a implements Iterator<f>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public int f57639b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f57640c;

        public a(f fVar) {
            this.f57640c = fVar;
            this.f57639b = fVar.e();
        }

        /* renamed from: a */
        public f next() {
            f fVar = this.f57640c;
            int e11 = fVar.e();
            int i11 = this.f57639b;
            this.f57639b = i11 - 1;
            return fVar.d(e11 - i11);
        }

        public boolean hasNext() {
            return this.f57639b > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class b implements Iterator<String>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public int f57641b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f57642c;

        public b(f fVar) {
            this.f57642c = fVar;
            this.f57641b = fVar.e();
        }

        /* renamed from: a */
        public String next() {
            f fVar = this.f57642c;
            int e11 = fVar.e();
            int i11 = this.f57641b;
            this.f57641b = i11 - 1;
            return fVar.f(e11 - i11);
        }

        public boolean hasNext() {
            return this.f57641b > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class c implements Iterable<f>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f57643b;

        public c(f fVar) {
            this.f57643b = fVar;
        }

        public Iterator<f> iterator() {
            return new a(this.f57643b);
        }
    }

    public static final class d implements Iterable<String>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f57644b;

        public d(f fVar) {
            this.f57644b = fVar;
        }

        public Iterator<String> iterator() {
            return new b(this.f57644b);
        }
    }

    public static final Iterable<f> a(f fVar) {
        return new c(fVar);
    }

    public static final Iterable<String> b(f fVar) {
        return new d(fVar);
    }
}
