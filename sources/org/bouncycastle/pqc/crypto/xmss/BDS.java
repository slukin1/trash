package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.TreeMap;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.pqc.crypto.xmss.HashTreeAddress;
import org.bouncycastle.pqc.crypto.xmss.LTreeAddress;
import org.bouncycastle.pqc.crypto.xmss.OTSHashAddress;

public final class BDS implements Serializable {
    private static final long serialVersionUID = 1;
    private List<XMSSNode> authenticationPath;
    private int index;

    /* renamed from: k  reason: collision with root package name */
    private int f59614k;
    private Map<Integer, XMSSNode> keep;
    private transient int maxIndex;
    private Map<Integer, LinkedList<XMSSNode>> retain;
    private XMSSNode root;
    private Stack<XMSSNode> stack;
    private final List<BDSTreeHash> treeHashInstances;
    private final int treeHeight;
    private boolean used;
    private transient WOTSPlus wotsPlus;

    public BDS(BDS bds) {
        this.wotsPlus = new WOTSPlus(bds.wotsPlus.getParams());
        this.treeHeight = bds.treeHeight;
        this.f59614k = bds.f59614k;
        this.root = bds.root;
        ArrayList arrayList = new ArrayList();
        this.authenticationPath = arrayList;
        arrayList.addAll(bds.authenticationPath);
        this.retain = new TreeMap();
        for (Integer next : bds.retain.keySet()) {
            this.retain.put(next, (LinkedList) bds.retain.get(next).clone());
        }
        Stack<XMSSNode> stack2 = new Stack<>();
        this.stack = stack2;
        stack2.addAll(bds.stack);
        this.treeHashInstances = new ArrayList();
        for (BDSTreeHash clone : bds.treeHashInstances) {
            this.treeHashInstances.add(clone.clone());
        }
        this.keep = new TreeMap(bds.keep);
        this.index = bds.index;
        this.maxIndex = bds.maxIndex;
        this.used = bds.used;
    }

    private BDS(BDS bds, int i11, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.wotsPlus = new WOTSPlus(new WOTSPlusParameters(aSN1ObjectIdentifier));
        this.treeHeight = bds.treeHeight;
        this.f59614k = bds.f59614k;
        this.root = bds.root;
        ArrayList arrayList = new ArrayList();
        this.authenticationPath = arrayList;
        arrayList.addAll(bds.authenticationPath);
        this.retain = new TreeMap();
        for (Integer next : bds.retain.keySet()) {
            this.retain.put(next, (LinkedList) bds.retain.get(next).clone());
        }
        Stack<XMSSNode> stack2 = new Stack<>();
        this.stack = stack2;
        stack2.addAll(bds.stack);
        this.treeHashInstances = new ArrayList();
        for (BDSTreeHash clone : bds.treeHashInstances) {
            this.treeHashInstances.add(clone.clone());
        }
        this.keep = new TreeMap(bds.keep);
        this.index = bds.index;
        this.maxIndex = i11;
        this.used = bds.used;
        validate();
    }

    private BDS(BDS bds, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.wotsPlus = new WOTSPlus(new WOTSPlusParameters(aSN1ObjectIdentifier));
        this.treeHeight = bds.treeHeight;
        this.f59614k = bds.f59614k;
        this.root = bds.root;
        ArrayList arrayList = new ArrayList();
        this.authenticationPath = arrayList;
        arrayList.addAll(bds.authenticationPath);
        this.retain = new TreeMap();
        for (Integer next : bds.retain.keySet()) {
            this.retain.put(next, (LinkedList) bds.retain.get(next).clone());
        }
        Stack<XMSSNode> stack2 = new Stack<>();
        this.stack = stack2;
        stack2.addAll(bds.stack);
        this.treeHashInstances = new ArrayList();
        for (BDSTreeHash clone : bds.treeHashInstances) {
            this.treeHashInstances.add(clone.clone());
        }
        this.keep = new TreeMap(bds.keep);
        this.index = bds.index;
        this.maxIndex = bds.maxIndex;
        this.used = bds.used;
        validate();
    }

