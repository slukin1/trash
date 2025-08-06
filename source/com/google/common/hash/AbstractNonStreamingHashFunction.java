package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;

@Immutable
abstract class AbstractNonStreamingHashFunction extends AbstractHashFunction {

    public final class BufferingHasher extends AbstractHasher {
        public final ExposedByteArrayOutputStream stream;

        public BufferingHasher(int i11) {
            this.stream = new ExposedByteArrayOutputStream(i11);
        }

        public HashCode hash() {
            return AbstractNonStreamingHashFunction.this.hashBytes(this.stream.byteArray(), 0, this.stream.length());
        }

        public Hasher putByte(byte b11) {
            this.stream.write(b11);
            return this;
        }

        public Hasher putBytes(byte[] bArr, int i11, int i12) {
            this.stream.write(bArr, i11, i12);
            return this;
        }

        public Hasher putBytes(ByteBuffer byteBuffer) {
            this.stream.write(byteBuffer);
            return this;
        }
    }

    public static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public ExposedByteArrayOutputStream(int i11) {
            super(i11);
        }

        public byte[] byteArray() {
            return this.buf;
        }

        public int length() {
            return this.count;
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            int i11 = this.count;
            int i12 = i11 + remaining;
            byte[] bArr = this.buf;
            if (i12 > bArr.length) {
                this.buf = Arrays.copyOf(bArr, i11 + remaining);
            }
            byteBuffer.get(this.buf, this.count, remaining);
            this.count += remaining;
        }
    }

    public HashCode hashBytes(ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).putBytes(byteBuffer).hash();
    }

    public abstract HashCode hashBytes(byte[] bArr, int i11, int i12);

    public HashCode hashInt(int i11) {
        return hashBytes(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i11).array());
    }

    public HashCode hashLong(long j11) {
        return hashBytes(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j11).array());
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return hashBytes(charSequence.toString().getBytes(charset));
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        ByteBuffer order = ByteBuffer.allocate(length * 2).order(ByteOrder.LITTLE_ENDIAN);
        for (int i11 = 0; i11 < length; i11++) {
            order.putChar(charSequence.charAt(i11));
        }
        return hashBytes(order.array());
    }

    public Hasher newHasher() {
        return newHasher(32);
    }

    public Hasher newHasher(int i11) {
        Preconditions.checkArgument(i11 >= 0);
        return new BufferingHasher(i11);
    }
}
