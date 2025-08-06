package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class n extends m<GeneratedMessageLite.c> {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9187a;

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
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9187a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f9187a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n.a.<clinit>():void");
        }
    }

    public int a(Map.Entry<?, ?> entry) {
        return ((GeneratedMessageLite.c) entry.getKey()).getNumber();
    }

    public Object b(l lVar, f0 f0Var, int i11) {
        return lVar.a(f0Var, i11);
    }

    public q<GeneratedMessageLite.c> c(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).extensions;
    }

    public q<GeneratedMessageLite.c> d(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).C();
    }

    public boolean e(f0 f0Var) {
        return f0Var instanceof GeneratedMessageLite.ExtendableMessage;
    }

    public void f(Object obj) {
        c(obj).t();
    }

    public <UT, UB> UB g(s0 s0Var, Object obj, l lVar, q<GeneratedMessageLite.c> qVar, UB ub2, y0<UT, UB> y0Var) throws IOException {
        Object i11;
        ArrayList arrayList;
        GeneratedMessageLite.d dVar = (GeneratedMessageLite.d) obj;
        int c11 = dVar.c();
        if (!dVar.f9014b.isRepeated() || !dVar.f9014b.isPacked()) {
            Object obj2 = null;
            if (dVar.a() != WireFormat.FieldType.ENUM) {
                switch (a.f9187a[dVar.a().ordinal()]) {
                    case 1:
                        obj2 = Double.valueOf(s0Var.readDouble());
                        break;
                    case 2:
                        obj2 = Float.valueOf(s0Var.readFloat());
                        break;
                    case 3:
                        obj2 = Long.valueOf(s0Var.readInt64());
                        break;
                    case 4:
                        obj2 = Long.valueOf(s0Var.readUInt64());
                        break;
                    case 5:
                        obj2 = Integer.valueOf(s0Var.readInt32());
                        break;
                    case 6:
                        obj2 = Long.valueOf(s0Var.readFixed64());
                        break;
                    case 7:
                        obj2 = Integer.valueOf(s0Var.readFixed32());
                        break;
                    case 8:
                        obj2 = Boolean.valueOf(s0Var.readBool());
                        break;
                    case 9:
                        obj2 = Integer.valueOf(s0Var.readUInt32());
                        break;
                    case 10:
                        obj2 = Integer.valueOf(s0Var.readSFixed32());
                        break;
                    case 11:
                        obj2 = Long.valueOf(s0Var.readSFixed64());
                        break;
                    case 12:
                        obj2 = Integer.valueOf(s0Var.readSInt32());
                        break;
                    case 13:
                        obj2 = Long.valueOf(s0Var.readSInt64());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        obj2 = s0Var.readBytes();
                        break;
                    case 16:
                        obj2 = s0Var.readString();
                        break;
                    case 17:
                        obj2 = s0Var.e(dVar.b().getClass(), lVar);
                        break;
                    case 18:
                        obj2 = s0Var.b(dVar.b().getClass(), lVar);
                        break;
                }
            } else {
                int readInt32 = s0Var.readInt32();
                if (dVar.f9014b.b().findValueByNumber(readInt32) == null) {
                    return v0.L(c11, readInt32, ub2, y0Var);
                }
                obj2 = Integer.valueOf(readInt32);
            }
            if (dVar.d()) {
                qVar.a(dVar.f9014b, obj2);
            } else {
                int i12 = a.f9187a[dVar.a().ordinal()];
                if ((i12 == 17 || i12 == 18) && (i11 = qVar.i(dVar.f9014b)) != null) {
                    obj2 = u.h(i11, obj2);
                }
                qVar.x(dVar.f9014b, obj2);
            }
        } else {
            switch (a.f9187a[dVar.a().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    s0Var.readDoubleList(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    s0Var.readFloatList(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    s0Var.readInt64List(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    s0Var.readUInt64List(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    s0Var.readInt32List(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    s0Var.readFixed64List(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    s0Var.readFixed32List(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    s0Var.readBoolList(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    s0Var.readUInt32List(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    s0Var.readSFixed32List(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    s0Var.readSFixed64List(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    s0Var.readSInt32List(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    s0Var.readSInt64List(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    s0Var.readEnumList(arrayList);
                    ub2 = v0.z(c11, arrayList, dVar.f9014b.b(), ub2, y0Var);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + dVar.f9014b.getLiteType());
            }
            qVar.x(dVar.f9014b, arrayList);
        }
        return ub2;
    }

    public void h(s0 s0Var, Object obj, l lVar, q<GeneratedMessageLite.c> qVar) throws IOException {
        GeneratedMessageLite.d dVar = (GeneratedMessageLite.d) obj;
        qVar.x(dVar.f9014b, s0Var.b(dVar.b().getClass(), lVar));
    }

    public void i(ByteString byteString, Object obj, l lVar, q<GeneratedMessageLite.c> qVar) throws IOException {
        GeneratedMessageLite.d dVar = (GeneratedMessageLite.d) obj;
        f0 buildPartial = dVar.b().newBuilderForType().buildPartial();
        d h11 = d.h(ByteBuffer.wrap(byteString.toByteArray()), true);
        p0.a().b(buildPartial, h11, lVar);
        qVar.x(dVar.f9014b, buildPartial);
        if (h11.getFieldNumber() != Integer.MAX_VALUE) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public void j(Writer writer, Map.Entry<?, ?> entry) throws IOException {
        GeneratedMessageLite.c cVar = (GeneratedMessageLite.c) entry.getKey();
        if (cVar.isRepeated()) {
            switch (a.f9187a[cVar.getLiteType().ordinal()]) {
                case 1:
                    v0.P(cVar.getNumber(), (List) entry.getValue(), writer, cVar.isPacked());
                    return;
                case 2:
                    v0.T(cVar.getNumber(), (List) entry.getValue(), writer, cVar.isPacked());
                    return;
                case 3:
                    v0.W(cVar.getNumber(), (List) entry.getValue(), writer, cVar.isPacked());
                    return;
                case 4:
                    v0.e0(cVar.getNumber(), (List) entry.getValue(), writer, cVar.isPacked());
                    return;
                case 5:
                    v0.V(cVar.getNumber(), (List) entry.getValue(), writer, cVar.isPacked());
                    return;
                case 6:
                    v0.S(cVar.getNumber(), (List) entry.getValue(), writer, cVar.isPacked());
                    return;
                case 7:
                    v0.R(cVar.getNumber(), (List) entry.getValue(), writer, cVar.isPacked());
                    return;
                case 8:
                    v0.N(cVar.getNumber(), (List) entry.getValue(), writer, cVar.isPacked());
                    return;
                case 9:
                    v0.d0(cVar.getNumber(), (List) entry.getValue(), writer, cVar.isPacked());
                    return;
                case 10:
                    v0.Y(cVar.getNumber(), (List) entry.getValue(), writer, cVar.isPacked());
                    return;
                case 11:
                    v0.Z(cVar.getNumber(), (List) entry.getValue(), writer, cVar.isPacked());
                    return;
                case 12:
                    v0.a0(cVar.getNumber(), (List) entry.getValue(), writer, cVar.isPacked());
                    return;
                case 13:
                    v0.b0(cVar.getNumber(), (List) entry.getValue(), writer, cVar.isPacked());
                    return;
                case 14:
                    v0.V(cVar.getNumber(), (List) entry.getValue(), writer, cVar.isPacked());
                    return;
                case 15:
                    v0.O(cVar.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 16:
                    v0.c0(cVar.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        v0.U(cVar.getNumber(), (List) entry.getValue(), writer, p0.a().d(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        v0.X(cVar.getNumber(), (List) entry.getValue(), writer, p0.a().d(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (a.f9187a[cVar.getLiteType().ordinal()]) {
                case 1:
                    writer.writeDouble(cVar.getNumber(), ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    writer.writeFloat(cVar.getNumber(), ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    writer.writeInt64(cVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    writer.writeUInt64(cVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    writer.writeInt32(cVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    writer.writeFixed64(cVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    writer.writeFixed32(cVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    writer.writeBool(cVar.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    writer.writeUInt32(cVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    writer.writeSFixed32(cVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    writer.writeSFixed64(cVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    writer.writeSInt32(cVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    writer.writeSInt64(cVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    writer.writeInt32(cVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    writer.a(cVar.getNumber(), (ByteString) entry.getValue());
                    return;
                case 16:
                    writer.writeString(cVar.getNumber(), (String) entry.getValue());
                    return;
                case 17:
                    writer.e(cVar.getNumber(), entry.getValue(), p0.a().d(entry.getValue().getClass()));
                    return;
                case 18:
                    writer.b(cVar.getNumber(), entry.getValue(), p0.a().d(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }
}
