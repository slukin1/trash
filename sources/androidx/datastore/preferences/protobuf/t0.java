package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.c;
import java.io.IOException;

public interface t0<T> {
    void a(T t11, Writer writer) throws IOException;

    void b(T t11, s0 s0Var, l lVar) throws IOException;

    void c(T t11, byte[] bArr, int i11, int i12, c.b bVar) throws IOException;

    boolean equals(T t11, T t12);

    int getSerializedSize(T t11);

    int hashCode(T t11);

    boolean isInitialized(T t11);

    void makeImmutable(T t11);

    void mergeFrom(T t11, T t12);

    T newInstance();
}
