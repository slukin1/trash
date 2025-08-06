package com.google.protobuf;

import java.nio.ByteBuffer;

@CheckReturnValue
abstract class AllocatedBuffer {
    public static AllocatedBuffer wrap(byte[] bArr) {
        return wrapNoCheck(bArr, 0, bArr.length);
    }

    private static AllocatedBuffer wrapNoCheck(final byte[] bArr, final int i11, final int i12) {
        return new AllocatedBuffer() {
            private int position;

            public byte[] array() {
                return bArr;
            }

            public int arrayOffset() {
                return i11;
            }

            public boolean hasArray() {
                return true;
            }

            public boolean hasNioBuffer() {
                return false;
            }

            public int limit() {
                return i12;
            }

            public ByteBuffer nioBuffer() {
                throw new UnsupportedOperationException();
            }

            public int position() {
                return this.position;
            }

            public int remaining() {
                return i12 - this.position;
            }

            public AllocatedBuffer position(int i11) {
                if (i11 < 0 || i11 > i12) {
                    throw new IllegalArgumentException("Invalid position: " + i11);
                }
                this.position = i11;
                return this;
            }
        };
    }

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    public abstract int limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    @CanIgnoreReturnValue
    public abstract AllocatedBuffer position(int i11);

    public abstract int remaining();

    public static AllocatedBuffer wrap(byte[] bArr, int i11, int i12) {
        if (i11 >= 0 && i12 >= 0 && i11 + i12 <= bArr.length) {
            return wrapNoCheck(bArr, i11, i12);
        }
        throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)}));
    }

    public static AllocatedBuffer wrap(final ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        return new AllocatedBuffer() {
            public byte[] array() {
                return byteBuffer.array();
            }

            public int arrayOffset() {
                return byteBuffer.arrayOffset();
            }

            public boolean hasArray() {
                return byteBuffer.hasArray();
            }

            public boolean hasNioBuffer() {
                return true;
            }

            public int limit() {
                return byteBuffer.limit();
            }

            public ByteBuffer nioBuffer() {
                return byteBuffer;
            }

            public int position() {
                return byteBuffer.position();
            }

            public int remaining() {
                return byteBuffer.remaining();
            }

            public AllocatedBuffer position(int i11) {
                ByteBuffer byteBuffer = (ByteBuffer) byteBuffer.position(i11);
                return this;
            }
        };
    }
}
