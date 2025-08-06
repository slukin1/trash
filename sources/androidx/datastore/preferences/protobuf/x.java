package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import java.util.Collections;
import java.util.List;

public abstract class x {

    /* renamed from: a  reason: collision with root package name */
    public static final x f9246a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final x f9247b = new c();

    public static final class b extends x {

        /* renamed from: c  reason: collision with root package name */
        public static final Class<?> f9248c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        public b() {
            super();
        }

        public static <E> List<E> f(Object obj, long j11) {
            return (List) c1.E(obj, j11);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.datastore.preferences.protobuf.LazyStringArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: androidx.datastore.preferences.protobuf.LazyStringArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: androidx.datastore.preferences.protobuf.LazyStringArrayList} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static <L> java.util.List<L> g(java.lang.Object r3, long r4, int r6) {
            /*
                java.util.List r0 = f(r3, r4)
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L_0x002d
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.w
                if (r1 == 0) goto L_0x0014
                androidx.datastore.preferences.protobuf.LazyStringArrayList r0 = new androidx.datastore.preferences.protobuf.LazyStringArrayList
                r0.<init>((int) r6)
                goto L_0x0029
            L_0x0014:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.o0
                if (r1 == 0) goto L_0x0024
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.u.i
                if (r1 == 0) goto L_0x0024
                androidx.datastore.preferences.protobuf.u$i r0 = (androidx.datastore.preferences.protobuf.u.i) r0
                androidx.datastore.preferences.protobuf.u$i r6 = r0.mutableCopyWithCapacity(r6)
                r0 = r6
                goto L_0x0029
            L_0x0024:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>(r6)
            L_0x0029:
                androidx.datastore.preferences.protobuf.c1.T(r3, r4, r0)
                goto L_0x007f
            L_0x002d:
                java.lang.Class<?> r1 = f9248c
                java.lang.Class r2 = r0.getClass()
                boolean r1 = r1.isAssignableFrom(r2)
                if (r1 == 0) goto L_0x004b
                java.util.ArrayList r1 = new java.util.ArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>(r2)
                r1.addAll(r0)
                androidx.datastore.preferences.protobuf.c1.T(r3, r4, r1)
            L_0x0049:
                r0 = r1
                goto L_0x007f
            L_0x004b:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.b1
                if (r1 == 0) goto L_0x0062
                androidx.datastore.preferences.protobuf.LazyStringArrayList r1 = new androidx.datastore.preferences.protobuf.LazyStringArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>((int) r2)
                androidx.datastore.preferences.protobuf.b1 r0 = (androidx.datastore.preferences.protobuf.b1) r0
                r1.addAll(r0)
                androidx.datastore.preferences.protobuf.c1.T(r3, r4, r1)
                goto L_0x0049
            L_0x0062:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.o0
                if (r1 == 0) goto L_0x007f
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.u.i
                if (r1 == 0) goto L_0x007f
                r1 = r0
                androidx.datastore.preferences.protobuf.u$i r1 = (androidx.datastore.preferences.protobuf.u.i) r1
                boolean r2 = r1.isModifiable()
                if (r2 != 0) goto L_0x007f
                int r0 = r0.size()
                int r0 = r0 + r6
                androidx.datastore.preferences.protobuf.u$i r0 = r1.mutableCopyWithCapacity(r0)
                androidx.datastore.preferences.protobuf.c1.T(r3, r4, r0)
            L_0x007f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.x.b.g(java.lang.Object, long, int):java.util.List");
        }

        public void c(Object obj, long j11) {
            Object obj2;
            List list = (List) c1.E(obj, j11);
            if (list instanceof w) {
                obj2 = ((w) list).getUnmodifiableView();
            } else if (!f9248c.isAssignableFrom(list.getClass())) {
                if (!(list instanceof o0) || !(list instanceof u.i)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    u.i iVar = (u.i) list;
                    if (iVar.isModifiable()) {
                        iVar.makeImmutable();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            c1.T(obj, j11, obj2);
        }

        public <E> void d(Object obj, Object obj2, long j11) {
            List f11 = f(obj2, j11);
            List g11 = g(obj, j11, f11.size());
            int size = g11.size();
            int size2 = f11.size();
            if (size > 0 && size2 > 0) {
                g11.addAll(f11);
            }
            if (size > 0) {
                f11 = g11;
            }
            c1.T(obj, j11, f11);
        }

        public <L> List<L> e(Object obj, long j11) {
            return g(obj, j11, 10);
        }
    }

    public static final class c extends x {
        public c() {
            super();
        }

        public static <E> u.i<E> f(Object obj, long j11) {
            return (u.i) c1.E(obj, j11);
        }

        public void c(Object obj, long j11) {
            f(obj, j11).makeImmutable();
        }

        public <E> void d(Object obj, Object obj2, long j11) {
            u.i f11 = f(obj, j11);
            u.i f12 = f(obj2, j11);
            int size = f11.size();
            int size2 = f12.size();
            if (size > 0 && size2 > 0) {
                if (!f11.isModifiable()) {
                    f11 = f11.mutableCopyWithCapacity(size2 + size);
                }
                f11.addAll(f12);
            }
            if (size > 0) {
                f12 = f11;
            }
            c1.T(obj, j11, f12);
        }

        public <L> List<L> e(Object obj, long j11) {
            u.i f11 = f(obj, j11);
            if (f11.isModifiable()) {
                return f11;
            }
            int size = f11.size();
            u.i mutableCopyWithCapacity = f11.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            c1.T(obj, j11, mutableCopyWithCapacity);
            return mutableCopyWithCapacity;
        }
    }

    public static x a() {
        return f9246a;
    }

    public static x b() {
        return f9247b;
    }

    public abstract void c(Object obj, long j11);

    public abstract <L> void d(Object obj, Object obj2, long j11);

    public abstract <L> List<L> e(Object obj, long j11);

    public x() {
    }
}
