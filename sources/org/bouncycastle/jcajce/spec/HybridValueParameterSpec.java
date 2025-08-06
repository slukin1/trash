package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.security.auth.Destroyable;
import org.bouncycastle.util.Arrays;

public class HybridValueParameterSpec implements AlgorithmParameterSpec, Destroyable {
    private volatile AlgorithmParameterSpec baseSpec;
    private final AtomicBoolean hasBeenDestroyed = new AtomicBoolean(false);

    /* renamed from: t  reason: collision with root package name */
    private volatile byte[] f59352t;

    public HybridValueParameterSpec(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec) {
        this.f59352t = bArr;
        this.baseSpec = algorithmParameterSpec;
    }

    private void checkDestroyed() {
        if (isDestroyed()) {
            throw new IllegalStateException("spec has been destroyed");
        }
    }

    public void destroy() {
        if (!this.hasBeenDestroyed.getAndSet(true)) {
            Arrays.clear(this.f59352t);
            this.f59352t = null;
            this.baseSpec = null;
        }
    }

    public AlgorithmParameterSpec getBaseParameterSpec() {
        checkDestroyed();
        return this.baseSpec;
    }

    public byte[] getT() {
        checkDestroyed();
        return this.f59352t;
    }

    public boolean isDestroyed() {
        return this.hasBeenDestroyed.get();
    }
}
