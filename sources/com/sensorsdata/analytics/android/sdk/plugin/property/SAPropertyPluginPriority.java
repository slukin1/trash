package com.sensorsdata.analytics.android.sdk.plugin.property;

public class SAPropertyPluginPriority {
    public static SAPropertyPluginPriority DEFAULT = new SAPropertyPluginPriority(500);
    public static SAPropertyPluginPriority HIGH = new SAPropertyPluginPriority(750);
    public static SAPropertyPluginPriority LOW = new SAPropertyPluginPriority(250);
    public static SAPropertyPluginPriority SUPER = new SAPropertyPluginPriority(1431656640);
    private final long priority;

    private SAPropertyPluginPriority(long j11) {
        this.priority = j11;
    }

    public long getPriority() {
        return this.priority;
    }
}
