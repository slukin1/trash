package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

public abstract class d implements s0 {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9096a;

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
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9096a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9096a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9096a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9096a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9096a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9096a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f9096a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f9096a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f9096a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f9096a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f9096a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f9096a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f9096a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f9096a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f9096a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f9096a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f9096a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.d.a.<clinit>():void");
        }
    }

    public static final class b extends d {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f9097a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f9098b;

        /* renamed from: c  reason: collision with root package name */
        public int f9099c;

        /* renamed from: d  reason: collision with root package name */
        public final int f9100d;

        /* renamed from: e  reason: collision with root package name */
        public int f9101e;

        /* renamed from: f  reason: collision with root package name */
        public int f9102f;

        /* renamed from: g  reason: collision with root package name */
        public int f9103g;

        public b(ByteBuffer byteBuffer, boolean z11) {
            super((a) null);
            this.f9097a = z11;
            this.f9098b = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.f9099c = arrayOffset;
            this.f9100d = arrayOffset;
            this.f9101e = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        /* JADX WARNING: Removed duplicated region for block: B:1:0x000f A[LOOP:0: B:1:0x000f->B:4:0x001c, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void A() throws java.io.IOException {
            /*
                r3 = this;
                int r0 = r3.f9103g
                int r1 = r3.f9102f
                int r1 = androidx.datastore.preferences.protobuf.WireFormat.a(r1)
                r2 = 4
                int r1 = androidx.datastore.preferences.protobuf.WireFormat.c(r1, r2)
                r3.f9103g = r1
            L_0x000f:
                int r1 = r3.getFieldNumber()
                r2 = 2147483647(0x7fffffff, float:NaN)
                if (r1 == r2) goto L_0x001e
                boolean r1 = r3.skipField()
                if (r1 != 0) goto L_0x000f
            L_0x001e:
                int r1 = r3.f9102f
                int r2 = r3.f9103g
                if (r1 != r2) goto L_0x0027
                r3.f9103g = r0
                return
            L_0x0027:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.d.b.A():void");
        }

        public final void B() throws IOException {
            int i11 = this.f9101e;
            int i12 = this.f9099c;
            if (i11 - i12 >= 10) {
                byte[] bArr = this.f9098b;
                int i13 = 0;
                while (i13 < 10) {
                    int i14 = i12 + 1;
                    if (bArr[i12] >= 0) {
                        this.f9099c = i14;
                        return;
                    } else {
                        i13++;
                        i12 = i14;
                    }
                }
            }
            C();
        }

        public final void C() throws IOException {
            int i11 = 0;
            while (i11 < 10) {
                if (j() < 0) {
                    i11++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void D(int i11) throws IOException {
            w(i11);
            if ((i11 & 3) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        public final void E(int i11) throws IOException {
            w(i11);
            if ((i11 & 7) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        public <T> T a(t0<T> t0Var, l lVar) throws IOException {
            y(3);
            return l(t0Var, lVar);
        }

        public <T> T b(Class<T> cls, l lVar) throws IOException {
            y(2);
            return q(p0.a().d(cls), lVar);
        }

        public <T> T c(t0<T> t0Var, l lVar) throws IOException {
            y(2);
            return q(t0Var, lVar);
        }

        public <T> void d(List<T> list, t0<T> t0Var, l lVar) throws IOException {
            int i11;
            if (WireFormat.b(this.f9102f) == 2) {
                int i12 = this.f9102f;
                do {
                    list.add(q(t0Var, lVar));
                    if (!i()) {
                        i11 = this.f9099c;
                    } else {
                        return;
                    }
                } while (t() == i12);
                this.f9099c = i11;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        public <T> T e(Class<T> cls, l lVar) throws IOException {
            y(3);
            return l(p0.a().d(cls), lVar);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:19|20|(2:22|35)(3:30|23|24)) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
            if (skipField() != false) goto L_0x0054;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x005a, code lost:
            throw new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException("Unable to parse map entry.");
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <K, V> void f(java.util.Map<K, V> r8, androidx.datastore.preferences.protobuf.z.a<K, V> r9, androidx.datastore.preferences.protobuf.l r10) throws java.io.IOException {
            /*
                r7 = this;
                r0 = 2
                r7.y(r0)
                int r1 = r7.t()
                r7.w(r1)
                int r2 = r7.f9101e
                int r3 = r7.f9099c
                int r3 = r3 + r1
                r7.f9101e = r3
                K r1 = r9.f9257b     // Catch:{ all -> 0x005b }
                V r3 = r9.f9259d     // Catch:{ all -> 0x005b }
            L_0x0016:
                int r4 = r7.getFieldNumber()     // Catch:{ all -> 0x005b }
                r5 = 2147483647(0x7fffffff, float:NaN)
                if (r4 != r5) goto L_0x0025
                r8.put(r1, r3)     // Catch:{ all -> 0x005b }
                r7.f9101e = r2
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
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ InvalidWireTypeException -> 0x004e }
                r4.<init>((java.lang.String) r6)     // Catch:{ InvalidWireTypeException -> 0x004e }
                throw r4     // Catch:{ InvalidWireTypeException -> 0x004e }
            L_0x0039:
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f9258c     // Catch:{ InvalidWireTypeException -> 0x004e }
                V r5 = r9.f9259d     // Catch:{ InvalidWireTypeException -> 0x004e }
                java.lang.Class r5 = r5.getClass()     // Catch:{ InvalidWireTypeException -> 0x004e }
                java.lang.Object r3 = r7.k(r4, r5, r10)     // Catch:{ InvalidWireTypeException -> 0x004e }
                goto L_0x0016
            L_0x0046:
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f9256a     // Catch:{ InvalidWireTypeException -> 0x004e }
                r5 = 0
                java.lang.Object r1 = r7.k(r4, r5, r5)     // Catch:{ InvalidWireTypeException -> 0x004e }
                goto L_0x0016
            L_0x004e:
                boolean r4 = r7.skipField()     // Catch:{ all -> 0x005b }
                if (r4 == 0) goto L_0x0055
                goto L_0x0016
            L_0x0055:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r8 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x005b }
                r8.<init>((java.lang.String) r6)     // Catch:{ all -> 0x005b }
                throw r8     // Catch:{ all -> 0x005b }
            L_0x005b:
                r8 = move-exception
                r7.f9101e = r2
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.d.b.f(java.util.Map, androidx.datastore.preferences.protobuf.z$a, androidx.datastore.preferences.protobuf.l):void");
        }

        public <T> void g(List<T> list, t0<T> t0Var, l lVar) throws IOException {
            int i11;
            if (WireFormat.b(this.f9102f) == 3) {
                int i12 = this.f9102f;
                do {
                    list.add(l(t0Var, lVar));
                    if (!i()) {
                        i11 = this.f9099c;
                    } else {
                        return;
                    }
                } while (t() == i12);
                this.f9099c = i11;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        public int getFieldNumber() throws IOException {
            if (i()) {
                return Integer.MAX_VALUE;
            }
            int t11 = t();
            this.f9102f = t11;
            if (t11 == this.f9103g) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.a(t11);
        }

        public int getTag() {
            return this.f9102f;
        }

        public final boolean i() {
            return this.f9099c == this.f9101e;
        }

        public final byte j() throws IOException {
            int i11 = this.f9099c;
            if (i11 != this.f9101e) {
                byte[] bArr = this.f9098b;
                this.f9099c = i11 + 1;
                return bArr[i11];
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public final Object k(WireFormat.FieldType fieldType, Class<?> cls, l lVar) throws IOException {
            switch (a.f9096a[fieldType.ordinal()]) {
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
                    return b(cls, lVar);
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

        public final <T> T l(t0<T> t0Var, l lVar) throws IOException {
            int i11 = this.f9103g;
            this.f9103g = WireFormat.c(WireFormat.a(this.f9102f), 4);
            try {
                T newInstance = t0Var.newInstance();
                t0Var.b(newInstance, this, lVar);
                t0Var.makeImmutable(newInstance);
                if (this.f9102f == this.f9103g) {
                    return newInstance;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } finally {
                this.f9103g = i11;
            }
        }

        public final int m() throws IOException {
            w(4);
            return n();
        }

        public final int n() {
            int i11 = this.f9099c;
            byte[] bArr = this.f9098b;
            this.f9099c = i11 + 4;
            return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
        }

        public final long o() throws IOException {
            w(8);
            return p();
        }

        public final long p() {
            int i11 = this.f9099c;
            byte[] bArr = this.f9098b;
            this.f9099c = i11 + 8;
            return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
        }

        public final <T> T q(t0<T> t0Var, l lVar) throws IOException {
            int t11 = t();
            w(t11);
            int i11 = this.f9101e;
            int i12 = this.f9099c + t11;
            this.f9101e = i12;
            try {
                T newInstance = t0Var.newInstance();
                t0Var.b(newInstance, this, lVar);
                t0Var.makeImmutable(newInstance);
                if (this.f9099c == i12) {
                    return newInstance;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } finally {
                this.f9101e = i11;
            }
        }

        public String r(boolean z11) throws IOException {
            y(2);
            int t11 = t();
            if (t11 == 0) {
                return "";
            }
            w(t11);
            if (z11) {
                byte[] bArr = this.f9098b;
                int i11 = this.f9099c;
                if (!Utf8.t(bArr, i11, i11 + t11)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            String str = new String(this.f9098b, this.f9099c, t11, u.f9213a);
            this.f9099c += t11;
            return str;
        }

        public boolean readBool() throws IOException {
            y(0);
            if (t() != 0) {
                return true;
            }
            return false;
        }

        public void readBoolList(List<Boolean> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof e) {
                e eVar = (e) list;
                int b11 = WireFormat.b(this.f9102f);
                if (b11 == 0) {
                    do {
                        eVar.addBoolean(readBool());
                        if (!i()) {
                            i12 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i12;
                } else if (b11 == 2) {
                    int t11 = this.f9099c + t();
                    while (this.f9099c < t11) {
                        eVar.addBoolean(t() != 0);
                    }
                    x(t11);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b12 = WireFormat.b(this.f9102f);
                if (b12 == 0) {
                    do {
                        list.add(Boolean.valueOf(readBool()));
                        if (!i()) {
                            i11 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i11;
                } else if (b12 == 2) {
                    int t12 = this.f9099c + t();
                    while (this.f9099c < t12) {
                        list.add(Boolean.valueOf(t() != 0));
                    }
                    x(t12);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public ByteString readBytes() throws IOException {
            ByteString byteString;
            y(2);
            int t11 = t();
            if (t11 == 0) {
                return ByteString.EMPTY;
            }
            w(t11);
            if (this.f9097a) {
                byteString = ByteString.wrap(this.f9098b, this.f9099c, t11);
            } else {
                byteString = ByteString.copyFrom(this.f9098b, this.f9099c, t11);
            }
            this.f9099c += t11;
            return byteString;
        }

        public void readBytesList(List<ByteString> list) throws IOException {
            int i11;
            if (WireFormat.b(this.f9102f) == 2) {
                do {
                    list.add(readBytes());
                    if (!i()) {
                        i11 = this.f9099c;
                    } else {
                        return;
                    }
                } while (t() == this.f9102f);
                this.f9099c = i11;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        public double readDouble() throws IOException {
            y(1);
            return Double.longBitsToDouble(o());
        }

        public void readDoubleList(List<Double> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof j) {
                j jVar = (j) list;
                int b11 = WireFormat.b(this.f9102f);
                if (b11 == 1) {
                    do {
                        jVar.addDouble(readDouble());
                        if (!i()) {
                            i12 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i12;
                } else if (b11 == 2) {
                    int t11 = t();
                    E(t11);
                    int i13 = this.f9099c + t11;
                    while (this.f9099c < i13) {
                        jVar.addDouble(Double.longBitsToDouble(p()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b12 = WireFormat.b(this.f9102f);
                if (b12 == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (!i()) {
                            i11 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i11;
                } else if (b12 == 2) {
                    int t12 = t();
                    E(t12);
                    int i14 = this.f9099c + t12;
                    while (this.f9099c < i14) {
                        list.add(Double.valueOf(Double.longBitsToDouble(p())));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public int readEnum() throws IOException {
            y(0);
            return t();
        }

        public void readEnumList(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof t) {
                t tVar = (t) list;
                int b11 = WireFormat.b(this.f9102f);
                if (b11 == 0) {
                    do {
                        tVar.addInt(readEnum());
                        if (!i()) {
                            i12 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i12;
                } else if (b11 == 2) {
                    int t11 = this.f9099c + t();
                    while (this.f9099c < t11) {
                        tVar.addInt(t());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b12 = WireFormat.b(this.f9102f);
                if (b12 == 0) {
                    do {
                        list.add(Integer.valueOf(readEnum()));
                        if (!i()) {
                            i11 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i11;
                } else if (b12 == 2) {
                    int t12 = this.f9099c + t();
                    while (this.f9099c < t12) {
                        list.add(Integer.valueOf(t()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public int readFixed32() throws IOException {
            y(5);
            return m();
        }

        public void readFixed32List(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof t) {
                t tVar = (t) list;
                int b11 = WireFormat.b(this.f9102f);
                if (b11 == 2) {
                    int t11 = t();
                    D(t11);
                    int i13 = this.f9099c + t11;
                    while (this.f9099c < i13) {
                        tVar.addInt(n());
                    }
                } else if (b11 == 5) {
                    do {
                        tVar.addInt(readFixed32());
                        if (!i()) {
                            i12 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i12;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b12 = WireFormat.b(this.f9102f);
                if (b12 == 2) {
                    int t12 = t();
                    D(t12);
                    int i14 = this.f9099c + t12;
                    while (this.f9099c < i14) {
                        list.add(Integer.valueOf(n()));
                    }
                } else if (b12 == 5) {
                    do {
                        list.add(Integer.valueOf(readFixed32()));
                        if (!i()) {
                            i11 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i11;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readFixed64() throws IOException {
            y(1);
            return o();
        }

        public void readFixed64List(List<Long> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof y) {
                y yVar = (y) list;
                int b11 = WireFormat.b(this.f9102f);
                if (b11 == 1) {
                    do {
                        yVar.addLong(readFixed64());
                        if (!i()) {
                            i12 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i12;
                } else if (b11 == 2) {
                    int t11 = t();
                    E(t11);
                    int i13 = this.f9099c + t11;
                    while (this.f9099c < i13) {
                        yVar.addLong(p());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b12 = WireFormat.b(this.f9102f);
                if (b12 == 1) {
                    do {
                        list.add(Long.valueOf(readFixed64()));
                        if (!i()) {
                            i11 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i11;
                } else if (b12 == 2) {
                    int t12 = t();
                    E(t12);
                    int i14 = this.f9099c + t12;
                    while (this.f9099c < i14) {
                        list.add(Long.valueOf(p()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public float readFloat() throws IOException {
            y(5);
            return Float.intBitsToFloat(m());
        }

        public void readFloatList(List<Float> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof r) {
                r rVar = (r) list;
                int b11 = WireFormat.b(this.f9102f);
                if (b11 == 2) {
                    int t11 = t();
                    D(t11);
                    int i13 = this.f9099c + t11;
                    while (this.f9099c < i13) {
                        rVar.addFloat(Float.intBitsToFloat(n()));
                    }
                } else if (b11 == 5) {
                    do {
                        rVar.addFloat(readFloat());
                        if (!i()) {
                            i12 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i12;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b12 = WireFormat.b(this.f9102f);
                if (b12 == 2) {
                    int t12 = t();
                    D(t12);
                    int i14 = this.f9099c + t12;
                    while (this.f9099c < i14) {
                        list.add(Float.valueOf(Float.intBitsToFloat(n())));
                    }
                } else if (b12 == 5) {
                    do {
                        list.add(Float.valueOf(readFloat()));
                        if (!i()) {
                            i11 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i11;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public int readInt32() throws IOException {
            y(0);
            return t();
        }

        public void readInt32List(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof t) {
                t tVar = (t) list;
                int b11 = WireFormat.b(this.f9102f);
                if (b11 == 0) {
                    do {
                        tVar.addInt(readInt32());
                        if (!i()) {
                            i12 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i12;
                } else if (b11 == 2) {
                    int t11 = this.f9099c + t();
                    while (this.f9099c < t11) {
                        tVar.addInt(t());
                    }
                    x(t11);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b12 = WireFormat.b(this.f9102f);
                if (b12 == 0) {
                    do {
                        list.add(Integer.valueOf(readInt32()));
                        if (!i()) {
                            i11 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i11;
                } else if (b12 == 2) {
                    int t12 = this.f9099c + t();
                    while (this.f9099c < t12) {
                        list.add(Integer.valueOf(t()));
                    }
                    x(t12);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readInt64() throws IOException {
            y(0);
            return u();
        }

        public void readInt64List(List<Long> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof y) {
                y yVar = (y) list;
                int b11 = WireFormat.b(this.f9102f);
                if (b11 == 0) {
                    do {
                        yVar.addLong(readInt64());
                        if (!i()) {
                            i12 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i12;
                } else if (b11 == 2) {
                    int t11 = this.f9099c + t();
                    while (this.f9099c < t11) {
                        yVar.addLong(u());
                    }
                    x(t11);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b12 = WireFormat.b(this.f9102f);
                if (b12 == 0) {
                    do {
                        list.add(Long.valueOf(readInt64()));
                        if (!i()) {
                            i11 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i11;
                } else if (b12 == 2) {
                    int t12 = this.f9099c + t();
                    while (this.f9099c < t12) {
                        list.add(Long.valueOf(u()));
                    }
                    x(t12);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public int readSFixed32() throws IOException {
            y(5);
            return m();
        }

        public void readSFixed32List(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof t) {
                t tVar = (t) list;
                int b11 = WireFormat.b(this.f9102f);
                if (b11 == 2) {
                    int t11 = t();
                    D(t11);
                    int i13 = this.f9099c + t11;
                    while (this.f9099c < i13) {
                        tVar.addInt(n());
                    }
                } else if (b11 == 5) {
                    do {
                        tVar.addInt(readSFixed32());
                        if (!i()) {
                            i12 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i12;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b12 = WireFormat.b(this.f9102f);
                if (b12 == 2) {
                    int t12 = t();
                    D(t12);
                    int i14 = this.f9099c + t12;
                    while (this.f9099c < i14) {
                        list.add(Integer.valueOf(n()));
                    }
                } else if (b12 == 5) {
                    do {
                        list.add(Integer.valueOf(readSFixed32()));
                        if (!i()) {
                            i11 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i11;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readSFixed64() throws IOException {
            y(1);
            return o();
        }

        public void readSFixed64List(List<Long> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof y) {
                y yVar = (y) list;
                int b11 = WireFormat.b(this.f9102f);
                if (b11 == 1) {
                    do {
                        yVar.addLong(readSFixed64());
                        if (!i()) {
                            i12 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i12;
                } else if (b11 == 2) {
                    int t11 = t();
                    E(t11);
                    int i13 = this.f9099c + t11;
                    while (this.f9099c < i13) {
                        yVar.addLong(p());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b12 = WireFormat.b(this.f9102f);
                if (b12 == 1) {
                    do {
                        list.add(Long.valueOf(readSFixed64()));
                        if (!i()) {
                            i11 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i11;
                } else if (b12 == 2) {
                    int t12 = t();
                    E(t12);
                    int i14 = this.f9099c + t12;
                    while (this.f9099c < i14) {
                        list.add(Long.valueOf(p()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public int readSInt32() throws IOException {
            y(0);
            return g.b(t());
        }

        public void readSInt32List(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof t) {
                t tVar = (t) list;
                int b11 = WireFormat.b(this.f9102f);
                if (b11 == 0) {
                    do {
                        tVar.addInt(readSInt32());
                        if (!i()) {
                            i12 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i12;
                } else if (b11 == 2) {
                    int t11 = this.f9099c + t();
                    while (this.f9099c < t11) {
                        tVar.addInt(g.b(t()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b12 = WireFormat.b(this.f9102f);
                if (b12 == 0) {
                    do {
                        list.add(Integer.valueOf(readSInt32()));
                        if (!i()) {
                            i11 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i11;
                } else if (b12 == 2) {
                    int t12 = this.f9099c + t();
                    while (this.f9099c < t12) {
                        list.add(Integer.valueOf(g.b(t())));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readSInt64() throws IOException {
            y(0);
            return g.c(u());
        }

        public void readSInt64List(List<Long> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof y) {
                y yVar = (y) list;
                int b11 = WireFormat.b(this.f9102f);
                if (b11 == 0) {
                    do {
                        yVar.addLong(readSInt64());
                        if (!i()) {
                            i12 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i12;
                } else if (b11 == 2) {
                    int t11 = this.f9099c + t();
                    while (this.f9099c < t11) {
                        yVar.addLong(g.c(u()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b12 = WireFormat.b(this.f9102f);
                if (b12 == 0) {
                    do {
                        list.add(Long.valueOf(readSInt64()));
                        if (!i()) {
                            i11 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i11;
                } else if (b12 == 2) {
                    int t12 = this.f9099c + t();
                    while (this.f9099c < t12) {
                        list.add(Long.valueOf(g.c(u())));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public String readString() throws IOException {
            return r(false);
        }

        public void readStringList(List<String> list) throws IOException {
            s(list, false);
        }

        public void readStringListRequireUtf8(List<String> list) throws IOException {
            s(list, true);
        }

        public String readStringRequireUtf8() throws IOException {
            return r(true);
        }

        public int readUInt32() throws IOException {
            y(0);
            return t();
        }

        public void readUInt32List(List<Integer> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof t) {
                t tVar = (t) list;
                int b11 = WireFormat.b(this.f9102f);
                if (b11 == 0) {
                    do {
                        tVar.addInt(readUInt32());
                        if (!i()) {
                            i12 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i12;
                } else if (b11 == 2) {
                    int t11 = this.f9099c + t();
                    while (this.f9099c < t11) {
                        tVar.addInt(t());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b12 = WireFormat.b(this.f9102f);
                if (b12 == 0) {
                    do {
                        list.add(Integer.valueOf(readUInt32()));
                        if (!i()) {
                            i11 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i11;
                } else if (b12 == 2) {
                    int t12 = this.f9099c + t();
                    while (this.f9099c < t12) {
                        list.add(Integer.valueOf(t()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public long readUInt64() throws IOException {
            y(0);
            return u();
        }

        public void readUInt64List(List<Long> list) throws IOException {
            int i11;
            int i12;
            if (list instanceof y) {
                y yVar = (y) list;
                int b11 = WireFormat.b(this.f9102f);
                if (b11 == 0) {
                    do {
                        yVar.addLong(readUInt64());
                        if (!i()) {
                            i12 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i12;
                } else if (b11 == 2) {
                    int t11 = this.f9099c + t();
                    while (this.f9099c < t11) {
                        yVar.addLong(u());
                    }
                    x(t11);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int b12 = WireFormat.b(this.f9102f);
                if (b12 == 0) {
                    do {
                        list.add(Long.valueOf(readUInt64()));
                        if (!i()) {
                            i11 = this.f9099c;
                        } else {
                            return;
                        }
                    } while (t() == this.f9102f);
                    this.f9099c = i11;
                } else if (b12 == 2) {
                    int t12 = this.f9099c + t();
                    while (this.f9099c < t12) {
                        list.add(Long.valueOf(u()));
                    }
                    x(t12);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public void s(List<String> list, boolean z11) throws IOException {
            int i11;
            int i12;
            if (WireFormat.b(this.f9102f) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            } else if (!(list instanceof w) || z11) {
                do {
                    list.add(r(z11));
                    if (!i()) {
                        i11 = this.f9099c;
                    } else {
                        return;
                    }
                } while (t() == this.f9102f);
                this.f9099c = i11;
            } else {
                w wVar = (w) list;
                do {
                    wVar.f(readBytes());
                    if (!i()) {
                        i12 = this.f9099c;
                    } else {
                        return;
                    }
                } while (t() == this.f9102f);
                this.f9099c = i12;
            }
        }

        public boolean skipField() throws IOException {
            int i11;
            if (i() || (i11 = this.f9102f) == this.f9103g) {
                return false;
            }
            int b11 = WireFormat.b(i11);
            if (b11 == 0) {
                B();
                return true;
            } else if (b11 == 1) {
                z(8);
                return true;
            } else if (b11 == 2) {
                z(t());
                return true;
            } else if (b11 == 3) {
                A();
                return true;
            } else if (b11 == 5) {
                z(4);
                return true;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final int t() throws IOException {
            byte b11;
            int i11 = this.f9099c;
            int i12 = this.f9101e;
            if (i12 != i11) {
                byte[] bArr = this.f9098b;
                int i13 = i11 + 1;
                byte b12 = bArr[i11];
                if (b12 >= 0) {
                    this.f9099c = i13;
                    return b12;
                } else if (i12 - i13 < 9) {
                    return (int) v();
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
                    this.f9099c = i14;
                    return b11;
                }
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public long u() throws IOException {
            long j11;
            int i11;
            long j12;
            long j13;
            byte b11;
            int i12 = this.f9099c;
            int i13 = this.f9101e;
            if (i13 != i12) {
                byte[] bArr = this.f9098b;
                int i14 = i12 + 1;
                byte b12 = bArr[i12];
                if (b12 >= 0) {
                    this.f9099c = i14;
                    return (long) b12;
                } else if (i13 - i14 < 9) {
                    return v();
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
                        this.f9099c = i11;
                        return j11;
                    }
                    j11 = (long) b11;
                    this.f9099c = i11;
                    return j11;
                }
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public final long v() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                byte j12 = j();
                j11 |= ((long) (j12 & Ascii.DEL)) << i11;
                if ((j12 & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final void w(int i11) throws IOException {
            if (i11 < 0 || i11 > this.f9101e - this.f9099c) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public final void x(int i11) throws IOException {
            if (this.f9099c != i11) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public final void y(int i11) throws IOException {
            if (WireFormat.b(this.f9102f) != i11) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final void z(int i11) throws IOException {
            w(i11);
            this.f9099c += i11;
        }
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d h(ByteBuffer byteBuffer, boolean z11) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer, z11);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    public d() {
    }
}
