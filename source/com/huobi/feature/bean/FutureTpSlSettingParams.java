package com.huobi.feature.bean;

import android.text.TextUtils;
import com.huobi.contract.entity.PriceType;
import com.huobi.feature.ui.FutureTpSlSettingDialogFragment;
import i6.m;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.NonNull;

public class FutureTpSlSettingParams implements Serializable {
    private BigDecimal entrustPrice;
    private boolean isTpslAdvanced;
    @NonNull
    private FutureTpSlSettingDialogFragment.OpenType openType;
    @NonNull
    private PriceType priceType = PriceType.OPTIMAL_TWENTY;
    private double tpslVolumeRate;
    private String triggerInputValue;
    private BigDecimal triggerPrice;
    private int triggerPriceInputType;
    private String triggerType;

    public FutureTpSlSettingParams(FutureTpSlSettingDialogFragment.OpenType openType2, PriceType priceType2) {
        this.openType = openType2;
        this.priceType = priceType2;
    }

    public static FutureTpSlSettingParams changeTpSlCache(FutureTpSlSettingParams futureTpSlSettingParams, FutureTpSlSettingDialogFragment.OpenType openType2, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (futureTpSlSettingParams == null) {
            FutureTpSlSettingParams futureTpSlSettingParams2 = new FutureTpSlSettingParams(openType2, PriceType.MARKET);
            futureTpSlSettingParams2.setTriggerPrice(m.a(str));
            futureTpSlSettingParams2.setEntrustPrice(BigDecimal.ZERO);
            futureTpSlSettingParams2.setTpslVolumeRate(1.0d);
            return futureTpSlSettingParams2;
        }
        futureTpSlSettingParams.setTriggerPrice(m.a(str));
        return futureTpSlSettingParams;
    }

    public BigDecimal getEntrustPrice() {
        return this.entrustPrice;
    }

    @NonNull
    public FutureTpSlSettingDialogFragment.OpenType getOpenType() {
        return this.openType;
    }

    @NonNull
    public PriceType getPriceType() {
        return this.priceType;
    }

    public double getTpslVolumeRate() {
        return 1.0d;
    }

    public int getTriggerInputType() {
        return this.triggerPriceInputType;
    }

    public String getTriggerInputValue() {
        return this.triggerInputValue;
    }

    public BigDecimal getTriggerPrice() {
        return this.triggerPrice;
    }

    public String getTriggerType() {
        return this.triggerType;
    }

    public boolean isOpenLong() {
        return this.openType == FutureTpSlSettingDialogFragment.OpenType.OpenLong;
    }

    public boolean isOpenShort() {
        return this.openType == FutureTpSlSettingDialogFragment.OpenType.OpenShort;
    }

    public boolean isTpslAdvanced() {
        return this.isTpslAdvanced;
    }

    public void setEntrustPrice(BigDecimal bigDecimal) {
        this.entrustPrice = bigDecimal;
    }

    public void setOpenType(@NonNull FutureTpSlSettingDialogFragment.OpenType openType2) {
        Objects.requireNonNull(openType2, "openType is marked @NonNull but is null");
        this.openType = openType2;
    }

    public void setPriceType(@NonNull PriceType priceType2) {
        Objects.requireNonNull(priceType2, "priceType is marked @NonNull but is null");
        this.priceType = priceType2;
    }

    public void setTpslAdvanced(boolean z11) {
        this.isTpslAdvanced = z11;
    }

    public void setTpslVolumeRate(double d11) {
        this.tpslVolumeRate = d11;
    }

    public void setTriggerInputType(int i11) {
        this.triggerPriceInputType = i11;
    }

    public void setTriggerInputValue(String str) {
        this.triggerInputValue = str;
    }

    public void setTriggerPrice(BigDecimal bigDecimal) {
        this.triggerPrice = bigDecimal;
    }

    public void setTriggerType(String str) {
        this.triggerType = str;
    }

    public FutureTpSlSettingParams(@NonNull FutureTpSlSettingParams futureTpSlSettingParams) {
        Objects.requireNonNull(futureTpSlSettingParams, "params is marked @NonNull but is null");
        setOpenType(futureTpSlSettingParams.openType);
        setTriggerPrice(futureTpSlSettingParams.triggerPrice);
        setEntrustPrice(futureTpSlSettingParams.entrustPrice);
        setPriceType(futureTpSlSettingParams.priceType);
        setTriggerInputValue(futureTpSlSettingParams.triggerInputValue);
        setTriggerType(futureTpSlSettingParams.getTriggerType());
        setTpslVolumeRate(futureTpSlSettingParams.tpslVolumeRate);
        setTriggerInputType(futureTpSlSettingParams.triggerPriceInputType);
    }
}
