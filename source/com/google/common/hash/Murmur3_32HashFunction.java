package com.google.common.hash;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

@Immutable
final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final int CHUNK_SIZE = 4;
    public static final HashFunction GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.GOOD_FAST_HASH_SEED);
    public static final HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0);
    private static final long serialVersionUID = 0;
    private final int seed;

    @CanIgnoreReturnValue
    public static final class Murmur3_32Hasher extends AbstractHasher {
        private long buffer;

        /* renamed from: h1  reason: collision with root package name */
        private int f66925h1;
        private boolean isDone = false;
        private int length = 0;
        private int shift;

        public Murmur3_32Hasher(int i11) {
            this.f66925h1 = i11;
        }

        private void update(int i11, long j11) {
            long j12 = this.buffer;
            int i12 = this.shift;
            long j13 = ((j11 & 4294967295L) << i12) | j12;
            this.buffer = j13;
            int i13 = i12 + (i11 * 8);
            this.shift = i13;
            this.length += i11;
            if (i13 >= 32) {
                this.f66925h1 = Murmur3_32HashFunction.mixH1(this.f66925h1, Murmur3_32HashFunction.mixK1((int) j13));
                this.buffer >>>= 32;
                this.shift -= 32;
            }
        }

        public HashCode hash() {
            Preconditions.checkState(!this.isDone);
            this.isDone = true;
            int access$000 = this.f66925h1 ^ Murmur3_32HashFunction.mixK1((int) this.buffer);
            this.f66925h1 = access$000;
            return Murmur3_32HashFunction.fmix(access$000, this.length);
        }

        public Hasher putByte(byte b11) {
            update(1, (long) (b11 & 255));
            return this;
        }

        public Hasher putChar(char c11) {
            update(2, (long) c11);
            return this;
        }

        public Hasher putInt(int i11) {
            update(4, (long) i11);
            return this;
        }

        public Hasher putLong(long j11) {
            update(4, (long) ((int) j11));
            update(4, j11 >>> 32);
            return this;
        }

        public Hasher putString(CharSequence charSequence, Charset charset) {
            if (!Charsets.UTF_8.equals(charset)) {
                return super.putString(charSequence, charset);
            }
            int length2 = charSequence.length();
            int i11 = 0;
            while (true) {
                int i12 = i11 + 4;
                if (i12 > length2) {
                    break;
                }
                char charAt = charSequence.charAt(i11);
                char charAt2 = charSequence.charAt(i11 + 1);
                char charAt3 = charSequence.charAt(i11 + 2);
                char charAt4 = charSequence.charAt(i11 + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                update(4, (long) ((charAt2 << 8) | charAt | (charAt3 << 16) | (charAt4 << 24)));
                i11 = i12;
            }
            while (i11 < length2) {
                char charAt5 = charSequence.charAt(i11);
                if (charAt5 < 128) {
                    update(1, (long) charAt5);
                } else if (charAt5 < 2048) {
                    update(2, Murmur3_32HashFunction.charToTwoUtf8Bytes(charAt5));
                } else if (charAt5 < 55296 || charAt5 > 57343) {
                    update(3, Murmur3_32HashFunction.charToThreeUtf8Bytes(charAt5));
                } else {
                    int codePointAt = Character.codePointAt(charSequence, i11);
                    if (codePointAt == charAt5) {
                        putBytes(charSequence.subSequence(i11, length2).toString().getBytes(charset));
                        return this;
                    }
                    i11++;
                    update(4, Murmur3_32HashFunction.codePointToFourUtf8Bytes(codePointAt));
                }
                i11++;
            }
            return this;
        }

        public Hasher putBytes(byte[] bArr, int i11, int i12) {
            Preconditions.checkPositionIndexes(i11, i11 + i12, bArr.length);
            int i13 = 0;
            while (true) {
                int i14 = i13 + 4;
                if (i14 > i12) {
                    break;
                }
                update(4, (long) Murmur3_32HashFunction.getIntLittleEndian(bArr, i13 + i11));
                i13 = i14;
            }
            while (i13 < i12) {
                putByte(bArr[i11 + i13]);
                i13++;
            }
            return this;
        }

        public Hasher putBytes(ByteBuffer byteBuffer) {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                putInt(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                putByte(byteBuffer.get());
            }
            byteBuffer.order(order);
            return this;
        }
    }

    public Murmur3_32HashFunction(int i11) {
        this.seed = i11;
    }

    /* access modifiers changed from: private */
    public static long charToThreeUtf8Bytes(char c11) {
        return (long) ((((c11 & '?') | 128) << 16) | (((c11 >>> 12) | TXVodDownloadDataSource.QUALITY_480P) & 255) | ((((c11 >>> 6) & 63) | 128) << 8));
    }

    /* access modifiers changed from: private */
    public static long charToTwoUtf8Bytes(char c11) {
        return (long) ((((c11 & '?') | 128) << 8) | (((c11 >>> 6) | 960) & 255));
    }

    /* access modifiers changed from: private */
    public static long codePointToFourUtf8Bytes(int i11) {
        return ((((long) (i11 >>> 18)) | 240) & 255) | ((((long) ((i11 >>> 12) & 63)) | 128) << 8) | ((((long) ((i11 >>> 6) & 63)) | 128) << 16) | ((((long) (i11 & 63)) | 128) << 24);
    }

    /* access modifiers changed from: private */
    public static HashCode fmix(int i11, int i12) {
        int i13 = i11 ^ i12;
        int i14 = (i13 ^ (i13 >>> 16)) * -2048144789;
        int i15 = (i14 ^ (i14 >>> 13)) * -1028477387;
        return HashCode.fromInt(i15 ^ (i15 >>> 16));
    }

    /* access modifiers changed from: private */
    public static int getIntLittleEndian(byte[] bArr, int i11) {
        return Ints.fromBytes(bArr[i11 + 3], bArr[i11 + 2], bArr[i11 + 1], bArr[i11]);
    }

    /* access modifiers changed from: private */
    public static int mixH1(int i11, int i12) {
        return (Integer.rotateLeft(i11 ^ i12, 13) * 5) - 430675100;
    }

    /* access modifiers changed from: private */
    public static int mixK1(int i11) {
        return Integer.rotateLeft(i11 * C1, 15) * C2;
    }

    public int bits() {
        return 32;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Murmur3_32HashFunction) || this.seed != ((Murmur3_32HashFunction) obj).seed) {
            return false;
        }
        return true;
    }

    public HashCode hashBytes(byte[] bArr, int i11, int i12) {
        Preconditions.checkPositionIndexes(i11, i11 + i12, bArr.length);
        int i13 = this.seed;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            int i16 = i15 + 4;
            if (i16 > i12) {
                break;
            }
            i13 = mixH1(i13, mixK1(getIntLittleEndian(bArr, i15 + i11)));
            i15 = i16;
        }
        int i17 = i15;
        int i18 = 0;
        while (i17 < i12) {
            i14 ^= UnsignedBytes.toInt(bArr[i11 + i17]) << i18;
            i17++;
            i18 += 8;
        }
        return fmix(mixK1(i14) ^ i13, i12);
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.seed;
    }

    public HashCode hashInt(int i11) {
        return fmix(mixH1(this.seed, mixK1(i11)), 4);
    }

    public HashCode hashLong(long j11) {
        return fmix(mixH1(mixH1(this.seed, mixK1((int) j11)), mixK1((int) (j11 >>> 32))), 8);
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        int i11;
        if (!Charsets.UTF_8.equals(charset)) {
            return hashBytes(charSequence.toString().getBytes(charset));
        }
        int length = charSequence.length();
        int i12 = this.seed;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            int i16 = i14 + 4;
            if (i16 > length) {
                break;
            }
            char charAt = charSequence.charAt(i14);
            char charAt2 = charSequence.charAt(i14 + 1);
            char charAt3 = charSequence.charAt(i14 + 2);
            char charAt4 = charSequence.charAt(i14 + 3);
            if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                break;
            }
            i12 = mixH1(i12, mixK1((charAt2 << 8) | charAt | (charAt3 << 16) | (charAt4 << 24)));
            i15 = i11 + 4;
            i14 = i16;
        }
        long j11 = 0;
        while (i14 < length) {
            char charAt5 = charSequence.charAt(i14);
            if (charAt5 < 128) {
                j11 |= ((long) charAt5) << i13;
                i13 += 8;
                i11++;
            } else if (charAt5 < 2048) {
                j11 |= charToTwoUtf8Bytes(charAt5) << i13;
                i13 += 16;
                i11 += 2;
            } else if (charAt5 < 55296 || charAt5 > 57343) {
                j11 |= charToThreeUtf8Bytes(charAt5) << i13;
                i13 += 24;
                i11 += 3;
            } else {
                int codePointAt = Character.codePointAt(charSequence, i14);
                if (codePointAt == charAt5) {
                    return hashBytes(charSequence.toString().getBytes(charset));
                }
                i14++;
                j11 |= codePointToFourUtf8Bytes(codePointAt) << i13;
                i11 += 4;
            }
            if (i13 >= 32) {
                i12 = mixH1(i12, mixK1((int) j11));
                j11 >>>= 32;
                i13 -= 32;
            }
            i14++;
        }
        return fmix(mixK1((int) j11) ^ i12, i11);
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int i11 = this.seed;
        for (int i12 = 1; i12 < charSequence.length(); i12 += 2) {
            i11 = mixH1(i11, mixK1(charSequence.charAt(i12 - 1) | (charSequence.charAt(i12) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i11 ^= mixK1(charSequence.charAt(charSequence.length() - 1));
        }
        return fmix(i11, charSequence.length() * 2);
    }

    public Hasher newHasher() {
        return new Murmur3_32Hasher(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.seed + ")";
    }
}
