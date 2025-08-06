package com.hbg.component.kline.draw.bean;

import java.io.Serializable;

public class KlineDrawPointBean implements Serializable {
    private static final long serialVersionUID = 48282419874452571L;

    /* renamed from: x  reason: collision with root package name */
    private long f67193x;

    /* renamed from: y  reason: collision with root package name */
    private float f67194y;

    public boolean canEqual(Object obj) {
        return obj instanceof KlineDrawPointBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KlineDrawPointBean)) {
            return false;
        }
        KlineDrawPointBean klineDrawPointBean = (KlineDrawPointBean) obj;
        return klineDrawPointBean.canEqual(this) && getX() == klineDrawPointBean.getX() && Float.compare(getY(), klineDrawPointBean.getY()) == 0;
    }

    public long getX() {
        return this.f67193x;
    }

    public float getY() {
        return this.f67194y;
    }

    public int hashCode() {
        long x11 = getX();
        return ((((int) (x11 ^ (x11 >>> 32))) + 59) * 59) + Float.floatToIntBits(getY());
    }

    public void setX(long j11) {
        this.f67193x = j11;
    }

    public void setY(float f11) {
        this.f67194y = f11;
    }

    public String toString() {
        return "KlineDrawPointBean(x=" + getX() + ", y=" + getY() + ")";
    }
}
