package com.huobi.zeroswap.engine.model;

import androidx.annotation.Keep;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaCodecProfileLevel;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Keep
public final class KLineBean {
    private final String amount;
    private final String day;
    private final String dayUnit;
    private final String disPlaySymbol;
    private final Boolean fold;
    private final String hour;
    private final String icon;
    private final String klineTitle;
    private final String lever;
    private final String limitTips;
    private final String liqPx;
    private final String liqPxName;
    private final String margin;
    private final String marginMode;
    private final String marginName;
    private final String marginRatio;
    private final String marginRatioName;
    private final String minute;
    private final String openAvgPx;
    private final String openAvgPxName;
    private final String pnl;
    private final String pnlColor;
    private final String pnlName;
    private final String pnlRatio;
    private final String pnlRatioName;
    private final String posSide;
    private final String posSideColor;
    private final String posSidebackColor;
    private final String positionAmountTitle;
    private final String price;
    private final String second;
    private final Boolean showClose;
    private final String symbol;
    private final String title;
    private final String updownImage;

    public KLineBean() {
        this((String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, -1, 7, (r) null);
    }

    public KLineBean(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, Boolean bool2, String str29, String str30, String str31, String str32, String str33) {
        this.amount = str;
        this.day = str2;
        this.dayUnit = str3;
        this.disPlaySymbol = str4;
        this.fold = bool;
        this.hour = str5;
        this.icon = str6;
        this.klineTitle = str7;
        this.lever = str8;
        this.liqPx = str9;
        this.liqPxName = str10;
        this.margin = str11;
        this.marginMode = str12;
        this.marginName = str13;
        this.marginRatio = str14;
        this.marginRatioName = str15;
        this.minute = str16;
        this.openAvgPx = str17;
        this.openAvgPxName = str18;
        this.pnl = str19;
        this.pnlColor = str20;
        this.pnlName = str21;
        this.pnlRatio = str22;
        this.pnlRatioName = str23;
        this.posSide = str24;
        this.posSideColor = str25;
        this.posSidebackColor = str26;
        this.positionAmountTitle = str27;
        this.price = str28;
        this.showClose = bool2;
        this.symbol = str29;
        this.title = str30;
        this.updownImage = str31;
        this.second = str32;
        this.limitTips = str33;
    }

    public static /* synthetic */ KLineBean copy$default(KLineBean kLineBean, String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, Boolean bool2, String str29, String str30, String str31, String str32, String str33, int i11, int i12, Object obj) {
        KLineBean kLineBean2 = kLineBean;
        int i13 = i11;
        return kLineBean.copy((i13 & 1) != 0 ? kLineBean2.amount : str, (i13 & 2) != 0 ? kLineBean2.day : str2, (i13 & 4) != 0 ? kLineBean2.dayUnit : str3, (i13 & 8) != 0 ? kLineBean2.disPlaySymbol : str4, (i13 & 16) != 0 ? kLineBean2.fold : bool, (i13 & 32) != 0 ? kLineBean2.hour : str5, (i13 & 64) != 0 ? kLineBean2.icon : str6, (i13 & 128) != 0 ? kLineBean2.klineTitle : str7, (i13 & 256) != 0 ? kLineBean2.lever : str8, (i13 & 512) != 0 ? kLineBean2.liqPx : str9, (i13 & 1024) != 0 ? kLineBean2.liqPxName : str10, (i13 & 2048) != 0 ? kLineBean2.margin : str11, (i13 & 4096) != 0 ? kLineBean2.marginMode : str12, (i13 & 8192) != 0 ? kLineBean2.marginName : str13, (i13 & 16384) != 0 ? kLineBean2.marginRatio : str14, (i13 & 32768) != 0 ? kLineBean2.marginRatioName : str15, (i13 & 65536) != 0 ? kLineBean2.minute : str16, (i13 & 131072) != 0 ? kLineBean2.openAvgPx : str17, (i13 & 262144) != 0 ? kLineBean2.openAvgPxName : str18, (i13 & 524288) != 0 ? kLineBean2.pnl : str19, (i13 & 1048576) != 0 ? kLineBean2.pnlColor : str20, (i13 & 2097152) != 0 ? kLineBean2.pnlName : str21, (i13 & 4194304) != 0 ? kLineBean2.pnlRatio : str22, (i13 & 8388608) != 0 ? kLineBean2.pnlRatioName : str23, (i13 & 16777216) != 0 ? kLineBean2.posSide : str24, (i13 & TPMediaCodecProfileLevel.HEVCHighTierLevel62) != 0 ? kLineBean2.posSideColor : str25, (i13 & 67108864) != 0 ? kLineBean2.posSidebackColor : str26, (i13 & 134217728) != 0 ? kLineBean2.positionAmountTitle : str27, (i13 & 268435456) != 0 ? kLineBean2.price : str28, (i13 & 536870912) != 0 ? kLineBean2.showClose : bool2, (i13 & 1073741824) != 0 ? kLineBean2.symbol : str29, (i13 & Integer.MIN_VALUE) != 0 ? kLineBean2.title : str30, (i12 & 1) != 0 ? kLineBean2.updownImage : str31, (i12 & 2) != 0 ? kLineBean2.second : str32, (i12 & 4) != 0 ? kLineBean2.limitTips : str33);
    }

    public final String component1() {
        return this.amount;
    }

    public final String component10() {
        return this.liqPx;
    }

    public final String component11() {
        return this.liqPxName;
    }

    public final String component12() {
        return this.margin;
    }

    public final String component13() {
        return this.marginMode;
    }

    public final String component14() {
        return this.marginName;
    }

    public final String component15() {
        return this.marginRatio;
    }

    public final String component16() {
        return this.marginRatioName;
    }

    public final String component17() {
        return this.minute;
    }

    public final String component18() {
        return this.openAvgPx;
    }

    public final String component19() {
        return this.openAvgPxName;
    }

    public final String component2() {
        return this.day;
    }

    public final String component20() {
        return this.pnl;
    }

    public final String component21() {
        return this.pnlColor;
    }

    public final String component22() {
        return this.pnlName;
    }

    public final String component23() {
        return this.pnlRatio;
    }

    public final String component24() {
        return this.pnlRatioName;
    }

    public final String component25() {
        return this.posSide;
    }

    public final String component26() {
        return this.posSideColor;
    }

    public final String component27() {
        return this.posSidebackColor;
    }

    public final String component28() {
        return this.positionAmountTitle;
    }

    public final String component29() {
        return this.price;
    }

    public final String component3() {
        return this.dayUnit;
    }

    public final Boolean component30() {
        return this.showClose;
    }

    public final String component31() {
        return this.symbol;
    }

    public final String component32() {
        return this.title;
    }

    public final String component33() {
        return this.updownImage;
    }

    public final String component34() {
        return this.second;
    }

    public final String component35() {
        return this.limitTips;
    }

    public final String component4() {
        return this.disPlaySymbol;
    }

    public final Boolean component5() {
        return this.fold;
    }

    public final String component6() {
        return this.hour;
    }

    public final String component7() {
        return this.icon;
    }

    public final String component8() {
        return this.klineTitle;
    }

    public final String component9() {
        return this.lever;
    }

    public final KLineBean copy(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, Boolean bool2, String str29, String str30, String str31, String str32, String str33) {
        return new KLineBean(str, str2, str3, str4, bool, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, bool2, str29, str30, str31, str32, str33);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KLineBean)) {
            return false;
        }
        KLineBean kLineBean = (KLineBean) obj;
        return x.b(this.amount, kLineBean.amount) && x.b(this.day, kLineBean.day) && x.b(this.dayUnit, kLineBean.dayUnit) && x.b(this.disPlaySymbol, kLineBean.disPlaySymbol) && x.b(this.fold, kLineBean.fold) && x.b(this.hour, kLineBean.hour) && x.b(this.icon, kLineBean.icon) && x.b(this.klineTitle, kLineBean.klineTitle) && x.b(this.lever, kLineBean.lever) && x.b(this.liqPx, kLineBean.liqPx) && x.b(this.liqPxName, kLineBean.liqPxName) && x.b(this.margin, kLineBean.margin) && x.b(this.marginMode, kLineBean.marginMode) && x.b(this.marginName, kLineBean.marginName) && x.b(this.marginRatio, kLineBean.marginRatio) && x.b(this.marginRatioName, kLineBean.marginRatioName) && x.b(this.minute, kLineBean.minute) && x.b(this.openAvgPx, kLineBean.openAvgPx) && x.b(this.openAvgPxName, kLineBean.openAvgPxName) && x.b(this.pnl, kLineBean.pnl) && x.b(this.pnlColor, kLineBean.pnlColor) && x.b(this.pnlName, kLineBean.pnlName) && x.b(this.pnlRatio, kLineBean.pnlRatio) && x.b(this.pnlRatioName, kLineBean.pnlRatioName) && x.b(this.posSide, kLineBean.posSide) && x.b(this.posSideColor, kLineBean.posSideColor) && x.b(this.posSidebackColor, kLineBean.posSidebackColor) && x.b(this.positionAmountTitle, kLineBean.positionAmountTitle) && x.b(this.price, kLineBean.price) && x.b(this.showClose, kLineBean.showClose) && x.b(this.symbol, kLineBean.symbol) && x.b(this.title, kLineBean.title) && x.b(this.updownImage, kLineBean.updownImage) && x.b(this.second, kLineBean.second) && x.b(this.limitTips, kLineBean.limitTips);
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getDay() {
        return this.day;
    }

