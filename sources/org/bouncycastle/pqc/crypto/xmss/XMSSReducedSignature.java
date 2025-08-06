package org.bouncycastle.pqc.crypto.xmss;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class XMSSReducedSignature implements XMSSStoreableObjectInterface {
    private final List<XMSSNode> authPath;
    private final XMSSParameters params;
    private final WOTSPlusSignature wotsPlusSignature;

    public static class Builder {
        /* access modifiers changed from: private */
        public List<XMSSNode> authPath = null;
        /* access modifiers changed from: private */
        public final XMSSParameters params;
        /* access modifiers changed from: private */
        public byte[] reducedSignature = null;
        /* access modifiers changed from: private */
        public WOTSPlusSignature wotsPlusSignature = null;

        public Builder(XMSSParameters xMSSParameters) {
            this.params = xMSSParameters;
        }

        public XMSSReducedSignature build() {
            return new XMSSReducedSignature(this);
        }

        public Builder withAuthPath(List<XMSSNode> list) {
            this.authPath = list;
            return this;
        }

        public Builder withReducedSignature(byte[] bArr) {
            this.reducedSignature = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withWOTSPlusSignature(WOTSPlusSignature wOTSPlusSignature) {
            this.wotsPlusSignature = wOTSPlusSignature;
            return this;
        }
    }

    public XMSSReducedSignature(Builder builder) {
        List<XMSSNode> list;
        XMSSParameters access$000 = builder.params;
        this.params = access$000;
        Objects.requireNonNull(access$000, "params == null");
        int treeDigestSize = access$000.getTreeDigestSize();
        int len = access$000.getWOTSPlus().getParams().getLen();
        int height = access$000.getHeight();
        byte[] access$100 = builder.reducedSignature;
        if (access$100 != null) {
            if (access$100.length == (len * treeDigestSize) + (height * treeDigestSize)) {
                byte[][] bArr = new byte[len][];
                int i11 = 0;
                for (int i12 = 0; i12 < len; i12++) {
                    bArr[i12] = XMSSUtil.extractBytesAtOffset(access$100, i11, treeDigestSize);
                    i11 += treeDigestSize;
                }
                this.wotsPlusSignature = new WOTSPlusSignature(this.params.getWOTSPlus().getParams(), bArr);
                list = new ArrayList<>();
                for (int i13 = 0; i13 < height; i13++) {
                    list.add(new XMSSNode(i13, XMSSUtil.extractBytesAtOffset(access$100, i11, treeDigestSize)));
                    i11 += treeDigestSize;
                }
            } else {
                throw new IllegalArgumentException("signature has wrong size");
            }
        } else {
            WOTSPlusSignature access$200 = builder.wotsPlusSignature;
            if (access$200 == null) {
                WOTSPlusParameters params2 = access$000.getWOTSPlus().getParams();
                int[] iArr = new int[2];
                iArr[1] = treeDigestSize;
                iArr[0] = len;
                access$200 = new WOTSPlusSignature(params2, (byte[][]) Array.newInstance(byte.class, iArr));
            }
            this.wotsPlusSignature = access$200;
            list = builder.authPath;
            if (list == null) {
                list = new ArrayList<>();
            } else if (list.size() != height) {
                throw new IllegalArgumentException("size of authPath needs to be equal to height of tree");
            }
        }
        this.authPath = list;
    }

    public List<XMSSNode> getAuthPath() {
        return this.authPath;
    }

    public XMSSParameters getParams() {
        return this.params;
    }

    public WOTSPlusSignature getWOTSPlusSignature() {
        return this.wotsPlusSignature;
    }

    public byte[] toByteArray() {
        int treeDigestSize = this.params.getTreeDigestSize();
        byte[] bArr = new byte[((this.params.getWOTSPlus().getParams().getLen() * treeDigestSize) + (this.params.getHeight() * treeDigestSize))];
        byte[][] byteArray = this.wotsPlusSignature.toByteArray();
        int i11 = 0;
        for (byte[] copyBytesAtOffset : byteArray) {
            XMSSUtil.copyBytesAtOffset(bArr, copyBytesAtOffset, i11);
            i11 += treeDigestSize;
        }
        for (int i12 = 0; i12 < this.authPath.size(); i12++) {
            XMSSUtil.copyBytesAtOffset(bArr, this.authPath.get(i12).getValue(), i11);
            i11 += treeDigestSize;
        }
        return bArr;
    }
}
