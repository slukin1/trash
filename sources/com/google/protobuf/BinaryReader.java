package com.google.protobuf;

import com.google.common.base.Ascii;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

@CheckReturnValue
abstract class BinaryReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;

    /* renamed from: com.google.protobuf.BinaryReader$1  reason: invalid class name */
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
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.BinaryReader.AnonymousClass1.<clinit>():void");
        }
    }

    public /* synthetic */ BinaryReader(AnonymousClass1 r12) {
        this();
    }

    public static BinaryReader newInstance(ByteBuffer byteBuffer, boolean z11) {
        if (byteBuffer.hasArray()) {
            return new SafeHeapReader(byteBuffer, z11);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    public abstract int getTotalBytesRead();

    public boolean shouldDiscardUnknownFields() {
        return false;
    }

    public static final class SafeHeapReader extends BinaryReader {
        private final byte[] buffer;
        private final boolean bufferIsImmutable;
        private int endGroupTag;
        private final int initialPos;
        private int limit;
        private int pos;
        private int tag;

        public SafeHeapReader(ByteBuffer byteBuffer, boolean z11) {
            super((AnonymousClass1) null);
            this.bufferIsImmutable = z11;
            this.buffer = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.pos = arrayOffset;
            this.initialPos = arrayOffset;
            this.limit = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        private boolean isAtEnd() {
            return this.pos == this.limit;
        }

        private byte readByte() throws IOException {
            int i11 = this.pos;
            if (i11 != this.limit) {
                byte[] bArr = this.buffer;
                this.pos = i11 + 1;
                return bArr[i11];
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private Object readField(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(readBool());
                case 2:
                    return readBytes();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(readEnum());
                case 5:
                    return Integer.valueOf(readFixed32());
                case 6:
                    return Long.valueOf(readFixed64());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(readInt32());
                case 9:
                    return Long.valueOf(readInt64());
                case 10:
                    return readMessage(cls, extensionRegistryLite);
                case 11:
                    return Integer.valueOf(readSFixed32());
                case 12:
                    return Long.valueOf(readSFixed64());
                case 13:
                    return Integer.valueOf(readSInt32());
                case 14:
                    return Long.valueOf(readSInt64());
                case 15:
                    return readStringRequireUtf8();
                case 16:
                    return Integer.valueOf(readUInt32());
                case 17:
                    return Long.valueOf(readUInt64());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private int readLittleEndian32() throws IOException {
            requireBytes(4);
            return readLittleEndian32_NoCheck();
        }

        private int readLittleEndian32_NoCheck() {
            int i11 = this.pos;
            byte[] bArr = this.buffer;
            this.pos = i11 + 4;
            return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
        }

        private long readLittleEndian64() throws IOException {
            requireBytes(8);
            return readLittleEndian64_NoCheck();
        }

        private long readLittleEndian64_NoCheck() {
            int i11 = this.pos;
            byte[] bArr = this.buffer;
            this.pos = i11 + 8;
            return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
        }

        private int readVarint32() throws IOException {
            byte b11;
            int i11 = this.pos;
            int i12 = this.limit;
            if (i12 != i11) {
                byte[] bArr = this.buffer;
                int i13 = i11 + 1;
                byte b12 = bArr[i11];
                if (b12 >= 0) {
                    this.pos = i13;
                    return b12;
                } else if (i12 - i13 < 9) {
                    return (int) readVarint64SlowPath();
                } else {
                    int i14 = i13 + 1;
                    byte b13 = b12 ^ (bArr[i13] << 7);
                    if (b13 < 0) {
                        b11 = b13 ^ Byte.MIN_VALUE;
                    } else {
                        int i15 = i14 + 1;
                        byte b14 = b13 ^ (bArr[i14] << 14);
                        if (b14 >= 0) {
                            b11 = b14 ^ 16256;
                        } else {
                            i14 = i15 + 1;
                            byte b15 = b14 ^ (bArr[i15] << 21);
                            if (b15 < 0) {
                                b11 = b15 ^ -2080896;
                            } else {
                                i15 = i14 + 1;
                                byte b16 = bArr[i14];
                                b11 = (b15 ^ (b16 << 28)) ^ 266354560;
                                if (b16 < 0) {
                                    i14 = i15 + 1;
                                    if (bArr[i15] < 0) {
                                        i15 = i14 + 1;
                                        if (bArr[i14] < 0) {
                                            i14 = i15 + 1;
                                            if (bArr[i15] < 0) {
                                                i15 = i14 + 1;
                                                if (bArr[i14] < 0) {
                                                    i14 = i15 + 1;
                                                    if (bArr[i15] < 0) {
                                                        throw InvalidProtocolBufferException.malformedVarint();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i14 = i15;
                    }
                    this.pos = i14;
                    return b11;
                }
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private long readVarint64SlowPath() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                byte readByte = readByte();
                j11 |= ((long) (readByte & Ascii.DEL)) << i11;
                if ((readByte & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void requireBytes(int i11) throws IOException {
            if (i11 < 0 || i11 > this.limit - this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requirePosition(int i11) throws IOException {
            if (this.pos != i11) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requireWireType(int i11) throws IOException {
            if (WireFormat.getTagWireType(this.tag) != i11) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        private void skipBytes(int i11) throws IOException {
            requireBytes(i11);
            this.pos += i11;
        }

        /* JADX WARNING: Removed duplicated region for block: B:1:0x000f A[LOOP:0: B:1:0x000f->B:4:0x001c, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void skipGroup() throws java.io.IOException {
            /*
                r3 = this;
                int r0 = r3.endGroupTag
                int r1 = r3.tag
                int r1 = com.google.protobuf.WireFormat.getTagFieldNumber(r1)
                r2 = 4
                int r1 = com.google.protobuf.WireFormat.makeTag(r1, r2)
                r3.endGroupTag = r1
            L_0x000f:
                int r1 = r3.getFieldNumber()
                r2 = 2147483647(0x7fffffff, float:NaN)
                if (r1 == r2) goto L_0x001e
                boolean r1 = r3.skipField()
                if (r1 != 0) goto L_0x000f
            L_0x001e:
                int r1 = r3.tag
                int r2 = r3.endGroupTag
                if (r1 != r2) goto L_0x0027
                r3.endGroupTag = r0
                return
            L_0x0027:
                com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.parseFailure()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.BinaryReader.SafeHeapReader.skipGroup():void");
        }

        private void skipVarint() throws IOException {
            int i11 = this.limit;
            int i12 = this.pos;
            if (i11 - i12 >= 10) {
                byte[] bArr = this.buffer;
                int i13 = 0;
                while (i13 < 10) {
                    int i14 = i12 + 1;
                    if (bArr[i12] >= 0) {
                        this.pos = i14;
                        return;
                    } else {
                        i13++;
                        i12 = i14;
                    }
                }
            }
            skipVarintSlowPath();
        }

        private void skipVarintSlowPath() throws IOException {
            int i11 = 0;
            while (i11 < 10) {
                if (readByte() < 0) {
                    i11++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void verifyPackedFixed32Length(int i11) throws IOException {
            requireBytes(i11);
            if ((i11 & 3) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void verifyPackedFixed64Length(int i11) throws IOException {
            requireBytes(i11);
            if ((i11 & 7) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        public int getFieldNumber() throws IOException {
            if (isAtEnd()) {
                return Integer.MAX_VALUE;
            }
            int readVarint32 = readVarint32();
            this.tag = readVarint32;
            if (readVarint32 == this.endGroupTag) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.getTagFieldNumber(readVarint32);
        }

        public int getTag() {
            return this.tag;
        }

        public int getTotalBytesRead() {
            return this.pos - this.initialPos;
        }

        public <T> void mergeGroupField(T t11, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i11 = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            try {
                schema.mergeFrom(t11, this, extensionRegistryLite);
                if (this.tag != this.endGroupTag) {
                    throw InvalidProtocolBufferException.parseFailure();
                }
            } finally {
                this.endGroupTag = i11;
            }
        }

        public <T> void mergeMessageField(T t11, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readVarint32 = readVarint32();
            requireBytes(readVarint32);
            int i11 = this.limit;
            int i12 = this.pos + readVarint32;
            this.limit = i12;
            try {
                schema.mergeFrom(t11, this, extensionRegistryLite);
                if (this.pos != i12) {
                    throw InvalidProtocolBufferException.parseFailure();
                }
            } finally {
                this.limit = i11;
            }
        }

        public boolean readBool() throws IOException {
            requireWireType(0);
            if (readVarint32() != 0) {
                return true;
            }
            return false;
        }

        public void readBoolList(List<Boolean> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof BooleanArrayList) {
                BooleanArrayList booleanArrayList = (BooleanArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        booleanArrayList.addBoolean(readBool());
                        if (!isAtEnd()) {
                            i12 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i12;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        booleanArrayList.addBoolean(readVarint32() != 0);
                    }
                    requirePosition(readVarint32);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Boolean.valueOf(readBool()));
                        if (!isAtEnd()) {
                            i11 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i11;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Boolean.valueOf(readVarint32() != 0));
                    }
                    requirePosition(readVarint322);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public ByteString readBytes() throws IOException {
            ByteString byteString;
            requireWireType(2);
            int readVarint32 = readVarint32();
            if (readVarint32 == 0) {
                return ByteString.EMPTY;
            }
            requireBytes(readVarint32);
            if (this.bufferIsImmutable) {
                byteString = ByteString.wrap(this.buffer, this.pos, readVarint32);
            } else {
                byteString = ByteString.copyFrom(this.buffer, this.pos, readVarint32);
            }
            this.pos += readVarint32;
            return byteString;
        }

        public void readBytesList(List<ByteString> list) throws IOException {
            int i11;
            if (WireFormat.getTagWireType(this.tag) == 2) {
                do {
                    list.add(readBytes());
                    if (!isAtEnd()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i11;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        public double readDouble() throws IOException {
            requireWireType(1);
            return Double.longBitsToDouble(readLittleEndian64());
        }

        public void readDoubleList(List<Double> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof DoubleArrayList) {
                DoubleArrayList doubleArrayList = (DoubleArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 1) {
                    do {
                        doubleArrayList.addDouble(readDouble());
                        if (!isAtEnd()) {
                            i12 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i12;
                } else if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed64Length(readVarint32);
                    int i13 = this.pos + readVarint32;
                    while (this.pos < i13) {
                        doubleArrayList.addDouble(Double.longBitsToDouble(readLittleEndian64_NoCheck()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (!isAtEnd()) {
                            i11 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i11;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed64Length(readVarint322);
                    int i14 = this.pos + readVarint322;
                    while (this.pos < i14) {
                        list.add(Double.valueOf(Double.longBitsToDouble(readLittleEndian64_NoCheck())));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public int readEnum() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        public void readEnumList(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        intArrayList.addInt(readEnum());
                        if (!isAtEnd()) {
                            i12 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i12;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        intArrayList.addInt(readVarint32());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(readEnum()));
                        if (!isAtEnd()) {
                            i11 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i11;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public int readFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        public void readFixed32List(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i13 = this.pos + readVarint32;
                    while (this.pos < i13) {
                        intArrayList.addInt(readLittleEndian32_NoCheck());
                    }
                } else if (tagWireType == 5) {
                    do {
                        intArrayList.addInt(readFixed32());
                        if (!isAtEnd()) {
                            i12 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i12;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed32Length(readVarint322);
                    int i14 = this.pos + readVarint322;
                    while (this.pos < i14) {
                        list.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                } else if (tagWireType2 == 5) {
                    do {
                        list.add(Integer.valueOf(readFixed32()));
                        if (!isAtEnd()) {
                            i11 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i11;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        public void readFixed64List(List<Long> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 1) {
                    do {
                        longArrayList.addLong(readFixed64());
                        if (!isAtEnd()) {
                            i12 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i12;
                } else if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed64Length(readVarint32);
                    int i13 = this.pos + readVarint32;
                    while (this.pos < i13) {
                        longArrayList.addLong(readLittleEndian64_NoCheck());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 1) {
                    do {
                        list.add(Long.valueOf(readFixed64()));
                        if (!isAtEnd()) {
                            i11 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i11;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed64Length(readVarint322);
                    int i14 = this.pos + readVarint322;
                    while (this.pos < i14) {
                        list.add(Long.valueOf(readLittleEndian64_NoCheck()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public float readFloat() throws IOException {
            requireWireType(5);
            return Float.intBitsToFloat(readLittleEndian32());
        }

        public void readFloatList(List<Float> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof FloatArrayList) {
                FloatArrayList floatArrayList = (FloatArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i13 = this.pos + readVarint32;
                    while (this.pos < i13) {
                        floatArrayList.addFloat(Float.intBitsToFloat(readLittleEndian32_NoCheck()));
                    }
                } else if (tagWireType == 5) {
                    do {
                        floatArrayList.addFloat(readFloat());
                        if (!isAtEnd()) {
                            i12 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i12;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed32Length(readVarint322);
                    int i14 = this.pos + readVarint322;
                    while (this.pos < i14) {
                        list.add(Float.valueOf(Float.intBitsToFloat(readLittleEndian32_NoCheck())));
                    }
                } else if (tagWireType2 == 5) {
                    do {
                        list.add(Float.valueOf(readFloat()));
                        if (!isAtEnd()) {
                            i11 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i11;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        @Deprecated
        public <T> T readGroup(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(3);
            return readGroup(Protobuf.getInstance().schemaFor(cls), extensionRegistryLite);
        }

        @Deprecated
        public <T> T readGroupBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(3);
            return readGroup(schema, extensionRegistryLite);
        }

        @Deprecated
        public <T> void readGroupList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            readGroupList(list, Protobuf.getInstance().schemaFor(cls), extensionRegistryLite);
        }

        public int readInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        public void readInt32List(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        intArrayList.addInt(readInt32());
                        if (!isAtEnd()) {
                            i12 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i12;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        intArrayList.addInt(readVarint32());
                    }
                    requirePosition(readVarint32);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(readInt32()));
                        if (!isAtEnd()) {
                            i11 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i11;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                    requirePosition(readVarint322);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        public void readInt64List(List<Long> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        longArrayList.addLong(readInt64());
                        if (!isAtEnd()) {
                            i12 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i12;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        longArrayList.addLong(readVarint64());
                    }
                    requirePosition(readVarint32);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Long.valueOf(readInt64()));
                        if (!isAtEnd()) {
                            i11 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i11;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Long.valueOf(readVarint64()));
                    }
                    requirePosition(readVarint322);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:19|20|(2:22|35)(3:30|23|24)) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
            if (skipField() != false) goto L_0x0054;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x005a, code lost:
            throw new com.google.protobuf.InvalidProtocolBufferException("Unable to parse map entry.");
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <K, V> void readMap(java.util.Map<K, V> r8, com.google.protobuf.MapEntryLite.Metadata<K, V> r9, com.google.protobuf.ExtensionRegistryLite r10) throws java.io.IOException {
            /*
                r7 = this;
                r0 = 2
                r7.requireWireType(r0)
                int r1 = r7.readVarint32()
                r7.requireBytes(r1)
                int r2 = r7.limit
                int r3 = r7.pos
                int r3 = r3 + r1
                r7.limit = r3
                K r1 = r9.defaultKey     // Catch:{ all -> 0x005b }
                V r3 = r9.defaultValue     // Catch:{ all -> 0x005b }
            L_0x0016:
                int r4 = r7.getFieldNumber()     // Catch:{ all -> 0x005b }
                r5 = 2147483647(0x7fffffff, float:NaN)
                if (r4 != r5) goto L_0x0025
                r8.put(r1, r3)     // Catch:{ all -> 0x005b }
                r7.limit = r2
                return
            L_0x0025:
                r5 = 1
                java.lang.String r6 = "Unable to parse map entry."
                if (r4 == r5) goto L_0x0046
                if (r4 == r0) goto L_0x0039
                boolean r4 = r7.skipField()     // Catch:{ InvalidWireTypeException -> 0x004e }
                if (r4 == 0) goto L_0x0033
                goto L_0x0016
            L_0x0033:
                com.google.protobuf.InvalidProtocolBufferException r4 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ InvalidWireTypeException -> 0x004e }
                r4.<init>((java.lang.String) r6)     // Catch:{ InvalidWireTypeException -> 0x004e }
                throw r4     // Catch:{ InvalidWireTypeException -> 0x004e }
            L_0x0039:
                com.google.protobuf.WireFormat$FieldType r4 = r9.valueType     // Catch:{ InvalidWireTypeException -> 0x004e }
                V r5 = r9.defaultValue     // Catch:{ InvalidWireTypeException -> 0x004e }
                java.lang.Class r5 = r5.getClass()     // Catch:{ InvalidWireTypeException -> 0x004e }
                java.lang.Object r3 = r7.readField(r4, r5, r10)     // Catch:{ InvalidWireTypeException -> 0x004e }
                goto L_0x0016
            L_0x0046:
                com.google.protobuf.WireFormat$FieldType r4 = r9.keyType     // Catch:{ InvalidWireTypeException -> 0x004e }
                r5 = 0
                java.lang.Object r1 = r7.readField(r4, r5, r5)     // Catch:{ InvalidWireTypeException -> 0x004e }
                goto L_0x0016
            L_0x004e:
                boolean r4 = r7.skipField()     // Catch:{ all -> 0x005b }
                if (r4 == 0) goto L_0x0055
                goto L_0x0016
            L_0x0055:
                com.google.protobuf.InvalidProtocolBufferException r8 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x005b }
                r8.<init>((java.lang.String) r6)     // Catch:{ all -> 0x005b }
                throw r8     // Catch:{ all -> 0x005b }
            L_0x005b:
                r8 = move-exception
                r7.limit = r2
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.BinaryReader.SafeHeapReader.readMap(java.util.Map, com.google.protobuf.MapEntryLite$Metadata, com.google.protobuf.ExtensionRegistryLite):void");
        }

        public <T> T readMessage(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            return readMessage(Protobuf.getInstance().schemaFor(cls), extensionRegistryLite);
        }

        public <T> T readMessageBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            return readMessage(schema, extensionRegistryLite);
        }

        public <T> void readMessageList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            readMessageList(list, Protobuf.getInstance().schemaFor(cls), extensionRegistryLite);
        }

        public int readSFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        public void readSFixed32List(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i13 = this.pos + readVarint32;
                    while (this.pos < i13) {
                        intArrayList.addInt(readLittleEndian32_NoCheck());
                    }
                } else if (tagWireType == 5) {
                    do {
                        intArrayList.addInt(readSFixed32());
                        if (!isAtEnd()) {
                            i12 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i12;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed32Length(readVarint322);
                    int i14 = this.pos + readVarint322;
                    while (this.pos < i14) {
                        list.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                } else if (tagWireType2 == 5) {
                    do {
                        list.add(Integer.valueOf(readSFixed32()));
                        if (!isAtEnd()) {
                            i11 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i11;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readSFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        public void readSFixed64List(List<Long> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 1) {
                    do {
                        longArrayList.addLong(readSFixed64());
                        if (!isAtEnd()) {
                            i12 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i12;
                } else if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed64Length(readVarint32);
                    int i13 = this.pos + readVarint32;
                    while (this.pos < i13) {
                        longArrayList.addLong(readLittleEndian64_NoCheck());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 1) {
                    do {
                        list.add(Long.valueOf(readSFixed64()));
                        if (!isAtEnd()) {
                            i11 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i11;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed64Length(readVarint322);
                    int i14 = this.pos + readVarint322;
                    while (this.pos < i14) {
                        list.add(Long.valueOf(readLittleEndian64_NoCheck()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public int readSInt32() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag32(readVarint32());
        }

        public void readSInt32List(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        intArrayList.addInt(readSInt32());
                        if (!isAtEnd()) {
                            i12 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i12;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        intArrayList.addInt(CodedInputStream.decodeZigZag32(readVarint32()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(readSInt32()));
                        if (!isAtEnd()) {
                            i11 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i11;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Integer.valueOf(CodedInputStream.decodeZigZag32(readVarint32())));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readSInt64() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag64(readVarint64());
        }

        public void readSInt64List(List<Long> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        longArrayList.addLong(readSInt64());
                        if (!isAtEnd()) {
                            i12 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i12;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        longArrayList.addLong(CodedInputStream.decodeZigZag64(readVarint64()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Long.valueOf(readSInt64()));
                        if (!isAtEnd()) {
                            i11 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i11;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Long.valueOf(CodedInputStream.decodeZigZag64(readVarint64())));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public String readString() throws IOException {
            return readStringInternal(false);
        }

        public String readStringInternal(boolean z11) throws IOException {
            requireWireType(2);
            int readVarint32 = readVarint32();
            if (readVarint32 == 0) {
                return "";
            }
            requireBytes(readVarint32);
            if (z11) {
                byte[] bArr = this.buffer;
                int i11 = this.pos;
                if (!Utf8.isValidUtf8(bArr, i11, i11 + readVarint32)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            String str = new String(this.buffer, this.pos, readVarint32, Internal.UTF_8);
            this.pos += readVarint32;
            return str;
        }

        public void readStringList(List<String> list) throws IOException {
            readStringListInternal(list, false);
        }

        public void readStringListInternal(List<String> list, boolean z11) throws IOException {
            int i11;
            int i12;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            } else if (!(list instanceof LazyStringList) || z11) {
                do {
                    list.add(readStringInternal(z11));
                    if (!isAtEnd()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i11;
            } else {
                LazyStringList lazyStringList = (LazyStringList) list;
                do {
                    lazyStringList.add(readBytes());
                    if (!isAtEnd()) {
                        i12 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i12;
            }
        }

        public void readStringListRequireUtf8(List<String> list) throws IOException {
            readStringListInternal(list, true);
        }

        public String readStringRequireUtf8() throws IOException {
            return readStringInternal(true);
        }

        public int readUInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        public void readUInt32List(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        intArrayList.addInt(readUInt32());
                        if (!isAtEnd()) {
                            i12 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i12;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        intArrayList.addInt(readVarint32());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(readUInt32()));
                        if (!isAtEnd()) {
                            i11 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i11;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readUInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        public void readUInt64List(List<Long> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        longArrayList.addLong(readUInt64());
                        if (!isAtEnd()) {
                            i12 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i12;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        longArrayList.addLong(readVarint64());
                    }
                    requirePosition(readVarint32);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Long.valueOf(readUInt64()));
                        if (!isAtEnd()) {
                            i11 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i11;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Long.valueOf(readVarint64()));
                    }
                    requirePosition(readVarint322);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readVarint64() throws IOException {
            long j11;
            int i11;
            long j12;
            long j13;
            byte b11;
            int i12 = this.pos;
            int i13 = this.limit;
            if (i13 != i12) {
                byte[] bArr = this.buffer;
                int i14 = i12 + 1;
                byte b12 = bArr[i12];
                if (b12 >= 0) {
                    this.pos = i14;
                    return (long) b12;
                } else if (i13 - i14 < 9) {
                    return readVarint64SlowPath();
                } else {
                    int i15 = i14 + 1;
                    byte b13 = b12 ^ (bArr[i14] << 7);
                    if (b13 < 0) {
                        b11 = b13 ^ Byte.MIN_VALUE;
                    } else {
                        int i16 = i15 + 1;
                        byte b14 = b13 ^ (bArr[i15] << 14);
                        if (b14 >= 0) {
                            i11 = i16;
                            j11 = (long) (b14 ^ 16256);
                        } else {
                            i15 = i16 + 1;
                            byte b15 = b14 ^ (bArr[i16] << 21);
                            if (b15 < 0) {
                                b11 = b15 ^ -2080896;
                            } else {
                                long j14 = (long) b15;
                                int i17 = i15 + 1;
                                long j15 = j14 ^ (((long) bArr[i15]) << 28);
                                if (j15 >= 0) {
                                    j13 = 266354560;
                                } else {
                                    int i18 = i17 + 1;
                                    long j16 = j15 ^ (((long) bArr[i17]) << 35);
                                    if (j16 < 0) {
                                        j12 = -34093383808L;
                                    } else {
                                        i17 = i18 + 1;
                                        j15 = j16 ^ (((long) bArr[i18]) << 42);
                                        if (j15 >= 0) {
                                            j13 = 4363953127296L;
                                        } else {
                                            i18 = i17 + 1;
                                            j16 = j15 ^ (((long) bArr[i17]) << 49);
                                            if (j16 < 0) {
                                                j12 = -558586000294016L;
                                            } else {
                                                int i19 = i18 + 1;
                                                long j17 = (j16 ^ (((long) bArr[i18]) << 56)) ^ 71499008037633920L;
                                                if (j17 < 0) {
                                                    i11 = i19 + 1;
                                                    if (((long) bArr[i19]) < 0) {
                                                        throw InvalidProtocolBufferException.malformedVarint();
                                                    }
                                                } else {
                                                    i11 = i19;
                                                }
                                                j11 = j17;
                                            }
                                        }
                                    }
                                    j11 = j16 ^ j12;
                                }
                                j11 = j15 ^ j13;
                                i11 = i17;
                            }
                        }
                        this.pos = i11;
                        return j11;
                    }
                    j11 = (long) b11;
                    this.pos = i11;
                    return j11;
                }
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public boolean skipField() throws IOException {
            int i11;
            if (isAtEnd() || (i11 = this.tag) == this.endGroupTag) {
                return false;
            }
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                skipVarint();
                return true;
            } else if (tagWireType == 1) {
                skipBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipBytes(readVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipGroup();
                return true;
            } else if (tagWireType == 5) {
                skipBytes(4);
                return true;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        private <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            T newInstance = schema.newInstance();
            mergeGroupField(newInstance, schema, extensionRegistryLite);
            schema.makeImmutable(newInstance);
            return newInstance;
        }

        private <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            T newInstance = schema.newInstance();
            mergeMessageField(newInstance, schema, extensionRegistryLite);
            schema.makeImmutable(newInstance);
            return newInstance;
        }

        @Deprecated
        public <T> void readGroupList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i11;
            if (WireFormat.getTagWireType(this.tag) == 3) {
                int i12 = this.tag;
                do {
                    list.add(readGroup(schema, extensionRegistryLite));
                    if (!isAtEnd()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == i12);
                this.pos = i11;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        public <T> void readMessageList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i11;
            if (WireFormat.getTagWireType(this.tag) == 2) {
                int i12 = this.tag;
                do {
                    list.add(readMessage(schema, extensionRegistryLite));
                    if (!isAtEnd()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == i12);
                this.pos = i11;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    private BinaryReader() {
    }
}
