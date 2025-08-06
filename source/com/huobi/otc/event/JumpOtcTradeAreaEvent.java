package com.huobi.otc.event;

import com.huobi.otc.enums.OtcTradeAreaEnum;
import java.io.Serializable;

public class JumpOtcTradeAreaEvent implements Serializable {
    private OtcTradeAreaEnum childtTradeAreaEnum;
    private String coinName;
    private String fiatName;
    private boolean isToSell;
    private OtcTradeAreaEnum tradeAreaEnum;

    public boolean canEqual(Object obj) {
        return obj instanceof JumpOtcTradeAreaEvent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JumpOtcTradeAreaEvent)) {
            return false;
        }
        JumpOtcTradeAreaEvent jumpOtcTradeAreaEvent = (JumpOtcTradeAreaEvent) obj;
        if (!jumpOtcTradeAreaEvent.canEqual(this) || isToSell() != jumpOtcTradeAreaEvent.isToSell()) {
            return false;
        }
        String fiatName2 = getFiatName();
        String fiatName3 = jumpOtcTradeAreaEvent.getFiatName();
        if (fiatName2 != null ? !fiatName2.equals(fiatName3) : fiatName3 != null) {
            return false;
        }
        String coinName2 = getCoinName();
        String coinName3 = jumpOtcTradeAreaEvent.getCoinName();
        if (coinName2 != null ? !coinName2.equals(coinName3) : coinName3 != null) {
            return false;
        }
        OtcTradeAreaEnum tradeAreaEnum2 = getTradeAreaEnum();
        OtcTradeAreaEnum tradeAreaEnum3 = jumpOtcTradeAreaEvent.getTradeAreaEnum();
        if (tradeAreaEnum2 != null ? !tradeAreaEnum2.equals(tradeAreaEnum3) : tradeAreaEnum3 != null) {
            return false;
        }
        OtcTradeAreaEnum childtTradeAreaEnum2 = getChildtTradeAreaEnum();
        OtcTradeAreaEnum childtTradeAreaEnum3 = jumpOtcTradeAreaEvent.getChildtTradeAreaEnum();
        return childtTradeAreaEnum2 != null ? childtTradeAreaEnum2.equals(childtTradeAreaEnum3) : childtTradeAreaEnum3 == null;
    }

    public OtcTradeAreaEnum getChildtTradeAreaEnum() {
        return this.childtTradeAreaEnum;
    }

    public String getCoinName() {
        return this.coinName;
    }

    public String getFiatName() {
        return this.fiatName;
    }

    public OtcTradeAreaEnum getTradeAreaEnum() {
        return this.tradeAreaEnum;
    }

    public int hashCode() {
        int i11 = isToSell() ? 79 : 97;
        String fiatName2 = getFiatName();
        int i12 = 43;
        int hashCode = ((i11 + 59) * 59) + (fiatName2 == null ? 43 : fiatName2.hashCode());
        String coinName2 = getCoinName();
        int hashCode2 = (hashCode * 59) + (coinName2 == null ? 43 : coinName2.hashCode());
        OtcTradeAreaEnum tradeAreaEnum2 = getTradeAreaEnum();
        int hashCode3 = (hashCode2 * 59) + (tradeAreaEnum2 == null ? 43 : tradeAreaEnum2.hashCode());
        OtcTradeAreaEnum childtTradeAreaEnum2 = getChildtTradeAreaEnum();
        int i13 = hashCode3 * 59;
        if (childtTradeAreaEnum2 != null) {
            i12 = childtTradeAreaEnum2.hashCode();
        }
        return i13 + i12;
    }

    public boolean isToSell() {
        return this.isToSell;
    }

    public void setChildtTradeAreaEnum(OtcTradeAreaEnum otcTradeAreaEnum) {
        this.childtTradeAreaEnum = otcTradeAreaEnum;
    }

    public void setCoinName(String str) {
        this.coinName = str;
    }

    public void setFiatName(String str) {
        this.fiatName = str;
    }

    public void setToSell(boolean z11) {
        this.isToSell = z11;
    }

    public void setTradeAreaEnum(OtcTradeAreaEnum otcTradeAreaEnum) {
        this.tradeAreaEnum = otcTradeAreaEnum;
    }

    public String toString() {
        return "JumpOtcTradeAreaEvent(isToSell=" + isToSell() + ", fiatName=" + getFiatName() + ", coinName=" + getCoinName() + ", tradeAreaEnum=" + getTradeAreaEnum() + ", childtTradeAreaEnum=" + getChildtTradeAreaEnum() + ")";
    }
}
