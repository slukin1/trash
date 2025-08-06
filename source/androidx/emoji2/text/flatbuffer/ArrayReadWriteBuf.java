package androidx.emoji2.text.flatbuffer;

public class ArrayReadWriteBuf implements b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f9441a;

    /* renamed from: b  reason: collision with root package name */
    public int f9442b;

    public ArrayReadWriteBuf() {
        this(10);
    }

    public byte get(int i11) {
        return this.f9441a[i11];
    }

    public ArrayReadWriteBuf(int i11) {
        this(new byte[i11]);
    }

    public ArrayReadWriteBuf(byte[] bArr) {
        this.f9441a = bArr;
        this.f9442b = 0;
    }

    public ArrayReadWriteBuf(byte[] bArr, int i11) {
        this.f9441a = bArr;
        this.f9442b = i11;
    }
}
