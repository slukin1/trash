package k1;

import androidx.emoji2.text.flatbuffer.MetadataList;
import com.tencent.android.tpush.common.Constants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class h {

    public static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f16026a;

        public a(ByteBuffer byteBuffer) {
            this.f16026a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public int a() throws IOException {
            return this.f16026a.getInt();
        }

        public long b() throws IOException {
            return h.c(this.f16026a.getInt());
        }

        public long getPosition() {
            return (long) this.f16026a.position();
        }

        public int readUnsignedShort() throws IOException {
            return h.d(this.f16026a.getShort());
        }

        public void skip(int i11) throws IOException {
            ByteBuffer byteBuffer = this.f16026a;
            byteBuffer.position(byteBuffer.position() + i11);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f16027a;

        /* renamed from: b  reason: collision with root package name */
        public final long f16028b;

        public b(long j11, long j12) {
            this.f16027a = j11;
            this.f16028b = j12;
        }

        public long a() {
            return this.f16027a;
        }
    }

    public interface c {
        int a() throws IOException;

        long b() throws IOException;

        long getPosition();

        int readUnsignedShort() throws IOException;

        void skip(int i11) throws IOException;
    }

    public static b a(c cVar) throws IOException {
        long j11;
        cVar.skip(4);
        int readUnsignedShort = cVar.readUnsignedShort();
        if (readUnsignedShort <= 100) {
            cVar.skip(6);
            int i11 = 0;
            while (true) {
                if (i11 >= readUnsignedShort) {
                    j11 = -1;
                    break;
                }
                int a11 = cVar.a();
                cVar.skip(4);
                j11 = cVar.b();
                cVar.skip(4);
                if (1835365473 == a11) {
                    break;
                }
                i11++;
            }
            if (j11 != -1) {
                cVar.skip((int) (j11 - cVar.getPosition()));
                cVar.skip(12);
                long b11 = cVar.b();
                for (int i12 = 0; ((long) i12) < b11; i12++) {
                    int a12 = cVar.a();
                    long b12 = cVar.b();
                    long b13 = cVar.b();
                    if (1164798569 == a12 || 1701669481 == a12) {
                        return new b(b12 + j11, b13);
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    public static MetadataList b(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) a(new a(duplicate)).a());
        return MetadataList.h(duplicate);
    }

    public static long c(int i11) {
        return ((long) i11) & 4294967295L;
    }

    public static int d(short s11) {
        return s11 & Constants.PROTOCOL_NONE;
    }
}
