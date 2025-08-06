package com.hbg.module.huobi.im.group.ui.active;

import java.io.Serializable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class LiveRewardsData implements Serializable {
    private RewardsAnim animArr;
    private int eventType;
    private int giftPanelHeight;
    private Double integral;
    private RewardsLocation location;

    public LiveRewardsData(int i11, Double d11, int i12, RewardsAnim rewardsAnim, RewardsLocation rewardsLocation) {
        this.eventType = i11;
        this.integral = d11;
        this.giftPanelHeight = i12;
        this.animArr = rewardsAnim;
        this.location = rewardsLocation;
    }

    public static /* synthetic */ LiveRewardsData copy$default(LiveRewardsData liveRewardsData, int i11, Double d11, int i12, RewardsAnim rewardsAnim, RewardsLocation rewardsLocation, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = liveRewardsData.eventType;
        }
        if ((i13 & 2) != 0) {
            d11 = liveRewardsData.integral;
        }
        Double d12 = d11;
        if ((i13 & 4) != 0) {
            i12 = liveRewardsData.giftPanelHeight;
        }
        int i14 = i12;
        if ((i13 & 8) != 0) {
            rewardsAnim = liveRewardsData.animArr;
        }
        RewardsAnim rewardsAnim2 = rewardsAnim;
        if ((i13 & 16) != 0) {
            rewardsLocation = liveRewardsData.location;
        }
        return liveRewardsData.copy(i11, d12, i14, rewardsAnim2, rewardsLocation);
    }

    public final int component1() {
        return this.eventType;
    }

    public final Double component2() {
        return this.integral;
    }

    public final int component3() {
        return this.giftPanelHeight;
    }

    public final RewardsAnim component4() {
        return this.animArr;
    }

    public final RewardsLocation component5() {
        return this.location;
    }

    public final LiveRewardsData copy(int i11, Double d11, int i12, RewardsAnim rewardsAnim, RewardsLocation rewardsLocation) {
        return new LiveRewardsData(i11, d11, i12, rewardsAnim, rewardsLocation);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveRewardsData)) {
            return false;
        }
        LiveRewardsData liveRewardsData = (LiveRewardsData) obj;
        return this.eventType == liveRewardsData.eventType && x.b(this.integral, liveRewardsData.integral) && this.giftPanelHeight == liveRewardsData.giftPanelHeight && x.b(this.animArr, liveRewardsData.animArr) && x.b(this.location, liveRewardsData.location);
    }

    public final RewardsAnim getAnimArr() {
        return this.animArr;
    }

    public final int getEventType() {
        return this.eventType;
    }

    public final int getGiftPanelHeight() {
        return this.giftPanelHeight;
    }

    public final Double getIntegral() {
        return this.integral;
    }

    public final RewardsLocation getLocation() {
        return this.location;
    }

    public int hashCode() {
        int i11 = this.eventType * 31;
        Double d11 = this.integral;
        int i12 = 0;
        int hashCode = (((i11 + (d11 == null ? 0 : d11.hashCode())) * 31) + this.giftPanelHeight) * 31;
        RewardsAnim rewardsAnim = this.animArr;
        int hashCode2 = (hashCode + (rewardsAnim == null ? 0 : rewardsAnim.hashCode())) * 31;
        RewardsLocation rewardsLocation = this.location;
        if (rewardsLocation != null) {
            i12 = rewardsLocation.hashCode();
        }
        return hashCode2 + i12;
    }

    public final void setAnimArr(RewardsAnim rewardsAnim) {
        this.animArr = rewardsAnim;
    }

    public final void setEventType(int i11) {
        this.eventType = i11;
    }

    public final void setGiftPanelHeight(int i11) {
        this.giftPanelHeight = i11;
    }

    public final void setIntegral(Double d11) {
        this.integral = d11;
    }

    public final void setLocation(RewardsLocation rewardsLocation) {
        this.location = rewardsLocation;
    }

    public String toString() {
        return "LiveRewardsData(eventType=" + this.eventType + ", integral=" + this.integral + ", giftPanelHeight=" + this.giftPanelHeight + ", animArr=" + this.animArr + ", location=" + this.location + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LiveRewardsData(int i11, Double d11, int i12, RewardsAnim rewardsAnim, RewardsLocation rewardsLocation, int i13, r rVar) {
        this(i11, (i13 & 2) != 0 ? Double.valueOf(0.0d) : d11, (i13 & 4) != 0 ? 0 : i12, (i13 & 8) != 0 ? null : rewardsAnim, (i13 & 16) != 0 ? null : rewardsLocation);
    }
}
