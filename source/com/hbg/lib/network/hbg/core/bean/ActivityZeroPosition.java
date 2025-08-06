package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import kotlin.jvm.internal.x;

@Keep
public final class ActivityZeroPosition {
    private final Integer direction;
    private final String highestProfit;
    private final Integer leverageRatio;
    private final String openPrice;
    private final String positionAmount;
    private final String positionMargin;
    private final Object profitRate;
    private final String symbol;

    public ActivityZeroPosition(Integer num, String str, Integer num2, String str2, String str3, String str4, Object obj, String str5) {
        this.direction = num;
        this.highestProfit = str;
        this.leverageRatio = num2;
        this.openPrice = str2;
        this.positionAmount = str3;
        this.positionMargin = str4;
        this.profitRate = obj;
        this.symbol = str5;
    }

    public static /* synthetic */ ActivityZeroPosition copy$default(ActivityZeroPosition activityZeroPosition, Integer num, String str, Integer num2, String str2, String str3, String str4, Object obj, String str5, int i11, Object obj2) {
        ActivityZeroPosition activityZeroPosition2 = activityZeroPosition;
        int i12 = i11;
        return activityZeroPosition.copy((i12 & 1) != 0 ? activityZeroPosition2.direction : num, (i12 & 2) != 0 ? activityZeroPosition2.highestProfit : str, (i12 & 4) != 0 ? activityZeroPosition2.leverageRatio : num2, (i12 & 8) != 0 ? activityZeroPosition2.openPrice : str2, (i12 & 16) != 0 ? activityZeroPosition2.positionAmount : str3, (i12 & 32) != 0 ? activityZeroPosition2.positionMargin : str4, (i12 & 64) != 0 ? activityZeroPosition2.profitRate : obj, (i12 & 128) != 0 ? activityZeroPosition2.symbol : str5);
    }

    public final Integer component1() {
        return this.direction;
    }

    public final String component2() {
        return this.highestProfit;
    }

    public final Integer component3() {
        return this.leverageRatio;
    }

    public final String component4() {
        return this.openPrice;
    }

    public final String component5() {
        return this.positionAmount;
    }

    public final String component6() {
        return this.positionMargin;
    }

    public final Object component7() {
        return this.profitRate;
    }

    public final String component8() {
        return this.symbol;
    }

    public final ActivityZeroPosition copy(Integer num, String str, Integer num2, String str2, String str3, String str4, Object obj, String str5) {
        return new ActivityZeroPosition(num, str, num2, str2, str3, str4, obj, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityZeroPosition)) {
            return false;
        }
        ActivityZeroPosition activityZeroPosition = (ActivityZeroPosition) obj;
        return x.b(this.direction, activityZeroPosition.direction) && x.b(this.highestProfit, activityZeroPosition.highestProfit) && x.b(this.leverageRatio, activityZeroPosition.leverageRatio) && x.b(this.openPrice, activityZeroPosition.openPrice) && x.b(this.positionAmount, activityZeroPosition.positionAmount) && x.b(this.positionMargin, activityZeroPosition.positionMargin) && x.b(this.profitRate, activityZeroPosition.profitRate) && x.b(this.symbol, activityZeroPosition.symbol);
    }

    public final Integer getDirection() {
        return this.direction;
    }

    public final String getHighestProfit() {
        return this.highestProfit;
    }

    public final Integer getLeverageRatio() {
        return this.leverageRatio;
    }

    public final String getOpenPrice() {
        return this.openPrice;
    }

    public final String getPositionAmount() {
        return this.positionAmount;
    }

    public final String getPositionMargin() {
        return this.positionMargin;
    }

    public final Object getProfitRate() {
        return this.profitRate;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        Integer num = this.direction;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.highestProfit;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.leverageRatio;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.openPrice;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.positionAmount;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.positionMargin;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Object obj = this.profitRate;
        int hashCode7 = (hashCode6 + (obj == null ? 0 : obj.hashCode())) * 31;
        String str5 = this.symbol;
        if (str5 != null) {
            i11 = str5.hashCode();
        }
        return hashCode7 + i11;
    }

    public String toString() {
        return "ActivityZeroPosition(direction=" + this.direction + ", highestProfit=" + this.highestProfit + ", leverageRatio=" + this.leverageRatio + ", openPrice=" + this.openPrice + ", positionAmount=" + this.positionAmount + ", positionMargin=" + this.positionMargin + ", profitRate=" + this.profitRate + ", symbol=" + this.symbol + ')';
    }
}
