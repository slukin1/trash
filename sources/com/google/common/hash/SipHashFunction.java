package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;

@Immutable
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    public static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: c  reason: collision with root package name */
    private final int f66926c;

    /* renamed from: d  reason: collision with root package name */
    private final int f66927d;

    /* renamed from: k0  reason: collision with root package name */
    private final long f66928k0;

    /* renamed from: k1  reason: collision with root package name */
    private final long f66929k1;

    public static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* renamed from: b  reason: collision with root package name */
        private long f66930b = 0;

        /* renamed from: c  reason: collision with root package name */
        private final int f66931c;

        /* renamed from: d  reason: collision with root package name */
        private final int f66932d;
        private long finalM = 0;

        /* renamed from: v0  reason: collision with root package name */
        private long f66933v0 = 8317987319222330741L;

        /* renamed from: v1  reason: collision with root package name */
        private long f66934v1 = 7237128888997146477L;

        /* renamed from: v2  reason: collision with root package name */
        private long f66935v2 = 7816392313619706465L;

        /* renamed from: v3  reason: collision with root package name */
        private long f66936v3 = 8387220255154660723L;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SipHasher(int i11, int i12, long j11, long j12) {
            super(8);
            this.f66931c = i11;
            this.f66932d = i12;
            this.f66933v0 = 8317987319222330741L ^ j11;
            this.f66934v1 = 7237128888997146477L ^ j12;
            this.f66935v2 = 7816392313619706465L ^ j11;
            this.f66936v3 = 8387220255154660723L ^ j12;
        }

        private void processM(long j11) {
            this.f66936v3 ^= j11;
            sipRound(this.f66931c);
            this.f66933v0 = j11 ^ this.f66933v0;
        }

        private void sipRound(int i11) {
            for (int i12 = 0; i12 < i11; i12++) {
                long j11 = this.f66933v0;
                long j12 = this.f66934v1;
                this.f66933v0 = j11 + j12;
                this.f66935v2 += this.f66936v3;
                this.f66934v1 = Long.rotateLeft(j12, 13);
                long rotateLeft = Long.rotateLeft(this.f66936v3, 16);
                this.f66936v3 = rotateLeft;
                long j13 = this.f66934v1;
                long j14 = this.f66933v0;
                this.f66934v1 = j13 ^ j14;
                this.f66936v3 = rotateLeft ^ this.f66935v2;
                long rotateLeft2 = Long.rotateLeft(j14, 32);
                this.f66933v0 = rotateLeft2;
                long j15 = this.f66935v2;
                long j16 = this.f66934v1;
                this.f66935v2 = j15 + j16;
                this.f66933v0 = rotateLeft2 + this.f66936v3;
                this.f66934v1 = Long.rotateLeft(j16, 17);
                long rotateLeft3 = Long.rotateLeft(this.f66936v3, 21);
                this.f66936v3 = rotateLeft3;
                long j17 = this.f66934v1;
                long j18 = this.f66935v2;
                this.f66934v1 = j17 ^ j18;
                this.f66936v3 = rotateLeft3 ^ this.f66933v0;
                this.f66935v2 = Long.rotateLeft(j18, 32);
            }
        }

        public HashCode makeHash() {
            long j11 = this.finalM ^ (this.f66930b << 56);
            this.finalM = j11;
            processM(j11);
            this.f66935v2 ^= 255;
            sipRound(this.f66932d);
            return HashCode.fromLong(((this.f66933v0 ^ this.f66934v1) ^ this.f66935v2) ^ this.f66936v3);
        }

        public void process(ByteBuffer byteBuffer) {
            this.f66930b += 8;
            processM(byteBuffer.getLong());
        }

        public void processRemaining(ByteBuffer byteBuffer) {
            this.f66930b += (long) byteBuffer.remaining();
            int i11 = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (((long) byteBuffer.get()) & 255) << i11;
                i11 += 8;
            }
        }
    }

    public SipHashFunction(int i11, int i12, long j11, long j12) {
        boolean z11 = true;
        Preconditions.checkArgument(i11 > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i11);
        Preconditions.checkArgument(i12 <= 0 ? false : z11, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i12);
        this.f66926c = i11;
        this.f66927d = i12;
        this.f66928k0 = j11;
        this.f66929k1 = j12;
    }

    public int bits() {
        return 64;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        if (this.f66926c == sipHashFunction.f66926c && this.f66927d == sipHashFunction.f66927d && this.f66928k0 == sipHashFunction.f66928k0 && this.f66929k1 == sipHashFunction.f66929k1) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((long) ((SipHashFunction.class.hashCode() ^ this.f66926c) ^ this.f66927d)) ^ this.f66928k0) ^ this.f66929k1);
    }

    public Hasher newHasher() {
        return new SipHasher(this.f66926c, this.f66927d, this.f66928k0, this.f66929k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f66926c + "" + this.f66927d + "(" + this.f66928k0 + ", " + this.f66929k1 + ")";
    }
}
