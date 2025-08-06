package com.huobi.finance.bean;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.YbbUserAssetInfoData;
import com.huobi.finance.viewhandler.AssetSpotItemViewAdapter;
import com.huobi.finance.viewhandler.BalanceViewAdapter;
import i6.m;
import java.math.BigDecimal;

public class BalanceDetailInfo extends BaseAssetInfo {
    public static final int FLAG_STATUS_CANNOT_DEPOSIT = 2;
    public static final int FLAG_STATUS_CANNOT_LEGAL_TRADE = 32;
    public static final int FLAG_STATUS_CANNOT_WITHDRAW = 4;
    public static final int FLAG_STATUS_INVISIBLE = 1;
    public static final int FLAG_STATUS_IN_BLACKLIST = 8;
    public static final int FLAG_STATUS_IN_WHITELIST = 16;
    private String availableWithYbb;
    private String descCanNotDeposit;
    private String descCanNotWithDraw;
    private String descInvisible;
    private int status;
    private TradeType tradeType;
    private YbbUserAssetInfoData.DetailsDTO ybbAsset;

    public boolean canEqual(Object obj) {
        return obj instanceof BalanceDetailInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BalanceDetailInfo)) {
            return false;
        }
        BalanceDetailInfo balanceDetailInfo = (BalanceDetailInfo) obj;
        if (!balanceDetailInfo.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        TradeType tradeType2 = getTradeType();
        TradeType tradeType3 = balanceDetailInfo.getTradeType();
        if (tradeType2 != null ? !tradeType2.equals(tradeType3) : tradeType3 != null) {
            return false;
        }
        if (getStatus() != balanceDetailInfo.getStatus()) {
            return false;
        }
        String descCanNotDeposit2 = getDescCanNotDeposit();
        String descCanNotDeposit3 = balanceDetailInfo.getDescCanNotDeposit();
        if (descCanNotDeposit2 != null ? !descCanNotDeposit2.equals(descCanNotDeposit3) : descCanNotDeposit3 != null) {
            return false;
        }
        String descCanNotWithDraw2 = getDescCanNotWithDraw();
        String descCanNotWithDraw3 = balanceDetailInfo.getDescCanNotWithDraw();
        if (descCanNotWithDraw2 != null ? !descCanNotWithDraw2.equals(descCanNotWithDraw3) : descCanNotWithDraw3 != null) {
            return false;
        }
        String descInvisible2 = getDescInvisible();
        String descInvisible3 = balanceDetailInfo.getDescInvisible();
        if (descInvisible2 != null ? !descInvisible2.equals(descInvisible3) : descInvisible3 != null) {
            return false;
        }
        YbbUserAssetInfoData.DetailsDTO ybbAsset2 = getYbbAsset();
        YbbUserAssetInfoData.DetailsDTO ybbAsset3 = balanceDetailInfo.getYbbAsset();
        if (ybbAsset2 != null ? !ybbAsset2.equals(ybbAsset3) : ybbAsset3 != null) {
            return false;
        }
        String availableWithYbb2 = getAvailableWithYbb();
        String availableWithYbb3 = balanceDetailInfo.getAvailableWithYbb();
        return availableWithYbb2 != null ? availableWithYbb2.equals(availableWithYbb3) : availableWithYbb3 == null;
    }

    public String getAvailableWithYbb() {
        return this.availableWithYbb;
    }

    public String getDescCanNotDeposit() {
        return this.descCanNotDeposit;
    }

    public String getDescCanNotWithDraw() {
        return this.descCanNotWithDraw;
    }

    public String getDescInvisible() {
        return this.descInvisible;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTitle() {
        return getDisplayName();
    }

    public TradeType getTradeType() {
        return this.tradeType;
    }

    public String getViewHandlerName() {
        return AssetSpotItemViewAdapter.class.getName();
    }

    public YbbUserAssetInfoData.DetailsDTO getYbbAsset() {
        return this.ybbAsset;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        TradeType tradeType2 = getTradeType();
        int i11 = 43;
        int hashCode2 = (((hashCode * 59) + (tradeType2 == null ? 43 : tradeType2.hashCode())) * 59) + getStatus();
        String descCanNotDeposit2 = getDescCanNotDeposit();
        int hashCode3 = (hashCode2 * 59) + (descCanNotDeposit2 == null ? 43 : descCanNotDeposit2.hashCode());
        String descCanNotWithDraw2 = getDescCanNotWithDraw();
        int hashCode4 = (hashCode3 * 59) + (descCanNotWithDraw2 == null ? 43 : descCanNotWithDraw2.hashCode());
        String descInvisible2 = getDescInvisible();
        int hashCode5 = (hashCode4 * 59) + (descInvisible2 == null ? 43 : descInvisible2.hashCode());
        YbbUserAssetInfoData.DetailsDTO ybbAsset2 = getYbbAsset();
        int hashCode6 = (hashCode5 * 59) + (ybbAsset2 == null ? 43 : ybbAsset2.hashCode());
        String availableWithYbb2 = getAvailableWithYbb();
        int i12 = hashCode6 * 59;
        if (availableWithYbb2 != null) {
            i11 = availableWithYbb2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isMinAmountAsset() {
        if (BalanceViewAdapter.class.getName().equals(getViewHandlerName())) {
            if (m.a(getEstimateAmount()).compareTo(BigDecimal.ZERO) == 0) {
                return true;
            }
            return false;
        } else if (!AssetSpotItemViewAdapter.class.getName().equals(getViewHandlerName())) {
            return super.isMinAmountAsset();
        } else {
            if (m.a(getHoldingsNum()).compareTo(BigDecimal.ZERO) == 0 && m.a(getEstimateAmount()).compareTo(BigDecimal.ZERO) == 0) {
                return true;
            }
            return false;
        }
    }

    public boolean isTruncationZero() {
        return m.a(m.u0(m.a(getAvaialAble()).add(m.a(getOnOrders())).add(m.a(getLock())).toPlainString(), 12, 8)).compareTo(BigDecimal.ZERO) == 0;
    }

    public void setAvailableWithYbb(String str) {
        this.availableWithYbb = str;
    }

    public void setDescCanNotDeposit(String str) {
        this.descCanNotDeposit = str;
    }

    public void setDescCanNotWithDraw(String str) {
        this.descCanNotWithDraw = str;
    }

    public void setDescInvisible(String str) {
        this.descInvisible = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setTradeType(TradeType tradeType2) {
        this.tradeType = tradeType2;
    }

    public void setYbbAsset(YbbUserAssetInfoData.DetailsDTO detailsDTO) {
        this.ybbAsset = detailsDTO;
    }

    public String toString() {
        return "BalanceDetailInfo(tradeType=" + getTradeType() + ", status=" + getStatus() + ", descCanNotDeposit=" + getDescCanNotDeposit() + ", descCanNotWithDraw=" + getDescCanNotWithDraw() + ", descInvisible=" + getDescInvisible() + ", ybbAsset=" + getYbbAsset() + ", availableWithYbb=" + getAvailableWithYbb() + ")";
    }
}
