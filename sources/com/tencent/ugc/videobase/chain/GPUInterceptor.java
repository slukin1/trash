package com.tencent.ugc.videobase.chain;

import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;

public abstract class GPUInterceptor {
    private boolean mIsInitialized = false;

    public final void initialize(GLTexturePool gLTexturePool) {
        if (!this.mIsInitialized) {
            onInit(gLTexturePool);
            this.mIsInitialized = true;
        }
    }

    public abstract GLTexture intercept(long j11, GLTexture gLTexture);

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public void onInit(GLTexturePool gLTexturePool) {
    }

    public void onUninit() {
    }

    public final void uninitialize() {
        if (this.mIsInitialized) {
            onUninit();
            this.mIsInitialized = false;
        }
    }
}
