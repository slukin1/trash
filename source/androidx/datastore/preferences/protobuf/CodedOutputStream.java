package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CodedOutputStream extends ByteOutput {

    /* renamed from: c  reason: collision with root package name */
    public static final Logger f8986c = Logger.getLogger(CodedOutputStream.class.getName());

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f8987d = c1.G();

    /* renamed from: a  reason: collision with root package name */
    public i f8988a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8989b;

    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException() {
            super(MESSAGE);
        }

        public OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        public OutOfSpaceException(Throwable th2) {
            super(MESSAGE, th2);
        }

        public OutOfSpaceException(String str, Throwable th2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th2);
        }
    }

    public static abstract class b extends CodedOutputStream {

        /* renamed from: e  reason: collision with root package name */
        public final byte[] f8990e;

        /* renamed from: f  reason: collision with root package name */
        public final int f8991f;

        /* renamed from: g  reason: collision with root package name */
        public int f8992g;

        /* renamed from: h  reason: collision with root package name */
        public int f8993h;

        public b(int i11) {
            super();
            if (i11 >= 0) {
                byte[] bArr = new byte[Math.max(i11, 20)];
                this.f8990e = bArr;
                this.f8991f = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        public final void c1(byte b11) {
            byte[] bArr = this.f8990e;
            int i11 = this.f8992g;
            this.f8992g = i11 + 1;
            bArr[i11] = b11;
            this.f8993h++;
        }

        public final void d1(int i11) {
            byte[] bArr = this.f8990e;
            int i12 = this.f8992g;
            int i13 = i12 + 1;
            this.f8992g = i13;
            bArr[i12] = (byte) (i11 & 255);
            int i14 = i13 + 1;
            this.f8992g = i14;
            bArr[i13] = (byte) ((i11 >> 8) & 255);
            int i15 = i14 + 1;
            this.f8992g = i15;
            bArr[i14] = (byte) ((i11 >> 16) & 255);
            this.f8992g = i15 + 1;
            bArr[i15] = (byte) ((i11 >> 24) & 255);
            this.f8993h += 4;
        }

        public final void e1(long j11) {
            byte[] bArr = this.f8990e;
            int i11 = this.f8992g;
            int i12 = i11 + 1;
            this.f8992g = i12;
            bArr[i11] = (byte) ((int) (j11 & 255));
            int i13 = i12 + 1;
            this.f8992g = i13;
            bArr[i12] = (byte) ((int) ((j11 >> 8) & 255));
            int i14 = i13 + 1;
            this.f8992g = i14;
            bArr[i13] = (byte) ((int) ((j11 >> 16) & 255));
            int i15 = i14 + 1;
            this.f8992g = i15;
            bArr[i14] = (byte) ((int) (255 & (j11 >> 24)));
            int i16 = i15 + 1;
            this.f8992g = i16;
            bArr[i15] = (byte) (((int) (j11 >> 32)) & 255);
            int i17 = i16 + 1;
            this.f8992g = i17;
            bArr[i16] = (byte) (((int) (j11 >> 40)) & 255);
            int i18 = i17 + 1;
            this.f8992g = i18;
            bArr[i17] = (byte) (((int) (j11 >> 48)) & 255);
            this.f8992g = i18 + 1;
            bArr[i18] = (byte) (((int) (j11 >> 56)) & 255);
            this.f8993h += 8;
        }

        public final void f1(int i11) {
            if (i11 >= 0) {
                h1(i11);
            } else {
                i1((long) i11);
            }
        }

        public final void g1(int i11, int i12) {
            h1(WireFormat.c(i11, i12));
        }

        public final void h1(int i11) {
            if (CodedOutputStream.f8987d) {
                long j11 = (long) this.f8992g;
                while ((i11 & -128) != 0) {
                    byte[] bArr = this.f8990e;
                    int i12 = this.f8992g;
                    this.f8992g = i12 + 1;
                    c1.M(bArr, (long) i12, (byte) ((i11 & 127) | 128));
                    i11 >>>= 7;
                }
                byte[] bArr2 = this.f8990e;
                int i13 = this.f8992g;
                this.f8992g = i13 + 1;
                c1.M(bArr2, (long) i13, (byte) i11);
                this.f8993h += (int) (((long) this.f8992g) - j11);
                return;
            }
            while ((i11 & -128) != 0) {
                byte[] bArr3 = this.f8990e;
                int i14 = this.f8992g;
                this.f8992g = i14 + 1;
                bArr3[i14] = (byte) ((i11 & 127) | 128);
                this.f8993h++;
                i11 >>>= 7;
            }
            byte[] bArr4 = this.f8990e;
            int i15 = this.f8992g;
            this.f8992g = i15 + 1;
            bArr4[i15] = (byte) i11;
            this.f8993h++;
        }

        public final void i1(long j11) {
            if (CodedOutputStream.f8987d) {
                long j12 = (long) this.f8992g;
                while ((j11 & -128) != 0) {
                    byte[] bArr = this.f8990e;
                    int i11 = this.f8992g;
                    this.f8992g = i11 + 1;
                    c1.M(bArr, (long) i11, (byte) ((((int) j11) & 127) | 128));
                    j11 >>>= 7;
                }
                byte[] bArr2 = this.f8990e;
                int i12 = this.f8992g;
                this.f8992g = i12 + 1;
                c1.M(bArr2, (long) i12, (byte) ((int) j11));
                this.f8993h += (int) (((long) this.f8992g) - j12);
                return;
            }
            while ((j11 & -128) != 0) {
                byte[] bArr3 = this.f8990e;
                int i13 = this.f8992g;
                this.f8992g = i13 + 1;
                bArr3[i13] = (byte) ((((int) j11) & 127) | 128);
                this.f8993h++;
                j11 >>>= 7;
            }
            byte[] bArr4 = this.f8990e;
            int i14 = this.f8992g;
            this.f8992g = i14 + 1;
            bArr4[i14] = (byte) ((int) j11);
            this.f8993h++;
        }

        public final int j0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    public static class c extends CodedOutputStream {

        /* renamed from: e  reason: collision with root package name */
        public final byte[] f8994e;

        /* renamed from: f  reason: collision with root package name */
        public final int f8995f;

        /* renamed from: g  reason: collision with root package name */
        public final int f8996g;

        /* renamed from: h  reason: collision with root package name */
        public int f8997h;

        public c(byte[] bArr, int i11, int i12) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            int i13 = i11 + i12;
            if ((i11 | i12 | (bArr.length - i13)) >= 0) {
                this.f8994e = bArr;
                this.f8995f = i11;
                this.f8997h = i11;
                this.f8996g = i13;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)}));
        }

        public final void F0(int i11, int i12) throws IOException {
            X0(i11, 0);
            G0(i12);
        }

        public final void G0(int i11) throws IOException {
            if (i11 >= 0) {
                Z0(i11);
            } else {
                b1((long) i11);
            }
        }

        public final void J0(int i11, f0 f0Var, t0 t0Var) throws IOException {
            X0(i11, 2);
            Z0(((AbstractMessageLite) f0Var).e(t0Var));
            t0Var.a(f0Var, this.f8988a);
        }

        public final void K0(f0 f0Var) throws IOException {
            Z0(f0Var.getSerializedSize());
            f0Var.b(this);
        }

        public final void L0(int i11, f0 f0Var) throws IOException {
            X0(1, 3);
            Y0(2, i11);
            e1(3, f0Var);
            X0(1, 4);
        }

        public final void M0(int i11, ByteString byteString) throws IOException {
            X0(1, 3);
            Y0(2, i11);
            p0(3, byteString);
            X0(1, 4);
        }

        public final void V0(int i11, String str) throws IOException {
            X0(i11, 2);
            W0(str);
        }

        public final void W0(String str) throws IOException {
            int i11 = this.f8997h;
            try {
                int Y = CodedOutputStream.Y(str.length() * 3);
                int Y2 = CodedOutputStream.Y(str.length());
                if (Y2 == Y) {
                    int i12 = i11 + Y2;
                    this.f8997h = i12;
                    int i13 = Utf8.i(str, this.f8994e, i12, j0());
                    this.f8997h = i11;
                    Z0((i13 - i11) - Y2);
                    this.f8997h = i13;
                    return;
                }
                Z0(Utf8.j(str));
                this.f8997h = Utf8.i(str, this.f8994e, this.f8997h, j0());
            } catch (Utf8.UnpairedSurrogateException e11) {
                this.f8997h = i11;
                e0(str, e11);
            } catch (IndexOutOfBoundsException e12) {
                throw new OutOfSpaceException((Throwable) e12);
            }
        }

        public final void X0(int i11, int i12) throws IOException {
            Z0(WireFormat.c(i11, i12));
        }

        public final void Y0(int i11, int i12) throws IOException {
            X0(i11, 0);
            Z0(i12);
        }

        public final void Z0(int i11) throws IOException {
            if (!CodedOutputStream.f8987d || b.c() || j0() < 5) {
                while ((i11 & -128) != 0) {
                    byte[] bArr = this.f8994e;
                    int i12 = this.f8997h;
                    this.f8997h = i12 + 1;
                    bArr[i12] = (byte) ((i11 & 127) | 128);
                    i11 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f8994e;
                    int i13 = this.f8997h;
                    this.f8997h = i13 + 1;
                    bArr2[i13] = (byte) i11;
                } catch (IndexOutOfBoundsException e11) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f8997h), Integer.valueOf(this.f8996g), 1}), e11);
                }
            } else if ((i11 & -128) == 0) {
                byte[] bArr3 = this.f8994e;
                int i14 = this.f8997h;
                this.f8997h = i14 + 1;
                c1.M(bArr3, (long) i14, (byte) i11);
            } else {
                byte[] bArr4 = this.f8994e;
                int i15 = this.f8997h;
                this.f8997h = i15 + 1;
                c1.M(bArr4, (long) i15, (byte) (i11 | 128));
                int i16 = i11 >>> 7;
                if ((i16 & -128) == 0) {
                    byte[] bArr5 = this.f8994e;
                    int i17 = this.f8997h;
                    this.f8997h = i17 + 1;
                    c1.M(bArr5, (long) i17, (byte) i16);
                    return;
                }
                byte[] bArr6 = this.f8994e;
                int i18 = this.f8997h;
                this.f8997h = i18 + 1;
                c1.M(bArr6, (long) i18, (byte) (i16 | 128));
                int i19 = i16 >>> 7;
                if ((i19 & -128) == 0) {
                    byte[] bArr7 = this.f8994e;
                    int i21 = this.f8997h;
                    this.f8997h = i21 + 1;
                    c1.M(bArr7, (long) i21, (byte) i19);
                    return;
                }
                byte[] bArr8 = this.f8994e;
                int i22 = this.f8997h;
                this.f8997h = i22 + 1;
                c1.M(bArr8, (long) i22, (byte) (i19 | 128));
                int i23 = i19 >>> 7;
                if ((i23 & -128) == 0) {
                    byte[] bArr9 = this.f8994e;
                    int i24 = this.f8997h;
                    this.f8997h = i24 + 1;
                    c1.M(bArr9, (long) i24, (byte) i23);
                    return;
                }
                byte[] bArr10 = this.f8994e;
                int i25 = this.f8997h;
                this.f8997h = i25 + 1;
                c1.M(bArr10, (long) i25, (byte) (i23 | 128));
                byte[] bArr11 = this.f8994e;
                int i26 = this.f8997h;
                this.f8997h = i26 + 1;
                c1.M(bArr11, (long) i26, (byte) (i23 >>> 7));
            }
        }

        public final void a(ByteBuffer byteBuffer) throws IOException {
            c1(byteBuffer);
        }

        public final void a1(int i11, long j11) throws IOException {
            X0(i11, 0);
            b1(j11);
        }

        public final void b(byte[] bArr, int i11, int i12) throws IOException {
            d1(bArr, i11, i12);
        }

        public final void b1(long j11) throws IOException {
            if (!CodedOutputStream.f8987d || j0() < 10) {
                while ((j11 & -128) != 0) {
                    byte[] bArr = this.f8994e;
                    int i11 = this.f8997h;
                    this.f8997h = i11 + 1;
                    bArr[i11] = (byte) ((((int) j11) & 127) | 128);
                    j11 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f8994e;
                    int i12 = this.f8997h;
                    this.f8997h = i12 + 1;
                    bArr2[i12] = (byte) ((int) j11);
                } catch (IndexOutOfBoundsException e11) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f8997h), Integer.valueOf(this.f8996g), 1}), e11);
                }
            } else {
                while ((j11 & -128) != 0) {
                    byte[] bArr3 = this.f8994e;
                    int i13 = this.f8997h;
                    this.f8997h = i13 + 1;
                    c1.M(bArr3, (long) i13, (byte) ((((int) j11) & 127) | 128));
                    j11 >>>= 7;
                }
                byte[] bArr4 = this.f8994e;
                int i14 = this.f8997h;
                this.f8997h = i14 + 1;
                c1.M(bArr4, (long) i14, (byte) ((int) j11));
            }
        }

        public final void c1(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f8994e, this.f8997h, remaining);
                this.f8997h += remaining;
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f8997h), Integer.valueOf(this.f8996g), Integer.valueOf(remaining)}), e11);
            }
        }

        public void d0() {
        }

        public final void d1(byte[] bArr, int i11, int i12) throws IOException {
            try {
                System.arraycopy(bArr, i11, this.f8994e, this.f8997h, i12);
                this.f8997h += i12;
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f8997h), Integer.valueOf(this.f8996g), Integer.valueOf(i12)}), e11);
            }
        }

        public final void e1(int i11, f0 f0Var) throws IOException {
            X0(i11, 2);
            K0(f0Var);
        }

        public final int j0() {
            return this.f8996g - this.f8997h;
        }

        public final void k0(byte b11) throws IOException {
            try {
                byte[] bArr = this.f8994e;
                int i11 = this.f8997h;
                this.f8997h = i11 + 1;
                bArr[i11] = b11;
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f8997h), Integer.valueOf(this.f8996g), 1}), e11);
            }
        }

        public final void l0(int i11, boolean z11) throws IOException {
            X0(i11, 0);
            k0(z11 ? (byte) 1 : 0);
        }

        public final void o0(byte[] bArr, int i11, int i12) throws IOException {
            Z0(i12);
            d1(bArr, i11, i12);
        }

        public final void p0(int i11, ByteString byteString) throws IOException {
            X0(i11, 2);
            q0(byteString);
        }

        public final void q0(ByteString byteString) throws IOException {
            Z0(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public final void v0(int i11, int i12) throws IOException {
            X0(i11, 5);
            w0(i12);
        }

        public final void w0(int i11) throws IOException {
            try {
                byte[] bArr = this.f8994e;
                int i12 = this.f8997h;
                int i13 = i12 + 1;
                this.f8997h = i13;
                bArr[i12] = (byte) (i11 & 255);
                int i14 = i13 + 1;
                this.f8997h = i14;
                bArr[i13] = (byte) ((i11 >> 8) & 255);
                int i15 = i14 + 1;
                this.f8997h = i15;
                bArr[i14] = (byte) ((i11 >> 16) & 255);
                this.f8997h = i15 + 1;
                bArr[i15] = (byte) ((i11 >> 24) & 255);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f8997h), Integer.valueOf(this.f8996g), 1}), e11);
            }
        }

        public final void x0(int i11, long j11) throws IOException {
            X0(i11, 1);
            y0(j11);
        }

        public final void y0(long j11) throws IOException {
            try {
                byte[] bArr = this.f8994e;
                int i11 = this.f8997h;
                int i12 = i11 + 1;
                this.f8997h = i12;
                bArr[i11] = (byte) (((int) j11) & 255);
                int i13 = i12 + 1;
                this.f8997h = i13;
                bArr[i12] = (byte) (((int) (j11 >> 8)) & 255);
                int i14 = i13 + 1;
                this.f8997h = i14;
                bArr[i13] = (byte) (((int) (j11 >> 16)) & 255);
                int i15 = i14 + 1;
                this.f8997h = i15;
                bArr[i14] = (byte) (((int) (j11 >> 24)) & 255);
                int i16 = i15 + 1;
                this.f8997h = i16;
                bArr[i15] = (byte) (((int) (j11 >> 32)) & 255);
                int i17 = i16 + 1;
                this.f8997h = i17;
                bArr[i16] = (byte) (((int) (j11 >> 40)) & 255);
                int i18 = i17 + 1;
                this.f8997h = i18;
                bArr[i17] = (byte) (((int) (j11 >> 48)) & 255);
                this.f8997h = i18 + 1;
                bArr[i18] = (byte) (((int) (j11 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f8997h), Integer.valueOf(this.f8996g), 1}), e11);
            }
        }
    }

    public static final class d extends b {

        /* renamed from: i  reason: collision with root package name */
        public final OutputStream f8998i;

        public d(OutputStream outputStream, int i11) {
            super(i11);
            Objects.requireNonNull(outputStream, "out");
            this.f8998i = outputStream;
        }

        public void F0(int i11, int i12) throws IOException {
            k1(20);
            g1(i11, 0);
            f1(i12);
        }

        public void G0(int i11) throws IOException {
            if (i11 >= 0) {
                Z0(i11);
            } else {
                b1((long) i11);
            }
        }

        public void J0(int i11, f0 f0Var, t0 t0Var) throws IOException {
            X0(i11, 2);
            o1(f0Var, t0Var);
        }

        public void K0(f0 f0Var) throws IOException {
            Z0(f0Var.getSerializedSize());
            f0Var.b(this);
        }

        public void L0(int i11, f0 f0Var) throws IOException {
            X0(1, 3);
            Y0(2, i11);
            n1(3, f0Var);
            X0(1, 4);
        }

        public void M0(int i11, ByteString byteString) throws IOException {
            X0(1, 3);
            Y0(2, i11);
            p0(3, byteString);
            X0(1, 4);
        }

        public void V0(int i11, String str) throws IOException {
            X0(i11, 2);
            W0(str);
        }

        public void W0(String str) throws IOException {
            int i11;
            int i12;
            try {
                int length = str.length() * 3;
                int Y = CodedOutputStream.Y(length);
                int i13 = Y + length;
                int i14 = this.f8991f;
                if (i13 > i14) {
                    byte[] bArr = new byte[length];
                    int i15 = Utf8.i(str, bArr, 0, length);
                    Z0(i15);
                    b(bArr, 0, i15);
                    return;
                }
                if (i13 > i14 - this.f8992g) {
                    j1();
                }
                int Y2 = CodedOutputStream.Y(str.length());
                i11 = this.f8992g;
                if (Y2 == Y) {
                    int i16 = i11 + Y2;
                    this.f8992g = i16;
                    int i17 = Utf8.i(str, this.f8990e, i16, this.f8991f - i16);
                    this.f8992g = i11;
                    i12 = (i17 - i11) - Y2;
                    h1(i12);
                    this.f8992g = i17;
                } else {
                    i12 = Utf8.j(str);
                    h1(i12);
                    this.f8992g = Utf8.i(str, this.f8990e, this.f8992g, i12);
                }
                this.f8993h += i12;
            } catch (Utf8.UnpairedSurrogateException e11) {
                this.f8993h -= this.f8992g - i11;
                this.f8992g = i11;
                throw e11;
            } catch (ArrayIndexOutOfBoundsException e12) {
                throw new OutOfSpaceException((Throwable) e12);
            } catch (Utf8.UnpairedSurrogateException e13) {
                e0(str, e13);
            }
        }

        public void X0(int i11, int i12) throws IOException {
            Z0(WireFormat.c(i11, i12));
        }

        public void Y0(int i11, int i12) throws IOException {
            k1(20);
            g1(i11, 0);
            h1(i12);
        }

        public void Z0(int i11) throws IOException {
            k1(5);
            h1(i11);
        }

        public void a(ByteBuffer byteBuffer) throws IOException {
            l1(byteBuffer);
        }

        public void a1(int i11, long j11) throws IOException {
            k1(20);
            g1(i11, 0);
            i1(j11);
        }

        public void b(byte[] bArr, int i11, int i12) throws IOException {
            m1(bArr, i11, i12);
        }

        public void b1(long j11) throws IOException {
            k1(10);
            i1(j11);
        }

        public void d0() throws IOException {
            if (this.f8992g > 0) {
                j1();
            }
        }

        public final void j1() throws IOException {
            this.f8998i.write(this.f8990e, 0, this.f8992g);
            this.f8992g = 0;
        }

        public void k0(byte b11) throws IOException {
            if (this.f8992g == this.f8991f) {
                j1();
            }
            c1(b11);
        }

        public final void k1(int i11) throws IOException {
            if (this.f8991f - this.f8992g < i11) {
                j1();
            }
        }

        public void l0(int i11, boolean z11) throws IOException {
            k1(11);
            g1(i11, 0);
            c1(z11 ? (byte) 1 : 0);
        }

        public void l1(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            int i11 = this.f8991f;
            int i12 = this.f8992g;
            if (i11 - i12 >= remaining) {
                byteBuffer.get(this.f8990e, i12, remaining);
                this.f8992g += remaining;
                this.f8993h += remaining;
                return;
            }
            int i13 = i11 - i12;
            byteBuffer.get(this.f8990e, i12, i13);
            int i14 = remaining - i13;
            this.f8992g = this.f8991f;
            this.f8993h += i13;
            j1();
            while (true) {
                int i15 = this.f8991f;
                if (i14 > i15) {
                    byteBuffer.get(this.f8990e, 0, i15);
                    this.f8998i.write(this.f8990e, 0, this.f8991f);
                    int i16 = this.f8991f;
                    i14 -= i16;
                    this.f8993h += i16;
                } else {
                    byteBuffer.get(this.f8990e, 0, i14);
                    this.f8992g = i14;
                    this.f8993h += i14;
                    return;
                }
            }
        }

        public void m1(byte[] bArr, int i11, int i12) throws IOException {
            int i13 = this.f8991f;
            int i14 = this.f8992g;
            if (i13 - i14 >= i12) {
                System.arraycopy(bArr, i11, this.f8990e, i14, i12);
                this.f8992g += i12;
                this.f8993h += i12;
                return;
            }
            int i15 = i13 - i14;
            System.arraycopy(bArr, i11, this.f8990e, i14, i15);
            int i16 = i11 + i15;
            int i17 = i12 - i15;
            this.f8992g = this.f8991f;
            this.f8993h += i15;
            j1();
            if (i17 <= this.f8991f) {
                System.arraycopy(bArr, i16, this.f8990e, 0, i17);
                this.f8992g = i17;
            } else {
                this.f8998i.write(bArr, i16, i17);
            }
            this.f8993h += i17;
        }

        public void n1(int i11, f0 f0Var) throws IOException {
            X0(i11, 2);
            K0(f0Var);
        }

        public void o0(byte[] bArr, int i11, int i12) throws IOException {
            Z0(i12);
            m1(bArr, i11, i12);
        }

        public void o1(f0 f0Var, t0 t0Var) throws IOException {
            Z0(((AbstractMessageLite) f0Var).e(t0Var));
            t0Var.a(f0Var, this.f8988a);
        }

        public void p0(int i11, ByteString byteString) throws IOException {
            X0(i11, 2);
            q0(byteString);
        }

        public void q0(ByteString byteString) throws IOException {
            Z0(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void v0(int i11, int i12) throws IOException {
            k1(14);
            g1(i11, 5);
            d1(i12);
        }

        public void w0(int i11) throws IOException {
            k1(4);
            d1(i11);
        }

        public void x0(int i11, long j11) throws IOException {
            k1(18);
            g1(i11, 1);
            e1(j11);
        }

        public void y0(long j11) throws IOException {
            k1(8);
            e1(j11);
        }
    }

    public static int A(int i11, LazyFieldLite lazyFieldLite) {
        return (W(1) * 2) + X(2, i11) + B(3, lazyFieldLite);
    }

    public static int B(int i11, LazyFieldLite lazyFieldLite) {
        return W(i11) + C(lazyFieldLite);
    }

    public static int C(LazyFieldLite lazyFieldLite) {
        return D(lazyFieldLite.b());
    }

    public static int D(int i11) {
        return Y(i11) + i11;
    }

    public static int E(int i11, f0 f0Var) {
        return (W(1) * 2) + X(2, i11) + F(3, f0Var);
    }

    public static int F(int i11, f0 f0Var) {
        return W(i11) + H(f0Var);
    }

    public static int G(int i11, f0 f0Var, t0 t0Var) {
        return W(i11) + I(f0Var, t0Var);
    }

    public static int H(f0 f0Var) {
        return D(f0Var.getSerializedSize());
    }

    public static int I(f0 f0Var, t0 t0Var) {
        return D(((AbstractMessageLite) f0Var).e(t0Var));
    }

    public static int J(int i11) {
        if (i11 > 4096) {
            return 4096;
        }
        return i11;
    }

    public static int K(int i11, ByteString byteString) {
        return (W(1) * 2) + X(2, i11) + h(3, byteString);
    }

    @Deprecated
    public static int L(int i11) {
        return Y(i11);
    }

    public static int M(int i11, int i12) {
        return W(i11) + N(i12);
    }

    public static int N(int i11) {
        return 4;
    }

    public static int O(int i11, long j11) {
        return W(i11) + P(j11);
    }

    public static int P(long j11) {
        return 8;
    }

    public static int Q(int i11, int i12) {
        return W(i11) + R(i12);
    }

    public static int R(int i11) {
        return Y(b0(i11));
    }

    public static int S(int i11, long j11) {
        return W(i11) + T(j11);
    }

    public static int T(long j11) {
        return a0(c0(j11));
    }

    public static int U(int i11, String str) {
        return W(i11) + V(str);
    }

    public static int V(String str) {
        int i11;
        try {
            i11 = Utf8.j(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            i11 = str.getBytes(u.f9213a).length;
        }
        return D(i11);
    }

    public static int W(int i11) {
        return Y(WireFormat.c(i11, 0));
    }

    public static int X(int i11, int i12) {
        return W(i11) + Y(i12);
    }

    public static int Y(int i11) {
        if ((i11 & -128) == 0) {
            return 1;
        }
        if ((i11 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i11) == 0) {
            return 3;
        }
        return (i11 & -268435456) == 0 ? 4 : 5;
    }

    public static int Z(int i11, long j11) {
        return W(i11) + a0(j11);
    }

    public static int a0(long j11) {
        int i11;
        if ((-128 & j11) == 0) {
            return 1;
        }
        if (j11 < 0) {
            return 10;
        }
        if ((-34359738368L & j11) != 0) {
            i11 = 6;
            j11 >>>= 28;
        } else {
            i11 = 2;
        }
        if ((-2097152 & j11) != 0) {
            i11 += 2;
            j11 >>>= 14;
        }
        return (j11 & -16384) != 0 ? i11 + 1 : i11;
    }

    public static int b0(int i11) {
        return (i11 >> 31) ^ (i11 << 1);
    }

    public static long c0(long j11) {
        return (j11 >> 63) ^ (j11 << 1);
    }

    public static int e(int i11, boolean z11) {
        return W(i11) + f(z11);
    }

    public static int f(boolean z11) {
        return 1;
    }

    public static int g(byte[] bArr) {
        return D(bArr.length);
    }

    public static CodedOutputStream g0(OutputStream outputStream, int i11) {
        return new d(outputStream, i11);
    }

    public static int h(int i11, ByteString byteString) {
        return W(i11) + i(byteString);
    }

    public static CodedOutputStream h0(byte[] bArr) {
        return i0(bArr, 0, bArr.length);
    }

    public static int i(ByteString byteString) {
        return D(byteString.size());
    }

    public static CodedOutputStream i0(byte[] bArr, int i11, int i12) {
        return new c(bArr, i11, i12);
    }

    public static int j(int i11, double d11) {
        return W(i11) + k(d11);
    }

    public static int k(double d11) {
        return 8;
    }

    public static int l(int i11, int i12) {
        return W(i11) + m(i12);
    }

    public static int m(int i11) {
        return x(i11);
    }

    public static int n(int i11, int i12) {
        return W(i11) + o(i12);
    }

    public static int o(int i11) {
        return 4;
    }

    public static int p(int i11, long j11) {
        return W(i11) + q(j11);
    }

    public static int q(long j11) {
        return 8;
    }

    public static int r(int i11, float f11) {
        return W(i11) + s(f11);
    }

    public static int s(float f11) {
        return 4;
    }

    @Deprecated
    public static int t(int i11, f0 f0Var, t0 t0Var) {
        return (W(i11) * 2) + v(f0Var, t0Var);
    }

    @Deprecated
    public static int u(f0 f0Var) {
        return f0Var.getSerializedSize();
    }

    @Deprecated
    public static int v(f0 f0Var, t0 t0Var) {
        return ((AbstractMessageLite) f0Var).e(t0Var);
    }

    public static int w(int i11, int i12) {
        return W(i11) + x(i12);
    }

    public static int x(int i11) {
        if (i11 >= 0) {
            return Y(i11);
        }
        return 10;
    }

    public static int y(int i11, long j11) {
        return W(i11) + z(j11);
    }

    public static int z(long j11) {
        return a0(j11);
    }

    public final void A0(float f11) throws IOException {
        w0(Float.floatToRawIntBits(f11));
    }

    @Deprecated
    public final void B0(int i11, f0 f0Var) throws IOException {
        X0(i11, 3);
        D0(f0Var);
        X0(i11, 4);
    }

    @Deprecated
    public final void C0(int i11, f0 f0Var, t0 t0Var) throws IOException {
        X0(i11, 3);
        E0(f0Var, t0Var);
        X0(i11, 4);
    }

    @Deprecated
    public final void D0(f0 f0Var) throws IOException {
        f0Var.b(this);
    }

    @Deprecated
    public final void E0(f0 f0Var, t0 t0Var) throws IOException {
        t0Var.a(f0Var, this.f8988a);
    }

    public abstract void F0(int i11, int i12) throws IOException;

    public abstract void G0(int i11) throws IOException;

    public final void H0(int i11, long j11) throws IOException {
        a1(i11, j11);
    }

    public final void I0(long j11) throws IOException {
        b1(j11);
    }

    public abstract void J0(int i11, f0 f0Var, t0 t0Var) throws IOException;

    public abstract void K0(f0 f0Var) throws IOException;

    public abstract void L0(int i11, f0 f0Var) throws IOException;

    public abstract void M0(int i11, ByteString byteString) throws IOException;

    public final void N0(int i11, int i12) throws IOException {
        v0(i11, i12);
    }

    public final void O0(int i11) throws IOException {
        w0(i11);
    }

    public final void P0(int i11, long j11) throws IOException {
        x0(i11, j11);
    }

    public final void Q0(long j11) throws IOException {
        y0(j11);
    }

    public final void R0(int i11, int i12) throws IOException {
        Y0(i11, b0(i12));
    }

    public final void S0(int i11) throws IOException {
        Z0(b0(i11));
    }

    public final void T0(int i11, long j11) throws IOException {
        a1(i11, c0(j11));
    }

    public final void U0(long j11) throws IOException {
        b1(c0(j11));
    }

    public abstract void V0(int i11, String str) throws IOException;

    public abstract void W0(String str) throws IOException;

    public abstract void X0(int i11, int i12) throws IOException;

    public abstract void Y0(int i11, int i12) throws IOException;

    public abstract void Z0(int i11) throws IOException;

    public abstract void a1(int i11, long j11) throws IOException;

    public abstract void b(byte[] bArr, int i11, int i12) throws IOException;

    public abstract void b1(long j11) throws IOException;

    public final void d() {
        if (j0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void d0() throws IOException;

    public final void e0(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        f8986c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", unpairedSurrogateException);
        byte[] bytes = str.getBytes(u.f9213a);
        try {
            Z0(bytes.length);
            b(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e11) {
            throw new OutOfSpaceException((Throwable) e11);
        } catch (OutOfSpaceException e12) {
            throw e12;
        }
    }

    public boolean f0() {
        return this.f8989b;
    }

    public abstract int j0();

    public abstract void k0(byte b11) throws IOException;

    public abstract void l0(int i11, boolean z11) throws IOException;

    public final void m0(boolean z11) throws IOException {
        k0(z11 ? (byte) 1 : 0);
    }

    public final void n0(byte[] bArr) throws IOException {
        o0(bArr, 0, bArr.length);
    }

    public abstract void o0(byte[] bArr, int i11, int i12) throws IOException;

    public abstract void p0(int i11, ByteString byteString) throws IOException;

    public abstract void q0(ByteString byteString) throws IOException;

    public final void r0(int i11, double d11) throws IOException {
        x0(i11, Double.doubleToRawLongBits(d11));
    }

    public final void s0(double d11) throws IOException {
        y0(Double.doubleToRawLongBits(d11));
    }

    public final void t0(int i11, int i12) throws IOException {
        F0(i11, i12);
    }

    public final void u0(int i11) throws IOException {
        G0(i11);
    }

    public abstract void v0(int i11, int i12) throws IOException;

    public abstract void w0(int i11) throws IOException;

    public abstract void x0(int i11, long j11) throws IOException;

    public abstract void y0(long j11) throws IOException;

    public final void z0(int i11, float f11) throws IOException {
        v0(i11, Float.floatToRawIntBits(f11));
    }

    public CodedOutputStream() {
    }
}
