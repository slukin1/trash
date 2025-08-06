package com.zopim.android.sdk.model.items;

import com.zopim.android.sdk.model.items.VisitorItem;

public abstract class VisitorItem<T extends VisitorItem> extends RowItem<T> {
    private boolean failed;
    private boolean unverified;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisitorItem) || !super.equals(obj)) {
            return false;
        }
        VisitorItem visitorItem = (VisitorItem) obj;
        if (this.unverified != visitorItem.unverified) {
            return false;
        }
        if (this.failed == visitorItem.failed) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + (this.unverified ? 1 : 0)) * 31) + (this.failed ? 1 : 0);
    }

    public boolean isFailed() {
        return this.failed;
    }

    public boolean isUnverified() {
        return this.unverified;
    }

    public void setFailed(boolean z11) {
        this.failed = z11;
    }

    public void setUnverified(boolean z11) {
        this.unverified = z11;
    }

    public String toString() {
        return "failed:" + this.failed + super.toString();
    }

    public void update(T t11) {
        super.update(t11);
        this.unverified = t11.isUnverified();
        this.failed = t11.isFailed();
    }
}
