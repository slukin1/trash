package com.huobi.entity;

import com.huobi.coupon.bean.Coupon;
import java.io.Serializable;

public class UserTransInfo implements Serializable {
    private static final long serialVersionUID = -7727294078723649554L;
    private String avatarUrl;
    private int instLevelType;
    private int instState;
    private boolean isInst;
    private String kycJumpChannel = Coupon.SPOT;
    private String kycStateLabel;
    private int kycStateWithNoStep;
    private String kycStep;
    private boolean showKycText;
    private String title;

    public boolean canEqual(Object obj) {
        return obj instanceof UserTransInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserTransInfo)) {
            return false;
        }
        UserTransInfo userTransInfo = (UserTransInfo) obj;
        if (!userTransInfo.canEqual(this)) {
            return false;
        }
        String title2 = getTitle();
        String title3 = userTransInfo.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String avatarUrl2 = getAvatarUrl();
        String avatarUrl3 = userTransInfo.getAvatarUrl();
        if (avatarUrl2 != null ? !avatarUrl2.equals(avatarUrl3) : avatarUrl3 != null) {
            return false;
        }
        if (isShowKycText() != userTransInfo.isShowKycText()) {
            return false;
        }
        String kycJumpChannel2 = getKycJumpChannel();
        String kycJumpChannel3 = userTransInfo.getKycJumpChannel();
        if (kycJumpChannel2 != null ? !kycJumpChannel2.equals(kycJumpChannel3) : kycJumpChannel3 != null) {
            return false;
        }
        String kycStateLabel2 = getKycStateLabel();
        String kycStateLabel3 = userTransInfo.getKycStateLabel();
        if (kycStateLabel2 != null ? !kycStateLabel2.equals(kycStateLabel3) : kycStateLabel3 != null) {
            return false;
        }
        String kycStep2 = getKycStep();
        String kycStep3 = userTransInfo.getKycStep();
        if (kycStep2 != null ? kycStep2.equals(kycStep3) : kycStep3 == null) {
            return getKycStateWithNoStep() == userTransInfo.getKycStateWithNoStep() && isInst() == userTransInfo.isInst() && getInstState() == userTransInfo.getInstState() && getInstLevelType() == userTransInfo.getInstLevelType();
        }
        return false;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public int getInstLevelType() {
        return this.instLevelType;
    }

    public int getInstState() {
        return this.instState;
    }

    public String getKycJumpChannel() {
        return this.kycJumpChannel;
    }

    public String getKycStateLabel() {
        return this.kycStateLabel;
    }

    public int getKycStateWithNoStep() {
        return this.kycStateWithNoStep;
    }

    public String getKycStep() {
        return this.kycStep;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String title2 = getTitle();
        int i11 = 43;
        int hashCode = title2 == null ? 43 : title2.hashCode();
        String avatarUrl2 = getAvatarUrl();
        int i12 = 79;
        int hashCode2 = ((((hashCode + 59) * 59) + (avatarUrl2 == null ? 43 : avatarUrl2.hashCode())) * 59) + (isShowKycText() ? 79 : 97);
        String kycJumpChannel2 = getKycJumpChannel();
        int hashCode3 = (hashCode2 * 59) + (kycJumpChannel2 == null ? 43 : kycJumpChannel2.hashCode());
        String kycStateLabel2 = getKycStateLabel();
        int hashCode4 = (hashCode3 * 59) + (kycStateLabel2 == null ? 43 : kycStateLabel2.hashCode());
        String kycStep2 = getKycStep();
        int i13 = hashCode4 * 59;
        if (kycStep2 != null) {
            i11 = kycStep2.hashCode();
        }
        int kycStateWithNoStep2 = (((i13 + i11) * 59) + getKycStateWithNoStep()) * 59;
        if (!isInst()) {
            i12 = 97;
        }
        return ((((kycStateWithNoStep2 + i12) * 59) + getInstState()) * 59) + getInstLevelType();
    }

    public boolean isInst() {
        return this.isInst;
    }

    public boolean isShowKycText() {
        return this.showKycText;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setInst(boolean z11) {
        this.isInst = z11;
    }

    public void setInstLevelType(int i11) {
        this.instLevelType = i11;
    }

    public void setInstState(int i11) {
        this.instState = i11;
    }

    public void setKycJumpChannel(String str) {
        this.kycJumpChannel = str;
    }

    public void setKycStateLabel(String str) {
        this.kycStateLabel = str;
    }

    public void setKycStateWithNoStep(int i11) {
        this.kycStateWithNoStep = i11;
    }

    public void setKycStep(String str) {
        this.kycStep = str;
    }

    public void setShowKycText(boolean z11) {
        this.showKycText = z11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "UserTransInfo(title=" + getTitle() + ", avatarUrl=" + getAvatarUrl() + ", showKycText=" + isShowKycText() + ", kycJumpChannel=" + getKycJumpChannel() + ", kycStateLabel=" + getKycStateLabel() + ", kycStep=" + getKycStep() + ", kycStateWithNoStep=" + getKycStateWithNoStep() + ", isInst=" + isInst() + ", instState=" + getInstState() + ", instLevelType=" + getInstLevelType() + ")";
    }
}
