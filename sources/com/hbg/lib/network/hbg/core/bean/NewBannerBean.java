package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class NewBannerBean implements Serializable {
    private List<BannerAdv> bannerAdvList;

    public static class BannerAdv implements Serializable {
        private String advId;
        private String imageUrl;
        private String jumpTo;
        private String nightImageUrl;
        private String title;

        public boolean canEqual(Object obj) {
            return obj instanceof BannerAdv;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BannerAdv)) {
                return false;
            }
            BannerAdv bannerAdv = (BannerAdv) obj;
            if (!bannerAdv.canEqual(this)) {
                return false;
            }
            String advId2 = getAdvId();
            String advId3 = bannerAdv.getAdvId();
            if (advId2 != null ? !advId2.equals(advId3) : advId3 != null) {
                return false;
            }
            String title2 = getTitle();
            String title3 = bannerAdv.getTitle();
            if (title2 != null ? !title2.equals(title3) : title3 != null) {
                return false;
            }
            String imageUrl2 = getImageUrl();
            String imageUrl3 = bannerAdv.getImageUrl();
            if (imageUrl2 != null ? !imageUrl2.equals(imageUrl3) : imageUrl3 != null) {
                return false;
            }
            String nightImageUrl2 = getNightImageUrl();
            String nightImageUrl3 = bannerAdv.getNightImageUrl();
            if (nightImageUrl2 != null ? !nightImageUrl2.equals(nightImageUrl3) : nightImageUrl3 != null) {
                return false;
            }
            String jumpTo2 = getJumpTo();
            String jumpTo3 = bannerAdv.getJumpTo();
            return jumpTo2 != null ? jumpTo2.equals(jumpTo3) : jumpTo3 == null;
        }

        public String getAdvId() {
            return this.advId;
        }

        public String getImageUrl() {
            return this.imageUrl;
        }

        public String getJumpTo() {
            return this.jumpTo;
        }

        public String getNightImageUrl() {
            return this.nightImageUrl;
        }

        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String advId2 = getAdvId();
            int i11 = 43;
            int hashCode = advId2 == null ? 43 : advId2.hashCode();
            String title2 = getTitle();
            int hashCode2 = ((hashCode + 59) * 59) + (title2 == null ? 43 : title2.hashCode());
            String imageUrl2 = getImageUrl();
            int hashCode3 = (hashCode2 * 59) + (imageUrl2 == null ? 43 : imageUrl2.hashCode());
            String nightImageUrl2 = getNightImageUrl();
            int hashCode4 = (hashCode3 * 59) + (nightImageUrl2 == null ? 43 : nightImageUrl2.hashCode());
            String jumpTo2 = getJumpTo();
            int i12 = hashCode4 * 59;
            if (jumpTo2 != null) {
                i11 = jumpTo2.hashCode();
            }
            return i12 + i11;
        }

        public void setAdvId(String str) {
            this.advId = str;
        }

        public void setImageUrl(String str) {
            this.imageUrl = str;
        }

        public void setJumpTo(String str) {
            this.jumpTo = str;
        }

        public void setNightImageUrl(String str) {
            this.nightImageUrl = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String toString() {
            return "NewBannerBean.BannerAdv(advId=" + getAdvId() + ", title=" + getTitle() + ", imageUrl=" + getImageUrl() + ", nightImageUrl=" + getNightImageUrl() + ", jumpTo=" + getJumpTo() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof NewBannerBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NewBannerBean)) {
            return false;
        }
        NewBannerBean newBannerBean = (NewBannerBean) obj;
        if (!newBannerBean.canEqual(this)) {
            return false;
        }
        List<BannerAdv> bannerAdvList2 = getBannerAdvList();
        List<BannerAdv> bannerAdvList3 = newBannerBean.getBannerAdvList();
        return bannerAdvList2 != null ? bannerAdvList2.equals(bannerAdvList3) : bannerAdvList3 == null;
    }

    public List<BannerAdv> getBannerAdvList() {
        return this.bannerAdvList;
    }

    public int hashCode() {
        List<BannerAdv> bannerAdvList2 = getBannerAdvList();
        return 59 + (bannerAdvList2 == null ? 43 : bannerAdvList2.hashCode());
    }

    public void setBannerAdvList(List<BannerAdv> list) {
        this.bannerAdvList = list;
    }

    public String toString() {
        return "NewBannerBean(bannerAdvList=" + getBannerAdvList() + ")";
    }
}
