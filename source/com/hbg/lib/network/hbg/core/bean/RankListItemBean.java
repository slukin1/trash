package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class RankListItemBean implements Serializable {
    private static final long serialVersionUID = 5055037037204266746L;
    private String baseCurrency;
    private long beginTradeDate;
    private double beginTradePrice;
    private double beginTradeUpAndDown;
    private int contractBusinessType;
    private String contractBusinessTypeTag;
    private String contractShowSymbol;
    private String currency;
    private int flag;
    private String flagURL;
    private String jumpUrl;
    private String newProfitAmount;
    private String nftDid;
    private String nftImg;
    private String open;
    private String price;
    private String quoteCurrency;
    private String symbol;
    private String tagUrl;
    private ArrayList<String> tags;
    private String totalProfitAmount;
    private String totalProfitRate;
    private String upAndDown;
    private String volume;
    private int winCount;

    public boolean canEqual(Object obj) {
        return obj instanceof RankListItemBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RankListItemBean)) {
            return false;
        }
        RankListItemBean rankListItemBean = (RankListItemBean) obj;
        if (!rankListItemBean.canEqual(this)) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = rankListItemBean.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = rankListItemBean.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = rankListItemBean.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String open2 = getOpen();
        String open3 = rankListItemBean.getOpen();
        if (open2 != null ? !open2.equals(open3) : open3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = rankListItemBean.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String upAndDown2 = getUpAndDown();
        String upAndDown3 = rankListItemBean.getUpAndDown();
        if (upAndDown2 != null ? !upAndDown2.equals(upAndDown3) : upAndDown3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = rankListItemBean.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = rankListItemBean.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        String tagUrl2 = getTagUrl();
        String tagUrl3 = rankListItemBean.getTagUrl();
        if (tagUrl2 != null ? !tagUrl2.equals(tagUrl3) : tagUrl3 != null) {
            return false;
        }
        if (getFlag() != rankListItemBean.getFlag()) {
            return false;
        }
        String flagURL2 = getFlagURL();
        String flagURL3 = rankListItemBean.getFlagURL();
        if (flagURL2 != null ? !flagURL2.equals(flagURL3) : flagURL3 != null) {
            return false;
        }
        if (getBeginTradeDate() != rankListItemBean.getBeginTradeDate() || Double.compare(getBeginTradePrice(), rankListItemBean.getBeginTradePrice()) != 0 || Double.compare(getBeginTradeUpAndDown(), rankListItemBean.getBeginTradeUpAndDown()) != 0 || getContractBusinessType() != rankListItemBean.getContractBusinessType()) {
            return false;
        }
        String contractShowSymbol2 = getContractShowSymbol();
        String contractShowSymbol3 = rankListItemBean.getContractShowSymbol();
        if (contractShowSymbol2 != null ? !contractShowSymbol2.equals(contractShowSymbol3) : contractShowSymbol3 != null) {
            return false;
        }
        String contractBusinessTypeTag2 = getContractBusinessTypeTag();
        String contractBusinessTypeTag3 = rankListItemBean.getContractBusinessTypeTag();
        if (contractBusinessTypeTag2 != null ? !contractBusinessTypeTag2.equals(contractBusinessTypeTag3) : contractBusinessTypeTag3 != null) {
            return false;
        }
        String totalProfitRate2 = getTotalProfitRate();
        String totalProfitRate3 = rankListItemBean.getTotalProfitRate();
        if (totalProfitRate2 != null ? !totalProfitRate2.equals(totalProfitRate3) : totalProfitRate3 != null) {
            return false;
        }
        String totalProfitAmount2 = getTotalProfitAmount();
        String totalProfitAmount3 = rankListItemBean.getTotalProfitAmount();
        if (totalProfitAmount2 != null ? !totalProfitAmount2.equals(totalProfitAmount3) : totalProfitAmount3 != null) {
            return false;
        }
        String jumpUrl2 = getJumpUrl();
        String jumpUrl3 = rankListItemBean.getJumpUrl();
        if (jumpUrl2 != null ? !jumpUrl2.equals(jumpUrl3) : jumpUrl3 != null) {
            return false;
        }
        String nftDid2 = getNftDid();
        String nftDid3 = rankListItemBean.getNftDid();
        if (nftDid2 != null ? !nftDid2.equals(nftDid3) : nftDid3 != null) {
            return false;
        }
        String nftImg2 = getNftImg();
        String nftImg3 = rankListItemBean.getNftImg();
        if (nftImg2 != null ? !nftImg2.equals(nftImg3) : nftImg3 != null) {
            return false;
        }
        String newProfitAmount2 = getNewProfitAmount();
        String newProfitAmount3 = rankListItemBean.getNewProfitAmount();
        if (newProfitAmount2 != null ? !newProfitAmount2.equals(newProfitAmount3) : newProfitAmount3 != null) {
            return false;
        }
        if (getWinCount() != rankListItemBean.getWinCount()) {
            return false;
        }
        ArrayList<String> tags2 = getTags();
        ArrayList<String> tags3 = rankListItemBean.getTags();
        return tags2 != null ? tags2.equals(tags3) : tags3 == null;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public long getBeginTradeDate() {
        return this.beginTradeDate;
    }

    public double getBeginTradePrice() {
        return this.beginTradePrice;
    }

    public double getBeginTradeUpAndDown() {
        return this.beginTradeUpAndDown;
    }

    public int getContractBusinessType() {
        return this.contractBusinessType;
    }

    public String getContractBusinessTypeTag() {
        return this.contractBusinessTypeTag;
    }

    public String getContractShowSymbol() {
        return this.contractShowSymbol;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int getFlag() {
        return this.flag;
    }

    public String getFlagURL() {
        return this.flagURL;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getNewProfitAmount() {
        return this.newProfitAmount;
    }

    public String getNftDid() {
        return this.nftDid;
    }

    public String getNftImg() {
        return this.nftImg;
    }

    public String getOpen() {
        return this.open;
    }

    public String getPrice() {
        return this.price;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTagUrl() {
        return this.tagUrl;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public String getTotalProfitAmount() {
        return this.totalProfitAmount;
    }

    public String getTotalProfitRate() {
        return this.totalProfitRate;
    }

    public String getUpAndDown() {
        return this.upAndDown;
    }

    public String getVolume() {
        return this.volume;
    }

    public int getWinCount() {
        return this.winCount;
    }

    public int hashCode() {
        String baseCurrency2 = getBaseCurrency();
        int i11 = 43;
        int hashCode = baseCurrency2 == null ? 43 : baseCurrency2.hashCode();
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode());
        String symbol2 = getSymbol();
        int hashCode3 = (hashCode2 * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String open2 = getOpen();
        int hashCode4 = (hashCode3 * 59) + (open2 == null ? 43 : open2.hashCode());
        String price2 = getPrice();
        int hashCode5 = (hashCode4 * 59) + (price2 == null ? 43 : price2.hashCode());
        String upAndDown2 = getUpAndDown();
        int hashCode6 = (hashCode5 * 59) + (upAndDown2 == null ? 43 : upAndDown2.hashCode());
        String currency2 = getCurrency();
        int hashCode7 = (hashCode6 * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String volume2 = getVolume();
        int hashCode8 = (hashCode7 * 59) + (volume2 == null ? 43 : volume2.hashCode());
        String tagUrl2 = getTagUrl();
        int hashCode9 = (((hashCode8 * 59) + (tagUrl2 == null ? 43 : tagUrl2.hashCode())) * 59) + getFlag();
        String flagURL2 = getFlagURL();
        int hashCode10 = (hashCode9 * 59) + (flagURL2 == null ? 43 : flagURL2.hashCode());
        long beginTradeDate2 = getBeginTradeDate();
        int i12 = (hashCode10 * 59) + ((int) (beginTradeDate2 ^ (beginTradeDate2 >>> 32)));
        long doubleToLongBits = Double.doubleToLongBits(getBeginTradePrice());
        int i13 = (i12 * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        long doubleToLongBits2 = Double.doubleToLongBits(getBeginTradeUpAndDown());
        int contractBusinessType2 = (((i13 * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 59) + getContractBusinessType();
        String contractShowSymbol2 = getContractShowSymbol();
        int hashCode11 = (contractBusinessType2 * 59) + (contractShowSymbol2 == null ? 43 : contractShowSymbol2.hashCode());
        String contractBusinessTypeTag2 = getContractBusinessTypeTag();
        int hashCode12 = (hashCode11 * 59) + (contractBusinessTypeTag2 == null ? 43 : contractBusinessTypeTag2.hashCode());
        String totalProfitRate2 = getTotalProfitRate();
        int hashCode13 = (hashCode12 * 59) + (totalProfitRate2 == null ? 43 : totalProfitRate2.hashCode());
        String totalProfitAmount2 = getTotalProfitAmount();
        int hashCode14 = (hashCode13 * 59) + (totalProfitAmount2 == null ? 43 : totalProfitAmount2.hashCode());
        String jumpUrl2 = getJumpUrl();
        int hashCode15 = (hashCode14 * 59) + (jumpUrl2 == null ? 43 : jumpUrl2.hashCode());
        String nftDid2 = getNftDid();
        int hashCode16 = (hashCode15 * 59) + (nftDid2 == null ? 43 : nftDid2.hashCode());
        String nftImg2 = getNftImg();
        int hashCode17 = (hashCode16 * 59) + (nftImg2 == null ? 43 : nftImg2.hashCode());
        String newProfitAmount2 = getNewProfitAmount();
        int hashCode18 = (((hashCode17 * 59) + (newProfitAmount2 == null ? 43 : newProfitAmount2.hashCode())) * 59) + getWinCount();
        ArrayList<String> tags2 = getTags();
        int i14 = hashCode18 * 59;
        if (tags2 != null) {
            i11 = tags2.hashCode();
        }
        return i14 + i11;
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setBeginTradeDate(long j11) {
        this.beginTradeDate = j11;
    }

    public void setBeginTradePrice(double d11) {
        this.beginTradePrice = d11;
    }

    public void setBeginTradeUpAndDown(double d11) {
        this.beginTradeUpAndDown = d11;
    }

    public void setContractBusinessType(int i11) {
        this.contractBusinessType = i11;
    }

    public void setContractBusinessTypeTag(String str) {
        this.contractBusinessTypeTag = str;
    }

    public void setContractShowSymbol(String str) {
        this.contractShowSymbol = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setFlag(int i11) {
        this.flag = i11;
    }

    public void setFlagURL(String str) {
        this.flagURL = str;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setNewProfitAmount(String str) {
        this.newProfitAmount = str;
    }

    public void setNftDid(String str) {
        this.nftDid = str;
    }

    public void setNftImg(String str) {
        this.nftImg = str;
    }

    public void setOpen(String str) {
        this.open = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTagUrl(String str) {
        this.tagUrl = str;
    }

    public void setTags(ArrayList<String> arrayList) {
        this.tags = arrayList;
    }

    public void setTotalProfitAmount(String str) {
        this.totalProfitAmount = str;
    }

    public void setTotalProfitRate(String str) {
        this.totalProfitRate = str;
    }

    public void setUpAndDown(String str) {
        this.upAndDown = str;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public void setWinCount(int i11) {
        this.winCount = i11;
    }

    public String toString() {
        return "RankListItemBean(baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", symbol=" + getSymbol() + ", open=" + getOpen() + ", price=" + getPrice() + ", upAndDown=" + getUpAndDown() + ", currency=" + getCurrency() + ", volume=" + getVolume() + ", tagUrl=" + getTagUrl() + ", flag=" + getFlag() + ", flagURL=" + getFlagURL() + ", beginTradeDate=" + getBeginTradeDate() + ", beginTradePrice=" + getBeginTradePrice() + ", beginTradeUpAndDown=" + getBeginTradeUpAndDown() + ", contractBusinessType=" + getContractBusinessType() + ", contractShowSymbol=" + getContractShowSymbol() + ", contractBusinessTypeTag=" + getContractBusinessTypeTag() + ", totalProfitRate=" + getTotalProfitRate() + ", totalProfitAmount=" + getTotalProfitAmount() + ", jumpUrl=" + getJumpUrl() + ", nftDid=" + getNftDid() + ", nftImg=" + getNftImg() + ", newProfitAmount=" + getNewProfitAmount() + ", winCount=" + getWinCount() + ", tags=" + getTags() + ")";
    }
}
