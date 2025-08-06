package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class AssetBannerData implements Serializable {
    private String activityName;
    private String headerPic;
    private String link;

    public boolean canEqual(Object obj) {
        return obj instanceof AssetBannerData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AssetBannerData)) {
            return false;
        }
        AssetBannerData assetBannerData = (AssetBannerData) obj;
        if (!assetBannerData.canEqual(this)) {
            return false;
        }
        String activityName2 = getActivityName();
        String activityName3 = assetBannerData.getActivityName();
        if (activityName2 != null ? !activityName2.equals(activityName3) : activityName3 != null) {
            return false;
        }
        String headerPic2 = getHeaderPic();
        String headerPic3 = assetBannerData.getHeaderPic();
        if (headerPic2 != null ? !headerPic2.equals(headerPic3) : headerPic3 != null) {
            return false;
        }
        String link2 = getLink();
        String link3 = assetBannerData.getLink();
        return link2 != null ? link2.equals(link3) : link3 == null;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public String getHeaderPic() {
        return this.headerPic;
    }

    public String getLink() {
        return this.link;
    }

    public int hashCode() {
        String activityName2 = getActivityName();
        int i11 = 43;
        int hashCode = activityName2 == null ? 43 : activityName2.hashCode();
        String headerPic2 = getHeaderPic();
        int hashCode2 = ((hashCode + 59) * 59) + (headerPic2 == null ? 43 : headerPic2.hashCode());
        String link2 = getLink();
        int i12 = hashCode2 * 59;
        if (link2 != null) {
            i11 = link2.hashCode();
        }
        return i12 + i11;
    }

    public void setActivityName(String str) {
        this.activityName = str;
    }

    public void setHeaderPic(String str) {
        this.headerPic = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public String toString() {
        return "AssetBannerData(activityName=" + getActivityName() + ", headerPic=" + getHeaderPic() + ", link=" + getLink() + ")";
    }
}
