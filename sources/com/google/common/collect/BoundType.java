package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public enum BoundType {
    OPEN(false),
    CLOSED(true);
    
    public final boolean inclusive;

    private BoundType(boolean z11) {
        this.inclusive = z11;
    }

    public static BoundType forBoolean(boolean z11) {
        return z11 ? CLOSED : OPEN;
    }

    public BoundType flip() {
        return forBoolean(!this.inclusive);
    }
}
