package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class HomePageInvestData implements Serializable {
    public InvestDrawerDualData dual;
    public InvestDrawerSpotAndMartingaleData martingale;
    public boolean show;
    public String showTitleText;
    public InvestDrawerSpotAndMartingaleData spot;
    public InvestDrawerTradingToEarnData tradingToEarn;
    public String url;

    public static class InvestDrawerDualData {
        public String apy;
        public String covertCurrency;
        public String currency;
        public long expireTime;
        public String hookPrice;
        public String productName;
        public int productTypeId;
        public boolean show;
        public String showTitleText;
        public String symbol;
        public String url;
    }

    public static class InvestDrawerSpotAndMartingaleData {
        public String img;
        public String nick;
        public String productName;
        public boolean show;
        public String showContentText;
        public String showTitleText;
        public String totalProfitAmount;
        public String url;
        public long userId;
    }

    public static class InvestDrawerTradingToEarnData {
        public long activityId;
        public int activityStatus;
        public String allocatedScore;
        public String apyPercent;
        public String durationOfActivity;
        public long endTime;
        public long personNum;
        public String prizeAmount;
        public String prizeCurrency;
        public boolean show;
        public String showActivityTimeText;
        public String showBonusText;
        public String showParticipantsText;
        public String showScheduleText;
        public String showTitleText;
        public long startTime;
        public String symbol;
        public long systemTime;
        public String url;
    }
}
