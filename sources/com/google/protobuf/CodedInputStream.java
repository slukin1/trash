package com.google.protobuf;

import com.google.common.base.Ascii;
import com.google.protobuf.MessageLite;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    private static volatile int defaultRecursionLimit = 100;
    public int recursionDepth;
    public int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    public int sizeLimit;
    public CodedInputStreamReader wrapper;

    public static final class ArrayDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        private void recomputeBufferSizeAfterLimit() {
            int i11 = this.limit + this.bufferSizeAfterLimit;
            this.limit = i11;
            int i12 = i11 - this.startPos;
            int i13 = this.currentLimit;
            if (i12 > i13) {
                int i14 = i12 - i13;
                this.bufferSizeAfterLimit = i14;
                this.limit = i11 - i14;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        private void skipRawVarint() throws IOException {
            if (this.limit - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            int i11 = 0;
            while (i11 < 10) {
                byte[] bArr = this.buffer;
                int i12 = this.pos;
                this.pos = i12 + 1;
                if (bArr[i12] < 0) {
                    i11++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int i11 = 0;
            while (i11 < 10) {
                if (readRawByte() < 0) {
                    i11++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public void checkLastTagWas(int i11) throws InvalidProtocolBufferException {
            if (this.lastTag != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public void enableAliasing(boolean z11) {
            this.enableAliasing = z11;
        }

        public int getBytesUntilLimit() {
            int i11 = this.currentLimit;
            if (i11 == Integer.MAX_VALUE) {
                return -1;
            }
            return i11 - getTotalBytesRead();
        }

        public int getLastTag() {
            return this.lastTag;
        }

        public int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        public boolean isAtEnd() throws IOException {
            return this.pos == this.limit;
        }

        public void popLimit(int i11) {
            this.currentLimit = i11;
            recomputeBufferSizeAfterLimit();
        }

        public int pushLimit(int i11) throws InvalidProtocolBufferException {
            if (i11 >= 0) {
                int totalBytesRead = i11 + getTotalBytesRead();
                if (totalBytesRead >= 0) {
                    int i12 = this.currentLimit;
                    if (totalBytesRead <= i12) {
                        this.currentLimit = totalBytesRead;
                        recomputeBufferSizeAfterLimit();
                        return i12;
                    }
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.parseFailure();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        public ByteBuffer readByteBuffer() throws IOException {
            ByteBuffer byteBuffer;
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i11 = this.limit;
                int i12 = this.pos;
                if (readRawVarint32 <= i11 - i12) {
                    if (this.immutable || !this.enableAliasing) {
                        byteBuffer = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i12, i12 + readRawVarint32));
                    } else {
                        byteBuffer = ByteBuffer.wrap(this.buffer, i12, readRawVarint32).slice();
                    }
                    this.pos += readRawVarint32;
                    return byteBuffer;
                }
            }
            if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public ByteString readBytes() throws IOException {
            ByteString byteString;
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i11 = this.limit;
                int i12 = this.pos;
                if (readRawVarint32 <= i11 - i12) {
                    if (!this.immutable || !this.enableAliasing) {
                        byteString = ByteString.copyFrom(this.buffer, i12, readRawVarint32);
                    } else {
                        byteString = ByteString.wrap(this.buffer, i12, readRawVarint32);
                    }
                    this.pos += readRawVarint32;
                    return byteString;
                }
            }
            if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            return ByteString.wrap(readRawBytes(readRawVarint32));
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        public void readGroup(int i11, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i11, 4));
            this.recursionDepth--;
        }

        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte readRawByte() throws IOException {
            int i11 = this.pos;
            if (i11 != this.limit) {
                byte[] bArr = this.buffer;
                this.pos = i11 + 1;
                return bArr[i11];
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte[] readRawBytes(int i11) throws IOException {
            if (i11 > 0) {
                int i12 = this.limit;
                int i13 = this.pos;
                if (i11 <= i12 - i13) {
                    int i14 = i11 + i13;
                    this.pos = i14;
                    return Arrays.copyOfRange(this.buffer, i13, i14);
                }
            }
            if (i11 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i11 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            } else {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        public int readRawLittleEndian32() throws IOException {
            int i11 = this.pos;
            if (this.limit - i11 >= 4) {
                byte[] bArr = this.buffer;
                this.pos = i11 + 4;
                return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public long readRawLittleEndian64() throws IOException {
            int i11 = this.pos;
            if (this.limit - i11 >= 8) {
                byte[] bArr = this.buffer;
                this.pos = i11 + 8;
                return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.pos
                int r1 = r5.limit
                if (r1 != r0) goto L_0x0007
                goto L_0x006a
            L_0x0007:
                byte[] r2 = r5.buffer
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0012
                r5.pos = r3
                return r0
            L_0x0012:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x0018
                goto L_0x006a
            L_0x0018:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0024
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0070
            L_0x0024:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0031
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x002f:
                r1 = r3
                goto L_0x0070
            L_0x0031:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x003f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0070
            L_0x003f:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r2 = r2[r3]
                if (r2 >= 0) goto L_0x0070
            L_0x006a:
                long r0 = r5.readRawVarint64SlowPath()
                int r0 = (int) r0
                return r0
            L_0x0070:
                r5.pos = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.ArrayDecoder.readRawVarint32():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long readRawVarint64() throws java.io.IOException {
            /*
                r11 = this;
                int r0 = r11.pos
                int r1 = r11.limit
                if (r1 != r0) goto L_0x0008
                goto L_0x00b6
            L_0x0008:
                byte[] r2 = r11.buffer
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0014
                r11.pos = r3
                long r0 = (long) r0
                return r0
            L_0x0014:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x001b
                goto L_0x00b6
            L_0x001b:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0029
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            L_0x0026:
                long r2 = (long) r0
                goto L_0x00bd
            L_0x0029:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x003a
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                long r0 = (long) r0
                r9 = r0
                r1 = r3
                r2 = r9
                goto L_0x00bd
            L_0x003a:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0048
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0026
            L_0x0048:
                long r3 = (long) r0
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r5 = (long) r1
                r1 = 28
                long r5 = r5 << r1
                long r3 = r3 ^ r5
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x005f
                r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            L_0x005b:
                long r2 = r3 ^ r1
                r1 = r0
                goto L_0x00bd
            L_0x005f:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 35
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0074
                r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            L_0x0071:
                long r2 = r3 ^ r5
                goto L_0x00bd
            L_0x0074:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 42
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x0087
                r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
                goto L_0x005b
            L_0x0087:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 49
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x009a
                r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
                goto L_0x0071
            L_0x009a:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 56
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto L_0x00bb
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x00bc
            L_0x00b6:
                long r0 = r11.readRawVarint64SlowPath()
                return r0
            L_0x00bb:
                r1 = r0
            L_0x00bc:
                r2 = r3
            L_0x00bd:
                r11.pos = r1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.ArrayDecoder.readRawVarint64():long");
        }

        public long readRawVarint64SlowPath() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                byte readRawByte = readRawByte();
                j11 |= ((long) (readRawByte & Ascii.DEL)) << i11;
                if ((readRawByte & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i11 = this.limit;
                int i12 = this.pos;
                if (readRawVarint32 <= i11 - i12) {
                    String str = new String(this.buffer, i12, readRawVarint32, Internal.UTF_8);
                    this.pos += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i11 = this.limit;
                int i12 = this.pos;
                if (readRawVarint32 <= i11 - i12) {
                    String decodeUtf8 = Utf8.decodeUtf8(this.buffer, i12, readRawVarint32);
                    this.pos += readRawVarint32;
                    return decodeUtf8;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Deprecated
        public void readUnknownGroup(int i11, MessageLite.Builder builder) throws IOException {
            readGroup(i11, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        public boolean skipField(int i11) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i11), 4));
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.ArrayDecoder.skipMessage():void");
        }

        public void skipRawBytes(int i11) throws IOException {
            if (i11 >= 0) {
                int i12 = this.limit;
                int i13 = this.pos;
                if (i11 <= i12 - i13) {
                    this.pos = i13 + i11;
                    return;
                }
            }
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private ArrayDecoder(byte[] bArr, int i11, int i12, boolean z11) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = bArr;
            this.limit = i12 + i11;
            this.pos = i11;
            this.startPos = i11;
            this.immutable = z11;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage(com.google.protobuf.CodedOutputStream r2) throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.ArrayDecoder.skipMessage(com.google.protobuf.CodedOutputStream):void");
        }

        public <T extends MessageLite> T readGroup(int i11, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T t11 = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i11, 4));
            this.recursionDepth--;
            return t11;
        }

        public boolean skipField(int i11, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i11);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i11), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeUInt32NoTag(makeTag);
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeUInt32NoTag(i11);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T t11 = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return t11;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public static final class IterableDirectByteBufferDecoder extends CodedInputStream {
        private int bufferSizeAfterCurrentLimit;
        private long currentAddress;
        private ByteBuffer currentByteBuffer;
        private long currentByteBufferLimit;
        private long currentByteBufferPos;
        private long currentByteBufferStartPos;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private final Iterable<ByteBuffer> input;
        private final Iterator<ByteBuffer> iterator;
        private int lastTag;
        private int startOffset;
        private int totalBufferSize;
        private int totalBytesRead;

        private long currentRemaining() {
            return this.currentByteBufferLimit - this.currentByteBufferPos;
        }

        private void getNextByteBuffer() throws InvalidProtocolBufferException {
            if (this.iterator.hasNext()) {
                tryGetNextByteBuffer();
                return;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void readRawBytesTo(byte[] bArr, int i11, int i12) throws IOException {
            if (i12 >= 0 && i12 <= remaining()) {
                int i13 = i12;
                while (i13 > 0) {
                    if (currentRemaining() == 0) {
                        getNextByteBuffer();
                    }
                    int min = Math.min(i13, (int) currentRemaining());
                    long j11 = (long) min;
                    UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, (long) ((i12 - i13) + i11), j11);
                    i13 -= min;
                    this.currentByteBufferPos += j11;
                }
            } else if (i12 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i12 != 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        private void recomputeBufferSizeAfterLimit() {
            int i11 = this.totalBufferSize + this.bufferSizeAfterCurrentLimit;
            this.totalBufferSize = i11;
            int i12 = i11 - this.startOffset;
            int i13 = this.currentLimit;
            if (i12 > i13) {
                int i14 = i12 - i13;
                this.bufferSizeAfterCurrentLimit = i14;
                this.totalBufferSize = i11 - i14;
                return;
            }
            this.bufferSizeAfterCurrentLimit = 0;
        }

        private int remaining() {
            return (int) ((((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private void skipRawVarint() throws IOException {
            int i11 = 0;
            while (i11 < 10) {
                if (readRawByte() < 0) {
                    i11++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
            r2.position(r0);
            r2.limit(r1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0023 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.nio.ByteBuffer slice(int r4, int r5) throws java.io.IOException {
            /*
                r3 = this;
                java.nio.ByteBuffer r0 = r3.currentByteBuffer
                int r0 = r0.position()
                java.nio.ByteBuffer r1 = r3.currentByteBuffer
                int r1 = r1.limit()
                java.nio.ByteBuffer r2 = r3.currentByteBuffer
                r2.position(r4)     // Catch:{ IllegalArgumentException -> 0x0023 }
                r2.limit(r5)     // Catch:{ IllegalArgumentException -> 0x0023 }
                java.nio.ByteBuffer r4 = r3.currentByteBuffer     // Catch:{ IllegalArgumentException -> 0x0023 }
                java.nio.ByteBuffer r4 = r4.slice()     // Catch:{ IllegalArgumentException -> 0x0023 }
                r2.position(r0)
                r2.limit(r1)
                return r4
            L_0x0021:
                r4 = move-exception
                goto L_0x0028
            L_0x0023:
                com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.truncatedMessage()     // Catch:{ all -> 0x0021 }
                throw r4     // Catch:{ all -> 0x0021 }
            L_0x0028:
                r2.position(r0)
                r2.limit(r1)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.slice(int, int):java.nio.ByteBuffer");
        }

        private void tryGetNextByteBuffer() {
            ByteBuffer next = this.iterator.next();
            this.currentByteBuffer = next;
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            long position = (long) next.position();
            this.currentByteBufferPos = position;
            this.currentByteBufferStartPos = position;
            this.currentByteBufferLimit = (long) this.currentByteBuffer.limit();
            long addressOffset = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentAddress = addressOffset;
            this.currentByteBufferPos += addressOffset;
            this.currentByteBufferStartPos += addressOffset;
            this.currentByteBufferLimit += addressOffset;
        }

        public void checkLastTagWas(int i11) throws InvalidProtocolBufferException {
            if (this.lastTag != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public void enableAliasing(boolean z11) {
            this.enableAliasing = z11;
        }

        public int getBytesUntilLimit() {
            int i11 = this.currentLimit;
            if (i11 == Integer.MAX_VALUE) {
                return -1;
            }
            return i11 - getTotalBytesRead();
        }

        public int getLastTag() {
            return this.lastTag;
        }

        public int getTotalBytesRead() {
            return (int) ((((long) (this.totalBytesRead - this.startOffset)) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        public boolean isAtEnd() throws IOException {
            return (((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos == ((long) this.totalBufferSize);
        }

        public void popLimit(int i11) {
            this.currentLimit = i11;
            recomputeBufferSizeAfterLimit();
        }

        public int pushLimit(int i11) throws InvalidProtocolBufferException {
            if (i11 >= 0) {
                int totalBytesRead2 = i11 + getTotalBytesRead();
                int i12 = this.currentLimit;
                if (totalBytesRead2 <= i12) {
                    this.currentLimit = totalBytesRead2;
                    recomputeBufferSizeAfterLimit();
                    return i12;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j11 = (long) readRawVarint32;
                if (j11 <= currentRemaining()) {
                    if (this.immutable || !this.enableAliasing) {
                        byte[] bArr = new byte[readRawVarint32];
                        UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0, j11);
                        this.currentByteBufferPos += j11;
                        return ByteBuffer.wrap(bArr);
                    }
                    long j12 = this.currentByteBufferPos + j11;
                    this.currentByteBufferPos = j12;
                    long j13 = this.currentAddress;
                    return slice((int) ((j12 - j13) - j11), (int) (j12 - j13));
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return ByteBuffer.wrap(bArr2);
            } else if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j11 = (long) readRawVarint32;
                long j12 = this.currentByteBufferLimit;
                long j13 = this.currentByteBufferPos;
                if (j11 <= j12 - j13) {
                    if (!this.immutable || !this.enableAliasing) {
                        byte[] bArr = new byte[readRawVarint32];
                        UnsafeUtil.copyMemory(j13, bArr, 0, j11);
                        this.currentByteBufferPos += j11;
                        return ByteString.wrap(bArr);
                    }
                    int i11 = (int) (j13 - this.currentAddress);
                    ByteString wrap = ByteString.wrap(slice(i11, readRawVarint32 + i11));
                    this.currentByteBufferPos += j11;
                    return wrap;
                }
            }
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return ByteString.EMPTY;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (!this.immutable || !this.enableAliasing) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return ByteString.wrap(bArr2);
            } else {
                ArrayList arrayList = new ArrayList();
                while (readRawVarint32 > 0) {
                    if (currentRemaining() == 0) {
                        getNextByteBuffer();
                    }
                    int min = Math.min(readRawVarint32, (int) currentRemaining());
                    int i12 = (int) (this.currentByteBufferPos - this.currentAddress);
                    arrayList.add(ByteString.wrap(slice(i12, i12 + min)));
                    readRawVarint32 -= min;
                    this.currentByteBufferPos += (long) min;
                }
                return ByteString.copyFrom((Iterable<ByteString>) arrayList);
            }
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        public void readGroup(int i11, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i11, 4));
            this.recursionDepth--;
        }

        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte readRawByte() throws IOException {
            if (currentRemaining() == 0) {
                getNextByteBuffer();
            }
            long j11 = this.currentByteBufferPos;
            this.currentByteBufferPos = 1 + j11;
            return UnsafeUtil.getByte(j11);
        }

        public byte[] readRawBytes(int i11) throws IOException {
            if (i11 >= 0) {
                long j11 = (long) i11;
                if (j11 <= currentRemaining()) {
                    byte[] bArr = new byte[i11];
                    UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0, j11);
                    this.currentByteBufferPos += j11;
                    return bArr;
                }
            }
            if (i11 >= 0 && i11 <= remaining()) {
                byte[] bArr2 = new byte[i11];
                readRawBytesTo(bArr2, 0, i11);
                return bArr2;
            } else if (i11 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i11 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            } else {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        public int readRawLittleEndian32() throws IOException {
            if (currentRemaining() < 4) {
                return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << Ascii.CAN);
            }
            long j11 = this.currentByteBufferPos;
            this.currentByteBufferPos = 4 + j11;
            return ((UnsafeUtil.getByte(j11 + 3) & 255) << Ascii.CAN) | (UnsafeUtil.getByte(j11) & 255) | ((UnsafeUtil.getByte(1 + j11) & 255) << 8) | ((UnsafeUtil.getByte(2 + j11) & 255) << 16);
        }

        public long readRawLittleEndian64() throws IOException {
            long readRawByte;
            byte readRawByte2;
            if (currentRemaining() >= 8) {
                long j11 = this.currentByteBufferPos;
                this.currentByteBufferPos = 8 + j11;
                readRawByte = (((long) UnsafeUtil.getByte(j11)) & 255) | ((((long) UnsafeUtil.getByte(1 + j11)) & 255) << 8) | ((((long) UnsafeUtil.getByte(2 + j11)) & 255) << 16) | ((((long) UnsafeUtil.getByte(3 + j11)) & 255) << 24) | ((((long) UnsafeUtil.getByte(4 + j11)) & 255) << 32) | ((((long) UnsafeUtil.getByte(5 + j11)) & 255) << 40) | ((((long) UnsafeUtil.getByte(6 + j11)) & 255) << 48);
                readRawByte2 = UnsafeUtil.getByte(j11 + 7);
            } else {
                readRawByte = (((long) readRawByte()) & 255) | ((((long) readRawByte()) & 255) << 8) | ((((long) readRawByte()) & 255) << 16) | ((((long) readRawByte()) & 255) << 24) | ((((long) readRawByte()) & 255) << 32) | ((((long) readRawByte()) & 255) << 40) | ((((long) readRawByte()) & 255) << 48);
                readRawByte2 = readRawByte();
            }
            return ((((long) readRawByte2) & 255) << 56) | readRawByte;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0088, code lost:
            if (com.google.protobuf.UnsafeUtil.getByte(r4) < 0) goto L_0x008a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r10 = this;
                long r0 = r10.currentByteBufferPos
                long r2 = r10.currentByteBufferLimit
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x000a
                goto L_0x008a
            L_0x000a:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r0)
                if (r0 < 0) goto L_0x001a
                long r4 = r10.currentByteBufferPos
                long r4 = r4 + r2
                r10.currentByteBufferPos = r4
                return r0
            L_0x001a:
                long r6 = r10.currentByteBufferLimit
                long r8 = r10.currentByteBufferPos
                long r6 = r6 - r8
                r8 = 10
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L_0x0026
                goto L_0x008a
            L_0x0026:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x0034
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0090
            L_0x0034:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0043
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x0041:
                r6 = r4
                goto L_0x0090
            L_0x0043:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x0053
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L_0x0090
            L_0x0053:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L_0x0041
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L_0x0090
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r6)
                if (r1 >= 0) goto L_0x0041
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L_0x0090
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r6)
                if (r1 >= 0) goto L_0x0041
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L_0x0090
            L_0x008a:
                long r0 = r10.readRawVarint64SlowPath()
                int r0 = (int) r0
                return r0
            L_0x0090:
                r10.currentByteBufferPos = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.readRawVarint32():int");
        }

        public long readRawVarint64() throws IOException {
            long j11;
            long j12;
            long j13;
            byte b11;
            long j14 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j14) {
                long j15 = j14 + 1;
                byte b12 = UnsafeUtil.getByte(j14);
                if (b12 >= 0) {
                    this.currentByteBufferPos++;
                    return (long) b12;
                } else if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j16 = j15 + 1;
                    byte b13 = b12 ^ (UnsafeUtil.getByte(j15) << 7);
                    if (b13 < 0) {
                        b11 = b13 ^ Byte.MIN_VALUE;
                    } else {
                        long j17 = j16 + 1;
                        byte b14 = b13 ^ (UnsafeUtil.getByte(j16) << 14);
                        if (b14 >= 0) {
                            j11 = (long) (b14 ^ 16256);
                        } else {
                            j16 = j17 + 1;
                            byte b15 = b14 ^ (UnsafeUtil.getByte(j17) << 21);
                            if (b15 < 0) {
                                b11 = b15 ^ -2080896;
                            } else {
                                j17 = j16 + 1;
                                long j18 = ((long) b15) ^ (((long) UnsafeUtil.getByte(j16)) << 28);
                                if (j18 >= 0) {
                                    j13 = 266354560;
                                } else {
                                    long j19 = j17 + 1;
                                    long j21 = j18 ^ (((long) UnsafeUtil.getByte(j17)) << 35);
                                    if (j21 < 0) {
                                        j12 = -34093383808L;
                                    } else {
                                        j17 = j19 + 1;
                                        j18 = j21 ^ (((long) UnsafeUtil.getByte(j19)) << 42);
                                        if (j18 >= 0) {
                                            j13 = 4363953127296L;
                                        } else {
                                            j19 = j17 + 1;
                                            j21 = j18 ^ (((long) UnsafeUtil.getByte(j17)) << 49);
                                            if (j21 < 0) {
                                                j12 = -558586000294016L;
                                            } else {
                                                j17 = j19 + 1;
                                                j11 = (j21 ^ (((long) UnsafeUtil.getByte(j19)) << 56)) ^ 71499008037633920L;
                                                if (j11 < 0) {
                                                    long j22 = 1 + j17;
                                                    if (((long) UnsafeUtil.getByte(j17)) >= 0) {
                                                        j16 = j22;
                                                        this.currentByteBufferPos = j16;
                                                        return j11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j11 = j21 ^ j12;
                                    j16 = j19;
                                    this.currentByteBufferPos = j16;
                                    return j11;
                                }
                                j11 = j18 ^ j13;
                            }
                        }
                        j16 = j17;
                        this.currentByteBufferPos = j16;
                        return j11;
                    }
                    j11 = (long) b11;
                    this.currentByteBufferPos = j16;
                    return j11;
                }
            }
            return readRawVarint64SlowPath();
        }

        public long readRawVarint64SlowPath() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                byte readRawByte = readRawByte();
                j11 |= ((long) (readRawByte & Ascii.DEL)) << i11;
                if ((readRawByte & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j11 = (long) readRawVarint32;
                long j12 = this.currentByteBufferLimit;
                long j13 = this.currentByteBufferPos;
                if (j11 <= j12 - j13) {
                    byte[] bArr = new byte[readRawVarint32];
                    UnsafeUtil.copyMemory(j13, bArr, 0, j11);
                    String str = new String(bArr, Internal.UTF_8);
                    this.currentByteBufferPos += j11;
                    return str;
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return new String(bArr2, Internal.UTF_8);
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j11 = (long) readRawVarint32;
                long j12 = this.currentByteBufferLimit;
                long j13 = this.currentByteBufferPos;
                if (j11 <= j12 - j13) {
                    String decodeUtf8 = Utf8.decodeUtf8(this.currentByteBuffer, (int) (j13 - this.currentByteBufferStartPos), readRawVarint32);
                    this.currentByteBufferPos += j11;
                    return decodeUtf8;
                }
            }
            if (readRawVarint32 >= 0 && readRawVarint32 <= remaining()) {
                byte[] bArr = new byte[readRawVarint32];
                readRawBytesTo(bArr, 0, readRawVarint32);
                return Utf8.decodeUtf8(bArr, 0, readRawVarint32);
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 <= 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Deprecated
        public void readUnknownGroup(int i11, MessageLite.Builder builder) throws IOException {
            readGroup(i11, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        public void resetSizeCounter() {
            this.startOffset = (int) ((((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        public boolean skipField(int i11) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i11), 4));
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.skipMessage():void");
        }

        public void skipRawBytes(int i11) throws IOException {
            if (i11 >= 0 && ((long) i11) <= (((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos) {
                while (i11 > 0) {
                    if (currentRemaining() == 0) {
                        getNextByteBuffer();
                    }
                    int min = Math.min(i11, (int) currentRemaining());
                    i11 -= min;
                    this.currentByteBufferPos += (long) min;
                }
            } else if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> iterable, int i11, boolean z11) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = i11;
            this.input = iterable;
            this.iterator = iterable.iterator();
            this.immutable = z11;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (i11 == 0) {
                this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
                this.currentByteBufferPos = 0;
                this.currentByteBufferStartPos = 0;
                this.currentByteBufferLimit = 0;
                this.currentAddress = 0;
                return;
            }
            tryGetNextByteBuffer();
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage(com.google.protobuf.CodedOutputStream r2) throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.skipMessage(com.google.protobuf.CodedOutputStream):void");
        }

        public <T extends MessageLite> T readGroup(int i11, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T t11 = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i11, 4));
            this.recursionDepth--;
            return t11;
        }

        public boolean skipField(int i11, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i11);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i11), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeUInt32NoTag(makeTag);
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeUInt32NoTag(i11);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T t11 = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return t11;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public static final class StreamDecoder extends CodedInputStream {
        /* access modifiers changed from: private */
        public final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private final InputStream input;
        private int lastTag;
        /* access modifiers changed from: private */
        public int pos;
        private RefillCallback refillCallback;
        private int totalBytesRetired;

        public interface RefillCallback {
            void onRefill();
        }

        public class SkippedDataSink implements RefillCallback {
            private ByteArrayOutputStream byteArrayStream;
            private int lastPos;

            private SkippedDataSink() {
                this.lastPos = StreamDecoder.this.pos;
            }

            public ByteBuffer getSkippedData() {
                ByteArrayOutputStream byteArrayOutputStream = this.byteArrayStream;
                if (byteArrayOutputStream == null) {
                    return ByteBuffer.wrap(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                }
                byteArrayOutputStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos);
                return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
            }

            public void onRefill() {
                if (this.byteArrayStream == null) {
                    this.byteArrayStream = new ByteArrayOutputStream();
                }
                this.byteArrayStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                this.lastPos = 0;
            }
        }

        private static int available(InputStream inputStream) throws IOException {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e11) {
                e11.setThrownFromInputStream();
                throw e11;
            }
        }

        private static int read(InputStream inputStream, byte[] bArr, int i11, int i12) throws IOException {
            try {
                return inputStream.read(bArr, i11, i12);
            } catch (InvalidProtocolBufferException e11) {
                e11.setThrownFromInputStream();
                throw e11;
            }
        }

        private ByteString readBytesSlowPath(int i11) throws IOException {
            byte[] readRawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i11);
            if (readRawBytesSlowPathOneChunk != null) {
                return ByteString.copyFrom(readRawBytesSlowPathOneChunk);
            }
            int i12 = this.pos;
            int i13 = this.bufferSize;
            int i14 = i13 - i12;
            this.totalBytesRetired += i13;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> readRawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i11 - i14);
            byte[] bArr = new byte[i11];
            System.arraycopy(this.buffer, i12, bArr, 0, i14);
            for (byte[] next : readRawBytesSlowPathRemainingChunks) {
                System.arraycopy(next, 0, bArr, i14, next.length);
                i14 += next.length;
            }
            return ByteString.wrap(bArr);
        }

        private byte[] readRawBytesSlowPath(int i11, boolean z11) throws IOException {
            byte[] readRawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i11);
            if (readRawBytesSlowPathOneChunk != null) {
                return z11 ? (byte[]) readRawBytesSlowPathOneChunk.clone() : readRawBytesSlowPathOneChunk;
            }
            int i12 = this.pos;
            int i13 = this.bufferSize;
            int i14 = i13 - i12;
            this.totalBytesRetired += i13;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> readRawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i11 - i14);
            byte[] bArr = new byte[i11];
            System.arraycopy(this.buffer, i12, bArr, 0, i14);
            for (byte[] next : readRawBytesSlowPathRemainingChunks) {
                System.arraycopy(next, 0, bArr, i14, next.length);
                i14 += next.length;
            }
            return bArr;
        }

        private byte[] readRawBytesSlowPathOneChunk(int i11) throws IOException {
            if (i11 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            if (i11 >= 0) {
                int i12 = this.totalBytesRetired;
                int i13 = this.pos;
                int i14 = i12 + i13 + i11;
                if (i14 - this.sizeLimit <= 0) {
                    int i15 = this.currentLimit;
                    if (i14 <= i15) {
                        int i16 = this.bufferSize - i13;
                        int i17 = i11 - i16;
                        if (i17 >= 4096 && i17 > available(this.input)) {
                            return null;
                        }
                        byte[] bArr = new byte[i11];
                        System.arraycopy(this.buffer, this.pos, bArr, 0, i16);
                        this.totalBytesRetired += this.bufferSize;
                        this.pos = 0;
                        this.bufferSize = 0;
                        while (i16 < i11) {
                            int read = read(this.input, bArr, i16, i11 - i16);
                            if (read != -1) {
                                this.totalBytesRetired += read;
                                i16 += read;
                            } else {
                                throw InvalidProtocolBufferException.truncatedMessage();
                            }
                        }
                        return bArr;
                    }
                    skipRawBytes((i15 - i12) - i13);
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int i11) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i11 > 0) {
                int min = Math.min(i11, 4096);
                byte[] bArr = new byte[min];
                int i12 = 0;
                while (i12 < min) {
                    int read = this.input.read(bArr, i12, min - i12);
                    if (read != -1) {
                        this.totalBytesRetired += read;
                        i12 += read;
                    } else {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                }
                i11 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void recomputeBufferSizeAfterLimit() {
            int i11 = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = i11;
            int i12 = this.totalBytesRetired + i11;
            int i13 = this.currentLimit;
            if (i12 > i13) {
                int i14 = i12 - i13;
                this.bufferSizeAfterLimit = i14;
                this.bufferSize = i11 - i14;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        private void refillBuffer(int i11) throws IOException {
            if (tryRefillBuffer(i11)) {
                return;
            }
            if (i11 > (this.sizeLimit - this.totalBytesRetired) - this.pos) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private static long skip(InputStream inputStream, long j11) throws IOException {
            try {
                return inputStream.skip(j11);
            } catch (InvalidProtocolBufferException e11) {
                e11.setThrownFromInputStream();
                throw e11;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
            throw new java.lang.IllegalStateException(r8.input.getClass() + "#skip returned invalid result: " + r0 + "\nThe InputStream implementation is buggy.");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void skipRawBytesSlowPath(int r9) throws java.io.IOException {
            /*
                r8 = this;
                if (r9 < 0) goto L_0x0097
                int r0 = r8.totalBytesRetired
                int r1 = r8.pos
                int r2 = r0 + r1
                int r2 = r2 + r9
                int r3 = r8.currentLimit
                if (r2 > r3) goto L_0x008d
                com.google.protobuf.CodedInputStream$StreamDecoder$RefillCallback r2 = r8.refillCallback
                r3 = 0
                if (r2 != 0) goto L_0x006f
                int r0 = r0 + r1
                r8.totalBytesRetired = r0
                int r0 = r8.bufferSize
                int r0 = r0 - r1
                r8.bufferSize = r3
                r8.pos = r3
                r3 = r0
            L_0x001d:
                if (r3 >= r9) goto L_0x0067
                int r0 = r9 - r3
                java.io.InputStream r1 = r8.input     // Catch:{ all -> 0x005d }
                long r4 = (long) r0     // Catch:{ all -> 0x005d }
                long r0 = skip(r1, r4)     // Catch:{ all -> 0x005d }
                r6 = 0
                int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r2 < 0) goto L_0x0038
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 > 0) goto L_0x0038
                if (r2 != 0) goto L_0x0035
                goto L_0x0067
            L_0x0035:
                int r0 = (int) r0     // Catch:{ all -> 0x005d }
                int r3 = r3 + r0
                goto L_0x001d
            L_0x0038:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005d }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
                r2.<init>()     // Catch:{ all -> 0x005d }
                java.io.InputStream r4 = r8.input     // Catch:{ all -> 0x005d }
                java.lang.Class r4 = r4.getClass()     // Catch:{ all -> 0x005d }
                r2.append(r4)     // Catch:{ all -> 0x005d }
                java.lang.String r4 = "#skip returned invalid result: "
                r2.append(r4)     // Catch:{ all -> 0x005d }
                r2.append(r0)     // Catch:{ all -> 0x005d }
                java.lang.String r0 = "\nThe InputStream implementation is buggy."
                r2.append(r0)     // Catch:{ all -> 0x005d }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x005d }
                r9.<init>(r0)     // Catch:{ all -> 0x005d }
                throw r9     // Catch:{ all -> 0x005d }
            L_0x005d:
                r9 = move-exception
                int r0 = r8.totalBytesRetired
                int r0 = r0 + r3
                r8.totalBytesRetired = r0
                r8.recomputeBufferSizeAfterLimit()
                throw r9
            L_0x0067:
                int r0 = r8.totalBytesRetired
                int r0 = r0 + r3
                r8.totalBytesRetired = r0
                r8.recomputeBufferSizeAfterLimit()
            L_0x006f:
                if (r3 >= r9) goto L_0x008c
                int r0 = r8.bufferSize
                int r1 = r8.pos
                int r1 = r0 - r1
                r8.pos = r0
                r0 = 1
                r8.refillBuffer(r0)
            L_0x007d:
                int r2 = r9 - r1
                int r3 = r8.bufferSize
                if (r2 <= r3) goto L_0x008a
                int r1 = r1 + r3
                r8.pos = r3
                r8.refillBuffer(r0)
                goto L_0x007d
            L_0x008a:
                r8.pos = r2
            L_0x008c:
                return
            L_0x008d:
                int r3 = r3 - r0
                int r3 = r3 - r1
                r8.skipRawBytes(r3)
                com.google.protobuf.InvalidProtocolBufferException r9 = com.google.protobuf.InvalidProtocolBufferException.truncatedMessage()
                throw r9
            L_0x0097:
                com.google.protobuf.InvalidProtocolBufferException r9 = com.google.protobuf.InvalidProtocolBufferException.negativeSize()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.StreamDecoder.skipRawBytesSlowPath(int):void");
        }

        private void skipRawVarint() throws IOException {
            if (this.bufferSize - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            int i11 = 0;
            while (i11 < 10) {
                byte[] bArr = this.buffer;
                int i12 = this.pos;
                this.pos = i12 + 1;
                if (bArr[i12] < 0) {
                    i11++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int i11 = 0;
            while (i11 < 10) {
                if (readRawByte() < 0) {
                    i11++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private boolean tryRefillBuffer(int i11) throws IOException {
            int i12 = this.pos;
            if (i12 + i11 > this.bufferSize) {
                int i13 = this.sizeLimit;
                int i14 = this.totalBytesRetired;
                if (i11 > (i13 - i14) - i12 || i14 + i12 + i11 > this.currentLimit) {
                    return false;
                }
                RefillCallback refillCallback2 = this.refillCallback;
                if (refillCallback2 != null) {
                    refillCallback2.onRefill();
                }
                int i15 = this.pos;
                if (i15 > 0) {
                    int i16 = this.bufferSize;
                    if (i16 > i15) {
                        byte[] bArr = this.buffer;
                        System.arraycopy(bArr, i15, bArr, 0, i16 - i15);
                    }
                    this.totalBytesRetired += i15;
                    this.bufferSize -= i15;
                    this.pos = 0;
                }
                InputStream inputStream = this.input;
                byte[] bArr2 = this.buffer;
                int i17 = this.bufferSize;
                int read = read(inputStream, bArr2, i17, Math.min(bArr2.length - i17, (this.sizeLimit - this.totalBytesRetired) - i17));
                if (read == 0 || read < -1 || read > this.buffer.length) {
                    throw new IllegalStateException(this.input.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.bufferSize += read;
                    recomputeBufferSizeAfterLimit();
                    if (this.bufferSize >= i11) {
                        return true;
                    }
                    return tryRefillBuffer(i11);
                }
            } else {
                throw new IllegalStateException("refillBuffer() called when " + i11 + " bytes were already available in buffer");
            }
        }

        public void checkLastTagWas(int i11) throws InvalidProtocolBufferException {
            if (this.lastTag != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public void enableAliasing(boolean z11) {
        }

        public int getBytesUntilLimit() {
            int i11 = this.currentLimit;
            if (i11 == Integer.MAX_VALUE) {
                return -1;
            }
            return i11 - (this.totalBytesRetired + this.pos);
        }

        public int getLastTag() {
            return this.lastTag;
        }

        public int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        public boolean isAtEnd() throws IOException {
            return this.pos == this.bufferSize && !tryRefillBuffer(1);
        }

        public void popLimit(int i11) {
            this.currentLimit = i11;
            recomputeBufferSizeAfterLimit();
        }

        public int pushLimit(int i11) throws InvalidProtocolBufferException {
            if (i11 >= 0) {
                int i12 = i11 + this.totalBytesRetired + this.pos;
                int i13 = this.currentLimit;
                if (i12 <= i13) {
                    this.currentLimit = i12;
                    recomputeBufferSizeAfterLimit();
                    return i13;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        public byte[] readByteArray() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i11 = this.bufferSize;
            int i12 = this.pos;
            if (readRawVarint32 > i11 - i12 || readRawVarint32 <= 0) {
                return readRawBytesSlowPath(readRawVarint32, false);
            }
            byte[] copyOfRange = Arrays.copyOfRange(this.buffer, i12, i12 + readRawVarint32);
            this.pos += readRawVarint32;
            return copyOfRange;
        }

        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i11 = this.bufferSize;
            int i12 = this.pos;
            if (readRawVarint32 <= i11 - i12 && readRawVarint32 > 0) {
                ByteBuffer wrap = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i12, i12 + readRawVarint32));
                this.pos += readRawVarint32;
                return wrap;
            } else if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            } else {
                return ByteBuffer.wrap(readRawBytesSlowPath(readRawVarint32, true));
            }
        }

        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i11 = this.bufferSize;
            int i12 = this.pos;
            if (readRawVarint32 <= i11 - i12 && readRawVarint32 > 0) {
                ByteString copyFrom = ByteString.copyFrom(this.buffer, i12, readRawVarint32);
                this.pos += readRawVarint32;
                return copyFrom;
            } else if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            } else {
                return readBytesSlowPath(readRawVarint32);
            }
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        public void readGroup(int i11, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i11, 4));
            this.recursionDepth--;
        }

        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte readRawByte() throws IOException {
            if (this.pos == this.bufferSize) {
                refillBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            this.pos = i11 + 1;
            return bArr[i11];
        }

        public byte[] readRawBytes(int i11) throws IOException {
            int i12 = this.pos;
            if (i11 > this.bufferSize - i12 || i11 <= 0) {
                return readRawBytesSlowPath(i11, false);
            }
            int i13 = i11 + i12;
            this.pos = i13;
            return Arrays.copyOfRange(this.buffer, i12, i13);
        }

        public int readRawLittleEndian32() throws IOException {
            int i11 = this.pos;
            if (this.bufferSize - i11 < 4) {
                refillBuffer(4);
                i11 = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i11 + 4;
            return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
        }

        public long readRawLittleEndian64() throws IOException {
            int i11 = this.pos;
            if (this.bufferSize - i11 < 8) {
                refillBuffer(8);
                i11 = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i11 + 8;
            return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r2[r3] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.pos
                int r1 = r5.bufferSize
                if (r1 != r0) goto L_0x0007
                goto L_0x006a
            L_0x0007:
                byte[] r2 = r5.buffer
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0012
                r5.pos = r3
                return r0
            L_0x0012:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x0018
                goto L_0x006a
            L_0x0018:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0024
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0070
            L_0x0024:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0031
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x002f:
                r1 = r3
                goto L_0x0070
            L_0x0031:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x003f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0070
            L_0x003f:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0070
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r3 + 1
                byte r2 = r2[r3]
                if (r2 >= 0) goto L_0x0070
            L_0x006a:
                long r0 = r5.readRawVarint64SlowPath()
                int r0 = (int) r0
                return r0
            L_0x0070:
                r5.pos = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.StreamDecoder.readRawVarint32():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
            if (((long) r2[r0]) < 0) goto L_0x00b6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long readRawVarint64() throws java.io.IOException {
            /*
                r11 = this;
                int r0 = r11.pos
                int r1 = r11.bufferSize
                if (r1 != r0) goto L_0x0008
                goto L_0x00b6
            L_0x0008:
                byte[] r2 = r11.buffer
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0014
                r11.pos = r3
                long r0 = (long) r0
                return r0
            L_0x0014:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L_0x001b
                goto L_0x00b6
            L_0x001b:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0029
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            L_0x0026:
                long r2 = (long) r0
                goto L_0x00bd
            L_0x0029:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x003a
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                long r0 = (long) r0
                r9 = r0
                r1 = r3
                r2 = r9
                goto L_0x00bd
            L_0x003a:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0048
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0026
            L_0x0048:
                long r3 = (long) r0
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r5 = (long) r1
                r1 = 28
                long r5 = r5 << r1
                long r3 = r3 ^ r5
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x005f
                r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            L_0x005b:
                long r2 = r3 ^ r1
                r1 = r0
                goto L_0x00bd
            L_0x005f:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 35
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0074
                r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            L_0x0071:
                long r2 = r3 ^ r5
                goto L_0x00bd
            L_0x0074:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 42
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x0087
                r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
                goto L_0x005b
            L_0x0087:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 49
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x009a
                r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
                goto L_0x0071
            L_0x009a:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 56
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto L_0x00bb
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x00bc
            L_0x00b6:
                long r0 = r11.readRawVarint64SlowPath()
                return r0
            L_0x00bb:
                r1 = r0
            L_0x00bc:
                r2 = r3
            L_0x00bd:
                r11.pos = r1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.StreamDecoder.readRawVarint64():long");
        }

        public long readRawVarint64SlowPath() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                byte readRawByte = readRawByte();
                j11 |= ((long) (readRawByte & Ascii.DEL)) << i11;
                if ((readRawByte & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i11 = this.bufferSize;
                int i12 = this.pos;
                if (readRawVarint32 <= i11 - i12) {
                    String str = new String(this.buffer, i12, readRawVarint32, Internal.UTF_8);
                    this.pos += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 > this.bufferSize) {
                return new String(readRawBytesSlowPath(readRawVarint32, false), Internal.UTF_8);
            }
            refillBuffer(readRawVarint32);
            String str2 = new String(this.buffer, this.pos, readRawVarint32, Internal.UTF_8);
            this.pos += readRawVarint32;
            return str2;
        }

        public String readStringRequireUtf8() throws IOException {
            byte[] bArr;
            int readRawVarint32 = readRawVarint32();
            int i11 = this.pos;
            int i12 = this.bufferSize;
            if (readRawVarint32 <= i12 - i11 && readRawVarint32 > 0) {
                bArr = this.buffer;
                this.pos = i11 + readRawVarint32;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 <= i12) {
                    refillBuffer(readRawVarint32);
                    bArr = this.buffer;
                    this.pos = readRawVarint32 + 0;
                } else {
                    bArr = readRawBytesSlowPath(readRawVarint32, false);
                }
                i11 = 0;
            }
            return Utf8.decodeUtf8(bArr, i11, readRawVarint32);
        }

        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Deprecated
        public void readUnknownGroup(int i11, MessageLite.Builder builder) throws IOException {
            readGroup(i11, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        public void resetSizeCounter() {
            this.totalBytesRetired = -this.pos;
        }

        public boolean skipField(int i11) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i11), 4));
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.StreamDecoder.skipMessage():void");
        }

        public void skipRawBytes(int i11) throws IOException {
            int i12 = this.bufferSize;
            int i13 = this.pos;
            if (i11 > i12 - i13 || i11 < 0) {
                skipRawBytesSlowPath(i11);
            } else {
                this.pos = i13 + i11;
            }
        }

        private StreamDecoder(InputStream inputStream, int i11) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.refillCallback = null;
            Internal.checkNotNull(inputStream, "input");
            this.input = inputStream;
            this.buffer = new byte[i11];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage(com.google.protobuf.CodedOutputStream r2) throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.StreamDecoder.skipMessage(com.google.protobuf.CodedOutputStream):void");
        }

        public <T extends MessageLite> T readGroup(int i11, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T t11 = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i11, 4));
            this.recursionDepth--;
            return t11;
        }

        public boolean skipField(int i11, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i11);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i11), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeUInt32NoTag(makeTag);
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeUInt32NoTag(i11);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T t11 = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return t11;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public static final class UnsafeDirectNioDecoder extends CodedInputStream {
        private final long address;
        private final ByteBuffer buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private long limit;
        private long pos;
        private long startPos;

        private int bufferPos(long j11) {
            return (int) (j11 - this.address);
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void recomputeBufferSizeAfterLimit() {
            long j11 = this.limit + ((long) this.bufferSizeAfterLimit);
            this.limit = j11;
            int i11 = (int) (j11 - this.startPos);
            int i12 = this.currentLimit;
            if (i11 > i12) {
                int i13 = i11 - i12;
                this.bufferSizeAfterLimit = i13;
                this.limit = j11 - ((long) i13);
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        private int remaining() {
            return (int) (this.limit - this.pos);
        }

        private void skipRawVarint() throws IOException {
            if (remaining() >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            int i11 = 0;
            while (i11 < 10) {
                long j11 = this.pos;
                this.pos = 1 + j11;
                if (UnsafeUtil.getByte(j11) < 0) {
                    i11++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int i11 = 0;
            while (i11 < 10) {
                if (readRawByte() < 0) {
                    i11++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer slice(long j11, long j12) throws IOException {
            int position = this.buffer.position();
            int limit2 = this.buffer.limit();
            ByteBuffer byteBuffer = this.buffer;
            try {
                byteBuffer.position(bufferPos(j11));
                byteBuffer.limit(bufferPos(j12));
                ByteBuffer slice = this.buffer.slice();
                byteBuffer.position(position);
                byteBuffer.limit(limit2);
                return slice;
            } catch (IllegalArgumentException e11) {
                InvalidProtocolBufferException truncatedMessage = InvalidProtocolBufferException.truncatedMessage();
                truncatedMessage.initCause(e11);
                throw truncatedMessage;
            } catch (Throwable th2) {
                byteBuffer.position(position);
                byteBuffer.limit(limit2);
                throw th2;
            }
        }

        public void checkLastTagWas(int i11) throws InvalidProtocolBufferException {
            if (this.lastTag != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public void enableAliasing(boolean z11) {
            this.enableAliasing = z11;
        }

        public int getBytesUntilLimit() {
            int i11 = this.currentLimit;
            if (i11 == Integer.MAX_VALUE) {
                return -1;
            }
            return i11 - getTotalBytesRead();
        }

        public int getLastTag() {
            return this.lastTag;
        }

        public int getTotalBytesRead() {
            return (int) (this.pos - this.startPos);
        }

        public boolean isAtEnd() throws IOException {
            return this.pos == this.limit;
        }

        public void popLimit(int i11) {
            this.currentLimit = i11;
            recomputeBufferSizeAfterLimit();
        }

        public int pushLimit(int i11) throws InvalidProtocolBufferException {
            if (i11 >= 0) {
                int totalBytesRead = i11 + getTotalBytesRead();
                int i12 = this.currentLimit;
                if (totalBytesRead <= i12) {
                    this.currentLimit = totalBytesRead;
                    recomputeBufferSizeAfterLimit();
                    return i12;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return Internal.EMPTY_BYTE_BUFFER;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (this.immutable || !this.enableAliasing) {
                byte[] bArr = new byte[readRawVarint32];
                long j11 = (long) readRawVarint32;
                UnsafeUtil.copyMemory(this.pos, bArr, 0, j11);
                this.pos += j11;
                return ByteBuffer.wrap(bArr);
            } else {
                long j12 = this.pos;
                long j13 = (long) readRawVarint32;
                ByteBuffer slice = slice(j12, j12 + j13);
                this.pos += j13;
                return slice;
            }
        }

        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return ByteString.EMPTY;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (!this.immutable || !this.enableAliasing) {
                byte[] bArr = new byte[readRawVarint32];
                long j11 = (long) readRawVarint32;
                UnsafeUtil.copyMemory(this.pos, bArr, 0, j11);
                this.pos += j11;
                return ByteString.wrap(bArr);
            } else {
                long j12 = this.pos;
                long j13 = (long) readRawVarint32;
                ByteBuffer slice = slice(j12, j12 + j13);
                this.pos += j13;
                return ByteString.wrap(slice);
            }
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        public void readGroup(int i11, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i11, 4));
            this.recursionDepth--;
        }

        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte readRawByte() throws IOException {
            long j11 = this.pos;
            if (j11 != this.limit) {
                this.pos = 1 + j11;
                return UnsafeUtil.getByte(j11);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte[] readRawBytes(int i11) throws IOException {
            if (i11 >= 0 && i11 <= remaining()) {
                byte[] bArr = new byte[i11];
                long j11 = this.pos;
                long j12 = (long) i11;
                slice(j11, j11 + j12).get(bArr);
                this.pos += j12;
                return bArr;
            } else if (i11 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i11 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            } else {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        public int readRawLittleEndian32() throws IOException {
            long j11 = this.pos;
            if (this.limit - j11 >= 4) {
                this.pos = 4 + j11;
                return ((UnsafeUtil.getByte(j11 + 3) & 255) << Ascii.CAN) | (UnsafeUtil.getByte(j11) & 255) | ((UnsafeUtil.getByte(1 + j11) & 255) << 8) | ((UnsafeUtil.getByte(2 + j11) & 255) << 16);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public long readRawLittleEndian64() throws IOException {
            long j11 = this.pos;
            if (this.limit - j11 >= 8) {
                this.pos = 8 + j11;
                return ((((long) UnsafeUtil.getByte(j11 + 7)) & 255) << 56) | (((long) UnsafeUtil.getByte(j11)) & 255) | ((((long) UnsafeUtil.getByte(1 + j11)) & 255) << 8) | ((((long) UnsafeUtil.getByte(2 + j11)) & 255) << 16) | ((((long) UnsafeUtil.getByte(3 + j11)) & 255) << 24) | ((((long) UnsafeUtil.getByte(4 + j11)) & 255) << 32) | ((((long) UnsafeUtil.getByte(5 + j11)) & 255) << 40) | ((((long) UnsafeUtil.getByte(6 + j11)) & 255) << 48);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
            if (com.google.protobuf.UnsafeUtil.getByte(r4) < 0) goto L_0x0085;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r10 = this;
                long r0 = r10.pos
                long r2 = r10.limit
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x000a
                goto L_0x0085
            L_0x000a:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r0)
                if (r0 < 0) goto L_0x0017
                r10.pos = r4
                return r0
            L_0x0017:
                long r6 = r10.limit
                long r6 = r6 - r4
                r8 = 9
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L_0x0021
                goto L_0x0085
            L_0x0021:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x002f
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x008b
            L_0x002f:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x003e
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x003c:
                r6 = r4
                goto L_0x008b
            L_0x003e:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x004e
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L_0x008b
            L_0x004e:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L_0x003c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L_0x008b
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r6)
                if (r1 >= 0) goto L_0x003c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L_0x008b
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r6)
                if (r1 >= 0) goto L_0x003c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L_0x008b
            L_0x0085:
                long r0 = r10.readRawVarint64SlowPath()
                int r0 = (int) r0
                return r0
            L_0x008b:
                r10.pos = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.UnsafeDirectNioDecoder.readRawVarint32():int");
        }

        public long readRawVarint64() throws IOException {
            long j11;
            long j12;
            long j13;
            byte b11;
            long j14 = this.pos;
            if (this.limit != j14) {
                long j15 = j14 + 1;
                byte b12 = UnsafeUtil.getByte(j14);
                if (b12 >= 0) {
                    this.pos = j15;
                    return (long) b12;
                } else if (this.limit - j15 >= 9) {
                    long j16 = j15 + 1;
                    byte b13 = b12 ^ (UnsafeUtil.getByte(j15) << 7);
                    if (b13 < 0) {
                        b11 = b13 ^ Byte.MIN_VALUE;
                    } else {
                        long j17 = j16 + 1;
                        byte b14 = b13 ^ (UnsafeUtil.getByte(j16) << 14);
                        if (b14 >= 0) {
                            j11 = (long) (b14 ^ 16256);
                        } else {
                            j16 = j17 + 1;
                            byte b15 = b14 ^ (UnsafeUtil.getByte(j17) << 21);
                            if (b15 < 0) {
                                b11 = b15 ^ -2080896;
                            } else {
                                j17 = j16 + 1;
                                long j18 = ((long) b15) ^ (((long) UnsafeUtil.getByte(j16)) << 28);
                                if (j18 >= 0) {
                                    j13 = 266354560;
                                } else {
                                    long j19 = j17 + 1;
                                    long j21 = j18 ^ (((long) UnsafeUtil.getByte(j17)) << 35);
                                    if (j21 < 0) {
                                        j12 = -34093383808L;
                                    } else {
                                        j17 = j19 + 1;
                                        j18 = j21 ^ (((long) UnsafeUtil.getByte(j19)) << 42);
                                        if (j18 >= 0) {
                                            j13 = 4363953127296L;
                                        } else {
                                            j19 = j17 + 1;
                                            j21 = j18 ^ (((long) UnsafeUtil.getByte(j17)) << 49);
                                            if (j21 < 0) {
                                                j12 = -558586000294016L;
                                            } else {
                                                j17 = j19 + 1;
                                                j11 = (j21 ^ (((long) UnsafeUtil.getByte(j19)) << 56)) ^ 71499008037633920L;
                                                if (j11 < 0) {
                                                    long j22 = 1 + j17;
                                                    if (((long) UnsafeUtil.getByte(j17)) >= 0) {
                                                        j16 = j22;
                                                        this.pos = j16;
                                                        return j11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j11 = j21 ^ j12;
                                    j16 = j19;
                                    this.pos = j16;
                                    return j11;
                                }
                                j11 = j18 ^ j13;
                            }
                        }
                        j16 = j17;
                        this.pos = j16;
                        return j11;
                    }
                    j11 = (long) b11;
                    this.pos = j16;
                    return j11;
                }
            }
            return readRawVarint64SlowPath();
        }

        public long readRawVarint64SlowPath() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                byte readRawByte = readRawByte();
                j11 |= ((long) (readRawByte & Ascii.DEL)) << i11;
                if ((readRawByte & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                byte[] bArr = new byte[readRawVarint32];
                long j11 = (long) readRawVarint32;
                UnsafeUtil.copyMemory(this.pos, bArr, 0, j11);
                String str = new String(bArr, Internal.UTF_8);
                this.pos += j11;
                return str;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                String decodeUtf8 = Utf8.decodeUtf8(this.buffer, bufferPos(this.pos), readRawVarint32);
                this.pos += (long) readRawVarint32;
                return decodeUtf8;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 <= 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Deprecated
        public void readUnknownGroup(int i11, MessageLite.Builder builder) throws IOException {
            readGroup(i11, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        public boolean skipField(int i11) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i11), 4));
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.UnsafeDirectNioDecoder.skipMessage():void");
        }

        public void skipRawBytes(int i11) throws IOException {
            if (i11 >= 0 && i11 <= remaining()) {
                this.pos += (long) i11;
            } else if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private UnsafeDirectNioDecoder(ByteBuffer byteBuffer, boolean z11) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = byteBuffer;
            long addressOffset = UnsafeUtil.addressOffset(byteBuffer);
            this.address = addressOffset;
            this.limit = ((long) byteBuffer.limit()) + addressOffset;
            long position = addressOffset + ((long) byteBuffer.position());
            this.pos = position;
            this.startPos = position;
            this.immutable = z11;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage(com.google.protobuf.CodedOutputStream r2) throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.UnsafeDirectNioDecoder.skipMessage(com.google.protobuf.CodedOutputStream):void");
        }

        public <T extends MessageLite> T readGroup(int i11, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T t11 = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i11, 4));
            this.recursionDepth--;
            return t11;
        }

        public boolean skipField(int i11, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i11);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i11), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeUInt32NoTag(makeTag);
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeUInt32NoTag(i11);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T t11 = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return t11;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public static int decodeZigZag32(int i11) {
        return (-(i11 & 1)) ^ (i11 >>> 1);
    }

    public static long decodeZigZag64(long j11) {
        return (-(j11 & 1)) ^ (j11 >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return newInstance(inputStream, 4096);
    }

    public static int readRawVarint32(int i11, InputStream inputStream) throws IOException {
        if ((i11 & 128) == 0) {
            return i11;
        }
        int i12 = i11 & 127;
        int i13 = 7;
        while (i13 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i12 |= (read & 127) << i13;
                if ((read & 128) == 0) {
                    return i12;
                }
                i13 += 7;
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }
        while (i13 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if ((read2 & 128) == 0) {
                return i12;
            } else {
                i13 += 7;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public abstract void checkLastTagWas(int i11) throws InvalidProtocolBufferException;

    public void checkRecursionLimit() throws InvalidProtocolBufferException {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    public final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    public abstract void enableAliasing(boolean z11);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd() throws IOException;

    public abstract void popLimit(int i11);

    public abstract int pushLimit(int i11) throws InvalidProtocolBufferException;

    public abstract boolean readBool() throws IOException;

    public abstract byte[] readByteArray() throws IOException;

    public abstract ByteBuffer readByteBuffer() throws IOException;

    public abstract ByteString readBytes() throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract int readEnum() throws IOException;

    public abstract int readFixed32() throws IOException;

    public abstract long readFixed64() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract <T extends MessageLite> T readGroup(int i11, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract void readGroup(int i11, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract int readInt32() throws IOException;

    public abstract long readInt64() throws IOException;

    public abstract <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract byte readRawByte() throws IOException;

    public abstract byte[] readRawBytes(int i11) throws IOException;

    public abstract int readRawLittleEndian32() throws IOException;

    public abstract long readRawLittleEndian64() throws IOException;

    public abstract int readRawVarint32() throws IOException;

    public abstract long readRawVarint64() throws IOException;

    public abstract long readRawVarint64SlowPath() throws IOException;

    public abstract int readSFixed32() throws IOException;

    public abstract long readSFixed64() throws IOException;

    public abstract int readSInt32() throws IOException;

    public abstract long readSInt64() throws IOException;

    public abstract String readString() throws IOException;

    public abstract String readStringRequireUtf8() throws IOException;

    public abstract int readTag() throws IOException;

    public abstract int readUInt32() throws IOException;

    public abstract long readUInt64() throws IOException;

    @Deprecated
    public abstract void readUnknownGroup(int i11, MessageLite.Builder builder) throws IOException;

    public abstract void resetSizeCounter();

    public final int setRecursionLimit(int i11) {
        if (i11 >= 0) {
            int i12 = this.recursionLimit;
            this.recursionLimit = i11;
            return i12;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + i11);
    }

    public final int setSizeLimit(int i11) {
        if (i11 >= 0) {
            int i12 = this.sizeLimit;
            this.sizeLimit = i11;
            return i12;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i11);
    }

    public final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public abstract boolean skipField(int i11) throws IOException;

    @Deprecated
    public abstract boolean skipField(int i11, CodedOutputStream codedOutputStream) throws IOException;

    public abstract void skipMessage() throws IOException;

    public abstract void skipMessage(CodedOutputStream codedOutputStream) throws IOException;

    public abstract void skipRawBytes(int i11) throws IOException;

    public final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }

    private CodedInputStream() {
        this.recursionLimit = defaultRecursionLimit;
        this.sizeLimit = Integer.MAX_VALUE;
        this.shouldDiscardUnknownFields = false;
    }

    public static CodedInputStream newInstance(InputStream inputStream, int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("bufferSize must be > 0");
        } else if (inputStream == null) {
            return newInstance(Internal.EMPTY_BYTE_ARRAY);
        } else {
            return new StreamDecoder(inputStream, i11);
        }
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> iterable) {
        if (!UnsafeDirectNioDecoder.isSupported()) {
            return newInstance((InputStream) new IterableByteBufferInputStream(iterable));
        }
        return newInstance(iterable, false);
    }

    public static int readRawVarint32(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return readRawVarint32(read, inputStream);
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> iterable, boolean z11) {
        boolean z12 = false;
        int i11 = 0;
        for (ByteBuffer next : iterable) {
            i11 += next.remaining();
            if (next.hasArray()) {
                z12 |= true;
            } else {
                z12 = next.isDirect() ? z12 | true : z12 | true;
            }
        }
        if (z12) {
            return new IterableDirectByteBufferDecoder(iterable, i11, z11);
        }
        return newInstance((InputStream) new IterableByteBufferInputStream(iterable));
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i11, int i12) {
        return newInstance(bArr, i11, i12, false);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i11, int i12, boolean z11) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i11, i12, z11);
        try {
            arrayDecoder.pushLimit(i12);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer) {
        return newInstance(byteBuffer, false);
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer, boolean z11) {
        if (byteBuffer.hasArray()) {
            return newInstance(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z11);
        }
        if (byteBuffer.isDirect() && UnsafeDirectNioDecoder.isSupported()) {
            return new UnsafeDirectNioDecoder(byteBuffer, z11);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return newInstance(bArr, 0, remaining, true);
    }
}
