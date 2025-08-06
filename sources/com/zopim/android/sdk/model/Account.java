package com.zopim.android.sdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.pro.core.bean.SymbolBean;

public class Account {
    @SerializedName("status$string")
    @Expose
    private String status;

    public enum Status {
        ONLINE(SymbolBean.ONLINE),
        OFFLINE(SymbolBean.OFFLINE),
        UNKNOWN("unknown");
        
        public final String value;

        private Status(String str) {
            this.value = str;
        }

        public static Status getStatus(String str) {
            for (Status status : values()) {
                if (status.getValue().equals(str)) {
                    return status;
                }
            }
            return UNKNOWN;
        }

        public String getValue() {
            return this.value;
        }
    }

    public Status getStatus() {
        return Status.getStatus(this.status);
    }
}
