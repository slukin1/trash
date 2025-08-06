package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;

public class RunnableWrapper implements Runnable {
    private Runnable runnable;

    public RunnableWrapper(Runnable runnable2) {
        this.runnable = runnable2;
    }

    public void run() {
        try {
            this.runnable.run();
        } catch (Throwable th2) {
            AdjustFactory.getLogger().error("Runnable error [%s] of type [%s]", th2.getMessage(), th2.getClass().getCanonicalName());
        }
    }
}
