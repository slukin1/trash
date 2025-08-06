package org.bouncycastle.crypto.util;

import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;

public class ScryptConfig extends PBKDFConfig {
    private final int blockSize;
    private final int costParameter;
    private final int parallelizationParameter;
    private final int saltLength;

    public static class Builder {
        /* access modifiers changed from: private */
        public final int blockSize;
        /* access modifiers changed from: private */
        public final int costParameter;
        /* access modifiers changed from: private */
        public final int parallelizationParameter;
        /* access modifiers changed from: private */
        public int saltLength = 16;

        public Builder(int i11, int i12, int i13) {
            if (i11 <= 1 || !isPowerOf2(i11)) {
                throw new IllegalArgumentException("Cost parameter N must be > 1 and a power of 2");
            }
            this.costParameter = i11;
            this.blockSize = i12;
            this.parallelizationParameter = i13;
        }

        private static boolean isPowerOf2(int i11) {
            return (i11 & (i11 + -1)) == 0;
        }

        public ScryptConfig build() {
            return new ScryptConfig(this);
        }

        public Builder withSaltLength(int i11) {
            this.saltLength = i11;
            return this;
        }
    }

    private ScryptConfig(Builder builder) {
        super(MiscObjectIdentifiers.id_scrypt);
        this.costParameter = builder.costParameter;
        this.blockSize = builder.blockSize;
        this.parallelizationParameter = builder.parallelizationParameter;
        this.saltLength = builder.saltLength;
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public int getCostParameter() {
        return this.costParameter;
    }

    public int getParallelizationParameter() {
        return this.parallelizationParameter;
    }

    public int getSaltLength() {
        return this.saltLength;
    }
}
