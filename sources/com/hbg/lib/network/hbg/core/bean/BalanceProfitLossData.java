package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceProfitLossData implements Serializable {
    private Map<String, AccountBalance> accountBalanceMap;
    @SerializedName("accountState")
    private String accountState;
    private boolean hideAssetAmount;
    private boolean isProfitAnalyzeEnable;
    private List<AccountBalance> profitAccountBalanceList;
    @SerializedName("spotRiskLevel")
    private String spotRiskLevel;
    @SerializedName("spotRiskRate")
    private String spotRiskRate;
    private String todayCoinProfit;
    private String todayCoinProfitRate;
    private String todayProfit;
    private String todayProfitRate;
    private String totalAccumulateProfit;
    private String totalBalance;
    private UpdatedObject updated;
    private String userId;

    public static class AccountBalance implements Serializable {
        public static final String DISTRIBUTION_TYPE_CROSS_MARGIN = "3";
        public static final String DISTRIBUTION_TYPE_FUTURE_DERIVATIVES = "4";
        public static final String DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP = "11";
        public static final String DISTRIBUTION_TYPE_FUTURE_OPTION = "12";
        public static final String DISTRIBUTION_TYPE_FUTURE_SWAP = "7";
        public static final String DISTRIBUTION_TYPE_HUOBI_EARN = "16";
        public static final String DISTRIBUTION_TYPE_ISOLATE_MARGIN = "2";
        public static final String DISTRIBUTION_TYPE_MORTGAGE = "14";
        public static final String DISTRIBUTION_TYPE_OTC = "5";
        public static final String DISTRIBUTION_TYPE_POOL = "6";
        public static final String DISTRIBUTION_TYPE_QUANT = "15";
        public static final String DISTRIBUTION_TYPE_SPOT = "1";
        public static final String DISTRIBUTION_TYPE_WARRANT = "13";
        private String accountBalance;
        private List<AccountBalance> accountBalances;
        private int distributionIconRes = -1;
        private String distributionName;
        /* access modifiers changed from: private */
        public String distributionType;
        private boolean isExpanded = false;
        private boolean isOpened = true;
        private boolean success;

        public boolean canEqual(Object obj) {
            return obj instanceof AccountBalance;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AccountBalance)) {
                return false;
            }
            AccountBalance accountBalance2 = (AccountBalance) obj;
            if (!accountBalance2.canEqual(this) || isSuccess() != accountBalance2.isSuccess()) {
                return false;
            }
            String distributionType2 = getDistributionType();
            String distributionType3 = accountBalance2.getDistributionType();
            if (distributionType2 != null ? !distributionType2.equals(distributionType3) : distributionType3 != null) {
                return false;
            }
            String distributionName2 = getDistributionName();
            String distributionName3 = accountBalance2.getDistributionName();
            if (distributionName2 != null ? !distributionName2.equals(distributionName3) : distributionName3 != null) {
                return false;
            }
            String accountBalance3 = getAccountBalance();
            String accountBalance4 = accountBalance2.getAccountBalance();
            if (accountBalance3 != null ? !accountBalance3.equals(accountBalance4) : accountBalance4 != null) {
                return false;
            }
            if (getDistributionIconRes() != accountBalance2.getDistributionIconRes() || isOpened() != accountBalance2.isOpened()) {
                return false;
            }
            List<AccountBalance> accountBalances2 = getAccountBalances();
            List<AccountBalance> accountBalances3 = accountBalance2.getAccountBalances();
            if (accountBalances2 != null ? accountBalances2.equals(accountBalances3) : accountBalances3 == null) {
                return isExpanded() == accountBalance2.isExpanded();
            }
            return false;
        }

        public String getAccountBalance() {
            return this.accountBalance;
        }

        public List<AccountBalance> getAccountBalances() {
            return this.accountBalances;
        }

        public int getDistributionIconRes() {
            return this.distributionIconRes;
        }

        public String getDistributionName() {
            return this.distributionName;
        }

        public String getDistributionType() {
            return this.distributionType;
        }

        public int hashCode() {
            int i11 = 79;
            int i12 = isSuccess() ? 79 : 97;
            String distributionType2 = getDistributionType();
            int i13 = 43;
            int hashCode = ((i12 + 59) * 59) + (distributionType2 == null ? 43 : distributionType2.hashCode());
            String distributionName2 = getDistributionName();
            int hashCode2 = (hashCode * 59) + (distributionName2 == null ? 43 : distributionName2.hashCode());
            String accountBalance2 = getAccountBalance();
            int hashCode3 = (((((hashCode2 * 59) + (accountBalance2 == null ? 43 : accountBalance2.hashCode())) * 59) + getDistributionIconRes()) * 59) + (isOpened() ? 79 : 97);
            List<AccountBalance> accountBalances2 = getAccountBalances();
            int i14 = hashCode3 * 59;
            if (accountBalances2 != null) {
                i13 = accountBalances2.hashCode();
            }
            int i15 = (i14 + i13) * 59;
            if (!isExpanded()) {
                i11 = 97;
            }
            return i15 + i11;
        }

        public boolean isExpanded() {
            return this.isExpanded;
        }

        public boolean isOpened() {
            return this.isOpened;
        }

        public boolean isSuccess() {
            return this.success;
        }

        public void setAccountBalance(String str) {
            this.accountBalance = str;
        }

        public void setAccountBalances(List<AccountBalance> list) {
            this.accountBalances = list;
        }

        public void setDistributionIconRes(int i11) {
            this.distributionIconRes = i11;
        }

        public void setDistributionName(String str) {
            this.distributionName = str;
        }

        public void setDistributionType(String str) {
            this.distributionType = str;
        }

        public void setExpanded(boolean z11) {
            this.isExpanded = z11;
        }

        public void setOpened(boolean z11) {
            this.isOpened = z11;
        }

        public void setSuccess(boolean z11) {
            this.success = z11;
        }

        public String toString() {
            return "BalanceProfitLossData.AccountBalance(success=" + isSuccess() + ", distributionType=" + getDistributionType() + ", distributionName=" + getDistributionName() + ", accountBalance=" + getAccountBalance() + ", distributionIconRes=" + getDistributionIconRes() + ", isOpened=" + isOpened() + ", accountBalances=" + getAccountBalances() + ", isExpanded=" + isExpanded() + ")";
        }
    }

    public static class UpdatedObject implements Serializable {
        private boolean success;
        private String time;

        public boolean canEqual(Object obj) {
            return obj instanceof UpdatedObject;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UpdatedObject)) {
                return false;
            }
            UpdatedObject updatedObject = (UpdatedObject) obj;
            if (!updatedObject.canEqual(this) || isSuccess() != updatedObject.isSuccess()) {
                return false;
            }
            String time2 = getTime();
            String time3 = updatedObject.getTime();
            return time2 != null ? time2.equals(time3) : time3 == null;
        }

        public String getTime() {
            return this.time;
        }

        public int hashCode() {
            int i11 = isSuccess() ? 79 : 97;
            String time2 = getTime();
            return ((i11 + 59) * 59) + (time2 == null ? 43 : time2.hashCode());
        }

        public boolean isSuccess() {
            return this.success;
        }

        public void setSuccess(boolean z11) {
            this.success = z11;
        }

        public void setTime(String str) {
            this.time = str;
        }

        public String toString() {
            return "BalanceProfitLossData.UpdatedObject(success=" + isSuccess() + ", time=" + getTime() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof BalanceProfitLossData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BalanceProfitLossData)) {
            return false;
        }
        BalanceProfitLossData balanceProfitLossData = (BalanceProfitLossData) obj;
        if (!balanceProfitLossData.canEqual(this)) {
            return false;
        }
        String userId2 = getUserId();
        String userId3 = balanceProfitLossData.getUserId();
        if (userId2 != null ? !userId2.equals(userId3) : userId3 != null) {
            return false;
        }
        String accountState2 = getAccountState();
        String accountState3 = balanceProfitLossData.getAccountState();
        if (accountState2 != null ? !accountState2.equals(accountState3) : accountState3 != null) {
            return false;
        }
        String spotRiskLevel2 = getSpotRiskLevel();
        String spotRiskLevel3 = balanceProfitLossData.getSpotRiskLevel();
        if (spotRiskLevel2 != null ? !spotRiskLevel2.equals(spotRiskLevel3) : spotRiskLevel3 != null) {
            return false;
        }
        String spotRiskRate2 = getSpotRiskRate();
        String spotRiskRate3 = balanceProfitLossData.getSpotRiskRate();
        if (spotRiskRate2 != null ? !spotRiskRate2.equals(spotRiskRate3) : spotRiskRate3 != null) {
            return false;
        }
        String todayProfit2 = getTodayProfit();
        String todayProfit3 = balanceProfitLossData.getTodayProfit();
        if (todayProfit2 != null ? !todayProfit2.equals(todayProfit3) : todayProfit3 != null) {
            return false;
        }
        UpdatedObject updated2 = getUpdated();
        UpdatedObject updated3 = balanceProfitLossData.getUpdated();
        if (updated2 != null ? !updated2.equals(updated3) : updated3 != null) {
            return false;
        }
        String totalBalance2 = getTotalBalance();
        String totalBalance3 = balanceProfitLossData.getTotalBalance();
        if (totalBalance2 != null ? !totalBalance2.equals(totalBalance3) : totalBalance3 != null) {
            return false;
        }
        String todayProfitRate2 = getTodayProfitRate();
        String todayProfitRate3 = balanceProfitLossData.getTodayProfitRate();
        if (todayProfitRate2 != null ? !todayProfitRate2.equals(todayProfitRate3) : todayProfitRate3 != null) {
            return false;
        }
        String todayCoinProfit2 = getTodayCoinProfit();
        String todayCoinProfit3 = balanceProfitLossData.getTodayCoinProfit();
        if (todayCoinProfit2 != null ? !todayCoinProfit2.equals(todayCoinProfit3) : todayCoinProfit3 != null) {
            return false;
        }
        String todayCoinProfitRate2 = getTodayCoinProfitRate();
        String todayCoinProfitRate3 = balanceProfitLossData.getTodayCoinProfitRate();
        if (todayCoinProfitRate2 != null ? !todayCoinProfitRate2.equals(todayCoinProfitRate3) : todayCoinProfitRate3 != null) {
            return false;
        }
        String totalAccumulateProfit2 = getTotalAccumulateProfit();
        String totalAccumulateProfit3 = balanceProfitLossData.getTotalAccumulateProfit();
        if (totalAccumulateProfit2 != null ? !totalAccumulateProfit2.equals(totalAccumulateProfit3) : totalAccumulateProfit3 != null) {
            return false;
        }
        List<AccountBalance> profitAccountBalanceList2 = getProfitAccountBalanceList();
        List<AccountBalance> profitAccountBalanceList3 = balanceProfitLossData.getProfitAccountBalanceList();
        if (profitAccountBalanceList2 != null ? !profitAccountBalanceList2.equals(profitAccountBalanceList3) : profitAccountBalanceList3 != null) {
            return false;
        }
        if (isHideAssetAmount() != balanceProfitLossData.isHideAssetAmount()) {
            return false;
        }
        Map<String, AccountBalance> accountBalanceMap2 = getAccountBalanceMap();
        Map<String, AccountBalance> accountBalanceMap3 = balanceProfitLossData.getAccountBalanceMap();
        if (accountBalanceMap2 != null ? accountBalanceMap2.equals(accountBalanceMap3) : accountBalanceMap3 == null) {
            return isProfitAnalyzeEnable() == balanceProfitLossData.isProfitAnalyzeEnable();
        }
        return false;
    }

    public Map<String, AccountBalance> getAccountBalanceMap() {
        if (this.accountBalanceMap == null && this.profitAccountBalanceList != null) {
            this.accountBalanceMap = new HashMap();
            for (AccountBalance next : this.profitAccountBalanceList) {
                this.accountBalanceMap.put(next.distributionType, next);
            }
        }
        return this.accountBalanceMap;
    }

    public String getAccountState() {
        return this.accountState;
    }

    public List<AccountBalance> getProfitAccountBalanceList() {
        return this.profitAccountBalanceList;
    }

    public String getSpotRiskLevel() {
        return this.spotRiskLevel;
    }

    public String getSpotRiskRate() {
        return this.spotRiskRate;
    }

    public String getTodayCoinProfit() {
        return this.todayCoinProfit;
    }

    public String getTodayCoinProfitRate() {
        return this.todayCoinProfitRate;
    }

    public String getTodayProfit() {
        return this.todayProfit;
    }

    public String getTodayProfitRate() {
        return this.todayProfitRate;
    }

    public String getTotalAccumulateProfit() {
        return this.totalAccumulateProfit;
    }

    public String getTotalBalance() {
        return this.totalBalance;
    }

    public UpdatedObject getUpdated() {
        return this.updated;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String userId2 = getUserId();
        int i11 = 43;
        int hashCode = userId2 == null ? 43 : userId2.hashCode();
        String accountState2 = getAccountState();
        int hashCode2 = ((hashCode + 59) * 59) + (accountState2 == null ? 43 : accountState2.hashCode());
        String spotRiskLevel2 = getSpotRiskLevel();
        int hashCode3 = (hashCode2 * 59) + (spotRiskLevel2 == null ? 43 : spotRiskLevel2.hashCode());
        String spotRiskRate2 = getSpotRiskRate();
        int hashCode4 = (hashCode3 * 59) + (spotRiskRate2 == null ? 43 : spotRiskRate2.hashCode());
        String todayProfit2 = getTodayProfit();
        int hashCode5 = (hashCode4 * 59) + (todayProfit2 == null ? 43 : todayProfit2.hashCode());
        UpdatedObject updated2 = getUpdated();
        int hashCode6 = (hashCode5 * 59) + (updated2 == null ? 43 : updated2.hashCode());
        String totalBalance2 = getTotalBalance();
        int hashCode7 = (hashCode6 * 59) + (totalBalance2 == null ? 43 : totalBalance2.hashCode());
        String todayProfitRate2 = getTodayProfitRate();
        int hashCode8 = (hashCode7 * 59) + (todayProfitRate2 == null ? 43 : todayProfitRate2.hashCode());
        String todayCoinProfit2 = getTodayCoinProfit();
        int hashCode9 = (hashCode8 * 59) + (todayCoinProfit2 == null ? 43 : todayCoinProfit2.hashCode());
        String todayCoinProfitRate2 = getTodayCoinProfitRate();
        int hashCode10 = (hashCode9 * 59) + (todayCoinProfitRate2 == null ? 43 : todayCoinProfitRate2.hashCode());
        String totalAccumulateProfit2 = getTotalAccumulateProfit();
        int hashCode11 = (hashCode10 * 59) + (totalAccumulateProfit2 == null ? 43 : totalAccumulateProfit2.hashCode());
        List<AccountBalance> profitAccountBalanceList2 = getProfitAccountBalanceList();
        int i12 = 79;
        int hashCode12 = (((hashCode11 * 59) + (profitAccountBalanceList2 == null ? 43 : profitAccountBalanceList2.hashCode())) * 59) + (isHideAssetAmount() ? 79 : 97);
        Map<String, AccountBalance> accountBalanceMap2 = getAccountBalanceMap();
        int i13 = hashCode12 * 59;
        if (accountBalanceMap2 != null) {
            i11 = accountBalanceMap2.hashCode();
        }
        int i14 = (i13 + i11) * 59;
        if (!isProfitAnalyzeEnable()) {
            i12 = 97;
        }
        return i14 + i12;
    }

    public boolean isHideAssetAmount() {
        return this.hideAssetAmount;
    }

    public boolean isProfitAnalyzeEnable() {
        return this.isProfitAnalyzeEnable;
    }

    public void setAccountBalanceMap(Map<String, AccountBalance> map) {
        this.accountBalanceMap = map;
    }

    public void setAccountState(String str) {
        this.accountState = str;
    }

    public void setHideAssetAmount(boolean z11) {
        this.hideAssetAmount = z11;
    }

    public void setProfitAccountBalanceList(List<AccountBalance> list) {
        this.profitAccountBalanceList = list;
    }

    public void setProfitAnalyzeEnable(boolean z11) {
        this.isProfitAnalyzeEnable = z11;
    }

    public void setSpotRiskLevel(String str) {
        this.spotRiskLevel = str;
    }

    public void setSpotRiskRate(String str) {
        this.spotRiskRate = str;
    }

    public void setTodayCoinProfit(String str) {
        this.todayCoinProfit = str;
    }

    public void setTodayCoinProfitRate(String str) {
        this.todayCoinProfitRate = str;
    }

    public void setTodayProfit(String str) {
        this.todayProfit = str;
    }

    public void setTodayProfitRate(String str) {
        this.todayProfitRate = str;
    }

    public void setTotalAccumulateProfit(String str) {
        this.totalAccumulateProfit = str;
    }

    public void setTotalBalance(String str) {
        this.totalBalance = str;
    }

    public void setUpdated(UpdatedObject updatedObject) {
        this.updated = updatedObject;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "BalanceProfitLossData(userId=" + getUserId() + ", accountState=" + getAccountState() + ", spotRiskLevel=" + getSpotRiskLevel() + ", spotRiskRate=" + getSpotRiskRate() + ", todayProfit=" + getTodayProfit() + ", updated=" + getUpdated() + ", totalBalance=" + getTotalBalance() + ", todayProfitRate=" + getTodayProfitRate() + ", todayCoinProfit=" + getTodayCoinProfit() + ", todayCoinProfitRate=" + getTodayCoinProfitRate() + ", totalAccumulateProfit=" + getTotalAccumulateProfit() + ", profitAccountBalanceList=" + getProfitAccountBalanceList() + ", hideAssetAmount=" + isHideAssetAmount() + ", accountBalanceMap=" + getAccountBalanceMap() + ", isProfitAnalyzeEnable=" + isProfitAnalyzeEnable() + ")";
    }
}
