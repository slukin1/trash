package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.OTSHashAddress;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.Pack;

public final class XMSSPrivateKeyParameters extends XMSSKeyParameters implements XMSSStoreableObjectInterface, Encodable {
    private volatile BDS bdsState;
    private final XMSSParameters params;
    private final byte[] publicSeed;
    private final byte[] root;
    private final byte[] secretKeyPRF;
    private final byte[] secretKeySeed;

    public static class Builder {
        /* access modifiers changed from: private */
        public BDS bdsState = null;
        /* access modifiers changed from: private */
        public int index = 0;
        /* access modifiers changed from: private */
        public int maxIndex = -1;
        /* access modifiers changed from: private */
        public final XMSSParameters params;
        /* access modifiers changed from: private */
        public byte[] privateKey = null;
        /* access modifiers changed from: private */
        public byte[] publicSeed = null;
        /* access modifiers changed from: private */
        public byte[] root = null;
        /* access modifiers changed from: private */
        public byte[] secretKeyPRF = null;
        /* access modifiers changed from: private */
        public byte[] secretKeySeed = null;

        public Builder(XMSSParameters xMSSParameters) {
            this.params = xMSSParameters;
        }

        public XMSSPrivateKeyParameters build() {
            return new XMSSPrivateKeyParameters(this);
        }

        public Builder withBDSState(BDS bds) {
            this.bdsState = bds;
            return this;
        }

        public Builder withIndex(int i11) {
            this.index = i11;
            return this;
        }

        public Builder withMaxIndex(int i11) {
            this.maxIndex = i11;
            return this;
        }

