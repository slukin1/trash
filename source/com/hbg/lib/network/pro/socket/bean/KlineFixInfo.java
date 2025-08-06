package com.hbg.lib.network.pro.socket.bean;

import java.io.Serializable;

public class KlineFixInfo implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    public long f70629id;
    public Double target_high;
    public Double target_low;

    public String toString() {
        return "KlineFixInfo(id=" + this.f70629id + ", target_low=" + this.target_low + ", target_high=" + this.target_high + ")";
    }
}
