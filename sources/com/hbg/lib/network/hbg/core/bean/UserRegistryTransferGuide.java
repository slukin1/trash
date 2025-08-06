package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
public class UserRegistryTransferGuide implements Serializable {
    private String introductionUrl;
    private String subTitle;
    private int taskProgress;
    private String title;
    private String totalAward;

    public boolean canEqual(Object obj) {
        return obj instanceof UserRegistryTransferGuide;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserRegistryTransferGuide)) {
            return false;
        }
        UserRegistryTransferGuide userRegistryTransferGuide = (UserRegistryTransferGuide) obj;
        if (!userRegistryTransferGuide.canEqual(this) || getTaskProgress() != userRegistryTransferGuide.getTaskProgress()) {
            return false;
        }
        String totalAward2 = getTotalAward();
        String totalAward3 = userRegistryTransferGuide.getTotalAward();
        if (totalAward2 != null ? !totalAward2.equals(totalAward3) : totalAward3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = userRegistryTransferGuide.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String subTitle2 = getSubTitle();
        String subTitle3 = userRegistryTransferGuide.getSubTitle();
        if (subTitle2 != null ? !subTitle2.equals(subTitle3) : subTitle3 != null) {
            return false;
        }
        String introductionUrl2 = getIntroductionUrl();
        String introductionUrl3 = userRegistryTransferGuide.getIntroductionUrl();
        return introductionUrl2 != null ? introductionUrl2.equals(introductionUrl3) : introductionUrl3 == null;
    }

    public String getIntroductionUrl() {
        return this.introductionUrl;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public int getTaskProgress() {
        return this.taskProgress;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTotalAward() {
        return this.totalAward;
    }

    public int hashCode() {
        String totalAward2 = getTotalAward();
        int i11 = 43;
        int taskProgress2 = ((getTaskProgress() + 59) * 59) + (totalAward2 == null ? 43 : totalAward2.hashCode());
        String title2 = getTitle();
        int hashCode = (taskProgress2 * 59) + (title2 == null ? 43 : title2.hashCode());
        String subTitle2 = getSubTitle();
        int hashCode2 = (hashCode * 59) + (subTitle2 == null ? 43 : subTitle2.hashCode());
        String introductionUrl2 = getIntroductionUrl();
        int i12 = hashCode2 * 59;
        if (introductionUrl2 != null) {
            i11 = introductionUrl2.hashCode();
        }
        return i12 + i11;
    }

    public void setIntroductionUrl(String str) {
        this.introductionUrl = str;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTaskProgress(int i11) {
        this.taskProgress = i11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTotalAward(String str) {
        this.totalAward = str;
    }

    public String toString() {
        return "UserRegistryTransferGuide(taskProgress=" + getTaskProgress() + ", totalAward=" + getTotalAward() + ", title=" + getTitle() + ", subTitle=" + getSubTitle() + ", introductionUrl=" + getIntroductionUrl() + ")";
    }
}
