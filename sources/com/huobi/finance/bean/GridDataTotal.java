package com.huobi.finance.bean;

import com.hbg.lib.network.hbg.grid.bean.GridAccountConvertInfo;
import java.util.ArrayList;
import java.util.List;

public class GridDataTotal extends BaseAssetTotal {
    private List<GridAccountConvertInfo> convertList = new ArrayList();
    private String estimateBalance;
    private String totalEstimateBtc;
    private String totalProfit;

    public boolean canEqual(Object obj) {
        return obj instanceof GridDataTotal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridDataTotal)) {
            return false;
        }
        GridDataTotal gridDataTotal = (GridDataTotal) obj;
        if (!gridDataTotal.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String estimateBalance2 = getEstimateBalance();
        String estimateBalance3 = gridDataTotal.getEstimateBalance();
        if (estimateBalance2 != null ? !estimateBalance2.equals(estimateBalance3) : estimateBalance3 != null) {
            return false;
        }
        String totalProfit2 = getTotalProfit();
        String totalProfit3 = gridDataTotal.getTotalProfit();
        if (totalProfit2 != null ? !totalProfit2.equals(totalProfit3) : totalProfit3 != null) {
            return false;
        }
        String totalEstimateBtc2 = getTotalEstimateBtc();
        String totalEstimateBtc3 = gridDataTotal.getTotalEstimateBtc();
        if (totalEstimateBtc2 != null ? !totalEstimateBtc2.equals(totalEstimateBtc3) : totalEstimateBtc3 != null) {
            return false;
        }
        List<GridAccountConvertInfo> convertList2 = getConvertList();
        List<GridAccountConvertInfo> convertList3 = gridDataTotal.getConvertList();
        return convertList2 != null ? convertList2.equals(convertList3) : convertList3 == null;
    }

    public List<GridAccountConvertInfo> getConvertList() {
        return this.convertList;
    }

    public String getEstimateBalance() {
        return this.estimateBalance;
    }

    public String getTotalEstimateBtc() {
        return this.totalEstimateBtc;
    }

    public String getTotalProfit() {
        return this.totalProfit;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String estimateBalance2 = getEstimateBalance();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (estimateBalance2 == null ? 43 : estimateBalance2.hashCode());
        String totalProfit2 = getTotalProfit();
        int hashCode3 = (hashCode2 * 59) + (totalProfit2 == null ? 43 : totalProfit2.hashCode());
        String totalEstimateBtc2 = getTotalEstimateBtc();
        int hashCode4 = (hashCode3 * 59) + (totalEstimateBtc2 == null ? 43 : totalEstimateBtc2.hashCode());
        List<GridAccountConvertInfo> convertList2 = getConvertList();
        int i12 = hashCode4 * 59;
        if (convertList2 != null) {
            i11 = convertList2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isAvailable() {
        return (this.estimateBalance == null && this.totalProfit == null) ? false : true;
    }

    public void setConvertList(List<GridAccountConvertInfo> list) {
        this.convertList = list;
    }

    public void setEstimateBalance(String str) {
        this.estimateBalance = str;
    }

    public void setTotalEstimateBtc(String str) {
        this.totalEstimateBtc = str;
    }

    public void setTotalProfit(String str) {
        this.totalProfit = str;
    }

    public String toString() {
        return "GridDataTotal(estimateBalance=" + getEstimateBalance() + ", totalProfit=" + getTotalProfit() + ", totalEstimateBtc=" + getTotalEstimateBtc() + ", convertList=" + getConvertList() + ")";
    }
}
