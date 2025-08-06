package com.hbg.lib.network.newkyc.bean;

import java.io.Serializable;

public class ForceInfoNew implements Serializable {
    private boolean force_c2;
    private boolean force_supplement_data;
    private boolean force_video;
    private boolean recertification;

    public boolean isForce_c2() {
        return this.force_c2;
    }

    public boolean isForce_supplement_data() {
        return this.force_supplement_data;
    }

    public boolean isForce_video() {
        return this.force_video;
    }

    public boolean isRecertification() {
        return this.recertification;
    }

    public void setForce_c2(boolean z11) {
        this.force_c2 = z11;
    }

    public void setForce_supplement_data(boolean z11) {
        this.force_supplement_data = z11;
    }

    public void setForce_video(boolean z11) {
        this.force_video = z11;
    }

    public void setRecertification(boolean z11) {
        this.recertification = z11;
    }
}
