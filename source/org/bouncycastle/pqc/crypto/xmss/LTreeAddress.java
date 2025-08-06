package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.pqc.crypto.xmss.XMSSAddress;
import org.bouncycastle.util.Pack;

final class LTreeAddress extends XMSSAddress {
    private static final int TYPE = 1;
    private final int lTreeAddress;
    private final int treeHeight;
    private final int treeIndex;

    public static class Builder extends XMSSAddress.Builder<Builder> {
        /* access modifiers changed from: private */
        public int lTreeAddress = 0;
        /* access modifiers changed from: private */
        public int treeHeight = 0;
        /* access modifiers changed from: private */
        public int treeIndex = 0;

        public Builder() {
            super(1);
        }

        public XMSSAddress build() {
            return new LTreeAddress(this);
        }

        public Builder getThis() {
            return this;
        }

        public Builder withLTreeAddress(int i11) {
            this.lTreeAddress = i11;
            return this;
        }

        public Builder withTreeHeight(int i11) {
            this.treeHeight = i11;
            return this;
        }

        public Builder withTreeIndex(int i11) {
            this.treeIndex = i11;
            return this;
        }
    }

    private LTreeAddress(Builder builder) {
        super(builder);
        this.lTreeAddress = builder.lTreeAddress;
        this.treeHeight = builder.treeHeight;
        this.treeIndex = builder.treeIndex;
    }

    public int getLTreeAddress() {
        return this.lTreeAddress;
    }

    public int getTreeHeight() {
        return this.treeHeight;
    }

    public int getTreeIndex() {
        return this.treeIndex;
    }

    public byte[] toByteArray() {
        byte[] byteArray = super.toByteArray();
        Pack.intToBigEndian(this.lTreeAddress, byteArray, 16);
        Pack.intToBigEndian(this.treeHeight, byteArray, 20);
        Pack.intToBigEndian(this.treeIndex, byteArray, 24);
        return byteArray;
    }
}
