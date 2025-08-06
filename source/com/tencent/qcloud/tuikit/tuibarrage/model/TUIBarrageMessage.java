package com.tencent.qcloud.tuikit.tuibarrage.model;

import com.google.gson.annotations.SerializedName;
import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.imsdk.v2.V2TIMMessage;
import java.util.Map;

public class TUIBarrageMessage {
    @SerializedName("businessID")
    public String businessID;
    @SerializedName("data")
    public Map<String, Object> data;
    @SerializedName("encrypt")
    public boolean encrypt;
    public String message;
    @SerializedName("platform")
    public String platform;
    public long sendTime;
    public String sender;
    public V2TIMMessage v2TIMMessage;
    @SerializedName("version")
    public String version;

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TUIBarrageJson{data=");
        Map<String, Object> map = this.data;
        sb2.append(map == null ? OptionsBridge.NULL_VALUE : map.toString());
        sb2.append(", platform='");
        sb2.append(this.platform);
        sb2.append('\'');
        sb2.append(", version='");
        sb2.append(this.version);
        sb2.append('\'');
        sb2.append(", businessID='");
        sb2.append(this.businessID);
        sb2.append('\'');
        sb2.append(", encrypt='");
        sb2.append(this.encrypt);
        sb2.append('\'');
        sb2.append('}');
        return sb2.toString();
    }
}
