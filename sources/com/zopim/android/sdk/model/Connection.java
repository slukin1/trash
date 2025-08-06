package com.zopim.android.sdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.huobi.points.entity.PointsPack;

public class Connection {
    @SerializedName("status$string")
    @Expose
    private String status;

    public enum Status {
        NO_CONNECTION("noConnection"),
        CLOSED(PointsPack.STATE_CLOSED),
        DISCONNECTED("disconnected"),
        CONNECTING("connecting"),
        CONNECTED("connected"),
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

    public Connection() {
    }

    public Status getStatus() {
        return Status.getStatus(this.status);
    }

    public String toString() {
        return this.status;
    }

    public Connection(Status status2) {
        this.status = status2.getValue();
    }
}
