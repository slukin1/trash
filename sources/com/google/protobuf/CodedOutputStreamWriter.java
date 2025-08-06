package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@CheckReturnValue
final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    /* renamed from: com.google.protobuf.CodedOutputStreamWriter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
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
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x003e }
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
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedOutputStreamWriter.AnonymousClass1.<clinit>():void");
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.checkNotNull(codedOutputStream, "output");
        this.output = codedOutputStream2;
        codedOutputStream2.wrapper = this;
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.wrapper;
        if (codedOutputStreamWriter != null) {
            return codedOutputStreamWriter;
        }
        return new CodedOutputStreamWriter(codedOutputStream);
    }

    private <V> void writeDeterministicBooleanMapEntry(int i11, boolean z11, V v11, MapEntryLite.Metadata<Boolean, V> metadata) throws IOException {
        this.output.writeTag(i11, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Boolean.valueOf(z11), v11));
        MapEntryLite.writeTo(this.output, metadata, Boolean.valueOf(z11), v11);
    }

    private <V> void writeDeterministicIntegerMap(int i11, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) throws IOException {
        int size = map.size();
        int[] iArr = new int[size];
        int i12 = 0;
        for (Integer intValue : map.keySet()) {
            iArr[i12] = intValue.intValue();
            i12++;
        }
        Arrays.sort(iArr);
        for (int i13 = 0; i13 < size; i13++) {
            int i14 = iArr[i13];
            V v11 = map.get(Integer.valueOf(i14));
            this.output.writeTag(i11, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Integer.valueOf(i14), v11));
            MapEntryLite.writeTo(this.output, metadata, Integer.valueOf(i14), v11);
        }
    }

    private <V> void writeDeterministicLongMap(int i11, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) throws IOException {
        int size = map.size();
        long[] jArr = new long[size];
        int i12 = 0;
        for (Long longValue : map.keySet()) {
            jArr[i12] = longValue.longValue();
            i12++;
        }
        Arrays.sort(jArr);
        for (int i13 = 0; i13 < size; i13++) {
            long j11 = jArr[i13];
            V v11 = map.get(Long.valueOf(j11));
            this.output.writeTag(i11, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Long.valueOf(j11), v11));
            MapEntryLite.writeTo(this.output, metadata, Long.valueOf(j11), v11);
        }
    }

    private <K, V> void writeDeterministicMap(int i11, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[metadata.keyType.ordinal()]) {
            case 1:
                V v11 = map.get(Boolean.FALSE);
                if (v11 != null) {
                    writeDeterministicBooleanMapEntry(i11, false, v11, metadata);
                }
                V v12 = map.get(Boolean.TRUE);
                if (v12 != null) {
                    writeDeterministicBooleanMapEntry(i11, true, v12, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                writeDeterministicIntegerMap(i11, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                writeDeterministicLongMap(i11, metadata, map);
                return;
            case 12:
                writeDeterministicStringMap(i11, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.keyType);
        }
    }

    private <V> void writeDeterministicStringMap(int i11, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) throws IOException {
        int size = map.size();
        String[] strArr = new String[size];
        int i12 = 0;
        for (String str : map.keySet()) {
            strArr[i12] = str;
            i12++;
        }
        Arrays.sort(strArr);
        for (int i13 = 0; i13 < size; i13++) {
            String str2 = strArr[i13];
            V v11 = map.get(str2);
            this.output.writeTag(i11, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, str2, v11));
            MapEntryLite.writeTo(this.output, metadata, str2, v11);
        }
    }

    private void writeLazyString(int i11, Object obj) throws IOException {
        if (obj instanceof String) {
            this.output.writeString(i11, (String) obj);
        } else {
            this.output.writeBytes(i11, (ByteString) obj);
        }
    }

    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    public void writeBool(int i11, boolean z11) throws IOException {
        this.output.writeBool(i11, z11);
    }

    public void writeBoolList(int i11, List<Boolean> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.output.writeTag(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.computeBoolSizeNoTag(list.get(i14).booleanValue());
            }
            this.output.writeUInt32NoTag(i13);
            while (i12 < list.size()) {
                this.output.writeBoolNoTag(list.get(i12).booleanValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.output.writeBool(i11, list.get(i12).booleanValue());
            i12++;
        }
    }

    public void writeBytes(int i11, ByteString byteString) throws IOException {
        this.output.writeBytes(i11, byteString);
    }

    public void writeBytesList(int i11, List<ByteString> list) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.output.writeBytes(i11, list.get(i12));
        }
    }

    public void writeDouble(int i11, double d11) throws IOException {
        this.output.writeDouble(i11, d11);
    }

    public void writeDoubleList(int i11, List<Double> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.output.writeTag(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.computeDoubleSizeNoTag(list.get(i14).doubleValue());
            }
            this.output.writeUInt32NoTag(i13);
            while (i12 < list.size()) {
                this.output.writeDoubleNoTag(list.get(i12).doubleValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.output.writeDouble(i11, list.get(i12).doubleValue());
            i12++;
        }
    }

    @Deprecated
    public void writeEndGroup(int i11) throws IOException {
        this.output.writeTag(i11, 4);
    }

    public void writeEnum(int i11, int i12) throws IOException {
        this.output.writeEnum(i11, i12);
    }

    public void writeEnumList(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.output.writeTag(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.computeEnumSizeNoTag(list.get(i14).intValue());
            }
            this.output.writeUInt32NoTag(i13);
            while (i12 < list.size()) {
                this.output.writeEnumNoTag(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.output.writeEnum(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public void writeFixed32(int i11, int i12) throws IOException {
        this.output.writeFixed32(i11, i12);
    }

    public void writeFixed32List(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.output.writeTag(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.computeFixed32SizeNoTag(list.get(i14).intValue());
            }
            this.output.writeUInt32NoTag(i13);
            while (i12 < list.size()) {
                this.output.writeFixed32NoTag(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.output.writeFixed32(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public void writeFixed64(int i11, long j11) throws IOException {
        this.output.writeFixed64(i11, j11);
    }

    public void writeFixed64List(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.output.writeTag(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.computeFixed64SizeNoTag(list.get(i14).longValue());
            }
            this.output.writeUInt32NoTag(i13);
            while (i12 < list.size()) {
                this.output.writeFixed64NoTag(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.output.writeFixed64(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public void writeFloat(int i11, float f11) throws IOException {
        this.output.writeFloat(i11, f11);
    }

    public void writeFloatList(int i11, List<Float> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.output.writeTag(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.computeFloatSizeNoTag(list.get(i14).floatValue());
            }
            this.output.writeUInt32NoTag(i13);
            while (i12 < list.size()) {
                this.output.writeFloatNoTag(list.get(i12).floatValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.output.writeFloat(i11, list.get(i12).floatValue());
            i12++;
        }
    }

    @Deprecated
    public void writeGroup(int i11, Object obj) throws IOException {
        this.output.writeGroup(i11, (MessageLite) obj);
    }

    @Deprecated
    public void writeGroupList(int i11, List<?> list) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            writeGroup(i11, list.get(i12));
        }
    }

    public void writeInt32(int i11, int i12) throws IOException {
        this.output.writeInt32(i11, i12);
    }

    public void writeInt32List(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.output.writeTag(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.computeInt32SizeNoTag(list.get(i14).intValue());
            }
            this.output.writeUInt32NoTag(i13);
            while (i12 < list.size()) {
                this.output.writeInt32NoTag(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.output.writeInt32(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public void writeInt64(int i11, long j11) throws IOException {
        this.output.writeInt64(i11, j11);
    }

    public void writeInt64List(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.output.writeTag(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.computeInt64SizeNoTag(list.get(i14).longValue());
            }
            this.output.writeUInt32NoTag(i13);
            while (i12 < list.size()) {
                this.output.writeInt64NoTag(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.output.writeInt64(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public <K, V> void writeMap(int i11, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        if (this.output.isSerializationDeterministic()) {
            writeDeterministicMap(i11, metadata, map);
            return;
        }
        for (Map.Entry next : map.entrySet()) {
            this.output.writeTag(i11, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, next.getKey(), next.getValue()));
            MapEntryLite.writeTo(this.output, metadata, next.getKey(), next.getValue());
        }
    }

    public void writeMessage(int i11, Object obj) throws IOException {
        this.output.writeMessage(i11, (MessageLite) obj);
    }

    public void writeMessageList(int i11, List<?> list) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            writeMessage(i11, list.get(i12));
        }
    }

    public final void writeMessageSetItem(int i11, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.output.writeRawMessageSetExtension(i11, (ByteString) obj);
        } else {
            this.output.writeMessageSetExtension(i11, (MessageLite) obj);
        }
    }

    public void writeSFixed32(int i11, int i12) throws IOException {
        this.output.writeSFixed32(i11, i12);
    }

    public void writeSFixed32List(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.output.writeTag(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i14).intValue());
            }
            this.output.writeUInt32NoTag(i13);
            while (i12 < list.size()) {
                this.output.writeSFixed32NoTag(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.output.writeSFixed32(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public void writeSFixed64(int i11, long j11) throws IOException {
        this.output.writeSFixed64(i11, j11);
    }

    public void writeSFixed64List(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.output.writeTag(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i14).longValue());
            }
            this.output.writeUInt32NoTag(i13);
            while (i12 < list.size()) {
                this.output.writeSFixed64NoTag(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.output.writeSFixed64(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public void writeSInt32(int i11, int i12) throws IOException {
        this.output.writeSInt32(i11, i12);
    }

    public void writeSInt32List(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.output.writeTag(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i14).intValue());
            }
            this.output.writeUInt32NoTag(i13);
            while (i12 < list.size()) {
                this.output.writeSInt32NoTag(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.output.writeSInt32(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public void writeSInt64(int i11, long j11) throws IOException {
        this.output.writeSInt64(i11, j11);
    }

    public void writeSInt64List(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.output.writeTag(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i14).longValue());
            }
            this.output.writeUInt32NoTag(i13);
            while (i12 < list.size()) {
                this.output.writeSInt64NoTag(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.output.writeSInt64(i11, list.get(i12).longValue());
            i12++;
        }
    }

    @Deprecated
    public void writeStartGroup(int i11) throws IOException {
        this.output.writeTag(i11, 3);
    }

    public void writeString(int i11, String str) throws IOException {
        this.output.writeString(i11, str);
    }

    public void writeStringList(int i11, List<String> list) throws IOException {
        int i12 = 0;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i12 < list.size()) {
                writeLazyString(i11, lazyStringList.getRaw(i12));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.output.writeString(i11, list.get(i12));
            i12++;
        }
    }

    public void writeUInt32(int i11, int i12) throws IOException {
        this.output.writeUInt32(i11, i12);
    }

    public void writeUInt32List(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.output.writeTag(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i14).intValue());
            }
            this.output.writeUInt32NoTag(i13);
            while (i12 < list.size()) {
                this.output.writeUInt32NoTag(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.output.writeUInt32(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public void writeUInt64(int i11, long j11) throws IOException {
        this.output.writeUInt64(i11, j11);
    }

    public void writeUInt64List(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.output.writeTag(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i14).longValue());
            }
            this.output.writeUInt32NoTag(i13);
            while (i12 < list.size()) {
                this.output.writeUInt64NoTag(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.output.writeUInt64(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public void writeGroup(int i11, Object obj, Schema schema) throws IOException {
        this.output.writeGroup(i11, (MessageLite) obj, schema);
    }

    public void writeMessage(int i11, Object obj, Schema schema) throws IOException {
        this.output.writeMessage(i11, (MessageLite) obj, schema);
    }

    public void writeGroupList(int i11, List<?> list, Schema schema) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            writeGroup(i11, list.get(i12), schema);
        }
    }

    public void writeMessageList(int i11, List<?> list, Schema schema) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            writeMessage(i11, list.get(i12), schema);
        }
    }
}
