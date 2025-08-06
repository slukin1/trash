package com.tencent.imsdk.manager;

public class UserPreference {
    private boolean enableSignaling;

    public boolean getEnableSignaling() {
        return this.enableSignaling;
    }

    public void setEnableSignaling(Boolean bool) {
        this.enableSignaling = bool.booleanValue();
    }
}
