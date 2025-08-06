package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.q;
import androidx.datastore.preferences.protobuf.q.b;
import java.io.IOException;
import java.util.Map;

public abstract class m<T extends q.b<T>> {
    public abstract int a(Map.Entry<?, ?> entry);

    public abstract Object b(l lVar, f0 f0Var, int i11);

    public abstract q<T> c(Object obj);

    public abstract q<T> d(Object obj);

    public abstract boolean e(f0 f0Var);

    public abstract void f(Object obj);

    public abstract <UT, UB> UB g(s0 s0Var, Object obj, l lVar, q<T> qVar, UB ub2, y0<UT, UB> y0Var) throws IOException;

    public abstract void h(s0 s0Var, Object obj, l lVar, q<T> qVar) throws IOException;

    public abstract void i(ByteString byteString, Object obj, l lVar, q<T> qVar) throws IOException;

    public abstract void j(Writer writer, Map.Entry<?, ?> entry) throws IOException;
}
