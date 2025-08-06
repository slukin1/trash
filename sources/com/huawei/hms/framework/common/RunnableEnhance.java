package com.huawei.hms.framework.common;

public class RunnableEnhance implements Runnable {
    public static final String TRANCELOGO = " -->";
    private String parentName = Thread.currentThread().getName();
    private Runnable proxy;

    public RunnableEnhance(Runnable runnable) {
        this.proxy = runnable;
    }

    public String getParentName() {
        return this.parentName;
    }

    public void run() {
        this.proxy.run();
    }
}
