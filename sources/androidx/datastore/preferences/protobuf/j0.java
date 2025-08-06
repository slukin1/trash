package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.q;
import androidx.datastore.preferences.protobuf.v;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public final class j0<T> implements t0<T> {

    /* renamed from: a  reason: collision with root package name */
    public final f0 f9173a;

    /* renamed from: b  reason: collision with root package name */
    public final y0<?, ?> f9174b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f9175c;

    /* renamed from: d  reason: collision with root package name */
    public final m<?> f9176d;

    public j0(y0<?, ?> y0Var, m<?> mVar, f0 f0Var) {
        this.f9174b = y0Var;
        this.f9175c = mVar.e(f0Var);
        this.f9176d = mVar;
        this.f9173a = f0Var;
    }

    public static <T> j0<T> f(y0<?, ?> y0Var, m<?> mVar, f0 f0Var) {
        return new j0<>(y0Var, mVar, f0Var);
    }

    public void a(T t11, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> s11 = this.f9176d.c(t11).s();
        while (s11.hasNext()) {
            Map.Entry next = s11.next();
            q.b bVar = (q.b) next.getKey();
            if (bVar.getLiteJavaType() != WireFormat.JavaType.MESSAGE || bVar.isRepeated() || bVar.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof v.b) {
                writer.writeMessageSetItem(bVar.getNumber(), ((v.b) next).a().e());
            } else {
                writer.writeMessageSetItem(bVar.getNumber(), next.getValue());
            }
        }
        h(this.f9174b, t11, writer);
    }

    public void b(T t11, s0 s0Var, l lVar) throws IOException {
        e(this.f9174b, this.f9176d, t11, s0Var, lVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: androidx.datastore.preferences.protobuf.GeneratedMessageLite$d} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(T r11, byte[] r12, int r13, int r14, androidx.datastore.preferences.protobuf.c.b r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            androidx.datastore.preferences.protobuf.GeneratedMessageLite r0 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite) r0
            androidx.datastore.preferences.protobuf.z0 r1 = r0.unknownFields
            androidx.datastore.preferences.protobuf.z0 r2 = androidx.datastore.preferences.protobuf.z0.e()
            if (r1 != r2) goto L_0x0011
            androidx.datastore.preferences.protobuf.z0 r1 = androidx.datastore.preferences.protobuf.z0.l()
            r0.unknownFields = r1
        L_0x0011:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtendableMessage r11 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage) r11
            androidx.datastore.preferences.protobuf.q r11 = r11.C()
            r0 = 0
            r2 = r0
        L_0x0019:
            if (r13 >= r14) goto L_0x00d7
            int r4 = androidx.datastore.preferences.protobuf.c.I(r12, r13, r15)
            int r13 = r15.f9065a
            int r3 = androidx.datastore.preferences.protobuf.WireFormat.f9051a
            r5 = 2
            if (r13 == r3) goto L_0x006b
            int r3 = androidx.datastore.preferences.protobuf.WireFormat.b(r13)
            if (r3 != r5) goto L_0x0066
            androidx.datastore.preferences.protobuf.m<?> r2 = r10.f9176d
            androidx.datastore.preferences.protobuf.l r3 = r15.f9068d
            androidx.datastore.preferences.protobuf.f0 r5 = r10.f9173a
            int r6 = androidx.datastore.preferences.protobuf.WireFormat.a(r13)
            java.lang.Object r2 = r2.b(r3, r5, r6)
            r8 = r2
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$d r8 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.d) r8
            if (r8 == 0) goto L_0x005b
            androidx.datastore.preferences.protobuf.p0 r13 = androidx.datastore.preferences.protobuf.p0.a()
            androidx.datastore.preferences.protobuf.f0 r2 = r8.b()
            java.lang.Class r2 = r2.getClass()
            androidx.datastore.preferences.protobuf.t0 r13 = r13.d(r2)
            int r13 = androidx.datastore.preferences.protobuf.c.p(r13, r12, r4, r14, r15)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r2 = r8.f9014b
            java.lang.Object r3 = r15.f9067c
            r11.x(r2, r3)
            goto L_0x0064
        L_0x005b:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = androidx.datastore.preferences.protobuf.c.G(r2, r3, r4, r5, r6, r7)
        L_0x0064:
            r2 = r8
            goto L_0x0019
        L_0x0066:
            int r13 = androidx.datastore.preferences.protobuf.c.N(r13, r12, r4, r14, r15)
            goto L_0x0019
        L_0x006b:
            r13 = 0
            r3 = r0
        L_0x006d:
            if (r4 >= r14) goto L_0x00cb
            int r4 = androidx.datastore.preferences.protobuf.c.I(r12, r4, r15)
            int r6 = r15.f9065a
            int r7 = androidx.datastore.preferences.protobuf.WireFormat.a(r6)
            int r8 = androidx.datastore.preferences.protobuf.WireFormat.b(r6)
            if (r7 == r5) goto L_0x00ac
            r9 = 3
            if (r7 == r9) goto L_0x0083
            goto L_0x00c1
        L_0x0083:
            if (r2 == 0) goto L_0x00a1
            androidx.datastore.preferences.protobuf.p0 r6 = androidx.datastore.preferences.protobuf.p0.a()
            androidx.datastore.preferences.protobuf.f0 r7 = r2.b()
            java.lang.Class r7 = r7.getClass()
            androidx.datastore.preferences.protobuf.t0 r6 = r6.d(r7)
            int r4 = androidx.datastore.preferences.protobuf.c.p(r6, r12, r4, r14, r15)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$c r6 = r2.f9014b
            java.lang.Object r7 = r15.f9067c
            r11.x(r6, r7)
            goto L_0x006d
        L_0x00a1:
            if (r8 != r5) goto L_0x00c1
            int r4 = androidx.datastore.preferences.protobuf.c.b(r12, r4, r15)
            java.lang.Object r3 = r15.f9067c
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            goto L_0x006d
        L_0x00ac:
            if (r8 != 0) goto L_0x00c1
            int r4 = androidx.datastore.preferences.protobuf.c.I(r12, r4, r15)
            int r13 = r15.f9065a
            androidx.datastore.preferences.protobuf.m<?> r2 = r10.f9176d
            androidx.datastore.preferences.protobuf.l r6 = r15.f9068d
            androidx.datastore.preferences.protobuf.f0 r7 = r10.f9173a
            java.lang.Object r2 = r2.b(r6, r7, r13)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$d r2 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.d) r2
            goto L_0x006d
        L_0x00c1:
            int r7 = androidx.datastore.preferences.protobuf.WireFormat.f9052b
            if (r6 != r7) goto L_0x00c6
            goto L_0x00cb
        L_0x00c6:
            int r4 = androidx.datastore.preferences.protobuf.c.N(r6, r12, r4, r14, r15)
            goto L_0x006d
        L_0x00cb:
            if (r3 == 0) goto L_0x00d4
            int r13 = androidx.datastore.preferences.protobuf.WireFormat.c(r13, r5)
            r1.n(r13, r3)
        L_0x00d4:
            r13 = r4
            goto L_0x0019
        L_0x00d7:
            if (r13 != r14) goto L_0x00da
            return
        L_0x00da:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r11 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.j0.c(java.lang.Object, byte[], int, int, androidx.datastore.preferences.protobuf.c$b):void");
    }

    public final <UT, UB> int d(y0<UT, UB> y0Var, T t11) {
        return y0Var.i(y0Var.g(t11));
    }

    public final <UT, UB, ET extends q.b<ET>> void e(y0<UT, UB> y0Var, m<ET> mVar, T t11, s0 s0Var, l lVar) throws IOException {
        UB f11 = y0Var.f(t11);
        q<ET> d11 = mVar.d(t11);
        do {
            try {
                if (s0Var.getFieldNumber() == Integer.MAX_VALUE) {
                    y0Var.o(t11, f11);
                    return;
                }
            } finally {
                y0Var.o(t11, f11);
            }
        } while (g(s0Var, lVar, mVar, d11, y0Var, f11));
    }

    public boolean equals(T t11, T t12) {
        if (!this.f9174b.g(t11).equals(this.f9174b.g(t12))) {
            return false;
        }
        if (this.f9175c) {
            return this.f9176d.c(t11).equals(this.f9176d.c(t12));
        }
        return true;
    }

    public final <UT, UB, ET extends q.b<ET>> boolean g(s0 s0Var, l lVar, m<ET> mVar, q<ET> qVar, y0<UT, UB> y0Var, UB ub2) throws IOException {
        int tag = s0Var.getTag();
        if (tag == WireFormat.f9051a) {
            int i11 = 0;
            Object obj = null;
            ByteString byteString = null;
            while (s0Var.getFieldNumber() != Integer.MAX_VALUE) {
                int tag2 = s0Var.getTag();
                if (tag2 == WireFormat.f9053c) {
                    i11 = s0Var.readUInt32();
                    obj = mVar.b(lVar, this.f9173a, i11);
                } else if (tag2 == WireFormat.f9054d) {
                    if (obj != null) {
                        mVar.h(s0Var, obj, lVar, qVar);
                    } else {
                        byteString = s0Var.readBytes();
                    }
                } else if (!s0Var.skipField()) {
                    break;
                }
            }
            if (s0Var.getTag() == WireFormat.f9052b) {
                if (byteString != null) {
                    if (obj != null) {
                        mVar.i(byteString, obj, lVar, qVar);
                    } else {
                        y0Var.d(ub2, i11, byteString);
                    }
                }
                return true;
            }
            throw InvalidProtocolBufferException.invalidEndTag();
        } else if (WireFormat.b(tag) != 2) {
            return s0Var.skipField();
        } else {
            Object b11 = mVar.b(lVar, this.f9173a, WireFormat.a(tag));
            if (b11 == null) {
                return y0Var.m(ub2, s0Var);
            }
            mVar.h(s0Var, b11, lVar, qVar);
            return true;
        }
    }

    public int getSerializedSize(T t11) {
        int d11 = d(this.f9174b, t11) + 0;
        return this.f9175c ? d11 + this.f9176d.c(t11).j() : d11;
    }

    public final <UT, UB> void h(y0<UT, UB> y0Var, T t11, Writer writer) throws IOException {
        y0Var.s(y0Var.g(t11), writer);
    }

    public int hashCode(T t11) {
        int hashCode = this.f9174b.g(t11).hashCode();
        return this.f9175c ? (hashCode * 53) + this.f9176d.c(t11).hashCode() : hashCode;
    }

    public final boolean isInitialized(T t11) {
        return this.f9176d.c(t11).p();
    }

    public void makeImmutable(T t11) {
        this.f9174b.j(t11);
        this.f9176d.f(t11);
    }

    public void mergeFrom(T t11, T t12) {
        v0.G(this.f9174b, t11, t12);
        if (this.f9175c) {
            v0.E(this.f9176d, t11, t12);
        }
    }

    public T newInstance() {
        return this.f9173a.newBuilderForType().buildPartial();
    }
}
