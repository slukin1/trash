package org.bouncycastle.crypto.prng;

public class ThreadedSeedGenerator {

    public class SeedGenerator implements Runnable {
        private volatile int counter;
        private volatile boolean stop;

        private SeedGenerator() {
            this.counter = 0;
            this.stop = false;
        }

        public byte[] generateSeed(int i11, boolean z11) {
            Thread thread = new Thread(this);
            byte[] bArr = new byte[i11];
            this.counter = 0;
            this.stop = false;
            thread.start();
            if (!z11) {
                i11 *= 8;
            }
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                while (this.counter == i12) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException unused) {
                    }
                }
                i12 = this.counter;
                if (z11) {
                    bArr[i13] = (byte) (i12 & 255);
                } else {
                    int i14 = i13 / 8;
                    bArr[i14] = (byte) ((bArr[i14] << 1) | (i12 & 1));
                }
            }
            this.stop = true;
            return bArr;
        }

        public void run() {
            while (!this.stop) {
                this.counter++;
            }
        }
    }

    public byte[] generateSeed(int i11, boolean z11) {
        return new SeedGenerator().generateSeed(i11, z11);
    }
}
