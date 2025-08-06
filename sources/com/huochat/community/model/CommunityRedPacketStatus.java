package com.huochat.community.model;

import kotlin.jvm.internal.r;

public enum CommunityRedPacketStatus {
    COMMUNITY_RED_PACKET_X(-1, "未知"),
    COMMUNITY_RED_PACKET_0(0, "未领取"),
    COMMUNITY_RED_PACKET_1(1, "已领取"),
    COMMUNITY_RED_PACKET_2(2, "已过期"),
    COMMUNITY_RED_PACKET_3(3, "已抢完");
    
    public static final Companion Companion = null;
    private String desc;
    private Integer status;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public CommunityRedPacketStatus getStatus(int i11) {
            CommunityRedPacketStatus[] values = CommunityRedPacketStatus.values();
            boolean z11 = true;
            if (values != null) {
                if (!(values.length == 0)) {
                    z11 = false;
                }
            }
            if (z11) {
                return CommunityRedPacketStatus.COMMUNITY_RED_PACKET_X;
            }
            for (CommunityRedPacketStatus communityRedPacketStatus : values) {
                Integer status = communityRedPacketStatus.getStatus();
                if (status != null && i11 == status.intValue()) {
                    return communityRedPacketStatus;
                }
            }
            return CommunityRedPacketStatus.COMMUNITY_RED_PACKET_X;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((r) null);
    }

    private CommunityRedPacketStatus(Integer num, String str) {
        this.status = 0;
        this.desc = "";
        this.status = num;
        this.desc = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }
}
