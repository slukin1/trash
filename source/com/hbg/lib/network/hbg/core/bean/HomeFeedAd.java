package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class HomeFeedAd {
    public int lastRefreshIndex = 0;
    @SerializedName("pageBannerList")
    private List<PageBannerListDTO> pageBannerList;

    public static class PageBannerListDTO {
        @SerializedName("bannerAdvList")
        private List<BannerAdvListDTO> bannerAdvList;
        @SerializedName("pageType")
        private Integer pageType;

        public static class BannerAdvListDTO {
            @SerializedName("advId")
            private Integer advId;
            @SerializedName("imageUrl")
            private String imageUrl;
            @SerializedName("jumpTo")
            private String jumpTo;
            @SerializedName("nightImageUrl")
            private String nightImageUrl;

            public boolean canEqual(Object obj) {
                return obj instanceof BannerAdvListDTO;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof BannerAdvListDTO)) {
                    return false;
                }
                BannerAdvListDTO bannerAdvListDTO = (BannerAdvListDTO) obj;
                if (!bannerAdvListDTO.canEqual(this)) {
                    return false;
                }
                Integer advId2 = getAdvId();
                Integer advId3 = bannerAdvListDTO.getAdvId();
                if (advId2 != null ? !advId2.equals(advId3) : advId3 != null) {
                    return false;
                }
                String imageUrl2 = getImageUrl();
                String imageUrl3 = bannerAdvListDTO.getImageUrl();
                if (imageUrl2 != null ? !imageUrl2.equals(imageUrl3) : imageUrl3 != null) {
                    return false;
                }
                String jumpTo2 = getJumpTo();
                String jumpTo3 = bannerAdvListDTO.getJumpTo();
                if (jumpTo2 != null ? !jumpTo2.equals(jumpTo3) : jumpTo3 != null) {
                    return false;
                }
                String nightImageUrl2 = getNightImageUrl();
                String nightImageUrl3 = bannerAdvListDTO.getNightImageUrl();
                return nightImageUrl2 != null ? nightImageUrl2.equals(nightImageUrl3) : nightImageUrl3 == null;
            }

            public Integer getAdvId() {
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

            public int hashCode() {
                Integer advId2 = getAdvId();
                int i11 = 43;
                int hashCode = advId2 == null ? 43 : advId2.hashCode();
                String imageUrl2 = getImageUrl();
                int hashCode2 = ((hashCode + 59) * 59) + (imageUrl2 == null ? 43 : imageUrl2.hashCode());
                String jumpTo2 = getJumpTo();
                int hashCode3 = (hashCode2 * 59) + (jumpTo2 == null ? 43 : jumpTo2.hashCode());
                String nightImageUrl2 = getNightImageUrl();
                int i12 = hashCode3 * 59;
                if (nightImageUrl2 != null) {
                    i11 = nightImageUrl2.hashCode();
                }
                return i12 + i11;
            }

            public void setAdvId(Integer num) {
                this.advId = num;
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

            public String toString() {
                return "HomeFeedAd.PageBannerListDTO.BannerAdvListDTO(advId=" + getAdvId() + ", imageUrl=" + getImageUrl() + ", jumpTo=" + getJumpTo() + ", nightImageUrl=" + getNightImageUrl() + ")";
            }
        }

        public boolean canEqual(Object obj) {
            return obj instanceof PageBannerListDTO;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PageBannerListDTO)) {
                return false;
            }
            PageBannerListDTO pageBannerListDTO = (PageBannerListDTO) obj;
            if (!pageBannerListDTO.canEqual(this)) {
                return false;
            }
            Integer pageType2 = getPageType();
            Integer pageType3 = pageBannerListDTO.getPageType();
            if (pageType2 != null ? !pageType2.equals(pageType3) : pageType3 != null) {
                return false;
            }
            List<BannerAdvListDTO> bannerAdvList2 = getBannerAdvList();
            List<BannerAdvListDTO> bannerAdvList3 = pageBannerListDTO.getBannerAdvList();
            return bannerAdvList2 != null ? bannerAdvList2.equals(bannerAdvList3) : bannerAdvList3 == null;
        }

        public List<BannerAdvListDTO> getBannerAdvList() {
            return this.bannerAdvList;
        }

        public Integer getPageType() {
            return this.pageType;
        }

        public int hashCode() {
            Integer pageType2 = getPageType();
            int i11 = 43;
            int hashCode = pageType2 == null ? 43 : pageType2.hashCode();
            List<BannerAdvListDTO> bannerAdvList2 = getBannerAdvList();
            int i12 = (hashCode + 59) * 59;
            if (bannerAdvList2 != null) {
                i11 = bannerAdvList2.hashCode();
            }
            return i12 + i11;
        }

        public void setBannerAdvList(List<BannerAdvListDTO> list) {
            this.bannerAdvList = list;
        }

        public void setPageType(Integer num) {
            this.pageType = num;
        }

        public String toString() {
            return "HomeFeedAd.PageBannerListDTO(pageType=" + getPageType() + ", bannerAdvList=" + getBannerAdvList() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof HomeFeedAd;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HomeFeedAd)) {
            return false;
        }
        HomeFeedAd homeFeedAd = (HomeFeedAd) obj;
        if (!homeFeedAd.canEqual(this)) {
            return false;
        }
        List<PageBannerListDTO> pageBannerList2 = getPageBannerList();
        List<PageBannerListDTO> pageBannerList3 = homeFeedAd.getPageBannerList();
        if (pageBannerList2 != null ? pageBannerList2.equals(pageBannerList3) : pageBannerList3 == null) {
            return getLastRefreshIndex() == homeFeedAd.getLastRefreshIndex();
        }
        return false;
    }

    public int getLastRefreshIndex() {
        return this.lastRefreshIndex;
    }

    public List<PageBannerListDTO> getPageBannerList() {
        return this.pageBannerList;
    }

    public int hashCode() {
        List<PageBannerListDTO> pageBannerList2 = getPageBannerList();
        return (((pageBannerList2 == null ? 43 : pageBannerList2.hashCode()) + 59) * 59) + getLastRefreshIndex();
    }

    public void setLastRefreshIndex(int i11) {
        this.lastRefreshIndex = i11;
    }

    public void setPageBannerList(List<PageBannerListDTO> list) {
        this.pageBannerList = list;
    }

    public String toString() {
        return "HomeFeedAd(pageBannerList=" + getPageBannerList() + ", lastRefreshIndex=" + getLastRefreshIndex() + ")";
    }
}
