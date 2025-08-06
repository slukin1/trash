package org.bouncycastle.pqc.crypto.sphincsplus;

class NodeEntry {
    public final int nodeHeight;
    public final byte[] nodeValue;

    public NodeEntry(byte[] bArr, int i11) {
        this.nodeValue = bArr;
        this.nodeHeight = i11;
    }
}
