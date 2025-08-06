package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.u;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Objects;

public final class c {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9064a;

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
                f9064a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f9064a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.c.a.<clinit>():void");
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f9065a;

        /* renamed from: b  reason: collision with root package name */
        public long f9066b;

        /* renamed from: c  reason: collision with root package name */
        public Object f9067c;

        /* renamed from: d  reason: collision with root package name */
        public final l f9068d;

        public b(l lVar) {
            Objects.requireNonNull(lVar);
            this.f9068d = lVar;
        }
    }

    public static int A(int i11, byte[] bArr, int i12, int i13, u.i<?> iVar, b bVar) {
        t tVar = (t) iVar;
        int I = I(bArr, i12, bVar);
        tVar.addInt(g.b(bVar.f9065a));
        while (I < i13) {
            int I2 = I(bArr, I, bVar);
            if (i11 != bVar.f9065a) {
                break;
            }
            I = I(bArr, I2, bVar);
            tVar.addInt(g.b(bVar.f9065a));
        }
        return I;
    }

    public static int B(int i11, byte[] bArr, int i12, int i13, u.i<?> iVar, b bVar) {
        y yVar = (y) iVar;
        int L = L(bArr, i12, bVar);
        yVar.addLong(g.c(bVar.f9066b));
        while (L < i13) {
            int I = I(bArr, L, bVar);
            if (i11 != bVar.f9065a) {
                break;
            }
            L = L(bArr, I, bVar);
            yVar.addLong(g.c(bVar.f9066b));
        }
        return L;
    }

    public static int C(byte[] bArr, int i11, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f9065a;
        if (i12 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i12 == 0) {
            bVar.f9067c = "";
            return I;
        } else {
            bVar.f9067c = new String(bArr, I, i12, u.f9213a);
            return I + i12;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[EDGE_INSN: B:21:0x0044->B:17:0x0044 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    public static int D(int r4, byte[] r5, int r6, int r7, androidx.datastore.preferences.protobuf.u.i<?> r8, androidx.datastore.preferences.protobuf.c.b r9) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        /*
            int r6 = I(r5, r6, r9)
            int r0 = r9.f9065a
            if (r0 < 0) goto L_0x0045
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            r8.add(r1)
            goto L_0x001b
        L_0x0010:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = androidx.datastore.preferences.protobuf.u.f9213a
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
        L_0x001a:
            int r6 = r6 + r0
        L_0x001b:
            if (r6 >= r7) goto L_0x0044
            int r0 = I(r5, r6, r9)
            int r2 = r9.f9065a
            if (r4 == r2) goto L_0x0026
            goto L_0x0044
        L_0x0026:
            int r6 = I(r5, r0, r9)
            int r0 = r9.f9065a
            if (r0 < 0) goto L_0x003f
            if (r0 != 0) goto L_0x0034
            r8.add(r1)
            goto L_0x001b
        L_0x0034:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = androidx.datastore.preferences.protobuf.u.f9213a
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
            goto L_0x001a
        L_0x003f:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r4
        L_0x0044:
            return r6
        L_0x0045:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.c.D(int, byte[], int, int, androidx.datastore.preferences.protobuf.u$i, androidx.datastore.preferences.protobuf.c$b):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        r2 = r7 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (androidx.datastore.preferences.protobuf.Utf8.t(r6, r7, r2) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        r9.add(new java.lang.String(r6, r7, r0, androidx.datastore.preferences.protobuf.u.f9213a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidUtf8();
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059 A[EDGE_INSN: B:28:0x0059->B:23:0x0059 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int E(int r5, byte[] r6, int r7, int r8, androidx.datastore.preferences.protobuf.u.i<?> r9, androidx.datastore.preferences.protobuf.c.b r10) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        /*
            int r7 = I(r6, r7, r10)
            int r0 = r10.f9065a
            if (r0 < 0) goto L_0x005f
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            r9.add(r1)
            goto L_0x0023
        L_0x0010:
            int r2 = r7 + r0
            boolean r3 = androidx.datastore.preferences.protobuf.Utf8.t(r6, r7, r2)
            if (r3 == 0) goto L_0x005a
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = androidx.datastore.preferences.protobuf.u.f9213a
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
        L_0x0022:
            r7 = r2
        L_0x0023:
            if (r7 >= r8) goto L_0x0059
            int r0 = I(r6, r7, r10)
            int r2 = r10.f9065a
            if (r5 == r2) goto L_0x002e
            goto L_0x0059
        L_0x002e:
            int r7 = I(r6, r0, r10)
            int r0 = r10.f9065a
            if (r0 < 0) goto L_0x0054
            if (r0 != 0) goto L_0x003c
            r9.add(r1)
            goto L_0x0023
        L_0x003c:
            int r2 = r7 + r0
            boolean r3 = androidx.datastore.preferences.protobuf.Utf8.t(r6, r7, r2)
            if (r3 == 0) goto L_0x004f
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = androidx.datastore.preferences.protobuf.u.f9213a
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
            goto L_0x0022
        L_0x004f:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidUtf8()
            throw r5
        L_0x0054:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r5
        L_0x0059:
            return r7
        L_0x005a:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidUtf8()
            throw r5
        L_0x005f:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.c.E(int, byte[], int, int, androidx.datastore.preferences.protobuf.u$i, androidx.datastore.preferences.protobuf.c$b):int");
    }

    public static int F(byte[] bArr, int i11, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f9065a;
        if (i12 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i12 == 0) {
            bVar.f9067c = "";
            return I;
        } else {
            bVar.f9067c = Utf8.h(bArr, I, i12);
            return I + i12;
        }
    }

    public static int G(int i11, byte[] bArr, int i12, int i13, z0 z0Var, b bVar) throws InvalidProtocolBufferException {
        if (WireFormat.a(i11) != 0) {
            int b11 = WireFormat.b(i11);
            if (b11 == 0) {
                int L = L(bArr, i12, bVar);
                z0Var.n(i11, Long.valueOf(bVar.f9066b));
                return L;
            } else if (b11 == 1) {
                z0Var.n(i11, Long.valueOf(j(bArr, i12)));
                return i12 + 8;
            } else if (b11 == 2) {
                int I = I(bArr, i12, bVar);
                int i14 = bVar.f9065a;
                if (i14 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                } else if (i14 <= bArr.length - I) {
                    if (i14 == 0) {
                        z0Var.n(i11, ByteString.EMPTY);
                    } else {
                        z0Var.n(i11, ByteString.copyFrom(bArr, I, i14));
                    }
                    return I + i14;
                } else {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } else if (b11 == 3) {
                z0 l11 = z0.l();
                int i15 = (i11 & -8) | 4;
                int i16 = 0;
                while (true) {
                    if (i12 >= i13) {
                        break;
                    }
                    int I2 = I(bArr, i12, bVar);
                    int i17 = bVar.f9065a;
                    if (i17 == i15) {
                        i16 = i17;
                        i12 = I2;
                        break;
                    }
                    i16 = i17;
                    i12 = G(i17, bArr, I2, i13, l11, bVar);
                }
                if (i12 > i13 || i16 != i15) {
                    throw InvalidProtocolBufferException.parseFailure();
                }
                z0Var.n(i11, l11);
                return i12;
            } else if (b11 == 5) {
                z0Var.n(i11, Integer.valueOf(h(bArr, i12)));
                return i12 + 4;
            } else {
                throw InvalidProtocolBufferException.invalidTag();
            }
        } else {
            throw InvalidProtocolBufferException.invalidTag();
        }
    }

    public static int H(int i11, byte[] bArr, int i12, b bVar) {
        int i13 = i11 & 127;
        int i14 = i12 + 1;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            bVar.f9065a = i13 | (b11 << 7);
            return i14;
        }
        int i15 = i13 | ((b11 & Ascii.DEL) << 7);
        int i16 = i14 + 1;
        byte b12 = bArr[i14];
        if (b12 >= 0) {
            bVar.f9065a = i15 | (b12 << 14);
            return i16;
        }
        int i17 = i15 | ((b12 & Ascii.DEL) << 14);
        int i18 = i16 + 1;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            bVar.f9065a = i17 | (b13 << 21);
            return i18;
        }
        int i19 = i17 | ((b13 & Ascii.DEL) << 21);
        int i21 = i18 + 1;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            bVar.f9065a = i19 | (b14 << 28);
            return i21;
        }
        int i22 = i19 | ((b14 & Ascii.DEL) << 28);
        while (true) {
            int i23 = i21 + 1;
            if (bArr[i21] < 0) {
                i21 = i23;
            } else {
                bVar.f9065a = i22;
                return i23;
            }
        }
    }

    public static int I(byte[] bArr, int i11, b bVar) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return H(b11, bArr, i12, bVar);
        }
        bVar.f9065a = b11;
        return i12;
    }

    public static int J(int i11, byte[] bArr, int i12, int i13, u.i<?> iVar, b bVar) {
        t tVar = (t) iVar;
        int I = I(bArr, i12, bVar);
        tVar.addInt(bVar.f9065a);
        while (I < i13) {
            int I2 = I(bArr, I, bVar);
            if (i11 != bVar.f9065a) {
                break;
            }
            I = I(bArr, I2, bVar);
            tVar.addInt(bVar.f9065a);
        }
        return I;
    }

    public static int K(long j11, byte[] bArr, int i11, b bVar) {
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
        bVar.f9066b = j12;
        return i12;
    }

    public static int L(byte[] bArr, int i11, b bVar) {
        int i12 = i11 + 1;
        long j11 = (long) bArr[i11];
        if (j11 < 0) {
            return K(j11, bArr, i12, bVar);
        }
        bVar.f9066b = j11;
        return i12;
    }

    public static int M(int i11, byte[] bArr, int i12, int i13, u.i<?> iVar, b bVar) {
        y yVar = (y) iVar;
        int L = L(bArr, i12, bVar);
        yVar.addLong(bVar.f9066b);
        while (L < i13) {
            int I = I(bArr, L, bVar);
            if (i11 != bVar.f9065a) {
                break;
            }
            L = L(bArr, I, bVar);
            yVar.addLong(bVar.f9066b);
        }
        return L;
    }

    public static int N(int i11, byte[] bArr, int i12, int i13, b bVar) throws InvalidProtocolBufferException {
        if (WireFormat.a(i11) != 0) {
            int b11 = WireFormat.b(i11);
            if (b11 == 0) {
                return L(bArr, i12, bVar);
            }
            if (b11 == 1) {
                return i12 + 8;
            }
            if (b11 == 2) {
                return I(bArr, i12, bVar) + bVar.f9065a;
            }
            if (b11 == 3) {
                int i14 = (i11 & -8) | 4;
                int i15 = 0;
                while (i12 < i13) {
                    i12 = I(bArr, i12, bVar);
                    i15 = bVar.f9065a;
                    if (i15 == i14) {
                        break;
                    }
                    i12 = N(i15, bArr, i12, i13, bVar);
                }
                if (i12 <= i13 && i15 == i14) {
                    return i12;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } else if (b11 == 5) {
                return i12 + 4;
            } else {
                throw InvalidProtocolBufferException.invalidTag();
            }
        } else {
            throw InvalidProtocolBufferException.invalidTag();
        }
    }

    public static int a(int i11, byte[] bArr, int i12, int i13, u.i<?> iVar, b bVar) {
        e eVar = (e) iVar;
        int L = L(bArr, i12, bVar);
        eVar.addBoolean(bVar.f9066b != 0);
        while (L < i13) {
            int I = I(bArr, L, bVar);
            if (i11 != bVar.f9065a) {
                break;
            }
            L = L(bArr, I, bVar);
            eVar.addBoolean(bVar.f9066b != 0);
        }
        return L;
    }

    public static int b(byte[] bArr, int i11, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f9065a;
        if (i12 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i12 > bArr.length - I) {
            throw InvalidProtocolBufferException.truncatedMessage();
        } else if (i12 == 0) {
            bVar.f9067c = ByteString.EMPTY;
            return I;
        } else {
            bVar.f9067c = ByteString.copyFrom(bArr, I, i12);
            return I + i12;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x004d A[EDGE_INSN: B:30:0x004d->B:22:0x004d ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int c(int r2, byte[] r3, int r4, int r5, androidx.datastore.preferences.protobuf.u.i<?> r6, androidx.datastore.preferences.protobuf.c.b r7) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        /*
            int r4 = I(r3, r4, r7)
            int r0 = r7.f9065a
            if (r0 < 0) goto L_0x0053
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x004e
            if (r0 != 0) goto L_0x0014
            androidx.datastore.preferences.protobuf.ByteString r0 = androidx.datastore.preferences.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L_0x001c
        L_0x0014:
            androidx.datastore.preferences.protobuf.ByteString r1 = androidx.datastore.preferences.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
        L_0x001b:
            int r4 = r4 + r0
        L_0x001c:
            if (r4 >= r5) goto L_0x004d
            int r0 = I(r3, r4, r7)
            int r1 = r7.f9065a
            if (r2 == r1) goto L_0x0027
            goto L_0x004d
        L_0x0027:
            int r4 = I(r3, r0, r7)
            int r0 = r7.f9065a
            if (r0 < 0) goto L_0x0048
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x0043
            if (r0 != 0) goto L_0x003b
            androidx.datastore.preferences.protobuf.ByteString r0 = androidx.datastore.preferences.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L_0x001c
        L_0x003b:
            androidx.datastore.preferences.protobuf.ByteString r1 = androidx.datastore.preferences.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
            goto L_0x001b
        L_0x0043:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r2 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r2
        L_0x0048:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r2 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r2
        L_0x004d:
            return r4
        L_0x004e:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r2 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r2
        L_0x0053:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r2 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.c.c(int, byte[], int, int, androidx.datastore.preferences.protobuf.u$i, androidx.datastore.preferences.protobuf.c$b):int");
    }

    public static double d(byte[] bArr, int i11) {
        return Double.longBitsToDouble(j(bArr, i11));
    }

    public static int e(int i11, byte[] bArr, int i12, int i13, u.i<?> iVar, b bVar) {
        j jVar = (j) iVar;
        jVar.addDouble(d(bArr, i12));
        int i14 = i12 + 8;
        while (i14 < i13) {
            int I = I(bArr, i14, bVar);
            if (i11 != bVar.f9065a) {
                break;
            }
            jVar.addDouble(d(bArr, I));
            i14 = I + 8;
        }
        return i14;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01f4, code lost:
        r9 = r9 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01ff, code lost:
        r9 = r9 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int f(int r7, byte[] r8, int r9, int r10, androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage<?, ?> r11, androidx.datastore.preferences.protobuf.GeneratedMessageLite.d<?, ?> r12, androidx.datastore.preferences.protobuf.y0<androidx.datastore.preferences.protobuf.z0, androidx.datastore.preferences.protobuf.z0> r13, androidx.datastore.preferences.protobuf.c.b r14) throws java.io.IOException {
        /*
            androidx.datastore.preferences.protobuf.q<androidx.datastore.preferences.protobuf.GeneratedMessageLite$c> r0 = r11.extensions
            int r7 = r7 >>> 3
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r1 = r12.f9014b
            boolean r1 = r1.isRepeated()
            r2 = 0
            if (r1 == 0) goto L_0x00fb
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r1 = r12.f9014b
            boolean r1 = r1.isPacked()
            if (r1 == 0) goto L_0x00fb
            int[] r10 = androidx.datastore.preferences.protobuf.c.a.f9064a
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = r12.a()
            int r1 = r1.ordinal()
            r10 = r10[r1]
            switch(r10) {
                case 1: goto L_0x00eb;
                case 2: goto L_0x00db;
                case 3: goto L_0x00cb;
                case 4: goto L_0x00cb;
                case 5: goto L_0x00bb;
                case 6: goto L_0x00bb;
                case 7: goto L_0x00ab;
                case 8: goto L_0x00ab;
                case 9: goto L_0x009b;
                case 10: goto L_0x009b;
                case 11: goto L_0x008b;
                case 12: goto L_0x007b;
                case 13: goto L_0x006b;
                case 14: goto L_0x0041;
                default: goto L_0x0024;
            }
        L_0x0024:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Type cannot be packed: "
            r8.append(r9)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r9 = r12.f9014b
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r9 = r9.getLiteType()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0041:
            androidx.datastore.preferences.protobuf.t r10 = new androidx.datastore.preferences.protobuf.t
            r10.<init>()
            int r8 = y(r8, r9, r10, r14)
            androidx.datastore.preferences.protobuf.z0 r9 = r11.unknownFields
            androidx.datastore.preferences.protobuf.z0 r14 = androidx.datastore.preferences.protobuf.z0.e()
            if (r9 != r14) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r2 = r9
        L_0x0054:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r9 = r12.f9014b
            androidx.datastore.preferences.protobuf.u$d r9 = r9.b()
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.v0.z(r7, r10, r9, r2, r13)
            androidx.datastore.preferences.protobuf.z0 r7 = (androidx.datastore.preferences.protobuf.z0) r7
            if (r7 == 0) goto L_0x0064
            r11.unknownFields = r7
        L_0x0064:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r7 = r12.f9014b
            r0.x(r7, r10)
            goto L_0x0234
        L_0x006b:
            androidx.datastore.preferences.protobuf.y r7 = new androidx.datastore.preferences.protobuf.y
            r7.<init>()
            int r8 = x(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r9 = r12.f9014b
            r0.x(r9, r7)
            goto L_0x0234
        L_0x007b:
            androidx.datastore.preferences.protobuf.t r7 = new androidx.datastore.preferences.protobuf.t
            r7.<init>()
            int r8 = w(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r9 = r12.f9014b
            r0.x(r9, r7)
            goto L_0x0234
        L_0x008b:
            androidx.datastore.preferences.protobuf.e r7 = new androidx.datastore.preferences.protobuf.e
            r7.<init>()
            int r8 = r(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r9 = r12.f9014b
            r0.x(r9, r7)
            goto L_0x0234
        L_0x009b:
            androidx.datastore.preferences.protobuf.t r7 = new androidx.datastore.preferences.protobuf.t
            r7.<init>()
            int r8 = t(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r9 = r12.f9014b
            r0.x(r9, r7)
            goto L_0x0234
        L_0x00ab:
            androidx.datastore.preferences.protobuf.y r7 = new androidx.datastore.preferences.protobuf.y
            r7.<init>()
            int r8 = u(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r9 = r12.f9014b
            r0.x(r9, r7)
            goto L_0x0234
        L_0x00bb:
            androidx.datastore.preferences.protobuf.t r7 = new androidx.datastore.preferences.protobuf.t
            r7.<init>()
            int r8 = y(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r9 = r12.f9014b
            r0.x(r9, r7)
            goto L_0x0234
        L_0x00cb:
            androidx.datastore.preferences.protobuf.y r7 = new androidx.datastore.preferences.protobuf.y
            r7.<init>()
            int r8 = z(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r9 = r12.f9014b
            r0.x(r9, r7)
            goto L_0x0234
        L_0x00db:
            androidx.datastore.preferences.protobuf.r r7 = new androidx.datastore.preferences.protobuf.r
            r7.<init>()
            int r8 = v(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r9 = r12.f9014b
            r0.x(r9, r7)
            goto L_0x0234
        L_0x00eb:
            androidx.datastore.preferences.protobuf.j r7 = new androidx.datastore.preferences.protobuf.j
            r7.<init>()
            int r8 = s(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r9 = r12.f9014b
            r0.x(r9, r7)
            goto L_0x0234
        L_0x00fb:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = r12.a()
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r3 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM
            if (r1 != r3) goto L_0x0131
            int r9 = I(r8, r9, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r8 = r12.f9014b
            androidx.datastore.preferences.protobuf.u$d r8 = r8.b()
            int r10 = r14.f9065a
            androidx.datastore.preferences.protobuf.u$c r8 = r8.findValueByNumber(r10)
            if (r8 != 0) goto L_0x0129
            androidx.datastore.preferences.protobuf.z0 r8 = r11.unknownFields
            androidx.datastore.preferences.protobuf.z0 r10 = androidx.datastore.preferences.protobuf.z0.e()
            if (r8 != r10) goto L_0x0123
            androidx.datastore.preferences.protobuf.z0 r8 = androidx.datastore.preferences.protobuf.z0.l()
            r11.unknownFields = r8
        L_0x0123:
            int r10 = r14.f9065a
            androidx.datastore.preferences.protobuf.v0.L(r7, r10, r8, r13)
            return r9
        L_0x0129:
            int r7 = r14.f9065a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0201
        L_0x0131:
            int[] r11 = androidx.datastore.preferences.protobuf.c.a.f9064a
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r13 = r12.a()
            int r13 = r13.ordinal()
            r11 = r11[r13]
            switch(r11) {
                case 1: goto L_0x01f7;
                case 2: goto L_0x01ec;
                case 3: goto L_0x01e1;
                case 4: goto L_0x01e1;
                case 5: goto L_0x01d6;
                case 6: goto L_0x01d6;
                case 7: goto L_0x01cd;
                case 8: goto L_0x01cd;
                case 9: goto L_0x01c4;
                case 10: goto L_0x01c4;
                case 11: goto L_0x01b0;
                case 12: goto L_0x01a1;
                case 13: goto L_0x0192;
                case 14: goto L_0x018a;
                case 15: goto L_0x0182;
                case 16: goto L_0x017a;
                case 17: goto L_0x015a;
                case 18: goto L_0x0142;
                default: goto L_0x0140;
            }
        L_0x0140:
            goto L_0x0201
        L_0x0142:
            androidx.datastore.preferences.protobuf.p0 r7 = androidx.datastore.preferences.protobuf.p0.a()
            androidx.datastore.preferences.protobuf.f0 r11 = r12.b()
            java.lang.Class r11 = r11.getClass()
            androidx.datastore.preferences.protobuf.t0 r7 = r7.d(r11)
            int r9 = p(r7, r8, r9, r10, r14)
            java.lang.Object r2 = r14.f9067c
            goto L_0x0201
        L_0x015a:
            int r7 = r7 << 3
            r5 = r7 | 4
            androidx.datastore.preferences.protobuf.p0 r7 = androidx.datastore.preferences.protobuf.p0.a()
            androidx.datastore.preferences.protobuf.f0 r11 = r12.b()
            java.lang.Class r11 = r11.getClass()
            androidx.datastore.preferences.protobuf.t0 r1 = r7.d(r11)
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r14
            int r9 = n(r1, r2, r3, r4, r5, r6)
            java.lang.Object r2 = r14.f9067c
            goto L_0x0201
        L_0x017a:
            int r9 = C(r8, r9, r14)
            java.lang.Object r2 = r14.f9067c
            goto L_0x0201
        L_0x0182:
            int r9 = b(r8, r9, r14)
            java.lang.Object r2 = r14.f9067c
            goto L_0x0201
        L_0x018a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Shouldn't reach here."
            r7.<init>(r8)
            throw r7
        L_0x0192:
            int r9 = L(r8, r9, r14)
            long r7 = r14.f9066b
            long r7 = androidx.datastore.preferences.protobuf.g.c(r7)
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            goto L_0x0201
        L_0x01a1:
            int r9 = I(r8, r9, r14)
            int r7 = r14.f9065a
            int r7 = androidx.datastore.preferences.protobuf.g.b(r7)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0201
        L_0x01b0:
            int r9 = L(r8, r9, r14)
            long r7 = r14.f9066b
            r10 = 0
            int r7 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r7 == 0) goto L_0x01be
            r7 = 1
            goto L_0x01bf
        L_0x01be:
            r7 = 0
        L_0x01bf:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r7)
            goto L_0x0201
        L_0x01c4:
            int r7 = h(r8, r9)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x01f4
        L_0x01cd:
            long r7 = j(r8, r9)
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            goto L_0x01ff
        L_0x01d6:
            int r9 = I(r8, r9, r14)
            int r7 = r14.f9065a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0201
        L_0x01e1:
            int r9 = L(r8, r9, r14)
            long r7 = r14.f9066b
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            goto L_0x0201
        L_0x01ec:
            float r7 = l(r8, r9)
            java.lang.Float r2 = java.lang.Float.valueOf(r7)
        L_0x01f4:
            int r9 = r9 + 4
            goto L_0x0201
        L_0x01f7:
            double r7 = d(r8, r9)
            java.lang.Double r2 = java.lang.Double.valueOf(r7)
        L_0x01ff:
            int r9 = r9 + 8
        L_0x0201:
            boolean r7 = r12.d()
            if (r7 == 0) goto L_0x020d
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r7 = r12.f9014b
            r0.a(r7, r2)
            goto L_0x0233
        L_0x020d:
            int[] r7 = androidx.datastore.preferences.protobuf.c.a.f9064a
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r8 = r12.a()
            int r8 = r8.ordinal()
            r7 = r7[r8]
            r8 = 17
            if (r7 == r8) goto L_0x0222
            r8 = 18
            if (r7 == r8) goto L_0x0222
            goto L_0x022e
        L_0x0222:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r7 = r12.f9014b
            java.lang.Object r7 = r0.i(r7)
            if (r7 == 0) goto L_0x022e
            java.lang.Object r2 = androidx.datastore.preferences.protobuf.u.h(r7, r2)
        L_0x022e:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r7 = r12.f9014b
            r0.x(r7, r2)
        L_0x0233:
            r8 = r9
        L_0x0234:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.c.f(int, byte[], int, int, androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtendableMessage, androidx.datastore.preferences.protobuf.GeneratedMessageLite$d, androidx.datastore.preferences.protobuf.y0, androidx.datastore.preferences.protobuf.c$b):int");
    }

    public static int g(int i11, byte[] bArr, int i12, int i13, Object obj, f0 f0Var, y0<z0, z0> y0Var, b bVar) throws IOException {
        GeneratedMessageLite.d a11 = bVar.f9068d.a(f0Var, i11 >>> 3);
        if (a11 == null) {
            return G(i11, bArr, i12, i13, i0.p(obj), bVar);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.C();
        return f(i11, bArr, i12, i13, extendableMessage, a11, y0Var, bVar);
    }

    public static int h(byte[] bArr, int i11) {
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
    }

    public static int i(int i11, byte[] bArr, int i12, int i13, u.i<?> iVar, b bVar) {
        t tVar = (t) iVar;
        tVar.addInt(h(bArr, i12));
        int i14 = i12 + 4;
        while (i14 < i13) {
            int I = I(bArr, i14, bVar);
            if (i11 != bVar.f9065a) {
                break;
            }
            tVar.addInt(h(bArr, I));
            i14 = I + 4;
        }
        return i14;
    }

    public static long j(byte[] bArr, int i11) {
        return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
    }

    public static int k(int i11, byte[] bArr, int i12, int i13, u.i<?> iVar, b bVar) {
        y yVar = (y) iVar;
        yVar.addLong(j(bArr, i12));
        int i14 = i12 + 8;
        while (i14 < i13) {
            int I = I(bArr, i14, bVar);
            if (i11 != bVar.f9065a) {
                break;
            }
            yVar.addLong(j(bArr, I));
            i14 = I + 8;
        }
        return i14;
    }

    public static float l(byte[] bArr, int i11) {
        return Float.intBitsToFloat(h(bArr, i11));
    }

    public static int m(int i11, byte[] bArr, int i12, int i13, u.i<?> iVar, b bVar) {
        r rVar = (r) iVar;
        rVar.addFloat(l(bArr, i12));
        int i14 = i12 + 4;
        while (i14 < i13) {
            int I = I(bArr, i14, bVar);
            if (i11 != bVar.f9065a) {
                break;
            }
            rVar.addFloat(l(bArr, I));
            i14 = I + 4;
        }
        return i14;
    }

    public static int n(t0 t0Var, byte[] bArr, int i11, int i12, int i13, b bVar) throws IOException {
        i0 i0Var = (i0) t0Var;
        Object newInstance = i0Var.newInstance();
        int W = i0Var.W(newInstance, bArr, i11, i12, i13, bVar);
        i0Var.makeImmutable(newInstance);
        bVar.f9067c = newInstance;
        return W;
    }

    public static int o(t0 t0Var, int i11, byte[] bArr, int i12, int i13, u.i<?> iVar, b bVar) throws IOException {
        int i14 = (i11 & -8) | 4;
        int n11 = n(t0Var, bArr, i12, i13, i14, bVar);
        iVar.add(bVar.f9067c);
        while (n11 < i13) {
            int I = I(bArr, n11, bVar);
            if (i11 != bVar.f9065a) {
                break;
            }
            n11 = n(t0Var, bArr, I, i13, i14, bVar);
            iVar.add(bVar.f9067c);
        }
        return n11;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int p(androidx.datastore.preferences.protobuf.t0 r6, byte[] r7, int r8, int r9, androidx.datastore.preferences.protobuf.c.b r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = H(r8, r7, r0, r10)
            int r8 = r10.f9065a
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.newInstance()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.c(r1, r2, r3, r4, r5)
            r6.makeImmutable(r9)
            r10.f9067c = r9
            return r8
        L_0x0025:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r6 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.c.p(androidx.datastore.preferences.protobuf.t0, byte[], int, int, androidx.datastore.preferences.protobuf.c$b):int");
    }

    public static int q(t0<?> t0Var, int i11, byte[] bArr, int i12, int i13, u.i<?> iVar, b bVar) throws IOException {
        int p11 = p(t0Var, bArr, i12, i13, bVar);
        iVar.add(bVar.f9067c);
        while (p11 < i13) {
            int I = I(bArr, p11, bVar);
            if (i11 != bVar.f9065a) {
                break;
            }
            p11 = p(t0Var, bArr, I, i13, bVar);
            iVar.add(bVar.f9067c);
        }
        return p11;
    }

    public static int r(byte[] bArr, int i11, u.i<?> iVar, b bVar) throws IOException {
        e eVar = (e) iVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f9065a + I;
        while (I < i12) {
            I = L(bArr, I, bVar);
            eVar.addBoolean(bVar.f9066b != 0);
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int s(byte[] bArr, int i11, u.i<?> iVar, b bVar) throws IOException {
        j jVar = (j) iVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f9065a + I;
        while (I < i12) {
            jVar.addDouble(d(bArr, I));
            I += 8;
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int t(byte[] bArr, int i11, u.i<?> iVar, b bVar) throws IOException {
        t tVar = (t) iVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f9065a + I;
        while (I < i12) {
            tVar.addInt(h(bArr, I));
            I += 4;
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int u(byte[] bArr, int i11, u.i<?> iVar, b bVar) throws IOException {
        y yVar = (y) iVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f9065a + I;
        while (I < i12) {
            yVar.addLong(j(bArr, I));
            I += 8;
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int v(byte[] bArr, int i11, u.i<?> iVar, b bVar) throws IOException {
        r rVar = (r) iVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f9065a + I;
        while (I < i12) {
            rVar.addFloat(l(bArr, I));
            I += 4;
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int w(byte[] bArr, int i11, u.i<?> iVar, b bVar) throws IOException {
        t tVar = (t) iVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f9065a + I;
        while (I < i12) {
            I = I(bArr, I, bVar);
            tVar.addInt(g.b(bVar.f9065a));
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int x(byte[] bArr, int i11, u.i<?> iVar, b bVar) throws IOException {
        y yVar = (y) iVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f9065a + I;
        while (I < i12) {
            I = L(bArr, I, bVar);
            yVar.addLong(g.c(bVar.f9066b));
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int y(byte[] bArr, int i11, u.i<?> iVar, b bVar) throws IOException {
        t tVar = (t) iVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f9065a + I;
        while (I < i12) {
            I = I(bArr, I, bVar);
            tVar.addInt(bVar.f9065a);
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int z(byte[] bArr, int i11, u.i<?> iVar, b bVar) throws IOException {
        y yVar = (y) iVar;
        int I = I(bArr, i11, bVar);
        int i12 = bVar.f9065a + I;
        while (I < i12) {
            I = L(bArr, I, bVar);
            yVar.addLong(bVar.f9066b);
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
}
