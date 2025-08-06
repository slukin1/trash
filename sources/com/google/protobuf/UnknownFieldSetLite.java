package com.google.protobuf;

import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;

public final class UnknownFieldSetLite {
    private static final UnknownFieldSetLite DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
    private static final int MIN_CAPACITY = 8;
    private int count;
    private boolean isMutable;
    private int memoizedSerializedSize;
    private Object[] objects;
    private int[] tags;

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private void ensureCapacity(int i11) {
        int[] iArr = this.tags;
        if (i11 > iArr.length) {
            int i12 = this.count;
            int i13 = i12 + (i12 / 2);
            if (i13 >= i11) {
                i11 = i13;
            }
            if (i11 < 8) {
                i11 = 8;
            }
            this.tags = Arrays.copyOf(iArr, i11);
            this.objects = Arrays.copyOf(this.objects, i11);
        }
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static int hashCode(int[] iArr, int i11) {
        int i12 = 17;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 = (i12 * 31) + iArr[i13];
        }
        return i12;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private com.google.protobuf.UnknownFieldSetLite mergeFrom(com.google.protobuf.CodedInputStream r2) throws java.io.IOException {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r2.readTag()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.mergeFieldFrom(r0, r2)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.UnknownFieldSetLite.mergeFrom(com.google.protobuf.CodedInputStream):com.google.protobuf.UnknownFieldSetLite");
    }

    public static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int i11 = unknownFieldSetLite.count + unknownFieldSetLite2.count;
        int[] copyOf = Arrays.copyOf(unknownFieldSetLite.tags, i11);
        System.arraycopy(unknownFieldSetLite2.tags, 0, copyOf, unknownFieldSetLite.count, unknownFieldSetLite2.count);
        Object[] copyOf2 = Arrays.copyOf(unknownFieldSetLite.objects, i11);
        System.arraycopy(unknownFieldSetLite2.objects, 0, copyOf2, unknownFieldSetLite.count, unknownFieldSetLite2.count);
        return new UnknownFieldSetLite(i11, copyOf, copyOf2, true);
    }

    public static UnknownFieldSetLite newInstance() {
        return new UnknownFieldSetLite();
    }

