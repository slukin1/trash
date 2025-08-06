package com.squareup.wire;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public abstract class ProtoAdapter<E> {

    /* renamed from: d  reason: collision with root package name */
    public static final ProtoAdapter<Boolean> f30172d;

    /* renamed from: e  reason: collision with root package name */
    public static final ProtoAdapter<Integer> f30173e;

    /* renamed from: f  reason: collision with root package name */
    public static final ProtoAdapter<Integer> f30174f;

    /* renamed from: g  reason: collision with root package name */
    public static final ProtoAdapter<Integer> f30175g;

    /* renamed from: h  reason: collision with root package name */
    public static final ProtoAdapter<Integer> f30176h;

    /* renamed from: i  reason: collision with root package name */
    public static final ProtoAdapter<Integer> f30177i;

    /* renamed from: j  reason: collision with root package name */
    public static final ProtoAdapter<Long> f30178j;

    /* renamed from: k  reason: collision with root package name */
    public static final ProtoAdapter<Long> f30179k;

    /* renamed from: l  reason: collision with root package name */
    public static final ProtoAdapter<Long> f30180l;

    /* renamed from: m  reason: collision with root package name */
    public static final ProtoAdapter<Long> f30181m;

    /* renamed from: n  reason: collision with root package name */
    public static final ProtoAdapter<Long> f30182n;

    /* renamed from: o  reason: collision with root package name */
    public static final ProtoAdapter<Float> f30183o;

    /* renamed from: p  reason: collision with root package name */
    public static final ProtoAdapter<Double> f30184p;

    /* renamed from: q  reason: collision with root package name */
    public static final ProtoAdapter<String> f30185q;

    /* renamed from: r  reason: collision with root package name */
    public static final ProtoAdapter<ByteString> f30186r;

    /* renamed from: a  reason: collision with root package name */
    public final FieldEncoding f30187a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<?> f30188b;

    /* renamed from: c  reason: collision with root package name */
    public ProtoAdapter<List<E>> f30189c;

    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        public EnumConstantNotFoundException(int i11, Class<?> cls) {
            super("Unknown enum tag " + i11 + " for " + cls.getCanonicalName());
            this.value = i11;
        }
    }

    public class a extends ProtoAdapter<Float> {
        public a(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* renamed from: r */
        public Float c(c cVar) throws IOException {
            return Float.valueOf(Float.intBitsToFloat(cVar.i()));
        }

        /* renamed from: s */
        public void g(d dVar, Float f11) throws IOException {
            dVar.l(Float.floatToIntBits(f11.floatValue()));
        }

        /* renamed from: t */
        public int l(Float f11) {
            return 4;
        }
    }

    public class b extends ProtoAdapter<Double> {
        public b(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* renamed from: r */
        public Double c(c cVar) throws IOException {
            return Double.valueOf(Double.longBitsToDouble(cVar.j()));
        }

        /* renamed from: s */
        public void g(d dVar, Double d11) throws IOException {
            dVar.m(Double.doubleToLongBits(d11.doubleValue()));
        }

        /* renamed from: t */
        public int l(Double d11) {
            return 8;
        }
    }

    public class c extends ProtoAdapter<String> {
        public c(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* renamed from: r */
        public String c(c cVar) throws IOException {
            return cVar.k();
        }

        /* renamed from: s */
        public void g(d dVar, String str) throws IOException {
            dVar.o(str);
        }

        /* renamed from: t */
        public int l(String str) {
            return d.h(str);
        }
    }

    public class d extends ProtoAdapter<ByteString> {
        public d(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* renamed from: r */
        public ByteString c(c cVar) throws IOException {
            return cVar.h();
        }

        /* renamed from: s */
        public void g(d dVar, ByteString byteString) throws IOException {
            dVar.k(byteString);
        }

        /* renamed from: t */
        public int l(ByteString byteString) {
            return byteString.size();
        }
    }

    public class e extends ProtoAdapter<List<E>> {
        public e(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* renamed from: r */
        public List<E> c(c cVar) throws IOException {
            return Collections.singletonList(ProtoAdapter.this.c(cVar));
        }

        /* renamed from: s */
        public void g(d dVar, List<E> list) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        /* renamed from: t */
        public void k(d dVar, int i11, List<E> list) throws IOException {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                ProtoAdapter.this.k(dVar, i11, list.get(i12));
            }
        }

        /* renamed from: u */
        public int l(List<E> list) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        /* renamed from: v */
        public int m(int i11, List<E> list) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                i12 += ProtoAdapter.this.m(i11, list.get(i13));
            }
            return i12;
        }
    }

    public class f extends ProtoAdapter<Boolean> {
        public f(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* renamed from: r */
        public Boolean c(c cVar) throws IOException {
            int l11 = cVar.l();
            if (l11 == 0) {
                return Boolean.FALSE;
            }
            if (l11 == 1) {
                return Boolean.TRUE;
            }
            throw new IOException(String.format("Invalid boolean value 0x%02x", new Object[]{Integer.valueOf(l11)}));
        }

        /* renamed from: s */
        public void g(d dVar, Boolean bool) throws IOException {
            dVar.q(bool.booleanValue() ? 1 : 0);
        }

        /* renamed from: t */
        public int l(Boolean bool) {
            return 1;
        }
    }

    public class g extends ProtoAdapter<Integer> {
        public g(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* renamed from: r */
        public Integer c(c cVar) throws IOException {
            return Integer.valueOf(cVar.l());
        }

        /* renamed from: s */
        public void g(d dVar, Integer num) throws IOException {
            dVar.n(num.intValue());
        }

        /* renamed from: t */
        public int l(Integer num) {
            return d.e(num.intValue());
        }
    }

    public class h extends ProtoAdapter<Integer> {
        public h(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* renamed from: r */
        public Integer c(c cVar) throws IOException {
            return Integer.valueOf(cVar.l());
        }

        /* renamed from: s */
        public void g(d dVar, Integer num) throws IOException {
            dVar.q(num.intValue());
        }

        /* renamed from: t */
        public int l(Integer num) {
            return d.i(num.intValue());
        }
    }

    public class i extends ProtoAdapter<Integer> {
        public i(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* renamed from: r */
        public Integer c(c cVar) throws IOException {
            return Integer.valueOf(d.a(cVar.l()));
        }

        /* renamed from: s */
        public void g(d dVar, Integer num) throws IOException {
            dVar.q(d.c(num.intValue()));
        }

        /* renamed from: t */
        public int l(Integer num) {
            return d.i(d.c(num.intValue()));
        }
    }

    public class j extends ProtoAdapter<Integer> {
        public j(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* renamed from: r */
        public Integer c(c cVar) throws IOException {
            return Integer.valueOf(cVar.i());
        }

        /* renamed from: s */
        public void g(d dVar, Integer num) throws IOException {
            dVar.l(num.intValue());
        }

        /* renamed from: t */
        public int l(Integer num) {
            return 4;
        }
    }

    public class k extends ProtoAdapter<Long> {
        public k(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* renamed from: r */
        public Long c(c cVar) throws IOException {
            return Long.valueOf(cVar.m());
        }

        /* renamed from: s */
        public void g(d dVar, Long l11) throws IOException {
            dVar.r(l11.longValue());
        }

        /* renamed from: t */
        public int l(Long l11) {
            return d.j(l11.longValue());
        }
    }

    public class l extends ProtoAdapter<Long> {
        public l(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* renamed from: r */
        public Long c(c cVar) throws IOException {
            return Long.valueOf(cVar.m());
        }

        /* renamed from: s */
        public void g(d dVar, Long l11) throws IOException {
            dVar.r(l11.longValue());
        }

        /* renamed from: t */
        public int l(Long l11) {
            return d.j(l11.longValue());
        }
    }

    public class m extends ProtoAdapter<Long> {
        public m(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* renamed from: r */
        public Long c(c cVar) throws IOException {
            return Long.valueOf(d.b(cVar.m()));
        }

        /* renamed from: s */
        public void g(d dVar, Long l11) throws IOException {
            dVar.r(d.d(l11.longValue()));
        }

        /* renamed from: t */
        public int l(Long l11) {
            return d.j(d.d(l11.longValue()));
        }
    }

    public class n extends ProtoAdapter<Long> {
        public n(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
        }

        /* renamed from: r */
        public Long c(c cVar) throws IOException {
            return Long.valueOf(cVar.j());
        }

        /* renamed from: s */
        public void g(d dVar, Long l11) throws IOException {
            dVar.m(l11.longValue());
        }

        /* renamed from: t */
        public int l(Long l11) {
            return 8;
        }
    }

    public static final class o<K, V> extends ProtoAdapter<Map.Entry<K, V>> {

        /* renamed from: s  reason: collision with root package name */
        public final ProtoAdapter<K> f30191s;

        /* renamed from: t  reason: collision with root package name */
        public final ProtoAdapter<V> f30192t;

        public o(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) null);
            this.f30191s = protoAdapter;
            this.f30192t = protoAdapter2;
        }

        /* renamed from: r */
        public Map.Entry<K, V> c(c cVar) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: s */
        public void g(d dVar, Map.Entry<K, V> entry) throws IOException {
            this.f30191s.k(dVar, 1, entry.getKey());
            this.f30192t.k(dVar, 2, entry.getValue());
        }

        /* renamed from: t */
        public int l(Map.Entry<K, V> entry) {
            return this.f30191s.m(1, entry.getKey()) + this.f30192t.m(2, entry.getValue());
        }
    }

    public static final class p<K, V> extends ProtoAdapter<Map<K, V>> {

        /* renamed from: s  reason: collision with root package name */
        public final o<K, V> f30193s;

        public p(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) null);
            this.f30193s = new o<>(protoAdapter, protoAdapter2);
        }

        /* renamed from: r */
        public Map<K, V> c(c cVar) throws IOException {
            long c11 = cVar.c();
            K k11 = null;
            V v11 = null;
            while (true) {
                int f11 = cVar.f();
                if (f11 == -1) {
                    break;
                } else if (f11 == 1) {
                    k11 = this.f30193s.f30191s.c(cVar);
                } else if (f11 == 2) {
                    v11 = this.f30193s.f30192t.c(cVar);
                }
            }
            cVar.d(c11);
            if (k11 == null) {
                throw new IllegalStateException("Map entry with null key");
            } else if (v11 != null) {
                return Collections.singletonMap(k11, v11);
            } else {
                throw new IllegalStateException("Map entry with null value");
            }
        }

        /* renamed from: s */
        public void g(d dVar, Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        /* renamed from: t */
        public void k(d dVar, int i11, Map<K, V> map) throws IOException {
            for (Map.Entry<K, V> k11 : map.entrySet()) {
                this.f30193s.k(dVar, i11, k11);
            }
        }

        /* renamed from: u */
        public int l(Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        /* renamed from: v */
        public int m(int i11, Map<K, V> map) {
            int i12 = 0;
            for (Map.Entry<K, V> m11 : map.entrySet()) {
                i12 += this.f30193s.m(i11, m11);
            }
            return i12;
        }
    }

    static {
        Class<Long> cls = Long.class;
        Class<Integer> cls2 = Integer.class;
        FieldEncoding fieldEncoding = FieldEncoding.VARINT;
        f30172d = new f(fieldEncoding, Boolean.class);
        f30173e = new g(fieldEncoding, cls2);
        f30174f = new h(fieldEncoding, cls2);
        f30175g = new i(fieldEncoding, cls2);
        FieldEncoding fieldEncoding2 = FieldEncoding.FIXED32;
        j jVar = new j(fieldEncoding2, cls2);
        f30176h = jVar;
        f30177i = jVar;
        f30178j = new k(fieldEncoding, cls);
        f30179k = new l(fieldEncoding, cls);
        f30180l = new m(fieldEncoding, cls);
        FieldEncoding fieldEncoding3 = FieldEncoding.FIXED64;
        n nVar = new n(fieldEncoding3, cls);
        f30181m = nVar;
        f30182n = nVar;
        f30183o = new a(fieldEncoding2, Float.class);
        f30184p = new b(fieldEncoding3, Double.class);
        FieldEncoding fieldEncoding4 = FieldEncoding.LENGTH_DELIMITED;
        f30185q = new c(fieldEncoding4, String.class);
        f30186r = new d(fieldEncoding4, ByteString.class);
    }

    public ProtoAdapter(FieldEncoding fieldEncoding, Class<?> cls) {
        this.f30187a = fieldEncoding;
        this.f30188b = cls;
    }

    public static <M> ProtoAdapter<M> n(Class<M> cls) {
        try {
            return (ProtoAdapter) cls.getField("ADAPTER").get((Object) null);
        } catch (IllegalAccessException | NoSuchFieldException e11) {
            throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", e11);
        }
    }

    public static <E extends f> e<E> o(Class<E> cls) {
        return new e<>(cls);
    }

    public static <K, V> ProtoAdapter<Map<K, V>> p(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        return new p(protoAdapter, protoAdapter2);
    }

    public final ProtoAdapter<List<E>> a() {
        ProtoAdapter<List<E>> protoAdapter = this.f30189c;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<List<E>> b11 = b();
        this.f30189c = b11;
        return b11;
    }

    public final ProtoAdapter<List<E>> b() {
        return new e(this.f30187a, List.class);
    }

    public abstract E c(c cVar) throws IOException;

    public final E d(InputStream inputStream) throws IOException {
        b.a(inputStream, "stream == null");
        return e(Okio.buffer(Okio.source(inputStream)));
    }

    public final E e(BufferedSource bufferedSource) throws IOException {
        b.a(bufferedSource, "source == null");
        return c(new c(bufferedSource));
    }

    public final E f(byte[] bArr) throws IOException {
        b.a(bArr, "bytes == null");
        return e(new Buffer().write(bArr));
    }

    public abstract void g(d dVar, E e11) throws IOException;

    public final void h(OutputStream outputStream, E e11) throws IOException {
        b.a(e11, "value == null");
        b.a(outputStream, "stream == null");
        BufferedSink buffer = Okio.buffer(Okio.sink(outputStream));
        i(buffer, e11);
        buffer.emit();
    }

    public final void i(BufferedSink bufferedSink, E e11) throws IOException {
        b.a(e11, "value == null");
        b.a(bufferedSink, "sink == null");
        g(new d(bufferedSink), e11);
    }

    public final byte[] j(E e11) {
        b.a(e11, "value == null");
        Buffer buffer = new Buffer();
        try {
            i(buffer, e11);
            return buffer.readByteArray();
        } catch (IOException e12) {
            throw new AssertionError(e12);
        }
    }

    public void k(d dVar, int i11, E e11) throws IOException {
        if (e11 != null) {
            dVar.p(i11, this.f30187a);
            if (this.f30187a == FieldEncoding.LENGTH_DELIMITED) {
                dVar.q(l(e11));
            }
            g(dVar, e11);
        }
    }

    public abstract int l(E e11);

    public int m(int i11, E e11) {
        if (e11 == null) {
            return 0;
        }
        int l11 = l(e11);
        if (this.f30187a == FieldEncoding.LENGTH_DELIMITED) {
            l11 += d.i(l11);
        }
        return l11 + d.g(i11);
    }

    public String q(E e11) {
        return e11.toString();
    }
}
