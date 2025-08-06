package com.google.protobuf;

import com.google.common.base.Ascii;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Objects;

@CheckReturnValue
final class ArrayDecoders {

    /* renamed from: com.google.protobuf.ArrayDecoders$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
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
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.AnonymousClass1.<clinit>():void");
        }
    }

    private ArrayDecoders() {
    }

    public static int decodeBoolList(int i11, byte[] bArr, int i12, int i13, Internal.ProtobufList<?> protobufList, Registers registers) {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i12, registers);
        booleanArrayList.addBoolean(registers.long1 != 0);
        while (decodeVarint64 < i13) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i11 != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            booleanArrayList.addBoolean(registers.long1 != 0);
        }
        return decodeVarint64;
    }

    public static int decodeBytes(byte[] bArr, int i11, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i11, registers);
        int i12 = registers.int1;
        if (i12 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i12 > bArr.length - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        } else if (i12 == 0) {
            registers.object1 = ByteString.EMPTY;
            return decodeVarint32;
        } else {
            registers.object1 = ByteString.copyFrom(bArr, decodeVarint32, i12);
            return decodeVarint32 + i12;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x004d A[EDGE_INSN: B:30:0x004d->B:22:0x004d ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int decodeBytesList(int r2, byte[] r3, int r4, int r5, com.google.protobuf.Internal.ProtobufList<?> r6, com.google.protobuf.ArrayDecoders.Registers r7) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            int r4 = decodeVarint32(r3, r4, r7)
            int r0 = r7.int1
            if (r0 < 0) goto L_0x0053
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x004e
            if (r0 != 0) goto L_0x0014
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L_0x001c
        L_0x0014:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
        L_0x001b:
            int r4 = r4 + r0
        L_0x001c:
            if (r4 >= r5) goto L_0x004d
            int r0 = decodeVarint32(r3, r4, r7)
            int r1 = r7.int1
            if (r2 == r1) goto L_0x0027
            goto L_0x004d
        L_0x0027:
            int r4 = decodeVarint32(r3, r0, r7)
            int r0 = r7.int1
            if (r0 < 0) goto L_0x0048
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x0043
            if (r0 != 0) goto L_0x003b
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L_0x001c
        L_0x003b:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
            goto L_0x001b
        L_0x0043:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r2
        L_0x0048:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r2
        L_0x004d:
            return r4
        L_0x004e:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r2
        L_0x0053:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.decodeBytesList(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    public static double decodeDouble(byte[] bArr, int i11) {
        return Double.longBitsToDouble(decodeFixed64(bArr, i11));
    }

    public static int decodeDoubleList(int i11, byte[] bArr, int i12, int i13, Internal.ProtobufList<?> protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        doubleArrayList.addDouble(decodeDouble(bArr, i12));
        int i14 = i12 + 8;
        while (i14 < i13) {
            int decodeVarint32 = decodeVarint32(bArr, i14, registers);
            if (i11 != registers.int1) {
                break;
            }
            doubleArrayList.addDouble(decodeDouble(bArr, decodeVarint32));
            i14 = decodeVarint32 + 8;
        }
        return i14;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0225, code lost:
        r10 = r10 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0230, code lost:
        r10 = r10 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int decodeExtension(int r8, byte[] r9, int r10, int r11, com.google.protobuf.GeneratedMessageLite.ExtendableMessage<?, ?> r12, com.google.protobuf.GeneratedMessageLite.GeneratedExtension<?, ?> r13, com.google.protobuf.UnknownFieldSchema<com.google.protobuf.UnknownFieldSetLite, com.google.protobuf.UnknownFieldSetLite> r14, com.google.protobuf.ArrayDecoders.Registers r15) throws java.io.IOException {
        /*
            com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor> r0 = r12.extensions
            int r2 = r8 >>> 3
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r13.descriptor
            boolean r8 = r8.isRepeated()
            if (r8 == 0) goto L_0x00ed
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r13.descriptor
            boolean r8 = r8.isPacked()
            if (r8 == 0) goto L_0x00ed
            int[] r8 = com.google.protobuf.ArrayDecoders.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType
            com.google.protobuf.WireFormat$FieldType r11 = r13.getLiteType()
            int r11 = r11.ordinal()
            r8 = r8[r11]
            switch(r8) {
                case 1: goto L_0x00dd;
                case 2: goto L_0x00cd;
                case 3: goto L_0x00bd;
                case 4: goto L_0x00bd;
                case 5: goto L_0x00ad;
                case 6: goto L_0x00ad;
                case 7: goto L_0x009d;
                case 8: goto L_0x009d;
                case 9: goto L_0x008d;
                case 10: goto L_0x008d;
                case 11: goto L_0x007d;
                case 12: goto L_0x006d;
                case 13: goto L_0x005d;
                case 14: goto L_0x0040;
                default: goto L_0x0023;
            }
        L_0x0023:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Type cannot be packed: "
            r9.append(r10)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r13.descriptor
            com.google.protobuf.WireFormat$FieldType r10 = r10.getLiteType()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x0040:
            com.google.protobuf.IntArrayList r8 = new com.google.protobuf.IntArrayList
            r8.<init>()
            int r9 = decodePackedVarint32List(r9, r10, r8, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r13.descriptor
            com.google.protobuf.Internal$EnumLiteMap r4 = r10.getEnumType()
            r5 = 0
            r1 = r12
            r3 = r8
            r6 = r14
            com.google.protobuf.SchemaUtil.filterUnknownEnumList((java.lang.Object) r1, (int) r2, (java.util.List<java.lang.Integer>) r3, (com.google.protobuf.Internal.EnumLiteMap<?>) r4, r5, r6)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r13.descriptor
            r0.setField(r10, r8)
            goto L_0x0244
        L_0x005d:
            com.google.protobuf.LongArrayList r8 = new com.google.protobuf.LongArrayList
            r8.<init>()
            int r9 = decodePackedSInt64List(r9, r10, r8, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r13.descriptor
            r0.setField(r10, r8)
            goto L_0x0244
        L_0x006d:
            com.google.protobuf.IntArrayList r8 = new com.google.protobuf.IntArrayList
            r8.<init>()
            int r9 = decodePackedSInt32List(r9, r10, r8, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r13.descriptor
            r0.setField(r10, r8)
            goto L_0x0244
        L_0x007d:
            com.google.protobuf.BooleanArrayList r8 = new com.google.protobuf.BooleanArrayList
            r8.<init>()
            int r9 = decodePackedBoolList(r9, r10, r8, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r13.descriptor
            r0.setField(r10, r8)
            goto L_0x0244
        L_0x008d:
            com.google.protobuf.IntArrayList r8 = new com.google.protobuf.IntArrayList
            r8.<init>()
            int r9 = decodePackedFixed32List(r9, r10, r8, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r13.descriptor
            r0.setField(r10, r8)
            goto L_0x0244
        L_0x009d:
            com.google.protobuf.LongArrayList r8 = new com.google.protobuf.LongArrayList
            r8.<init>()
            int r9 = decodePackedFixed64List(r9, r10, r8, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r13.descriptor
            r0.setField(r10, r8)
            goto L_0x0244
        L_0x00ad:
            com.google.protobuf.IntArrayList r8 = new com.google.protobuf.IntArrayList
            r8.<init>()
            int r9 = decodePackedVarint32List(r9, r10, r8, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r13.descriptor
            r0.setField(r10, r8)
            goto L_0x0244
        L_0x00bd:
            com.google.protobuf.LongArrayList r8 = new com.google.protobuf.LongArrayList
            r8.<init>()
            int r9 = decodePackedVarint64List(r9, r10, r8, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r13.descriptor
            r0.setField(r10, r8)
            goto L_0x0244
        L_0x00cd:
            com.google.protobuf.FloatArrayList r8 = new com.google.protobuf.FloatArrayList
            r8.<init>()
            int r9 = decodePackedFloatList(r9, r10, r8, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r13.descriptor
            r0.setField(r10, r8)
            goto L_0x0244
        L_0x00dd:
            com.google.protobuf.DoubleArrayList r8 = new com.google.protobuf.DoubleArrayList
            r8.<init>()
            int r9 = decodePackedDoubleList(r9, r10, r8, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r13.descriptor
            r0.setField(r10, r8)
            goto L_0x0244
        L_0x00ed:
            com.google.protobuf.WireFormat$FieldType r8 = r13.getLiteType()
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM
            r3 = 0
            if (r8 != r1) goto L_0x0116
            int r10 = decodeVarint32(r9, r10, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r13.descriptor
            com.google.protobuf.Internal$EnumLiteMap r8 = r8.getEnumType()
            int r9 = r15.int1
            com.google.protobuf.Internal$EnumLite r8 = r8.findValueByNumber(r9)
            if (r8 != 0) goto L_0x010e
            int r8 = r15.int1
            com.google.protobuf.SchemaUtil.storeUnknownEnum(r12, r2, r8, r3, r14)
            return r10
        L_0x010e:
            int r8 = r15.int1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            goto L_0x0232
        L_0x0116:
            int[] r8 = com.google.protobuf.ArrayDecoders.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType
            com.google.protobuf.WireFormat$FieldType r12 = r13.getLiteType()
            int r12 = r12.ordinal()
            r8 = r8[r12]
            switch(r8) {
                case 1: goto L_0x0228;
                case 2: goto L_0x021d;
                case 3: goto L_0x0212;
                case 4: goto L_0x0212;
                case 5: goto L_0x0207;
                case 6: goto L_0x0207;
                case 7: goto L_0x01fe;
                case 8: goto L_0x01fe;
                case 9: goto L_0x01f5;
                case 10: goto L_0x01f5;
                case 11: goto L_0x01e1;
                case 12: goto L_0x01d2;
                case 13: goto L_0x01c3;
                case 14: goto L_0x01bb;
                case 15: goto L_0x01b3;
                case 16: goto L_0x01ab;
                case 17: goto L_0x0164;
                case 18: goto L_0x0127;
                default: goto L_0x0125;
            }
        L_0x0125:
            goto L_0x0232
        L_0x0127:
            com.google.protobuf.Protobuf r8 = com.google.protobuf.Protobuf.getInstance()
            com.google.protobuf.MessageLite r12 = r13.getMessageDefaultInstance()
            java.lang.Class r12 = r12.getClass()
            com.google.protobuf.Schema r2 = r8.schemaFor(r12)
            boolean r8 = r13.isRepeated()
            if (r8 == 0) goto L_0x0149
            int r8 = decodeMessageField(r2, r9, r10, r11, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r13.descriptor
            java.lang.Object r10 = r15.object1
            r0.addRepeatedField(r9, r10)
            goto L_0x0163
        L_0x0149:
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r13.descriptor
            java.lang.Object r8 = r0.getField(r8)
            if (r8 != 0) goto L_0x015a
            java.lang.Object r8 = r2.newInstance()
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r12 = r13.descriptor
            r0.setField(r12, r8)
        L_0x015a:
            r1 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r15
            int r8 = mergeMessageField(r1, r2, r3, r4, r5, r6)
        L_0x0163:
            return r8
        L_0x0164:
            int r8 = r2 << 3
            r6 = r8 | 4
            com.google.protobuf.Protobuf r8 = com.google.protobuf.Protobuf.getInstance()
            com.google.protobuf.MessageLite r12 = r13.getMessageDefaultInstance()
            java.lang.Class r12 = r12.getClass()
            com.google.protobuf.Schema r2 = r8.schemaFor(r12)
            boolean r8 = r13.isRepeated()
            if (r8 == 0) goto L_0x0190
            r1 = r2
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r6
            r6 = r15
            int r8 = decodeGroupField(r1, r2, r3, r4, r5, r6)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r13.descriptor
            java.lang.Object r10 = r15.object1
            r0.addRepeatedField(r9, r10)
            goto L_0x01aa
        L_0x0190:
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r13.descriptor
            java.lang.Object r8 = r0.getField(r8)
            if (r8 != 0) goto L_0x01a1
            java.lang.Object r8 = r2.newInstance()
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r12 = r13.descriptor
            r0.setField(r12, r8)
        L_0x01a1:
            r1 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r7 = r15
            int r8 = mergeGroupField(r1, r2, r3, r4, r5, r6, r7)
        L_0x01aa:
            return r8
        L_0x01ab:
            int r10 = decodeString(r9, r10, r15)
            java.lang.Object r3 = r15.object1
            goto L_0x0232
        L_0x01b3:
            int r10 = decodeBytes(r9, r10, r15)
            java.lang.Object r3 = r15.object1
            goto L_0x0232
        L_0x01bb:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Shouldn't reach here."
            r8.<init>(r9)
            throw r8
        L_0x01c3:
            int r10 = decodeVarint64(r9, r10, r15)
            long r8 = r15.long1
            long r8 = com.google.protobuf.CodedInputStream.decodeZigZag64(r8)
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            goto L_0x0232
        L_0x01d2:
            int r10 = decodeVarint32(r9, r10, r15)
            int r8 = r15.int1
            int r8 = com.google.protobuf.CodedInputStream.decodeZigZag32(r8)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            goto L_0x0232
        L_0x01e1:
            int r10 = decodeVarint64(r9, r10, r15)
            long r8 = r15.long1
            r11 = 0
            int r8 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r8 == 0) goto L_0x01ef
            r8 = 1
            goto L_0x01f0
        L_0x01ef:
            r8 = 0
        L_0x01f0:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r8)
            goto L_0x0232
        L_0x01f5:
            int r8 = decodeFixed32(r9, r10)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            goto L_0x0225
        L_0x01fe:
            long r8 = decodeFixed64(r9, r10)
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            goto L_0x0230
        L_0x0207:
            int r10 = decodeVarint32(r9, r10, r15)
            int r8 = r15.int1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            goto L_0x0232
        L_0x0212:
            int r10 = decodeVarint64(r9, r10, r15)
            long r8 = r15.long1
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            goto L_0x0232
        L_0x021d:
            float r8 = decodeFloat(r9, r10)
            java.lang.Float r3 = java.lang.Float.valueOf(r8)
        L_0x0225:
            int r10 = r10 + 4
            goto L_0x0232
        L_0x0228:
            double r8 = decodeDouble(r9, r10)
            java.lang.Double r3 = java.lang.Double.valueOf(r8)
        L_0x0230:
            int r10 = r10 + 8
        L_0x0232:
            boolean r8 = r13.isRepeated()
            if (r8 == 0) goto L_0x023e
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r13.descriptor
            r0.addRepeatedField(r8, r3)
            goto L_0x0243
        L_0x023e:
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r13.descriptor
            r0.setField(r8, r3)
        L_0x0243:
            r9 = r10
        L_0x0244:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.decodeExtension(int, byte[], int, int, com.google.protobuf.GeneratedMessageLite$ExtendableMessage, com.google.protobuf.GeneratedMessageLite$GeneratedExtension, com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    public static int decodeExtensionOrUnknownField(int i11, byte[] bArr, int i12, int i13, Object obj, MessageLite messageLite, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        GeneratedMessageLite.GeneratedExtension findLiteExtensionByNumber = registers.extensionRegistry.findLiteExtensionByNumber(messageLite, i11 >>> 3);
        if (findLiteExtensionByNumber == null) {
            return decodeUnknownField(i11, bArr, i12, i13, MessageSchema.getMutableUnknownFields(obj), registers);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.ensureExtensionsAreMutable();
        return decodeExtension(i11, bArr, i12, i13, extendableMessage, findLiteExtensionByNumber, unknownFieldSchema, registers);
    }

    public static int decodeFixed32(byte[] bArr, int i11) {
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
    }

    public static int decodeFixed32List(int i11, byte[] bArr, int i12, int i13, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        intArrayList.addInt(decodeFixed32(bArr, i12));
        int i14 = i12 + 4;
        while (i14 < i13) {
            int decodeVarint32 = decodeVarint32(bArr, i14, registers);
            if (i11 != registers.int1) {
                break;
            }
            intArrayList.addInt(decodeFixed32(bArr, decodeVarint32));
            i14 = decodeVarint32 + 4;
        }
        return i14;
    }

    public static long decodeFixed64(byte[] bArr, int i11) {
        return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
    }

    public static int decodeFixed64List(int i11, byte[] bArr, int i12, int i13, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        longArrayList.addLong(decodeFixed64(bArr, i12));
        int i14 = i12 + 8;
        while (i14 < i13) {
            int decodeVarint32 = decodeVarint32(bArr, i14, registers);
            if (i11 != registers.int1) {
                break;
            }
            longArrayList.addLong(decodeFixed64(bArr, decodeVarint32));
            i14 = decodeVarint32 + 8;
        }
        return i14;
    }

    public static float decodeFloat(byte[] bArr, int i11) {
        return Float.intBitsToFloat(decodeFixed32(bArr, i11));
    }

    public static int decodeFloatList(int i11, byte[] bArr, int i12, int i13, Internal.ProtobufList<?> protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        floatArrayList.addFloat(decodeFloat(bArr, i12));
        int i14 = i12 + 4;
        while (i14 < i13) {
            int decodeVarint32 = decodeVarint32(bArr, i14, registers);
            if (i11 != registers.int1) {
                break;
            }
            floatArrayList.addFloat(decodeFloat(bArr, decodeVarint32));
            i14 = decodeVarint32 + 4;
        }
        return i14;
    }

    public static int decodeGroupField(Schema schema, byte[] bArr, int i11, int i12, int i13, Registers registers) throws IOException {
        Object newInstance = schema.newInstance();
        int mergeGroupField = mergeGroupField(newInstance, schema, bArr, i11, i12, i13, registers);
        schema.makeImmutable(newInstance);
        registers.object1 = newInstance;
        return mergeGroupField;
    }

    public static int decodeGroupList(Schema schema, int i11, byte[] bArr, int i12, int i13, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int i14 = (i11 & -8) | 4;
        int decodeGroupField = decodeGroupField(schema, bArr, i12, i13, i14, registers);
        protobufList.add(registers.object1);
        while (decodeGroupField < i13) {
            int decodeVarint32 = decodeVarint32(bArr, decodeGroupField, registers);
            if (i11 != registers.int1) {
                break;
            }
            decodeGroupField = decodeGroupField(schema, bArr, decodeVarint32, i13, i14, registers);
            protobufList.add(registers.object1);
        }
        return decodeGroupField;
    }

    public static int decodeMessageField(Schema schema, byte[] bArr, int i11, int i12, Registers registers) throws IOException {
        Object newInstance = schema.newInstance();
        int mergeMessageField = mergeMessageField(newInstance, schema, bArr, i11, i12, registers);
        schema.makeImmutable(newInstance);
        registers.object1 = newInstance;
        return mergeMessageField;
    }

    public static int decodeMessageList(Schema<?> schema, int i11, byte[] bArr, int i12, int i13, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int decodeMessageField = decodeMessageField(schema, bArr, i12, i13, registers);
        protobufList.add(registers.object1);
        while (decodeMessageField < i13) {
            int decodeVarint32 = decodeVarint32(bArr, decodeMessageField, registers);
            if (i11 != registers.int1) {
                break;
            }
            decodeMessageField = decodeMessageField(schema, bArr, decodeVarint32, i13, registers);
            protobufList.add(registers.object1);
        }
        return decodeMessageField;
    }

    public static int decodePackedBoolList(byte[] bArr, int i11, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i11, registers);
        int i12 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            booleanArrayList.addBoolean(registers.long1 != 0);
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedDoubleList(byte[] bArr, int i11, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i11, registers);
        int i12 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            doubleArrayList.addDouble(decodeDouble(bArr, decodeVarint32));
            decodeVarint32 += 8;
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed32List(byte[] bArr, int i11, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i11, registers);
        int i12 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            intArrayList.addInt(decodeFixed32(bArr, decodeVarint32));
            decodeVarint32 += 4;
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed64List(byte[] bArr, int i11, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i11, registers);
        int i12 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            longArrayList.addLong(decodeFixed64(bArr, decodeVarint32));
            decodeVarint32 += 8;
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFloatList(byte[] bArr, int i11, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i11, registers);
        int i12 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            floatArrayList.addFloat(decodeFloat(bArr, decodeVarint32));
            decodeVarint32 += 4;
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt32List(byte[] bArr, int i11, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i11, registers);
        int i12 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            decodeVarint32 = decodeVarint32(bArr, decodeVarint32, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt64List(byte[] bArr, int i11, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i11, registers);
        int i12 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint32List(byte[] bArr, int i11, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i11, registers);
        int i12 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            decodeVarint32 = decodeVarint32(bArr, decodeVarint32, registers);
            intArrayList.addInt(registers.int1);
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint64List(byte[] bArr, int i11, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i11, registers);
        int i12 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i12) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        if (decodeVarint32 == i12) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodeSInt32List(int i11, byte[] bArr, int i12, int i13, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i12, registers);
        intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        while (decodeVarint32 < i13) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (i11 != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        return decodeVarint32;
    }

    public static int decodeSInt64List(int i11, byte[] bArr, int i12, int i13, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i12, registers);
        longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        while (decodeVarint64 < i13) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i11 != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        return decodeVarint64;
    }

    public static int decodeString(byte[] bArr, int i11, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i11, registers);
        int i12 = registers.int1;
        if (i12 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i12 == 0) {
            registers.object1 = "";
            return decodeVarint32;
        } else {
            registers.object1 = new String(bArr, decodeVarint32, i12, Internal.UTF_8);
            return decodeVarint32 + i12;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[EDGE_INSN: B:21:0x0044->B:17:0x0044 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    public static int decodeStringList(int r4, byte[] r5, int r6, int r7, com.google.protobuf.Internal.ProtobufList<?> r8, com.google.protobuf.ArrayDecoders.Registers r9) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            int r6 = decodeVarint32(r5, r6, r9)
            int r0 = r9.int1
            if (r0 < 0) goto L_0x0045
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            r8.add(r1)
            goto L_0x001b
        L_0x0010:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.protobuf.Internal.UTF_8
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
        L_0x001a:
            int r6 = r6 + r0
        L_0x001b:
            if (r6 >= r7) goto L_0x0044
            int r0 = decodeVarint32(r5, r6, r9)
            int r2 = r9.int1
            if (r4 == r2) goto L_0x0026
            goto L_0x0044
        L_0x0026:
            int r6 = decodeVarint32(r5, r0, r9)
            int r0 = r9.int1
            if (r0 < 0) goto L_0x003f
            if (r0 != 0) goto L_0x0034
            r8.add(r1)
            goto L_0x001b
        L_0x0034:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.protobuf.Internal.UTF_8
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
            goto L_0x001a
        L_0x003f:
            com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r4
        L_0x0044:
            return r6
        L_0x0045:
            com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.decodeStringList(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        r2 = r7 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (com.google.protobuf.Utf8.isValidUtf8(r6, r7, r2) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        r9.add(new java.lang.String(r6, r7, r0, com.google.protobuf.Internal.UTF_8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059 A[EDGE_INSN: B:28:0x0059->B:23:0x0059 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int decodeStringListRequireUtf8(int r5, byte[] r6, int r7, int r8, com.google.protobuf.Internal.ProtobufList<?> r9, com.google.protobuf.ArrayDecoders.Registers r10) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            int r7 = decodeVarint32(r6, r7, r10)
            int r0 = r10.int1
            if (r0 < 0) goto L_0x005f
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            r9.add(r1)
            goto L_0x0023
        L_0x0010:
            int r2 = r7 + r0
            boolean r3 = com.google.protobuf.Utf8.isValidUtf8(r6, r7, r2)
            if (r3 == 0) goto L_0x005a
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.protobuf.Internal.UTF_8
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
        L_0x0022:
            r7 = r2
        L_0x0023:
            if (r7 >= r8) goto L_0x0059
            int r0 = decodeVarint32(r6, r7, r10)
            int r2 = r10.int1
            if (r5 == r2) goto L_0x002e
            goto L_0x0059
        L_0x002e:
            int r7 = decodeVarint32(r6, r0, r10)
            int r0 = r10.int1
            if (r0 < 0) goto L_0x0054
            if (r0 != 0) goto L_0x003c
            r9.add(r1)
            goto L_0x0023
        L_0x003c:
            int r2 = r7 + r0
            boolean r3 = com.google.protobuf.Utf8.isValidUtf8(r6, r7, r2)
            if (r3 == 0) goto L_0x004f
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.protobuf.Internal.UTF_8
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
            goto L_0x0022
        L_0x004f:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.invalidUtf8()
            throw r5
        L_0x0054:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r5
        L_0x0059:
            return r7
        L_0x005a:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.invalidUtf8()
            throw r5
        L_0x005f:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.decodeStringListRequireUtf8(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    public static int decodeStringRequireUtf8(byte[] bArr, int i11, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i11, registers);
        int i12 = registers.int1;
        if (i12 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i12 == 0) {
            registers.object1 = "";
            return decodeVarint32;
        } else {
            registers.object1 = Utf8.decodeUtf8(bArr, decodeVarint32, i12);
            return decodeVarint32 + i12;
        }
    }

    public static int decodeUnknownField(int i11, byte[] bArr, int i12, int i13, UnknownFieldSetLite unknownFieldSetLite, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i11) != 0) {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                int decodeVarint64 = decodeVarint64(bArr, i12, registers);
                unknownFieldSetLite.storeField(i11, Long.valueOf(registers.long1));
                return decodeVarint64;
            } else if (tagWireType == 1) {
                unknownFieldSetLite.storeField(i11, Long.valueOf(decodeFixed64(bArr, i12)));
                return i12 + 8;
            } else if (tagWireType == 2) {
                int decodeVarint32 = decodeVarint32(bArr, i12, registers);
                int i14 = registers.int1;
                if (i14 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                } else if (i14 <= bArr.length - decodeVarint32) {
                    if (i14 == 0) {
                        unknownFieldSetLite.storeField(i11, ByteString.EMPTY);
                    } else {
                        unknownFieldSetLite.storeField(i11, ByteString.copyFrom(bArr, decodeVarint32, i14));
                    }
                    return decodeVarint32 + i14;
                } else {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } else if (tagWireType == 3) {
                UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
                int i15 = (i11 & -8) | 4;
                int i16 = 0;
                while (true) {
                    if (i12 >= i13) {
                        break;
                    }
                    int decodeVarint322 = decodeVarint32(bArr, i12, registers);
                    int i17 = registers.int1;
                    if (i17 == i15) {
                        i16 = i17;
                        i12 = decodeVarint322;
                        break;
                    }
                    i16 = i17;
                    i12 = decodeUnknownField(i17, bArr, decodeVarint322, i13, newInstance, registers);
                }
                if (i12 > i13 || i16 != i15) {
                    throw InvalidProtocolBufferException.parseFailure();
                }
                unknownFieldSetLite.storeField(i11, newInstance);
                return i12;
            } else if (tagWireType == 5) {
                unknownFieldSetLite.storeField(i11, Integer.valueOf(decodeFixed32(bArr, i12)));
                return i12 + 4;
            } else {
                throw InvalidProtocolBufferException.invalidTag();
            }
        } else {
            throw InvalidProtocolBufferException.invalidTag();
        }
    }

    public static int decodeVarint32(byte[] bArr, int i11, Registers registers) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return decodeVarint32(b11, bArr, i12, registers);
        }
        registers.int1 = b11;
        return i12;
    }

    public static int decodeVarint32List(int i11, byte[] bArr, int i12, int i13, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i12, registers);
        intArrayList.addInt(registers.int1);
        while (decodeVarint32 < i13) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (i11 != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
            intArrayList.addInt(registers.int1);
        }
        return decodeVarint32;
    }

    public static int decodeVarint64(byte[] bArr, int i11, Registers registers) {
        int i12 = i11 + 1;
        long j11 = (long) bArr[i11];
        if (j11 < 0) {
            return decodeVarint64(j11, bArr, i12, registers);
        }
        registers.long1 = j11;
        return i12;
    }

    public static int decodeVarint64List(int i11, byte[] bArr, int i12, int i13, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i12, registers);
        longArrayList.addLong(registers.long1);
        while (decodeVarint64 < i13) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i11 != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        return decodeVarint64;
    }

    public static int mergeGroupField(Object obj, Schema schema, byte[] bArr, int i11, int i12, int i13, Registers registers) throws IOException {
        int parseProto2Message = ((MessageSchema) schema).parseProto2Message(obj, bArr, i11, i12, i13, registers);
        registers.object1 = obj;
        return parseProto2Message;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int mergeMessageField(java.lang.Object r6, com.google.protobuf.Schema r7, byte[] r8, int r9, int r10, com.google.protobuf.ArrayDecoders.Registers r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = decodeVarint32(r9, r8, r0, r11)
            int r9 = r11.int1
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x001e
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x001e
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.mergeFrom(r1, r2, r3, r4, r5)
            r11.object1 = r6
            return r9
        L_0x001e:
            com.google.protobuf.InvalidProtocolBufferException r6 = com.google.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.mergeMessageField(java.lang.Object, com.google.protobuf.Schema, byte[], int, int, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    public static int skipField(int i11, byte[] bArr, int i12, int i13, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i11) != 0) {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                return decodeVarint64(bArr, i12, registers);
            }
            if (tagWireType == 1) {
                return i12 + 8;
            }
            if (tagWireType == 2) {
                return decodeVarint32(bArr, i12, registers) + registers.int1;
            }
            if (tagWireType == 3) {
                int i14 = (i11 & -8) | 4;
                int i15 = 0;
                while (i12 < i13) {
                    i12 = decodeVarint32(bArr, i12, registers);
                    i15 = registers.int1;
                    if (i15 == i14) {
                        break;
                    }
                    i12 = skipField(i15, bArr, i12, i13, registers);
                }
                if (i12 <= i13 && i15 == i14) {
                    return i12;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } else if (tagWireType == 5) {
                return i12 + 4;
            } else {
                throw InvalidProtocolBufferException.invalidTag();
            }
        } else {
            throw InvalidProtocolBufferException.invalidTag();
        }
    }

    public static final class Registers {
        public final ExtensionRegistryLite extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;

        public Registers() {
            this.extensionRegistry = ExtensionRegistryLite.getEmptyRegistry();
        }

        public Registers(ExtensionRegistryLite extensionRegistryLite) {
            Objects.requireNonNull(extensionRegistryLite);
            this.extensionRegistry = extensionRegistryLite;
        }
    }

    public static int decodeVarint32(int i11, byte[] bArr, int i12, Registers registers) {
        int i13 = i11 & 127;
        int i14 = i12 + 1;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            registers.int1 = i13 | (b11 << 7);
            return i14;
        }
        int i15 = i13 | ((b11 & Ascii.DEL) << 7);
        int i16 = i14 + 1;
        byte b12 = bArr[i14];
        if (b12 >= 0) {
            registers.int1 = i15 | (b12 << 14);
            return i16;
        }
        int i17 = i15 | ((b12 & Ascii.DEL) << 14);
        int i18 = i16 + 1;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            registers.int1 = i17 | (b13 << 21);
            return i18;
        }
        int i19 = i17 | ((b13 & Ascii.DEL) << 21);
        int i21 = i18 + 1;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            registers.int1 = i19 | (b14 << 28);
            return i21;
        }
        int i22 = i19 | ((b14 & Ascii.DEL) << 28);
        while (true) {
            int i23 = i21 + 1;
            if (bArr[i21] < 0) {
                i21 = i23;
            } else {
                registers.int1 = i22;
                return i23;
            }
        }
    }

    public static int decodeVarint64(long j11, byte[] bArr, int i11, Registers registers) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        long j12 = (j11 & 127) | (((long) (b11 & Ascii.DEL)) << 7);
        int i13 = 7;
        while (b11 < 0) {
            int i14 = i12 + 1;
            byte b12 = bArr[i12];
            i13 += 7;
            j12 |= ((long) (b12 & Ascii.DEL)) << i13;
            byte b13 = b12;
            i12 = i14;
            b11 = b13;
        }
        registers.long1 = j12;
        return i12;
    }
}