    private static boolean objectsEquals(Object[] objArr, Object[] objArr2, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (!objArr[i12].equals(objArr2[i12])) {
                return false;
            }
        }
        return true;
    }

    private static boolean tagsEquals(int[] iArr, int[] iArr2, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (iArr[i12] != iArr2[i12]) {
                return false;
            }
        }
        return true;
    }

    private static void writeField(int i11, Object obj, Writer writer) throws IOException {
        int tagFieldNumber = WireFormat.getTagFieldNumber(i11);
        int tagWireType = WireFormat.getTagWireType(i11);
        if (tagWireType == 0) {
            writer.writeInt64(tagFieldNumber, ((Long) obj).longValue());
        } else if (tagWireType == 1) {
            writer.writeFixed64(tagFieldNumber, ((Long) obj).longValue());
        } else if (tagWireType == 2) {
            writer.writeBytes(tagFieldNumber, (ByteString) obj);
        } else if (tagWireType != 3) {
            if (tagWireType == 5) {
                writer.writeFixed32(tagFieldNumber, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
        } else if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            writer.writeStartGroup(tagFieldNumber);
            ((UnknownFieldSetLite) obj).writeTo(writer);
            writer.writeEndGroup(tagFieldNumber);
        } else {
            writer.writeEndGroup(tagFieldNumber);
            ((UnknownFieldSetLite) obj).writeTo(writer);
            writer.writeStartGroup(tagFieldNumber);
        }
    }

    public void checkMutable() {
        if (!this.isMutable) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i11 = this.count;
        return i11 == unknownFieldSetLite.count && tagsEquals(this.tags, unknownFieldSetLite.tags, i11) && objectsEquals(this.objects, unknownFieldSetLite.objects, this.count);
    }

    public int getSerializedSize() {
        int i11;
        int i12 = this.memoizedSerializedSize;
        if (i12 != -1) {
            return i12;
        }
        int i13 = 0;
        for (int i14 = 0; i14 < this.count; i14++) {
            int i15 = this.tags[i14];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i15);
            int tagWireType = WireFormat.getTagWireType(i15);
            if (tagWireType == 0) {
                i11 = CodedOutputStream.computeUInt64Size(tagFieldNumber, ((Long) this.objects[i14]).longValue());
            } else if (tagWireType == 1) {
                i11 = CodedOutputStream.computeFixed64Size(tagFieldNumber, ((Long) this.objects[i14]).longValue());
            } else if (tagWireType == 2) {
                i11 = CodedOutputStream.computeBytesSize(tagFieldNumber, (ByteString) this.objects[i14]);
            } else if (tagWireType == 3) {
                i11 = (CodedOutputStream.computeTagSize(tagFieldNumber) * 2) + ((UnknownFieldSetLite) this.objects[i14]).getSerializedSize();
            } else if (tagWireType == 5) {
                i11 = CodedOutputStream.computeFixed32Size(tagFieldNumber, ((Integer) this.objects[i14]).intValue());
            } else {
                throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
            }
            i13 += i11;
        }
        this.memoizedSerializedSize = i13;
        return i13;
    }

    public int getSerializedSizeAsMessageSet() {
        int i11 = this.memoizedSerializedSize;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.count; i13++) {
            i12 += CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.tags[i13]), (ByteString) this.objects[i13]);
        }
        this.memoizedSerializedSize = i12;
        return i12;
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public boolean mergeFieldFrom(int i11, CodedInputStream codedInputStream) throws IOException {
        checkMutable();
        int tagFieldNumber = WireFormat.getTagFieldNumber(i11);
        int tagWireType = WireFormat.getTagWireType(i11);
        if (tagWireType == 0) {
            storeField(i11, Long.valueOf(codedInputStream.readInt64()));
            return true;
        } else if (tagWireType == 1) {
            storeField(i11, Long.valueOf(codedInputStream.readFixed64()));
            return true;
        } else if (tagWireType == 2) {
            storeField(i11, codedInputStream.readBytes());
            return true;
        } else if (tagWireType == 3) {
            UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite();
            unknownFieldSetLite.mergeFrom(codedInputStream);
            codedInputStream.checkLastTagWas(WireFormat.makeTag(tagFieldNumber, 4));
            storeField(i11, unknownFieldSetLite);
            return true;
        } else if (tagWireType == 4) {
            return false;
        } else {
            if (tagWireType == 5) {
                storeField(i11, Integer.valueOf(codedInputStream.readFixed32()));
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    public UnknownFieldSetLite mergeLengthDelimitedField(int i11, ByteString byteString) {
        checkMutable();
        if (i11 != 0) {
            storeField(WireFormat.makeTag(i11, 2), byteString);
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public UnknownFieldSetLite mergeVarintField(int i11, int i12) {
        checkMutable();
        if (i11 != 0) {
            storeField(WireFormat.makeTag(i11, 0), Long.valueOf((long) i12));
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public final void printWithIndent(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < this.count; i12++) {
            MessageLiteToString.printField(sb2, i11, String.valueOf(WireFormat.getTagFieldNumber(this.tags[i12])), this.objects[i12]);
        }
    }

    public void storeField(int i11, Object obj) {
        checkMutable();
        ensureCapacity(this.count + 1);
        int[] iArr = this.tags;
        int i12 = this.count;
        iArr[i12] = i11;
        this.objects[i12] = obj;
        this.count = i12 + 1;
    }

    public void writeAsMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i11 = 0; i11 < this.count; i11++) {
            codedOutputStream.writeRawMessageSetExtension(WireFormat.getTagFieldNumber(this.tags[i11]), (ByteString) this.objects[i11]);
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i11 = 0; i11 < this.count; i11++) {
            int i12 = this.tags[i11];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i12);
            int tagWireType = WireFormat.getTagWireType(i12);
            if (tagWireType == 0) {
                codedOutputStream.writeUInt64(tagFieldNumber, ((Long) this.objects[i11]).longValue());
            } else if (tagWireType == 1) {
                codedOutputStream.writeFixed64(tagFieldNumber, ((Long) this.objects[i11]).longValue());
            } else if (tagWireType == 2) {
                codedOutputStream.writeBytes(tagFieldNumber, (ByteString) this.objects[i11]);
            } else if (tagWireType == 3) {
                codedOutputStream.writeTag(tagFieldNumber, 3);
                ((UnknownFieldSetLite) this.objects[i11]).writeTo(codedOutputStream);
                codedOutputStream.writeTag(tagFieldNumber, 4);
            } else if (tagWireType == 5) {
                codedOutputStream.writeFixed32(tagFieldNumber, ((Integer) this.objects[i11]).intValue());
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }

    private UnknownFieldSetLite(int i11, int[] iArr, Object[] objArr, boolean z11) {
        this.memoizedSerializedSize = -1;
        this.count = i11;
        this.tags = iArr;
        this.objects = objArr;
        this.isMutable = z11;
    }

    private static int hashCode(Object[] objArr, int i11) {
        int i12 = 17;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 = (i12 * 31) + objArr[i13].hashCode();
        }
        return i12;
    }

    public int hashCode() {
        int i11 = this.count;
        return ((((527 + i11) * 31) + hashCode(this.tags, i11)) * 31) + hashCode(this.objects, this.count);
    }

    @CanIgnoreReturnValue
    public UnknownFieldSetLite mergeFrom(UnknownFieldSetLite unknownFieldSetLite) {
        if (unknownFieldSetLite.equals(getDefaultInstance())) {
            return this;
        }
        checkMutable();
        int i11 = this.count + unknownFieldSetLite.count;
        ensureCapacity(i11);
        System.arraycopy(unknownFieldSetLite.tags, 0, this.tags, this.count, unknownFieldSetLite.count);
        System.arraycopy(unknownFieldSetLite.objects, 0, this.objects, this.count, unknownFieldSetLite.count);
        this.count = i11;
        return this;
    }

    public void writeAsMessageSetTo(Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            for (int i11 = this.count - 1; i11 >= 0; i11--) {
                writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[i11]), this.objects[i11]);
            }
            return;
        }
        for (int i12 = 0; i12 < this.count; i12++) {
            writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[i12]), this.objects[i12]);
        }
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.count != 0) {
            if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
                for (int i11 = 0; i11 < this.count; i11++) {
                    writeField(this.tags[i11], this.objects[i11], writer);
                }
                return;
            }
            for (int i12 = this.count - 1; i12 >= 0; i12--) {
                writeField(this.tags[i12], this.objects[i12], writer);
            }
        }
    }
}
