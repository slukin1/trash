package com.huochat.community.enums;

import kotlin.jvm.internal.r;

public enum TopDataType {
    UNKNOWN(-1),
    NORMAL(0),
    TOPIC(1),
    SORT_MENU(2);
    
    public static final Companion Companion = null;
    private int type;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final TopDataType getType(int i11) {
            for (TopDataType topDataType : TopDataType.values()) {
                if (topDataType.getType() == i11) {
                    return topDataType;
                }
            }
            return TopDataType.UNKNOWN;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((r) null);
    }

    private TopDataType(int i11) {
        this.type = i11;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i11) {
        this.type = i11;
    }
}
