package com.hbg.lib.network.hbg.integration;

import java.io.Serializable;

public class IntegrationConfig implements Serializable {
    public boolean display;
    public Long integral;

    public boolean canEqual(Object obj) {
        return obj instanceof IntegrationConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntegrationConfig)) {
            return false;
        }
        IntegrationConfig integrationConfig = (IntegrationConfig) obj;
        if (!integrationConfig.canEqual(this) || isDisplay() != integrationConfig.isDisplay()) {
            return false;
        }
        Long integral2 = getIntegral();
        Long integral3 = integrationConfig.getIntegral();
        return integral2 != null ? integral2.equals(integral3) : integral3 == null;
    }

    public Long getIntegral() {
        return this.integral;
    }

    public int hashCode() {
        int i11 = isDisplay() ? 79 : 97;
        Long integral2 = getIntegral();
        return ((i11 + 59) * 59) + (integral2 == null ? 43 : integral2.hashCode());
    }

    public boolean isDisplay() {
        return this.display;
    }

    public void setDisplay(boolean z11) {
        this.display = z11;
    }

    public void setIntegral(Long l11) {
        this.integral = l11;
    }

    public String toString() {
        return "IntegrationConfig(display=" + isDisplay() + ", integral=" + getIntegral() + ")";
    }
}
