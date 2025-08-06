package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class EtpRebalanceResult implements Serializable {
    public static final int POSITION_TYPE_SYSTEM_TIME = 1;
    public static final int POSITION_TYPE_SYSTEM_TIME_NO = 2;
    private static final long serialVersionUID = 2286285568057032391L;
    private List<BasketInfo> basketAfter;
    private List<BasketInfo> basketBefore;

    /* renamed from: id  reason: collision with root package name */
    private int f70237id;
    private String leverageAfter;
    private String leverageBefore;
    private int positionType;
    private long rebalanceTime;

    public boolean canEqual(Object obj) {
        return obj instanceof EtpRebalanceResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EtpRebalanceResult)) {
            return false;
        }
        EtpRebalanceResult etpRebalanceResult = (EtpRebalanceResult) obj;
        if (!etpRebalanceResult.canEqual(this) || getId() != etpRebalanceResult.getId() || getRebalanceTime() != etpRebalanceResult.getRebalanceTime()) {
            return false;
        }
        List<BasketInfo> basketBefore2 = getBasketBefore();
        List<BasketInfo> basketBefore3 = etpRebalanceResult.getBasketBefore();
        if (basketBefore2 != null ? !basketBefore2.equals(basketBefore3) : basketBefore3 != null) {
            return false;
        }
        List<BasketInfo> basketAfter2 = getBasketAfter();
        List<BasketInfo> basketAfter3 = etpRebalanceResult.getBasketAfter();
        if (basketAfter2 != null ? !basketAfter2.equals(basketAfter3) : basketAfter3 != null) {
            return false;
        }
        String leverageBefore2 = getLeverageBefore();
        String leverageBefore3 = etpRebalanceResult.getLeverageBefore();
        if (leverageBefore2 != null ? !leverageBefore2.equals(leverageBefore3) : leverageBefore3 != null) {
            return false;
        }
        String leverageAfter2 = getLeverageAfter();
        String leverageAfter3 = etpRebalanceResult.getLeverageAfter();
        if (leverageAfter2 != null ? leverageAfter2.equals(leverageAfter3) : leverageAfter3 == null) {
            return getPositionType() == etpRebalanceResult.getPositionType();
        }
        return false;
    }

    public List<BasketInfo> getBasketAfter() {
        return this.basketAfter;
    }

    public List<BasketInfo> getBasketBefore() {
        return this.basketBefore;
    }

    public int getId() {
        return this.f70237id;
    }

    public String getLeverageAfter() {
        return this.leverageAfter;
    }

    public String getLeverageBefore() {
        return this.leverageBefore;
    }

    public int getPositionType() {
        return this.positionType;
    }

    public long getRebalanceTime() {
        return this.rebalanceTime;
    }

    public int hashCode() {
        long rebalanceTime2 = getRebalanceTime();
        int id2 = ((getId() + 59) * 59) + ((int) (rebalanceTime2 ^ (rebalanceTime2 >>> 32)));
        List<BasketInfo> basketBefore2 = getBasketBefore();
        int i11 = 43;
        int hashCode = (id2 * 59) + (basketBefore2 == null ? 43 : basketBefore2.hashCode());
        List<BasketInfo> basketAfter2 = getBasketAfter();
        int hashCode2 = (hashCode * 59) + (basketAfter2 == null ? 43 : basketAfter2.hashCode());
        String leverageBefore2 = getLeverageBefore();
        int hashCode3 = (hashCode2 * 59) + (leverageBefore2 == null ? 43 : leverageBefore2.hashCode());
        String leverageAfter2 = getLeverageAfter();
        int i12 = hashCode3 * 59;
        if (leverageAfter2 != null) {
            i11 = leverageAfter2.hashCode();
        }
        return ((i12 + i11) * 59) + getPositionType();
    }

    public void setBasketAfter(List<BasketInfo> list) {
        this.basketAfter = list;
    }

    public void setBasketBefore(List<BasketInfo> list) {
        this.basketBefore = list;
    }

    public void setId(int i11) {
        this.f70237id = i11;
    }

    public void setLeverageAfter(String str) {
        this.leverageAfter = str;
    }

    public void setLeverageBefore(String str) {
        this.leverageBefore = str;
    }

    public void setPositionType(int i11) {
        this.positionType = i11;
    }

    public void setRebalanceTime(long j11) {
        this.rebalanceTime = j11;
    }

    public String toString() {
        return "EtpRebalanceResult(id=" + getId() + ", rebalanceTime=" + getRebalanceTime() + ", basketBefore=" + getBasketBefore() + ", basketAfter=" + getBasketAfter() + ", leverageBefore=" + getLeverageBefore() + ", leverageAfter=" + getLeverageAfter() + ", positionType=" + getPositionType() + ")";
    }
}
