package org.bouncycastle.crypto.prng;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;

public class DigestRandomGenerator implements RandomGenerator {
    private static long CYCLE_COUNT = 10;
    private Digest digest;
    private byte[] seed;
    private long seedCounter = 1;
    private byte[] state;
    private long stateCounter;

    public DigestRandomGenerator(Digest digest2) {
        this.digest = digest2;
        this.seed = new byte[digest2.getDigestSize()];
        this.state = new byte[digest2.getDigestSize()];
        this.stateCounter = 1;
    }

    private void cycleSeed() {
        digestUpdate(this.seed);
        long j11 = this.seedCounter;
        this.seedCounter = 1 + j11;
        digestAddCounter(j11);
        digestDoFinal(this.seed);
    }

    private void digestAddCounter(long j11) {
        for (int i11 = 0; i11 != 8; i11++) {
            this.digest.update((byte) ((int) j11));
            j11 >>>= 8;
        }
    }

    private void digestDoFinal(byte[] bArr) {
        this.digest.doFinal(bArr, 0);
    }

    private void digestUpdate(byte[] bArr) {
        this.digest.update(bArr, 0, bArr.length);
    }

    private void generateState() {
        long j11 = this.stateCounter;
        this.stateCounter = 1 + j11;
        digestAddCounter(j11);
        digestUpdate(this.state);
        digestUpdate(this.seed);
        digestDoFinal(this.state);
        if (this.stateCounter % CYCLE_COUNT == 0) {
            cycleSeed();
        }
    }

    public void addSeedMaterial(long j11) {
        synchronized (this) {
            digestAddCounter(j11);
            digestUpdate(this.seed);
            digestDoFinal(this.seed);
        }
    }

    public void addSeedMaterial(byte[] bArr) {
        synchronized (this) {
            if (!Arrays.isNullOrEmpty(bArr)) {
                digestUpdate(bArr);
            }
            digestUpdate(this.seed);
            digestDoFinal(this.seed);
        }
    }

    public void nextBytes(byte[] bArr) {
        nextBytes(bArr, 0, bArr.length);
    }

    public void nextBytes(byte[] bArr, int i11, int i12) {
        synchronized (this) {
            generateState();
            int i13 = i12 + i11;
            int i14 = 0;
            while (i11 != i13) {
                if (i14 == this.state.length) {
                    generateState();
                    i14 = 0;
                }
                bArr[i11] = this.state[i14];
                i11++;
                i14++;
            }
        }
    }
}
