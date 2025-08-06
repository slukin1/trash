package androidx.datastore.preferences.protobuf;

import java.io.IOException;

public abstract class y0<T, B> {
    public abstract void a(B b11, int i11, int i12);

    public abstract void b(B b11, int i11, long j11);

    public abstract void c(B b11, int i11, T t11);

    public abstract void d(B b11, int i11, ByteString byteString);

    public abstract void e(B b11, int i11, long j11);

    public abstract B f(Object obj);

    public abstract T g(Object obj);

    public abstract int h(T t11);

    public abstract int i(T t11);

    public abstract void j(Object obj);

    public abstract T k(T t11, T t12);

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000d, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(B r3, androidx.datastore.preferences.protobuf.s0 r4) throws java.io.IOException {
        /*
            r2 = this;
        L_0x0000:
            int r0 = r4.getFieldNumber()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x000f
            boolean r0 = r2.m(r3, r4)
            if (r0 != 0) goto L_0x0000
        L_0x000f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.y0.l(java.lang.Object, androidx.datastore.preferences.protobuf.s0):void");
    }

    public final boolean m(B b11, s0 s0Var) throws IOException {
        int tag = s0Var.getTag();
        int a11 = WireFormat.a(tag);
        int b12 = WireFormat.b(tag);
        if (b12 == 0) {
            e(b11, a11, s0Var.readInt64());
            return true;
        } else if (b12 == 1) {
            b(b11, a11, s0Var.readFixed64());
            return true;
        } else if (b12 == 2) {
            d(b11, a11, s0Var.readBytes());
            return true;
        } else if (b12 == 3) {
            Object n11 = n();
            int c11 = WireFormat.c(a11, 4);
            l(n11, s0Var);
            if (c11 == s0Var.getTag()) {
                c(b11, a11, r(n11));
                return true;
            }
            throw InvalidProtocolBufferException.invalidEndTag();
        } else if (b12 == 4) {
            return false;
        } else {
            if (b12 == 5) {
                a(b11, a11, s0Var.readFixed32());
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    public abstract B n();

    public abstract void o(Object obj, B b11);

    public abstract void p(Object obj, T t11);

    public abstract boolean q(s0 s0Var);

    public abstract T r(B b11);

    public abstract void s(T t11, Writer writer) throws IOException;

    public abstract void t(T t11, Writer writer) throws IOException;
}
