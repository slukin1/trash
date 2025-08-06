package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class Table {

    /* renamed from: a  reason: collision with root package name */
    public int f9468a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f9469b;

    /* renamed from: c  reason: collision with root package name */
    public int f9470c;

    /* renamed from: d  reason: collision with root package name */
    public int f9471d;

    /* renamed from: e  reason: collision with root package name */
    public Utf8 f9472e = Utf8.a();

    public int a(int i11) {
        return i11 + this.f9469b.getInt(i11);
    }

    public int b(int i11) {
        if (i11 < this.f9471d) {
            return this.f9469b.getShort(this.f9470c + i11);
        }
        return 0;
    }

    public void c(int i11, ByteBuffer byteBuffer) {
        this.f9469b = byteBuffer;
        if (byteBuffer != null) {
            this.f9468a = i11;
            int i12 = i11 - byteBuffer.getInt(i11);
            this.f9470c = i12;
            this.f9471d = this.f9469b.getShort(i12);
            return;
        }
        this.f9468a = 0;
        this.f9470c = 0;
        this.f9471d = 0;
    }

    public int d(int i11) {
        int i12 = i11 + this.f9468a;
        return i12 + this.f9469b.getInt(i12) + 4;
    }

    public int e(int i11) {
        int i12 = i11 + this.f9468a;
        return this.f9469b.getInt(i12 + this.f9469b.getInt(i12));
    }
}
