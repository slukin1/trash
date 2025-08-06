package com.huobi.staring.bean;

import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.huobi.staring.viewhandler.RemindSearchListItemHandler;
import java.io.Serializable;
import ka.a;
import pro.huobi.R;

public class RemindSearchListItem implements a, Serializable {
    private RemindBusinessType businessType;
    private RemindContractType contractType;
    private boolean isContract;
    private String showSubTitle;
    private String showTitle;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof RemindSearchListItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemindSearchListItem)) {
            return false;
        }
        RemindSearchListItem remindSearchListItem = (RemindSearchListItem) obj;
        if (!remindSearchListItem.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = remindSearchListItem.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String showTitle2 = getShowTitle();
        String showTitle3 = remindSearchListItem.getShowTitle();
        if (showTitle2 != null ? !showTitle2.equals(showTitle3) : showTitle3 != null) {
            return false;
        }
        String showSubTitle2 = getShowSubTitle();
        String showSubTitle3 = remindSearchListItem.getShowSubTitle();
        if (showSubTitle2 != null ? !showSubTitle2.equals(showSubTitle3) : showSubTitle3 != null) {
            return false;
        }
        if (isContract() != remindSearchListItem.isContract()) {
            return false;
        }
        RemindContractType contractType2 = getContractType();
        RemindContractType contractType3 = remindSearchListItem.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        RemindBusinessType businessType2 = getBusinessType();
        RemindBusinessType businessType3 = remindSearchListItem.getBusinessType();
        return businessType2 != null ? businessType2.equals(businessType3) : businessType3 == null;
    }

    public RemindBusinessType getBusinessType() {
        return this.businessType;
    }

    public RemindContractType getContractType() {
        return this.contractType;
    }

    public int getResId() {
        return R.layout.staring_layout_remind_search_list_item;
    }

    public String getShowSubTitle() {
        return this.showSubTitle;
    }

    public String getShowTitle() {
        return this.showTitle;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getViewHandlerName() {
        return RemindSearchListItemHandler.class.getName();
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String showTitle2 = getShowTitle();
        int hashCode2 = ((hashCode + 59) * 59) + (showTitle2 == null ? 43 : showTitle2.hashCode());
        String showSubTitle2 = getShowSubTitle();
        int hashCode3 = (((hashCode2 * 59) + (showSubTitle2 == null ? 43 : showSubTitle2.hashCode())) * 59) + (isContract() ? 79 : 97);
        RemindContractType contractType2 = getContractType();
        int hashCode4 = (hashCode3 * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        RemindBusinessType businessType2 = getBusinessType();
        int i12 = hashCode4 * 59;
        if (businessType2 != null) {
            i11 = businessType2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isContract() {
        return this.isContract;
    }

    public boolean isSticky() {
        return false;
    }

    public void setBusinessType(RemindBusinessType remindBusinessType) {
        this.businessType = remindBusinessType;
    }

    public void setContract(boolean z11) {
        this.isContract = z11;
    }

    public void setContractType(RemindContractType remindContractType) {
        this.contractType = remindContractType;
    }

    public void setShowSubTitle(String str) {
        this.showSubTitle = str;
    }

    public void setShowTitle(String str) {
        this.showTitle = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "RemindSearchListItem(symbol=" + getSymbol() + ", showTitle=" + getShowTitle() + ", showSubTitle=" + getShowSubTitle() + ", isContract=" + isContract() + ", contractType=" + getContractType() + ", businessType=" + getBusinessType() + ")";
    }
}
