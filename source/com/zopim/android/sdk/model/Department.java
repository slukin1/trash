package com.zopim.android.sdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.pro.core.bean.SymbolBean;

public class Department {
    @SerializedName("name$string")
    @Expose
    public String name;
    @SerializedName("status$string")
    @Expose
    public String status;

    public enum Status {
        ONLINE(SymbolBean.ONLINE),
        OFFLINE(SymbolBean.OFFLINE),
        AWAY("away"),
        UNKNOWN("unknown");
        
        public final String status;

        private Status(String str) {
            this.status = str;
        }

        public static Status getStatus(String str) {
            for (Status status2 : values()) {
                if (status2.getValue().equals(str)) {
                    return status2;
                }
            }
            return UNKNOWN;
        }

        public String getValue() {
            return this.status;
        }
    }

    public String getName() {
        return this.name;
    }

    public Status getStatus() {
        return Status.getStatus(this.status);
    }

    public String toString() {
        return this.name + " (" + this.status + ")";
    }
}
