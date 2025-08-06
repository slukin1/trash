package com.yalantis.ucrop.util;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import m1.a;

public class ImageHeaderParser {
    private static final int[] BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    private static final int EXIF_MAGIC_NUMBER = 65496;
    private static final int EXIF_SEGMENT_TYPE = 225;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    private static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int SEGMENT_SOS = 218;
    private static final int SEGMENT_START_ID = 255;
    private static final String TAG = "ImageHeaderParser";
    public static final int UNKNOWN_ORIENTATION = -1;
    private final Reader reader;

    public static class RandomAccessReader {
        private final ByteBuffer data;

        public RandomAccessReader(byte[] bArr, int i11) {
            this.data = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i11);
        }

        public short getInt16(int i11) {
            return this.data.getShort(i11);
        }

        public int getInt32(int i11) {
            return this.data.getInt(i11);
        }

        public int length() {
            return this.data.remaining();
        }

        public void order(ByteOrder byteOrder) {
            this.data.order(byteOrder);
        }
    }

    public interface Reader {
        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] bArr, int i11) throws IOException;

        long skip(long j11) throws IOException;
    }

    public static class StreamReader implements Reader {

        /* renamed from: is  reason: collision with root package name */
        private final InputStream f52625is;

        public StreamReader(InputStream inputStream) {
            this.f52625is = inputStream;
        }

        public int getUInt16() throws IOException {
            return ((this.f52625is.read() << 8) & 65280) | (this.f52625is.read() & 255);
        }

        public short getUInt8() throws IOException {
            return (short) (this.f52625is.read() & 255);
        }

        public int read(byte[] bArr, int i11) throws IOException {
            int i12 = i11;
            while (i12 > 0) {
                int read = this.f52625is.read(bArr, i11 - i12, i12);
                if (read == -1) {
                    break;
                }
                i12 -= read;
            }
            return i11 - i12;
        }

        public long skip(long j11) throws IOException {
            if (j11 < 0) {
                return 0;
            }
            long j12 = j11;
            while (j12 > 0) {
                long skip = this.f52625is.skip(j12);
                if (skip <= 0) {
                    if (this.f52625is.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j12 -= skip;
            }
            return j11 - j12;
        }
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.reader = new StreamReader(inputStream);
    }

    private static int calcTagOffset(int i11, int i12) {
        return i11 + 2 + (i12 * 12);
    }

    public static void copyExif(a aVar, int i11, int i12, String str) {
        try {
            copyExifAttributes(aVar, new a(str), i11, i12);
        } catch (IOException e11) {
            Log.d(TAG, e11.getMessage());
        }
    }

    private static void copyExifAttributes(a aVar, a aVar2, int i11, int i12) throws IOException {
        a aVar3 = aVar2;
        String[] strArr = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "PhotographicSensitivity", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
        for (int i13 = 0; i13 < 22; i13++) {
            String str = strArr[i13];
            String g11 = aVar.g(str);
            if (!TextUtils.isEmpty(g11)) {
                aVar3.c0(str, g11);
            }
        }
        aVar3.c0("ImageWidth", String.valueOf(i11));
        aVar3.c0("ImageLength", String.valueOf(i12));
        aVar3.c0("Orientation", "0");
        aVar2.X();
    }

    private static boolean handles(int i11) {
        return (i11 & EXIF_MAGIC_NUMBER) == EXIF_MAGIC_NUMBER || i11 == MOTOROLA_TIFF_MAGIC_NUMBER || i11 == INTEL_TIFF_MAGIC_NUMBER;
    }

    private boolean hasJpegExifPreamble(byte[] bArr, int i11) {
        boolean z11 = bArr != null && i11 > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length;
        if (z11) {
            int i12 = 0;
            while (true) {
                byte[] bArr2 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
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

    private int moveToExifSegmentAndGetLength() throws IOException {
        short uInt8;
        int uInt16;
        long j11;
        long skip;
        do {
            short uInt82 = this.reader.getUInt8();
            if (uInt82 != 255) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Unknown segmentId=" + uInt82);
                }
                return -1;
            }
            uInt8 = this.reader.getUInt8();
            if (uInt8 == 218) {
                return -1;
            }
            if (uInt8 == 217) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            uInt16 = this.reader.getUInt16() - 2;
            if (uInt8 == 225) {
                return uInt16;
            }
            j11 = (long) uInt16;
            skip = this.reader.skip(j11);
        } while (skip == j11);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Unable to skip enough data, type: " + uInt8 + ", wanted to skip: " + uInt16 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    private int parseExifSegment(byte[] bArr, int i11) throws IOException {
        int read = this.reader.read(bArr, i11);
        if (read != i11) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unable to read exif segment data, length: " + i11 + ", actually read: " + read);
            }
            return -1;
        } else if (hasJpegExifPreamble(bArr, i11)) {
            return parseExifSegment(new RandomAccessReader(bArr, i11));
        } else {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    public int getOrientation() throws IOException {
        int uInt16 = this.reader.getUInt16();
        if (!handles(uInt16)) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Parser doesn't handle magic number: " + uInt16);
            }
            return -1;
        }
        int moveToExifSegmentAndGetLength = moveToExifSegmentAndGetLength();
        if (moveToExifSegmentAndGetLength != -1) {
            return parseExifSegment(new byte[moveToExifSegmentAndGetLength], moveToExifSegmentAndGetLength);
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Failed to parse exif segment length, or exif segment not found");
        }
        return -1;
    }

    public static void copyExif(Context context, int i11, int i12, Uri uri, String str) {
        if (context == null) {
            Log.d(TAG, "context is null");
            return;
        }
        InputStream inputStream = null;
        try {
            inputStream = context.getContentResolver().openInputStream(uri);
            copyExifAttributes(new a(inputStream), new a(str), i11, i12);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e11) {
                    Log.d(TAG, e11.getMessage(), e11);
                }
            }
        } catch (IOException e12) {
            Log.d(TAG, e12.getMessage(), e12);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e13) {
                    Log.d(TAG, e13.getMessage(), e13);
                }
            }
            throw th2;
        }
    }

    private static int parseExifSegment(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        short int16 = randomAccessReader.getInt16(6);
        if (int16 == MOTOROLA_TIFF_MAGIC_NUMBER) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (int16 == INTEL_TIFF_MAGIC_NUMBER) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unknown endianness = " + int16);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.order(byteOrder);
        int int32 = randomAccessReader.getInt32(10) + 6;
        short int162 = randomAccessReader.getInt16(int32);
        for (int i11 = 0; i11 < int162; i11++) {
            int calcTagOffset = calcTagOffset(int32, i11);
            short int163 = randomAccessReader.getInt16(calcTagOffset);
            if (int163 == 274) {
                short int164 = randomAccessReader.getInt16(calcTagOffset + 2);
                if (int164 >= 1 && int164 <= 12) {
                    int int322 = randomAccessReader.getInt32(calcTagOffset + 4);
                    if (int322 >= 0) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Got tagIndex=" + i11 + " tagType=" + int163 + " formatCode=" + int164 + " componentCount=" + int322);
                        }
                        int i12 = int322 + BYTES_PER_FORMAT[int164];
                        if (i12 <= 4) {
                            int i13 = calcTagOffset + 8;
                            if (i13 < 0 || i13 > randomAccessReader.length()) {
                                if (Log.isLoggable(TAG, 3)) {
                                    Log.d(TAG, "Illegal tagValueOffset=" + i13 + " tagType=" + int163);
                                }
                            } else if (i12 >= 0 && i12 + i13 <= randomAccessReader.length()) {
                                return randomAccessReader.getInt16(i13);
                            } else {
                                if (Log.isLoggable(TAG, 3)) {
                                    Log.d(TAG, "Illegal number of bytes for TI tag data tagType=" + int163);
                                }
                            }
                        } else if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Got byte count > 4, not orientation, continuing, formatCode=" + int164);
                        }
                    } else if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Negative tiff component count");
                    }
                } else if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Got invalid format code = " + int164);
                }
            }
        }
        return -1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.InputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0056 A[SYNTHETIC, Splitter:B:27:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0064 A[SYNTHETIC, Splitter:B:32:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0074 A[SYNTHETIC, Splitter:B:38:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0082 A[SYNTHETIC, Splitter:B:43:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyExif(android.content.Context r4, int r5, int r6, android.net.Uri r7, android.net.Uri r8) {
        /*
            java.lang.String r0 = "ImageHeaderParser"
            if (r4 != 0) goto L_0x000a
            java.lang.String r4 = "context is null"
            android.util.Log.d(r0, r4)
            return
        L_0x000a:
            r1 = 0
            android.content.ContentResolver r2 = r4.getContentResolver()     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            java.io.InputStream r7 = r2.openInputStream(r7)     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            m1.a r2 = new m1.a     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            r2.<init>((java.io.InputStream) r7)     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            java.lang.String r3 = "rw"
            android.os.ParcelFileDescriptor r1 = r4.openFileDescriptor(r8, r3)     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            m1.a r4 = new m1.a     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            java.io.FileDescriptor r8 = r1.getFileDescriptor()     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            r4.<init>((java.io.FileDescriptor) r8)     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            copyExifAttributes(r2, r4, r5, r6)     // Catch:{ IOException -> 0x0044, all -> 0x0040 }
            if (r7 == 0) goto L_0x003c
            r7.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x003c
        L_0x0034:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            android.util.Log.d(r0, r5, r4)
        L_0x003c:
            r1.close()     // Catch:{ IOException -> 0x0068 }
            goto L_0x0070
        L_0x0040:
            r4 = move-exception
            r5 = r1
            r1 = r7
            goto L_0x0072
        L_0x0044:
            r4 = move-exception
            r5 = r1
            r1 = r7
            goto L_0x004d
        L_0x0048:
            r4 = move-exception
            r5 = r1
            goto L_0x0072
        L_0x004b:
            r4 = move-exception
            r5 = r1
        L_0x004d:
            java.lang.String r6 = r4.getMessage()     // Catch:{ all -> 0x0071 }
            android.util.Log.d(r0, r6, r4)     // Catch:{ all -> 0x0071 }
            if (r1 == 0) goto L_0x0062
            r1.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x0062
        L_0x005a:
            r4 = move-exception
            java.lang.String r6 = r4.getMessage()
            android.util.Log.d(r0, r6, r4)
        L_0x0062:
            if (r5 == 0) goto L_0x0070
            r5.close()     // Catch:{ IOException -> 0x0068 }
            goto L_0x0070
        L_0x0068:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            android.util.Log.d(r0, r5, r4)
        L_0x0070:
            return
        L_0x0071:
            r4 = move-exception
        L_0x0072:
            if (r1 == 0) goto L_0x0080
            r1.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x0080
        L_0x0078:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()
            android.util.Log.d(r0, r7, r6)
        L_0x0080:
            if (r5 == 0) goto L_0x008e
            r5.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008e
        L_0x0086:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            android.util.Log.d(r0, r6, r5)
        L_0x008e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.ImageHeaderParser.copyExif(android.content.Context, int, int, android.net.Uri, android.net.Uri):void");
    }

    public static void copyExif(Context context, a aVar, int i11, int i12, Uri uri) {
        if (context == null) {
            Log.d(TAG, "context is null");
            return;
        }
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
            copyExifAttributes(aVar, new a(parcelFileDescriptor.getFileDescriptor()), i11, i12);
            try {
                parcelFileDescriptor.close();
            } catch (IOException e11) {
                Log.d(TAG, e11.getMessage(), e11);
            }
        } catch (IOException e12) {
            Log.d(TAG, e12.getMessage());
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
        } catch (Throwable th2) {
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e13) {
                    Log.d(TAG, e13.getMessage(), e13);
                }
            }
            throw th2;
        }
    }
}
