package com.huobi.otcoption.bean;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class OtcOptionsDrawerInfoData {
    @SerializedName("symbols")

    /* renamed from: a  reason: collision with root package name */
    public List<OtcOptionsIndexData> f80205a = new ArrayList();

    public boolean a(Object obj) {
        return obj instanceof OtcOptionsDrawerInfoData;
    }

    public List<OtcOptionsIndexData> b() {
        return this.f80205a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcOptionsDrawerInfoData)) {
            return false;
        }
        OtcOptionsDrawerInfoData otcOptionsDrawerInfoData = (OtcOptionsDrawerInfoData) obj;
        if (!otcOptionsDrawerInfoData.a(this)) {
            return false;
        }
        List<OtcOptionsIndexData> b11 = b();
        List<OtcOptionsIndexData> b12 = otcOptionsDrawerInfoData.b();
        return b11 != null ? b11.equals(b12) : b12 == null;
    }

    public int hashCode() {
        List<OtcOptionsIndexData> b11 = b();
        return 59 + (b11 == null ? 43 : b11.hashCode());
    }

    public String toString() {
        return "OtcOptionsDrawerInfoData(symbols=" + b() + ")";
    }
}
