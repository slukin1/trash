package com.hbg.lib.network.hbg.prime;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class PrimeRounds implements Serializable {
    public static final String ROUND_TRADE_LIMIT_TYPE = "limit";
    public static final String ROUND_TRADE_LUCKY_TYPE = "lucky";
    public static final String ROUND_TRADE_MARKET_TYPE = "market";
    private static final long serialVersionUID = 2985541352071748754L;
    private long roundBeginTime;
    private long roundCirculation;
    private long roundEndTime;
    private String roundIssuePrice;
    private String roundLimitOrderSellPrice;
    private int roundNum;
    private String roundTradeType;

    public boolean canEqual(Object obj) {
        return obj instanceof PrimeRounds;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrimeRounds)) {
            return false;
        }
        PrimeRounds primeRounds = (PrimeRounds) obj;
        if (!primeRounds.canEqual(this) || getRoundNum() != primeRounds.getRoundNum() || getRoundBeginTime() != primeRounds.getRoundBeginTime() || getRoundEndTime() != primeRounds.getRoundEndTime() || getRoundCirculation() != primeRounds.getRoundCirculation()) {
            return false;
        }
        String roundIssuePrice2 = getRoundIssuePrice();
        String roundIssuePrice3 = primeRounds.getRoundIssuePrice();
        if (roundIssuePrice2 != null ? !roundIssuePrice2.equals(roundIssuePrice3) : roundIssuePrice3 != null) {
            return false;
        }
        String roundLimitOrderSellPrice2 = getRoundLimitOrderSellPrice();
        String roundLimitOrderSellPrice3 = primeRounds.getRoundLimitOrderSellPrice();
        if (roundLimitOrderSellPrice2 != null ? !roundLimitOrderSellPrice2.equals(roundLimitOrderSellPrice3) : roundLimitOrderSellPrice3 != null) {
            return false;
        }
        String roundTradeType2 = getRoundTradeType();
        String roundTradeType3 = primeRounds.getRoundTradeType();
        return roundTradeType2 != null ? roundTradeType2.equals(roundTradeType3) : roundTradeType3 == null;
    }

    public long getRoundBeginTime() {
        return this.roundBeginTime;
    }

    public long getRoundCirculation() {
        return this.roundCirculation;
    }

    public long getRoundEndTime() {
        return this.roundEndTime;
    }

    public String getRoundIssuePrice() {
        return this.roundIssuePrice;
    }

    public String getRoundLimitOrderSellPrice() {
        return this.roundLimitOrderSellPrice;
    }

    public int getRoundNum() {
        return this.roundNum;
    }

    public String getRoundTradeType() {
        return this.roundTradeType;
    }

    public int hashCode() {
        long roundBeginTime2 = getRoundBeginTime();
        int roundNum2 = ((getRoundNum() + 59) * 59) + ((int) (roundBeginTime2 ^ (roundBeginTime2 >>> 32)));
        long roundEndTime2 = getRoundEndTime();
        int i11 = (roundNum2 * 59) + ((int) (roundEndTime2 ^ (roundEndTime2 >>> 32)));
        long roundCirculation2 = getRoundCirculation();
        int i12 = (i11 * 59) + ((int) (roundCirculation2 ^ (roundCirculation2 >>> 32)));
        String roundIssuePrice2 = getRoundIssuePrice();
        int i13 = 43;
        int hashCode = (i12 * 59) + (roundIssuePrice2 == null ? 43 : roundIssuePrice2.hashCode());
        String roundLimitOrderSellPrice2 = getRoundLimitOrderSellPrice();
        int hashCode2 = (hashCode * 59) + (roundLimitOrderSellPrice2 == null ? 43 : roundLimitOrderSellPrice2.hashCode());
        String roundTradeType2 = getRoundTradeType();
        int i14 = hashCode2 * 59;
        if (roundTradeType2 != null) {
            i13 = roundTradeType2.hashCode();
        }
        return i14 + i13;
    }

    public void setRoundBeginTime(long j11) {
        this.roundBeginTime = j11;
    }

    public void setRoundCirculation(long j11) {
        this.roundCirculation = j11;
    }

    public void setRoundEndTime(long j11) {
        this.roundEndTime = j11;
    }

    public void setRoundIssuePrice(String str) {
        this.roundIssuePrice = str;
    }

    public void setRoundLimitOrderSellPrice(String str) {
        this.roundLimitOrderSellPrice = str;
    }

    public void setRoundNum(int i11) {
        this.roundNum = i11;
    }

    public void setRoundTradeType(String str) {
        this.roundTradeType = str;
    }

    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US);
        return "\t第" + this.roundNum + "轮 开始时间：" + simpleDateFormat.format(Long.valueOf(this.roundBeginTime)) + " 结束时间：" + simpleDateFormat.format(Long.valueOf(this.roundEndTime)) + " 发行量：" + this.roundCirculation + " 发行价：" + this.roundIssuePrice;
    }
}
