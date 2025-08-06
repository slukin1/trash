package com.huobi.feature.bean;

import com.hbg.lib.data.symbol.TradeType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.NonNull;

public class FutureTpSlDialogShowBean implements Serializable {
    @NonNull
    private Long contVolume;
    private String contractCode;
    @NonNull
    private BigDecimal contractFace;
    private String contractShortType;
    private String contractType;
    private BigDecimal entrustPrice;
    private boolean isSingleMode = false;
    @NonNull
    private String lever;
    private String marginMode;
    private int predictProfitPrecision;
    private int pricePrecision;
    private FutureTpSlSettingParams stopLossSetting;
    private FutureTpSlSettingParams stopProfitSetting;
    @NonNull
    private String symbol;
    @NonNull
    private TradeType tradeType;
    private Long volume;

    @NonNull
    public Long getContVolume() {
        return this.contVolume;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    @NonNull
    public BigDecimal getContractFace() {
        return this.contractFace;
    }

    public String getContractShortType() {
        return this.contractShortType;
    }

    public String getContractType() {
        return this.contractType;
    }

    public BigDecimal getEntrustPrice() {
        return this.entrustPrice;
    }

    @NonNull
    public String getLever() {
        return this.lever;
    }

    public String getMarginMode() {
        return this.marginMode;
    }

    public int getPredictProfitPrecision() {
        return this.predictProfitPrecision;
    }

    public int getPricePrecision() {
        return this.pricePrecision;
    }

    public FutureTpSlSettingParams getStopLossSetting() {
        return this.stopLossSetting;
    }

    public FutureTpSlSettingParams getStopProfitSetting() {
        return this.stopProfitSetting;
    }

    public String getSymbol() {
        return this.symbol;
    }

    @NonNull
    public TradeType getTradeType() {
        return this.tradeType;
    }

    public Long getVolume() {
        return this.volume;
    }

    public boolean isLinearSwap() {
        return this.tradeType == TradeType.LINEAR_SWAP;
    }

    public boolean isSingleMode() {
        return this.isSingleMode;
    }

    public boolean isSwap() {
        return this.tradeType == TradeType.SWAP;
    }

    public void setContVolume(@NonNull Long l11) {
        Objects.requireNonNull(l11, "contVolume is marked @NonNull but is null");
        this.contVolume = l11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractFace(@NonNull BigDecimal bigDecimal) {
        Objects.requireNonNull(bigDecimal, "contractFace is marked @NonNull but is null");
        this.contractFace = bigDecimal;
    }

    public void setContractShortType(String str) {
        this.contractShortType = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setEntrustPrice(BigDecimal bigDecimal) {
        this.entrustPrice = bigDecimal;
    }

    public void setLever(@NonNull String str) {
        Objects.requireNonNull(str, "lever is marked @NonNull but is null");
        this.lever = str;
    }

    public void setMarginMode(String str) {
        this.marginMode = str;
    }

    public void setPredictProfitPrecision(int i11) {
        this.predictProfitPrecision = i11;
    }

    public void setPricePrecision(int i11) {
        this.pricePrecision = i11;
    }

    public void setSingleMode(boolean z11) {
        this.isSingleMode = z11;
    }

    public void setStopLossSetting(FutureTpSlSettingParams futureTpSlSettingParams) {
        this.stopLossSetting = futureTpSlSettingParams;
    }

    public void setStopProfitSetting(FutureTpSlSettingParams futureTpSlSettingParams) {
        this.stopProfitSetting = futureTpSlSettingParams;
    }

    public void setSymbol(@NonNull String str) {
        Objects.requireNonNull(str, "symbol is marked @NonNull but is null");
        this.symbol = str;
    }

    public void setTradeType(@NonNull TradeType tradeType2) {
        Objects.requireNonNull(tradeType2, "tradeType is marked @NonNull but is null");
        this.tradeType = tradeType2;
    }

    public void setVolume(Long l11) {
        this.volume = l11;
    }
}
