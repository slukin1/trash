package androidx.datastore.preferences.protobuf;

import java.io.IOException;

public class a1 extends y0<z0, z0> {
    /* renamed from: A */
    public z0 g(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    /* renamed from: B */
    public int h(z0 z0Var) {
        return z0Var.f();
    }

    /* renamed from: C */
    public int i(z0 z0Var) {
        return z0Var.g();
    }

    /* renamed from: D */
    public z0 k(z0 z0Var, z0 z0Var2) {
        return z0Var2.equals(z0.e()) ? z0Var : z0.k(z0Var, z0Var2);
    }

    /* renamed from: E */
    public z0 n() {
        return z0.l();
    }

    /* renamed from: F */
    public void o(Object obj, z0 z0Var) {
        p(obj, z0Var);
    }

    /* renamed from: G */
    public void p(Object obj, z0 z0Var) {
        ((GeneratedMessageLite) obj).unknownFields = z0Var;
    }

    /* renamed from: H */
    public z0 r(z0 z0Var) {
        z0Var.j();
        return z0Var;
    }

    /* renamed from: I */
    public void s(z0 z0Var, Writer writer) throws IOException {
        z0Var.o(writer);
    }

    /* renamed from: J */
    public void t(z0 z0Var, Writer writer) throws IOException {
        z0Var.q(writer);
    }

    public void j(Object obj) {
        g(obj).j();
    }

    public boolean q(s0 s0Var) {
        return false;
    }

    /* renamed from: u */
    public void a(z0 z0Var, int i11, int i12) {
        z0Var.n(WireFormat.c(i11, 5), Integer.valueOf(i12));
    }

    /* renamed from: v */
    public void b(z0 z0Var, int i11, long j11) {
        z0Var.n(WireFormat.c(i11, 1), Long.valueOf(j11));
    }

    /* renamed from: w */
    public void c(z0 z0Var, int i11, z0 z0Var2) {
        z0Var.n(WireFormat.c(i11, 3), z0Var2);
    }

    /* renamed from: x */
    public void d(z0 z0Var, int i11, ByteString byteString) {
        z0Var.n(WireFormat.c(i11, 2), byteString);
    }

    /* renamed from: y */
    public void e(z0 z0Var, int i11, long j11) {
        z0Var.n(WireFormat.c(i11, 0), Long.valueOf(j11));
    }

    /* renamed from: z */
    public z0 f(Object obj) {
        z0 A = g(obj);
        if (A != z0.e()) {
            return A;
        }
        z0 l11 = z0.l();
        p(obj, l11);
        return l11;
    }
}
