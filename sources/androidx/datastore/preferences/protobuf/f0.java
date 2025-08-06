package androidx.datastore.preferences.protobuf;

import java.io.IOException;

public interface f0 extends g0 {

    public interface a extends g0, Cloneable {
        a a(f0 f0Var);

        f0 build();

        f0 buildPartial();

        a mergeFrom(byte[] bArr) throws InvalidProtocolBufferException;
    }

    void b(CodedOutputStream codedOutputStream) throws IOException;

    n0<? extends f0> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    byte[] toByteArray();

    ByteString toByteString();
}