    private BDS(BDS bds, byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        this.wotsPlus = new WOTSPlus(bds.wotsPlus.getParams());
        this.treeHeight = bds.treeHeight;
        this.f59614k = bds.f59614k;
        this.root = bds.root;
        ArrayList arrayList = new ArrayList();
        this.authenticationPath = arrayList;
        arrayList.addAll(bds.authenticationPath);
        this.retain = new TreeMap();
        for (Integer next : bds.retain.keySet()) {
            this.retain.put(next, (LinkedList) bds.retain.get(next).clone());
        }
        Stack<XMSSNode> stack2 = new Stack<>();
        this.stack = stack2;
        stack2.addAll(bds.stack);
        this.treeHashInstances = new ArrayList();
        for (BDSTreeHash clone : bds.treeHashInstances) {
            this.treeHashInstances.add(clone.clone());
        }
        this.keep = new TreeMap(bds.keep);
        this.index = bds.index;
        this.maxIndex = bds.maxIndex;
        this.used = false;
        nextAuthenticationPath(bArr, bArr2, oTSHashAddress);
    }

    private BDS(WOTSPlus wOTSPlus, int i11, int i12, int i13) {
        this.wotsPlus = wOTSPlus;
        this.treeHeight = i11;
        this.maxIndex = i13;
        this.f59614k = i12;
        if (i12 <= i11 && i12 >= 2) {
            int i14 = i11 - i12;
            if (i14 % 2 == 0) {
                this.authenticationPath = new ArrayList();
                this.retain = new TreeMap();
                this.stack = new Stack<>();
                this.treeHashInstances = new ArrayList();
                for (int i15 = 0; i15 < i14; i15++) {
                    this.treeHashInstances.add(new BDSTreeHash(i15));
                }
                this.keep = new TreeMap();
                this.index = 0;
                this.used = false;
                return;
            }
        }
        throw new IllegalArgumentException("illegal value for BDS parameter k");
    }

    public BDS(XMSSParameters xMSSParameters, int i11, int i12) {
        this(xMSSParameters.getWOTSPlus(), xMSSParameters.getHeight(), xMSSParameters.getK(), i12);
        this.maxIndex = i11;
        this.index = i12;
        this.used = true;
    }

    public BDS(XMSSParameters xMSSParameters, byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        this(xMSSParameters.getWOTSPlus(), xMSSParameters.getHeight(), xMSSParameters.getK(), (1 << xMSSParameters.getHeight()) - 1);
        initialize(bArr, bArr2, oTSHashAddress);
    }

    public BDS(XMSSParameters xMSSParameters, byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress, int i11) {
        this(xMSSParameters.getWOTSPlus(), xMSSParameters.getHeight(), xMSSParameters.getK(), (1 << xMSSParameters.getHeight()) - 1);
        initialize(bArr, bArr2, oTSHashAddress);
        while (this.index < i11) {
            nextAuthenticationPath(bArr, bArr2, oTSHashAddress);
            this.used = false;
        }
    }

    private BDSTreeHash getBDSTreeHashInstanceForUpdate() {
        BDSTreeHash bDSTreeHash = null;
        for (BDSTreeHash next : this.treeHashInstances) {
            if (!next.isFinished() && next.isInitialized()) {
                if (bDSTreeHash == null || next.getHeight() < bDSTreeHash.getHeight() || (next.getHeight() == bDSTreeHash.getHeight() && next.getIndexLeaf() < bDSTreeHash.getIndexLeaf())) {
                    bDSTreeHash = next;
                }
            }
        }
        return bDSTreeHash;
    }

