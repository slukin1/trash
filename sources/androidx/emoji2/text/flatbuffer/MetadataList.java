package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class MetadataList extends Table {

    public static final class Vector extends BaseVector {
    }

    public static MetadataList h(ByteBuffer byteBuffer) {
        return i(byteBuffer, new MetadataList());
    }

    public static MetadataList i(ByteBuffer byteBuffer, MetadataList metadataList) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataList.f(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public MetadataList f(int i11, ByteBuffer byteBuffer) {
        g(i11, byteBuffer);
        return this;
    }

    public void g(int i11, ByteBuffer byteBuffer) {
        c(i11, byteBuffer);
    }

    public MetadataItem j(MetadataItem metadataItem, int i11) {
        int b11 = b(6);
        if (b11 != 0) {
            return metadataItem.f(a(d(b11) + (i11 * 4)), this.f9469b);
        }
        return null;
    }

    public int k() {
        int b11 = b(6);
        if (b11 != 0) {
            return e(b11);
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
}
