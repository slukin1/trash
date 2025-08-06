package com.hbg.lib.network.otc.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class OtcSenior implements Serializable {
    private static final long serialVersionUID = 7857897301910311163L;
    @SerializedName("senior")
    private List<OtcSeniorInfo> senior;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcSenior;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcSenior)) {
            return false;
        }
        OtcSenior otcSenior = (OtcSenior) obj;
        if (!otcSenior.canEqual(this)) {
            return false;
        }
        List<OtcSeniorInfo> senior2 = getSenior();
        List<OtcSeniorInfo> senior3 = otcSenior.getSenior();
        return senior2 != null ? senior2.equals(senior3) : senior3 == null;
    }

    public List<OtcSeniorInfo> getSenior() {
        return this.senior;
    }

    public int hashCode() {
        List<OtcSeniorInfo> senior2 = getSenior();
        return 59 + (senior2 == null ? 43 : senior2.hashCode());
    }

    public void setSenior(List<OtcSeniorInfo> list) {
        this.senior = list;
    }

    public String toString() {
        return "OtcSenior(senior=" + getSenior() + ")";
    }
}
