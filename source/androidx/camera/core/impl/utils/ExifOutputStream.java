package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.utils.ExifData;
import androidx.core.util.h;
import com.tencent.android.tpush.common.Constants;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;

public final class ExifOutputStream extends FilterOutputStream {
    private static final short BYTE_ALIGN_II = 18761;
    private static final short BYTE_ALIGN_MM = 19789;
    private static final boolean DEBUG = false;
    private static final byte[] IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(ExifAttribute.ASCII);
    private static final int IFD_OFFSET = 8;
    private static final byte START_CODE = 42;
    private static final int STATE_FRAME_HEADER = 1;
    private static final int STATE_JPEG_DATA = 2;
    private static final int STATE_SOI = 0;
    private static final int STREAMBUFFER_SIZE = 65536;
    private static final String TAG = "ExifOutputStream";
    private final ByteBuffer mBuffer = ByteBuffer.allocate(4);
    private int mByteToCopy;
    private int mByteToSkip;
    private final ExifData mExifData;
    private final byte[] mSingleByteArray = new byte[1];
    private int mState = 0;

    public static final class JpegHeader {
        public static final short APP1 = -31;
        public static final short DAC = -52;
        public static final short DHT = -60;
        public static final short EOI = -39;
        public static final short JPG = -56;
        public static final short SOF0 = -64;
        public static final short SOF15 = -49;
        public static final short SOI = -40;

        private JpegHeader() {
        }

        public static boolean isSofMarker(short s11) {
            return (s11 < -64 || s11 > -49 || s11 == -60 || s11 == -56 || s11 == -52) ? false : true;
        }
    }

    public ExifOutputStream(OutputStream outputStream, ExifData exifData) {
        super(new BufferedOutputStream(outputStream, 65536));
        this.mExifData = exifData;
    }

    private int requestByteToBuffer(int i11, byte[] bArr, int i12, int i13) {
        int min = Math.min(i13, i11 - this.mBuffer.position());
        this.mBuffer.put(bArr, i12, min);
        return min;
    }

