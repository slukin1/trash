package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
public class HomeFlowConfig implements Serializable {
    private int newHome;
    private int operPosition;
    private int porcelain;
    private int userGuide;

    public boolean canEqual(Object obj) {
        return obj instanceof HomeFlowConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HomeFlowConfig)) {
            return false;
        }
        HomeFlowConfig homeFlowConfig = (HomeFlowConfig) obj;
        return homeFlowConfig.canEqual(this) && getUserGuide() == homeFlowConfig.getUserGuide() && getPorcelain() == homeFlowConfig.getPorcelain() && getOperPosition() == homeFlowConfig.getOperPosition() && getNewHome() == homeFlowConfig.getNewHome();
    }

    public int getNewHome() {
        return this.newHome;
    }

    public int getOperPosition() {
        return this.operPosition;
    }

    public int getPorcelain() {
        return this.porcelain;
    }

    public int getUserGuide() {
        return this.userGuide;
    }

    public int hashCode() {
        return ((((((getUserGuide() + 59) * 59) + getPorcelain()) * 59) + getOperPosition()) * 59) + getNewHome();
    }

    public void setNewHome(int i11) {
        this.newHome = i11;
    }

    public void setOperPosition(int i11) {
        this.operPosition = i11;
    }

    public void setPorcelain(int i11) {
        this.porcelain = i11;
    }

    public void setUserGuide(int i11) {
        this.userGuide = i11;
    }

    public String toString() {
        return "HomeFlowConfig(userGuide=" + getUserGuide() + ", porcelain=" + getPorcelain() + ", operPosition=" + getOperPosition() + ", newHome=" + getNewHome() + ")";
    }
}