        public Builder withPrivateKey(byte[] bArr) {
            this.privateKey = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withPublicSeed(byte[] bArr) {
            this.publicSeed = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withRoot(byte[] bArr) {
            this.root = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withSecretKeyPRF(byte[] bArr) {
            this.secretKeyPRF = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withSecretKeySeed(byte[] bArr) {
            this.secretKeySeed = XMSSUtil.cloneArray(bArr);
            return this;
        }
    }

    private XMSSPrivateKeyParameters(Builder builder) {
        super(true, builder.params.getTreeDigest());
        XMSSParameters access$000 = builder.params;
        this.params = access$000;
        Objects.requireNonNull(access$000, "params == null");
        int treeDigestSize = access$000.getTreeDigestSize();
        byte[] access$100 = builder.privateKey;
        if (access$100 != null) {
            int height = access$000.getHeight();
            int bigEndianToInt = Pack.bigEndianToInt(access$100, 0);
            if (XMSSUtil.isIndexValid(height, (long) bigEndianToInt)) {
                this.secretKeySeed = XMSSUtil.extractBytesAtOffset(access$100, 4, treeDigestSize);
                int i11 = 4 + treeDigestSize;
                this.secretKeyPRF = XMSSUtil.extractBytesAtOffset(access$100, i11, treeDigestSize);
                int i12 = i11 + treeDigestSize;
                this.publicSeed = XMSSUtil.extractBytesAtOffset(access$100, i12, treeDigestSize);
                int i13 = i12 + treeDigestSize;
                this.root = XMSSUtil.extractBytesAtOffset(access$100, i13, treeDigestSize);
                int i14 = i13 + treeDigestSize;
                try {
                    BDS bds = (BDS) XMSSUtil.deserialize(XMSSUtil.extractBytesAtOffset(access$100, i14, access$100.length - i14), BDS.class);
                    if (bds.getIndex() == bigEndianToInt) {
                        this.bdsState = bds.withWOTSDigest(builder.params.getTreeDigestOID());
                        return;
                    }
                    throw new IllegalStateException("serialized BDS has wrong index");
                } catch (IOException e11) {
                    throw new IllegalArgumentException(e11.getMessage(), e11);
                } catch (ClassNotFoundException e12) {
                    throw new IllegalArgumentException(e12.getMessage(), e12);
                }
            } else {
                throw new IllegalArgumentException("index out of bounds");
            }
        } else {
            byte[] access$200 = builder.secretKeySeed;
            if (access$200 == null) {
                this.secretKeySeed = new byte[treeDigestSize];
            } else if (access$200.length == treeDigestSize) {
                this.secretKeySeed = access$200;
            } else {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            byte[] access$300 = builder.secretKeyPRF;
            if (access$300 == null) {
                this.secretKeyPRF = new byte[treeDigestSize];
            } else if (access$300.length == treeDigestSize) {
                this.secretKeyPRF = access$300;
            } else {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            byte[] access$400 = builder.publicSeed;
            if (access$400 == null) {
                this.publicSeed = new byte[treeDigestSize];
            } else if (access$400.length == treeDigestSize) {
                this.publicSeed = access$400;
            } else {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            byte[] access$500 = builder.root;
            if (access$500 == null) {
                this.root = new byte[treeDigestSize];
            } else if (access$500.length == treeDigestSize) {
                this.root = access$500;
            } else {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            BDS access$600 = builder.bdsState;
            this.bdsState = access$600 == null ? (builder.index >= (1 << access$000.getHeight()) + -2 || access$400 == null || access$200 == null) ? new BDS(access$000, (1 << access$000.getHeight()) - 1, builder.index) : new BDS(access$000, access$400, access$200, (OTSHashAddress) new OTSHashAddress.Builder().build(), builder.index) : access$600;
            if (builder.maxIndex >= 0 && builder.maxIndex != this.bdsState.getMaxIndex()) {
                throw new IllegalArgumentException("maxIndex set but not reflected in state");
            }
        }
    }

    public XMSSPrivateKeyParameters extractKeyShard(int i11) {
        XMSSPrivateKeyParameters build;
        if (i11 >= 1) {
            synchronized (this) {
                long j11 = (long) i11;
                if (j11 <= getUsagesRemaining()) {
                    build = new Builder(this.params).withSecretKeySeed(this.secretKeySeed).withSecretKeyPRF(this.secretKeyPRF).withPublicSeed(this.publicSeed).withRoot(this.root).withIndex(getIndex()).withBDSState(this.bdsState.withMaxIndex((this.bdsState.getIndex() + i11) - 1, this.params.getTreeDigestOID())).build();
                    if (j11 == getUsagesRemaining()) {
                        this.bdsState = new BDS(this.params, this.bdsState.getMaxIndex(), getIndex() + i11);
                    } else {
                        OTSHashAddress oTSHashAddress = (OTSHashAddress) new OTSHashAddress.Builder().build();
                        for (int i12 = 0; i12 != i11; i12++) {
                            this.bdsState = this.bdsState.getNextState(this.publicSeed, this.secretKeySeed, oTSHashAddress);
                        }
                    }
                } else {
                    throw new IllegalArgumentException("usageCount exceeds usages remaining");
                }
            }
            return build;
        }
        throw new IllegalArgumentException("cannot ask for a shard with 0 keys");
    }

    public BDS getBDSState() {
        return this.bdsState;
    }

    public byte[] getEncoded() throws IOException {
        byte[] byteArray;
        synchronized (this) {
            byteArray = toByteArray();
        }
        return byteArray;
    }

    public int getIndex() {
        return this.bdsState.getIndex();
    }

    public XMSSPrivateKeyParameters getNextKey() {
        XMSSPrivateKeyParameters extractKeyShard;
        synchronized (this) {
            extractKeyShard = extractKeyShard(1);
        }
        return extractKeyShard;
    }

    public XMSSParameters getParameters() {
        return this.params;
    }

    public byte[] getPublicSeed() {
        return XMSSUtil.cloneArray(this.publicSeed);
    }

    public byte[] getRoot() {
        return XMSSUtil.cloneArray(this.root);
    }

    public byte[] getSecretKeyPRF() {
        return XMSSUtil.cloneArray(this.secretKeyPRF);
    }

    public byte[] getSecretKeySeed() {
        return XMSSUtil.cloneArray(this.secretKeySeed);
    }

    public long getUsagesRemaining() {
        long maxIndex;
        synchronized (this) {
            maxIndex = (long) ((this.bdsState.getMaxIndex() - getIndex()) + 1);
        }
        return maxIndex;
    }

    public XMSSPrivateKeyParameters rollKey() {
        synchronized (this) {
            this.bdsState = this.bdsState.getIndex() < this.bdsState.getMaxIndex() ? this.bdsState.getNextState(this.publicSeed, this.secretKeySeed, (OTSHashAddress) new OTSHashAddress.Builder().build()) : new BDS(this.params, this.bdsState.getMaxIndex(), this.bdsState.getMaxIndex() + 1);
        }
        return this;
    }

    public byte[] toByteArray() {
        byte[] concatenate;
        synchronized (this) {
            int treeDigestSize = this.params.getTreeDigestSize();
            byte[] bArr = new byte[(treeDigestSize + 4 + treeDigestSize + treeDigestSize + treeDigestSize)];
            Pack.intToBigEndian(this.bdsState.getIndex(), bArr, 0);
            XMSSUtil.copyBytesAtOffset(bArr, this.secretKeySeed, 4);
            int i11 = 4 + treeDigestSize;
            XMSSUtil.copyBytesAtOffset(bArr, this.secretKeyPRF, i11);
            int i12 = i11 + treeDigestSize;
            XMSSUtil.copyBytesAtOffset(bArr, this.publicSeed, i12);
            XMSSUtil.copyBytesAtOffset(bArr, this.root, i12 + treeDigestSize);
            try {
                concatenate = Arrays.concatenate(bArr, XMSSUtil.serialize(this.bdsState));
            } catch (IOException e11) {
                throw new RuntimeException("error serializing bds state: " + e11.getMessage());
            }
        }
        return concatenate;
    }
}
