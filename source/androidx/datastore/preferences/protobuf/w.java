package androidx.datastore.preferences.protobuf;

import java.util.List;

public interface w extends List {
    void f(ByteString byteString);

    Object getRaw(int i11);

    List<?> getUnderlyingElements();

    w getUnmodifiableView();
}
