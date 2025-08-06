package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.base.annotations.JNINamespace;
import java.util.concurrent.atomic.AtomicLong;

@JNINamespace("liteav::video")
public class ConsumerChainTimestamp {
    private AtomicLong mDecodeFinishTimestamp = new AtomicLong(0);
    private AtomicLong mDeliverTimestamp = new AtomicLong(0);
    private AtomicLong mRenderFinishTimestamp = new AtomicLong(0);

    public void copy(ConsumerChainTimestamp consumerChainTimestamp) {
        this.mDeliverTimestamp = consumerChainTimestamp.mDeliverTimestamp;
        this.mDecodeFinishTimestamp = consumerChainTimestamp.mDecodeFinishTimestamp;
        this.mRenderFinishTimestamp = consumerChainTimestamp.mRenderFinishTimestamp;
    }

    public long getDecodeFinishTimestamp() {
        return this.mDecodeFinishTimestamp.get();
    }

    public long getDeliverTimestamp() {
        return this.mDeliverTimestamp.get();
    }

    public long getRenderFinishTimestamp() {
        return this.mRenderFinishTimestamp.get();
    }

    public void setDecodeFinishTimestamp(long j11) {
        this.mDecodeFinishTimestamp.set(j11);
    }

    public void setDeliverTimestamp(long j11) {
        this.mDeliverTimestamp.set(j11);
    }

    public void setRenderFinishTimestamp(long j11) {
        this.mRenderFinishTimestamp.set(j11);
    }
}
