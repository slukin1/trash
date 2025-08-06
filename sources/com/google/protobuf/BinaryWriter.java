package com.google.protobuf;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.Utf8;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@CheckReturnValue
abstract class BinaryWriter extends ByteOutput implements Writer {
    public static final int DEFAULT_CHUNK_SIZE = 4096;
    private static final int MAP_KEY_NUMBER = 1;
    private static final int MAP_VALUE_NUMBER = 2;
    private final BufferAllocator alloc;
    public final ArrayDeque<AllocatedBuffer> buffers;
    private final int chunkSize;
    public int totalDoneBytes;

    /* renamed from: com.google.protobuf.BinaryWriter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.WireFormat$FieldType[] r0 = com.google.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.BinaryWriter.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class SafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private int limitMinusOne;
        private int pos;

        public SafeDirectWriter(BufferAllocator bufferAllocator, int i11) {
            super(bufferAllocator, i11, (AnonymousClass1) null);
            nextBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private int spaceLeft() {
            return this.pos + 1;
        }

        private void writeVarint32FiveBytes(int i11) {
            ByteBuffer byteBuffer = this.buffer;
            int i12 = this.pos;
            this.pos = i12 - 1;
            byteBuffer.put(i12, (byte) (i11 >>> 28));
            int i13 = this.pos - 4;
            this.pos = i13;
            this.buffer.putInt(i13 + 1, (i11 & 127) | 128 | ((((i11 >>> 21) & 127) | 128) << 24) | ((((i11 >>> 14) & 127) | 128) << 16) | ((((i11 >>> 7) & 127) | 128) << 8));
        }

        private void writeVarint32FourBytes(int i11) {
            int i12 = this.pos - 4;
            this.pos = i12;
            this.buffer.putInt(i12 + 1, (i11 & 127) | 128 | ((266338304 & i11) << 3) | (((2080768 & i11) | 2097152) << 2) | (((i11 & 16256) | 16384) << 1));
        }

        private void writeVarint32OneByte(int i11) {
            ByteBuffer byteBuffer = this.buffer;
            int i12 = this.pos;
            this.pos = i12 - 1;
            byteBuffer.put(i12, (byte) i11);
        }

        private void writeVarint32ThreeBytes(int i11) {
            int i12 = this.pos - 3;
            this.pos = i12;
            this.buffer.putInt(i12, (((i11 & 127) | 128) << 8) | ((2080768 & i11) << 10) | (((i11 & 16256) | 16384) << 9));
        }

        private void writeVarint32TwoBytes(int i11) {
            int i12 = this.pos - 2;
            this.pos = i12;
            this.buffer.putShort(i12 + 1, (short) ((i11 & 127) | 128 | ((i11 & 16256) << 1)));
        }

        private void writeVarint64EightBytes(long j11) {
            int i11 = this.pos - 8;
            this.pos = i11;
            this.buffer.putLong(i11 + 1, (j11 & 127) | 128 | ((71494644084506624L & j11) << 7) | (((558551906910208L & j11) | 562949953421312L) << 6) | (((4363686772736L & j11) | 4398046511104L) << 5) | (((34091302912L & j11) | 34359738368L) << 4) | (((266338304 & j11) | 268435456) << 3) | (((2080768 & j11) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 2) | (((16256 & j11) | 16384) << 1));
        }

        private void writeVarint64EightBytesWithSign(long j11) {
            int i11 = this.pos - 8;
            this.pos = i11;
            this.buffer.putLong(i11 + 1, (j11 & 127) | 128 | (((71494644084506624L & j11) | 72057594037927936L) << 7) | (((558551906910208L & j11) | 562949953421312L) << 6) | (((4363686772736L & j11) | 4398046511104L) << 5) | (((34091302912L & j11) | 34359738368L) << 4) | (((266338304 & j11) | 268435456) << 3) | (((2080768 & j11) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 2) | (((16256 & j11) | 16384) << 1));
        }

        private void writeVarint64FiveBytes(long j11) {
            int i11 = this.pos - 5;
            this.pos = i11;
            this.buffer.putLong(i11 - 2, (((j11 & 127) | 128) << 24) | ((34091302912L & j11) << 28) | (((266338304 & j11) | 268435456) << 27) | (((2080768 & j11) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 26) | (((16256 & j11) | 16384) << 25));
        }

        private void writeVarint64FourBytes(long j11) {
            writeVarint32FourBytes((int) j11);
        }

        private void writeVarint64NineBytes(long j11) {
            ByteBuffer byteBuffer = this.buffer;
            int i11 = this.pos;
            this.pos = i11 - 1;
            byteBuffer.put(i11, (byte) ((int) (j11 >>> 56)));
            writeVarint64EightBytesWithSign(j11 & 72057594037927935L);
        }

        private void writeVarint64OneByte(long j11) {
            writeVarint32OneByte((int) j11);
        }

        private void writeVarint64SevenBytes(long j11) {
            int i11 = this.pos - 7;
            this.pos = i11;
            this.buffer.putLong(i11, (((j11 & 127) | 128) << 8) | ((558551906910208L & j11) << 14) | (((4363686772736L & j11) | 4398046511104L) << 13) | (((34091302912L & j11) | 34359738368L) << 12) | (((266338304 & j11) | 268435456) << 11) | (((2080768 & j11) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 10) | (((16256 & j11) | 16384) << 9));
        }

        private void writeVarint64SixBytes(long j11) {
            int i11 = this.pos - 6;
            this.pos = i11;
            this.buffer.putLong(i11 - 1, (((j11 & 127) | 128) << 16) | ((4363686772736L & j11) << 21) | (((34091302912L & j11) | 34359738368L) << 20) | (((266338304 & j11) | 268435456) << 19) | (((2080768 & j11) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 18) | (((16256 & j11) | 16384) << 17));
        }

        private void writeVarint64TenBytes(long j11) {
            ByteBuffer byteBuffer = this.buffer;
            int i11 = this.pos;
            this.pos = i11 - 1;
            byteBuffer.put(i11, (byte) ((int) (j11 >>> 63)));
            ByteBuffer byteBuffer2 = this.buffer;
            int i12 = this.pos;
            this.pos = i12 - 1;
            byteBuffer2.put(i12, (byte) ((int) (((j11 >>> 56) & 127) | 128)));
            writeVarint64EightBytesWithSign(j11 & 72057594037927935L);
        }

        private void writeVarint64ThreeBytes(long j11) {
            writeVarint32ThreeBytes((int) j11);
        }

        private void writeVarint64TwoBytes(long j11) {
            writeVarint32TwoBytes((int) j11);
        }

        public void finishCurrentBuffer() {
            if (this.buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                ByteBuffer byteBuffer = (ByteBuffer) this.buffer.position(this.pos + 1);
                this.buffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        public void requireSpace(int i11) {
            if (spaceLeft() < i11) {
                nextBuffer(i11);
            }
        }

        public void write(byte b11) {
            ByteBuffer byteBuffer = this.buffer;
            int i11 = this.pos;
            this.pos = i11 - 1;
            byteBuffer.put(i11, b11);
        }

        public void writeBool(int i11, boolean z11) {
            requireSpace(6);
            write(z11 ? (byte) 1 : 0);
            writeTag(i11, 0);
        }

        public void writeBytes(int i11, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i11, 2);
            } catch (IOException e11) {
                throw new RuntimeException(e11);
            }
        }

        @Deprecated
        public void writeEndGroup(int i11) {
            writeTag(i11, 4);
        }

        public void writeFixed32(int i11, int i12) {
            requireSpace(9);
            writeFixed32(i12);
            writeTag(i11, 5);
        }

        public void writeFixed64(int i11, long j11) {
            requireSpace(13);
            writeFixed64(j11);
            writeTag(i11, 1);
        }

        @Deprecated
        public void writeGroup(int i11, Object obj) throws IOException {
            writeTag(i11, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i11, 3);
        }

        public void writeInt32(int i11, int i12) {
            requireSpace(15);
            writeInt32(i12);
            writeTag(i11, 0);
        }

        public void writeLazy(byte[] bArr, int i11, int i12) {
            if (spaceLeft() < i12) {
                this.totalDoneBytes += i12;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i11, i12));
                nextBuffer();
                return;
            }
            int i13 = this.pos - i12;
            this.pos = i13;
            ByteBuffer byteBuffer = (ByteBuffer) this.buffer.position(i13 + 1);
            this.buffer.put(bArr, i11, i12);
        }

        public void writeMessage(int i11, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
        }

        public void writeSInt32(int i11, int i12) {
            requireSpace(10);
            writeSInt32(i12);
            writeTag(i11, 0);
        }

        public void writeSInt64(int i11, long j11) {
            requireSpace(15);
            writeSInt64(j11);
            writeTag(i11, 0);
        }

        @Deprecated
        public void writeStartGroup(int i11) {
            writeTag(i11, 3);
        }

        public void writeString(int i11, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
        }

        public void writeTag(int i11, int i12) {
            writeVarint32(WireFormat.makeTag(i11, i12));
        }

        public void writeUInt32(int i11, int i12) {
            requireSpace(10);
            writeVarint32(i12);
            writeTag(i11, 0);
        }

        public void writeUInt64(int i11, long j11) {
            requireSpace(15);
            writeVarint64(j11);
            writeTag(i11, 0);
        }

        public void writeVarint32(int i11) {
            if ((i11 & -128) == 0) {
                writeVarint32OneByte(i11);
            } else if ((i11 & -16384) == 0) {
                writeVarint32TwoBytes(i11);
            } else if ((-2097152 & i11) == 0) {
                writeVarint32ThreeBytes(i11);
            } else if ((-268435456 & i11) == 0) {
                writeVarint32FourBytes(i11);
            } else {
                writeVarint32FiveBytes(i11);
            }
        }

        public void writeVarint64(long j11) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j11)) {
                case 1:
                    writeVarint64OneByte(j11);
                    return;
                case 2:
                    writeVarint64TwoBytes(j11);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j11);
                    return;
                case 4:
                    writeVarint64FourBytes(j11);
                    return;
                case 5:
                    writeVarint64FiveBytes(j11);
                    return;
                case 6:
                    writeVarint64SixBytes(j11);
                    return;
                case 7:
                    writeVarint64SevenBytes(j11);
                    return;
                case 8:
                    writeVarint64EightBytes(j11);
                    return;
                case 9:
                    writeVarint64NineBytes(j11);
                    return;
                case 10:
                    writeVarint64TenBytes(j11);
                    return;
                default:
                    return;
            }
        }

        private void nextBuffer(int i11) {
            nextBuffer(newDirectBuffer(i11));
        }

        public void write(byte[] bArr, int i11, int i12) {
            if (spaceLeft() < i12) {
                nextBuffer(i12);
            }
            int i13 = this.pos - i12;
            this.pos = i13;
            ByteBuffer byteBuffer = (ByteBuffer) this.buffer.position(i13 + 1);
            this.buffer.put(bArr, i11, i12);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer()) {
                ByteBuffer nioBuffer = allocatedBuffer.nioBuffer();
                if (nioBuffer.isDirect()) {
                    finishCurrentBuffer();
                    this.buffers.addFirst(allocatedBuffer);
                    this.buffer = nioBuffer;
                    ByteBuffer byteBuffer = (ByteBuffer) nioBuffer.limit(nioBuffer.capacity());
                    ByteBuffer byteBuffer2 = (ByteBuffer) this.buffer.position(0);
                    this.buffer.order(ByteOrder.LITTLE_ENDIAN);
                    int limit = this.buffer.limit() - 1;
                    this.limitMinusOne = limit;
                    this.pos = limit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        public void writeBool(boolean z11) {
            write(z11 ? (byte) 1 : 0);
        }

        public void writeFixed32(int i11) {
            int i12 = this.pos - 4;
            this.pos = i12;
            this.buffer.putInt(i12 + 1, i11);
        }

        public void writeFixed64(long j11) {
            int i11 = this.pos - 8;
            this.pos = i11;
            this.buffer.putLong(i11 + 1, j11);
        }

        public void writeGroup(int i11, Object obj, Schema schema) throws IOException {
            writeTag(i11, 4);
            schema.writeTo(obj, this);
            writeTag(i11, 3);
        }

        public void writeInt32(int i11) {
            if (i11 >= 0) {
                writeVarint32(i11);
            } else {
                writeVarint64((long) i11);
            }
        }

        public void writeSInt32(int i11) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i11));
        }

        public void writeSInt64(long j11) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j11));
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            int i11 = this.pos - remaining;
            this.pos = i11;
            ByteBuffer byteBuffer2 = (ByteBuffer) this.buffer.position(i11 + 1);
            this.buffer.put(byteBuffer);
        }

        public void writeMessage(int i11, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
        }

        public void writeString(String str) {
            int i11;
            int i12;
            int i13;
            char charAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.pos -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.buffer.put(this.pos + length, (byte) charAt);
                length--;
            }
            if (length == -1) {
                this.pos--;
                return;
            }
            this.pos += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128 && (i13 = this.pos) >= 0) {
                    ByteBuffer byteBuffer = this.buffer;
                    this.pos = i13 - 1;
                    byteBuffer.put(i13, (byte) charAt2);
                } else if (charAt2 < 2048 && (i12 = this.pos) > 0) {
                    ByteBuffer byteBuffer2 = this.buffer;
                    this.pos = i12 - 1;
                    byteBuffer2.put(i12, (byte) ((charAt2 & '?') | 128));
                    ByteBuffer byteBuffer3 = this.buffer;
                    int i14 = this.pos;
                    this.pos = i14 - 1;
                    byteBuffer3.put(i14, (byte) ((charAt2 >>> 6) | 960));
                } else if ((charAt2 < 55296 || 57343 < charAt2) && (i11 = this.pos) > 1) {
                    ByteBuffer byteBuffer4 = this.buffer;
                    this.pos = i11 - 1;
                    byteBuffer4.put(i11, (byte) ((charAt2 & '?') | 128));
                    ByteBuffer byteBuffer5 = this.buffer;
                    int i15 = this.pos;
                    this.pos = i15 - 1;
                    byteBuffer5.put(i15, (byte) (((charAt2 >>> 6) & 63) | 128));
                    ByteBuffer byteBuffer6 = this.buffer;
                    int i16 = this.pos;
                    this.pos = i16 - 1;
                    byteBuffer6.put(i16, (byte) ((charAt2 >>> 12) | TXVodDownloadDataSource.QUALITY_480P));
                } else if (this.pos > 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            ByteBuffer byteBuffer7 = this.buffer;
                            int i17 = this.pos;
                            this.pos = i17 - 1;
                            byteBuffer7.put(i17, (byte) ((codePoint & 63) | 128));
                            ByteBuffer byteBuffer8 = this.buffer;
                            int i18 = this.pos;
                            this.pos = i18 - 1;
                            byteBuffer8.put(i18, (byte) (((codePoint >>> 6) & 63) | 128));
                            ByteBuffer byteBuffer9 = this.buffer;
                            int i19 = this.pos;
                            this.pos = i19 - 1;
                            byteBuffer9.put(i19, (byte) (((codePoint >>> 12) & 63) | 128));
                            ByteBuffer byteBuffer10 = this.buffer;
                            int i21 = this.pos;
                            this.pos = i21 - 1;
                            byteBuffer10.put(i21, (byte) ((codePoint >>> 18) | 240));
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                } else {
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
                return;
            }
            int i11 = this.pos - remaining;
            this.pos = i11;
            ByteBuffer byteBuffer2 = (ByteBuffer) this.buffer.position(i11 + 1);
            this.buffer.put(byteBuffer);
        }
    }

    public static final class SafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private int limit;
        private int limitMinusOne;
        private int offset;
        private int offsetMinusOne;
        private int pos;

        public SafeHeapWriter(BufferAllocator bufferAllocator, int i11) {
            super(bufferAllocator, i11, (AnonymousClass1) null);
            nextBuffer();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void writeVarint32FiveBytes(int i11) {
            byte[] bArr = this.buffer;
            int i12 = this.pos;
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) (i11 >>> 28);
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) (((i11 >>> 21) & 127) | 128);
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) (((i11 >>> 14) & 127) | 128);
            int i16 = i15 - 1;
            this.pos = i16;
            bArr[i15] = (byte) (((i11 >>> 7) & 127) | 128);
            this.pos = i16 - 1;
            bArr[i16] = (byte) ((i11 & 127) | 128);
        }

        private void writeVarint32FourBytes(int i11) {
            byte[] bArr = this.buffer;
            int i12 = this.pos;
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) (i11 >>> 21);
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) (((i11 >>> 14) & 127) | 128);
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) (((i11 >>> 7) & 127) | 128);
            this.pos = i15 - 1;
            bArr[i15] = (byte) ((i11 & 127) | 128);
        }

        private void writeVarint32OneByte(int i11) {
            byte[] bArr = this.buffer;
            int i12 = this.pos;
            this.pos = i12 - 1;
            bArr[i12] = (byte) i11;
        }

        private void writeVarint32ThreeBytes(int i11) {
            byte[] bArr = this.buffer;
            int i12 = this.pos;
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) (i11 >>> 14);
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) (((i11 >>> 7) & 127) | 128);
            this.pos = i14 - 1;
            bArr[i14] = (byte) ((i11 & 127) | 128);
        }

        private void writeVarint32TwoBytes(int i11) {
            byte[] bArr = this.buffer;
            int i12 = this.pos;
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) (i11 >>> 7);
            this.pos = i13 - 1;
            bArr[i13] = (byte) ((i11 & 127) | 128);
        }

        private void writeVarint64EightBytes(long j11) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) ((int) (j11 >>> 49));
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) ((int) (((j11 >>> 42) & 127) | 128));
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) ((int) (((j11 >>> 35) & 127) | 128));
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) ((int) (((j11 >>> 28) & 127) | 128));
            int i16 = i15 - 1;
            this.pos = i16;
            bArr[i15] = (byte) ((int) (((j11 >>> 21) & 127) | 128));
            int i17 = i16 - 1;
            this.pos = i17;
            bArr[i16] = (byte) ((int) (((j11 >>> 14) & 127) | 128));
            int i18 = i17 - 1;
            this.pos = i18;
            bArr[i17] = (byte) ((int) (((j11 >>> 7) & 127) | 128));
            this.pos = i18 - 1;
            bArr[i18] = (byte) ((int) ((j11 & 127) | 128));
        }

        private void writeVarint64FiveBytes(long j11) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) ((int) (j11 >>> 28));
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) ((int) (((j11 >>> 21) & 127) | 128));
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) ((int) (((j11 >>> 14) & 127) | 128));
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) ((int) (((j11 >>> 7) & 127) | 128));
            this.pos = i15 - 1;
            bArr[i15] = (byte) ((int) ((j11 & 127) | 128));
        }

        private void writeVarint64FourBytes(long j11) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) ((int) (j11 >>> 21));
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) ((int) (((j11 >>> 14) & 127) | 128));
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) ((int) (((j11 >>> 7) & 127) | 128));
            this.pos = i14 - 1;
            bArr[i14] = (byte) ((int) ((j11 & 127) | 128));
        }

        private void writeVarint64NineBytes(long j11) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) ((int) (j11 >>> 56));
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) ((int) (((j11 >>> 49) & 127) | 128));
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) ((int) (((j11 >>> 42) & 127) | 128));
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) ((int) (((j11 >>> 35) & 127) | 128));
            int i16 = i15 - 1;
            this.pos = i16;
            bArr[i15] = (byte) ((int) (((j11 >>> 28) & 127) | 128));
            int i17 = i16 - 1;
            this.pos = i17;
            bArr[i16] = (byte) ((int) (((j11 >>> 21) & 127) | 128));
            int i18 = i17 - 1;
            this.pos = i18;
            bArr[i17] = (byte) ((int) (((j11 >>> 14) & 127) | 128));
            int i19 = i18 - 1;
            this.pos = i19;
            bArr[i18] = (byte) ((int) (((j11 >>> 7) & 127) | 128));
            this.pos = i19 - 1;
            bArr[i19] = (byte) ((int) ((j11 & 127) | 128));
        }

        private void writeVarint64OneByte(long j11) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            this.pos = i11 - 1;
            bArr[i11] = (byte) ((int) j11);
        }

        private void writeVarint64SevenBytes(long j11) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) ((int) (j11 >>> 42));
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) ((int) (((j11 >>> 35) & 127) | 128));
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) ((int) (((j11 >>> 28) & 127) | 128));
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) ((int) (((j11 >>> 21) & 127) | 128));
            int i16 = i15 - 1;
            this.pos = i16;
            bArr[i15] = (byte) ((int) (((j11 >>> 14) & 127) | 128));
            int i17 = i16 - 1;
            this.pos = i17;
            bArr[i16] = (byte) ((int) (((j11 >>> 7) & 127) | 128));
            this.pos = i17 - 1;
            bArr[i17] = (byte) ((int) ((j11 & 127) | 128));
        }

        private void writeVarint64SixBytes(long j11) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) ((int) (j11 >>> 35));
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) ((int) (((j11 >>> 28) & 127) | 128));
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) ((int) (((j11 >>> 21) & 127) | 128));
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) ((int) (((j11 >>> 14) & 127) | 128));
            int i16 = i15 - 1;
            this.pos = i16;
            bArr[i15] = (byte) ((int) (((j11 >>> 7) & 127) | 128));
            this.pos = i16 - 1;
            bArr[i16] = (byte) ((int) ((j11 & 127) | 128));
        }

        private void writeVarint64TenBytes(long j11) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) ((int) (j11 >>> 63));
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) ((int) (((j11 >>> 56) & 127) | 128));
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) ((int) (((j11 >>> 49) & 127) | 128));
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) ((int) (((j11 >>> 42) & 127) | 128));
            int i16 = i15 - 1;
            this.pos = i16;
            bArr[i15] = (byte) ((int) (((j11 >>> 35) & 127) | 128));
            int i17 = i16 - 1;
            this.pos = i17;
            bArr[i16] = (byte) ((int) (((j11 >>> 28) & 127) | 128));
            int i18 = i17 - 1;
            this.pos = i18;
            bArr[i17] = (byte) ((int) (((j11 >>> 21) & 127) | 128));
            int i19 = i18 - 1;
            this.pos = i19;
            bArr[i18] = (byte) ((int) (((j11 >>> 14) & 127) | 128));
            int i21 = i19 - 1;
            this.pos = i21;
            bArr[i19] = (byte) ((int) (((j11 >>> 7) & 127) | 128));
            this.pos = i21 - 1;
            bArr[i21] = (byte) ((int) ((j11 & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long j11) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) (((int) j11) >>> 14);
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) ((int) (((j11 >>> 7) & 127) | 128));
            this.pos = i13 - 1;
            bArr[i13] = (byte) ((int) ((j11 & 127) | 128));
        }

        private void writeVarint64TwoBytes(long j11) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) ((int) (j11 >>> 7));
            this.pos = i12 - 1;
            bArr[i12] = (byte) ((((int) j11) & 127) | 128);
        }

        public int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        public void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                AllocatedBuffer allocatedBuffer2 = this.allocatedBuffer;
                allocatedBuffer2.position((this.pos - allocatedBuffer2.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        public void requireSpace(int i11) {
            if (spaceLeft() < i11) {
                nextBuffer(i11);
            }
        }

        public int spaceLeft() {
            return this.pos - this.offsetMinusOne;
        }

        public void write(byte b11) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            this.pos = i11 - 1;
            bArr[i11] = b11;
        }

        public void writeBool(int i11, boolean z11) throws IOException {
            requireSpace(6);
            write(z11 ? (byte) 1 : 0);
            writeTag(i11, 0);
        }

        public void writeBytes(int i11, ByteString byteString) throws IOException {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i11, 2);
            } catch (IOException e11) {
                throw new RuntimeException(e11);
            }
        }

        public void writeEndGroup(int i11) {
            writeTag(i11, 4);
        }

        public void writeFixed32(int i11, int i12) throws IOException {
            requireSpace(9);
            writeFixed32(i12);
            writeTag(i11, 5);
        }

        public void writeFixed64(int i11, long j11) throws IOException {
            requireSpace(13);
            writeFixed64(j11);
            writeTag(i11, 1);
        }

        @Deprecated
        public void writeGroup(int i11, Object obj) throws IOException {
            writeTag(i11, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i11, 3);
        }

        public void writeInt32(int i11, int i12) throws IOException {
            requireSpace(15);
            writeInt32(i12);
            writeTag(i11, 0);
        }

        public void writeLazy(byte[] bArr, int i11, int i12) {
            if (spaceLeft() < i12) {
                this.totalDoneBytes += i12;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i11, i12));
                nextBuffer();
                return;
            }
            int i13 = this.pos - i12;
            this.pos = i13;
            System.arraycopy(bArr, i11, this.buffer, i13 + 1, i12);
        }

        public void writeMessage(int i11, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
        }

        public void writeSInt32(int i11, int i12) throws IOException {
            requireSpace(10);
            writeSInt32(i12);
            writeTag(i11, 0);
        }

        public void writeSInt64(int i11, long j11) throws IOException {
            requireSpace(15);
            writeSInt64(j11);
            writeTag(i11, 0);
        }

        public void writeStartGroup(int i11) {
            writeTag(i11, 3);
        }

        public void writeString(int i11, String str) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
        }

        public void writeTag(int i11, int i12) {
            writeVarint32(WireFormat.makeTag(i11, i12));
        }

        public void writeUInt32(int i11, int i12) throws IOException {
            requireSpace(10);
            writeVarint32(i12);
            writeTag(i11, 0);
        }

        public void writeUInt64(int i11, long j11) throws IOException {
            requireSpace(15);
            writeVarint64(j11);
            writeTag(i11, 0);
        }

        public void writeVarint32(int i11) {
            if ((i11 & -128) == 0) {
                writeVarint32OneByte(i11);
            } else if ((i11 & -16384) == 0) {
                writeVarint32TwoBytes(i11);
            } else if ((-2097152 & i11) == 0) {
                writeVarint32ThreeBytes(i11);
            } else if ((-268435456 & i11) == 0) {
                writeVarint32FourBytes(i11);
            } else {
                writeVarint32FiveBytes(i11);
            }
        }

        public void writeVarint64(long j11) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j11)) {
                case 1:
                    writeVarint64OneByte(j11);
                    return;
                case 2:
                    writeVarint64TwoBytes(j11);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j11);
                    return;
                case 4:
                    writeVarint64FourBytes(j11);
                    return;
                case 5:
                    writeVarint64FiveBytes(j11);
                    return;
                case 6:
                    writeVarint64SixBytes(j11);
                    return;
                case 7:
                    writeVarint64SevenBytes(j11);
                    return;
                case 8:
                    writeVarint64EightBytes(j11);
                    return;
                case 9:
                    writeVarint64NineBytes(j11);
                    return;
                case 10:
                    writeVarint64TenBytes(j11);
                    return;
                default:
                    return;
            }
        }

        private void nextBuffer(int i11) {
            nextBuffer(newHeapBuffer(i11));
        }

        public void write(byte[] bArr, int i11, int i12) {
            if (spaceLeft() < i12) {
                nextBuffer(i12);
            }
            int i13 = this.pos - i12;
            this.pos = i13;
            System.arraycopy(bArr, i11, this.buffer, i13 + 1, i12);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer2) {
            if (allocatedBuffer2.hasArray()) {
                finishCurrentBuffer();
                this.buffers.addFirst(allocatedBuffer2);
                this.allocatedBuffer = allocatedBuffer2;
                this.buffer = allocatedBuffer2.array();
                int arrayOffset = allocatedBuffer2.arrayOffset();
                this.limit = allocatedBuffer2.limit() + arrayOffset;
                int position = arrayOffset + allocatedBuffer2.position();
                this.offset = position;
                this.offsetMinusOne = position - 1;
                int i11 = this.limit - 1;
                this.limitMinusOne = i11;
                this.pos = i11;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        public void writeBool(boolean z11) {
            write(z11 ? (byte) 1 : 0);
        }

        public void writeFixed32(int i11) {
            byte[] bArr = this.buffer;
            int i12 = this.pos;
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) ((i11 >> 24) & 255);
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) ((i11 >> 16) & 255);
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) ((i11 >> 8) & 255);
            this.pos = i15 - 1;
            bArr[i15] = (byte) (i11 & 255);
        }

        public void writeFixed64(long j11) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) (((int) (j11 >> 56)) & 255);
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) (((int) (j11 >> 48)) & 255);
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) (((int) (j11 >> 40)) & 255);
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) (((int) (j11 >> 32)) & 255);
            int i16 = i15 - 1;
            this.pos = i16;
            bArr[i15] = (byte) (((int) (j11 >> 24)) & 255);
            int i17 = i16 - 1;
            this.pos = i17;
            bArr[i16] = (byte) (((int) (j11 >> 16)) & 255);
            int i18 = i17 - 1;
            this.pos = i18;
            bArr[i17] = (byte) (((int) (j11 >> 8)) & 255);
            this.pos = i18 - 1;
            bArr[i18] = (byte) (((int) j11) & 255);
        }

        public void writeGroup(int i11, Object obj, Schema schema) throws IOException {
            writeTag(i11, 4);
            schema.writeTo(obj, this);
            writeTag(i11, 3);
        }

        public void writeInt32(int i11) {
            if (i11 >= 0) {
                writeVarint32(i11);
            } else {
                writeVarint64((long) i11);
            }
        }

        public void writeSInt32(int i11) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i11));
        }

        public void writeSInt64(long j11) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j11));
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            int i11 = this.pos - remaining;
            this.pos = i11;
            byteBuffer.get(this.buffer, i11 + 1, remaining);
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            }
            int i11 = this.pos - remaining;
            this.pos = i11;
            byteBuffer.get(this.buffer, i11 + 1, remaining);
        }

        public void writeMessage(int i11, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
        }

        public void writeString(String str) {
            int i11;
            int i12;
            int i13;
            char charAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.pos -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.buffer[this.pos + length] = (byte) charAt;
                length--;
            }
            if (length == -1) {
                this.pos--;
                return;
            }
            this.pos += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128 && (i13 = this.pos) > this.offsetMinusOne) {
                    byte[] bArr = this.buffer;
                    this.pos = i13 - 1;
                    bArr[i13] = (byte) charAt2;
                } else if (charAt2 < 2048 && (i12 = this.pos) > this.offset) {
                    byte[] bArr2 = this.buffer;
                    int i14 = i12 - 1;
                    this.pos = i14;
                    bArr2[i12] = (byte) ((charAt2 & '?') | 128);
                    this.pos = i14 - 1;
                    bArr2[i14] = (byte) ((charAt2 >>> 6) | 960);
                } else if ((charAt2 < 55296 || 57343 < charAt2) && (i11 = this.pos) > this.offset + 1) {
                    byte[] bArr3 = this.buffer;
                    int i15 = i11 - 1;
                    this.pos = i15;
                    bArr3[i11] = (byte) ((charAt2 & '?') | 128);
                    int i16 = i15 - 1;
                    this.pos = i16;
                    bArr3[i15] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    this.pos = i16 - 1;
                    bArr3[i16] = (byte) ((charAt2 >>> 12) | TXVodDownloadDataSource.QUALITY_480P);
                } else if (this.pos > this.offset + 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            byte[] bArr4 = this.buffer;
                            int i17 = this.pos;
                            int i18 = i17 - 1;
                            this.pos = i18;
                            bArr4[i17] = (byte) ((codePoint & 63) | 128);
                            int i19 = i18 - 1;
                            this.pos = i19;
                            bArr4[i18] = (byte) (((codePoint >>> 6) & 63) | 128);
                            int i21 = i19 - 1;
                            this.pos = i21;
                            bArr4[i19] = (byte) (((codePoint >>> 12) & 63) | 128);
                            this.pos = i21 - 1;
                            bArr4[i21] = (byte) ((codePoint >>> 18) | 240);
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                } else {
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }
    }

    public static final class UnsafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private long bufferOffset;
        private long limitMinusOne;
        private long pos;

        public UnsafeDirectWriter(BufferAllocator bufferAllocator, int i11) {
            super(bufferAllocator, i11, (AnonymousClass1) null);
            nextBuffer();
        }

        private int bufferPos() {
            return (int) (this.pos - this.bufferOffset);
        }

        private int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        /* access modifiers changed from: private */
        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private int spaceLeft() {
            return bufferPos() + 1;
        }

