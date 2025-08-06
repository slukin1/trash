package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class CurrencyIntroInfo implements Serializable {
    private String auditReportUrl;
    @SerializedName("blockQuery")
    private String blockQuery;
    @SerializedName("circulateMarketValueRemark")
    private String circulateMarketValueRemark;
    @SerializedName("circulateVolume")
    private String circulateVolume;
    @SerializedName("circulateVolumeRemark")
    private String circulateVolumeRemark;
    @SerializedName("content")
    private String content;
    @SerializedName("createdAt")
    private long createdAt;
    @SerializedName("crowdfundingPrice")
    private String crowdfundingPrice;
    @SerializedName("currency")
    private String currency;
    @SerializedName("currencyUnlock")
    private List<CurrencyUnlock> currencyUnlock;
    @SerializedName("currentPrice")
    private String currentPrice;
    @SerializedName("facebook")
    private String facebook;
    @SerializedName("fullName")
    private String fullName;
    @SerializedName("github")
    private String github;
    @SerializedName("introduction")
    private String introduction;
    @SerializedName("investorPriceRemark")
    private String investorPriceRemark;
    @SerializedName("language")
    private String language;
    @SerializedName("maxPrice")
    private String maxPrice;
    @SerializedName("maxPriceRemark")
    private String maxPriceRemark;
    @SerializedName("medium")
    private String medium;
    @SerializedName("minPrice")
    private String minPrice;
    @SerializedName("minPriceRemark")
    private String minPriceRemark;
    @SerializedName("officialWebsite")
    private String officialWebsite;
    @SerializedName("publishTime")
    private String publishTime;
    @SerializedName("publishTimeRemark")
    private String publishTimeRemark;
    @SerializedName("publishVolume")
    private String publishVolume;
    @SerializedName("publishVolumeRemark")
    private String publishVolumeRemark;
    @SerializedName("rank")
    private String rank;
    @SerializedName("rankRemark")
    private String rankRemark;
    @SerializedName("show")
    private int show;
    @SerializedName("sort")
    private int sort;
    @SerializedName("summary")
    private String summary;
    @SerializedName("telegram")
    private String telegram;
    @SerializedName("totalMarketValueRemark")
    private String totalMarketValueRemark;
    @SerializedName("twitter")
    private String twitter;
    @SerializedName("updatedAt")
    private long updatedAt;
    @SerializedName("whitePaper")
    private String whitePaper;

    public static class CurrencyUnlock implements Serializable {
        @SerializedName("name")
        private String name;
        @SerializedName("percent")
        private String percent;
        @SerializedName("time")
        private String time;

        public boolean canEqual(Object obj) {
            return obj instanceof CurrencyUnlock;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CurrencyUnlock)) {
                return false;
            }
            CurrencyUnlock currencyUnlock = (CurrencyUnlock) obj;
            if (!currencyUnlock.canEqual(this)) {
                return false;
            }
            String name2 = getName();
            String name3 = currencyUnlock.getName();
            if (name2 != null ? !name2.equals(name3) : name3 != null) {
                return false;
            }
            String percent2 = getPercent();
            String percent3 = currencyUnlock.getPercent();
            if (percent2 != null ? !percent2.equals(percent3) : percent3 != null) {
                return false;
            }
            String time2 = getTime();
            String time3 = currencyUnlock.getTime();
            return time2 != null ? time2.equals(time3) : time3 == null;
        }

        public String getName() {
            return this.name;
        }

        public String getPercent() {
            return this.percent;
        }

        public String getTime() {
            return this.time;
        }

        public int hashCode() {
            String name2 = getName();
            int i11 = 43;
            int hashCode = name2 == null ? 43 : name2.hashCode();
            String percent2 = getPercent();
            int hashCode2 = ((hashCode + 59) * 59) + (percent2 == null ? 43 : percent2.hashCode());
            String time2 = getTime();
            int i12 = hashCode2 * 59;
            if (time2 != null) {
                i11 = time2.hashCode();
            }
            return i12 + i11;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPercent(String str) {
            this.percent = str;
        }

        public void setTime(String str) {
            this.time = str;
        }

        public String toString() {
            return "CurrencyIntroInfo.CurrencyUnlock(name=" + getName() + ", percent=" + getPercent() + ", time=" + getTime() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof CurrencyIntroInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrencyIntroInfo)) {
            return false;
        }
        CurrencyIntroInfo currencyIntroInfo = (CurrencyIntroInfo) obj;
        if (!currencyIntroInfo.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = currencyIntroInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String language2 = getLanguage();
        String language3 = currencyIntroInfo.getLanguage();
        if (language2 != null ? !language2.equals(language3) : language3 != null) {
            return false;
        }
        String fullName2 = getFullName();
        String fullName3 = currencyIntroInfo.getFullName();
        if (fullName2 != null ? !fullName2.equals(fullName3) : fullName3 != null) {
            return false;
        }
        if (getShow() != currencyIntroInfo.getShow() || getSort() != currencyIntroInfo.getSort()) {
            return false;
        }
        String currentPrice2 = getCurrentPrice();
        String currentPrice3 = currencyIntroInfo.getCurrentPrice();
        if (currentPrice2 != null ? !currentPrice2.equals(currentPrice3) : currentPrice3 != null) {
            return false;
        }
        String rank2 = getRank();
        String rank3 = currencyIntroInfo.getRank();
        if (rank2 != null ? !rank2.equals(rank3) : rank3 != null) {
            return false;
        }
        String rankRemark2 = getRankRemark();
        String rankRemark3 = currencyIntroInfo.getRankRemark();
        if (rankRemark2 != null ? !rankRemark2.equals(rankRemark3) : rankRemark3 != null) {
            return false;
        }
        String summary2 = getSummary();
        String summary3 = currencyIntroInfo.getSummary();
        if (summary2 != null ? !summary2.equals(summary3) : summary3 != null) {
            return false;
        }
        String introduction2 = getIntroduction();
        String introduction3 = currencyIntroInfo.getIntroduction();
        if (introduction2 != null ? !introduction2.equals(introduction3) : introduction3 != null) {
            return false;
        }
        String publishTime2 = getPublishTime();
        String publishTime3 = currencyIntroInfo.getPublishTime();
        if (publishTime2 != null ? !publishTime2.equals(publishTime3) : publishTime3 != null) {
            return false;
        }
        String publishTimeRemark2 = getPublishTimeRemark();
        String publishTimeRemark3 = currencyIntroInfo.getPublishTimeRemark();
        if (publishTimeRemark2 != null ? !publishTimeRemark2.equals(publishTimeRemark3) : publishTimeRemark3 != null) {
            return false;
        }
        String publishVolume2 = getPublishVolume();
        String publishVolume3 = currencyIntroInfo.getPublishVolume();
        if (publishVolume2 != null ? !publishVolume2.equals(publishVolume3) : publishVolume3 != null) {
            return false;
        }
        String publishVolumeRemark2 = getPublishVolumeRemark();
        String publishVolumeRemark3 = currencyIntroInfo.getPublishVolumeRemark();
        if (publishVolumeRemark2 != null ? !publishVolumeRemark2.equals(publishVolumeRemark3) : publishVolumeRemark3 != null) {
            return false;
        }
        String circulateVolume2 = getCirculateVolume();
        String circulateVolume3 = currencyIntroInfo.getCirculateVolume();
        if (circulateVolume2 != null ? !circulateVolume2.equals(circulateVolume3) : circulateVolume3 != null) {
            return false;
        }
        String circulateVolumeRemark2 = getCirculateVolumeRemark();
        String circulateVolumeRemark3 = currencyIntroInfo.getCirculateVolumeRemark();
        if (circulateVolumeRemark2 != null ? !circulateVolumeRemark2.equals(circulateVolumeRemark3) : circulateVolumeRemark3 != null) {
            return false;
        }
        String totalMarketValueRemark2 = getTotalMarketValueRemark();
        String totalMarketValueRemark3 = currencyIntroInfo.getTotalMarketValueRemark();
        if (totalMarketValueRemark2 != null ? !totalMarketValueRemark2.equals(totalMarketValueRemark3) : totalMarketValueRemark3 != null) {
            return false;
        }
        String circulateMarketValueRemark2 = getCirculateMarketValueRemark();
        String circulateMarketValueRemark3 = currencyIntroInfo.getCirculateMarketValueRemark();
        if (circulateMarketValueRemark2 != null ? !circulateMarketValueRemark2.equals(circulateMarketValueRemark3) : circulateMarketValueRemark3 != null) {
            return false;
        }
        String investorPriceRemark2 = getInvestorPriceRemark();
        String investorPriceRemark3 = currencyIntroInfo.getInvestorPriceRemark();
        if (investorPriceRemark2 != null ? !investorPriceRemark2.equals(investorPriceRemark3) : investorPriceRemark3 != null) {
            return false;
        }
        String crowdfundingPrice2 = getCrowdfundingPrice();
        String crowdfundingPrice3 = currencyIntroInfo.getCrowdfundingPrice();
        if (crowdfundingPrice2 != null ? !crowdfundingPrice2.equals(crowdfundingPrice3) : crowdfundingPrice3 != null) {
            return false;
        }
        String content2 = getContent();
        String content3 = currencyIntroInfo.getContent();
        if (content2 != null ? !content2.equals(content3) : content3 != null) {
            return false;
        }
        String whitePaper2 = getWhitePaper();
        String whitePaper3 = currencyIntroInfo.getWhitePaper();
        if (whitePaper2 != null ? !whitePaper2.equals(whitePaper3) : whitePaper3 != null) {
            return false;
        }
        String officialWebsite2 = getOfficialWebsite();
        String officialWebsite3 = currencyIntroInfo.getOfficialWebsite();
        if (officialWebsite2 != null ? !officialWebsite2.equals(officialWebsite3) : officialWebsite3 != null) {
            return false;
        }
        String auditReportUrl2 = getAuditReportUrl();
        String auditReportUrl3 = currencyIntroInfo.getAuditReportUrl();
        if (auditReportUrl2 != null ? !auditReportUrl2.equals(auditReportUrl3) : auditReportUrl3 != null) {
            return false;
        }
        String blockQuery2 = getBlockQuery();
        String blockQuery3 = currencyIntroInfo.getBlockQuery();
        if (blockQuery2 != null ? !blockQuery2.equals(blockQuery3) : blockQuery3 != null) {
            return false;
        }
        String github2 = getGithub();
        String github3 = currencyIntroInfo.getGithub();
        if (github2 != null ? !github2.equals(github3) : github3 != null) {
            return false;
        }
        String twitter2 = getTwitter();
        String twitter3 = currencyIntroInfo.getTwitter();
        if (twitter2 != null ? !twitter2.equals(twitter3) : twitter3 != null) {
            return false;
        }
        String medium2 = getMedium();
        String medium3 = currencyIntroInfo.getMedium();
        if (medium2 != null ? !medium2.equals(medium3) : medium3 != null) {
            return false;
        }
        String telegram2 = getTelegram();
        String telegram3 = currencyIntroInfo.getTelegram();
        if (telegram2 != null ? !telegram2.equals(telegram3) : telegram3 != null) {
            return false;
        }
        String facebook2 = getFacebook();
        String facebook3 = currencyIntroInfo.getFacebook();
        if (facebook2 != null ? !facebook2.equals(facebook3) : facebook3 != null) {
            return false;
        }
        if (getCreatedAt() != currencyIntroInfo.getCreatedAt() || getUpdatedAt() != currencyIntroInfo.getUpdatedAt()) {
            return false;
        }
        String maxPrice2 = getMaxPrice();
        String maxPrice3 = currencyIntroInfo.getMaxPrice();
        if (maxPrice2 != null ? !maxPrice2.equals(maxPrice3) : maxPrice3 != null) {
            return false;
        }
        String maxPriceRemark2 = getMaxPriceRemark();
        String maxPriceRemark3 = currencyIntroInfo.getMaxPriceRemark();
        if (maxPriceRemark2 != null ? !maxPriceRemark2.equals(maxPriceRemark3) : maxPriceRemark3 != null) {
            return false;
        }
        String minPrice2 = getMinPrice();
        String minPrice3 = currencyIntroInfo.getMinPrice();
        if (minPrice2 != null ? !minPrice2.equals(minPrice3) : minPrice3 != null) {
            return false;
        }
        String minPriceRemark2 = getMinPriceRemark();
        String minPriceRemark3 = currencyIntroInfo.getMinPriceRemark();
        if (minPriceRemark2 != null ? !minPriceRemark2.equals(minPriceRemark3) : minPriceRemark3 != null) {
            return false;
        }
        List<CurrencyUnlock> currencyUnlock2 = getCurrencyUnlock();
        List<CurrencyUnlock> currencyUnlock3 = currencyIntroInfo.getCurrencyUnlock();
        return currencyUnlock2 != null ? currencyUnlock2.equals(currencyUnlock3) : currencyUnlock3 == null;
    }

    public String getAuditReportUrl() {
        return this.auditReportUrl;
    }

    public String getBlockQuery() {
        return this.blockQuery;
    }

    public String getCirculateMarketValueRemark() {
        return this.circulateMarketValueRemark;
    }

    public String getCirculateVolume() {
        return this.circulateVolume;
    }

    public String getCirculateVolumeRemark() {
        return this.circulateVolumeRemark;
    }

    public String getContent() {
        return this.content;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getCrowdfundingPrice() {
        return this.crowdfundingPrice;
    }

    public String getCurrency() {
        return this.currency;
    }

    public List<CurrencyUnlock> getCurrencyUnlock() {
        return this.currencyUnlock;
    }

    public String getCurrentPrice() {
        return this.currentPrice;
    }

    public String getFacebook() {
        return this.facebook;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getGithub() {
        return this.github;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public String getInvestorPriceRemark() {
        return this.investorPriceRemark;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMaxPrice() {
        return this.maxPrice;
    }

    public String getMaxPriceRemark() {
        return this.maxPriceRemark;
    }

    public String getMedium() {
        return this.medium;
    }

    public String getMinPrice() {
        return this.minPrice;
    }

    public String getMinPriceRemark() {
        return this.minPriceRemark;
    }

    public String getOfficialWebsite() {
        return this.officialWebsite;
    }

    public String getPublishTime() {
        return this.publishTime;
    }

    public String getPublishTimeRemark() {
        return this.publishTimeRemark;
    }

    public String getPublishVolume() {
        return this.publishVolume;
    }

    public String getPublishVolumeRemark() {
        return this.publishVolumeRemark;
    }

    public String getRank() {
        return this.rank;
    }

    public String getRankRemark() {
        return this.rankRemark;
    }

    public int getShow() {
        return this.show;
    }

    public int getSort() {
        return this.sort;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getTelegram() {
        return this.telegram;
    }

    public String getTotalMarketValueRemark() {
        return this.totalMarketValueRemark;
    }

    public String getTwitter() {
        return this.twitter;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public String getWhitePaper() {
        return this.whitePaper;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String language2 = getLanguage();
        int hashCode2 = ((hashCode + 59) * 59) + (language2 == null ? 43 : language2.hashCode());
        String fullName2 = getFullName();
        int hashCode3 = (((((hashCode2 * 59) + (fullName2 == null ? 43 : fullName2.hashCode())) * 59) + getShow()) * 59) + getSort();
        String currentPrice2 = getCurrentPrice();
        int hashCode4 = (hashCode3 * 59) + (currentPrice2 == null ? 43 : currentPrice2.hashCode());
        String rank2 = getRank();
        int hashCode5 = (hashCode4 * 59) + (rank2 == null ? 43 : rank2.hashCode());
        String rankRemark2 = getRankRemark();
        int hashCode6 = (hashCode5 * 59) + (rankRemark2 == null ? 43 : rankRemark2.hashCode());
        String summary2 = getSummary();
        int hashCode7 = (hashCode6 * 59) + (summary2 == null ? 43 : summary2.hashCode());
        String introduction2 = getIntroduction();
        int hashCode8 = (hashCode7 * 59) + (introduction2 == null ? 43 : introduction2.hashCode());
        String publishTime2 = getPublishTime();
        int hashCode9 = (hashCode8 * 59) + (publishTime2 == null ? 43 : publishTime2.hashCode());
        String publishTimeRemark2 = getPublishTimeRemark();
        int hashCode10 = (hashCode9 * 59) + (publishTimeRemark2 == null ? 43 : publishTimeRemark2.hashCode());
        String publishVolume2 = getPublishVolume();
        int hashCode11 = (hashCode10 * 59) + (publishVolume2 == null ? 43 : publishVolume2.hashCode());
        String publishVolumeRemark2 = getPublishVolumeRemark();
        int hashCode12 = (hashCode11 * 59) + (publishVolumeRemark2 == null ? 43 : publishVolumeRemark2.hashCode());
        String circulateVolume2 = getCirculateVolume();
        int hashCode13 = (hashCode12 * 59) + (circulateVolume2 == null ? 43 : circulateVolume2.hashCode());
        String circulateVolumeRemark2 = getCirculateVolumeRemark();
        int hashCode14 = (hashCode13 * 59) + (circulateVolumeRemark2 == null ? 43 : circulateVolumeRemark2.hashCode());
        String totalMarketValueRemark2 = getTotalMarketValueRemark();
        int hashCode15 = (hashCode14 * 59) + (totalMarketValueRemark2 == null ? 43 : totalMarketValueRemark2.hashCode());
        String circulateMarketValueRemark2 = getCirculateMarketValueRemark();
        int hashCode16 = (hashCode15 * 59) + (circulateMarketValueRemark2 == null ? 43 : circulateMarketValueRemark2.hashCode());
        String investorPriceRemark2 = getInvestorPriceRemark();
        int hashCode17 = (hashCode16 * 59) + (investorPriceRemark2 == null ? 43 : investorPriceRemark2.hashCode());
        String crowdfundingPrice2 = getCrowdfundingPrice();
        int hashCode18 = (hashCode17 * 59) + (crowdfundingPrice2 == null ? 43 : crowdfundingPrice2.hashCode());
        String content2 = getContent();
        int hashCode19 = (hashCode18 * 59) + (content2 == null ? 43 : content2.hashCode());
        String whitePaper2 = getWhitePaper();
        int hashCode20 = (hashCode19 * 59) + (whitePaper2 == null ? 43 : whitePaper2.hashCode());
        String officialWebsite2 = getOfficialWebsite();
        int hashCode21 = (hashCode20 * 59) + (officialWebsite2 == null ? 43 : officialWebsite2.hashCode());
        String auditReportUrl2 = getAuditReportUrl();
        int hashCode22 = (hashCode21 * 59) + (auditReportUrl2 == null ? 43 : auditReportUrl2.hashCode());
        String blockQuery2 = getBlockQuery();
        int hashCode23 = (hashCode22 * 59) + (blockQuery2 == null ? 43 : blockQuery2.hashCode());
        String github2 = getGithub();
        int hashCode24 = (hashCode23 * 59) + (github2 == null ? 43 : github2.hashCode());
        String twitter2 = getTwitter();
        int hashCode25 = (hashCode24 * 59) + (twitter2 == null ? 43 : twitter2.hashCode());
        String medium2 = getMedium();
        int hashCode26 = (hashCode25 * 59) + (medium2 == null ? 43 : medium2.hashCode());
        String telegram2 = getTelegram();
        int hashCode27 = (hashCode26 * 59) + (telegram2 == null ? 43 : telegram2.hashCode());
        String facebook2 = getFacebook();
        int hashCode28 = (hashCode27 * 59) + (facebook2 == null ? 43 : facebook2.hashCode());
        long createdAt2 = getCreatedAt();
        int i12 = (hashCode28 * 59) + ((int) (createdAt2 ^ (createdAt2 >>> 32)));
        long updatedAt2 = getUpdatedAt();
        int i13 = (i12 * 59) + ((int) (updatedAt2 ^ (updatedAt2 >>> 32)));
        String maxPrice2 = getMaxPrice();
        int hashCode29 = (i13 * 59) + (maxPrice2 == null ? 43 : maxPrice2.hashCode());
        String maxPriceRemark2 = getMaxPriceRemark();
        int hashCode30 = (hashCode29 * 59) + (maxPriceRemark2 == null ? 43 : maxPriceRemark2.hashCode());
        String minPrice2 = getMinPrice();
        int hashCode31 = (hashCode30 * 59) + (minPrice2 == null ? 43 : minPrice2.hashCode());
        String minPriceRemark2 = getMinPriceRemark();
        int hashCode32 = (hashCode31 * 59) + (minPriceRemark2 == null ? 43 : minPriceRemark2.hashCode());
        List<CurrencyUnlock> currencyUnlock2 = getCurrencyUnlock();
        int i14 = hashCode32 * 59;
        if (currencyUnlock2 != null) {
            i11 = currencyUnlock2.hashCode();
        }
        return i14 + i11;
    }

    public void setAuditReportUrl(String str) {
        this.auditReportUrl = str;
    }

    public void setBlockQuery(String str) {
        this.blockQuery = str;
    }

    public void setCirculateMarketValueRemark(String str) {
        this.circulateMarketValueRemark = str;
    }

    public void setCirculateVolume(String str) {
        this.circulateVolume = str;
    }

    public void setCirculateVolumeRemark(String str) {
        this.circulateVolumeRemark = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreatedAt(long j11) {
        this.createdAt = j11;
    }

    public void setCrowdfundingPrice(String str) {
        this.crowdfundingPrice = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setCurrencyUnlock(List<CurrencyUnlock> list) {
        this.currencyUnlock = list;
    }

    public void setCurrentPrice(String str) {
        this.currentPrice = str;
    }

    public void setFacebook(String str) {
        this.facebook = str;
    }

    public void setFullName(String str) {
        this.fullName = str;
    }

    public void setGithub(String str) {
        this.github = str;
    }

    public void setIntroduction(String str) {
        this.introduction = str;
    }

    public void setInvestorPriceRemark(String str) {
        this.investorPriceRemark = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setMaxPrice(String str) {
        this.maxPrice = str;
    }

    public void setMaxPriceRemark(String str) {
        this.maxPriceRemark = str;
    }

    public void setMedium(String str) {
        this.medium = str;
    }

    public void setMinPrice(String str) {
        this.minPrice = str;
    }

    public void setMinPriceRemark(String str) {
        this.minPriceRemark = str;
    }

    public void setOfficialWebsite(String str) {
        this.officialWebsite = str;
    }

    public void setPublishTime(String str) {
        this.publishTime = str;
    }

    public void setPublishTimeRemark(String str) {
        this.publishTimeRemark = str;
    }

    public void setPublishVolume(String str) {
        this.publishVolume = str;
    }

    public void setPublishVolumeRemark(String str) {
        this.publishVolumeRemark = str;
    }

    public void setRank(String str) {
        this.rank = str;
    }

    public void setRankRemark(String str) {
        this.rankRemark = str;
    }

    public void setShow(int i11) {
        this.show = i11;
    }

    public void setSort(int i11) {
        this.sort = i11;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public void setTelegram(String str) {
        this.telegram = str;
    }

    public void setTotalMarketValueRemark(String str) {
        this.totalMarketValueRemark = str;
    }

    public void setTwitter(String str) {
        this.twitter = str;
    }

    public void setUpdatedAt(long j11) {
        this.updatedAt = j11;
    }

    public void setWhitePaper(String str) {
        this.whitePaper = str;
    }

    public String toString() {
        return "CurrencyIntroInfo(currency=" + getCurrency() + ", language=" + getLanguage() + ", fullName=" + getFullName() + ", show=" + getShow() + ", sort=" + getSort() + ", currentPrice=" + getCurrentPrice() + ", rank=" + getRank() + ", rankRemark=" + getRankRemark() + ", summary=" + getSummary() + ", introduction=" + getIntroduction() + ", publishTime=" + getPublishTime() + ", publishTimeRemark=" + getPublishTimeRemark() + ", publishVolume=" + getPublishVolume() + ", publishVolumeRemark=" + getPublishVolumeRemark() + ", circulateVolume=" + getCirculateVolume() + ", circulateVolumeRemark=" + getCirculateVolumeRemark() + ", totalMarketValueRemark=" + getTotalMarketValueRemark() + ", circulateMarketValueRemark=" + getCirculateMarketValueRemark() + ", investorPriceRemark=" + getInvestorPriceRemark() + ", crowdfundingPrice=" + getCrowdfundingPrice() + ", content=" + getContent() + ", whitePaper=" + getWhitePaper() + ", officialWebsite=" + getOfficialWebsite() + ", auditReportUrl=" + getAuditReportUrl() + ", blockQuery=" + getBlockQuery() + ", github=" + getGithub() + ", twitter=" + getTwitter() + ", medium=" + getMedium() + ", telegram=" + getTelegram() + ", facebook=" + getFacebook() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", maxPrice=" + getMaxPrice() + ", maxPriceRemark=" + getMaxPriceRemark() + ", minPrice=" + getMinPrice() + ", minPriceRemark=" + getMinPriceRemark() + ", currencyUnlock=" + getCurrencyUnlock() + ")";
    }
}
