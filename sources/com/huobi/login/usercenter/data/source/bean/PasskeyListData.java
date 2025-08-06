package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class PasskeyListData implements Serializable {
    @SerializedName("device_bind_pass_key")
    private int bind;
    private List<Passkey> keys;

    public static class Passkey implements Serializable {
        @SerializedName("create_time")
        private long createTime;
        @SerializedName("pass_key_id")

        /* renamed from: id  reason: collision with root package name */
        private String f75651id;
        @SerializedName("last_use_time")
        private long lastUseTime;
        @SerializedName("platform_type")
        private String platformType;
        private String remark;

        public long getCreateTime() {
            return this.createTime;
        }

        public String getId() {
            return this.f75651id;
        }

        public long getLastUseTime() {
            return this.lastUseTime;
        }

        public String getPlatformType() {
            return this.platformType;
        }

        public String getRemark() {
            return this.remark;
        }
    }

    public int getBind() {
        return this.bind;
    }

    public List<Passkey> getKeys() {
        return this.keys;
    }
}
