package com.huochat.community.enums;

import kotlin.jvm.internal.r;

public enum MomentTagType {
    NONE(0, "无"),
    RECOMMEND(1, "推荐"),
    TOP(2, "置顶"),
    FEATURED(3, "精选");
    
    public static final Companion Companion = null;
    private String desc;
    private int type;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final MomentTagType getType(int i11) {
            for (MomentTagType momentTagType : MomentTagType.values()) {
                if (i11 == momentTagType.getType()) {
                    return momentTagType;
                }
            }
            return MomentTagType.NONE;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((r) null);
    }

    private MomentTagType(int i11, String str) {
        this.desc = "";
        this.type = i11;
        this.desc = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getType() {
        return this.type;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setType(int i11) {
        this.type = i11;
    }
}
