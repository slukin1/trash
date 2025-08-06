package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class FlatBufferBuilder {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f9443a;

    /* renamed from: b  reason: collision with root package name */
    public int f9444b;

    /* renamed from: c  reason: collision with root package name */
    public int f9445c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f9446d;

    /* renamed from: e  reason: collision with root package name */
    public int f9447e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9448f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9449g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f9450h;

    /* renamed from: i  reason: collision with root package name */
    public int f9451i;

    /* renamed from: j  reason: collision with root package name */
    public int f9452j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f9453k;

    /* renamed from: l  reason: collision with root package name */
    public ByteBufferFactory f9454l;

    /* renamed from: m  reason: collision with root package name */
    public final Utf8 f9455m;

    public static abstract class ByteBufferFactory {
        public abstract ByteBuffer a(int i11);
    }

    public static final class HeapByteBufferFactory extends ByteBufferFactory {

        /* renamed from: a  reason: collision with root package name */
        public static final HeapByteBufferFactory f9456a = new HeapByteBufferFactory();

        public ByteBuffer a(int i11) {
            return ByteBuffer.allocate(i11).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public FlatBufferBuilder(int i11, ByteBufferFactory byteBufferFactory, ByteBuffer byteBuffer, Utf8 utf8) {
        this.f9445c = 1;
        this.f9446d = null;
        this.f9447e = 0;
        this.f9448f = false;
        this.f9449g = false;
        this.f9450h = new int[16];
        this.f9451i = 0;
        this.f9452j = 0;
        this.f9453k = false;
        i11 = i11 <= 0 ? 1 : i11;
        this.f9454l = byteBufferFactory;
        if (byteBuffer != null) {
            this.f9443a = byteBuffer;
            byteBuffer.clear();
            this.f9443a.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f9443a = byteBufferFactory.a(i11);
        }
        this.f9455m = utf8;
        this.f9444b = this.f9443a.capacity();
    }

    public FlatBufferBuilder(int i11) {
        this(i11, HeapByteBufferFactory.f9456a, (ByteBuffer) null, Utf8.a());
    }

    public FlatBufferBuilder() {
        this(1024);
    }
}
