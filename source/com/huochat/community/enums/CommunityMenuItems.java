package com.huochat.community.enums;

import kotlin.jvm.internal.r;

public enum CommunityMenuItems {
    UNKNOWN(4096, 0, 0),
    DEFAULT(4097, 1, 0),
    LAST_TIME(4098, 2, 0);
    
    public static final Companion Companion = null;

    /* renamed from: id  reason: collision with root package name */
    private int f38687id;
    private int itemRes;
    private int type;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final CommunityMenuItems getType(Integer num) {
            for (CommunityMenuItems communityMenuItems : CommunityMenuItems.values()) {
                int type = communityMenuItems.getType();
                if (num != null && num.intValue() == type) {
                    return communityMenuItems;
                }
            }
            return CommunityMenuItems.UNKNOWN;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((r) null);
    }

    private CommunityMenuItems(int i11, int i12, int i13) {
        this.f38687id = i11;
        this.type = i12;
        this.itemRes = i13;
    }

    public final int getId() {
        return this.f38687id;
    }

    public final int getItemRes() {
        return this.itemRes;
    }

    public final int getType() {
        return this.type;
    }

    public final void setId(int i11) {
        this.f38687id = i11;
    }

    public final void setItemRes(int i11) {
        this.itemRes = i11;
    }

    public final void setType(int i11) {
        this.type = i11;
    }
}
