package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@Immutable
abstract class AbstractHashFunction implements HashFunction {
    public HashCode hashBytes(byte[] bArr) {
        return hashBytes(bArr, 0, bArr.length);
    }

    public HashCode hashInt(int i11) {
        return newHasher(4).putInt(i11).hash();
    }

    public HashCode hashLong(long j11) {
        return newHasher(8).putLong(j11).hash();
    }

    public <T> HashCode hashObject(T t11, Funnel<? super T> funnel) {
        return newHasher().putObject(t11, funnel).hash();
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return newHasher().putString(charSequence, charset).hash();
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        return newHasher(charSequence.length() * 2).putUnencodedChars(charSequence).hash();
    }

    public Hasher newHasher(int i11) {
        Preconditions.checkArgument(i11 >= 0, "expectedInputSize must be >= 0 but was %s", i11);
        return newHasher();
    }

    public HashCode hashBytes(byte[] bArr, int i11, int i12) {
        Preconditions.checkPositionIndexes(i11, i11 + i12, bArr.length);
        return newHasher(i12).putBytes(bArr, i11, i12).hash();
    }

    public HashCode hashBytes(ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).putBytes(byteBuffer).hash();
    }
}
