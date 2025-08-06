package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class UserInvalidCoupon implements Serializable {
    private boolean soonInvalid;

    public boolean canEqual(Object obj) {
        return obj instanceof UserInvalidCoupon;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserInvalidCoupon)) {
            return false;
        }
        UserInvalidCoupon userInvalidCoupon = (UserInvalidCoupon) obj;
        return userInvalidCoupon.canEqual(this) && isSoonInvalid() == userInvalidCoupon.isSoonInvalid();
    }

    public int hashCode() {
        return 59 + (isSoonInvalid() ? 79 : 97);
    }

    public boolean isSoonInvalid() {
        return this.soonInvalid;
    }

    public void setSoonInvalid(boolean z11) {
        this.soonInvalid = z11;
    }

    public String toString() {
        return "UserInvalidCoupon(soonInvalid=" + isSoonInvalid() + ")";
    }
}
