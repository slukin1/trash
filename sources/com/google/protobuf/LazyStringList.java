package com.google.protobuf;

import java.util.Collection;
import java.util.List;

public interface LazyStringList extends ProtocolStringList {
    void add(ByteString byteString);

    void add(byte[] bArr);

    boolean addAllByteArray(Collection<byte[]> collection);

    boolean addAllByteString(Collection<? extends ByteString> collection);

    List<byte[]> asByteArrayList();

    byte[] getByteArray(int i11);

    ByteString getByteString(int i11);

    Object getRaw(int i11);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();

    void mergeFrom(LazyStringList lazyStringList);

    void set(int i11, ByteString byteString);

    void set(int i11, byte[] bArr);
}
