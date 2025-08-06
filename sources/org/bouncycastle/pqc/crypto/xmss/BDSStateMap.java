package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.pqc.crypto.xmss.OTSHashAddress;
import org.bouncycastle.util.Integers;

public class BDSStateMap implements Serializable {
    private static final long serialVersionUID = -3464451825208522308L;
    private final Map<Integer, BDS> bdsState = new TreeMap();
    private transient long maxIndex;

    public BDSStateMap(long j11) {
        this.maxIndex = j11;
    }

    public BDSStateMap(BDSStateMap bDSStateMap, long j11) {
        for (Integer next : bDSStateMap.bdsState.keySet()) {
            this.bdsState.put(next, new BDS(bDSStateMap.bdsState.get(next)));
        }
        this.maxIndex = j11;
    }

    public BDSStateMap(XMSSMTParameters xMSSMTParameters, long j11, byte[] bArr, byte[] bArr2) {
        this.maxIndex = (1 << xMSSMTParameters.getHeight()) - 1;
        for (long j12 = 0; j12 < j11; j12++) {
            updateState(xMSSMTParameters, j12, bArr, bArr2);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.maxIndex = objectInputStream.available() != 0 ? objectInputStream.readLong() : 0;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(this.maxIndex);
    }

    public BDS get(int i11) {
        return this.bdsState.get(Integers.valueOf(i11));
    }

    public long getMaxIndex() {
        return this.maxIndex;
    }

    public boolean isEmpty() {
        return this.bdsState.isEmpty();
    }

    public void put(int i11, BDS bds) {
        this.bdsState.put(Integers.valueOf(i11), bds);
    }

    public BDS update(int i11, byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        return this.bdsState.put(Integers.valueOf(i11), this.bdsState.get(Integers.valueOf(i11)).getNextState(bArr, bArr2, oTSHashAddress));
    }

    public void updateState(XMSSMTParameters xMSSMTParameters, long j11, byte[] bArr, byte[] bArr2) {
        long j12 = j11;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        XMSSParameters xMSSParameters = xMSSMTParameters.getXMSSParameters();
        int height = xMSSParameters.getHeight();
        long treeIndex = XMSSUtil.getTreeIndex(j12, height);
        int leafIndex = XMSSUtil.getLeafIndex(j12, height);
        OTSHashAddress oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withTreeAddress(treeIndex)).withOTSAddress(leafIndex).build();
        int i11 = (1 << height) - 1;
        if (leafIndex < i11) {
            if (get(0) == null || leafIndex == 0) {
                put(0, new BDS(xMSSParameters, bArr3, bArr4, oTSHashAddress));
            }
            update(0, bArr3, bArr4, oTSHashAddress);
        }
        for (int i12 = 1; i12 < xMSSMTParameters.getLayers(); i12++) {
            int leafIndex2 = XMSSUtil.getLeafIndex(treeIndex, height);
            treeIndex = XMSSUtil.getTreeIndex(treeIndex, height);
            OTSHashAddress oTSHashAddress2 = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(i12)).withTreeAddress(treeIndex)).withOTSAddress(leafIndex2).build();
            if (this.bdsState.get(Integer.valueOf(i12)) == null || XMSSUtil.isNewBDSInitNeeded(j12, height, i12)) {
                this.bdsState.put(Integer.valueOf(i12), new BDS(xMSSParameters, bArr3, bArr4, oTSHashAddress2));
            }
            if (leafIndex2 < i11 && XMSSUtil.isNewAuthenticationPathNeeded(j12, height, i12)) {
                update(i12, bArr3, bArr4, oTSHashAddress2);
            }
        }
    }

    public BDSStateMap withWOTSDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        BDSStateMap bDSStateMap = new BDSStateMap(this.maxIndex);
        for (Integer next : this.bdsState.keySet()) {
            bDSStateMap.bdsState.put(next, this.bdsState.get(next).withWOTSDigest(aSN1ObjectIdentifier));
        }
        return bDSStateMap;
    }
}
