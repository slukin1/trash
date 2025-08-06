package com.huobi.coupon.bean;

import java.io.Serializable;

public class CouponBannerInfo implements Serializable {
    private static final long serialVersionUID = -6610240768155825289L;
    private String pictureUrl;
    private String title;
    private String titleExt;

    public boolean canEqual(Object obj) {
        return obj instanceof CouponBannerInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CouponBannerInfo)) {
            return false;
        }
        CouponBannerInfo couponBannerInfo = (CouponBannerInfo) obj;
        if (!couponBannerInfo.canEqual(this)) {
            return false;
        }
        String pictureUrl2 = getPictureUrl();
        String pictureUrl3 = couponBannerInfo.getPictureUrl();
        if (pictureUrl2 != null ? !pictureUrl2.equals(pictureUrl3) : pictureUrl3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = couponBannerInfo.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String titleExt2 = getTitleExt();
        String titleExt3 = couponBannerInfo.getTitleExt();
        return titleExt2 != null ? titleExt2.equals(titleExt3) : titleExt3 == null;
    }

    public String getPictureUrl() {
        return this.pictureUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitleExt() {
        return this.titleExt;
    }

    public int hashCode() {
        String pictureUrl2 = getPictureUrl();
        int i11 = 43;
        int hashCode = pictureUrl2 == null ? 43 : pictureUrl2.hashCode();
        String title2 = getTitle();
        int hashCode2 = ((hashCode + 59) * 59) + (title2 == null ? 43 : title2.hashCode());
        String titleExt2 = getTitleExt();
        int i12 = hashCode2 * 59;
        if (titleExt2 != null) {
            i11 = titleExt2.hashCode();
        }
        return i12 + i11;
    }

    public void setPictureUrl(String str) {
        this.pictureUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTitleExt(String str) {
        this.titleExt = str;
    }

    public String toString() {
        return "CouponBannerInfo(pictureUrl=" + getPictureUrl() + ", title=" + getTitle() + ", titleExt=" + getTitleExt() + ")";
    }
}