    private void initialize(byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        Objects.requireNonNull(oTSHashAddress, "otsHashAddress == null");
        LTreeAddress lTreeAddress = (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).build();
        HashTreeAddress hashTreeAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).build();
        for (int i11 = 0; i11 < (1 << this.treeHeight); i11++) {
            oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(i11).withChainAddress(oTSHashAddress.getChainAddress()).withHashAddress(oTSHashAddress.getHashAddress()).withKeyAndMask(oTSHashAddress.getKeyAndMask())).build();
            WOTSPlus wOTSPlus = this.wotsPlus;
            wOTSPlus.importKeys(wOTSPlus.getWOTSPlusSecretKey(bArr2, oTSHashAddress), bArr);
            WOTSPlusPublicKeyParameters publicKey = this.wotsPlus.getPublicKey(oTSHashAddress);
            lTreeAddress = (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(lTreeAddress.getLayerAddress())).withTreeAddress(lTreeAddress.getTreeAddress())).withLTreeAddress(i11).withTreeHeight(lTreeAddress.getTreeHeight()).withTreeIndex(lTreeAddress.getTreeIndex()).withKeyAndMask(lTreeAddress.getKeyAndMask())).build();
            XMSSNode lTree = XMSSNodeUtil.lTree(this.wotsPlus, publicKey, lTreeAddress);
            hashTreeAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress.getLayerAddress())).withTreeAddress(hashTreeAddress.getTreeAddress())).withTreeIndex(i11).withKeyAndMask(hashTreeAddress.getKeyAndMask())).build();
            while (!this.stack.isEmpty() && this.stack.peek().getHeight() == lTree.getHeight()) {
                int height = i11 / (1 << lTree.getHeight());
                if (height == 1) {
                    this.authenticationPath.add(lTree);
                }
                if (height == 3 && lTree.getHeight() < this.treeHeight - this.f59614k) {
                    this.treeHashInstances.get(lTree.getHeight()).setNode(lTree);
                }
                if (height >= 3 && (height & 1) == 1 && lTree.getHeight() >= this.treeHeight - this.f59614k && lTree.getHeight() <= this.treeHeight - 2) {
                    if (this.retain.get(Integer.valueOf(lTree.getHeight())) == null) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(lTree);
                        this.retain.put(Integer.valueOf(lTree.getHeight()), linkedList);
                    } else {
                        this.retain.get(Integer.valueOf(lTree.getHeight())).add(lTree);
                    }
                }
                HashTreeAddress hashTreeAddress2 = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress.getLayerAddress())).withTreeAddress(hashTreeAddress.getTreeAddress())).withTreeHeight(hashTreeAddress.getTreeHeight()).withTreeIndex((hashTreeAddress.getTreeIndex() - 1) / 2).withKeyAndMask(hashTreeAddress.getKeyAndMask())).build();
                XMSSNode randomizeHash = XMSSNodeUtil.randomizeHash(this.wotsPlus, this.stack.pop(), lTree, hashTreeAddress2);
                XMSSNode xMSSNode = new XMSSNode(randomizeHash.getHeight() + 1, randomizeHash.getValue());
                hashTreeAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress2.getLayerAddress())).withTreeAddress(hashTreeAddress2.getTreeAddress())).withTreeHeight(hashTreeAddress2.getTreeHeight() + 1).withTreeIndex(hashTreeAddress2.getTreeIndex()).withKeyAndMask(hashTreeAddress2.getKeyAndMask())).build();
                lTree = xMSSNode;
            }
            this.stack.push(lTree);
        }
        this.root = this.stack.pop();
    }

    private void nextAuthenticationPath(byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        Object obj;
        List<XMSSNode> list;
        Objects.requireNonNull(oTSHashAddress, "otsHashAddress == null");
        if (!this.used) {
            int i11 = this.index;
            if (i11 <= this.maxIndex - 1) {
                int calculateTau = XMSSUtil.calculateTau(i11, this.treeHeight);
                if (((this.index >> (calculateTau + 1)) & 1) == 0 && calculateTau < this.treeHeight - 1) {
                    this.keep.put(Integer.valueOf(calculateTau), this.authenticationPath.get(calculateTau));
                }
                LTreeAddress lTreeAddress = (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).build();
                HashTreeAddress hashTreeAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).build();
                if (calculateTau == 0) {
                    oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(this.index).withChainAddress(oTSHashAddress.getChainAddress()).withHashAddress(oTSHashAddress.getHashAddress()).withKeyAndMask(oTSHashAddress.getKeyAndMask())).build();
                    WOTSPlus wOTSPlus = this.wotsPlus;
                    wOTSPlus.importKeys(wOTSPlus.getWOTSPlusSecretKey(bArr2, oTSHashAddress), bArr);
                    this.authenticationPath.set(0, XMSSNodeUtil.lTree(this.wotsPlus, this.wotsPlus.getPublicKey(oTSHashAddress), (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(lTreeAddress.getLayerAddress())).withTreeAddress(lTreeAddress.getTreeAddress())).withLTreeAddress(this.index).withTreeHeight(lTreeAddress.getTreeHeight()).withTreeIndex(lTreeAddress.getTreeIndex()).withKeyAndMask(lTreeAddress.getKeyAndMask())).build()));
                } else {
                    int i12 = calculateTau - 1;
                    WOTSPlus wOTSPlus2 = this.wotsPlus;
                    wOTSPlus2.importKeys(wOTSPlus2.getWOTSPlusSecretKey(bArr2, oTSHashAddress), bArr);
                    XMSSNode randomizeHash = XMSSNodeUtil.randomizeHash(this.wotsPlus, this.authenticationPath.get(i12), this.keep.get(Integer.valueOf(i12)), (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress.getLayerAddress())).withTreeAddress(hashTreeAddress.getTreeAddress())).withTreeHeight(i12).withTreeIndex(this.index >> calculateTau).withKeyAndMask(hashTreeAddress.getKeyAndMask())).build());
                    this.authenticationPath.set(calculateTau, new XMSSNode(randomizeHash.getHeight() + 1, randomizeHash.getValue()));
                    this.keep.remove(Integer.valueOf(i12));
                    for (int i13 = 0; i13 < calculateTau; i13++) {
                        if (i13 < this.treeHeight - this.f59614k) {
                            list = this.authenticationPath;
                            obj = this.treeHashInstances.get(i13).getTailNode();
                        } else {
                            list = this.authenticationPath;
                            obj = this.retain.get(Integer.valueOf(i13)).removeFirst();
                        }
                        list.set(i13, obj);
                    }
                    int min = Math.min(calculateTau, this.treeHeight - this.f59614k);
                    for (int i14 = 0; i14 < min; i14++) {
                        int i15 = this.index + 1 + ((1 << i14) * 3);
                        if (i15 < (1 << this.treeHeight)) {
                            this.treeHashInstances.get(i14).initialize(i15);
                        }
                    }
                }
                for (int i16 = 0; i16 < ((this.treeHeight - this.f59614k) >> 1); i16++) {
                    BDSTreeHash bDSTreeHashInstanceForUpdate = getBDSTreeHashInstanceForUpdate();
                    if (bDSTreeHashInstanceForUpdate != null) {
                        bDSTreeHashInstanceForUpdate.update(this.stack, this.wotsPlus, bArr, bArr2, oTSHashAddress);
                    }
                }
                this.index++;
                return;
            }
            throw new IllegalStateException("index out of bounds");
        }
        throw new IllegalStateException("index already used");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.maxIndex = objectInputStream.available() != 0 ? objectInputStream.readInt() : (1 << this.treeHeight) - 1;
        int i11 = this.maxIndex;
        if (i11 > (1 << this.treeHeight) - 1 || this.index > i11 + 1 || objectInputStream.available() != 0) {
            throw new IOException("inconsistent BDS data detected");
        }
    }

    private void validate() {
        if (this.authenticationPath == null) {
            throw new IllegalStateException("authenticationPath == null");
        } else if (this.retain == null) {
            throw new IllegalStateException("retain == null");
        } else if (this.stack == null) {
            throw new IllegalStateException("stack == null");
        } else if (this.treeHashInstances == null) {
            throw new IllegalStateException("treeHashInstances == null");
        } else if (this.keep == null) {
            throw new IllegalStateException("keep == null");
        } else if (!XMSSUtil.isIndexValid(this.treeHeight, (long) this.index)) {
            throw new IllegalStateException("index in BDS state out of bounds");
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.maxIndex);
    }

    public List<XMSSNode> getAuthenticationPath() {
        ArrayList arrayList = new ArrayList();
        for (XMSSNode add : this.authenticationPath) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public int getIndex() {
        return this.index;
    }

    public int getMaxIndex() {
        return this.maxIndex;
    }

    public BDS getNextState(byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        return new BDS(this, bArr, bArr2, oTSHashAddress);
    }

    public XMSSNode getRoot() {
        return this.root;
    }

    public int getTreeHeight() {
        return this.treeHeight;
    }

    public boolean isUsed() {
        return this.used;
    }

    public void markUsed() {
        this.used = true;
    }

    public BDS withMaxIndex(int i11, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return new BDS(this, i11, aSN1ObjectIdentifier);
    }

    public BDS withWOTSDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return new BDS(this, aSN1ObjectIdentifier);
    }
}
