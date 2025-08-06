package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class UserEmailBean implements Serializable {
    private String contactEmail;
    private boolean deleteStatus;
    private double gmtCreate;
    private double gmtUpdate;

    /* renamed from: id  reason: collision with root package name */
    private long f70595id;
    private long userId;

    public boolean canEqual(Object obj) {
        return obj instanceof UserEmailBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserEmailBean)) {
            return false;
        }
        UserEmailBean userEmailBean = (UserEmailBean) obj;
        if (!userEmailBean.canEqual(this) || getId() != userEmailBean.getId() || getUserId() != userEmailBean.getUserId()) {
            return false;
        }
        String contactEmail2 = getContactEmail();
        String contactEmail3 = userEmailBean.getContactEmail();
        if (contactEmail2 != null ? contactEmail2.equals(contactEmail3) : contactEmail3 == null) {
            return isDeleteStatus() == userEmailBean.isDeleteStatus() && Double.compare(getGmtUpdate(), userEmailBean.getGmtUpdate()) == 0 && Double.compare(getGmtCreate(), userEmailBean.getGmtCreate()) == 0;
        }
        return false;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public double getGmtCreate() {
        return this.gmtCreate;
    }

    public double getGmtUpdate() {
        return this.gmtUpdate;
    }

    public long getId() {
        return this.f70595id;
    }

    public long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        long id2 = getId();
        long userId2 = getUserId();
        int i11 = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + ((int) (userId2 ^ (userId2 >>> 32)));
        String contactEmail2 = getContactEmail();
        int hashCode = (((i11 * 59) + (contactEmail2 == null ? 43 : contactEmail2.hashCode())) * 59) + (isDeleteStatus() ? 79 : 97);
        long doubleToLongBits = Double.doubleToLongBits(getGmtUpdate());
        int i12 = (hashCode * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        long doubleToLongBits2 = Double.doubleToLongBits(getGmtCreate());
        return (i12 * 59) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public boolean isDeleteStatus() {
        return this.deleteStatus;
    }

    public void setContactEmail(String str) {
        this.contactEmail = str;
    }

    public void setDeleteStatus(boolean z11) {
        this.deleteStatus = z11;
    }

    public void setGmtCreate(double d11) {
        this.gmtCreate = d11;
    }

    public void setGmtUpdate(double d11) {
        this.gmtUpdate = d11;
    }

    public void setId(long j11) {
        this.f70595id = j11;
    }

    public void setUserId(long j11) {
        this.userId = j11;
    }

    public String toString() {
        return "UserEmailBean(id=" + getId() + ", userId=" + getUserId() + ", contactEmail=" + getContactEmail() + ", deleteStatus=" + isDeleteStatus() + ", gmtUpdate=" + getGmtUpdate() + ", gmtCreate=" + getGmtCreate() + ")";
    }
}
