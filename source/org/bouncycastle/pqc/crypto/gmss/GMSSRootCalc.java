package org.bouncycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.encoders.Hex;

public class GMSSRootCalc {
    private byte[][] AuthPath;
    private int K;
    private GMSSDigestProvider digestProvider;
    private int heightOfNextSeed;
    private Vector heightOfNodes;
    private int heightOfTree;
    private int[] index;
    private int indexForNextSeed;
    private boolean isFinished;
    private boolean isInitialized;
    private int mdLength;
    private Digest messDigestTree;
    private Vector[] retain = new Vector[(this.K - 1)];
    private byte[] root = new byte[this.mdLength];
    private Vector tailStack;
    private Treehash[] treehash;

    public GMSSRootCalc(int i11, int i12, GMSSDigestProvider gMSSDigestProvider) {
        this.heightOfTree = i11;
        this.digestProvider = gMSSDigestProvider;
        Digest digest = gMSSDigestProvider.get();
        this.messDigestTree = digest;
        int digestSize = digest.getDigestSize();
        this.mdLength = digestSize;
        this.K = i12;
        this.index = new int[i11];
        int[] iArr = new int[2];
        iArr[1] = digestSize;
        iArr[0] = i11;
        this.AuthPath = (byte[][]) Array.newInstance(byte.class, iArr);
        for (int i13 = 0; i13 < i12 - 1; i13++) {
            this.retain[i13] = new Vector();
        }
    }

    public byte[][] getAuthPath() {
        return GMSSUtils.clone(this.AuthPath);
    }

    public Vector[] getRetain() {
        return GMSSUtils.clone(this.retain);
    }

    public byte[] getRoot() {
        return Arrays.clone(this.root);
    }

    public Vector getStack() {
        Vector vector = new Vector();
        Enumeration elements = this.tailStack.elements();
        while (elements.hasMoreElements()) {
            vector.addElement(elements.nextElement());
        }
        return vector;
    }

