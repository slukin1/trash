package org.bouncycastle.pqc.crypto.sphincsplus;

import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

class ADRS {
    public static final int FORS_ROOTS = 4;
    public static final int FORS_TREE = 3;
    public static final int OFFSET_CHAIN_ADDR = 24;
    public static final int OFFSET_HASH_ADDR = 28;
    public static final int OFFSET_KP_ADDR = 20;
    public static final int OFFSET_LAYER = 0;
    public static final int OFFSET_TREE = 4;
    public static final int OFFSET_TREE_HGT = 24;
    public static final int OFFSET_TREE_INDEX = 28;
    public static final int OFFSET_TYPE = 16;
    public static final int TREE = 2;
    public static final int WOTS_HASH = 0;
    public static final int WOTS_PK = 1;
    public final byte[] value;

    public ADRS() {
        this.value = new byte[32];
    }

    public ADRS(ADRS adrs) {
        byte[] bArr = new byte[32];
        this.value = bArr;
        byte[] bArr2 = adrs.value;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
    }

    public int getKeyPairAddress() {
        return Pack.bigEndianToInt(this.value, 20);
    }

    public int getLayerAddress() {
        return Pack.bigEndianToInt(this.value, 0);
    }

    public long getTreeAddress() {
        return Pack.bigEndianToLong(this.value, 8);
    }

    public int getTreeHeight() {
        return Pack.bigEndianToInt(this.value, 24);
    }

    public int getTreeIndex() {
        return Pack.bigEndianToInt(this.value, 28);
    }

    public int getType() {
        return Pack.bigEndianToInt(this.value, 16);
    }

    public void setChainAddress(int i11) {
        Pack.intToBigEndian(i11, this.value, 24);
    }

    public void setHashAddress(int i11) {
        Pack.intToBigEndian(i11, this.value, 28);
    }

    public void setKeyPairAddress(int i11) {
        Pack.intToBigEndian(i11, this.value, 20);
    }

    public void setLayerAddress(int i11) {
        Pack.intToBigEndian(i11, this.value, 0);
    }

    public void setTreeAddress(long j11) {
        Pack.longToBigEndian(j11, this.value, 8);
    }

    public void setTreeHeight(int i11) {
        Pack.intToBigEndian(i11, this.value, 24);
    }

    public void setTreeIndex(int i11) {
        Pack.intToBigEndian(i11, this.value, 28);
    }

    public void setType(int i11) {
        Pack.intToBigEndian(i11, this.value, 16);
        byte[] bArr = this.value;
        Arrays.fill(bArr, 20, bArr.length, (byte) 0);
    }
}
