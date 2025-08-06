package org.bouncycastle.pqc.crypto.sphincsplus;

class IndexedDigest {
    public final byte[] digest;
    public final int idx_leaf;
    public final long idx_tree;

    public IndexedDigest(long j11, int i11, byte[] bArr) {
        this.idx_tree = j11;
        this.idx_leaf = i11;
        this.digest = bArr;
    }
}
