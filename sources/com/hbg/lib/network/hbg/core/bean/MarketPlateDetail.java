package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;
import s9.a;

public class MarketPlateDetail implements Serializable {
    private List<CurrencyItem> currencyList;
    private List<CurrencyItem> hotCurrency;
    private PlateInfo plateInfo;

    public static class CurrencyItem implements a, Serializable {
        private String currency;
        private String price;
        private String state;
        private String symbol;
        private String totalVol;
        private String upDown;

        public boolean canEqual(Object obj) {
            return obj instanceof CurrencyItem;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CurrencyItem)) {
                return false;
            }
            CurrencyItem currencyItem = (CurrencyItem) obj;
            if (!currencyItem.canEqual(this)) {
                return false;
            }
            String currency2 = getCurrency();
            String currency3 = currencyItem.getCurrency();
            if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
                return false;
            }
            String symbol2 = getSymbol();
            String symbol3 = currencyItem.getSymbol();
            if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
                return false;
            }
            String totalVol2 = getTotalVol();
            String totalVol3 = currencyItem.getTotalVol();
            if (totalVol2 != null ? !totalVol2.equals(totalVol3) : totalVol3 != null) {
                return false;
            }
            String price2 = getPrice();
            String price3 = currencyItem.getPrice();
            if (price2 != null ? !price2.equals(price3) : price3 != null) {
                return false;
            }
            String upDown2 = getUpDown();
            String upDown3 = currencyItem.getUpDown();
            if (upDown2 != null ? !upDown2.equals(upDown3) : upDown3 != null) {
                return false;
            }
            String state2 = getState();
            String state3 = currencyItem.getState();
            return state2 != null ? state2.equals(state3) : state3 == null;
        }

        public String getCurrency() {
            return this.currency;
        }

        public String getPrice() {
            return this.price;
        }

        public String getState() {
            return this.state;
        }

        public String getSymbol() {
            return this.symbol;
        }

        public String getTotalVol() {
            return this.totalVol;
        }

        public String getUpDown() {
            return this.upDown;
        }

        public String getViewHandlerName() {
            return "com.huobi.homemarket.handler.MarketDetailPlateHandler";
        }

        public int hashCode() {
            String currency2 = getCurrency();
            int i11 = 43;
            int hashCode = currency2 == null ? 43 : currency2.hashCode();
            String symbol2 = getSymbol();
            int hashCode2 = ((hashCode + 59) * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
            String totalVol2 = getTotalVol();
            int hashCode3 = (hashCode2 * 59) + (totalVol2 == null ? 43 : totalVol2.hashCode());
            String price2 = getPrice();
            int hashCode4 = (hashCode3 * 59) + (price2 == null ? 43 : price2.hashCode());
            String upDown2 = getUpDown();
            int hashCode5 = (hashCode4 * 59) + (upDown2 == null ? 43 : upDown2.hashCode());
            String state2 = getState();
            int i12 = hashCode5 * 59;
            if (state2 != null) {
                i11 = state2.hashCode();
            }
            return i12 + i11;
        }

        public void setCurrency(String str) {
            this.currency = str;
        }

        public void setPrice(String str) {
            this.price = str;
        }

        public void setState(String str) {
            this.state = str;
        }

        public void setSymbol(String str) {
            this.symbol = str;
        }

        public void setTotalVol(String str) {
            this.totalVol = str;
        }

        public void setUpDown(String str) {
            this.upDown = str;
        }

        public String toString() {
            return "MarketPlateDetail.CurrencyItem(currency=" + getCurrency() + ", symbol=" + getSymbol() + ", totalVol=" + getTotalVol() + ", price=" + getPrice() + ", upDown=" + getUpDown() + ", state=" + getState() + ")";
        }
    }

    public static class PlateInfo implements Serializable {
        private int downCount;
        private String intro;
        private String plateId;
        private String plateName;
        private String plateUpDown;
        private String totalVol;
        private int upCount;

        public boolean canEqual(Object obj) {
            return obj instanceof PlateInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PlateInfo)) {
                return false;
            }
            PlateInfo plateInfo = (PlateInfo) obj;
            if (!plateInfo.canEqual(this)) {
                return false;
            }
            String plateId2 = getPlateId();
            String plateId3 = plateInfo.getPlateId();
            if (plateId2 != null ? !plateId2.equals(plateId3) : plateId3 != null) {
                return false;
            }
            String plateName2 = getPlateName();
            String plateName3 = plateInfo.getPlateName();
            if (plateName2 != null ? !plateName2.equals(plateName3) : plateName3 != null) {
                return false;
            }
            String plateUpDown2 = getPlateUpDown();
            String plateUpDown3 = plateInfo.getPlateUpDown();
            if (plateUpDown2 != null ? !plateUpDown2.equals(plateUpDown3) : plateUpDown3 != null) {
                return false;
            }
            String totalVol2 = getTotalVol();
            String totalVol3 = plateInfo.getTotalVol();
            if (totalVol2 != null ? !totalVol2.equals(totalVol3) : totalVol3 != null) {
                return false;
            }
            if (getUpCount() != plateInfo.getUpCount() || getDownCount() != plateInfo.getDownCount()) {
                return false;
            }
            String intro2 = getIntro();
            String intro3 = plateInfo.getIntro();
            return intro2 != null ? intro2.equals(intro3) : intro3 == null;
        }

        public int getDownCount() {
            return this.downCount;
        }

        public String getIntro() {
            return this.intro;
        }

        public String getPlateId() {
            return this.plateId;
        }

        public String getPlateName() {
            return this.plateName;
        }

        public String getPlateUpDown() {
            return this.plateUpDown;
        }

        public String getTotalVol() {
            return this.totalVol;
        }

        public int getUpCount() {
            return this.upCount;
        }

        public int hashCode() {
            String plateId2 = getPlateId();
            int i11 = 43;
            int hashCode = plateId2 == null ? 43 : plateId2.hashCode();
            String plateName2 = getPlateName();
            int hashCode2 = ((hashCode + 59) * 59) + (plateName2 == null ? 43 : plateName2.hashCode());
            String plateUpDown2 = getPlateUpDown();
            int hashCode3 = (hashCode2 * 59) + (plateUpDown2 == null ? 43 : plateUpDown2.hashCode());
            String totalVol2 = getTotalVol();
            int hashCode4 = (((((hashCode3 * 59) + (totalVol2 == null ? 43 : totalVol2.hashCode())) * 59) + getUpCount()) * 59) + getDownCount();
            String intro2 = getIntro();
            int i12 = hashCode4 * 59;
            if (intro2 != null) {
                i11 = intro2.hashCode();
            }
            return i12 + i11;
        }

        public void setDownCount(int i11) {
            this.downCount = i11;
        }

        public void setIntro(String str) {
            this.intro = str;
        }

        public void setPlateId(String str) {
            this.plateId = str;
        }

        public void setPlateName(String str) {
            this.plateName = str;
        }

        public void setPlateUpDown(String str) {
            this.plateUpDown = str;
        }

        public void setTotalVol(String str) {
            this.totalVol = str;
        }

        public void setUpCount(int i11) {
            this.upCount = i11;
        }

        public String toString() {
            return "MarketPlateDetail.PlateInfo(plateId=" + getPlateId() + ", plateName=" + getPlateName() + ", plateUpDown=" + getPlateUpDown() + ", totalVol=" + getTotalVol() + ", upCount=" + getUpCount() + ", downCount=" + getDownCount() + ", intro=" + getIntro() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof MarketPlateDetail;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketPlateDetail)) {
            return false;
        }
        MarketPlateDetail marketPlateDetail = (MarketPlateDetail) obj;
        if (!marketPlateDetail.canEqual(this)) {
            return false;
        }
        PlateInfo plateInfo2 = getPlateInfo();
        PlateInfo plateInfo3 = marketPlateDetail.getPlateInfo();
        if (plateInfo2 != null ? !plateInfo2.equals(plateInfo3) : plateInfo3 != null) {
            return false;
        }
        List<CurrencyItem> currencyList2 = getCurrencyList();
        List<CurrencyItem> currencyList3 = marketPlateDetail.getCurrencyList();
        if (currencyList2 != null ? !currencyList2.equals(currencyList3) : currencyList3 != null) {
            return false;
        }
        List<CurrencyItem> hotCurrency2 = getHotCurrency();
        List<CurrencyItem> hotCurrency3 = marketPlateDetail.getHotCurrency();
        return hotCurrency2 != null ? hotCurrency2.equals(hotCurrency3) : hotCurrency3 == null;
    }

    public List<CurrencyItem> getCurrencyList() {
        return this.currencyList;
    }

    public List<CurrencyItem> getHotCurrency() {
        return this.hotCurrency;
    }

    public PlateInfo getPlateInfo() {
        return this.plateInfo;
    }

    public int hashCode() {
        PlateInfo plateInfo2 = getPlateInfo();
        int i11 = 43;
        int hashCode = plateInfo2 == null ? 43 : plateInfo2.hashCode();
        List<CurrencyItem> currencyList2 = getCurrencyList();
        int hashCode2 = ((hashCode + 59) * 59) + (currencyList2 == null ? 43 : currencyList2.hashCode());
        List<CurrencyItem> hotCurrency2 = getHotCurrency();
        int i12 = hashCode2 * 59;
        if (hotCurrency2 != null) {
            i11 = hotCurrency2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrencyList(List<CurrencyItem> list) {
        this.currencyList = list;
    }

    public void setHotCurrency(List<CurrencyItem> list) {
        this.hotCurrency = list;
    }

    public void setPlateInfo(PlateInfo plateInfo2) {
        this.plateInfo = plateInfo2;
    }

    public String toString() {
        return "MarketPlateDetail(plateInfo=" + getPlateInfo() + ", currencyList=" + getCurrencyList() + ", hotCurrency=" + getHotCurrency() + ")";
    }
}
