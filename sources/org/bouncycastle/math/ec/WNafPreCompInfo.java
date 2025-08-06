package org.bouncycastle.math.ec;

public class WNafPreCompInfo implements PreCompInfo {
    public int confWidth = -1;
    public ECPoint[] preComp = null;
    public ECPoint[] preCompNeg = null;
    public volatile int promotionCountdown = 4;
    public ECPoint twice = null;
    public int width = -1;

    public int decrementPromotionCountdown() {
        int i11 = this.promotionCountdown;
        if (i11 <= 0) {
            return i11;
        }
        int i12 = i11 - 1;
        this.promotionCountdown = i12;
        return i12;
    }

    public int getConfWidth() {
        return this.confWidth;
    }

    public ECPoint[] getPreComp() {
        return this.preComp;
    }

    public ECPoint[] getPreCompNeg() {
        return this.preCompNeg;
    }

    public int getPromotionCountdown() {
        return this.promotionCountdown;
    }

    public ECPoint getTwice() {
        return this.twice;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isPromoted() {
        return this.promotionCountdown <= 0;
    }

    public void setConfWidth(int i11) {
        this.confWidth = i11;
    }

    public void setPreComp(ECPoint[] eCPointArr) {
        this.preComp = eCPointArr;
    }

    public void setPreCompNeg(ECPoint[] eCPointArr) {
        this.preCompNeg = eCPointArr;
    }

    public void setPromotionCountdown(int i11) {
        this.promotionCountdown = i11;
    }

    public void setTwice(ECPoint eCPoint) {
        this.twice = eCPoint;
    }

    public void setWidth(int i11) {
        this.width = i11;
    }
}
