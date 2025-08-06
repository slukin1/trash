package com.huochat.community.model;

import com.huochat.community.R;

public enum MomentType {
    MOMENT_TEXT(10, 0, ""),
    MOMENT_SHARE_IMAGE(10, 0, ""),
    MOMENT_IMAGE_0(10, 0, ""),
    MOMENT_IMAGE_1(11, 0, ""),
    MOMENT_IMAGE_2(12, 0, ""),
    MOMENT_IMAGE_3(13, 0, ""),
    MOMENT_IMAGE_4(14, 0, ""),
    MOMENT_IMAGE_5(15, 0, ""),
    MOMENT_IMAGE_6(16, 0, ""),
    MOMENT_IMAGE_7(17, 0, ""),
    MOMENT_IMAGE_8(18, 0, ""),
    MOMENT_IMAGE_9(19, 0, ""),
    MOMENT_VEDIO(20, 0, ""),
    MOMENT_NEWS(30, R.drawable.bm_share_icon_zx, "资讯"),
    MOMENT_SCHOOL(40, R.drawable.bm_share_icon_bxt, "学堂"),
    MOMENT_CLUB(50, R.drawable.bm_share_icon_hd, "活动"),
    MOMENT_EXCHANGE(60, R.drawable.bm_share_icon_sd, "闪兑"),
    MOMENT_PROJECT(70, R.drawable.bm_share_icon_xm, "项目"),
    MOMENT_FLASH(81, 0, "快讯"),
    MOMENT_OUT_SHARE_IMAGE(90, 0, ""),
    MOMENT_OUT_SHARE_LINK(100, 0, ""),
    MOMENT_CONTENT_LINK(110, R.drawable.ic_community_link_def, ""),
    MOMENT_NONE(9999, 0, "");
    
    public String label;
    public int resouceId;
    public int type;

    private MomentType(int i11, int i12, String str) {
        this.type = i11;
        this.label = str;
        this.resouceId = i12;
    }

    public static MomentType getType(int i11) {
        if (i11 != 0) {
            if (i11 == 30) {
                return MOMENT_NEWS;
            }
            if (i11 == 40) {
                return MOMENT_SCHOOL;
            }
            if (i11 == 50) {
                return MOMENT_CLUB;
            }
            if (i11 == 60) {
                return MOMENT_EXCHANGE;
            }
            if (i11 == 70) {
                return MOMENT_PROJECT;
            }
            if (i11 == 100) {
                return MOMENT_OUT_SHARE_LINK;
            }
            if (i11 == 80 || i11 == 81) {
                return MOMENT_FLASH;
            }
            if (i11 == 90 || i11 == 91) {
                return MOMENT_OUT_SHARE_IMAGE;
            }
            switch (i11) {
                case 10:
                    break;
                case 11:
                    return MOMENT_IMAGE_1;
                case 12:
                    return MOMENT_IMAGE_2;
                case 13:
                    return MOMENT_IMAGE_3;
                case 14:
                    return MOMENT_IMAGE_4;
                case 15:
                    return MOMENT_IMAGE_5;
                case 16:
                    return MOMENT_IMAGE_6;
                case 17:
                    return MOMENT_IMAGE_7;
                case 18:
                    return MOMENT_IMAGE_8;
                case 19:
                    return MOMENT_IMAGE_9;
                case 20:
                    return MOMENT_VEDIO;
                default:
                    switch (i11) {
                        case 110:
                        case 111:
                        case 112:
                        case 113:
                        case 114:
                        case 115:
                        case 116:
                        case 117:
                        case 118:
                        case 119:
                            return MOMENT_CONTENT_LINK;
                        default:
                            return MOMENT_NONE;
                    }
            }
        }
        return MOMENT_TEXT;
    }
}
