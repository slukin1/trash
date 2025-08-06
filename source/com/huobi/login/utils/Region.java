package com.huobi.login.utils;

import android.text.TextUtils;

public enum Region {
    REGION_BJ(11, "BJ", "北京市"),
    REGION_TJ(12, "TJ", "天津市"),
    REGION_HE(13, "HE", "河北省"),
    REGION_SX(14, "SX", "山西省"),
    REGION_NM(15, "NM", "内蒙古自治区"),
    REGION_LN(21, "LN", "辽宁省"),
    REGION_JL(22, "JL", "吉林省"),
    REGION_HL(23, "HL", "黑龙江省"),
    REGION_SH(31, "SH", "上海市"),
    REGION_JS(32, "JS", "江苏省"),
    REGION_ZJ(33, "ZJ", "浙江省"),
    REGION_AH(34, "AH", "安徽省"),
    REGION_FJ(35, "FJ", "福建省"),
    REGION_JX(36, "JX", "江西省"),
    REGION_SD(37, "SD", "山东省"),
    REGION_HA(41, "HA", "河南省"),
    REGION_HB(42, "HB", "湖北省"),
    REGION_HN(43, "HN", "湖南省"),
    REGION_GD(44, "GD", "广东省"),
    REGION_GX(45, "GX", "广西壮族自治区"),
    REGION_HI(46, "HI", "海南省"),
    REGION_CQ(50, "CQ", "重庆市"),
    REGION_SC(51, "SC", "四川省"),
    REGION_GZ(52, "GZ", "贵州省"),
    REGION_YN(53, "YN", "云南省"),
    REGION_XZ(54, "XZ", "西藏自治区"),
    REGION_SN(61, "SN", "陕西省"),
    REGION_GS(62, "GS", "甘肃省"),
    REGION_QH(63, "QH", "青海省"),
    REGION_NX(64, "NX", "宁夏回族自治区"),
    REGION_XJ(65, "XJ", "新疆");
    
    private int regionId;
    private String regionIsoCode;
    private String regionName;

    private Region(int i11, String str, String str2) {
        this.regionId = i11;
        this.regionName = str2;
        this.regionIsoCode = str;
    }

    public static Region findRegionByIsoCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Region region : values()) {
            if (region.getRegionIsoCode().equalsIgnoreCase(str)) {
                return region;
            }
        }
        return null;
    }

    public static Region findRegionByRegionId(int i11) {
        if (i11 == 0) {
            return null;
        }
        for (Region region : values()) {
            if (region.regionId == i11) {
                return region;
            }
        }
        return null;
    }

    public int getRegionId() {
        return this.regionId;
    }

    public String getRegionIsoCode() {
        return this.regionIsoCode;
    }

    public String getRegionName() {
        return this.regionName;
    }
}
