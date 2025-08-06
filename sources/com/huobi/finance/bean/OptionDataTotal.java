package com.huobi.finance.bean;

import com.hbg.lib.network.option.core.bean.OptionAccountInfo;
import java.util.List;

public class OptionDataTotal extends BaseAssetTotal {
    private List<OptionAccountInfo> optionAccountInfoList;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionDataTotal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionDataTotal)) {
            return false;
        }
        OptionDataTotal optionDataTotal = (OptionDataTotal) obj;
        if (!optionDataTotal.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        List<OptionAccountInfo> optionAccountInfoList2 = getOptionAccountInfoList();
        List<OptionAccountInfo> optionAccountInfoList3 = optionDataTotal.getOptionAccountInfoList();
        return optionAccountInfoList2 != null ? optionAccountInfoList2.equals(optionAccountInfoList3) : optionAccountInfoList3 == null;
    }

    public List<OptionAccountInfo> getOptionAccountInfoList() {
        return this.optionAccountInfoList;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        List<OptionAccountInfo> optionAccountInfoList2 = getOptionAccountInfoList();
        return (hashCode * 59) + (optionAccountInfoList2 == null ? 43 : optionAccountInfoList2.hashCode());
    }

    public void setOptionAccountInfoList(List<OptionAccountInfo> list) {
        this.optionAccountInfoList = list;
    }

    public String toString() {
        return "OptionDataTotal(optionAccountInfoList=" + getOptionAccountInfoList() + ")";
    }
}
