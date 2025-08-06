package com.xiaomi.mipush.sdk;

import com.iproov.sdk.bridge.OptionsBridge;
import com.xiaomi.push.service.module.PushChannelRegion;

public class PushConfiguration {
    private boolean mGeoEnable;
    private boolean mOpenCOSPush;
    private boolean mOpenFCMPush;
    private boolean mOpenFTOSPush;
    private boolean mOpenHmsPush;
    private PushChannelRegion mRegion;

    public static class PushConfigurationBuilder {
        private boolean mGeoEnable;
        /* access modifiers changed from: private */
        public boolean mOpenCOSPush;
        /* access modifiers changed from: private */
        public boolean mOpenFCMPush;
        /* access modifiers changed from: private */
        public boolean mOpenFTOSPush;
        /* access modifiers changed from: private */
        public boolean mOpenHmsPush;
        /* access modifiers changed from: private */
        public PushChannelRegion mRegion;

        public PushConfiguration build() {
            return new PushConfiguration(this);
        }

        public PushConfigurationBuilder openCOSPush(boolean z11) {
            this.mOpenCOSPush = z11;
            return this;
        }

        public PushConfigurationBuilder openFCMPush(boolean z11) {
            this.mOpenFCMPush = z11;
            return this;
        }

        public PushConfigurationBuilder openFTOSPush(boolean z11) {
            this.mOpenFTOSPush = z11;
            return this;
        }

        public PushConfigurationBuilder openHmsPush(boolean z11) {
            this.mOpenHmsPush = z11;
            return this;
        }

        public PushConfigurationBuilder region(PushChannelRegion pushChannelRegion) {
            this.mRegion = pushChannelRegion;
            return this;
        }
    }

    public boolean getOpenCOSPush() {
        return this.mOpenCOSPush;
    }

    public boolean getOpenFCMPush() {
        return this.mOpenFCMPush;
    }

    public boolean getOpenFTOSPush() {
        return this.mOpenFTOSPush;
    }

    public boolean getOpenHmsPush() {
        return this.mOpenHmsPush;
    }

    public PushChannelRegion getRegion() {
        return this.mRegion;
    }

    public void setOpenCOSPush(boolean z11) {
        this.mOpenCOSPush = z11;
    }

    public void setOpenFCMPush(boolean z11) {
        this.mOpenFCMPush = z11;
    }

    public void setOpenFTOSPush(boolean z11) {
        this.mOpenFTOSPush = z11;
    }

    public void setOpenHmsPush(boolean z11) {
        this.mOpenHmsPush = z11;
    }

    public void setRegion(PushChannelRegion pushChannelRegion) {
        this.mRegion = pushChannelRegion;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PushConfiguration{");
        stringBuffer.append("Region:");
        PushChannelRegion pushChannelRegion = this.mRegion;
        if (pushChannelRegion == null) {
            stringBuffer.append(OptionsBridge.NULL_VALUE);
        } else {
            stringBuffer.append(pushChannelRegion.name());
        }
        stringBuffer.append(",mOpenHmsPush:" + this.mOpenHmsPush);
        stringBuffer.append(",mOpenFCMPush:" + this.mOpenFCMPush);
        stringBuffer.append(",mOpenCOSPush:" + this.mOpenCOSPush);
        stringBuffer.append(",mOpenFTOSPush:" + this.mOpenFTOSPush);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public PushConfiguration() {
        this.mRegion = PushChannelRegion.China;
        this.mOpenHmsPush = false;
        this.mOpenFCMPush = false;
        this.mOpenCOSPush = false;
        this.mOpenFTOSPush = false;
    }

    private PushConfiguration(PushConfigurationBuilder pushConfigurationBuilder) {
        this.mRegion = pushConfigurationBuilder.mRegion == null ? PushChannelRegion.China : pushConfigurationBuilder.mRegion;
        this.mOpenHmsPush = pushConfigurationBuilder.mOpenHmsPush;
        this.mOpenFCMPush = pushConfigurationBuilder.mOpenFCMPush;
        this.mOpenCOSPush = pushConfigurationBuilder.mOpenCOSPush;
        this.mOpenFTOSPush = pushConfigurationBuilder.mOpenFTOSPush;
    }
}
