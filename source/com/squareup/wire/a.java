package com.squareup.wire;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.f;
import java.io.IOException;

public abstract class a<E extends f> extends ProtoAdapter<E> {
    public a(Class<E> cls) {
        super(FieldEncoding.VARINT, cls);
    }

    /* renamed from: r */
    public final E c(c cVar) throws IOException {
        int l11 = cVar.l();
        E u11 = u(l11);
        if (u11 != null) {
            return u11;
        }
        throw new ProtoAdapter.EnumConstantNotFoundException(l11, this.f30188b);
    }

    /* renamed from: s */
    public final void g(d dVar, E e11) throws IOException {
        dVar.q(e11.getValue());
    }

    /* renamed from: t */
    public final int l(E e11) {
        return d.i(e11.getValue());
    }

    public abstract E u(int i11);
}
