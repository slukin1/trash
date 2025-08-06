package com.facebook.internal;

import java.util.EnumSet;
import java.util.Iterator;

public enum SmartLoginOption {
    None(0),
    Enabled(1),
    RequireConfirm(2);
    
    public static final EnumSet<SmartLoginOption> ALL = null;
    private final long mValue;

    /* access modifiers changed from: public */
    static {
        ALL = EnumSet.allOf(SmartLoginOption.class);
    }

    private SmartLoginOption(long j11) {
        this.mValue = j11;
    }

    public static EnumSet<SmartLoginOption> parseOptions(long j11) {
        EnumSet<SmartLoginOption> noneOf = EnumSet.noneOf(SmartLoginOption.class);
        Iterator it2 = ALL.iterator();
        while (it2.hasNext()) {
            SmartLoginOption smartLoginOption = (SmartLoginOption) it2.next();
            if ((smartLoginOption.getValue() & j11) != 0) {
                noneOf.add(smartLoginOption);
            }
        }
        return noneOf;
    }

    public long getValue() {
        return this.mValue;
    }
}
