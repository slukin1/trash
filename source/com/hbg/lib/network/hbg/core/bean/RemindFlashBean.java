package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class RemindFlashBean implements Serializable {
    private String coin;
    private String content;
    private int direction;

    /* renamed from: id  reason: collision with root package name */
    private long f70266id;
    private String pairId;
    private String strategyName;
    private String symbol;
    private String title;

    /* renamed from: ts  reason: collision with root package name */
    private long f70267ts;

    public boolean canEqual(Object obj) {
        return obj instanceof RemindFlashBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemindFlashBean)) {
            return false;
        }
        RemindFlashBean remindFlashBean = (RemindFlashBean) obj;
        if (!remindFlashBean.canEqual(this) || getId() != remindFlashBean.getId() || getTs() != remindFlashBean.getTs()) {
            return false;
        }
        String pairId2 = getPairId();
        String pairId3 = remindFlashBean.getPairId();
        if (pairId2 != null ? !pairId2.equals(pairId3) : pairId3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = remindFlashBean.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        if (getDirection() != remindFlashBean.getDirection()) {
            return false;
        }
        String strategyName2 = getStrategyName();
        String strategyName3 = remindFlashBean.getStrategyName();
        if (strategyName2 != null ? !strategyName2.equals(strategyName3) : strategyName3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = remindFlashBean.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String content2 = getContent();
        String content3 = remindFlashBean.getContent();
        if (content2 != null ? !content2.equals(content3) : content3 != null) {
            return false;
        }
        String coin2 = getCoin();
        String coin3 = remindFlashBean.getCoin();
        return coin2 != null ? coin2.equals(coin3) : coin3 == null;
    }

    public String getCoin() {
        return this.coin;
    }

    public String getContent() {
        return this.content;
    }

    public int getDirection() {
        return this.direction;
    }

    public long getId() {
        return this.f70266id;
    }

    public String getPairId() {
        return this.pairId;
    }

    public String getStrategyName() {
        return this.strategyName;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTitle() {
        return this.title;
    }

    public long getTs() {
        return this.f70267ts;
    }

    public int hashCode() {
        long id2 = getId();
        long ts2 = getTs();
        String pairId2 = getPairId();
        int i11 = (((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + ((int) ((ts2 >>> 32) ^ ts2))) * 59;
        int i12 = 43;
        int hashCode = i11 + (pairId2 == null ? 43 : pairId2.hashCode());
        String symbol2 = getSymbol();
        int hashCode2 = (((hashCode * 59) + (symbol2 == null ? 43 : symbol2.hashCode())) * 59) + getDirection();
        String strategyName2 = getStrategyName();
        int hashCode3 = (hashCode2 * 59) + (strategyName2 == null ? 43 : strategyName2.hashCode());
        String title2 = getTitle();
        int hashCode4 = (hashCode3 * 59) + (title2 == null ? 43 : title2.hashCode());
        String content2 = getContent();
        int hashCode5 = (hashCode4 * 59) + (content2 == null ? 43 : content2.hashCode());
        String coin2 = getCoin();
        int i13 = hashCode5 * 59;
        if (coin2 != null) {
            i12 = coin2.hashCode();
        }
        return i13 + i12;
    }

    public void setCoin(String str) {
        this.coin = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDirection(int i11) {
        this.direction = i11;
    }

    public void setId(long j11) {
        this.f70266id = j11;
    }

    public void setPairId(String str) {
        this.pairId = str;
    }

    public void setStrategyName(String str) {
        this.strategyName = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTs(long j11) {
        this.f70267ts = j11;
    }

    public String toString() {
        return "RemindFlashBean(id=" + getId() + ", ts=" + getTs() + ", pairId=" + getPairId() + ", symbol=" + getSymbol() + ", direction=" + getDirection() + ", strategyName=" + getStrategyName() + ", title=" + getTitle() + ", content=" + getContent() + ", coin=" + getCoin() + ")";
    }
}
