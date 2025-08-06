package com.hbg.module.kline.enums;

public enum CommentSwitchEnum {
    SHOW(1, "显示评论列表"),
    HIDE(0, "不显示评论列表");
    
    public String desc;
    public int type;

    private CommentSwitchEnum(int i11, String str) {
        this.type = i11;
        this.desc = str;
    }

    public static CommentSwitchEnum getType(int i11) {
        CommentSwitchEnum[] values = values();
        if (values != null) {
            for (CommentSwitchEnum commentSwitchEnum : values) {
                if (commentSwitchEnum.type == i11) {
                    return commentSwitchEnum;
                }
            }
        }
        return HIDE;
    }
}
