package com.huobi.view.realline;

import java.io.Serializable;

public class RealLineBean implements Serializable {
    private double amount;

    /* renamed from: id  reason: collision with root package name */
    private long f19102id;

    public double getAmount() {
        return this.amount;
    }

    public long getId() {
        return this.f19102id;
    }

    public void setAmount(double d11) {
        this.amount = d11;
    }

    public void setId(long j11) {
        this.f19102id = j11;
    }
}
