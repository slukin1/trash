package com.huochat.community.enums;

import kotlin.jvm.internal.r;

public enum SortBtnVisible {
    VISIBLE(1),
    GONE(0);
    
    public static final Companion Companion = null;
    private int visible;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final SortBtnVisible getVisible(int i11) {
            for (SortBtnVisible sortBtnVisible : SortBtnVisible.values()) {
                if (sortBtnVisible.getVisible() == i11) {
                    return sortBtnVisible;
                }
            }
            return SortBtnVisible.GONE;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((r) null);
    }

    private SortBtnVisible(int i11) {
        this.visible = i11;
    }

    public final int getVisible() {
        return this.visible;
    }

    public final void setVisible(int i11) {
        this.visible = i11;
    }
}
