package com.hbg.module.kline.enums;

public enum CommunitySwitchEnum {
    SHOW(1, "显示社区，K-line显示社区Tab。"),
    HIDE(0, "不显示社区，K-line不显示社区Tab。");
    
    public String desc;
    public int type;

    private CommunitySwitchEnum(int i11, String str) {
        this.type = i11;
        this.desc = str;
    }

    public static CommunitySwitchEnum getType(int i11) {
        CommunitySwitchEnum[] values = values();
        if (values != null) {
            for (CommunitySwitchEnum communitySwitchEnum : values) {
                if (communitySwitchEnum.type == i11) {
                    return communitySwitchEnum;
                }
            }
        }
        return HIDE;
    }
}