    private void writeExifSegment(ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        ExifTag[][] exifTagArr = ExifData.EXIF_TAGS;
        int[] iArr = new int[exifTagArr.length];
        int[] iArr2 = new int[exifTagArr.length];
        for (ExifTag exifTag : ExifData.EXIF_POINTER_TAGS) {
            for (int i11 = 0; i11 < ExifData.EXIF_TAGS.length; i11++) {
                this.mExifData.getAttributes(i11).remove(exifTag.name);
            }
        }
        if (!this.mExifData.getAttributes(1).isEmpty()) {
            this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0, this.mExifData.getByteOrder()));
        }
        if (!this.mExifData.getAttributes(2).isEmpty()) {
            this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0, this.mExifData.getByteOrder()));
        }
        if (!this.mExifData.getAttributes(3).isEmpty()) {
            this.mExifData.getAttributes(1).put(ExifData.EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0, this.mExifData.getByteOrder()));
        }
        for (int i12 = 0; i12 < ExifData.EXIF_TAGS.length; i12++) {
            int i13 = 0;
            for (Map.Entry<String, ExifAttribute> value : this.mExifData.getAttributes(i12).entrySet()) {
                int size = ((ExifAttribute) value.getValue()).size();
                if (size > 4) {
                    i13 += size;
                }
            }
            iArr2[i12] = iArr2[i12] + i13;
        }
        int i14 = 8;
        for (int i15 = 0; i15 < ExifData.EXIF_TAGS.length; i15++) {
            if (!this.mExifData.getAttributes(i15).isEmpty()) {
                iArr[i15] = i14;
                i14 += (this.mExifData.getAttributes(i15).size() * 12) + 2 + 4 + iArr2[i15];
            }
        }
        int i16 = i14 + 8;
        if (!this.mExifData.getAttributes(1).isEmpty()) {
            this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong((long) iArr[1], this.mExifData.getByteOrder()));
        }
        if (!this.mExifData.getAttributes(2).isEmpty()) {
            this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong((long) iArr[2], this.mExifData.getByteOrder()));
        }
        if (!this.mExifData.getAttributes(3).isEmpty()) {
            this.mExifData.getAttributes(1).put(ExifData.EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong((long) iArr[3], this.mExifData.getByteOrder()));
        }
        byteOrderedDataOutputStream.writeUnsignedShort(i16);
        byteOrderedDataOutputStream.write(IDENTIFIER_EXIF_APP1);
        byteOrderedDataOutputStream.writeShort(this.mExifData.getByteOrder() == ByteOrder.BIG_ENDIAN ? BYTE_ALIGN_MM : BYTE_ALIGN_II);
        byteOrderedDataOutputStream.setByteOrder(this.mExifData.getByteOrder());
        byteOrderedDataOutputStream.writeUnsignedShort(42);
        byteOrderedDataOutputStream.writeUnsignedInt(8);
        for (int i17 = 0; i17 < ExifData.EXIF_TAGS.length; i17++) {
            if (!this.mExifData.getAttributes(i17).isEmpty()) {
                byteOrderedDataOutputStream.writeUnsignedShort(this.mExifData.getAttributes(i17).size());
                int size2 = iArr[i17] + 2 + (this.mExifData.getAttributes(i17).size() * 12) + 4;
                for (Map.Entry next : this.mExifData.getAttributes(i17).entrySet()) {
                    int i18 = ((ExifTag) h.h((ExifTag) ExifData.Builder.sExifTagMapsForWriting.get(i17).get(next.getKey()), "Tag not supported: " + ((String) next.getKey()) + ". Tag needs to be ported from ExifInterface to ExifData.")).number;
                    ExifAttribute exifAttribute = (ExifAttribute) next.getValue();
                    int size3 = exifAttribute.size();
                    byteOrderedDataOutputStream.writeUnsignedShort(i18);
                    byteOrderedDataOutputStream.writeUnsignedShort(exifAttribute.format);
                    byteOrderedDataOutputStream.writeInt(exifAttribute.numberOfComponents);
                    if (size3 > 4) {
                        byteOrderedDataOutputStream.writeUnsignedInt((long) size2);
                        size2 += size3;
                    } else {
                        byteOrderedDataOutputStream.write(exifAttribute.bytes);
                        if (size3 < 4) {
                            while (size3 < 4) {
                                byteOrderedDataOutputStream.writeByte(0);
                                size3++;
                            }
                        }
                    }
                }
                byteOrderedDataOutputStream.writeUnsignedInt(0);
                for (Map.Entry<String, ExifAttribute> value2 : this.mExifData.getAttributes(i17).entrySet()) {
                    byte[] bArr = ((ExifAttribute) value2.getValue()).bytes;
                    if (bArr.length > 4) {
                        byteOrderedDataOutputStream.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        byteOrderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        while (true) {
            int i13 = this.mByteToSkip;
            if ((i13 > 0 || this.mByteToCopy > 0 || this.mState != 2) && i12 > 0) {
                if (i13 > 0) {
                    int min = Math.min(i12, i13);
                    i12 -= min;
                    this.mByteToSkip -= min;
                    i11 += min;
                }
                int i14 = this.mByteToCopy;
                if (i14 > 0) {
                    int min2 = Math.min(i12, i14);
                    this.out.write(bArr, i11, min2);
                    i12 -= min2;
                    this.mByteToCopy -= min2;
                    i11 += min2;
                }
                if (i12 != 0) {
                    int i15 = this.mState;
                    if (i15 == 0) {
                        int requestByteToBuffer = requestByteToBuffer(2, bArr, i11, i12);
                        i11 += requestByteToBuffer;
                        i12 -= requestByteToBuffer;
                        if (this.mBuffer.position() >= 2) {
                            this.mBuffer.rewind();
                            if (this.mBuffer.getShort() == -40) {
                                this.out.write(this.mBuffer.array(), 0, 2);
                                this.mState = 1;
                                this.mBuffer.rewind();
                                ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(this.out, ByteOrder.BIG_ENDIAN);
                                byteOrderedDataOutputStream.writeShort(-31);
                                writeExifSegment(byteOrderedDataOutputStream);
                            } else {
                                throw new IOException("Not a valid jpeg image, cannot write exif");
                            }
                        } else {
                            return;
                        }
                    } else if (i15 != 1) {
                        continue;
                    } else {
                        int requestByteToBuffer2 = requestByteToBuffer(4, bArr, i11, i12);
                        i11 += requestByteToBuffer2;
                        i12 -= requestByteToBuffer2;
                        if (this.mBuffer.position() == 2 && this.mBuffer.getShort() == -39) {
                            this.out.write(this.mBuffer.array(), 0, 2);
                            this.mBuffer.rewind();
                        }
                        if (this.mBuffer.position() >= 4) {
                            this.mBuffer.rewind();
                            short s11 = this.mBuffer.getShort();
                            if (s11 == -31) {
                                this.mByteToSkip = (this.mBuffer.getShort() & Constants.PROTOCOL_NONE) - 2;
                                this.mState = 2;
                            } else if (!JpegHeader.isSofMarker(s11)) {
                                this.out.write(this.mBuffer.array(), 0, 4);
                                this.mByteToCopy = (this.mBuffer.getShort() & Constants.PROTOCOL_NONE) - 2;
                            } else {
                                this.out.write(this.mBuffer.array(), 0, 4);
                                this.mState = 2;
                            }
                            this.mBuffer.rewind();
                        } else {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }
        if (i12 > 0) {
            this.out.write(bArr, i11, i12);
        }
    }

    public void write(int i11) throws IOException {
        byte[] bArr = this.mSingleByteArray;
        bArr[0] = (byte) (i11 & 255);
        write(bArr);
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