        private void writeVarint32FiveBytes(int i11) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (i11 >>> 28));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((i11 >>> 21) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((i11 >>> 14) & 127) | 128));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) (((i11 >>> 7) & 127) | 128));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) ((i11 & 127) | 128));
        }

        private void writeVarint32FourBytes(int i11) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (i11 >>> 21));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((i11 >>> 14) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((i11 >>> 7) & 127) | 128));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) ((i11 & 127) | 128));
        }

        private void writeVarint32OneByte(int i11) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) i11);
        }

        private void writeVarint32ThreeBytes(int i11) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (i11 >>> 14));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((i11 >>> 7) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((i11 & 127) | 128));
        }

        private void writeVarint32TwoBytes(int i11) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (i11 >>> 7));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((i11 & 127) | 128));
        }

        private void writeVarint64EightBytes(long j11) {
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((int) (j11 >>> 49)));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((int) (((j11 >>> 42) & 127) | 128)));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) ((int) (((j11 >>> 35) & 127) | 128)));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) ((int) (((j11 >>> 28) & 127) | 128)));
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(j16, (byte) ((int) (((j11 >>> 21) & 127) | 128)));
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(j17, (byte) ((int) (((j11 >>> 14) & 127) | 128)));
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(j18, (byte) ((int) (((j11 >>> 7) & 127) | 128)));
            long j19 = this.pos;
            this.pos = j19 - 1;
            UnsafeUtil.putByte(j19, (byte) ((int) ((j11 & 127) | 128)));
        }

        private void writeVarint64FiveBytes(long j11) {
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((int) (j11 >>> 28)));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((int) (((j11 >>> 21) & 127) | 128)));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) ((int) (((j11 >>> 14) & 127) | 128)));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) ((int) (((j11 >>> 7) & 127) | 128)));
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(j16, (byte) ((int) ((j11 & 127) | 128)));
        }

        private void writeVarint64FourBytes(long j11) {
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((int) (j11 >>> 21)));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((int) (((j11 >>> 14) & 127) | 128)));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) ((int) (((j11 >>> 7) & 127) | 128)));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) ((int) ((j11 & 127) | 128)));
        }

        private void writeVarint64NineBytes(long j11) {
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((int) (j11 >>> 56)));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((int) (((j11 >>> 49) & 127) | 128)));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) ((int) (((j11 >>> 42) & 127) | 128)));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) ((int) (((j11 >>> 35) & 127) | 128)));
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(j16, (byte) ((int) (((j11 >>> 28) & 127) | 128)));
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(j17, (byte) ((int) (((j11 >>> 21) & 127) | 128)));
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(j18, (byte) ((int) (((j11 >>> 14) & 127) | 128)));
            long j19 = this.pos;
            this.pos = j19 - 1;
            UnsafeUtil.putByte(j19, (byte) ((int) (((j11 >>> 7) & 127) | 128)));
            long j21 = this.pos;
            this.pos = j21 - 1;
            UnsafeUtil.putByte(j21, (byte) ((int) ((j11 & 127) | 128)));
        }

        private void writeVarint64OneByte(long j11) {
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((int) j11));
        }

        private void writeVarint64SevenBytes(long j11) {
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((int) (j11 >>> 42)));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((int) (((j11 >>> 35) & 127) | 128)));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) ((int) (((j11 >>> 28) & 127) | 128)));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) ((int) (((j11 >>> 21) & 127) | 128)));
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(j16, (byte) ((int) (((j11 >>> 14) & 127) | 128)));
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(j17, (byte) ((int) (((j11 >>> 7) & 127) | 128)));
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(j18, (byte) ((int) ((j11 & 127) | 128)));
        }

        private void writeVarint64SixBytes(long j11) {
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((int) (j11 >>> 35)));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((int) (((j11 >>> 28) & 127) | 128)));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) ((int) (((j11 >>> 21) & 127) | 128)));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) ((int) (((j11 >>> 14) & 127) | 128)));
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(j16, (byte) ((int) (((j11 >>> 7) & 127) | 128)));
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(j17, (byte) ((int) ((j11 & 127) | 128)));
        }

        private void writeVarint64TenBytes(long j11) {
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((int) (j11 >>> 63)));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((int) (((j11 >>> 56) & 127) | 128)));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) ((int) (((j11 >>> 49) & 127) | 128)));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) ((int) (((j11 >>> 42) & 127) | 128)));
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(j16, (byte) ((int) (((j11 >>> 35) & 127) | 128)));
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(j17, (byte) ((int) (((j11 >>> 28) & 127) | 128)));
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(j18, (byte) ((int) (((j11 >>> 21) & 127) | 128)));
            long j19 = this.pos;
            this.pos = j19 - 1;
            UnsafeUtil.putByte(j19, (byte) ((int) (((j11 >>> 14) & 127) | 128)));
            long j21 = this.pos;
            this.pos = j21 - 1;
            UnsafeUtil.putByte(j21, (byte) ((int) (((j11 >>> 7) & 127) | 128)));
            long j22 = this.pos;
            this.pos = j22 - 1;
            UnsafeUtil.putByte(j22, (byte) ((int) ((j11 & 127) | 128)));
        }

        private void writeVarint64ThreeBytes(long j11) {
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((int) j11) >>> 14));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((int) (((j11 >>> 7) & 127) | 128)));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) ((int) ((j11 & 127) | 128)));
        }

        private void writeVarint64TwoBytes(long j11) {
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((int) (j11 >>> 7)));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((((int) j11) & 127) | 128));
        }

        public void finishCurrentBuffer() {
            if (this.buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                ByteBuffer byteBuffer = (ByteBuffer) this.buffer.position(bufferPos() + 1);
                this.buffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        public void requireSpace(int i11) {
            if (spaceLeft() < i11) {
                nextBuffer(i11);
            }
        }

        public void write(byte b11) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, b11);
        }

        public void writeBool(int i11, boolean z11) {
            requireSpace(6);
            write(z11 ? (byte) 1 : 0);
            writeTag(i11, 0);
        }

        public void writeBytes(int i11, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i11, 2);
            } catch (IOException e11) {
                throw new RuntimeException(e11);
            }
        }

        @Deprecated
        public void writeEndGroup(int i11) {
            writeTag(i11, 4);
        }

        public void writeFixed32(int i11, int i12) {
            requireSpace(9);
            writeFixed32(i12);
            writeTag(i11, 5);
        }

        public void writeFixed64(int i11, long j11) {
            requireSpace(13);
            writeFixed64(j11);
            writeTag(i11, 1);
        }

        public void writeGroup(int i11, Object obj) throws IOException {
            writeTag(i11, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i11, 3);
        }

        public void writeInt32(int i11, int i12) {
            requireSpace(15);
            writeInt32(i12);
            writeTag(i11, 0);
        }

        public void writeLazy(byte[] bArr, int i11, int i12) {
            if (spaceLeft() < i12) {
                this.totalDoneBytes += i12;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i11, i12));
                nextBuffer();
                return;
            }
            this.pos -= (long) i12;
            ByteBuffer byteBuffer = (ByteBuffer) this.buffer.position(bufferPos() + 1);
            this.buffer.put(bArr, i11, i12);
        }

        public void writeMessage(int i11, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
        }

        public void writeSInt32(int i11, int i12) {
            requireSpace(10);
            writeSInt32(i12);
            writeTag(i11, 0);
        }

        public void writeSInt64(int i11, long j11) {
            requireSpace(15);
            writeSInt64(j11);
            writeTag(i11, 0);
        }

        @Deprecated
        public void writeStartGroup(int i11) {
            writeTag(i11, 3);
        }

        public void writeString(int i11, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
        }

        public void writeTag(int i11, int i12) {
            writeVarint32(WireFormat.makeTag(i11, i12));
        }

        public void writeUInt32(int i11, int i12) {
            requireSpace(10);
            writeVarint32(i12);
            writeTag(i11, 0);
        }

        public void writeUInt64(int i11, long j11) {
            requireSpace(15);
            writeVarint64(j11);
            writeTag(i11, 0);
        }

        public void writeVarint32(int i11) {
            if ((i11 & -128) == 0) {
                writeVarint32OneByte(i11);
            } else if ((i11 & -16384) == 0) {
                writeVarint32TwoBytes(i11);
            } else if ((-2097152 & i11) == 0) {
                writeVarint32ThreeBytes(i11);
            } else if ((-268435456 & i11) == 0) {
                writeVarint32FourBytes(i11);
            } else {
                writeVarint32FiveBytes(i11);
            }
        }

        public void writeVarint64(long j11) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j11)) {
                case 1:
                    writeVarint64OneByte(j11);
                    return;
                case 2:
                    writeVarint64TwoBytes(j11);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j11);
                    return;
                case 4:
                    writeVarint64FourBytes(j11);
                    return;
                case 5:
                    writeVarint64FiveBytes(j11);
                    return;
                case 6:
                    writeVarint64SixBytes(j11);
                    return;
                case 7:
                    writeVarint64SevenBytes(j11);
                    return;
                case 8:
                    writeVarint64EightBytes(j11);
                    return;
                case 9:
                    writeVarint64NineBytes(j11);
                    return;
                case 10:
                    writeVarint64TenBytes(j11);
                    return;
                default:
                    return;
            }
        }

        private void nextBuffer(int i11) {
            nextBuffer(newDirectBuffer(i11));
        }

        public void write(byte[] bArr, int i11, int i12) {
            if (spaceLeft() < i12) {
                nextBuffer(i12);
            }
            this.pos -= (long) i12;
            ByteBuffer byteBuffer = (ByteBuffer) this.buffer.position(bufferPos() + 1);
            this.buffer.put(bArr, i11, i12);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer()) {
                ByteBuffer nioBuffer = allocatedBuffer.nioBuffer();
                if (nioBuffer.isDirect()) {
                    finishCurrentBuffer();
                    this.buffers.addFirst(allocatedBuffer);
                    this.buffer = nioBuffer;
                    ByteBuffer byteBuffer = (ByteBuffer) nioBuffer.limit(nioBuffer.capacity());
                    ByteBuffer byteBuffer2 = (ByteBuffer) this.buffer.position(0);
                    long addressOffset = UnsafeUtil.addressOffset(this.buffer);
                    this.bufferOffset = addressOffset;
                    long limit = addressOffset + ((long) (this.buffer.limit() - 1));
                    this.limitMinusOne = limit;
                    this.pos = limit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        public void writeBool(boolean z11) {
            write(z11 ? (byte) 1 : 0);
        }

        public void writeFixed32(int i11) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) ((i11 >> 24) & 255));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((i11 >> 16) & 255));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((i11 >> 8) & 255));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) (i11 & 255));
        }

        public void writeFixed64(long j11) {
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((int) (j11 >> 56)) & 255));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((int) (j11 >> 48)) & 255));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) (((int) (j11 >> 40)) & 255));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) (((int) (j11 >> 32)) & 255));
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(j16, (byte) (((int) (j11 >> 24)) & 255));
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(j17, (byte) (((int) (j11 >> 16)) & 255));
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(j18, (byte) (((int) (j11 >> 8)) & 255));
            long j19 = this.pos;
            this.pos = j19 - 1;
            UnsafeUtil.putByte(j19, (byte) (((int) j11) & 255));
        }

        public void writeGroup(int i11, Object obj, Schema schema) throws IOException {
            writeTag(i11, 4);
            schema.writeTo(obj, this);
            writeTag(i11, 3);
        }

        public void writeInt32(int i11) {
            if (i11 >= 0) {
                writeVarint32(i11);
            } else {
                writeVarint64((long) i11);
            }
        }

        public void writeSInt32(int i11) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i11));
        }

        public void writeSInt64(long j11) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j11));
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            this.pos -= (long) remaining;
            ByteBuffer byteBuffer2 = (ByteBuffer) this.buffer.position(bufferPos() + 1);
            this.buffer.put(byteBuffer);
        }

        public void writeMessage(int i11, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
        }

        public void writeString(String str) {
            char charAt;
            requireSpace(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length >= 0 && (charAt = str.charAt(length)) < 128) {
                    long j11 = this.pos;
                    this.pos = j11 - 1;
                    UnsafeUtil.putByte(j11, (byte) charAt);
                }
            }
            if (length != -1) {
                while (length >= 0) {
                    char charAt2 = str.charAt(length);
                    if (charAt2 < 128) {
                        long j12 = this.pos;
                        if (j12 >= this.bufferOffset) {
                            this.pos = j12 - 1;
                            UnsafeUtil.putByte(j12, (byte) charAt2);
                            length--;
                        }
                    }
                    if (charAt2 < 2048) {
                        long j13 = this.pos;
                        if (j13 > this.bufferOffset) {
                            this.pos = j13 - 1;
                            UnsafeUtil.putByte(j13, (byte) ((charAt2 & '?') | 128));
                            long j14 = this.pos;
                            this.pos = j14 - 1;
                            UnsafeUtil.putByte(j14, (byte) ((charAt2 >>> 6) | 960));
                            length--;
                        }
                    }
                    if (charAt2 < 55296 || 57343 < charAt2) {
                        long j15 = this.pos;
                        if (j15 > this.bufferOffset + 1) {
                            this.pos = j15 - 1;
                            UnsafeUtil.putByte(j15, (byte) ((charAt2 & '?') | 128));
                            long j16 = this.pos;
                            this.pos = j16 - 1;
                            UnsafeUtil.putByte(j16, (byte) (((charAt2 >>> 6) & 63) | 128));
                            long j17 = this.pos;
                            this.pos = j17 - 1;
                            UnsafeUtil.putByte(j17, (byte) ((charAt2 >>> 12) | TXVodDownloadDataSource.QUALITY_480P));
                            length--;
                        }
                    }
                    if (this.pos > this.bufferOffset + 2) {
                        if (length != 0) {
                            char charAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(charAt3, charAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(charAt3, charAt2);
                                long j18 = this.pos;
                                this.pos = j18 - 1;
                                UnsafeUtil.putByte(j18, (byte) ((codePoint & 63) | 128));
                                long j19 = this.pos;
                                this.pos = j19 - 1;
                                UnsafeUtil.putByte(j19, (byte) (((codePoint >>> 6) & 63) | 128));
                                long j21 = this.pos;
                                this.pos = j21 - 1;
                                UnsafeUtil.putByte(j21, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j22 = this.pos;
                                this.pos = j22 - 1;
                                UnsafeUtil.putByte(j22, (byte) ((codePoint >>> 18) | 240));
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                    length--;
                }
            }
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
                return;
            }
            this.pos -= (long) remaining;
            ByteBuffer byteBuffer2 = (ByteBuffer) this.buffer.position(bufferPos() + 1);
            this.buffer.put(byteBuffer);
        }
    }

    public static final class UnsafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private long limit;
        private long limitMinusOne;
        private long offset;
        private long offsetMinusOne;
        private long pos;

        public UnsafeHeapWriter(BufferAllocator bufferAllocator, int i11) {
            super(bufferAllocator, i11, (AnonymousClass1) null);
            nextBuffer();
        }

        private int arrayPos() {
            return (int) this.pos;
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeArrayOperations();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void writeVarint32FiveBytes(int i11) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) (i11 >>> 28));
            byte[] bArr2 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr2, j12, (byte) (((i11 >>> 21) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr3, j13, (byte) (((i11 >>> 14) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr4, j14, (byte) (((i11 >>> 7) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr5, j15, (byte) ((i11 & 127) | 128));
        }

        private void writeVarint32FourBytes(int i11) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) (i11 >>> 21));
            byte[] bArr2 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr2, j12, (byte) (((i11 >>> 14) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr3, j13, (byte) (((i11 >>> 7) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr4, j14, (byte) ((i11 & 127) | 128));
        }

        private void writeVarint32OneByte(int i11) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) i11);
        }

        private void writeVarint32ThreeBytes(int i11) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) (i11 >>> 14));
            byte[] bArr2 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr2, j12, (byte) (((i11 >>> 7) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr3, j13, (byte) ((i11 & 127) | 128));
        }

        private void writeVarint32TwoBytes(int i11) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) (i11 >>> 7));
            byte[] bArr2 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr2, j12, (byte) ((i11 & 127) | 128));
        }

        private void writeVarint64EightBytes(long j11) {
            byte[] bArr = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr, j12, (byte) ((int) (j11 >>> 49)));
            byte[] bArr2 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr2, j13, (byte) ((int) (((j11 >>> 42) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr3, j14, (byte) ((int) (((j11 >>> 35) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr4, j15, (byte) ((int) (((j11 >>> 28) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(bArr5, j16, (byte) ((int) (((j11 >>> 21) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(bArr6, j17, (byte) ((int) (((j11 >>> 14) & 127) | 128)));
            byte[] bArr7 = this.buffer;
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(bArr7, j18, (byte) ((int) (((j11 >>> 7) & 127) | 128)));
            byte[] bArr8 = this.buffer;
            long j19 = this.pos;
            this.pos = j19 - 1;
            UnsafeUtil.putByte(bArr8, j19, (byte) ((int) ((j11 & 127) | 128)));
        }

        private void writeVarint64FiveBytes(long j11) {
            byte[] bArr = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr, j12, (byte) ((int) (j11 >>> 28)));
            byte[] bArr2 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr2, j13, (byte) ((int) (((j11 >>> 21) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr3, j14, (byte) ((int) (((j11 >>> 14) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr4, j15, (byte) ((int) (((j11 >>> 7) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(bArr5, j16, (byte) ((int) ((j11 & 127) | 128)));
        }

        private void writeVarint64FourBytes(long j11) {
            byte[] bArr = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr, j12, (byte) ((int) (j11 >>> 21)));
            byte[] bArr2 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr2, j13, (byte) ((int) (((j11 >>> 14) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr3, j14, (byte) ((int) (((j11 >>> 7) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr4, j15, (byte) ((int) ((j11 & 127) | 128)));
        }

        private void writeVarint64NineBytes(long j11) {
            byte[] bArr = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr, j12, (byte) ((int) (j11 >>> 56)));
            byte[] bArr2 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr2, j13, (byte) ((int) (((j11 >>> 49) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr3, j14, (byte) ((int) (((j11 >>> 42) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr4, j15, (byte) ((int) (((j11 >>> 35) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(bArr5, j16, (byte) ((int) (((j11 >>> 28) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(bArr6, j17, (byte) ((int) (((j11 >>> 21) & 127) | 128)));
            byte[] bArr7 = this.buffer;
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(bArr7, j18, (byte) ((int) (((j11 >>> 14) & 127) | 128)));
            byte[] bArr8 = this.buffer;
            long j19 = this.pos;
            this.pos = j19 - 1;
            UnsafeUtil.putByte(bArr8, j19, (byte) ((int) (((j11 >>> 7) & 127) | 128)));
            byte[] bArr9 = this.buffer;
            long j21 = this.pos;
            this.pos = j21 - 1;
            UnsafeUtil.putByte(bArr9, j21, (byte) ((int) ((j11 & 127) | 128)));
        }

        private void writeVarint64OneByte(long j11) {
            byte[] bArr = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr, j12, (byte) ((int) j11));
        }

        private void writeVarint64SevenBytes(long j11) {
            byte[] bArr = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr, j12, (byte) ((int) (j11 >>> 42)));
            byte[] bArr2 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr2, j13, (byte) ((int) (((j11 >>> 35) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr3, j14, (byte) ((int) (((j11 >>> 28) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr4, j15, (byte) ((int) (((j11 >>> 21) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(bArr5, j16, (byte) ((int) (((j11 >>> 14) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(bArr6, j17, (byte) ((int) (((j11 >>> 7) & 127) | 128)));
            byte[] bArr7 = this.buffer;
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(bArr7, j18, (byte) ((int) ((j11 & 127) | 128)));
        }

        private void writeVarint64SixBytes(long j11) {
            byte[] bArr = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr, j12, (byte) ((int) (j11 >>> 35)));
            byte[] bArr2 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr2, j13, (byte) ((int) (((j11 >>> 28) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr3, j14, (byte) ((int) (((j11 >>> 21) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr4, j15, (byte) ((int) (((j11 >>> 14) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(bArr5, j16, (byte) ((int) (((j11 >>> 7) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(bArr6, j17, (byte) ((int) ((j11 & 127) | 128)));
        }

        private void writeVarint64TenBytes(long j11) {
            byte[] bArr = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr, j12, (byte) ((int) (j11 >>> 63)));
            byte[] bArr2 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr2, j13, (byte) ((int) (((j11 >>> 56) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr3, j14, (byte) ((int) (((j11 >>> 49) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr4, j15, (byte) ((int) (((j11 >>> 42) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(bArr5, j16, (byte) ((int) (((j11 >>> 35) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(bArr6, j17, (byte) ((int) (((j11 >>> 28) & 127) | 128)));
            byte[] bArr7 = this.buffer;
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(bArr7, j18, (byte) ((int) (((j11 >>> 21) & 127) | 128)));
            byte[] bArr8 = this.buffer;
            long j19 = this.pos;
            this.pos = j19 - 1;
            UnsafeUtil.putByte(bArr8, j19, (byte) ((int) (((j11 >>> 14) & 127) | 128)));
            byte[] bArr9 = this.buffer;
            long j21 = this.pos;
            this.pos = j21 - 1;
            UnsafeUtil.putByte(bArr9, j21, (byte) ((int) (((j11 >>> 7) & 127) | 128)));
            byte[] bArr10 = this.buffer;
            long j22 = this.pos;
            this.pos = j22 - 1;
            UnsafeUtil.putByte(bArr10, j22, (byte) ((int) ((j11 & 127) | 128)));
        }

        private void writeVarint64ThreeBytes(long j11) {
            byte[] bArr = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr, j12, (byte) (((int) j11) >>> 14));
            byte[] bArr2 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr2, j13, (byte) ((int) (((j11 >>> 7) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr3, j14, (byte) ((int) ((j11 & 127) | 128)));
        }

        private void writeVarint64TwoBytes(long j11) {
            byte[] bArr = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr, j12, (byte) ((int) (j11 >>> 7)));
            byte[] bArr2 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr2, j13, (byte) ((((int) j11) & 127) | 128));
        }

        public int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        public void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.allocatedBuffer.position((arrayPos() - this.allocatedBuffer.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        public void requireSpace(int i11) {
            if (spaceLeft() < i11) {
                nextBuffer(i11);
            }
        }

        public int spaceLeft() {
            return (int) (this.pos - this.offsetMinusOne);
        }

        public void write(byte b11) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, b11);
        }

        public void writeBool(int i11, boolean z11) {
            requireSpace(6);
            write(z11 ? (byte) 1 : 0);
            writeTag(i11, 0);
        }

        public void writeBytes(int i11, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i11, 2);
            } catch (IOException e11) {
                throw new RuntimeException(e11);
            }
        }

        public void writeEndGroup(int i11) {
            writeTag(i11, 4);
        }

        public void writeFixed32(int i11, int i12) {
            requireSpace(9);
            writeFixed32(i12);
            writeTag(i11, 5);
        }

        public void writeFixed64(int i11, long j11) {
            requireSpace(13);
            writeFixed64(j11);
            writeTag(i11, 1);
        }

        public void writeGroup(int i11, Object obj) throws IOException {
            writeTag(i11, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i11, 3);
        }

        public void writeInt32(int i11, int i12) {
            requireSpace(15);
            writeInt32(i12);
            writeTag(i11, 0);
        }

        public void writeLazy(byte[] bArr, int i11, int i12) {
            if (i11 < 0 || i11 + i12 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)}));
            } else if (spaceLeft() < i12) {
                this.totalDoneBytes += i12;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i11, i12));
                nextBuffer();
            } else {
                this.pos -= (long) i12;
                System.arraycopy(bArr, i11, this.buffer, arrayPos() + 1, i12);
            }
        }

        public void writeMessage(int i11, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
        }

        public void writeSInt32(int i11, int i12) {
            requireSpace(10);
            writeSInt32(i12);
            writeTag(i11, 0);
        }

        public void writeSInt64(int i11, long j11) {
            requireSpace(15);
            writeSInt64(j11);
            writeTag(i11, 0);
        }

        public void writeStartGroup(int i11) {
            writeTag(i11, 3);
        }

        public void writeString(int i11, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
        }

        public void writeTag(int i11, int i12) {
            writeVarint32(WireFormat.makeTag(i11, i12));
        }

        public void writeUInt32(int i11, int i12) {
            requireSpace(10);
            writeVarint32(i12);
            writeTag(i11, 0);
        }

        public void writeUInt64(int i11, long j11) {
            requireSpace(15);
            writeVarint64(j11);
            writeTag(i11, 0);
        }

        public void writeVarint32(int i11) {
            if ((i11 & -128) == 0) {
                writeVarint32OneByte(i11);
            } else if ((i11 & -16384) == 0) {
                writeVarint32TwoBytes(i11);
            } else if ((-2097152 & i11) == 0) {
                writeVarint32ThreeBytes(i11);
            } else if ((-268435456 & i11) == 0) {
                writeVarint32FourBytes(i11);
            } else {
                writeVarint32FiveBytes(i11);
            }
        }

        public void writeVarint64(long j11) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j11)) {
                case 1:
                    writeVarint64OneByte(j11);
                    return;
                case 2:
                    writeVarint64TwoBytes(j11);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j11);
                    return;
                case 4:
                    writeVarint64FourBytes(j11);
                    return;
                case 5:
                    writeVarint64FiveBytes(j11);
                    return;
                case 6:
                    writeVarint64SixBytes(j11);
                    return;
                case 7:
                    writeVarint64SevenBytes(j11);
                    return;
                case 8:
                    writeVarint64EightBytes(j11);
                    return;
                case 9:
                    writeVarint64NineBytes(j11);
                    return;
                case 10:
                    writeVarint64TenBytes(j11);
                    return;
                default:
                    return;
            }
        }

        private void nextBuffer(int i11) {
            nextBuffer(newHeapBuffer(i11));
        }

        public void write(byte[] bArr, int i11, int i12) {
            if (i11 < 0 || i11 + i12 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)}));
            }
            requireSpace(i12);
            this.pos -= (long) i12;
            System.arraycopy(bArr, i11, this.buffer, arrayPos() + 1, i12);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer2) {
            if (allocatedBuffer2.hasArray()) {
                finishCurrentBuffer();
                this.buffers.addFirst(allocatedBuffer2);
                this.allocatedBuffer = allocatedBuffer2;
                this.buffer = allocatedBuffer2.array();
                long arrayOffset = (long) allocatedBuffer2.arrayOffset();
                this.limit = ((long) allocatedBuffer2.limit()) + arrayOffset;
                long position = arrayOffset + ((long) allocatedBuffer2.position());
                this.offset = position;
                this.offsetMinusOne = position - 1;
                long j11 = this.limit - 1;
                this.limitMinusOne = j11;
                this.pos = j11;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        public void writeBool(boolean z11) {
            write(z11 ? (byte) 1 : 0);
        }

        public void writeFixed32(int i11) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) ((i11 >> 24) & 255));
            byte[] bArr2 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr2, j12, (byte) ((i11 >> 16) & 255));
            byte[] bArr3 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr3, j13, (byte) ((i11 >> 8) & 255));
            byte[] bArr4 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr4, j14, (byte) (i11 & 255));
        }

        public void writeFixed64(long j11) {
            byte[] bArr = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr, j12, (byte) (((int) (j11 >> 56)) & 255));
            byte[] bArr2 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr2, j13, (byte) (((int) (j11 >> 48)) & 255));
            byte[] bArr3 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr3, j14, (byte) (((int) (j11 >> 40)) & 255));
            byte[] bArr4 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr4, j15, (byte) (((int) (j11 >> 32)) & 255));
            byte[] bArr5 = this.buffer;
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(bArr5, j16, (byte) (((int) (j11 >> 24)) & 255));
            byte[] bArr6 = this.buffer;
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(bArr6, j17, (byte) (((int) (j11 >> 16)) & 255));
            byte[] bArr7 = this.buffer;
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(bArr7, j18, (byte) (((int) (j11 >> 8)) & 255));
            byte[] bArr8 = this.buffer;
            long j19 = this.pos;
            this.pos = j19 - 1;
            UnsafeUtil.putByte(bArr8, j19, (byte) (((int) j11) & 255));
        }

        public void writeGroup(int i11, Object obj, Schema schema) throws IOException {
            writeTag(i11, 4);
            schema.writeTo(obj, this);
            writeTag(i11, 3);
        }

        public void writeInt32(int i11) {
            if (i11 >= 0) {
                writeVarint32(i11);
            } else {
                writeVarint64((long) i11);
            }
        }

        public void writeSInt32(int i11) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i11));
        }

        public void writeSInt64(long j11) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j11));
        }

        public void writeMessage(int i11, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
        }

        public void writeString(String str) {
            char charAt;
            requireSpace(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length >= 0 && (charAt = str.charAt(length)) < 128) {
                    byte[] bArr = this.buffer;
                    long j11 = this.pos;
                    this.pos = j11 - 1;
                    UnsafeUtil.putByte(bArr, j11, (byte) charAt);
                }
            }
            if (length != -1) {
                while (length >= 0) {
                    char charAt2 = str.charAt(length);
                    if (charAt2 < 128) {
                        long j12 = this.pos;
                        if (j12 > this.offsetMinusOne) {
                            byte[] bArr2 = this.buffer;
                            this.pos = j12 - 1;
                            UnsafeUtil.putByte(bArr2, j12, (byte) charAt2);
                            length--;
                        }
                    }
                    if (charAt2 < 2048) {
                        long j13 = this.pos;
                        if (j13 > this.offset) {
                            byte[] bArr3 = this.buffer;
                            this.pos = j13 - 1;
                            UnsafeUtil.putByte(bArr3, j13, (byte) ((charAt2 & '?') | 128));
                            byte[] bArr4 = this.buffer;
                            long j14 = this.pos;
                            this.pos = j14 - 1;
                            UnsafeUtil.putByte(bArr4, j14, (byte) ((charAt2 >>> 6) | 960));
                            length--;
                        }
                    }
                    if (charAt2 < 55296 || 57343 < charAt2) {
                        long j15 = this.pos;
                        if (j15 > this.offset + 1) {
                            byte[] bArr5 = this.buffer;
                            this.pos = j15 - 1;
                            UnsafeUtil.putByte(bArr5, j15, (byte) ((charAt2 & '?') | 128));
                            byte[] bArr6 = this.buffer;
                            long j16 = this.pos;
                            this.pos = j16 - 1;
                            UnsafeUtil.putByte(bArr6, j16, (byte) (((charAt2 >>> 6) & 63) | 128));
                            byte[] bArr7 = this.buffer;
                            long j17 = this.pos;
                            this.pos = j17 - 1;
                            UnsafeUtil.putByte(bArr7, j17, (byte) ((charAt2 >>> 12) | TXVodDownloadDataSource.QUALITY_480P));
                            length--;
                        }
                    }
                    if (this.pos > this.offset + 2) {
                        if (length != 0) {
                            char charAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(charAt3, charAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(charAt3, charAt2);
                                byte[] bArr8 = this.buffer;
                                long j18 = this.pos;
                                this.pos = j18 - 1;
                                UnsafeUtil.putByte(bArr8, j18, (byte) ((codePoint & 63) | 128));
                                byte[] bArr9 = this.buffer;
                                long j19 = this.pos;
                                this.pos = j19 - 1;
                                UnsafeUtil.putByte(bArr9, j19, (byte) (((codePoint >>> 6) & 63) | 128));
                                byte[] bArr10 = this.buffer;
                                long j21 = this.pos;
                                this.pos = j21 - 1;
                                UnsafeUtil.putByte(bArr10, j21, (byte) (((codePoint >>> 12) & 63) | 128));
                                byte[] bArr11 = this.buffer;
                                long j22 = this.pos;
                                this.pos = j22 - 1;
                                UnsafeUtil.putByte(bArr11, j22, (byte) ((codePoint >>> 18) | 240));
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                    length--;
                }
            }
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            requireSpace(remaining);
            this.pos -= (long) remaining;
            byteBuffer.get(this.buffer, arrayPos() + 1, remaining);
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            }
            this.pos -= (long) remaining;
            byteBuffer.get(this.buffer, arrayPos() + 1, remaining);
        }
    }

    public /* synthetic */ BinaryWriter(BufferAllocator bufferAllocator, int i11, AnonymousClass1 r32) {
        this(bufferAllocator, i11);
    }

    /* access modifiers changed from: private */
    public static byte computeUInt64SizeNoTag(long j11) {
        byte b11;
        if ((-128 & j11) == 0) {
            return 1;
        }
        if (j11 < 0) {
            return 10;
        }
        if ((-34359738368L & j11) != 0) {
            b11 = (byte) 6;
            j11 >>>= 28;
        } else {
            b11 = 2;
        }
        if ((-2097152 & j11) != 0) {
            b11 = (byte) (b11 + 2);
            j11 >>>= 14;
        }
        return (j11 & -16384) != 0 ? (byte) (b11 + 1) : b11;
    }

    public static boolean isUnsafeDirectSupported() {
        return UnsafeDirectWriter.isSupported();
    }

    public static boolean isUnsafeHeapSupported() {
        return UnsafeHeapWriter.isSupported();
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator) {
        return newDirectInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator) {
        return newHeapInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newSafeDirectInstance(BufferAllocator bufferAllocator, int i11) {
        return new SafeDirectWriter(bufferAllocator, i11);
    }

    public static BinaryWriter newSafeHeapInstance(BufferAllocator bufferAllocator, int i11) {
        return new SafeHeapWriter(bufferAllocator, i11);
    }

    public static BinaryWriter newUnsafeDirectInstance(BufferAllocator bufferAllocator, int i11) {
        if (isUnsafeDirectSupported()) {
            return new UnsafeDirectWriter(bufferAllocator, i11);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    public static BinaryWriter newUnsafeHeapInstance(BufferAllocator bufferAllocator, int i11) {
        if (isUnsafeHeapSupported()) {
            return new UnsafeHeapWriter(bufferAllocator, i11);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    private final void writeBoolList_Internal(int i11, List<Boolean> list, boolean z11) throws IOException {
        if (z11) {
            requireSpace(list.size() + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeBool(list.get(size).booleanValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeBool(i11, list.get(size2).booleanValue());
        }
    }

    private final void writeDoubleList_Internal(int i11, List<Double> list, boolean z11) throws IOException {
        if (z11) {
            requireSpace((list.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed64(Double.doubleToRawLongBits(list.get(size).doubleValue()));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeDouble(i11, list.get(size2).doubleValue());
        }
    }

    private final void writeFixed32List_Internal(int i11, List<Integer> list, boolean z11) throws IOException {
        if (z11) {
            requireSpace((list.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed32(i11, list.get(size2).intValue());
        }
    }

    private final void writeFixed64List_Internal(int i11, List<Long> list, boolean z11) throws IOException {
        if (z11) {
            requireSpace((list.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed64(i11, list.get(size2).longValue());
        }
    }

    private final void writeFloatList_Internal(int i11, List<Float> list, boolean z11) throws IOException {
        if (z11) {
            requireSpace((list.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed32(Float.floatToRawIntBits(list.get(size).floatValue()));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFloat(i11, list.get(size2).floatValue());
        }
    }

    private final void writeInt32List_Internal(int i11, List<Integer> list, boolean z11) throws IOException {
        if (z11) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeInt32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeInt32(i11, list.get(size2).intValue());
        }
    }

    private void writeLazyString(int i11, Object obj) throws IOException {
        if (obj instanceof String) {
            writeString(i11, (String) obj);
        } else {
            writeBytes(i11, (ByteString) obj);
        }
    }

    public static final void writeMapEntryField(Writer writer, int i11, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                writer.writeBool(i11, ((Boolean) obj).booleanValue());
                return;
            case 2:
                writer.writeFixed32(i11, ((Integer) obj).intValue());
                return;
            case 3:
                writer.writeFixed64(i11, ((Long) obj).longValue());
                return;
            case 4:
                writer.writeInt32(i11, ((Integer) obj).intValue());
                return;
            case 5:
                writer.writeInt64(i11, ((Long) obj).longValue());
                return;
            case 6:
                writer.writeSFixed32(i11, ((Integer) obj).intValue());
                return;
            case 7:
                writer.writeSFixed64(i11, ((Long) obj).longValue());
                return;
            case 8:
                writer.writeSInt32(i11, ((Integer) obj).intValue());
                return;
            case 9:
                writer.writeSInt64(i11, ((Long) obj).longValue());
                return;
            case 10:
                writer.writeString(i11, (String) obj);
                return;
            case 11:
                writer.writeUInt32(i11, ((Integer) obj).intValue());
                return;
            case 12:
                writer.writeUInt64(i11, ((Long) obj).longValue());
                return;
            case 13:
                writer.writeFloat(i11, ((Float) obj).floatValue());
                return;
            case 14:
                writer.writeDouble(i11, ((Double) obj).doubleValue());
                return;
            case 15:
                writer.writeMessage(i11, obj);
                return;
            case 16:
                writer.writeBytes(i11, (ByteString) obj);
                return;
            case 17:
                if (obj instanceof Internal.EnumLite) {
                    writer.writeEnum(i11, ((Internal.EnumLite) obj).getNumber());
                    return;
                } else if (obj instanceof Integer) {
                    writer.writeEnum(i11, ((Integer) obj).intValue());
                    return;
                } else {
                    throw new IllegalArgumentException("Unexpected type for enum in map.");
                }
            default:
                throw new IllegalArgumentException("Unsupported map value type for: " + fieldType);
        }
    }

    private final void writeSInt32List_Internal(int i11, List<Integer> list, boolean z11) throws IOException {
        if (z11) {
            requireSpace((list.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt32(i11, list.get(size2).intValue());
        }
    }

    private final void writeSInt64List_Internal(int i11, List<Long> list, boolean z11) throws IOException {
        if (z11) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt64(i11, list.get(size2).longValue());
        }
    }

    private final void writeUInt32List_Internal(int i11, List<Integer> list, boolean z11) throws IOException {
        if (z11) {
            requireSpace((list.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeVarint32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeUInt32(i11, list.get(size2).intValue());
        }
    }

    private final void writeUInt64List_Internal(int i11, List<Long> list, boolean z11) throws IOException {
        if (z11) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeVarint64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeUInt64(i11, list.get(size2).longValue());
        }
    }

    @CanIgnoreReturnValue
    public final Queue<AllocatedBuffer> complete() {
        finishCurrentBuffer();
        return this.buffers;
    }

    public final Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.DESCENDING;
    }

    public abstract void finishCurrentBuffer();

    public abstract int getTotalBytesWritten();

    public final AllocatedBuffer newDirectBuffer() {
        return this.alloc.allocateDirectBuffer(this.chunkSize);
    }

    public final AllocatedBuffer newHeapBuffer() {
        return this.alloc.allocateHeapBuffer(this.chunkSize);
    }

    public abstract void requireSpace(int i11);

    public abstract void writeBool(boolean z11);

    public final void writeBoolList(int i11, List<Boolean> list, boolean z11) throws IOException {
        if (list instanceof BooleanArrayList) {
            writeBoolList_Internal(i11, (BooleanArrayList) list, z11);
        } else {
            writeBoolList_Internal(i11, list, z11);
        }
    }

    public final void writeBytesList(int i11, List<ByteString> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeBytes(i11, list.get(size));
        }
    }

    public final void writeDouble(int i11, double d11) throws IOException {
        writeFixed64(i11, Double.doubleToRawLongBits(d11));
    }

    public final void writeDoubleList(int i11, List<Double> list, boolean z11) throws IOException {
        if (list instanceof DoubleArrayList) {
            writeDoubleList_Internal(i11, (DoubleArrayList) list, z11);
        } else {
            writeDoubleList_Internal(i11, list, z11);
        }
    }

    public final void writeEnum(int i11, int i12) throws IOException {
        writeInt32(i11, i12);
    }

    public final void writeEnumList(int i11, List<Integer> list, boolean z11) throws IOException {
        writeInt32List(i11, list, z11);
    }

    public abstract void writeFixed32(int i11);

    public final void writeFixed32List(int i11, List<Integer> list, boolean z11) throws IOException {
        if (list instanceof IntArrayList) {
            writeFixed32List_Internal(i11, (IntArrayList) list, z11);
        } else {
            writeFixed32List_Internal(i11, list, z11);
        }
    }

    public abstract void writeFixed64(long j11);

    public final void writeFixed64List(int i11, List<Long> list, boolean z11) throws IOException {
        if (list instanceof LongArrayList) {
            writeFixed64List_Internal(i11, (LongArrayList) list, z11);
        } else {
            writeFixed64List_Internal(i11, list, z11);
        }
    }

    public final void writeFloat(int i11, float f11) throws IOException {
        writeFixed32(i11, Float.floatToRawIntBits(f11));
    }

    public final void writeFloatList(int i11, List<Float> list, boolean z11) throws IOException {
        if (list instanceof FloatArrayList) {
            writeFloatList_Internal(i11, (FloatArrayList) list, z11);
        } else {
            writeFloatList_Internal(i11, list, z11);
        }
    }

    @Deprecated
    public final void writeGroupList(int i11, List<?> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(i11, list.get(size));
        }
    }

    public abstract void writeInt32(int i11);

    public final void writeInt32List(int i11, List<Integer> list, boolean z11) throws IOException {
        if (list instanceof IntArrayList) {
            writeInt32List_Internal(i11, (IntArrayList) list, z11);
        } else {
            writeInt32List_Internal(i11, list, z11);
        }
    }

    public final void writeInt64(int i11, long j11) throws IOException {
        writeUInt64(i11, j11);
    }

    public final void writeInt64List(int i11, List<Long> list, boolean z11) throws IOException {
        writeUInt64List(i11, list, z11);
    }

    public <K, V> void writeMap(int i11, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            int totalBytesWritten = getTotalBytesWritten();
            writeMapEntryField(this, 2, metadata.valueType, next.getValue());
            writeMapEntryField(this, 1, metadata.keyType, next.getKey());
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
        }
    }

    public final void writeMessageList(int i11, List<?> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(i11, list.get(size));
        }
    }

    public final void writeMessageSetItem(int i11, Object obj) throws IOException {
        writeTag(1, 4);
        if (obj instanceof ByteString) {
            writeBytes(3, (ByteString) obj);
        } else {
            writeMessage(3, obj);
        }
        writeUInt32(2, i11);
        writeTag(1, 3);
    }

    public final void writeSFixed32(int i11, int i12) throws IOException {
        writeFixed32(i11, i12);
    }

    public final void writeSFixed32List(int i11, List<Integer> list, boolean z11) throws IOException {
        writeFixed32List(i11, list, z11);
    }

    public final void writeSFixed64(int i11, long j11) throws IOException {
        writeFixed64(i11, j11);
    }

    public final void writeSFixed64List(int i11, List<Long> list, boolean z11) throws IOException {
        writeFixed64List(i11, list, z11);
    }

    public abstract void writeSInt32(int i11);

    public final void writeSInt32List(int i11, List<Integer> list, boolean z11) throws IOException {
        if (list instanceof IntArrayList) {
            writeSInt32List_Internal(i11, (IntArrayList) list, z11);
        } else {
            writeSInt32List_Internal(i11, list, z11);
        }
    }

    public abstract void writeSInt64(long j11);

    public final void writeSInt64List(int i11, List<Long> list, boolean z11) throws IOException {
        if (list instanceof LongArrayList) {
            writeSInt64List_Internal(i11, (LongArrayList) list, z11);
        } else {
            writeSInt64List_Internal(i11, list, z11);
        }
    }

    public abstract void writeString(String str);

    public final void writeStringList(int i11, List<String> list) throws IOException {
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            for (int size = list.size() - 1; size >= 0; size--) {
                writeLazyString(i11, lazyStringList.getRaw(size));
            }
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeString(i11, list.get(size2));
        }
    }

    public abstract void writeTag(int i11, int i12);

    public final void writeUInt32List(int i11, List<Integer> list, boolean z11) throws IOException {
        if (list instanceof IntArrayList) {
            writeUInt32List_Internal(i11, (IntArrayList) list, z11);
        } else {
            writeUInt32List_Internal(i11, list, z11);
        }
    }

    public final void writeUInt64List(int i11, List<Long> list, boolean z11) throws IOException {
        if (list instanceof LongArrayList) {
            writeUInt64List_Internal(i11, (LongArrayList) list, z11);
        } else {
            writeUInt64List_Internal(i11, list, z11);
        }
    }

    public abstract void writeVarint32(int i11);

    public abstract void writeVarint64(long j11);

    private BinaryWriter(BufferAllocator bufferAllocator, int i11) {
        this.buffers = new ArrayDeque<>(4);
        if (i11 > 0) {
            this.alloc = (BufferAllocator) Internal.checkNotNull(bufferAllocator, "alloc");
            this.chunkSize = i11;
            return;
        }
        throw new IllegalArgumentException("chunkSize must be > 0");
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator, int i11) {
        if (isUnsafeDirectSupported()) {
            return newUnsafeDirectInstance(bufferAllocator, i11);
        }
        return newSafeDirectInstance(bufferAllocator, i11);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator, int i11) {
        if (isUnsafeHeapSupported()) {
            return newUnsafeHeapInstance(bufferAllocator, i11);
        }
        return newSafeHeapInstance(bufferAllocator, i11);
    }

    public final AllocatedBuffer newDirectBuffer(int i11) {
        return this.alloc.allocateDirectBuffer(Math.max(i11, this.chunkSize));
    }

    public final AllocatedBuffer newHeapBuffer(int i11) {
        return this.alloc.allocateHeapBuffer(Math.max(i11, this.chunkSize));
    }

    @Deprecated
    public final void writeGroupList(int i11, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(i11, list.get(size), schema);
        }
    }

    public final void writeMessageList(int i11, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(i11, list.get(size), schema);
        }
    }

    private final void writeBoolList_Internal(int i11, BooleanArrayList booleanArrayList, boolean z11) throws IOException {
        if (z11) {
            requireSpace(booleanArrayList.size() + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = booleanArrayList.size() - 1; size >= 0; size--) {
                writeBool(booleanArrayList.getBoolean(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = booleanArrayList.size() - 1; size2 >= 0; size2--) {
            writeBool(i11, booleanArrayList.getBoolean(size2));
        }
    }

    private final void writeDoubleList_Internal(int i11, DoubleArrayList doubleArrayList, boolean z11) throws IOException {
        if (z11) {
            requireSpace((doubleArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = doubleArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(Double.doubleToRawLongBits(doubleArrayList.getDouble(size)));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = doubleArrayList.size() - 1; size2 >= 0; size2--) {
            writeDouble(i11, doubleArrayList.getDouble(size2));
        }
    }

    private final void writeFixed32List_Internal(int i11, IntArrayList intArrayList, boolean z11) throws IOException {
        if (z11) {
            requireSpace((intArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed32(i11, intArrayList.getInt(size2));
        }
    }

    private final void writeFixed64List_Internal(int i11, LongArrayList longArrayList, boolean z11) throws IOException {
        if (z11) {
            requireSpace((longArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed64(i11, longArrayList.getLong(size2));
        }
    }

    private final void writeFloatList_Internal(int i11, FloatArrayList floatArrayList, boolean z11) throws IOException {
        if (z11) {
            requireSpace((floatArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = floatArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(Float.floatToRawIntBits(floatArrayList.getFloat(size)));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = floatArrayList.size() - 1; size2 >= 0; size2--) {
            writeFloat(i11, floatArrayList.getFloat(size2));
        }
    }

    private final void writeInt32List_Internal(int i11, IntArrayList intArrayList, boolean z11) throws IOException {
        if (z11) {
            requireSpace((intArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeInt32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeInt32(i11, intArrayList.getInt(size2));
        }
    }

    private final void writeSInt32List_Internal(int i11, IntArrayList intArrayList, boolean z11) throws IOException {
        if (z11) {
            requireSpace((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeSInt32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt32(i11, intArrayList.getInt(size2));
        }
    }

    private final void writeSInt64List_Internal(int i11, LongArrayList longArrayList, boolean z11) throws IOException {
        if (z11) {
            requireSpace((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeSInt64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt64(i11, longArrayList.getLong(size2));
        }
    }

    private final void writeUInt32List_Internal(int i11, IntArrayList intArrayList, boolean z11) throws IOException {
        if (z11) {
            requireSpace((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeVarint32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt32(i11, intArrayList.getInt(size2));
        }
    }

    private final void writeUInt64List_Internal(int i11, LongArrayList longArrayList, boolean z11) throws IOException {
        if (z11) {
            requireSpace((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeVarint64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i11, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt64(i11, longArrayList.getLong(size2));
        }
    }
}
