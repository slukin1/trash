package com.huobi.account.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BalanceQueryDataV2 extends BalanceQueryData {
    @SerializedName("subaccounts")
    private List<SubaccountQueryData> subAccounts;

    public List<SubaccountQueryData> getList() {
        return this.subAccounts;
    }

    public void setList(List<SubaccountQueryData> list) {
        this.subAccounts = list;
    }
}
