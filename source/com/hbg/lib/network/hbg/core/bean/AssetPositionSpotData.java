package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class AssetPositionSpotData implements Serializable {
    @SerializedName("accountId")
    private String accountId;
    @SerializedName("accountState")
    private String accountState;
    @SerializedName("spotRiskLevel")
    private String riskLevel;
    @SerializedName("spotRiskRate")
    private String riskRate;
    @SerializedName("spotInfoList")
    private List<SpotInfoListDTO> spotInfoList;
    @SerializedName("userId")
    private String userId;

    public static class SpotInfoListDTO {
        @SerializedName("avgCost")
        private String avgCost;
        @SerializedName("balance")
        private String balance;
        @SerializedName("btcTotalNum")
        private String btcTotalNum;
        @SerializedName("currencyCode")
        private String currencyCode;
        @SerializedName("earnNum")
        private String earnNum;
        @SerializedName("lockNum")
        private String lockNum;
        @SerializedName("profit")
        private String profit;
        @SerializedName("profitRate")
        private String profitRate;
        @SerializedName("singleCurrencyNum")
        private String singleCurrencyNum;
        @SerializedName("singleCurrencySpotAvailableNum")
        private String singleCurrencySpotAvailableNum;
        @SerializedName("singleCurrencySpotNum")
        private String singleCurrencySpotNum;
        @SerializedName("suspense")
        private String suspense;
        @SerializedName("todayProfit")
        private String todayProfit;
        @SerializedName("todayProfitRate")
        private String todayProfitRate;
        @SerializedName("usdtTotalPrice")
        private String usdtTotalPrice;

        public boolean canEqual(Object obj) {
            return obj instanceof SpotInfoListDTO;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SpotInfoListDTO)) {
                return false;
            }
            SpotInfoListDTO spotInfoListDTO = (SpotInfoListDTO) obj;
            if (!spotInfoListDTO.canEqual(this)) {
                return false;
            }
            String currencyCode2 = getCurrencyCode();
            String currencyCode3 = spotInfoListDTO.getCurrencyCode();
            if (currencyCode2 != null ? !currencyCode2.equals(currencyCode3) : currencyCode3 != null) {
                return false;
            }
            String balance2 = getBalance();
            String balance3 = spotInfoListDTO.getBalance();
            if (balance2 != null ? !balance2.equals(balance3) : balance3 != null) {
                return false;
            }
            String suspense2 = getSuspense();
            String suspense3 = spotInfoListDTO.getSuspense();
            if (suspense2 != null ? !suspense2.equals(suspense3) : suspense3 != null) {
                return false;
            }
            String lockNum2 = getLockNum();
            String lockNum3 = spotInfoListDTO.getLockNum();
            if (lockNum2 != null ? !lockNum2.equals(lockNum3) : lockNum3 != null) {
                return false;
            }
            String earnNum2 = getEarnNum();
            String earnNum3 = spotInfoListDTO.getEarnNum();
            if (earnNum2 != null ? !earnNum2.equals(earnNum3) : earnNum3 != null) {
                return false;
            }
            String usdtTotalPrice2 = getUsdtTotalPrice();
            String usdtTotalPrice3 = spotInfoListDTO.getUsdtTotalPrice();
            if (usdtTotalPrice2 != null ? !usdtTotalPrice2.equals(usdtTotalPrice3) : usdtTotalPrice3 != null) {
                return false;
            }
            String btcTotalNum2 = getBtcTotalNum();
            String btcTotalNum3 = spotInfoListDTO.getBtcTotalNum();
            if (btcTotalNum2 != null ? !btcTotalNum2.equals(btcTotalNum3) : btcTotalNum3 != null) {
                return false;
            }
            String singleCurrencyNum2 = getSingleCurrencyNum();
            String singleCurrencyNum3 = spotInfoListDTO.getSingleCurrencyNum();
            if (singleCurrencyNum2 != null ? !singleCurrencyNum2.equals(singleCurrencyNum3) : singleCurrencyNum3 != null) {
                return false;
            }
            String singleCurrencySpotNum2 = getSingleCurrencySpotNum();
            String singleCurrencySpotNum3 = spotInfoListDTO.getSingleCurrencySpotNum();
            if (singleCurrencySpotNum2 != null ? !singleCurrencySpotNum2.equals(singleCurrencySpotNum3) : singleCurrencySpotNum3 != null) {
                return false;
            }
            String avgCost2 = getAvgCost();
            String avgCost3 = spotInfoListDTO.getAvgCost();
            if (avgCost2 != null ? !avgCost2.equals(avgCost3) : avgCost3 != null) {
                return false;
            }
            String profit2 = getProfit();
            String profit3 = spotInfoListDTO.getProfit();
            if (profit2 != null ? !profit2.equals(profit3) : profit3 != null) {
                return false;
            }
            String profitRate2 = getProfitRate();
            String profitRate3 = spotInfoListDTO.getProfitRate();
            if (profitRate2 != null ? !profitRate2.equals(profitRate3) : profitRate3 != null) {
                return false;
            }
            String todayProfit2 = getTodayProfit();
            String todayProfit3 = spotInfoListDTO.getTodayProfit();
            if (todayProfit2 != null ? !todayProfit2.equals(todayProfit3) : todayProfit3 != null) {
                return false;
            }
            String todayProfitRate2 = getTodayProfitRate();
            String todayProfitRate3 = spotInfoListDTO.getTodayProfitRate();
            if (todayProfitRate2 != null ? !todayProfitRate2.equals(todayProfitRate3) : todayProfitRate3 != null) {
                return false;
            }
            String singleCurrencySpotAvailableNum2 = getSingleCurrencySpotAvailableNum();
            String singleCurrencySpotAvailableNum3 = spotInfoListDTO.getSingleCurrencySpotAvailableNum();
            return singleCurrencySpotAvailableNum2 != null ? singleCurrencySpotAvailableNum2.equals(singleCurrencySpotAvailableNum3) : singleCurrencySpotAvailableNum3 == null;
        }

        public String getAvgCost() {
            return this.avgCost;
        }

        public String getBalance() {
            return this.balance;
        }

        public String getBtcTotalNum() {
            return this.btcTotalNum;
        }

        public String getCurrencyCode() {
            return this.currencyCode;
        }

        public String getEarnNum() {
            return this.earnNum;
        }

        public String getLockNum() {
            return this.lockNum;
        }

        public String getProfit() {
            return this.profit;
        }

        public String getProfitRate() {
            return this.profitRate;
        }

        public String getSingleCurrencyNum() {
            return this.singleCurrencyNum;
        }

        public String getSingleCurrencySpotAvailableNum() {
            return this.singleCurrencySpotAvailableNum;
        }

        public String getSingleCurrencySpotNum() {
            return this.singleCurrencySpotNum;
        }

        public String getSuspense() {
            return this.suspense;
        }

        public String getTodayProfit() {
            return this.todayProfit;
        }

        public String getTodayProfitRate() {
            return this.todayProfitRate;
        }

        public String getUsdtTotalPrice() {
            return this.usdtTotalPrice;
        }

        public int hashCode() {
            String currencyCode2 = getCurrencyCode();
            int i11 = 43;
            int hashCode = currencyCode2 == null ? 43 : currencyCode2.hashCode();
            String balance2 = getBalance();
            int hashCode2 = ((hashCode + 59) * 59) + (balance2 == null ? 43 : balance2.hashCode());
            String suspense2 = getSuspense();
            int hashCode3 = (hashCode2 * 59) + (suspense2 == null ? 43 : suspense2.hashCode());
            String lockNum2 = getLockNum();
            int hashCode4 = (hashCode3 * 59) + (lockNum2 == null ? 43 : lockNum2.hashCode());
            String earnNum2 = getEarnNum();
            int hashCode5 = (hashCode4 * 59) + (earnNum2 == null ? 43 : earnNum2.hashCode());
            String usdtTotalPrice2 = getUsdtTotalPrice();
            int hashCode6 = (hashCode5 * 59) + (usdtTotalPrice2 == null ? 43 : usdtTotalPrice2.hashCode());
            String btcTotalNum2 = getBtcTotalNum();
            int hashCode7 = (hashCode6 * 59) + (btcTotalNum2 == null ? 43 : btcTotalNum2.hashCode());
            String singleCurrencyNum2 = getSingleCurrencyNum();
            int hashCode8 = (hashCode7 * 59) + (singleCurrencyNum2 == null ? 43 : singleCurrencyNum2.hashCode());
            String singleCurrencySpotNum2 = getSingleCurrencySpotNum();
            int hashCode9 = (hashCode8 * 59) + (singleCurrencySpotNum2 == null ? 43 : singleCurrencySpotNum2.hashCode());
            String avgCost2 = getAvgCost();
            int hashCode10 = (hashCode9 * 59) + (avgCost2 == null ? 43 : avgCost2.hashCode());
            String profit2 = getProfit();
            int hashCode11 = (hashCode10 * 59) + (profit2 == null ? 43 : profit2.hashCode());
            String profitRate2 = getProfitRate();
            int hashCode12 = (hashCode11 * 59) + (profitRate2 == null ? 43 : profitRate2.hashCode());
            String todayProfit2 = getTodayProfit();
            int hashCode13 = (hashCode12 * 59) + (todayProfit2 == null ? 43 : todayProfit2.hashCode());
            String todayProfitRate2 = getTodayProfitRate();
            int hashCode14 = (hashCode13 * 59) + (todayProfitRate2 == null ? 43 : todayProfitRate2.hashCode());
            String singleCurrencySpotAvailableNum2 = getSingleCurrencySpotAvailableNum();
            int i12 = hashCode14 * 59;
            if (singleCurrencySpotAvailableNum2 != null) {
                i11 = singleCurrencySpotAvailableNum2.hashCode();
            }
            return i12 + i11;
        }

        public void setAvgCost(String str) {
            this.avgCost = str;
        }

        public void setBalance(String str) {
            this.balance = str;
        }

        public void setBtcTotalNum(String str) {
            this.btcTotalNum = str;
        }

        public void setCurrencyCode(String str) {
            this.currencyCode = str;
        }

        public void setEarnNum(String str) {
            this.earnNum = str;
        }

        public void setLockNum(String str) {
            this.lockNum = str;
        }

        public void setProfit(String str) {
            this.profit = str;
        }

        public void setProfitRate(String str) {
            this.profitRate = str;
        }

        public void setSingleCurrencyNum(String str) {
            this.singleCurrencyNum = str;
        }

        public void setSingleCurrencySpotAvailableNum(String str) {
            this.singleCurrencySpotAvailableNum = str;
        }

        public void setSingleCurrencySpotNum(String str) {
            this.singleCurrencySpotNum = str;
        }

        public void setSuspense(String str) {
            this.suspense = str;
        }

        public void setTodayProfit(String str) {
            this.todayProfit = str;
        }

        public void setTodayProfitRate(String str) {
            this.todayProfitRate = str;
        }

        public void setUsdtTotalPrice(String str) {
            this.usdtTotalPrice = str;
        }

        public String toString() {
            return "AssetPositionSpotData.SpotInfoListDTO(currencyCode=" + getCurrencyCode() + ", balance=" + getBalance() + ", suspense=" + getSuspense() + ", lockNum=" + getLockNum() + ", earnNum=" + getEarnNum() + ", usdtTotalPrice=" + getUsdtTotalPrice() + ", btcTotalNum=" + getBtcTotalNum() + ", singleCurrencyNum=" + getSingleCurrencyNum() + ", singleCurrencySpotNum=" + getSingleCurrencySpotNum() + ", avgCost=" + getAvgCost() + ", profit=" + getProfit() + ", profitRate=" + getProfitRate() + ", todayProfit=" + getTodayProfit() + ", todayProfitRate=" + getTodayProfitRate() + ", singleCurrencySpotAvailableNum=" + getSingleCurrencySpotAvailableNum() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof AssetPositionSpotData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AssetPositionSpotData)) {
            return false;
        }
        AssetPositionSpotData assetPositionSpotData = (AssetPositionSpotData) obj;
        if (!assetPositionSpotData.canEqual(this)) {
            return false;
        }
        String userId2 = getUserId();
        String userId3 = assetPositionSpotData.getUserId();
        if (userId2 != null ? !userId2.equals(userId3) : userId3 != null) {
            return false;
        }
        String accountId2 = getAccountId();
        String accountId3 = assetPositionSpotData.getAccountId();
        if (accountId2 != null ? !accountId2.equals(accountId3) : accountId3 != null) {
            return false;
        }
        String accountState2 = getAccountState();
        String accountState3 = assetPositionSpotData.getAccountState();
        if (accountState2 != null ? !accountState2.equals(accountState3) : accountState3 != null) {
            return false;
        }
        String riskLevel2 = getRiskLevel();
        String riskLevel3 = assetPositionSpotData.getRiskLevel();
        if (riskLevel2 != null ? !riskLevel2.equals(riskLevel3) : riskLevel3 != null) {
            return false;
        }
        String riskRate2 = getRiskRate();
        String riskRate3 = assetPositionSpotData.getRiskRate();
        if (riskRate2 != null ? !riskRate2.equals(riskRate3) : riskRate3 != null) {
            return false;
        }
        List<SpotInfoListDTO> spotInfoList2 = getSpotInfoList();
        List<SpotInfoListDTO> spotInfoList3 = assetPositionSpotData.getSpotInfoList();
        return spotInfoList2 != null ? spotInfoList2.equals(spotInfoList3) : spotInfoList3 == null;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getAccountState() {
        return this.accountState;
    }

    public String getRiskLevel() {
        return this.riskLevel;
    }

    public String getRiskRate() {
        return this.riskRate;
    }

    public List<SpotInfoListDTO> getSpotInfoList() {
        return this.spotInfoList;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String userId2 = getUserId();
        int i11 = 43;
        int hashCode = userId2 == null ? 43 : userId2.hashCode();
        String accountId2 = getAccountId();
        int hashCode2 = ((hashCode + 59) * 59) + (accountId2 == null ? 43 : accountId2.hashCode());
        String accountState2 = getAccountState();
        int hashCode3 = (hashCode2 * 59) + (accountState2 == null ? 43 : accountState2.hashCode());
        String riskLevel2 = getRiskLevel();
        int hashCode4 = (hashCode3 * 59) + (riskLevel2 == null ? 43 : riskLevel2.hashCode());
        String riskRate2 = getRiskRate();
        int hashCode5 = (hashCode4 * 59) + (riskRate2 == null ? 43 : riskRate2.hashCode());
        List<SpotInfoListDTO> spotInfoList2 = getSpotInfoList();
        int i12 = hashCode5 * 59;
        if (spotInfoList2 != null) {
            i11 = spotInfoList2.hashCode();
        }
        return i12 + i11;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setAccountState(String str) {
        this.accountState = str;
    }

    public void setRiskLevel(String str) {
        this.riskLevel = str;
    }

    public void setRiskRate(String str) {
        this.riskRate = str;
    }

    public void setSpotInfoList(List<SpotInfoListDTO> list) {
        this.spotInfoList = list;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "AssetPositionSpotData(userId=" + getUserId() + ", accountId=" + getAccountId() + ", accountState=" + getAccountState() + ", riskLevel=" + getRiskLevel() + ", riskRate=" + getRiskRate() + ", spotInfoList=" + getSpotInfoList() + ")";
    }
}
