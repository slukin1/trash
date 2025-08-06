package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@CanIgnoreReturnValue
@Beta
public interface Hasher extends PrimitiveSink {
    HashCode hash();

    @Deprecated
    int hashCode();

    Hasher putBoolean(boolean z11);

    Hasher putByte(byte b11);

    Hasher putBytes(ByteBuffer byteBuffer);

    Hasher putBytes(byte[] bArr);

    Hasher putBytes(byte[] bArr, int i11, int i12);

    Hasher putChar(char c11);

    Hasher putDouble(double d11);

    Hasher putFloat(float f11);

    Hasher putInt(int i11);

    Hasher putLong(long j11);

    <T> Hasher putObject(T t11, Funnel<? super T> funnel);

    Hasher putShort(short s11);

    Hasher putString(CharSequence charSequence, Charset charset);

    Hasher putUnencodedChars(CharSequence charSequence);
}
