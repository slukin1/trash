package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import java.io.DataOutput;

@GwtIncompatible
public interface ByteArrayDataOutput extends DataOutput {
    byte[] toByteArray();

    void write(int i11);

    void write(byte[] bArr);

    void write(byte[] bArr, int i11, int i12);

    void writeBoolean(boolean z11);

    void writeByte(int i11);

    @Deprecated
    void writeBytes(String str);

    void writeChar(int i11);

    void writeChars(String str);

    void writeDouble(double d11);

    void writeFloat(float f11);

    void writeInt(int i11);

    void writeLong(long j11);

    void writeShort(int i11);

    void writeUTF(String str);
}
