package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class MetadataItem extends Table {

    public static final class Vector extends BaseVector {
    }

    public MetadataItem f(int i11, ByteBuffer byteBuffer) {
        g(i11, byteBuffer);
        return this;
    }

    public void g(int i11, ByteBuffer byteBuffer) {
        c(i11, byteBuffer);
    }

    public int h(int i11) {
        int b11 = b(16);
        if (b11 != 0) {
            return this.f9469b.getInt(d(b11) + (i11 * 4));
        }
        return 0;
    }

    public int i() {
        int b11 = b(16);
        if (b11 != 0) {
            return e(b11);
        }
        return 0;
    }

    public boolean j() {
        int b11 = b(6);
        return (b11 == 0 || this.f9469b.get(b11 + this.f9468a) == 0) ? false : true;
    }

    public short k() {
        int b11 = b(14);
        if (b11 != 0) {
            return this.f9469b.getShort(b11 + this.f9468a);
        }
        return 0;
    }

    public int l() {
        int b11 = b(4);
        if (b11 != 0) {
            return this.f9469b.getInt(b11 + this.f9468a);
        }
        return 0;
    }

    public short m() {
        int b11 = b(8);
        if (b11 != 0) {
            return this.f9469b.getShort(b11 + this.f9468a);
        }
        return 0;
    }

    public short n() {
        int b11 = b(12);
        if (b11 != 0) {
            return this.f9469b.getShort(b11 + this.f9468a);
        }
        return 0;
    }
}