    public byte[][] getStatByte() {
        Vector vector = this.tailStack;
        int size = vector == null ? 0 : vector.size();
        int[] iArr = new int[2];
        iArr[1] = 64;
        iArr[0] = this.heightOfTree + 1 + size;
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, iArr);
        bArr[0] = this.root;
        int i11 = 0;
        while (i11 < this.heightOfTree) {
            int i12 = i11 + 1;
            bArr[i12] = this.AuthPath[i11];
            i11 = i12;
        }
        for (int i13 = 0; i13 < size; i13++) {
            bArr[this.heightOfTree + 1 + i13] = (byte[]) this.tailStack.elementAt(i13);
        }
        return bArr;
    }

    public int[] getStatInt() {
        Vector vector = this.tailStack;
        int size = vector == null ? 0 : vector.size();
        int i11 = this.heightOfTree;
        int[] iArr = new int[(i11 + 8 + size)];
        iArr[0] = i11;
        iArr[1] = this.mdLength;
        iArr[2] = this.K;
        iArr[3] = this.indexForNextSeed;
        iArr[4] = this.heightOfNextSeed;
        if (this.isFinished) {
            iArr[5] = 1;
        } else {
            iArr[5] = 0;
        }
        if (this.isInitialized) {
            iArr[6] = 1;
        } else {
            iArr[6] = 0;
        }
        iArr[7] = size;
        for (int i12 = 0; i12 < this.heightOfTree; i12++) {
            iArr[i12 + 8] = this.index[i12];
        }
        for (int i13 = 0; i13 < size; i13++) {
            iArr[this.heightOfTree + 8 + i13] = ((Integer) this.heightOfNodes.elementAt(i13)).intValue();
        }
        return iArr;
    }

    public Treehash[] getTreehash() {
        return GMSSUtils.clone(this.treehash);
    }

    public void initialize(Vector vector) {
        int i11;
        this.treehash = new Treehash[(this.heightOfTree - this.K)];
        int i12 = 0;
        while (true) {
            i11 = this.heightOfTree;
            if (i12 >= i11 - this.K) {
                break;
            }
            this.treehash[i12] = new Treehash(vector, i12, this.digestProvider.get());
            i12++;
        }
        this.index = new int[i11];
        int[] iArr = new int[2];
        iArr[1] = this.mdLength;
        iArr[0] = i11;
        this.AuthPath = (byte[][]) Array.newInstance(byte.class, iArr);
        this.root = new byte[this.mdLength];
        this.tailStack = new Vector();
        this.heightOfNodes = new Vector();
        this.isInitialized = true;
        this.isFinished = false;
        for (int i13 = 0; i13 < this.heightOfTree; i13++) {
            this.index[i13] = -1;
        }
        this.retain = new Vector[(this.K - 1)];
        for (int i14 = 0; i14 < this.K - 1; i14++) {
            this.retain[i14] = new Vector();
        }
        this.indexForNextSeed = 3;
        this.heightOfNextSeed = 0;
    }

    public void initializeTreehashSeed(byte[] bArr, int i11) {
        this.treehash[i11].initializeSeed(bArr);
    }

    public String toString() {
        Vector vector = this.tailStack;
        int size = vector == null ? 0 : vector.size();
        String str = "";
        for (int i11 = 0; i11 < this.heightOfTree + 8 + size; i11++) {
            str = str + getStatInt()[i11] + " ";
        }
        for (int i12 = 0; i12 < this.heightOfTree + 1 + size; i12++) {
            str = str + new String(Hex.encode(getStatByte()[i12])) + " ";
        }
        return str + "  " + this.digestProvider.get().getDigestSize();
    }

    public void update(byte[] bArr) {
        if (this.isFinished) {
            System.out.print("Too much updates for Tree!!");
        } else if (!this.isInitialized) {
            System.err.println("GMSSRootCalc not initialized!");
        } else {
            int[] iArr = this.index;
            iArr[0] = iArr[0] + 1;
            if (iArr[0] == 1) {
                System.arraycopy(bArr, 0, this.AuthPath[0], 0, this.mdLength);
            } else if (iArr[0] == 3 && this.heightOfTree > this.K) {
                this.treehash[0].setFirstNode(bArr);
            }
            int[] iArr2 = this.index;
            if ((iArr2[0] - 3) % 2 == 0 && iArr2[0] >= 3 && this.heightOfTree == this.K) {
                this.retain[0].insertElementAt(bArr, 0);
            }
            if (this.index[0] == 0) {
                this.tailStack.addElement(bArr);
                this.heightOfNodes.addElement(Integers.valueOf(0));
                return;
            }
            int i11 = this.mdLength;
            byte[] bArr2 = new byte[i11];
            int i12 = i11 << 1;
            byte[] bArr3 = new byte[i12];
            System.arraycopy(bArr, 0, bArr2, 0, i11);
            int i13 = 0;
            while (this.tailStack.size() > 0 && i13 == ((Integer) this.heightOfNodes.lastElement()).intValue()) {
                System.arraycopy(this.tailStack.lastElement(), 0, bArr3, 0, this.mdLength);
                Vector vector = this.tailStack;
                vector.removeElementAt(vector.size() - 1);
                Vector vector2 = this.heightOfNodes;
                vector2.removeElementAt(vector2.size() - 1);
                int i14 = this.mdLength;
                System.arraycopy(bArr2, 0, bArr3, i14, i14);
                this.messDigestTree.update(bArr3, 0, i12);
                bArr2 = new byte[this.messDigestTree.getDigestSize()];
                this.messDigestTree.doFinal(bArr2, 0);
                i13++;
                if (i13 < this.heightOfTree) {
                    int[] iArr3 = this.index;
                    iArr3[i13] = iArr3[i13] + 1;
                    if (iArr3[i13] == 1) {
                        System.arraycopy(bArr2, 0, this.AuthPath[i13], 0, this.mdLength);
                    }
                    if (i13 >= this.heightOfTree - this.K) {
                        if (i13 == 0) {
                            System.out.println("M���P");
                        }
                        int[] iArr4 = this.index;
                        if ((iArr4[i13] - 3) % 2 == 0 && iArr4[i13] >= 3) {
                            this.retain[i13 - (this.heightOfTree - this.K)].insertElementAt(bArr2, 0);
                        }
                    } else if (this.index[i13] == 3) {
                        this.treehash[i13].setFirstNode(bArr2);
                    }
                }
            }
            this.tailStack.addElement(bArr2);
            this.heightOfNodes.addElement(Integers.valueOf(i13));
            if (i13 == this.heightOfTree) {
                this.isFinished = true;
                this.isInitialized = false;
                this.root = (byte[]) this.tailStack.lastElement();
            }
        }
    }

    public void update(byte[] bArr, byte[] bArr2) {
        int i11 = this.heightOfNextSeed;
        if (i11 < this.heightOfTree - this.K && this.indexForNextSeed - 2 == this.index[0]) {
            initializeTreehashSeed(bArr, i11);
            this.heightOfNextSeed++;
            this.indexForNextSeed *= 2;
        }
        update(bArr2);
    }

    public boolean wasFinished() {
        return this.isFinished;
    }

    public boolean wasInitialized() {
        return this.isInitialized;
    }
}
