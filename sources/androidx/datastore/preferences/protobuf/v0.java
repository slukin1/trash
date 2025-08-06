package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.q;
import androidx.datastore.preferences.protobuf.u;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f9221a = B();

    /* renamed from: b  reason: collision with root package name */
    public static final y0<?, ?> f9222b = C(false);

    /* renamed from: c  reason: collision with root package name */
    public static final y0<?, ?> f9223c = C(true);

    /* renamed from: d  reason: collision with root package name */
    public static final y0<?, ?> f9224d = new a1();

    public static <UT, UB> UB A(int i11, List<Integer> list, u.e eVar, UB ub2, y0<UT, UB> y0Var) {
        if (eVar == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                int intValue = list.get(i13).intValue();
                if (eVar.isInRange(intValue)) {
                    if (i13 != i12) {
                        list.set(i12, Integer.valueOf(intValue));
                    }
                    i12++;
                } else {
                    ub2 = L(i11, intValue, ub2, y0Var);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
            }
        } else {
            Iterator<Integer> it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue2 = it2.next().intValue();
                if (!eVar.isInRange(intValue2)) {
                    ub2 = L(i11, intValue2, ub2, y0Var);
                    it2.remove();
                }
            }
        }
        return ub2;
    }

    public static Class<?> B() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static y0<?, ?> C(boolean z11) {
        try {
            Class<?> D = D();
            if (D == null) {
                return null;
            }
            return (y0) D.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z11)});
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> D() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T, FT extends q.b<FT>> void E(m<FT> mVar, T t11, T t12) {
        q<FT> c11 = mVar.c(t12);
        if (!c11.n()) {
            mVar.d(t11).u(c11);
        }
    }

    public static <T> void F(a0 a0Var, T t11, T t12, long j11) {
        c1.T(t11, j11, a0Var.mergeFrom(c1.E(t11, j11), c1.E(t12, j11)));
    }

    public static <T, UT, UB> void G(y0<UT, UB> y0Var, T t11, T t12) {
        y0Var.p(t11, y0Var.k(y0Var.g(t11), y0Var.g(t12)));
    }

    public static y0<?, ?> H() {
        return f9222b;
    }

    public static y0<?, ?> I() {
        return f9223c;
    }

    public static void J(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = f9221a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean K(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <UT, UB> UB L(int i11, int i12, UB ub2, y0<UT, UB> y0Var) {
        if (ub2 == null) {
            ub2 = y0Var.n();
        }
        y0Var.e(ub2, i11, (long) i12);
        return ub2;
    }

    public static y0<?, ?> M() {
        return f9224d;
    }

    public static void N(int i11, List<Boolean> list, Writer writer, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeBoolList(i11, list, z11);
        }
    }

    public static void O(int i11, List<ByteString> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeBytesList(i11, list);
        }
    }

    public static void P(int i11, List<Double> list, Writer writer, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeDoubleList(i11, list, z11);
        }
    }

    public static void Q(int i11, List<Integer> list, Writer writer, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeEnumList(i11, list, z11);
        }
    }

    public static void R(int i11, List<Integer> list, Writer writer, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed32List(i11, list, z11);
        }
    }

    public static void S(int i11, List<Long> list, Writer writer, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed64List(i11, list, z11);
        }
    }

    public static void T(int i11, List<Float> list, Writer writer, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFloatList(i11, list, z11);
        }
    }

    public static void U(int i11, List<?> list, Writer writer, t0 t0Var) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.d(i11, list, t0Var);
        }
    }

    public static void V(int i11, List<Integer> list, Writer writer, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeInt32List(i11, list, z11);
        }
    }

    public static void W(int i11, List<Long> list, Writer writer, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeInt64List(i11, list, z11);
        }
    }

    public static void X(int i11, List<?> list, Writer writer, t0 t0Var) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.f(i11, list, t0Var);
        }
    }

    public static void Y(int i11, List<Integer> list, Writer writer, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed32List(i11, list, z11);
        }
    }

    public static void Z(int i11, List<Long> list, Writer writer, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed64List(i11, list, z11);
        }
    }

    public static int a(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z11) {
            return CodedOutputStream.W(i11) + CodedOutputStream.D(size);
        }
        return size * CodedOutputStream.e(i11, true);
    }

    public static void a0(int i11, List<Integer> list, Writer writer, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt32List(i11, list, z11);
        }
    }

    public static int b(List<?> list) {
        return list.size();
    }

    public static void b0(int i11, List<Long> list, Writer writer, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt64List(i11, list, z11);
        }
    }

    public static int c(int i11, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int W = size * CodedOutputStream.W(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            W += CodedOutputStream.i(list.get(i12));
        }
        return W;
    }

    public static void c0(int i11, List<String> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeStringList(i11, list);
        }
    }

    public static int d(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e11 = e(list);
        if (z11) {
            return CodedOutputStream.W(i11) + CodedOutputStream.D(e11);
        }
        return e11 + (size * CodedOutputStream.W(i11));
    }

    public static void d0(int i11, List<Integer> list, Writer writer, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt32List(i11, list, z11);
        }
    }

    public static int e(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof t) {
            t tVar = (t) list;
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.m(tVar.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + CodedOutputStream.m(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static void e0(int i11, List<Long> list, Writer writer, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt64List(i11, list, z11);
        }
    }

    public static int f(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z11) {
            return CodedOutputStream.W(i11) + CodedOutputStream.D(size * 4);
        }
        return size * CodedOutputStream.n(i11, 0);
    }

    public static int g(List<?> list) {
        return list.size() * 4;
    }

    public static int h(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z11) {
            return CodedOutputStream.W(i11) + CodedOutputStream.D(size * 8);
        }
        return size * CodedOutputStream.p(i11, 0);
    }

    public static int i(List<?> list) {
        return list.size() * 8;
    }

    public static int j(int i11, List<f0> list, t0 t0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            i12 += CodedOutputStream.t(i11, list.get(i13), t0Var);
        }
        return i12;
    }

    public static int k(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l11 = l(list);
        if (z11) {
            return CodedOutputStream.W(i11) + CodedOutputStream.D(l11);
        }
        return l11 + (size * CodedOutputStream.W(i11));
    }

    public static int l(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof t) {
            t tVar = (t) list;
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.x(tVar.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + CodedOutputStream.x(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int m(int i11, List<Long> list, boolean z11) {
        if (list.size() == 0) {
            return 0;
        }
        int n11 = n(list);
        if (z11) {
            return CodedOutputStream.W(i11) + CodedOutputStream.D(n11);
        }
        return n11 + (list.size() * CodedOutputStream.W(i11));
    }

    public static int n(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof y) {
            y yVar = (y) list;
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.z(yVar.getLong(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + CodedOutputStream.z(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int o(int i11, Object obj, t0 t0Var) {
        if (obj instanceof LazyFieldLite) {
            return CodedOutputStream.B(i11, (LazyFieldLite) obj);
        }
        return CodedOutputStream.G(i11, (f0) obj, t0Var);
    }

    public static int p(int i11, List<?> list, t0 t0Var) {
        int i12;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int W = CodedOutputStream.W(i11) * size;
        for (int i13 = 0; i13 < size; i13++) {
            Object obj = list.get(i13);
            if (obj instanceof LazyFieldLite) {
                i12 = CodedOutputStream.C((LazyFieldLite) obj);
            } else {
                i12 = CodedOutputStream.I((f0) obj, t0Var);
            }
            W += i12;
        }
        return W;
    }

    public static int q(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r11 = r(list);
        if (z11) {
            return CodedOutputStream.W(i11) + CodedOutputStream.D(r11);
        }
        return r11 + (size * CodedOutputStream.W(i11));
    }

    public static int r(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof t) {
            t tVar = (t) list;
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.R(tVar.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + CodedOutputStream.R(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int s(int i11, List<Long> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int t11 = t(list);
        if (z11) {
            return CodedOutputStream.W(i11) + CodedOutputStream.D(t11);
        }
        return t11 + (size * CodedOutputStream.W(i11));
    }

    public static int t(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof y) {
            y yVar = (y) list;
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.T(yVar.getLong(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + CodedOutputStream.T(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int u(int i11, List<?> list) {
        int i12;
        int i13;
        int size = list.size();
        int i14 = 0;
        if (size == 0) {
            return 0;
        }
        int W = CodedOutputStream.W(i11) * size;
        if (list instanceof w) {
            w wVar = (w) list;
            while (i14 < size) {
                Object raw = wVar.getRaw(i14);
                if (raw instanceof ByteString) {
                    i13 = CodedOutputStream.i((ByteString) raw);
                } else {
                    i13 = CodedOutputStream.V((String) raw);
                }
                W += i13;
                i14++;
            }
        } else {
            while (i14 < size) {
                Object obj = list.get(i14);
                if (obj instanceof ByteString) {
                    i12 = CodedOutputStream.i((ByteString) obj);
                } else {
                    i12 = CodedOutputStream.V((String) obj);
                }
                W += i12;
                i14++;
            }
        }
        return W;
    }

    public static int v(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w11 = w(list);
        if (z11) {
            return CodedOutputStream.W(i11) + CodedOutputStream.D(w11);
        }
        return w11 + (size * CodedOutputStream.W(i11));
    }

    public static int w(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof t) {
            t tVar = (t) list;
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.Y(tVar.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + CodedOutputStream.Y(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int x(int i11, List<Long> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y11 = y(list);
        if (z11) {
            return CodedOutputStream.W(i11) + CodedOutputStream.D(y11);
        }
        return y11 + (size * CodedOutputStream.W(i11));
    }

    public static int y(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof y) {
            y yVar = (y) list;
            i11 = 0;
            while (i12 < size) {
                i11 += CodedOutputStream.a0(yVar.getLong(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + CodedOutputStream.a0(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static <UT, UB> UB z(int i11, List<Integer> list, u.d<?> dVar, UB ub2, y0<UT, UB> y0Var) {
        if (dVar == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                int intValue = list.get(i13).intValue();
                if (dVar.findValueByNumber(intValue) != null) {
                    if (i13 != i12) {
                        list.set(i12, Integer.valueOf(intValue));
                    }
                    i12++;
                } else {
                    ub2 = L(i11, intValue, ub2, y0Var);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
            }
        } else {
            Iterator<Integer> it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue2 = it2.next().intValue();
                if (dVar.findValueByNumber(intValue2) == null) {
                    ub2 = L(i11, intValue2, ub2, y0Var);
                    it2.remove();
                }
            }
        }
        return ub2;
    }
}
