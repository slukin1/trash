package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.util.Pack;

public abstract class XMSSAddress {
    private final int keyAndMask;
    private final int layerAddress;
    private final long treeAddress;
    private final int type;

    public static abstract class Builder<T extends Builder> {
        /* access modifiers changed from: private */
        public int keyAndMask = 0;
        /* access modifiers changed from: private */
        public int layerAddress = 0;
        /* access modifiers changed from: private */
        public long treeAddress = 0;
        /* access modifiers changed from: private */
        public final int type;

        public Builder(int i11) {
            this.type = i11;
        }

        public abstract XMSSAddress build();

        public abstract T getThis();

        public T withKeyAndMask(int i11) {
            this.keyAndMask = i11;
            return getThis();
        }

        public T withLayerAddress(int i11) {
            this.layerAddress = i11;
            return getThis();
        }

        public T withTreeAddress(long j11) {
            this.treeAddress = j11;
            return getThis();
        }
    }

    public XMSSAddress(Builder builder) {
        this.layerAddress = builder.layerAddress;
        this.treeAddress = builder.treeAddress;
        this.type = builder.type;
        this.keyAndMask = builder.keyAndMask;
    }

    public final int getKeyAndMask() {
        return this.keyAndMask;
    }

    public final int getLayerAddress() {
        return this.layerAddress;
    }

    public final long getTreeAddress() {
        return this.treeAddress;
    }

    public final int getType() {
        return this.type;
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[32];
        Pack.intToBigEndian(this.layerAddress, bArr, 0);
        Pack.longToBigEndian(this.treeAddress, bArr, 4);
        Pack.intToBigEndian(this.type, bArr, 12);
        Pack.intToBigEndian(this.keyAndMask, bArr, 28);
        return bArr;
    }
}
