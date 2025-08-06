package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInput;

@GwtIncompatible
public interface ByteArrayDataInput extends DataInput {
    @CanIgnoreReturnValue
    boolean readBoolean();

    @CanIgnoreReturnValue
    byte readByte();

    @CanIgnoreReturnValue
    char readChar();

    @CanIgnoreReturnValue
    double readDouble();

    @CanIgnoreReturnValue
    float readFloat();

    void readFully(byte[] bArr);

    void readFully(byte[] bArr, int i11, int i12);

    @CanIgnoreReturnValue
    int readInt();

    @CanIgnoreReturnValue
    String readLine();

    @CanIgnoreReturnValue
    long readLong();

    @CanIgnoreReturnValue
    short readShort();

    @CanIgnoreReturnValue
    String readUTF();

    @CanIgnoreReturnValue
    int readUnsignedByte();

    @CanIgnoreReturnValue
    int readUnsignedShort();

    int skipBytes(int i11);
}
