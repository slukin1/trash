package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@GwtIncompatible
@Beta
public final class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput {
    public LittleEndianDataOutputStream(OutputStream outputStream) {
        super(new DataOutputStream((OutputStream) Preconditions.checkNotNull(outputStream)));
    }

    public void close() throws IOException {
        this.out.close();
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.out.write(bArr, i11, i12);
    }

    public void writeBoolean(boolean z11) throws IOException {
        ((DataOutputStream) this.out).writeBoolean(z11);
    }

    public void writeByte(int i11) throws IOException {
        ((DataOutputStream) this.out).writeByte(i11);
    }

    @Deprecated
    public void writeBytes(String str) throws IOException {
        ((DataOutputStream) this.out).writeBytes(str);
    }

    public void writeChar(int i11) throws IOException {
        writeShort(i11);
    }

    public void writeChars(String str) throws IOException {
        for (int i11 = 0; i11 < str.length(); i11++) {
            writeChar(str.charAt(i11));
        }
    }

    public void writeDouble(double d11) throws IOException {
        writeLong(Double.doubleToLongBits(d11));
    }

    public void writeFloat(float f11) throws IOException {
        writeInt(Float.floatToIntBits(f11));
    }

    public void writeInt(int i11) throws IOException {
        this.out.write(i11 & 255);
        this.out.write((i11 >> 8) & 255);
        this.out.write((i11 >> 16) & 255);
        this.out.write((i11 >> 24) & 255);
    }

    public void writeLong(long j11) throws IOException {
        byte[] byteArray = Longs.toByteArray(Long.reverseBytes(j11));
        write(byteArray, 0, byteArray.length);
    }

    public void writeShort(int i11) throws IOException {
        this.out.write(i11 & 255);
        this.out.write((i11 >> 8) & 255);
    }

    public void writeUTF(String str) throws IOException {
        ((DataOutputStream) this.out).writeUTF(str);
    }
}
