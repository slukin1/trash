package com.huochat.community.enums;

public enum CommunityMenuType {
    UNKNOWN(256, "未知"),
    LIST_SORT(257, "社区列表排序菜单");
    
    private String desc;
    private int type;

    private CommunityMenuType(int i11, String str) {
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