    public final String getDayUnit() {
        return this.dayUnit;
    }

    public final String getDisPlaySymbol() {
        return this.disPlaySymbol;
    }

    public final Boolean getFold() {
        return this.fold;
    }

    public final String getHour() {
        return this.hour;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getKlineTitle() {
        return this.klineTitle;
    }

    public final String getLever() {
        return this.lever;
    }

    public final String getLimitTips() {
        return this.limitTips;
    }

    public final String getLiqPx() {
        return this.liqPx;
    }

    public final String getLiqPxName() {
        return this.liqPxName;
    }

    public final String getMargin() {
        return this.margin;
    }

    public final String getMarginMode() {
        return this.marginMode;
    }

    public final String getMarginName() {
        return this.marginName;
    }

    public final String getMarginRatio() {
        return this.marginRatio;
    }

    public final String getMarginRatioName() {
        return this.marginRatioName;
    }

    public final String getMinute() {
        return this.minute;
    }

    public final String getOpenAvgPx() {
        return this.openAvgPx;
    }

    public final String getOpenAvgPxName() {
        return this.openAvgPxName;
    }

    public final String getPnl() {
        return this.pnl;
    }

    public final String getPnlColor() {
        return this.pnlColor;
    }

    public final String getPnlName() {
        return this.pnlName;
    }

    public final String getPnlRatio() {
        return this.pnlRatio;
    }

    public final String getPnlRatioName() {
        return this.pnlRatioName;
    }

    public final String getPosSide() {
        return this.posSide;
    }

    public final String getPosSideColor() {
        return this.posSideColor;
    }

    public final String getPosSidebackColor() {
        return this.posSidebackColor;
    }

    public final String getPositionAmountTitle() {
        return this.positionAmountTitle;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getSecond() {
        return this.second;
    }

    public final Boolean getShowClose() {
        return this.showClose;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUpdownImage() {
        return this.updownImage;
    }

    public int hashCode() {
        String str = this.amount;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.day;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.dayUnit;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.disPlaySymbol;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.fold;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str5 = this.hour;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.icon;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.klineTitle;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.lever;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.liqPx;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.liqPxName;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.margin;
        int hashCode12 = (hashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.marginMode;
        int hashCode13 = (hashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.marginName;
        int hashCode14 = (hashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.marginRatio;
        int hashCode15 = (hashCode14 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.marginRatioName;
        int hashCode16 = (hashCode15 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.minute;
        int hashCode17 = (hashCode16 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.openAvgPx;
        int hashCode18 = (hashCode17 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.openAvgPxName;
        int hashCode19 = (hashCode18 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.pnl;
        int hashCode20 = (hashCode19 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.pnlColor;
        int hashCode21 = (hashCode20 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.pnlName;
        int hashCode22 = (hashCode21 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.pnlRatio;
        int hashCode23 = (hashCode22 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.pnlRatioName;
        int hashCode24 = (hashCode23 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.posSide;
        int hashCode25 = (hashCode24 + (str24 == null ? 0 : str24.hashCode())) * 31;
        String str25 = this.posSideColor;
        int hashCode26 = (hashCode25 + (str25 == null ? 0 : str25.hashCode())) * 31;
        String str26 = this.posSidebackColor;
        int hashCode27 = (hashCode26 + (str26 == null ? 0 : str26.hashCode())) * 31;
        String str27 = this.positionAmountTitle;
        int hashCode28 = (hashCode27 + (str27 == null ? 0 : str27.hashCode())) * 31;
        String str28 = this.price;
        int hashCode29 = (hashCode28 + (str28 == null ? 0 : str28.hashCode())) * 31;
        Boolean bool2 = this.showClose;
        int hashCode30 = (hashCode29 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str29 = this.symbol;
        int hashCode31 = (hashCode30 + (str29 == null ? 0 : str29.hashCode())) * 31;
        String str30 = this.title;
        int hashCode32 = (hashCode31 + (str30 == null ? 0 : str30.hashCode())) * 31;
        String str31 = this.updownImage;
        int hashCode33 = (hashCode32 + (str31 == null ? 0 : str31.hashCode())) * 31;
        String str32 = this.second;
        int hashCode34 = (hashCode33 + (str32 == null ? 0 : str32.hashCode())) * 31;
        String str33 = this.limitTips;
        if (str33 != null) {
            i11 = str33.hashCode();
        }
        return hashCode34 + i11;
    }

    public String toString() {
        return "KLineBean(amount=" + this.amount + ", day=" + this.day + ", dayUnit=" + this.dayUnit + ", disPlaySymbol=" + this.disPlaySymbol + ", fold=" + this.fold + ", hour=" + this.hour + ", icon=" + this.icon + ", klineTitle=" + this.klineTitle + ", lever=" + this.lever + ", liqPx=" + this.liqPx + ", liqPxName=" + this.liqPxName + ", margin=" + this.margin + ", marginMode=" + this.marginMode + ", marginName=" + this.marginName + ", marginRatio=" + this.marginRatio + ", marginRatioName=" + this.marginRatioName + ", minute=" + this.minute + ", openAvgPx=" + this.openAvgPx + ", openAvgPxName=" + this.openAvgPxName + ", pnl=" + this.pnl + ", pnlColor=" + this.pnlColor + ", pnlName=" + this.pnlName + ", pnlRatio=" + this.pnlRatio + ", pnlRatioName=" + this.pnlRatioName + ", posSide=" + this.posSide + ", posSideColor=" + this.posSideColor + ", posSidebackColor=" + this.posSidebackColor + ", positionAmountTitle=" + this.positionAmountTitle + ", price=" + this.price + ", showClose=" + this.showClose + ", symbol=" + this.symbol + ", title=" + this.title + ", updownImage=" + this.updownImage + ", second=" + this.second + ", limitTips=" + this.limitTips + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ KLineBean(java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.Boolean r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, java.lang.String r56, java.lang.String r57, java.lang.String r58, java.lang.String r59, java.lang.String r60, java.lang.String r61, java.lang.String r62, java.lang.String r63, java.lang.String r64, java.lang.Boolean r65, java.lang.String r66, java.lang.String r67, java.lang.String r68, java.lang.String r69, java.lang.String r70, int r71, int r72, kotlin.jvm.internal.r r73) {
        /*
            r35 = this;
            r0 = r71
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r36
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r37
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r38
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r39
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r40
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r41
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r42
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r43
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r44
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r45
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r46
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r47
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r48
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r49
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r50
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r51
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r52
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r53
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r54
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r55
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 0
            goto L_0x00bd
        L_0x00bb:
            r21 = r56
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r57
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d1
            r23 = 0
            goto L_0x00d3
        L_0x00d1:
            r23 = r58
        L_0x00d3:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00dc
            r24 = 0
            goto L_0x00de
        L_0x00dc:
            r24 = r59
        L_0x00de:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e7
            r25 = 0
            goto L_0x00e9
        L_0x00e7:
            r25 = r60
        L_0x00e9:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00f2
            r26 = 0
            goto L_0x00f4
        L_0x00f2:
            r26 = r61
        L_0x00f4:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00fd
            r27 = 0
            goto L_0x00ff
        L_0x00fd:
            r27 = r62
        L_0x00ff:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x0108
            r28 = 0
            goto L_0x010a
        L_0x0108:
            r28 = r63
        L_0x010a:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x0113
            r29 = 0
            goto L_0x0115
        L_0x0113:
            r29 = r64
        L_0x0115:
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x011e
            r30 = 0
            goto L_0x0120
        L_0x011e:
            r30 = r65
        L_0x0120:
            r31 = 1073741824(0x40000000, float:2.0)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x0129
            r31 = 0
            goto L_0x012b
        L_0x0129:
            r31 = r66
        L_0x012b:
            r32 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r32
            if (r0 == 0) goto L_0x0133
            r0 = 0
            goto L_0x0135
        L_0x0133:
            r0 = r67
        L_0x0135:
            r32 = r72 & 1
            if (r32 == 0) goto L_0x013c
            r32 = 0
            goto L_0x013e
        L_0x013c:
            r32 = r68
        L_0x013e:
            r33 = r72 & 2
            if (r33 == 0) goto L_0x0145
            r33 = 0
            goto L_0x0147
        L_0x0145:
            r33 = r69
        L_0x0147:
            r34 = r72 & 4
            if (r34 == 0) goto L_0x014e
            r34 = 0
            goto L_0x0150
        L_0x014e:
            r34 = r70
        L_0x0150:
            r36 = r35
            r37 = r1
            r38 = r3
            r39 = r4
            r40 = r5
            r41 = r6
            r42 = r7
            r43 = r8
            r44 = r9
            r45 = r10
            r46 = r11
            r47 = r12
            r48 = r13
            r49 = r14
            r50 = r15
            r51 = r2
            r52 = r16
            r53 = r17
            r54 = r18
            r55 = r19
            r56 = r20
            r57 = r21
            r58 = r22
            r59 = r23
            r60 = r24
            r61 = r25
            r62 = r26
            r63 = r27
            r64 = r28
            r65 = r29
            r66 = r30
            r67 = r31
            r68 = r0
            r69 = r32
            r70 = r33
            r71 = r34
            r36.<init>(r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.zeroswap.engine.model.KLineBean.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.r):void");
    }
}
