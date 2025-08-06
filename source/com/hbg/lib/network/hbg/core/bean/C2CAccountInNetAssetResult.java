package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class C2CAccountInNetAssetResult implements Serializable {
    private String accountId;
    private List<C2CAccountOutNetAssetInfo> list;
    private String risk;
    private String state;
    private String subtype;
    private String type;

    public boolean canEqual(Object obj) {
        return obj instanceof C2CAccountInNetAssetResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2CAccountInNetAssetResult)) {
            return false;
        }
        C2CAccountInNetAssetResult c2CAccountInNetAssetResult = (C2CAccountInNetAssetResult) obj;
        if (!c2CAccountInNetAssetResult.canEqual(this)) {
            return false;
        }
        String accountId2 = getAccountId();
        String accountId3 = c2CAccountInNetAssetResult.getAccountId();
        if (accountId2 != null ? !accountId2.equals(accountId3) : accountId3 != null) {
            return false;
        }
        String type2 = getType();
        String type3 = c2CAccountInNetAssetResult.getType();
        if (type2 != null ? !type2.equals(type3) : type3 != null) {
            return false;
        }
        String state2 = getState();
        String state3 = c2CAccountInNetAssetResult.getState();
        if (state2 != null ? !state2.equals(state3) : state3 != null) {
            return false;
        }
        String subtype2 = getSubtype();
        String subtype3 = c2CAccountInNetAssetResult.getSubtype();
        if (subtype2 != null ? !subtype2.equals(subtype3) : subtype3 != null) {
            return false;
        }
        String risk2 = getRisk();
        String risk3 = c2CAccountInNetAssetResult.getRisk();
        if (risk2 != null ? !risk2.equals(risk3) : risk3 != null) {
            return false;
        }
        List<C2CAccountOutNetAssetInfo> list2 = getList();
        List<C2CAccountOutNetAssetInfo> list3 = c2CAccountInNetAssetResult.getList();
        return list2 != null ? list2.equals(list3) : list3 == null;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public List<C2CAccountOutNetAssetInfo> getList() {
        return this.list;
    }

    public String getRisk() {
        return this.risk;
    }

    public String getState() {
        return this.state;
    }

    public String getSubtype() {
        return this.subtype;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        String accountId2 = getAccountId();
        int i11 = 43;
        int hashCode = accountId2 == null ? 43 : accountId2.hashCode();
        String type2 = getType();
        int hashCode2 = ((hashCode + 59) * 59) + (type2 == null ? 43 : type2.hashCode());
        String state2 = getState();
        int hashCode3 = (hashCode2 * 59) + (state2 == null ? 43 : state2.hashCode());
        String subtype2 = getSubtype();
        int hashCode4 = (hashCode3 * 59) + (subtype2 == null ? 43 : subtype2.hashCode());
        String risk2 = getRisk();
        int hashCode5 = (hashCode4 * 59) + (risk2 == null ? 43 : risk2.hashCode());
        List<C2CAccountOutNetAssetInfo> list2 = getList();
        int i12 = hashCode5 * 59;
        if (list2 != null) {
            i11 = list2.hashCode();
        }
        return i12 + i11;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setList(List<C2CAccountOutNetAssetInfo> list2) {
        this.list = list2;
    }

    public void setRisk(String str) {
        this.risk = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setSubtype(String str) {
        this.subtype = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "C2CAccountInNetAssetResult(accountId=" + getAccountId() + ", type=" + getType() + ", state=" + getState() + ", subtype=" + getSubtype() + ", risk=" + getRisk() + ", list=" + getList() + ")";
    }
}
