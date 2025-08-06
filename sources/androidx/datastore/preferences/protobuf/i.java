package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Writer;
import androidx.datastore.preferences.protobuf.z;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class i implements Writer {

    /* renamed from: a  reason: collision with root package name */
    public final CodedOutputStream f9148a;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9149a;

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
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9149a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9149a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9149a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9149a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9149a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9149a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f9149a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f9149a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f9149a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f9149a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f9149a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f9149a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.i.a.<clinit>():void");
        }
    }

    public i(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) u.b(codedOutputStream, "output");
        this.f9148a = codedOutputStream2;
        codedOutputStream2.f8988a = this;
    }

    public static i g(CodedOutputStream codedOutputStream) {
        i iVar = codedOutputStream.f8988a;
        if (iVar != null) {
            return iVar;
        }
        return new i(codedOutputStream);
    }

    public void a(int i11, ByteString byteString) throws IOException {
        this.f9148a.p0(i11, byteString);
    }

    public void b(int i11, Object obj, t0 t0Var) throws IOException {
        this.f9148a.J0(i11, (f0) obj, t0Var);
    }

    public <K, V> void c(int i11, z.a<K, V> aVar, Map<K, V> map) throws IOException {
        if (this.f9148a.f0()) {
            k(i11, aVar, map);
            return;
        }
        for (Map.Entry next : map.entrySet()) {
            this.f9148a.X0(i11, 2);
            this.f9148a.Z0(z.b(aVar, next.getKey(), next.getValue()));
            z.e(this.f9148a, aVar, next.getKey(), next.getValue());
        }
    }

    public void d(int i11, List<?> list, t0 t0Var) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            e(i11, list.get(i12), t0Var);
        }
    }

    public void e(int i11, Object obj, t0 t0Var) throws IOException {
        this.f9148a.C0(i11, (f0) obj, t0Var);
    }

    public void f(int i11, List<?> list, t0 t0Var) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            b(i11, list.get(i12), t0Var);
        }
    }

    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public final <V> void h(int i11, boolean z11, V v11, z.a<Boolean, V> aVar) throws IOException {
        this.f9148a.X0(i11, 2);
        this.f9148a.Z0(z.b(aVar, Boolean.valueOf(z11), v11));
        z.e(this.f9148a, aVar, Boolean.valueOf(z11), v11);
    }

    public final <V> void i(int i11, z.a<Integer, V> aVar, Map<Integer, V> map) throws IOException {
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
            this.f9148a.X0(i11, 2);
            this.f9148a.Z0(z.b(aVar, Integer.valueOf(i14), v11));
            z.e(this.f9148a, aVar, Integer.valueOf(i14), v11);
        }
    }

    public final <V> void j(int i11, z.a<Long, V> aVar, Map<Long, V> map) throws IOException {
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
            this.f9148a.X0(i11, 2);
            this.f9148a.Z0(z.b(aVar, Long.valueOf(j11), v11));
            z.e(this.f9148a, aVar, Long.valueOf(j11), v11);
        }
    }

    public final <K, V> void k(int i11, z.a<K, V> aVar, Map<K, V> map) throws IOException {
        switch (a.f9149a[aVar.f9256a.ordinal()]) {
            case 1:
                V v11 = map.get(Boolean.FALSE);
                if (v11 != null) {
                    h(i11, false, v11, aVar);
                }
                V v12 = map.get(Boolean.TRUE);
                if (v12 != null) {
                    h(i11, true, v12, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                i(i11, aVar, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                j(i11, aVar, map);
                return;
            case 12:
                l(i11, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.f9256a);
        }
    }

    public final <V> void l(int i11, z.a<String, V> aVar, Map<String, V> map) throws IOException {
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
            this.f9148a.X0(i11, 2);
            this.f9148a.Z0(z.b(aVar, str2, v11));
            z.e(this.f9148a, aVar, str2, v11);
        }
    }

    public final void m(int i11, Object obj) throws IOException {
        if (obj instanceof String) {
            this.f9148a.V0(i11, (String) obj);
        } else {
            this.f9148a.p0(i11, (ByteString) obj);
        }
    }

    public void writeBool(int i11, boolean z11) throws IOException {
        this.f9148a.l0(i11, z11);
    }

    public void writeBoolList(int i11, List<Boolean> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.f9148a.X0(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.f(list.get(i14).booleanValue());
            }
            this.f9148a.Z0(i13);
            while (i12 < list.size()) {
                this.f9148a.m0(list.get(i12).booleanValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.f9148a.l0(i11, list.get(i12).booleanValue());
            i12++;
        }
    }

    public void writeBytesList(int i11, List<ByteString> list) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.f9148a.p0(i11, list.get(i12));
        }
    }

    public void writeDouble(int i11, double d11) throws IOException {
        this.f9148a.r0(i11, d11);
    }

    public void writeDoubleList(int i11, List<Double> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.f9148a.X0(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.k(list.get(i14).doubleValue());
            }
            this.f9148a.Z0(i13);
            while (i12 < list.size()) {
                this.f9148a.s0(list.get(i12).doubleValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.f9148a.r0(i11, list.get(i12).doubleValue());
            i12++;
        }
    }

    public void writeEndGroup(int i11) throws IOException {
        this.f9148a.X0(i11, 4);
    }

    public void writeEnum(int i11, int i12) throws IOException {
        this.f9148a.t0(i11, i12);
    }

    public void writeEnumList(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.f9148a.X0(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.m(list.get(i14).intValue());
            }
            this.f9148a.Z0(i13);
            while (i12 < list.size()) {
                this.f9148a.u0(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.f9148a.t0(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public void writeFixed32(int i11, int i12) throws IOException {
        this.f9148a.v0(i11, i12);
    }

    public void writeFixed32List(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.f9148a.X0(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.o(list.get(i14).intValue());
            }
            this.f9148a.Z0(i13);
            while (i12 < list.size()) {
                this.f9148a.w0(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.f9148a.v0(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public void writeFixed64(int i11, long j11) throws IOException {
        this.f9148a.x0(i11, j11);
    }

    public void writeFixed64List(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.f9148a.X0(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.q(list.get(i14).longValue());
            }
            this.f9148a.Z0(i13);
            while (i12 < list.size()) {
                this.f9148a.y0(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.f9148a.x0(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public void writeFloat(int i11, float f11) throws IOException {
        this.f9148a.z0(i11, f11);
    }

    public void writeFloatList(int i11, List<Float> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.f9148a.X0(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.s(list.get(i14).floatValue());
            }
            this.f9148a.Z0(i13);
            while (i12 < list.size()) {
                this.f9148a.A0(list.get(i12).floatValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.f9148a.z0(i11, list.get(i12).floatValue());
            i12++;
        }
    }

    public void writeInt32(int i11, int i12) throws IOException {
        this.f9148a.F0(i11, i12);
    }

    public void writeInt32List(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.f9148a.X0(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.x(list.get(i14).intValue());
            }
            this.f9148a.Z0(i13);
            while (i12 < list.size()) {
                this.f9148a.G0(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.f9148a.F0(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public void writeInt64(int i11, long j11) throws IOException {
        this.f9148a.H0(i11, j11);
    }

    public void writeInt64List(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.f9148a.X0(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.z(list.get(i14).longValue());
            }
            this.f9148a.Z0(i13);
            while (i12 < list.size()) {
                this.f9148a.I0(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.f9148a.H0(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void writeMessageSetItem(int i11, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.f9148a.M0(i11, (ByteString) obj);
        } else {
            this.f9148a.L0(i11, (f0) obj);
        }
    }

    public void writeSFixed32(int i11, int i12) throws IOException {
        this.f9148a.N0(i11, i12);
    }

    public void writeSFixed32List(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.f9148a.X0(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.N(list.get(i14).intValue());
            }
            this.f9148a.Z0(i13);
            while (i12 < list.size()) {
                this.f9148a.O0(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.f9148a.N0(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public void writeSFixed64(int i11, long j11) throws IOException {
        this.f9148a.P0(i11, j11);
    }

    public void writeSFixed64List(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.f9148a.X0(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.P(list.get(i14).longValue());
            }
            this.f9148a.Z0(i13);
            while (i12 < list.size()) {
                this.f9148a.Q0(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.f9148a.P0(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public void writeSInt32(int i11, int i12) throws IOException {
        this.f9148a.R0(i11, i12);
    }

    public void writeSInt32List(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.f9148a.X0(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.R(list.get(i14).intValue());
            }
            this.f9148a.Z0(i13);
            while (i12 < list.size()) {
                this.f9148a.S0(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.f9148a.R0(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public void writeSInt64(int i11, long j11) throws IOException {
        this.f9148a.T0(i11, j11);
    }

    public void writeSInt64List(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.f9148a.X0(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.T(list.get(i14).longValue());
            }
            this.f9148a.Z0(i13);
            while (i12 < list.size()) {
                this.f9148a.U0(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.f9148a.T0(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public void writeStartGroup(int i11) throws IOException {
        this.f9148a.X0(i11, 3);
    }

    public void writeString(int i11, String str) throws IOException {
        this.f9148a.V0(i11, str);
    }

    public void writeStringList(int i11, List<String> list) throws IOException {
        int i12 = 0;
        if (list instanceof w) {
            w wVar = (w) list;
            while (i12 < list.size()) {
                m(i11, wVar.getRaw(i12));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.f9148a.V0(i11, list.get(i12));
            i12++;
        }
    }

    public void writeUInt32(int i11, int i12) throws IOException {
        this.f9148a.Y0(i11, i12);
    }

    public void writeUInt32List(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.f9148a.X0(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.Y(list.get(i14).intValue());
            }
            this.f9148a.Z0(i13);
            while (i12 < list.size()) {
                this.f9148a.Z0(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.f9148a.Y0(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public void writeUInt64(int i11, long j11) throws IOException {
        this.f9148a.a1(i11, j11);
    }

    public void writeUInt64List(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.f9148a.X0(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += CodedOutputStream.a0(list.get(i14).longValue());
            }
            this.f9148a.Z0(i13);
            while (i12 < list.size()) {
                this.f9148a.b1(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.f9148a.a1(i11, list.get(i12).longValue());
            i12++;
        }
    }
}
