package com.hbg.lib.data.symbol;

import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PrimeInfo implements Serializable {
    public static final int STATUS_END = 3;
    public static final int STATUS_IN = 2;
    public static final int STATUS_PRE = 1;
    public static final String TYPE_LISTING_TRANSFER = "listingTransfer";
    public static final String TYPE_PRIME = "prime";
    public static final String TYPE_PRIME_LITE = "primeLite";
    private static final long serialVersionUID = 2484873330150564822L;
    private long admissionEndTime;
    private transient long countDownTime;
    private String currency;
    private transient String currentPrice = "0";
    private transient PrimeRounds currentPrimeRounds;
    private transient int currentRoundNumber;
    private long currentTime;
    private transient long endTime = 0;
    private String positionPath;
    private String primeType = "primeLite";
    private transient long roundCirculation = 0;
    private transient String roundLimitOrderPrice;
    private transient String roundTradeType;
    private List<PrimeRounds> rounds;
    private String rules;
    private transient String startPrice = "0";
    private transient int status;
    private transient String stopPrice = "0";
    private String summary;
    private String supportQuoteCurrency;
    private String symbolCode;
    private transient long totalRoundCirculation = 0;
    private transient int totalRounds = 0;
    private long tradeBeginTime;
    private boolean visible = true;

    public boolean canEqual(Object obj) {
        return obj instanceof PrimeInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrimeInfo)) {
            return false;
        }
        PrimeInfo primeInfo = (PrimeInfo) obj;
        if (!primeInfo.canEqual(this)) {
            return false;
        }
        String positionPath2 = getPositionPath();
        String positionPath3 = primeInfo.getPositionPath();
        if (positionPath2 != null ? !positionPath2.equals(positionPath3) : positionPath3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = primeInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String primeType2 = getPrimeType();
        String primeType3 = primeInfo.getPrimeType();
        if (primeType2 != null ? !primeType2.equals(primeType3) : primeType3 != null) {
            return false;
        }
        String symbolCode2 = getSymbolCode();
        String symbolCode3 = primeInfo.getSymbolCode();
        if (symbolCode2 != null ? !symbolCode2.equals(symbolCode3) : symbolCode3 != null) {
            return false;
        }
        if (getCurrentTime() != primeInfo.getCurrentTime() || getAdmissionEndTime() != primeInfo.getAdmissionEndTime()) {
            return false;
        }
        String summary2 = getSummary();
        String summary3 = primeInfo.getSummary();
        if (summary2 != null ? !summary2.equals(summary3) : summary3 != null) {
            return false;
        }
        String rules2 = getRules();
        String rules3 = primeInfo.getRules();
        if (rules2 != null ? !rules2.equals(rules3) : rules3 != null) {
            return false;
        }
        if (getTradeBeginTime() != primeInfo.getTradeBeginTime()) {
            return false;
        }
        List<PrimeRounds> rounds2 = getRounds();
        List<PrimeRounds> rounds3 = primeInfo.getRounds();
        if (rounds2 != null ? !rounds2.equals(rounds3) : rounds3 != null) {
            return false;
        }
        String supportQuoteCurrency2 = getSupportQuoteCurrency();
        String supportQuoteCurrency3 = primeInfo.getSupportQuoteCurrency();
        if (supportQuoteCurrency2 != null ? supportQuoteCurrency2.equals(supportQuoteCurrency3) : supportQuoteCurrency3 == null) {
            return isVisible() == primeInfo.isVisible();
        }
        return false;
    }

    public long getAdmissionEndTime() {
        return this.admissionEndTime;
    }

    public long getCountDownTime() {
        return this.countDownTime;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getCurrentPrice() {
        return this.currentPrice;
    }

    public PrimeRounds getCurrentPrimeRounds() {
        return this.currentPrimeRounds;
    }

    public int getCurrentRoundNumber() {
        return this.currentRoundNumber;
    }

    public long getCurrentTime() {
        return this.currentTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getPositionPath() {
        return this.positionPath;
    }

    public String getPrimeType() {
        return this.primeType;
    }

    public long getRoundCirculation() {
        return this.roundCirculation;
    }

    public String getRoundLimitOrderPrice() {
        return this.roundLimitOrderPrice;
    }

    public String getRoundTradeType() {
        return this.roundTradeType;
    }

    public List<PrimeRounds> getRounds() {
        return this.rounds;
    }

    public String getRules() {
        return this.rules;
    }

    public String getStartPrice() {
        return this.startPrice;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStopPrice() {
        return this.stopPrice;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getSupportQuoteCurrency() {
        return this.supportQuoteCurrency;
    }

    public String getSymbolCode() {
        return this.symbolCode;
    }

    public long getTotalRoundCirculation() {
        return this.totalRoundCirculation;
    }

    public int getTotalRounds() {
        return this.totalRounds;
    }

    public long getTradeBeginTime() {
        return this.tradeBeginTime;
    }

    public int hashCode() {
        String positionPath2 = getPositionPath();
        int i11 = 43;
        int hashCode = positionPath2 == null ? 43 : positionPath2.hashCode();
        String currency2 = getCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String primeType2 = getPrimeType();
        int hashCode3 = (hashCode2 * 59) + (primeType2 == null ? 43 : primeType2.hashCode());
        String symbolCode2 = getSymbolCode();
        int hashCode4 = (hashCode3 * 59) + (symbolCode2 == null ? 43 : symbolCode2.hashCode());
        long currentTime2 = getCurrentTime();
        int i12 = (hashCode4 * 59) + ((int) (currentTime2 ^ (currentTime2 >>> 32)));
        long admissionEndTime2 = getAdmissionEndTime();
        int i13 = (i12 * 59) + ((int) (admissionEndTime2 ^ (admissionEndTime2 >>> 32)));
        String summary2 = getSummary();
        int hashCode5 = (i13 * 59) + (summary2 == null ? 43 : summary2.hashCode());
        String rules2 = getRules();
        int hashCode6 = (hashCode5 * 59) + (rules2 == null ? 43 : rules2.hashCode());
        long tradeBeginTime2 = getTradeBeginTime();
        int i14 = (hashCode6 * 59) + ((int) (tradeBeginTime2 ^ (tradeBeginTime2 >>> 32)));
        List<PrimeRounds> rounds2 = getRounds();
        int hashCode7 = (i14 * 59) + (rounds2 == null ? 43 : rounds2.hashCode());
        String supportQuoteCurrency2 = getSupportQuoteCurrency();
        int i15 = hashCode7 * 59;
        if (supportQuoteCurrency2 != null) {
            i11 = supportQuoteCurrency2.hashCode();
        }
        return ((i15 + i11) * 59) + (isVisible() ? 79 : 97);
    }

    public PrimeInfo initTestData() {
        setCurrency("btc/usdt");
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        long j11 = currentTimeMillis - 30000;
        int i11 = 0;
        while (i11 < 1) {
            PrimeRounds primeRounds = new PrimeRounds();
            int i12 = i11 + 1;
            primeRounds.setRoundNum(i12);
            long j12 = currentTimeMillis + (((long) i11) * 60000);
            primeRounds.setRoundBeginTime(j12);
            currentTimeMillis = j12 + 60000;
            primeRounds.setRoundEndTime(currentTimeMillis);
            primeRounds.setRoundCirculation(1000000);
            primeRounds.setRoundIssuePrice(String.valueOf((((double) i11) * 0.015d) + 0.015d));
            arrayList.add(primeRounds);
            i11 = i12;
        }
        setRounds(arrayList);
        setTradeBeginTime(currentTimeMillis + 60000);
        setCurrentTime(j11);
        return this;
    }

    public boolean isListingTransfer() {
        return "listingTransfer".equalsIgnoreCase(getPrimeType());
    }

    public boolean isPrime() {
        return "prime".equalsIgnoreCase(getPrimeType());
    }

    public boolean isPrimeLite() {
        return "primeLite".equalsIgnoreCase(getPrimeType());
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void parseData() {
        if (this.rounds != null) {
            RetrofitLogger.a("-----------------------------------------------------");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
            RetrofitLogger.a("currentTime = " + simpleDateFormat.format(new Date(this.currentTime)));
            this.status = 3;
            this.totalRoundCirculation = 0;
            this.totalRounds = this.rounds.size();
            for (int i11 = 0; i11 < this.rounds.size(); i11++) {
                PrimeRounds primeRounds = this.rounds.get(i11);
                this.totalRoundCirculation += primeRounds.getRoundCirculation();
                if (i11 == 0) {
                    this.startPrice = primeRounds.getRoundIssuePrice();
                } else if (i11 == this.rounds.size() - 1) {
                    this.stopPrice = primeRounds.getRoundIssuePrice();
                }
                if (this.currentTime < primeRounds.getRoundBeginTime()) {
                    if (this.status == 3) {
                        this.status = 1;
                        this.countDownTime = primeRounds.getRoundBeginTime() - this.currentTime;
                        this.currentPrimeRounds = primeRounds;
                        this.currentRoundNumber = primeRounds.getRoundNum();
                        this.currentPrice = primeRounds.getRoundIssuePrice();
                        this.roundCirculation = primeRounds.getRoundCirculation();
                        this.roundLimitOrderPrice = primeRounds.getRoundLimitOrderSellPrice();
                        this.roundTradeType = primeRounds.getRoundTradeType();
                    }
                } else if (this.currentTime >= primeRounds.getRoundBeginTime() && this.currentTime < primeRounds.getRoundEndTime()) {
                    this.status = 2;
                    this.countDownTime = primeRounds.getRoundEndTime() - this.currentTime;
                    this.currentPrimeRounds = primeRounds;
                    this.currentRoundNumber = primeRounds.getRoundNum();
                    this.currentPrice = primeRounds.getRoundIssuePrice();
                    this.roundCirculation = primeRounds.getRoundCirculation();
                    this.roundLimitOrderPrice = primeRounds.getRoundLimitOrderSellPrice();
                    this.roundTradeType = primeRounds.getRoundTradeType();
                } else if (this.status != 2) {
                    this.status = 3;
                    this.endTime = primeRounds.getRoundEndTime();
                }
                RetrofitLogger.a("PrimeInfo-->parseData--> roundNum = " + primeRounds.getRoundNum() + " roundBeginTime = " + simpleDateFormat.format(new Date(primeRounds.getRoundBeginTime())) + " roundEndTime = " + simpleDateFormat.format(new Date(primeRounds.getRoundEndTime())) + " status = " + this.status + " currentRoundNumber = " + this.currentRoundNumber + " countDownTime = " + simpleDateFormat.format(new Date(this.countDownTime)));
            }
            RetrofitLogger.a("-----------------------------------------------------");
        }
    }

    public void setAdmissionEndTime(long j11) {
        this.admissionEndTime = j11;
    }

    public void setCountDownTime(long j11) {
        this.countDownTime = j11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setCurrentPrice(String str) {
        this.currentPrice = str;
    }

    public void setCurrentPrimeRounds(PrimeRounds primeRounds) {
        this.currentPrimeRounds = primeRounds;
    }

    public void setCurrentRoundNumber(int i11) {
        this.currentRoundNumber = i11;
    }

    public void setCurrentTime(long j11) {
        this.currentTime = j11;
    }

    public void setEndTime(long j11) {
        this.endTime = j11;
    }

    public void setPositionPath(String str) {
        this.positionPath = str;
    }

    public void setPrimeType(String str) {
        this.primeType = str;
    }

    public void setRoundCirculation(long j11) {
        this.roundCirculation = j11;
    }

    public void setRoundLimitOrderPrice(String str) {
        this.roundLimitOrderPrice = str;
    }

    public void setRoundTradeType(String str) {
        this.roundTradeType = str;
    }

    public void setRounds(List<PrimeRounds> list) {
        this.rounds = list;
    }

    public void setRules(String str) {
        this.rules = str;
    }

    public void setStartPrice(String str) {
        this.startPrice = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setStopPrice(String str) {
        this.stopPrice = str;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public void setSupportQuoteCurrency(String str) {
        this.supportQuoteCurrency = str;
    }

    public void setSymbolCode(String str) {
        this.symbolCode = str;
    }

    public void setTotalRoundCirculation(long j11) {
        this.totalRoundCirculation = j11;
    }

    public void setTotalRounds(int i11) {
        this.totalRounds = i11;
    }

    public void setTradeBeginTime(long j11) {
        this.tradeBeginTime = j11;
    }

    public void setVisible(boolean z11) {
        this.visible = z11;
    }

    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US);
        String str = "\nPrimeInfo-->\n\t币种：" + this.currency + "\n\t交易对：" + this.symbolCode + "\n\t抢购状态：" + this.status + "\n\t当前时间：" + simpleDateFormat.format(new Date(this.currentTime)) + "\n\t准入结束时间：" + simpleDateFormat.format(new Date(this.admissionEndTime)) + "\n\t倒计时：" + this.countDownTime + "\n\t本轮信息：" + this.currentPrimeRounds + "\n\t本轮轮次号：" + this.currentRoundNumber + "\n\t第一轮开盘价：" + this.startPrice + "\n\t最后一轮开盘价：" + this.stopPrice + "\n\t本轮开盘价：" + this.currentPrice + "\n\t本轮发行量：" + this.roundCirculation + "\n\t本期结束时间：" + simpleDateFormat.format(new Date(this.endTime)) + "\n\t总数量：" + this.totalRoundCirculation + "\n\tsummary：" + this.summary + "\n\trules：" + this.rules;
        StringBuilder sb2 = new StringBuilder();
        List<PrimeRounds> list = this.rounds;
        if (list != null) {
            for (PrimeRounds append : list) {
                sb2.append("\n");
                sb2.append(append);
            }
        } else {
            sb2.append(OptionsBridge.NULL_VALUE);
        }
        return str + sb2.toString();
    }
}
