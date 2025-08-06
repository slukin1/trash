package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class FootprintData implements Serializable {
    private List<ActivityFootPrint> activityFootPrint;
    private String moreFootPrintUrl;
    private List<SymbolFootPrint> symbolFootPrint;

    public class ActivityFootPrint implements Serializable {
        @SerializedName("description")
        public String desc;
        public String imgNightUrl;
        public String imgUrl;
        public String introduction;
        @SerializedName("participated")
        public boolean joinFlag;
        public String jumpUrl;
        public String subUrl;
        public String title;
        public String weight;

        public ActivityFootPrint() {
        }

        public boolean canEqual(Object obj) {
            return obj instanceof ActivityFootPrint;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ActivityFootPrint)) {
                return false;
            }
            ActivityFootPrint activityFootPrint = (ActivityFootPrint) obj;
            if (!activityFootPrint.canEqual(this)) {
                return false;
            }
            String title2 = getTitle();
            String title3 = activityFootPrint.getTitle();
            if (title2 != null ? !title2.equals(title3) : title3 != null) {
                return false;
            }
            String introduction2 = getIntroduction();
            String introduction3 = activityFootPrint.getIntroduction();
            if (introduction2 != null ? !introduction2.equals(introduction3) : introduction3 != null) {
                return false;
            }
            String imgUrl2 = getImgUrl();
            String imgUrl3 = activityFootPrint.getImgUrl();
            if (imgUrl2 != null ? !imgUrl2.equals(imgUrl3) : imgUrl3 != null) {
                return false;
            }
            String imgNightUrl2 = getImgNightUrl();
            String imgNightUrl3 = activityFootPrint.getImgNightUrl();
            if (imgNightUrl2 != null ? !imgNightUrl2.equals(imgNightUrl3) : imgNightUrl3 != null) {
                return false;
            }
            String subUrl2 = getSubUrl();
            String subUrl3 = activityFootPrint.getSubUrl();
            if (subUrl2 != null ? !subUrl2.equals(subUrl3) : subUrl3 != null) {
                return false;
            }
            String weight2 = getWeight();
            String weight3 = activityFootPrint.getWeight();
            if (weight2 != null ? !weight2.equals(weight3) : weight3 != null) {
                return false;
            }
            String desc2 = getDesc();
            String desc3 = activityFootPrint.getDesc();
            if (desc2 != null ? !desc2.equals(desc3) : desc3 != null) {
                return false;
            }
            if (isJoinFlag() != activityFootPrint.isJoinFlag()) {
                return false;
            }
            String jumpUrl2 = getJumpUrl();
            String jumpUrl3 = activityFootPrint.getJumpUrl();
            return jumpUrl2 != null ? jumpUrl2.equals(jumpUrl3) : jumpUrl3 == null;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getImgNightUrl() {
            return this.imgNightUrl;
        }

        public String getImgUrl() {
            return this.imgUrl;
        }

        public String getIntroduction() {
            return this.introduction;
        }

        public String getJumpUrl() {
            return this.jumpUrl;
        }

        public String getSubUrl() {
            return this.subUrl;
        }

        public String getTitle() {
            return this.title;
        }

        public String getWeight() {
            return this.weight;
        }

        public int hashCode() {
            String title2 = getTitle();
            int i11 = 43;
            int hashCode = title2 == null ? 43 : title2.hashCode();
            String introduction2 = getIntroduction();
            int hashCode2 = ((hashCode + 59) * 59) + (introduction2 == null ? 43 : introduction2.hashCode());
            String imgUrl2 = getImgUrl();
            int hashCode3 = (hashCode2 * 59) + (imgUrl2 == null ? 43 : imgUrl2.hashCode());
            String imgNightUrl2 = getImgNightUrl();
            int hashCode4 = (hashCode3 * 59) + (imgNightUrl2 == null ? 43 : imgNightUrl2.hashCode());
            String subUrl2 = getSubUrl();
            int hashCode5 = (hashCode4 * 59) + (subUrl2 == null ? 43 : subUrl2.hashCode());
            String weight2 = getWeight();
            int hashCode6 = (hashCode5 * 59) + (weight2 == null ? 43 : weight2.hashCode());
            String desc2 = getDesc();
            int hashCode7 = (((hashCode6 * 59) + (desc2 == null ? 43 : desc2.hashCode())) * 59) + (isJoinFlag() ? 79 : 97);
            String jumpUrl2 = getJumpUrl();
            int i12 = hashCode7 * 59;
            if (jumpUrl2 != null) {
                i11 = jumpUrl2.hashCode();
            }
            return i12 + i11;
        }

        public boolean isJoinFlag() {
            return this.joinFlag;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setImgNightUrl(String str) {
            this.imgNightUrl = str;
        }

        public void setImgUrl(String str) {
            this.imgUrl = str;
        }

        public void setIntroduction(String str) {
            this.introduction = str;
        }

        public void setJoinFlag(boolean z11) {
            this.joinFlag = z11;
        }

        public void setJumpUrl(String str) {
            this.jumpUrl = str;
        }

        public void setSubUrl(String str) {
            this.subUrl = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setWeight(String str) {
            this.weight = str;
        }

        public String toString() {
            return "FootprintData.ActivityFootPrint(title=" + getTitle() + ", introduction=" + getIntroduction() + ", imgUrl=" + getImgUrl() + ", imgNightUrl=" + getImgNightUrl() + ", subUrl=" + getSubUrl() + ", weight=" + getWeight() + ", desc=" + getDesc() + ", joinFlag=" + isJoinFlag() + ", jumpUrl=" + getJumpUrl() + ")";
        }
    }

    public class SymbolFootPrint implements Serializable {
        public String discountPrice;
        public String fluctuationRange;
        public String latestPrice;
        public String symbol;

        public SymbolFootPrint() {
        }

        public boolean canEqual(Object obj) {
            return obj instanceof SymbolFootPrint;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SymbolFootPrint)) {
                return false;
            }
            SymbolFootPrint symbolFootPrint = (SymbolFootPrint) obj;
            if (!symbolFootPrint.canEqual(this)) {
                return false;
            }
            String symbol2 = getSymbol();
            String symbol3 = symbolFootPrint.getSymbol();
            if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
                return false;
            }
            String fluctuationRange2 = getFluctuationRange();
            String fluctuationRange3 = symbolFootPrint.getFluctuationRange();
            if (fluctuationRange2 != null ? !fluctuationRange2.equals(fluctuationRange3) : fluctuationRange3 != null) {
                return false;
            }
            String latestPrice2 = getLatestPrice();
            String latestPrice3 = symbolFootPrint.getLatestPrice();
            if (latestPrice2 != null ? !latestPrice2.equals(latestPrice3) : latestPrice3 != null) {
                return false;
            }
            String discountPrice2 = getDiscountPrice();
            String discountPrice3 = symbolFootPrint.getDiscountPrice();
            return discountPrice2 != null ? discountPrice2.equals(discountPrice3) : discountPrice3 == null;
        }

        public String getDiscountPrice() {
            return this.discountPrice;
        }

        public String getFluctuationRange() {
            return this.fluctuationRange;
        }

        public String getLatestPrice() {
            return this.latestPrice;
        }

        public String getSymbol() {
            return this.symbol;
        }

        public int hashCode() {
            String symbol2 = getSymbol();
            int i11 = 43;
            int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
            String fluctuationRange2 = getFluctuationRange();
            int hashCode2 = ((hashCode + 59) * 59) + (fluctuationRange2 == null ? 43 : fluctuationRange2.hashCode());
            String latestPrice2 = getLatestPrice();
            int hashCode3 = (hashCode2 * 59) + (latestPrice2 == null ? 43 : latestPrice2.hashCode());
            String discountPrice2 = getDiscountPrice();
            int i12 = hashCode3 * 59;
            if (discountPrice2 != null) {
                i11 = discountPrice2.hashCode();
            }
            return i12 + i11;
        }

        public void setDiscountPrice(String str) {
            this.discountPrice = str;
        }

        public void setFluctuationRange(String str) {
            this.fluctuationRange = str;
        }

        public void setLatestPrice(String str) {
            this.latestPrice = str;
        }

        public void setSymbol(String str) {
            this.symbol = str;
        }

        public String toString() {
            return "FootprintData.SymbolFootPrint(symbol=" + getSymbol() + ", fluctuationRange=" + getFluctuationRange() + ", latestPrice=" + getLatestPrice() + ", discountPrice=" + getDiscountPrice() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof FootprintData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FootprintData)) {
            return false;
        }
        FootprintData footprintData = (FootprintData) obj;
        if (!footprintData.canEqual(this)) {
            return false;
        }
        String moreFootPrintUrl2 = getMoreFootPrintUrl();
        String moreFootPrintUrl3 = footprintData.getMoreFootPrintUrl();
        if (moreFootPrintUrl2 != null ? !moreFootPrintUrl2.equals(moreFootPrintUrl3) : moreFootPrintUrl3 != null) {
            return false;
        }
        List<ActivityFootPrint> activityFootPrint2 = getActivityFootPrint();
        List<ActivityFootPrint> activityFootPrint3 = footprintData.getActivityFootPrint();
        if (activityFootPrint2 != null ? !activityFootPrint2.equals(activityFootPrint3) : activityFootPrint3 != null) {
            return false;
        }
        List<SymbolFootPrint> symbolFootPrint2 = getSymbolFootPrint();
        List<SymbolFootPrint> symbolFootPrint3 = footprintData.getSymbolFootPrint();
        return symbolFootPrint2 != null ? symbolFootPrint2.equals(symbolFootPrint3) : symbolFootPrint3 == null;
    }

    public List<ActivityFootPrint> getActivityFootPrint() {
        return this.activityFootPrint;
    }

    public String getMoreFootPrintUrl() {
        return this.moreFootPrintUrl;
    }

    public List<SymbolFootPrint> getSymbolFootPrint() {
        return this.symbolFootPrint;
    }

    public int hashCode() {
        String moreFootPrintUrl2 = getMoreFootPrintUrl();
        int i11 = 43;
        int hashCode = moreFootPrintUrl2 == null ? 43 : moreFootPrintUrl2.hashCode();
        List<ActivityFootPrint> activityFootPrint2 = getActivityFootPrint();
        int hashCode2 = ((hashCode + 59) * 59) + (activityFootPrint2 == null ? 43 : activityFootPrint2.hashCode());
        List<SymbolFootPrint> symbolFootPrint2 = getSymbolFootPrint();
        int i12 = hashCode2 * 59;
        if (symbolFootPrint2 != null) {
            i11 = symbolFootPrint2.hashCode();
        }
        return i12 + i11;
    }

    public void setActivityFootPrint(List<ActivityFootPrint> list) {
        this.activityFootPrint = list;
    }

    public void setMoreFootPrintUrl(String str) {
        this.moreFootPrintUrl = str;
    }

    public void setSymbolFootPrint(List<SymbolFootPrint> list) {
        this.symbolFootPrint = list;
    }

    public String toString() {
        return "FootprintData(moreFootPrintUrl=" + getMoreFootPrintUrl() + ", activityFootPrint=" + getActivityFootPrint() + ", symbolFootPrint=" + getSymbolFootPrint() + ")";
    }
}
