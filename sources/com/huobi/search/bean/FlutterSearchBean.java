package com.huobi.search.bean;

import java.io.Serializable;

public class FlutterSearchBean implements Serializable {
    private static final long serialVersionUID = -49062535169462131L;
    private boolean favorite;
    private String imageUrl;
    private String marginString;
    private String primaryTitle;
    private String secondaryTitle;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof FlutterSearchBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlutterSearchBean)) {
            return false;
        }
        FlutterSearchBean flutterSearchBean = (FlutterSearchBean) obj;
        if (!flutterSearchBean.canEqual(this)) {
            return false;
        }
        String primaryTitle2 = getPrimaryTitle();
        String primaryTitle3 = flutterSearchBean.getPrimaryTitle();
        if (primaryTitle2 != null ? !primaryTitle2.equals(primaryTitle3) : primaryTitle3 != null) {
            return false;
        }
        String secondaryTitle2 = getSecondaryTitle();
        String secondaryTitle3 = flutterSearchBean.getSecondaryTitle();
        if (secondaryTitle2 != null ? !secondaryTitle2.equals(secondaryTitle3) : secondaryTitle3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = flutterSearchBean.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String marginString2 = getMarginString();
        String marginString3 = flutterSearchBean.getMarginString();
        if (marginString2 != null ? !marginString2.equals(marginString3) : marginString3 != null) {
            return false;
        }
        if (isFavorite() != flutterSearchBean.isFavorite()) {
            return false;
        }
        String imageUrl2 = getImageUrl();
        String imageUrl3 = flutterSearchBean.getImageUrl();
        return imageUrl2 != null ? imageUrl2.equals(imageUrl3) : imageUrl3 == null;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getMarginString() {
        return this.marginString;
    }

    public String getPrimaryTitle() {
        return this.primaryTitle;
    }

    public String getSecondaryTitle() {
        return this.secondaryTitle;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String primaryTitle2 = getPrimaryTitle();
        int i11 = 43;
        int hashCode = primaryTitle2 == null ? 43 : primaryTitle2.hashCode();
        String secondaryTitle2 = getSecondaryTitle();
        int hashCode2 = ((hashCode + 59) * 59) + (secondaryTitle2 == null ? 43 : secondaryTitle2.hashCode());
        String symbol2 = getSymbol();
        int hashCode3 = (hashCode2 * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String marginString2 = getMarginString();
        int hashCode4 = (((hashCode3 * 59) + (marginString2 == null ? 43 : marginString2.hashCode())) * 59) + (isFavorite() ? 79 : 97);
        String imageUrl2 = getImageUrl();
        int i12 = hashCode4 * 59;
        if (imageUrl2 != null) {
            i11 = imageUrl2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isFavorite() {
        return this.favorite;
    }

    public void setFavorite(boolean z11) {
        this.favorite = z11;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setMarginString(String str) {
        this.marginString = str;
    }

    public void setPrimaryTitle(String str) {
        this.primaryTitle = str;
    }

    public void setSecondaryTitle(String str) {
        this.secondaryTitle = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "FlutterSearchBean(primaryTitle=" + getPrimaryTitle() + ", secondaryTitle=" + getSecondaryTitle() + ", symbol=" + getSymbol() + ", marginString=" + getMarginString() + ", favorite=" + isFavorite() + ", imageUrl=" + getImageUrl() + ")";
    }
}
