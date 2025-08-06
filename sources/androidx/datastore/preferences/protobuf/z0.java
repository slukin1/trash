package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;

public final class z0 {

    /* renamed from: f  reason: collision with root package name */
    public static final z0 f9260f = new z0(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    public int f9261a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f9262b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f9263c;

    /* renamed from: d  reason: collision with root package name */
    public int f9264d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9265e;

    public z0() {
        this(0, new int[8], new Object[8], true);
    }

    public static boolean c(int[] iArr, int[] iArr2, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (iArr[i12] != iArr2[i12]) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(Object[] objArr, Object[] objArr2, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (!objArr[i12].equals(objArr2[i12])) {
                return false;
            }
        }
        return true;
    }

    public static z0 e() {
        return f9260f;
    }

    public static int h(int[] iArr, int i11) {
        int i12 = 17;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 = (i12 * 31) + iArr[i13];
        }
        return i12;
    }

    public static int i(Object[] objArr, int i11) {
        int i12 = 17;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 = (i12 * 31) + objArr[i13].hashCode();
        }
        return i12;
    }

    public static z0 k(z0 z0Var, z0 z0Var2) {
        int i11 = z0Var.f9261a + z0Var2.f9261a;
        int[] copyOf = Arrays.copyOf(z0Var.f9262b, i11);
        System.arraycopy(z0Var2.f9262b, 0, copyOf, z0Var.f9261a, z0Var2.f9261a);
        Object[] copyOf2 = Arrays.copyOf(z0Var.f9263c, i11);
        System.arraycopy(z0Var2.f9263c, 0, copyOf2, z0Var.f9261a, z0Var2.f9261a);
        return new z0(i11, copyOf, copyOf2, true);
    }

    public static z0 l() {
        return new z0();
    }

    public static void p(int i11, Object obj, Writer writer) throws IOException {
        int a11 = WireFormat.a(i11);
        int b11 = WireFormat.b(i11);
        if (b11 == 0) {
            writer.writeInt64(a11, ((Long) obj).longValue());
        } else if (b11 == 1) {
            writer.writeFixed64(a11, ((Long) obj).longValue());
        } else if (b11 == 2) {
            writer.a(a11, (ByteString) obj);
        } else if (b11 != 3) {
            if (b11 == 5) {
                writer.writeFixed32(a11, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
        } else if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            writer.writeStartGroup(a11);
            ((z0) obj).q(writer);
            writer.writeEndGroup(a11);
        } else {
            writer.writeEndGroup(a11);
            ((z0) obj).q(writer);
            writer.writeStartGroup(a11);
        }
    }

    public void a() {
        if (!this.f9265e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b() {
        int i11 = this.f9261a;
        int[] iArr = this.f9262b;
        if (i11 == iArr.length) {
            int i12 = i11 + (i11 < 4 ? 8 : i11 >> 1);
            this.f9262b = Arrays.copyOf(iArr, i12);
            this.f9263c = Arrays.copyOf(this.f9263c, i12);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof z0)) {
            return false;
        }
        z0 z0Var = (z0) obj;
        int i11 = this.f9261a;
        return i11 == z0Var.f9261a && c(this.f9262b, z0Var.f9262b, i11) && d(this.f9263c, z0Var.f9263c, this.f9261a);
    }

    public int f() {
        int i11;
        int i12 = this.f9264d;
        if (i12 != -1) {
            return i12;
        }
        int i13 = 0;
        for (int i14 = 0; i14 < this.f9261a; i14++) {
            int i15 = this.f9262b[i14];
            int a11 = WireFormat.a(i15);
            int b11 = WireFormat.b(i15);
            if (b11 == 0) {
                i11 = CodedOutputStream.Z(a11, ((Long) this.f9263c[i14]).longValue());
            } else if (b11 == 1) {
                i11 = CodedOutputStream.p(a11, ((Long) this.f9263c[i14]).longValue());
            } else if (b11 == 2) {
                i11 = CodedOutputStream.h(a11, (ByteString) this.f9263c[i14]);
            } else if (b11 == 3) {
                i11 = (CodedOutputStream.W(a11) * 2) + ((z0) this.f9263c[i14]).f();
            } else if (b11 == 5) {
                i11 = CodedOutputStream.n(a11, ((Integer) this.f9263c[i14]).intValue());
            } else {
                throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
            }
            i13 += i11;
        }
        this.f9264d = i13;
        return i13;
    }

    public int g() {
        int i11 = this.f9264d;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.f9261a; i13++) {
            i12 += CodedOutputStream.K(WireFormat.a(this.f9262b[i13]), (ByteString) this.f9263c[i13]);
        }
        this.f9264d = i12;
        return i12;
    }

    public int hashCode() {
        int i11 = this.f9261a;
        return ((((527 + i11) * 31) + h(this.f9262b, i11)) * 31) + i(this.f9263c, this.f9261a);
    }

    public void j() {
        this.f9265e = false;
    }

    public final void m(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < this.f9261a; i12++) {
            h0.c(sb2, i11, String.valueOf(WireFormat.a(this.f9262b[i12])), this.f9263c[i12]);
        }
    }

    public void n(int i11, Object obj) {
        a();
        b();
        int[] iArr = this.f9262b;
        int i12 = this.f9261a;
        iArr[i12] = i11;
        this.f9263c[i12] = obj;
        this.f9261a = i12 + 1;
    }

    public void o(Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            for (int i11 = this.f9261a - 1; i11 >= 0; i11--) {
                writer.writeMessageSetItem(WireFormat.a(this.f9262b[i11]), this.f9263c[i11]);
            }
            return;
        }
        for (int i12 = 0; i12 < this.f9261a; i12++) {
            writer.writeMessageSetItem(WireFormat.a(this.f9262b[i12]), this.f9263c[i12]);
        }
    }

    public void q(Writer writer) throws IOException {
        if (this.f9261a != 0) {
            if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
                for (int i11 = 0; i11 < this.f9261a; i11++) {
                    p(this.f9262b[i11], this.f9263c[i11], writer);
                }
                return;
            }
            for (int i12 = this.f9261a - 1; i12 >= 0; i12--) {
                p(this.f9262b[i12], this.f9263c[i12], writer);
            }
        }
    }

    public z0(int i11, int[] iArr, Object[] objArr, boolean z11) {
        this.f9264d = -1;
        this.f9261a = i11;
        this.f9262b = iArr;
        this.f9263c = objArr;
        this.f9265e = z11;
    }
}
