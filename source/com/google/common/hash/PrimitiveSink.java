package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@CanIgnoreReturnValue
@Beta
public interface PrimitiveSink {
    PrimitiveSink putBoolean(boolean z11);

    PrimitiveSink putByte(byte b11);

    PrimitiveSink putBytes(ByteBuffer byteBuffer);

    PrimitiveSink putBytes(byte[] bArr);

    PrimitiveSink putBytes(byte[] bArr, int i11, int i12);

    PrimitiveSink putChar(char c11);

    PrimitiveSink putDouble(double d11);

    PrimitiveSink putFloat(float f11);

    PrimitiveSink putInt(int i11);

    PrimitiveSink putLong(long j11);

    PrimitiveSink putShort(short s11);

    PrimitiveSink putString(CharSequence charSequence, Charset charset);

    PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
