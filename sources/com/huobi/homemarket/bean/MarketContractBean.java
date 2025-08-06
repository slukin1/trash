package com.huobi.homemarket.bean;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.huobi.contract.entity.ContractHeartBeat;
import java.io.Serializable;
import java.util.List;

public class MarketContractBean implements Serializable {
    private List<ContractCurrencyInfo> contractCurrencyInfoList;
    private ContractHeartBeat contractHeartBeat;
    private List<IndexCurrencyInfo> indexCurrencyInfoList;
    private List<FutureContractInfo> linearSwapCurrencyInfoList;
    private List<SwapCurrencyInfo> swapCurrencyInfoList;

    public MarketContractBean() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof MarketContractBean;
    }

    public boolean contractHasData() {
        List<ContractCurrencyInfo> list = this.contractCurrencyInfoList;
        return list != null && !list.isEmpty();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketContractBean)) {
            return false;
        }
        MarketContractBean marketContractBean = (MarketContractBean) obj;
        if (!marketContractBean.canEqual(this)) {
            return false;
        }
        ContractHeartBeat contractHeartBeat2 = getContractHeartBeat();
        ContractHeartBeat contractHeartBeat3 = marketContractBean.getContractHeartBeat();
        if (contractHeartBeat2 != null ? !contractHeartBeat2.equals(contractHeartBeat3) : contractHeartBeat3 != null) {
            return false;
        }
        List<ContractCurrencyInfo> contractCurrencyInfoList2 = getContractCurrencyInfoList();
        List<ContractCurrencyInfo> contractCurrencyInfoList3 = marketContractBean.getContractCurrencyInfoList();
        if (contractCurrencyInfoList2 != null ? !contractCurrencyInfoList2.equals(contractCurrencyInfoList3) : contractCurrencyInfoList3 != null) {
            return false;
        }
        List<SwapCurrencyInfo> swapCurrencyInfoList2 = getSwapCurrencyInfoList();
        List<SwapCurrencyInfo> swapCurrencyInfoList3 = marketContractBean.getSwapCurrencyInfoList();
        if (swapCurrencyInfoList2 != null ? !swapCurrencyInfoList2.equals(swapCurrencyInfoList3) : swapCurrencyInfoList3 != null) {
            return false;
        }
        List<IndexCurrencyInfo> indexCurrencyInfoList2 = getIndexCurrencyInfoList();
        List<IndexCurrencyInfo> indexCurrencyInfoList3 = marketContractBean.getIndexCurrencyInfoList();
        if (indexCurrencyInfoList2 != null ? !indexCurrencyInfoList2.equals(indexCurrencyInfoList3) : indexCurrencyInfoList3 != null) {
            return false;
        }
        List<FutureContractInfo> linearSwapCurrencyInfoList2 = getLinearSwapCurrencyInfoList();
        List<FutureContractInfo> linearSwapCurrencyInfoList3 = marketContractBean.getLinearSwapCurrencyInfoList();
        return linearSwapCurrencyInfoList2 != null ? linearSwapCurrencyInfoList2.equals(linearSwapCurrencyInfoList3) : linearSwapCurrencyInfoList3 == null;
    }

    public List<ContractCurrencyInfo> getContractCurrencyInfoList() {
        return this.contractCurrencyInfoList;
    }

    public ContractHeartBeat getContractHeartBeat() {
        return this.contractHeartBeat;
    }

    public List<IndexCurrencyInfo> getIndexCurrencyInfoList() {
        return this.indexCurrencyInfoList;
    }

    public List<FutureContractInfo> getLinearSwapCurrencyInfoList() {
        return this.linearSwapCurrencyInfoList;
    }

    public List<SwapCurrencyInfo> getSwapCurrencyInfoList() {
        return this.swapCurrencyInfoList;
    }

    public int hashCode() {
        ContractHeartBeat contractHeartBeat2 = getContractHeartBeat();
        int i11 = 43;
        int hashCode = contractHeartBeat2 == null ? 43 : contractHeartBeat2.hashCode();
        List<ContractCurrencyInfo> contractCurrencyInfoList2 = getContractCurrencyInfoList();
        int hashCode2 = ((hashCode + 59) * 59) + (contractCurrencyInfoList2 == null ? 43 : contractCurrencyInfoList2.hashCode());
        List<SwapCurrencyInfo> swapCurrencyInfoList2 = getSwapCurrencyInfoList();
        int hashCode3 = (hashCode2 * 59) + (swapCurrencyInfoList2 == null ? 43 : swapCurrencyInfoList2.hashCode());
        List<IndexCurrencyInfo> indexCurrencyInfoList2 = getIndexCurrencyInfoList();
        int hashCode4 = (hashCode3 * 59) + (indexCurrencyInfoList2 == null ? 43 : indexCurrencyInfoList2.hashCode());
        List<FutureContractInfo> linearSwapCurrencyInfoList2 = getLinearSwapCurrencyInfoList();
        int i12 = hashCode4 * 59;
        if (linearSwapCurrencyInfoList2 != null) {
            i11 = linearSwapCurrencyInfoList2.hashCode();
        }
        return i12 + i11;
    }

    public boolean indexHasData() {
        List<IndexCurrencyInfo> list = this.indexCurrencyInfoList;
        return list != null && !list.isEmpty();
    }

    public boolean isNotEmpty() {
        List<ContractCurrencyInfo> list = this.contractCurrencyInfoList;
        if (list != null && !list.isEmpty()) {
            return true;
        }
        List<SwapCurrencyInfo> list2 = this.swapCurrencyInfoList;
        if (list2 != null && !list2.isEmpty()) {
            return true;
        }
        List<FutureContractInfo> list3 = this.linearSwapCurrencyInfoList;
        if (list3 != null && !list3.isEmpty()) {
            return true;
        }
        List<IndexCurrencyInfo> list4 = this.indexCurrencyInfoList;
        if (list4 == null || list4.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean linearSwapHasData() {
        List<FutureContractInfo> list = this.linearSwapCurrencyInfoList;
        return list != null && !list.isEmpty();
    }

    public void setContractCurrencyInfoList(List<ContractCurrencyInfo> list) {
        this.contractCurrencyInfoList = list;
    }

    public void setContractHeartBeat(ContractHeartBeat contractHeartBeat2) {
        this.contractHeartBeat = contractHeartBeat2;
    }

    public void setIndexCurrencyInfoList(List<IndexCurrencyInfo> list) {
        this.indexCurrencyInfoList = list;
    }

    public void setLinearSwapCurrencyInfoList(List<FutureContractInfo> list) {
        this.linearSwapCurrencyInfoList = list;
    }

    public void setSwapCurrencyInfoList(List<SwapCurrencyInfo> list) {
        this.swapCurrencyInfoList = list;
    }

    public boolean swapHasData() {
        List<SwapCurrencyInfo> list = this.swapCurrencyInfoList;
        return list != null && !list.isEmpty();
    }

    public String toString() {
        return "MarketContractBean(contractHeartBeat=" + getContractHeartBeat() + ", contractCurrencyInfoList=" + getContractCurrencyInfoList() + ", swapCurrencyInfoList=" + getSwapCurrencyInfoList() + ", indexCurrencyInfoList=" + getIndexCurrencyInfoList() + ", linearSwapCurrencyInfoList=" + getLinearSwapCurrencyInfoList() + ")";
    }

    public MarketContractBean(ContractHeartBeat contractHeartBeat2, List<ContractCurrencyInfo> list, List<SwapCurrencyInfo> list2, List<IndexCurrencyInfo> list3) {
        this.contractHeartBeat = contractHeartBeat2;
        this.contractCurrencyInfoList = list;
        this.swapCurrencyInfoList = list2;
        this.indexCurrencyInfoList = list3;
    }
}
