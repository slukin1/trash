package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import f4.h;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f64048a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f64049b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public interface Reader {

        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            public EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] bArr, int i11) throws IOException;

        long skip(long j11) throws IOException;
    }

    public static final class a implements Reader {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f64050a;

        public a(ByteBuffer byteBuffer) {
            this.f64050a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public int getUInt16() throws Reader.EndOfFileException {
            return (getUInt8() << 8) | getUInt8();
        }

        public short getUInt8() throws Reader.EndOfFileException {
            if (this.f64050a.remaining() >= 1) {
                return (short) (this.f64050a.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        public int read(byte[] bArr, int i11) {
            int min = Math.min(i11, this.f64050a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f64050a.get(bArr, 0, min);
            return min;
        }

        public long skip(long j11) {
            int min = (int) Math.min((long) this.f64050a.remaining(), j11);
            ByteBuffer byteBuffer = this.f64050a;
            byteBuffer.position(byteBuffer.position() + min);
            return (long) min;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f64051a;

        public b(byte[] bArr, int i11) {
            this.f64051a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i11);
        }

        public short a(int i11) {
            if (c(i11, 2)) {
                return this.f64051a.getShort(i11);
            }
            return -1;
        }

        public int b(int i11) {
            if (c(i11, 4)) {
                return this.f64051a.getInt(i11);
            }
            return -1;
        }

        public final boolean c(int i11, int i12) {
            return this.f64051a.remaining() - i11 >= i12;
        }

        public int d() {
            return this.f64051a.remaining();
        }

        public void e(ByteOrder byteOrder) {
            this.f64051a.order(byteOrder);
        }
    }

    public static final class c implements Reader {

        /* renamed from: a  reason: collision with root package name */
        public final InputStream f64052a;

        public c(InputStream inputStream) {
            this.f64052a = inputStream;
        }

        public int getUInt16() throws IOException {
            return (getUInt8() << 8) | getUInt8();
        }

        public short getUInt8() throws IOException {
            int read = this.f64052a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new Reader.EndOfFileException();
        }

        public int read(byte[] bArr, int i11) throws IOException {
            int i12 = 0;
            int i13 = 0;
            while (i12 < i11 && (i13 = this.f64052a.read(bArr, i12, i11 - i12)) != -1) {
                i12 += i13;
            }
            if (i12 != 0 || i13 != -1) {
                return i12;
            }
            throw new Reader.EndOfFileException();
        }

        public long skip(long j11) throws IOException {
            if (j11 < 0) {
                return 0;
            }
            long j12 = j11;
            while (j12 > 0) {
                long skip = this.f64052a.skip(j12);
                if (skip <= 0) {
                    if (this.f64052a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j12 -= skip;
            }
            return j11 - j12;
        }
    }

    public static int d(int i11, int i12) {
        return i11 + 2 + (i12 * 12);
    }

    public static boolean g(int i11) {
        return (i11 & 65496) == 65496 || i11 == 19789 || i11 == 18761;
    }

    public static int j(b bVar) {
        ByteOrder byteOrder;
        short a11 = bVar.a(6);
        if (a11 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (a11 != 19789) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + a11);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.e(byteOrder);
        int b11 = bVar.b(10) + 6;
        short a12 = bVar.a(b11);
        for (int i11 = 0; i11 < a12; i11++) {
            int d11 = d(b11, i11);
            short a13 = bVar.a(d11);
            if (a13 == 274) {
                short a14 = bVar.a(d11 + 2);
                if (a14 >= 1 && a14 <= 12) {
                    int b12 = bVar.b(d11 + 4);
                    if (b12 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i11 + " tagType=" + a13 + " formatCode=" + a14 + " componentCount=" + b12);
                        }
                        int i12 = b12 + f64049b[a14];
                        if (i12 <= 4) {
                            int i13 = d11 + 8;
                            if (i13 < 0 || i13 > bVar.d()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i13 + " tagType=" + a13);
                                }
                            } else if (i12 >= 0 && i12 + i13 <= bVar.d()) {
                                return bVar.a(i13);
                            } else {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + a13);
                                }
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + a14);
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + a14);
                }
            }
        }
        return -1;
    }

    public ImageHeaderParser.ImageType a(InputStream inputStream) throws IOException {
        return f(new c((InputStream) h.d(inputStream)));
    }

    public int b(InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        return e(new c((InputStream) h.d(inputStream)), (com.bumptech.glide.load.engine.bitmap_recycle.b) h.d(bVar));
    }

    public ImageHeaderParser.ImageType c(ByteBuffer byteBuffer) throws IOException {
        return f(new a((ByteBuffer) h.d(byteBuffer)));
    }

    public final int e(Reader reader, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        byte[] bArr;
        try {
            int uInt16 = reader.getUInt16();
            if (!g(uInt16)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + uInt16);
                }
                return -1;
            }
            int i11 = i(reader);
            if (i11 == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            bArr = (byte[]) bVar.c(i11, byte[].class);
            int k11 = k(reader, bArr, i11);
            bVar.put(bArr);
            return k11;
        } catch (Reader.EndOfFileException unused) {
            return -1;
        } catch (Throwable th2) {
            bVar.put(bArr);
            throw th2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        return com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0039 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bumptech.glide.load.ImageHeaderParser.ImageType f(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader r6) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r6.getUInt16()     // Catch:{ EndOfFileException -> 0x00a0 }
            r1 = 65496(0xffd8, float:9.178E-41)
            if (r0 != r1) goto L_0x000c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x000c:
            int r0 = r0 << 8
            short r1 = r6.getUInt8()     // Catch:{ EndOfFileException -> 0x00a0 }
            r0 = r0 | r1
            r1 = 4671814(0x474946, float:6.546606E-39)
            if (r0 != r1) goto L_0x001b
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.GIF     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x001b:
            int r0 = r0 << 8
            short r1 = r6.getUInt8()     // Catch:{ EndOfFileException -> 0x00a0 }
            r0 = r0 | r1
            r1 = -1991225785(0xffffffff89504e47, float:-2.5073895E-33)
            if (r0 != r1) goto L_0x003c
            r0 = 21
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.getUInt8()     // Catch:{ EndOfFileException -> 0x0039 }
            r0 = 3
            if (r6 < r0) goto L_0x0036
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A     // Catch:{ EndOfFileException -> 0x0039 }
            goto L_0x0038
        L_0x0036:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ EndOfFileException -> 0x0039 }
        L_0x0038:
            return r6
        L_0x0039:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x003c:
            r1 = 1380533830(0x52494646, float:2.16116855E11)
            if (r0 == r1) goto L_0x0044
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x0044:
            r0 = 4
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r6.getUInt16()     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r2 << 16
            int r3 = r6.getUInt16()     // Catch:{ EndOfFileException -> 0x00a0 }
            r2 = r2 | r3
            r3 = 1464156752(0x57454250, float:2.16888601E14)
            if (r2 == r3) goto L_0x005c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x005c:
            int r2 = r6.getUInt16()     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r2 << 16
            int r3 = r6.getUInt16()     // Catch:{ EndOfFileException -> 0x00a0 }
            r2 = r2 | r3
            r3 = r2 & -256(0xffffffffffffff00, float:NaN)
            r4 = 1448097792(0x56503800, float:5.7234734E13)
            if (r3 == r4) goto L_0x0071
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x0071:
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 88
            if (r2 != r3) goto L_0x0088
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.getUInt8()     // Catch:{ EndOfFileException -> 0x00a0 }
            r6 = r6 & 16
            if (r6 == 0) goto L_0x0085
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ EndOfFileException -> 0x00a0 }
            goto L_0x0087
        L_0x0085:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
        L_0x0087:
            return r6
        L_0x0088:
            r3 = 76
            if (r2 != r3) goto L_0x009d
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.getUInt8()     // Catch:{ EndOfFileException -> 0x00a0 }
            r6 = r6 & 8
            if (r6 == 0) goto L_0x009a
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ EndOfFileException -> 0x00a0 }
            goto L_0x009c
        L_0x009a:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
        L_0x009c:
            return r6
        L_0x009d:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x00a0:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.f(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader):com.bumptech.glide.load.ImageHeaderParser$ImageType");
    }

    public final boolean h(byte[] bArr, int i11) {
        boolean z11 = bArr != null && i11 > f64048a.length;
        if (z11) {
            int i12 = 0;
            while (true) {
                byte[] bArr2 = f64048a;
                if (i12 >= bArr2.length) {
                    break;
                } else if (bArr[i12] != bArr2[i12]) {
                    return false;
                } else {
                    i12++;
                }
            }
        }
        return z11;
    }

    public final int i(Reader reader) throws IOException {
        short uInt8;
        int uInt16;
        long j11;
        long skip;
        do {
            short uInt82 = reader.getUInt8();
            if (uInt82 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + uInt82);
                }
                return -1;
            }
            uInt8 = reader.getUInt8();
            if (uInt8 == 218) {
                return -1;
            }
            if (uInt8 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            uInt16 = reader.getUInt16() - 2;
            if (uInt8 == 225) {
                return uInt16;
            }
            j11 = (long) uInt16;
            skip = reader.skip(j11);
        } while (skip == j11);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + uInt8 + ", wanted to skip: " + uInt16 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    public final int k(Reader reader, byte[] bArr, int i11) throws IOException {
        int read = reader.read(bArr, i11);
        if (read != i11) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i11 + ", actually read: " + read);
            }
            return -1;
        } else if (h(bArr, i11)) {
            return j(new b(bArr, i11));
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
    }
}
