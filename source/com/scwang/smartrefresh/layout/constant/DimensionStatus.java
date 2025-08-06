package com.scwang.smartrefresh.layout.constant;

public enum DimensionStatus {
    DefaultUnNotify(false),
    Default(true),
    XmlWrapUnNotify(false),
    XmlWrap(true),
    XmlExactUnNotify(false),
    XmlExact(true),
    XmlLayoutUnNotify(false),
    XmlLayout(true),
    CodeExactUnNotify(false),
    CodeExact(true),
    DeadLockUnNotify(false),
    DeadLock(true);
    
    public final boolean notified;

    private DimensionStatus(boolean z11) {
        this.notified = z11;
    }

    public boolean canReplaceWith(DimensionStatus dimensionStatus) {
        return ordinal() < dimensionStatus.ordinal() || ((!this.notified || CodeExact == this) && ordinal() == dimensionStatus.ordinal());
    }

    public boolean gteReplaceWith(DimensionStatus dimensionStatus) {
        return ordinal() >= dimensionStatus.ordinal();
    }

    public DimensionStatus notified() {
        return !this.notified ? values()[ordinal() + 1] : this;
    }

    public DimensionStatus unNotify() {
        if (!this.notified) {
            return this;
        }
        DimensionStatus dimensionStatus = values()[ordinal() - 1];
        if (!dimensionStatus.notified) {
            return dimensionStatus;
        }
        return DefaultUnNotify;
    }
}
