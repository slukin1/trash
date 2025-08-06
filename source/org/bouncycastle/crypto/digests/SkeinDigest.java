package org.bouncycastle.crypto.digests;

import com.xiaomi.mipush.sdk.Constants;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.params.SkeinParameters;
import org.bouncycastle.util.Memoable;

public class SkeinDigest implements ExtendedDigest, Memoable {
    public static final int SKEIN_1024 = 1024;
    public static final int SKEIN_256 = 256;
    public static final int SKEIN_512 = 512;
    private SkeinEngine engine;

    public SkeinDigest(int i11, int i12) {
        this.engine = new SkeinEngine(i11, i12);
        init((SkeinParameters) null);
    }

    public SkeinDigest(SkeinDigest skeinDigest) {
        this.engine = new SkeinEngine(skeinDigest.engine);
    }

    public Memoable copy() {
        return new SkeinDigest(this);
    }

    public int doFinal(byte[] bArr, int i11) {
        return this.engine.doFinal(bArr, i11);
    }

    public String getAlgorithmName() {
        return "Skein-" + (this.engine.getBlockSize() * 8) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + (this.engine.getOutputSize() * 8);
    }

    public int getByteLength() {
        return this.engine.getBlockSize();
    }

    public int getDigestSize() {
        return this.engine.getOutputSize();
    }

    public void init(SkeinParameters skeinParameters) {
        this.engine.init(skeinParameters);
    }

    public void reset() {
        this.engine.reset();
    }

    public void reset(Memoable memoable) {
        this.engine.reset(((SkeinDigest) memoable).engine);
    }

    public void update(byte b11) {
        this.engine.update(b11);
    }

    public void update(byte[] bArr, int i11, int i12) {
        this.engine.update(bArr, i11, i12);
    }
}
